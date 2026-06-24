package com.hs;

class DispenseState extends VendingMachineState {
	DispenseState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void dispenseProduct() {
		Product product = vm.getSelectedProduct();
		vm.inventory().decrement(product);
		System.out.println("Dispensed: " + product.name());
		vm.setState(vm.getReturnChangeState());
	}

	@Override
	public void cancel() {
		reject("Payment collected. Dispense product or contact support.");
	}
}
