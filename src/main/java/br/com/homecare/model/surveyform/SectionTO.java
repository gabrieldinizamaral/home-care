package br.com.homecare.model.surveyform;

import java.io.Serializable;
import java.util.List;

public class SectionTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String name;

	private List<FieldTO> fields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldTO> getFields() {
		return fields;
	}

	public void setFields(List<FieldTO> fields) {
		this.fields = fields;
	}


}
