package br.com.homecare.model.surveyform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String label;
	
	private List<String> options = new ArrayList();

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

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
	
}
