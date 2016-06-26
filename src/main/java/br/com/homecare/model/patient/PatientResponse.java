package br.com.homecare.model.patient;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.homecare.model.LocalDateCustomSerializer;

public class PatientResponse {

	private Long id;

	private String name;

	@JsonSerialize(using = LocalDateCustomSerializer.class)
	private LocalDate birth;

	private String gender;

	private String address;

	private String registry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

}
