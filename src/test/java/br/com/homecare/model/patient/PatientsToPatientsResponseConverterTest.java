package br.com.homecare.model.patient;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.homecare.model.patient.Gender;
import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.patient.PatientResponse;
import br.com.homecare.model.patient.PatientsToPatientsResponseConverter;

public class PatientsToPatientsResponseConverterTest {

	private PatientsToPatientsResponseConverter converter;

	@Test
	public void shouldConvert() {
		converter = new PatientsToPatientsResponseConverter();
		List<Patient> patients = createPatients();

		List<PatientResponse> patientsResponse = converter.convert(patients);

		Patient male = patients.get(0);
		PatientResponse maleResponse = patientsResponse.get(0);
		assertEquals(male.getAddress(), maleResponse.getAddress());
		assertEquals(male.getBirth(), maleResponse.getBirth());
		assertEquals(male.getGender().getValue(), maleResponse.getGender());
		assertEquals(male.getName(), maleResponse.getName());
		assertEquals(male.getRegistry(), maleResponse.getRegistry());

		Patient female = patients.get(1);
		PatientResponse femaleResponse = patientsResponse.get(1);
		assertEquals(female.getAddress(), femaleResponse.getAddress());
		assertEquals(female.getBirth(), femaleResponse.getBirth());
		assertEquals(female.getGender().getValue(), femaleResponse.getGender());
		assertEquals(female.getName(), femaleResponse.getName());
		assertEquals(female.getRegistry(), femaleResponse.getRegistry());

	}

	private List<Patient> createPatients() {
		List<Patient> patients = new ArrayList<Patient>();

		Patient male = new Patient();
		male.setBirth(LocalDate.of(2016, 8, 13));
		male.setAddress("Rua Augusta, 123 - São Paulo - SP");
		male.setGender(Gender.MALE);
		male.setName("Fulano de Tal");
		male.setRegistry("AD124G");

		patients.add(male);

		Patient female = new Patient();
		female.setBirth(LocalDate.of(2016, 7, 8));
		female.setAddress("Av. Paulista, 456 - São Paulo - SP");
		female.setGender(Gender.FEMALE);
		female.setName("Ciclana da Silva");
		female.setRegistry("ADN092");

		patients.add(female);

		return patients;
	}

}
