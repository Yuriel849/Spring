package com.leopard.mvc;

public class SearchType {
	private String label;
	private String value;

	// constructor
	public SearchType(String label, String value) {
		this.label = label;
		this.value = value;
	}

	// getters & setters
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}