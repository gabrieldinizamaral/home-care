package br.com.homecare.model.surveyform;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

public class SurveyFormResponse {

	private List<SectionResponse> sections;

	@JsonValue
	public List<SectionResponse> getSections() {
		return sections;
	}

	public void setSections(List<SectionResponse> sections) {
		this.sections = sections;
	}

}
