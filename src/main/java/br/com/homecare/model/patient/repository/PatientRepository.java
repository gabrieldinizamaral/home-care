package br.com.homecare.model.patient.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.homecare.model.patient.Patient;

@Service
public interface PatientRepository extends CrudRepository<Patient, Long> {

	Optional<Patient> findById(Long patientId);

}
