package com.sapient.vehicle.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sapeint.constant.VehicleParkingConstant;
import com.sapient.exception.VehicleNotValidException;
import com.sapient.exception.VehicleNumberNotValidException;
import com.sapient.factory.VehicleFactory;
import com.sapient.model.Slot;
import com.sapient.model.Token;
import com.sapient.model.Vehicle;
import com.sapient.payement.PaymentManagement;
import com.sapient.payement.impl.PaymentManagementImpl;
import com.sapient.slot.SlotManagement;
import com.sapient.slot.impl.SlotManagementImpl;
import com.sapient.vehicle.VehicleManagement;
import com.sapient.vehicleType.VehicleType;

/**
 * The Class VehicleManagementImpl.
 * 
 * @author Hareram
 */
public class VehicleManagementImpl implements VehicleManagement {

	/** The logger. */
	static Logger logger = Logger.getLogger(VehicleManagementImpl.class);

	/** The slot management. */
	private SlotManagement slotManagement;

	/** The payment management. */
	private PaymentManagement paymentManagement;

	/** The vehicles. */
	private Map<String, Vehicle> vehicles;

	/** The vehicle map. */
	private Map<String, Token> vehicleMap;

	/** The number of light vehicle parked. */
	private int numberOfLightVehicleEntered;

	/** The number of heavy vehicle parked. */
	private int numberOfHeavyVehicleEntered;

	/** The number of light vehicle exited. */
	private int numberOfLightVehicleExited;

	/** The number of heavy vehicle exited. */
	private int numberOfHeavyVehicleExited;

	/**
	 * Instantiates a new vehicle management impl.
	 */
	public VehicleManagementImpl() {
		vehicles = new HashMap<String, Vehicle>();
		vehicleMap = new HashMap<String, Token>();
		paymentManagement = new PaymentManagementImpl();
		slotManagement = new SlotManagementImpl();
		slotManagement.initSlot();
	}

