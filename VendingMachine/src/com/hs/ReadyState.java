package com.hs;

class ReadyState extends VendingMachineState {
	ReadyState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(Product product) {
		reject("Product already selected. Please make payment.");
	}

	@Override
	public void insertCoin(Coin coin) {
		vm.addCoin(coin);
		System.out.println("Coin inserted: " + coin);
		checkPayment();
	}

	@Override
	public void insertNote(Note note) {
		vm.addNote(note);
		System.out.println("Note inserted: " + note);
		checkPayment();
	}

	@Override
	public void dispenseProduct() {
		reject("Please make payment first.");
	}

	@Override
	public void returnChange() {
		reject("Please make payment first.");
	}

	private void checkPayment() {
		if (vm.getTotalPayment() >= vm.getSelectedProduct().getPrice()) {
			vm.setState(vm.getDispenseState());
		}
	}
}
