package com.hs;

public class VendingMachine {
	private static VendingMachine instance;
	protected Inventory inventory;
	private final VendingMachineState idleState;
	private final VendingMachineState readyState;
	private final VendingMachineState dispenseState;
	private final VendingMachineState returnChangeState;
	private VendingMachineState currentState;
	private Product selectedProduct;
	private double totalPayment;

	private VendingMachine() {
		inventory = new Inventory();
		idleState = new IdleState(this);
		readyState = new ReadyState(this);
		dispenseState = new DispenseState(this);
		returnChangeState = new ReturnChangeState(this);
		currentState = idleState;
		selectedProduct = null;
		totalPayment = 0.0;
	}

	public static synchronized VendingMachine getInstance() {
		if (instance == null) {
			instance = new VendingMachine();
		}
		return instance;
	}

	public void selectProduct(Product product) {
		currentState.selectProduct(product);
	}

	public void insertCoin(Coin coin) {
		currentState.insertCoin(coin);
	}

	public void insertNote(Note note) {
		currentState.insertNote(note);
	}

	public void dispenseProduct() {
		currentState.dispenseProduct();
	}

	public void returnChange() {
		currentState.returnChange();
	}

	public void setState(VendingMachineState state) {
		currentState = state;
	}

	public VendingMachineState getIdleState() {
		return idleState;
	}

	public VendingMachineState getReadyState() {
		return readyState;
	}

	public VendingMachineState getDispenseState() {
		return dispenseState;
	}

	public VendingMachineState getReturnChangeState() {
		return returnChangeState;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product product) {
		selectedProduct = product;
	}

	public void resetSelectedProduct() {
		selectedProduct = null;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void addCoin(Coin coin) {
		totalPayment += coin.getValue();
	}

	public void addNote(Note note) {
		totalPayment += note.getValue();
	}

	public void resetPayment() {
		totalPayment = 0.0;
	}
}