package com.hs;

public abstract class VendingMachineState {
	protected final VendingMachine vm;

	protected VendingMachineState(VendingMachine vm) {
		this.vm = vm;
	}

	protected void returnToIdle() {
		vm.resetPayment();
		vm.resetSelectedProduct();
		vm.setState(vm.getIdleState());
	}

	protected void reject(String message) {
		System.out.println(message);
	}

	public void selectProduct(Product product) {
		reject("Invalid action in current state.");
	}

	public void insertCoin(Coin coin) {
		reject("Invalid action in current state.");
	}

	public void insertNote(Note note) {
		reject("Invalid action in current state.");
	}

	public void dispenseProduct() {
		reject("Invalid action in current state.");
	}

	public void returnChange() {
		reject("Invalid action in current state.");
	}
}
