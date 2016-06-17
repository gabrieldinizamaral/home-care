package br.com.homecare.model.surveyform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.homecare.model.survey.Type;

public class FieldResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String label;

	private Type type;

	private List<String> options = new ArrayList<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

}
