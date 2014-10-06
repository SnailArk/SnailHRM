package com.snailark.snailhrm.model;

public enum AddressType {
	COMMUNICATION("Communication"), PERMANENT("Permanent");
	
	private String addressType;

	private AddressType(String addressType) {
		this.addressType = addressType;
	}
	
	public String getAddressType() {
		return addressType;
	}
}