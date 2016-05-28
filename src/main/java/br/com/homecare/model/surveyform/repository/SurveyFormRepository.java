package br.com.homecare.model.surveyform.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.homecare.model.surveyform.Section;

@Service
public interface SurveyFormRepository extends CrudRepository<Section, Long> {

	public Collection<Section> findAllByOrderByIdAsc();

}
