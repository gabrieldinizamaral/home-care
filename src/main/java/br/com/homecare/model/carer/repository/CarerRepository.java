package br.com.homecare.model.carer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.homecare.model.carer.Carer;

@Service
public interface CarerRepository extends CrudRepository<Carer, Long> {

	Optional<Carer> findById(Integer carerId);

}
