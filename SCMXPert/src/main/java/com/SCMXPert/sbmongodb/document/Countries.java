package com.SCMXPert.sbmongodb.document;

import java.util.List;

public class Countries {

	private List<States> States;
	private String CountryName;

	public void setStates(List<States> states) {
		States = states;
	}

	public List<States> getStates() {
		return States;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public String getCountryName() {
		return CountryName;
	}

}
