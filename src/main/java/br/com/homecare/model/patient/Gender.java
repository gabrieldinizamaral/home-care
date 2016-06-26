package br.com.homecare.model.patient;

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
		if (gender == "feminino") {
			return FEMALE;
		}
		return MALE;
	}

}
