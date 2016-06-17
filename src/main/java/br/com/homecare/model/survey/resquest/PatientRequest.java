package br.com.homecare.model.survey.resquest;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.homecare.model.LocalDateCustomSerializer;
import br.com.homecare.model.patient.Gender;

public class PatientRequest {

	private String name;

	@JsonSerialize(using = LocalDateCustomSerializer.class)
	private LocalDate birth;

	private Gender gender;

	private String address;

	private String Registry;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistry() {
		return Registry;
	}

	public void setRegistry(String registry) {
		Registry = registry;
	}	

}
