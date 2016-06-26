package br.com.homecare.model.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientsToPatientsResponseConverter implements Converter<List<Patient>, List<PatientResponse>> {

	@Override
	public List<PatientResponse> convert(List<Patient> patients) {
		List<PatientResponse> patientsResponse = new ArrayList<PatientResponse>();

		patients.forEach(patient -> {
			PatientResponse patientResponse = new PatientResponse();

			patientResponse.setId(patient.getId());
			patientResponse.setName(patient.getName());
			patientResponse.setAddress(patient.getAddress());
			patientResponse.setBirth(patient.getBirth());
			patientResponse.setRegistry(patient.getRegistry());
			patientResponse.setGender(patient.getGender().getValue());

			patientsResponse.add(patientResponse);
		});

		return patientsResponse;
	}
}
