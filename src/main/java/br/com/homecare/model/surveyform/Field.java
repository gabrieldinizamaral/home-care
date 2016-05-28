package br.com.homecare.model.surveyform;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.homecare.model.survey.Type;

@Entity
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	@Enumerated(EnumType.STRING)
	private Type type;

	private String options;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Section section;

	private Long previousId;

	private Long fieldFatherId;

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Long getPreviousId() {
		return previousId;
	}

	public void setPreviousId(Long previousId) {
		this.previousId = previousId;
	}

	public Long getFieldFatherId() {
		return fieldFatherId;
	}

	public void setFieldFatherId(Long fieldFatherId) {
		this.fieldFatherId = fieldFatherId;
	}

}
