package br.com.homecare.model.surveyform.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.homecare.model.surveyform.SurveyForm;

@Service
public interface SurveyFormRepository extends CrudRepository<SurveyForm, Long> {

	Optional<SurveyForm> findById(Long surveyFormId);

}
