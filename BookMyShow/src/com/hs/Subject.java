package com.hs;

public interface Subject {
	void registerObserver(Observer observer);
	void notifyObservers(String message);
}
