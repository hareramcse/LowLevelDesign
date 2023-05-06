package com.sapient.slot.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import com.sapeint.constant.VehicleParkingConstant;
import com.sapient.comparator.SlotComparator;
import com.sapient.exception.SlotNotAvailableException;
import com.sapient.model.Slot;
import com.sapient.model.Token;
import com.sapient.model.Vehicle;
import com.sapient.slot.SlotManagement;
import com.sapient.vehicleType.VehicleType;

/**
 * The Class SlotManagement.
 * 
 * @author Hareram
 */
public class SlotManagementImpl implements SlotManagement {

	/** The slot. */
	private Slot[][] slot;

	/** The empty slot. */
	private Queue<Slot> emptySlot;

	/**
	 * Instantiates a new slot management.
	 */
	public SlotManagementImpl() {
		slot = new Slot[VehicleParkingConstant.MATRIXSIZE][VehicleParkingConstant.MATRIXSIZE];
		emptySlot = new PriorityBlockingQueue<Slot>(VehicleParkingConstant.NUMBEROFINITIALSLOT, new SlotComparator());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.slot.SlotManagement#initSlot()
	 */
	public void initSlot() {
		for (int i = 0; i < slot.length; i++) {
			for (int j = 0; j < slot[i].length; j++) {
				slot[i][j] = new Slot(i, j);
				emptySlot.add(slot[i][j]);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.slot.SlotManagement#findNumberOfAvailableSlot()
	 */
	public int findNumberOfAvailableSlot() {
		int count = 0;
		for (int i = 0; i < slot.length; i++) {
			for (int j = 0; j < slot[i].length; j++) {
				if (slot[i][j] != null && !slot[i][j].isSlotOccupied()) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Check both side of slot, it is required for heavy vehicle parking.
	 *
	 * @param slot1
	 *            the slot 1
	 * @param slot2
	 *            the slot 2
	 * @return true, if successful
	 */
	private boolean checkBothSideOfSlot(Slot slot1, Slot slot2) {
		int xAxis[] = { 0, -1, 0, 1 };
		int yAxis[] = { -1, 0, 1, 0 };

		for (int i = 0; i < xAxis.length; i++) {
			if (slot1 != null && slot2 != null) {
				if ((slot1.getxCoordiate() + xAxis[i] >= 3) || (slot1.getxCoordiate() + xAxis[i] <= -1)
						|| (slot1.getyCoordinate() + yAxis[i] >= 3) || (slot1.getyCoordinate() + yAxis[i] <= -1)) {
					continue;
				}
				if ((slot1.getxCoordiate() + xAxis[i] == slot2.getxCoordiate())
						&& (slot1.getyCoordinate() + yAxis[i] == slot2.getyCoordinate())) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sapient.slot.SlotManagement#checkAvailableSlot(com.sapient.vehicle.
	 * Vehicle)
	 */
	public Slot[] checkAvailableSlot(Vehicle vehicle) {
		int slotReq = VehicleParkingConstant.INITIALSLOTREQUIRED;

		if (vehicle.getVehicleType() == VehicleType.LIGHT) {
			slotReq = VehicleParkingConstant.SLOTREQUIREDFORLIGHTVEHICLE;
		} else if (vehicle.getVehicleType() == VehicleType.HEAVY) {
			slotReq = VehicleParkingConstant.SLOTREQUIREDFORHEAVYVEHICLE;
		}
		Slot firstSlot = emptySlot.poll();
		Slot[] slotArr = new Slot[slotReq];
		if (slotReq == VehicleParkingConstant.SLOTREQUIREDFORLIGHTVEHICLE) {
			if (firstSlot != null) {
				slotArr[0] = firstSlot;
			} else {
				throw new SlotNotAvailableException(VehicleParkingConstant.PARKINGFULL);
			}
		} else if (slotReq == VehicleParkingConstant.SLOTREQUIREDFORHEAVYVEHICLE) {
			checkAvailableSlotForHeavyVehicle(vehicle, firstSlot, slotArr);
		}
		return slotArr;
	}

	/**
	 * Check available slot for heavy vehicle.
	 *
	 * @param vehicle
	 *            the vehicle
	 * @param firstSlot
	 *            the first slot
	 * @param slotArr
	 *            the slot arr
	 */
	private void checkAvailableSlotForHeavyVehicle(Vehicle vehicle, Slot firstSlot, Slot[] slotArr) {
		Queue<Slot> unUsedSecondSlot = new LinkedList<Slot>();
		Queue<Slot> unUsedSlot = new LinkedList<Slot>();
		while (true) {
			if (firstSlot != null) {
				slotArr[0] = firstSlot;
			} else {
				throw new SlotNotAvailableException(VehicleParkingConstant.PARKINGFULL);
			}
			Slot secondSlot = emptySlot.poll();
			if (secondSlot != null) {
				if (checkBothSideOfSlot(firstSlot, secondSlot)) {
					slotArr[1] = secondSlot;
					if (!unUsedSecondSlot.isEmpty()) {
						emptySlot.addAll(unUsedSecondSlot);
					}
					if (!unUsedSlot.isEmpty()) {
						emptySlot.addAll(unUsedSlot);
					}
					break;
				} else {
					unUsedSecondSlot.add(secondSlot);
				}
			} else {
				if (emptySlot.isEmpty()) {
					unUsedSlot.add(firstSlot);
					if (!unUsedSecondSlot.isEmpty())
						emptySlot.addAll(unUsedSecondSlot);
					firstSlot = emptySlot.poll();
				} else {
					unUsedSecondSlot.add(secondSlot);
				}
			}
			if (slotArr[0] != null && secondSlot == null) {
				emptySlot.add(slotArr[0]);
				throw new SlotNotAvailableException(VehicleParkingConstant.PARKINGFULL);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.slot.SlotManagement#releaseSlot(com.sapient.model.Token)
	 */
	public void releaseSlot(Token token) {
		Slot[] slot = token.getSlots();
		for (int i = 0; i < slot.length; i++) {
			slot[i].setSlotOccupied(false);
			slot[i].setVehicleNumber(VehicleParkingConstant.EMPTY);
			slot[i].setVehicleInTime(null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.slot.SlotManagement#getEmptySlot()
	 */
	public Queue<Slot> getEmptySlot() {
		return emptySlot;
	}
}