package com.hs;

class ReturnChangeState extends VendingMachineState {
	ReturnChangeState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(Product product) {
		reject("Please collect the change first.");
	}

	@Override
	public void insertCoin(Coin coin) {
		reject("Please collect the change first.");
	}

	@Override
	public void insertNote(Note note) {
		reject("Please collect the change first.");
	}

	@Override
	public void dispenseProduct() {
		reject("Product already dispensed. Please collect the change.");
	}

	@Override
	public void returnChange() {
		double change = vm.getTotalPayment() - vm.getSelectedProduct().getPrice();
		if (change > 0) {
			System.out.println("Change returned: $" + change);
		} else {
			System.out.println("No change to return.");
		}
		returnToIdle();
	}
}
