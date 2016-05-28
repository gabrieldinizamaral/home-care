package br.com.homecare.model.carer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.carer.repository.CarerRepository;

@RestController
public class CarerController {

	@Autowired
	private CarerRepository carerRepository;

	@RequestMapping(path = "carers", method = RequestMethod.POST)
	public @ResponseBody Carer save(@RequestBody @Valid Carer carer) {
		return carerRepository.save(carer);
	}

}
