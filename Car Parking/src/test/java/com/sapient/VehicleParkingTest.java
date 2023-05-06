package com.sapient;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sapeint.constant.VehicleParkingConstant;
import com.sapient.exception.PaymentExcepion;
import com.sapient.exception.SlotNotAvailableException;
import com.sapient.factory.VehicleFactory;
import com.sapient.model.Slot;
import com.sapient.model.Token;
import com.sapient.model.Vehicle;
import com.sapient.payement.PaymentManagement;
import com.sapient.payement.impl.PaymentManagementImpl;
import com.sapient.slot.SlotManagement;
import com.sapient.slot.impl.SlotManagementImpl;
import com.sapient.vehicle.VehicleManagement;
import com.sapient.vehicle.impl.VehicleManagementImpl;
import com.sapient.vehicleType.VehicleType;

/**
 * The Class VehicleParkingTest.
 * 
 * @author Hareram
 */
public class VehicleParkingTest {

	/** The vehicle parking. */
	private VehicleManagement vehicleManagement;

	/** The slot management. */
	private SlotManagement slotManagement;

	/** The payment management. */
	private PaymentManagement paymentManagement;

	/**
	 * Initialize the slot.
	 */
	@Before
	public void initSlot() {
		vehicleManagement = new VehicleManagementImpl();
		slotManagement = new SlotManagementImpl();
		paymentManagement = new PaymentManagementImpl();
		slotManagement.initSlot();
	}

	/**
	 * Slot availability test.
	 */

	@Test
	public void slotAvailabilityTest() {
		Vehicle lightVehicle = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG004");
		Slot[] lightVehicleSlot = slotManagement.checkAvailableSlot(lightVehicle);
		Token token = new Token();
		Token lightVehicleToken = token.generateTokenAndPark(lightVehicle, lightVehicleSlot);
		Assert.assertNotNull(lightVehicleToken);

		int noOfAvailabeSlot = slotManagement.findNumberOfAvailableSlot();
		Assert.assertEquals(8, noOfAvailabeSlot);

		Vehicle heavyVehicle = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG005");
		Slot[] heavyVehicleSlot = slotManagement.checkAvailableSlot(heavyVehicle);
		Token token1 = new Token();
		Token heavyVehicleToken = token1.generateTokenAndPark(heavyVehicle, heavyVehicleSlot);
		Assert.assertNotNull(heavyVehicleToken);

		noOfAvailabeSlot = slotManagement.findNumberOfAvailableSlot();
		Assert.assertEquals(6, noOfAvailabeSlot);
	}

	/**
	 * Release slot test.
	 */

	@Test
	public void releaseSlotTest() {
		Vehicle lightVehicle = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG004");
		Slot[] lightVehicleSlot = slotManagement.checkAvailableSlot(lightVehicle);
		Token token = new Token();
		Token lightVehicleToken = token.generateTokenAndPark(lightVehicle, lightVehicleSlot);
		Map<String, Token> tokenMap = new HashMap<String, Token>();
		Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();
		tokenMap.put(lightVehicle.getVehicleNumber(), lightVehicleToken);
		vehicleMap.put(lightVehicle.getVehicleNumber(), lightVehicle);
		vehicleManagement.setVehicleMap(tokenMap);
		vehicleManagement.setVehicles(vehicleMap);

		int noOfAvailabeSlot = slotManagement.findNumberOfAvailableSlot();
		Assert.assertEquals(8, noOfAvailabeSlot);

		slotManagement.releaseSlot(lightVehicleToken);
		Assert.assertNotNull(lightVehicleToken);

		noOfAvailabeSlot = slotManagement.findNumberOfAvailableSlot();
		Assert.assertEquals(9, noOfAvailabeSlot);
	}

	/**
	 * Do payment test.
	 */

