package br.com.homecare.model.survey.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.survey.Survey;

@Service
public interface SurveyRepository extends CrudRepository<Survey, Long> {

	Collection<Survey> findByCarer(Carer carer);

	Survey findByPatient(Patient patient);

}
