package com.sapient.payement.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sapeint.constant.VehicleParkingConstant;
import com.sapient.exception.PaymentExcepion;
import com.sapient.model.Token;
import com.sapient.payement.PaymentManagement;
import com.sapient.vehicleType.VehicleType;

/**
 * The Class PaymentManagement.
 * 
 * @author Hareram
 */
public class PaymentManagementImpl implements PaymentManagement {

	/** The total fees paid. */
	private double totalFeesPaid;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sapient.payement.PaymentManagement#doPayment(com.sapient.model.Token,
	 * java.lang.String)
	 */
	public void doPayment(Token token, String hours) throws PaymentExcepion {
		Timestamp vehicleOutTime = new Timestamp(System.currentTimeMillis());
		long timeDiff = vehicleOutTime.getTime() - token.getVehicleInTime().getTime();
		File xmlFile = new File(VehicleParkingConstant.CONFIGFILEPATH);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		double amount = 0;
		try {
			DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			NodeList nodeList = document.getElementsByTagName(VehicleParkingConstant.VEHICLE);
			Element element = (Element) nodeList.item(0);
			Double carRate = Double
					.parseDouble(element.getElementsByTagName(VehicleParkingConstant.CARRATE).item(0).getTextContent());
			Double truckRate = Double.parseDouble(
					element.getElementsByTagName(VehicleParkingConstant.TRUCKRATE).item(0).getTextContent());

			if (hours != VehicleParkingConstant.EMPTY && hours != null) {
				int hour = 0;
				hour = Integer.parseInt(hours);
				if (token.getVehicleType() != null && token.getVehicleType().equals(VehicleType.LIGHT)) {
					amount = hour * carRate * (token.getSlots().length);
				} else if (token.getVehicleType() != null && token.getVehicleType().equals(VehicleType.HEAVY)) {
					amount = hour * truckRate * (token.getSlots().length);
				}
			} else {
				if (token.getVehicleType() != null && token.getVehicleType().equals(VehicleType.LIGHT)) {
					amount = (TimeUnit.MILLISECONDS.toHours(timeDiff) + 1) * carRate * (token.getSlots().length);
				} else if (token.getVehicleType() != null && token.getVehicleType().equals(VehicleType.HEAVY)) {
					amount = (TimeUnit.MILLISECONDS.toHours(timeDiff) + 1) * truckRate * (token.getSlots().length);
				}
			}
			totalFeesPaid = totalFeesPaid + amount;
		} catch (Exception e) {
			throw new PaymentExcepion(VehicleParkingConstant.PAYMENTEXCEPTION);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.payement.PaymentManagement#getTotalFeesPaid()
	 */
	public double getTotalFeesPaid() {
		return totalFeesPaid;
	}
}