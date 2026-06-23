package com.hs;

class DispenseState extends VendingMachineState {
	DispenseState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(Product product) {
		reject("Product already selected. Please collect the dispensed product.");
	}

	@Override
	public void insertCoin(Coin coin) {
		reject("Payment already made. Please collect the dispensed product.");
	}

	@Override
	public void insertNote(Note note) {
		reject("Payment already made. Please collect the dispensed product.");
	}

	@Override
	public void dispenseProduct() {
		Product product = vm.getSelectedProduct();
		vm.inventory.updateQuantity(product, vm.inventory.getQuantity(product) - 1);
		System.out.println("Product dispensed: " + product.getName());
		vm.setState(vm.getReturnChangeState());
	}

	@Override
	public void returnChange() {
		reject("Please collect the dispensed product first.");
	}
}
