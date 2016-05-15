package homecare.survey.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import homecare.carer.Carer;
import homecare.survey.Survey;

@Service
public interface SurveyRepository extends CrudRepository<Survey, Long> {

	Collection<Survey> findByCarer(Carer carer);

}
