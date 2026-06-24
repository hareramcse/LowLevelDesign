package com.hs;

class IdleState extends VendingMachineState {
	IdleState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(String productCode) {
		vm.inventory().findByCode(productCode).ifPresentOrElse(product -> {
			if (!vm.inventory().isAvailable(product)) {
				reject("Out of stock: " + product.name());
				return;
			}
			vm.startTransaction(product);
			vm.setState(vm.getReadyState());
			System.out.println("Selected: " + product.name() + " ($" + product.price() + ")");
		}, () -> reject("Unknown product code: " + productCode));
	}

	@Override
	public void insertCoin(Coin coin) {
		reject("Please select a product first.");
	}

	@Override
	public void insertNote(Note note) {
		reject("Please select a product first.");
	}
}
