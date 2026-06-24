package com.hs;

import java.util.UUID;

public class VendingMachine {
	private final Inventory inventory = new Inventory();
	private final CashInventory cashInventory = new CashInventory();
	private final VendingMachineState idleState;
	private final VendingMachineState readyState;
	private final VendingMachineState dispenseState;
	private final VendingMachineState returnChangeState;
	private VendingMachineState currentState;
	private VendTransaction currentTransaction;

	public VendingMachine() {
		idleState = new IdleState(this);
		readyState = new ReadyState(this);
		dispenseState = new DispenseState(this);
		returnChangeState = new ReturnChangeState(this);
		currentState = idleState;
	}

	public Inventory inventory() {
		return inventory;
	}

	public CashInventory cashInventory() {
		return cashInventory;
	}

	public synchronized void selectProduct(String productCode) {
		currentState.selectProduct(productCode);
	}

	public synchronized void insertCoin(Coin coin) {
		currentState.insertCoin(coin);
	}

	public synchronized void insertNote(Note note) {
		currentState.insertNote(note);
	}

	public synchronized void dispenseProduct() {
		currentState.dispenseProduct();
	}

	public synchronized void returnChange() {
		currentState.returnChange();
	}

	public synchronized void cancel() {
		currentState.cancel();
	}

	void setState(VendingMachineState state) {
		currentState = state;
	}

	VendingMachineState getIdleState() {
		return idleState;
	}

	VendingMachineState getReadyState() {
		return readyState;
	}

	VendingMachineState getDispenseState() {
		return dispenseState;
	}

	VendingMachineState getReturnChangeState() {
		return returnChangeState;
	}

	VendTransaction getCurrentTransaction() {
		return currentTransaction;
	}

	void startTransaction(Product product) {
		currentTransaction = new VendTransaction(UUID.randomUUID().toString(), product);
	}

	void clearTransaction() {
		currentTransaction = null;
	}

	void addPayment(Coin coin) {
		currentTransaction.addPayment(coin.getValue());
		cashInventory.accept(coin);
	}

	void addPayment(Note note) {
		currentTransaction.addPayment(note.getValue());
	}

	double getTotalPayment() {
		return currentTransaction == null ? 0 : currentTransaction.amountPaid();
	}

	Product getSelectedProduct() {
		return currentTransaction == null ? null : currentTransaction.product();
	}

	protected void returnToIdle() {
		if (currentTransaction != null) {
			currentTransaction.complete();
		}
		clearTransaction();
		setState(getIdleState());
	}
}
