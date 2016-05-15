package homecare.patient;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;

	private String birth;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String address;

}
