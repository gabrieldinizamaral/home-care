package br.com.homecare.model.surveyform;

import java.util.List;

public class SurveyFormResponse {

	private List<SectionResponse> sections;

	public List<SectionResponse> getSections() {
		return sections;
	}

	public void setSections(List<SectionResponse> sections) {
		this.sections = sections;
	}

}