	/**
	 * Enter vehicle.
	 *
	 * @param inputValues
	 *            the input values
	 * @param slotManagement
	 *            the slot management
	 * @param token
	 *            the token
	 * @param scanner
	 *            the scanner
	 */
	private void enterVehicle(String[] inputValues, SlotManagement slotManagement, Token token, Scanner scanner) {
		Token lightVehicleToken = null;
		Token heavyVehicleToken = null;
		if (inputValues[0].trim().equalsIgnoreCase(VehicleParkingConstant.ENTER)) {
			if (inputValues.length >= 2) {
				logger.info(VehicleParkingConstant.ENTERVEHICLENUMBER);
				String vehicleNumber = scanner.nextLine();
				if (inputValues[1].trim().equalsIgnoreCase(VehicleParkingConstant.CAR)) {
					try{
						Vehicle lightVehicle = VehicleFactory.getVehicleObject(inputValues[1].trim(), vehicleNumber);
						Slot[] lightVehicleSlot = slotManagement.checkAvailableSlot(lightVehicle);
						lightVehicleToken = token.generateTokenAndPark(lightVehicle, lightVehicleSlot);
						numberOfLightVehicleEntered++;
						lightVehicleToken.setVehicleType(VehicleType.LIGHT);
						vehicles.put(lightVehicle.getVehicleNumber(), lightVehicle);
						vehicleMap.put(lightVehicle.getVehicleNumber(), lightVehicleToken);
					}catch(Exception e){
						logger.error(e.getMessage());
					}
				} else if (inputValues[1].trim().equalsIgnoreCase(VehicleParkingConstant.TRUCK)) {
					try{
						Vehicle heavyVehicle = VehicleFactory.getVehicleObject(inputValues[1].trim(), vehicleNumber);
						Slot[] heavyVehicleSlot = slotManagement.checkAvailableSlot(heavyVehicle);
						heavyVehicleToken = token.generateTokenAndPark(heavyVehicle, heavyVehicleSlot);
						numberOfHeavyVehicleEntered++;
						heavyVehicleToken.setVehicleType(VehicleType.HEAVY);
						vehicles.put(heavyVehicle.getVehicleNumber(), heavyVehicle);
						vehicleMap.put(heavyVehicle.getVehicleNumber(), heavyVehicleToken);
					}catch(Exception e){
						logger.error(e.getMessage());
					}
				} else {
					try {
						throw new VehicleNotValidException(VehicleParkingConstant.VEHICLENOTVALIDEXCEPTIONMESSAGE);
					} catch (VehicleNotValidException e) {
						logger.error(e.getMessage());
					}
				}
			} else {
				try {
					throw new VehicleNotValidException(VehicleParkingConstant.VEHICLENOTVALIDEXCEPTIONMESSAGE);
				} catch (VehicleNotValidException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * Exit vehicle.
	 *
	 * @param inputValues
	 *            the input values
	 * @param slotManagement
	 *            the slot management
	 * @param paymentManagement
	 *            the payment management
	 * @param token
	 *            the token
	 * @param scanner
	 *            the scanner
	 */
	private void exitVehicle(String[] inputValues, SlotManagement slotManagement, PaymentManagement paymentManagement,
			Token token, Scanner scanner) {
		Vehicle vehicle = null;
		if (inputValues[0].trim().equalsIgnoreCase(VehicleParkingConstant.EXIT)) {
			if (inputValues.length >= 2) {
				logger.info(VehicleParkingConstant.ENTERVEHICLENUMBER);
				String vehicleNumber = scanner.nextLine();
				if (vehicleNumber != null && !vehicleNumber.trim().equals(VehicleParkingConstant.EMPTY)) {
					vehicle = vehicles.get(vehicleNumber);
					token = vehicleMap.get(vehicleNumber);
				} else {
					try {
						throw new VehicleNumberNotValidException(
								VehicleParkingConstant.VEHICLENUMBERISNOTVALIDEXCEPTIONMESSAGE);
					} catch (VehicleNumberNotValidException e) {
						logger.error(e.getMessage());
					}
				}
				if (vehicles.size() > 0 && vehicle != null && vehicle.getVehicleType().equals(VehicleType.LIGHT)) {
					if (inputValues.length >= 3) {
						try {
							paymentManagement.doPayment(token, inputValues[2].trim());
							exitLightVehicle(slotManagement, token);
						} catch (Exception e) {
							logger.error(e.getMessage());
						}
					} else {
						try {
							paymentManagement.doPayment(token, VehicleParkingConstant.EMPTY);
							exitLightVehicle(slotManagement, token);
						} catch (Exception e) {
							logger.error(e.getMessage());
						}
					}
				} else if (vehicles.size() > 0 && vehicle != null
						&& vehicle.getVehicleType().equals(VehicleType.HEAVY)) {
					if (inputValues.length >= 3) {
						try {
							paymentManagement.doPayment(token, inputValues[2].trim());
							exitHeavyVehicle(slotManagement, token);
						} catch (Exception e) {
							logger.error(e.getMessage());
						}
					} else {
						try {
							paymentManagement.doPayment(token, VehicleParkingConstant.EMPTY);
							exitHeavyVehicle(slotManagement, token);
						} catch (Exception e) {
							logger.error(e.getMessage());
						}
					}
				} else {
					try {
						throw new VehicleNumberNotValidException(
								VehicleParkingConstant.VEHICLENOTFOUNDEXCEPTIONMESSAGE);
					} catch (VehicleNumberNotValidException e) {
						logger.error(e.getMessage());
					}
				}
			} else {
				try {
					throw new VehicleNumberNotValidException(VehicleParkingConstant.VEHICLENOTVALIDEXCEPTIONMESSAGE);
				} catch (VehicleNumberNotValidException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * Exit lightvehilce.
	 *
	 * @param slotManagement
	 *            the slot management
	 * @param token
	 *            the token
	 */
	public void exitLightVehicle(SlotManagement slotManagement, Token token) {
		slotManagement.releaseSlot(token);
		vehicles.remove(token.getVehicleNumber());
		vehicleMap.remove(token.getVehicleNumber());
		slotManagement.getEmptySlot().add(token.getSlots()[0]);
		numberOfLightVehicleExited++;
	}

	/**
	 * Exit heavy vehicle.
	 *
	 * @param slotManagement
	 *            the slot management
	 * @param token
	 *            the token
	 */
	public void exitHeavyVehicle(SlotManagement slotManagement, Token token) {
		slotManagement.releaseSlot(token);
		vehicles.remove(token.getVehicleNumber());
		vehicleMap.remove(token.getVehicleNumber());
		slotManagement.getEmptySlot().add(token.getSlots()[0]);
		slotManagement.getEmptySlot().add(token.getSlots()[1]);
		numberOfHeavyVehicleExited++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sapient.vehicle.VehicleManagement#vehicleEntryAndExit(com.sapient.
	 * slot.SlotManagement, com.sapient.payement.PaymentManagement)
	 */
	public void vehicleEntryAndExit() {
		logger.info(VehicleParkingConstant.NUMBEROFPROGRAM);
		logger.info(VehicleParkingConstant.USER + slotManagement.findNumberOfAvailableSlot());
		Scanner scanner = new Scanner(System.in);
		String userInput = null;
		do {
			Token token = new Token();
			logger.info(VehicleParkingConstant.USER);
			userInput = scanner.nextLine();
			String[] inputValues = userInput.trim().split(VehicleParkingConstant.SPACE);
			enterVehicle(inputValues, slotManagement, token, scanner);

			if (inputValues[0].trim().equalsIgnoreCase(VehicleParkingConstant.REPORT)) {
				generateReport(slotManagement, paymentManagement);
			}
			exitVehicle(inputValues, slotManagement, paymentManagement, token, scanner);
			if (userInput.trim().equalsIgnoreCase(VehicleParkingConstant.QUIT)) {
				System.exit(0);
			}
		} while (true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sapient.vehicle.VehicleManagement#generateReport(java.lang.String,
	 * com.sapient.slot.SlotManagement, com.sapient.payement.PaymentManagement)
	 * 
	 * this method generates the reports for all the operation of parking
	 * management like
	 */
	public void generateReport(SlotManagement slotManagement, PaymentManagement paymentManagement) {
		logger.info("");
		logger.info(VehicleParkingConstant.PROGRAM);

		logger.info(VehicleParkingConstant.CARENTERED + numberOfLightVehicleEntered);
		logger.info(VehicleParkingConstant.TRUCKENTERED + numberOfHeavyVehicleEntered);
		logger.info(VehicleParkingConstant.CAREXITED + numberOfLightVehicleExited);
		logger.info(VehicleParkingConstant.TRUCKEXITED + numberOfHeavyVehicleExited);
		logger.info(VehicleParkingConstant.PARKINGCARS + (numberOfLightVehicleEntered - numberOfLightVehicleExited));
		logger.info(VehicleParkingConstant.PARKINGTRUCKS + (numberOfHeavyVehicleEntered - numberOfHeavyVehicleExited));

		logger.info(VehicleParkingConstant.SPACESAVAILABLE + slotManagement.findNumberOfAvailableSlot());
		logger.info(VehicleParkingConstant.FEESPAID + VehicleParkingConstant.CURRENCY
				+ paymentManagement.getTotalFeesPaid());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.vehicle.VehicleManagement#setVehicles(java.util.Map)
	 */
	public void setVehicles(Map<String, Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.vehicle.VehicleManagement#setVehicleMap(java.util.Map)
	 */
	public void setVehicleMap(Map<String, Token> vehicleMap) {
		this.vehicleMap = vehicleMap;
	}

	/**
	 * Gets the number of light vehicle exited.
	 *
	 * @return the number of light vehicle exited
	 */
	public int getNumberOfLightVehicleExited() {
		return numberOfLightVehicleExited;
	}

	/**
	 * Gets the number of heavy vehicle exited.
	 *
	 * @return the number of heavy vehicle exited
	 */
	public int getNumberOfHeavyVehicleExited() {
		return numberOfHeavyVehicleExited;
	}
}