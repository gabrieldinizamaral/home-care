package br.com.homecare.model.patient;

import java.util.EnumSet;

public enum Gender {

	FEMALE("feminino"),
	MALE("masculino");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Gender fromValue(String gender) {
		return EnumSet.of(FEMALE, MALE).stream()
		.filter(genderEnum -> genderEnum.getValue().equals(gender)).findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Gender [" + gender + "] is not valid"));
	}

}
