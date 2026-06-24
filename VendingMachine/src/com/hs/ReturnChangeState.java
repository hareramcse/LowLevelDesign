package com.hs;

import java.util.Map;

class ReturnChangeState extends VendingMachineState {
	ReturnChangeState(VendingMachine vm) {
		super(vm);
	}

	@Override
	public void returnChange() {
		VendTransaction txn = vm.getCurrentTransaction();
		double change = txn.changeDue();
		if (change <= 0) {
			System.out.println("Exact payment. No change.");
			vm.returnToIdle();
			return;
		}
		ChangeMaker.makeChange(change, vm.cashInventory()).ifPresentOrElse(coins -> {
			vm.cashInventory().deduct(coins);
			System.out.println("Change returned: $" + change + " as " + formatCoins(coins));
			vm.returnToIdle();
		}, () -> reject("Unable to return change. Contact operator."));
	}

	private String formatCoins(Map<Coin, Integer> coins) {
		StringBuilder sb = new StringBuilder();
		coins.forEach((coin, qty) -> sb.append(qty).append("x").append(coin).append(" "));
		return sb.toString().trim();
	}
}
