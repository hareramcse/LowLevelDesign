package com.sapient.factory;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sapeint.constant.VehicleParkingConstant;
import com.sapient.model.Car;
import com.sapient.model.Truck;
import com.sapient.model.Vehicle;
import com.sapient.vehicleType.VehicleType;

/**
 * A factory for creating Vehicle objects.
 *
 * @author Hareram
 */
public class VehicleFactory {

	/** The logger. */
	static Logger logger = Logger.getLogger(VehicleFactory.class);

	/**
	 * This method returns the vehicle object based on the vehicle type.
	 *
	 * @param vehicleType
	 *            the vehicle type
	 * @param vehicleNumber
	 *            the vehicle number
	 * @return vehicle object
	 */
	public static Vehicle getVehicleObject(String vehicleType, String vehicleNumber) {
		Vehicle vehicle = null;
		Element element = readVehicleTypeFromXML();
		String car = element.getElementsByTagName(VehicleParkingConstant.CAR).item(0).getTextContent();
		String truck = element.getElementsByTagName(VehicleParkingConstant.TRUCK).item(0).getTextContent();
		if (vehicleType.equalsIgnoreCase(car)) {
			vehicle = new Car(VehicleType.LIGHT, vehicleNumber);
		} else if (vehicleType.equalsIgnoreCase(truck)) {
			vehicle = new Truck(VehicleType.HEAVY, vehicleNumber);
		} else {
			logger.error(VehicleParkingConstant.VEHICLENOTVALIDEXCEPTIONMESSAGE);
		}
		return vehicle;
	}

	/**
	 * Read vehicle type from XML.
	 *
	 * @return the element
	 */
	private static Element readVehicleTypeFromXML() {
		File xmlFile = new File("src/main/resources/vehicleConfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		Element element = null;
		try {
			DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			NodeList nodeList = document.getElementsByTagName(VehicleParkingConstant.VEHICLE);
			element = (Element) nodeList.item(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
}