package br.com.homecare.model.survey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.patient.Patient;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String startAt;

	private String endAt;

	@ManyToOne
	private Carer carer;

	@ManyToOne
	private Patient patient;

}
