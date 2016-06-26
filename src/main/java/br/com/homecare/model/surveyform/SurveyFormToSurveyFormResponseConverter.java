package br.com.homecare.model.surveyform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SurveyFormToSurveyFormResponseConverter implements Converter<SurveyForm, SurveyFormResponse> {

	@Override
	public SurveyFormResponse convert(SurveyForm surveyForm) {
		SurveyFormResponse surveyFormResponse = new SurveyFormResponse();

		List<SectionResponse> sectionsResponse = new ArrayList<SectionResponse>();

		surveyForm.getSections().forEach(section -> {

			SectionResponse sectionResponse = new SectionResponse();

			sectionResponse.setId(section.getId());
			sectionResponse.setName(section.getName());

			sectionResponse.setFields(createFieldsFrom(section.getFields()));

			sectionsResponse.add(sectionResponse);

		});

		surveyFormResponse.setSections(sectionsResponse);

		return surveyFormResponse;
	}

	private List<FieldResponse> createFieldsFrom(List<Field> fields) {
		List<FieldResponse> fieldsResponse = new ArrayList<FieldResponse>();

		fields.stream()
		.filter(field -> !field.getFields().isEmpty())
		.forEach(field -> {
			fieldsResponse.add(copyField(field));
		});

		return fieldsResponse;
	}

	private FieldResponse copyField(Field field) {
		FieldResponse fieldResponse = new FieldResponse();

		fieldResponse.setId(field.getId());
		fieldResponse.setLabel(field.getLabel());
		if (field.getOptions() != null) {
			fieldResponse.setOptions(breakInList(field.getOptions()));
		}

		fieldResponse.setType(field.getType());

		if (!field.getFields().isEmpty()) {
			List<FieldResponse> fieldsResponse = new ArrayList<>();

			field.getFields().forEach(parentField -> {
				fieldsResponse.add(copyField(parentField));
			});

			fieldResponse.setFields(fieldsResponse);
		}

		return fieldResponse;
	}

	private List<String> breakInList(String options) {
		String[] optionsArray = options.split(Pattern.quote("|"));
		return Arrays.asList(optionsArray);
	}

}