	@Test
	public void doPayementTest() {
		Token token = new Token();
		Vehicle lightVehicle1 = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG004");
		Slot[] lightVehicleSlot1 = slotManagement.checkAvailableSlot(lightVehicle1);
		Token lightVehicleToken1 = token.generateTokenAndPark(lightVehicle1, lightVehicleSlot1);
		lightVehicleToken1.setVehicleType(VehicleType.LIGHT);

		Vehicle lightVehicle2 = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG005");
		Slot[] lightVehicleSlot2 = slotManagement.checkAvailableSlot(lightVehicle2);
		Token lightVehicleToken2 = token.generateTokenAndPark(lightVehicle1, lightVehicleSlot2);
		lightVehicleToken2.setVehicleType(VehicleType.LIGHT);

		Vehicle heavyVehicle1 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG006");
		Slot[] heavyVehicleSlot1 = slotManagement.checkAvailableSlot(heavyVehicle1);
		Token heavyVehicleToken1 = token.generateTokenAndPark(heavyVehicle1, heavyVehicleSlot1);
		heavyVehicleToken1.setVehicleType(VehicleType.HEAVY);

		Vehicle heavyVehicle2 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG006");
		Slot[] heavyVehicleSlot2 = slotManagement.checkAvailableSlot(heavyVehicle2);
		Token heavyVehicleToken2 = token.generateTokenAndPark(heavyVehicle2, heavyVehicleSlot2);
		heavyVehicleToken2.setVehicleType(VehicleType.HEAVY);

		try {
			paymentManagement.doPayment(lightVehicleToken1, "2");
			slotManagement.releaseSlot(lightVehicleToken1);
		} catch (PaymentExcepion e) {
			e.printStackTrace();
		}

		try {
			paymentManagement.doPayment(lightVehicleToken2, "");
			slotManagement.releaseSlot(lightVehicleToken2);
		} catch (PaymentExcepion e) {
			e.printStackTrace();
		}

		try {
			paymentManagement.doPayment(heavyVehicleToken1, "3");
			slotManagement.releaseSlot(heavyVehicleToken1);
		} catch (PaymentExcepion e) {
			e.printStackTrace();
		}

		try {
			paymentManagement.doPayment(heavyVehicleToken2, "");
			slotManagement.releaseSlot(heavyVehicleToken2);
		} catch (PaymentExcepion e) {
			e.printStackTrace();
		}

		int totalFeesPaid = (int) paymentManagement.getTotalFeesPaid();
		Assert.assertEquals("$18", VehicleParkingConstant.CURRENCY + totalFeesPaid);
	}

	/**
	 * Payment exception test.
	 */

	@Test
	public void paymentExceptionTest() {
		Token token = new Token();
		Vehicle heavyVehicle1 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG006");
		Slot[] heavyVehicleSlot1 = slotManagement.checkAvailableSlot(heavyVehicle1);
		Token heavyVehicleToken1 = token.generateTokenAndPark(heavyVehicle1, heavyVehicleSlot1);
		heavyVehicleToken1.setVehicleType(VehicleType.HEAVY);
		try {
			paymentManagement.doPayment(heavyVehicleToken1, "abc");
			Assert.fail();
		} catch (PaymentExcepion e) {
			e.getMessage();
		}
		slotManagement.releaseSlot(heavyVehicleToken1);
	}

