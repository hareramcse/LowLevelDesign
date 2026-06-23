package com.hs;

class IdleState extends VendingMachineState {
	IdleState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(Product product) {
		if (!vm.inventory.isAvailable(product)) {
			reject("Product not available: " + product.getName());
			return;
		}
		vm.setSelectedProduct(product);
		vm.setState(vm.getReadyState());
		System.out.println("Product selected: " + product.getName());
	}

	@Override
	public void insertCoin(Coin coin) {
		reject("Please select a product first.");
	}

	@Override
	public void insertNote(Note note) {
		reject("Please select a product first.");
	}

	@Override
	public void dispenseProduct() {
		reject("Please select a product and make payment.");
	}

	@Override
	public void returnChange() {
		reject("No change to return.");
	}
}
