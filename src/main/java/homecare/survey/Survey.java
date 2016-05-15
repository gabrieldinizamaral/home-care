package homecare.survey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import homecare.carer.Carer;
import homecare.patient.Patient;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String start;

	private String end;

	@ManyToOne
	private Carer carer;

	@ManyToOne
	private Patient patient;

}
