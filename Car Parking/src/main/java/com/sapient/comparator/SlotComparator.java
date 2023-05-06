package com.sapient.comparator;

import java.util.Comparator;

import com.sapient.model.Slot;

/**
 * The Class SlotComparator.
 *
 * @author Hareram
 */
public class SlotComparator implements Comparator<Slot> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Slot slot1, Slot slot2) {

		if ((slot1.getxCoordiate() + slot1.getyCoordinate()) < (slot2.getxCoordiate() + slot2.getyCoordinate())) {
			return -1;
		}
		if ((slot1.getxCoordiate() + slot1.getyCoordinate()) > (slot2.getxCoordiate() + slot2.getyCoordinate())) {
			return 1;
		} else {
			return 0;
		}
	}
}