	/**
	 * Slot not available test.
	 */
	@Test
	public void slotNotAvailabeTest() {
		Token token = new Token();
		Map<String, Token> tokenMap = new HashMap<String, Token>();
		Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

		Vehicle heavyVehicle1 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG001");
		Slot[] heavyVehicleSlot1 = slotManagement.checkAvailableSlot(heavyVehicle1);
		Token heavyVehicleToken1 = token.generateTokenAndPark(heavyVehicle1, heavyVehicleSlot1);

		tokenMap.put(heavyVehicle1.getVehicleNumber(), heavyVehicleToken1);
		vehicleMap.put(heavyVehicle1.getVehicleNumber(), heavyVehicle1);
		vehicleManagement.setVehicleMap(tokenMap);
		vehicleManagement.setVehicles(vehicleMap);

		Vehicle heavyVehicle2 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG002");
		Slot[] heavyVehicleSlot2 = slotManagement.checkAvailableSlot(heavyVehicle2);
		Token heavyVehicleToken2 = token.generateTokenAndPark(heavyVehicle2, heavyVehicleSlot2);
		tokenMap.put(heavyVehicle2.getVehicleNumber(), heavyVehicleToken2);
		vehicleMap.put(heavyVehicle2.getVehicleNumber(), heavyVehicle2);
		vehicleManagement.setVehicleMap(tokenMap);
		vehicleManagement.setVehicles(vehicleMap);

		Vehicle heavyVehicle3 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG003");
		Slot[] heavyVehicleSlot3 = slotManagement.checkAvailableSlot(heavyVehicle3);
		Token heavyVehicleToken3 = token.generateTokenAndPark(heavyVehicle3, heavyVehicleSlot3);
		tokenMap.put(heavyVehicle3.getVehicleNumber(), heavyVehicleToken3);
		vehicleMap.put(heavyVehicle3.getVehicleNumber(), heavyVehicle3);
		vehicleManagement.setVehicleMap(tokenMap);
		vehicleManagement.setVehicles(vehicleMap);

		Vehicle heavyVehicle4 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG004");
		Slot[] heavyVehicleSlot4 = slotManagement.checkAvailableSlot(heavyVehicle4);
		Token heavyVehicleToken4 = token.generateTokenAndPark(heavyVehicle4, heavyVehicleSlot4);
		tokenMap.put(heavyVehicle4.getVehicleNumber(), heavyVehicleToken4);
		vehicleMap.put(heavyVehicle4.getVehicleNumber(), heavyVehicle4);
		vehicleManagement.setVehicleMap(tokenMap);
		vehicleManagement.setVehicles(vehicleMap);

		Assert.assertEquals(heavyVehicleToken2.getVehicleNumber(), "KA05HG002");

		Queue<Slot> availableSlot = slotManagement.getEmptySlot();
		Assert.assertEquals(1, availableSlot.size());

		// this entry of truck will make the program to throw the exception
		// SlotNotAvailableException as only one slot are available
		Vehicle heavyVehicle5 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG005");
		try {
			Slot[] heavyVehicleSlot5 = slotManagement.checkAvailableSlot(heavyVehicle5);
			Assert.fail();
		} catch (SlotNotAvailableException e) {
			e.getMessage();
		}

		// this entry will be, as there is one slot available
		Vehicle lightVehicle7 = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG006");
		Slot[] lightVehicleSlot7 = slotManagement.checkAvailableSlot(lightVehicle7);
		Assert.assertNotNull(lightVehicleSlot7);
		Assert.assertEquals(0, availableSlot.size());

		// this entry of truck will make the program to throw the exception
		// SlotNotAvailableException as all slots are full now
		Vehicle heavyVehicle6 = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA05HG07");
		try {
			Slot[] heavyVehicleSlot6 = slotManagement.checkAvailableSlot(heavyVehicle6);
			Assert.fail();
		} catch (SlotNotAvailableException e) {
			e.getMessage();
		}

		// this entry of truck will make the program to throw the exception
		// SlotNotAvailableException as all slots are full now
		Vehicle lightVehicle8 = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA05HG08");
		try {
			Slot[] lightVehicleSlot8 = slotManagement.checkAvailableSlot(lightVehicle8);
			Assert.fail();
		} catch (SlotNotAvailableException e) {
			e.getMessage();
		}
	}

	/**
	 * Generate report test.
	 */
	@Test
	public void generateReportTest() {
		SlotManagement slotManagement = new SlotManagementImpl();
		PaymentManagement paymentManagement = new PaymentManagementImpl();
		slotManagement.initSlot();
		vehicleManagement.generateReport(slotManagement, paymentManagement);
		Assert.assertEquals(9, slotManagement.findNumberOfAvailableSlot());
	}

	/**
	 * Exit light vehicle test.
	 */

	@Test
	public void exitLightVehicleTest() {
		VehicleManagementImpl vImpl = new VehicleManagementImpl();
		Token token = new Token();
		Vehicle lightVehicle = VehicleFactory.getVehicleObject(VehicleParkingConstant.CAR, "KA01");
		Slot[] lightVehicleSlot = slotManagement.checkAvailableSlot(lightVehicle);
		Token lightVehicleToken = token.generateTokenAndPark(lightVehicle, lightVehicleSlot);
		vImpl.exitLightVehicle(slotManagement, lightVehicleToken);
		Assert.assertEquals(1, vImpl.getNumberOfLightVehicleExited());
	}

	/**
	 * Exit heavy vehicle test.
	 */

	@Test
	public void exitHeavyVehicleTest() {
		VehicleManagementImpl vImpl = new VehicleManagementImpl();
		Token token = new Token();
		Vehicle heavyVehicle = VehicleFactory.getVehicleObject(VehicleParkingConstant.TRUCK, "KA02");
		Slot[] heavyVehicleSlot = slotManagement.checkAvailableSlot(heavyVehicle);
		Token heavyVehicleToken = token.generateTokenAndPark(heavyVehicle, heavyVehicleSlot);
		vImpl.exitHeavyVehicle(slotManagement, heavyVehicleToken);
		Assert.assertEquals(1, vImpl.getNumberOfHeavyVehicleExited());
	}
}