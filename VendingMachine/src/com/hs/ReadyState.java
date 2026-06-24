package com.hs;

class ReadyState extends VendingMachineState {
	ReadyState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void selectProduct(String productCode) {
		reject("Product already selected. Pay, cancel, or complete purchase.");
	}

	@Override
	public void insertCoin(Coin coin) {
		vm.addPayment(coin);
		System.out.println("Inserted: " + coin + " | total=$" + vm.getTotalPayment());
		checkPayment();
	}

	@Override
	public void insertNote(Note note) {
		vm.addPayment(note);
		System.out.println("Inserted: " + note + " | total=$" + vm.getTotalPayment());
		checkPayment();
	}

	@Override
	public void cancel() {
		System.out.println("Cancelled. Refunding $" + vm.getTotalPayment());
		vm.getCurrentTransaction().cancel();
		vm.clearTransaction();
		vm.setState(vm.getIdleState());
	}

	private void checkPayment() {
		VendTransaction txn = vm.getCurrentTransaction();
		double price = txn.product().price();
		if (vm.getTotalPayment() < price) {
			System.out.println("Need $" + (price - vm.getTotalPayment()) + " more.");
			return;
		}
		double change = txn.changeDue();
		if (change > 0 && ChangeMaker.makeChange(change, vm.cashInventory()).isEmpty()) {
			reject("Cannot make change $" + change + ". Use exact amount or smaller payment.");
			return;
		}
		txn.markPaid();
		vm.setState(vm.getDispenseState());
		System.out.println("Payment complete. Dispense product.");
	}
}
