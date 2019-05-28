package com.senebii.api.cart;

public class BillingResponse {
	private double total;
	private double discount;
	private double netPayableAmount;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNetPayableAmount() {
		return netPayableAmount;
	}
	public void setNetPayableAmount(double netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}
	
}
