package br.com.homecare.model.surveyform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class SectionsToSactionsResponseConverter {

	public Collection<SectionResponse> convert(Collection<Section> sections) {
		List<SectionResponse> sectionsResponse = new ArrayList<SectionResponse>();
		
		sections.forEach(section -> {
			
			SectionResponse sectionResponse = new SectionResponse();
			
			sectionResponse.setId(section.getId());
			sectionResponse.setName(section.getName());
			
			sectionResponse.setFields(createFieldsFrom(section.getFields()));
	
			sectionsResponse.add(sectionResponse);
			
		});
		
		return sectionsResponse;
	}

	private List<FieldResponse> createFieldsFrom(List<Field> fields) {
		List<FieldResponse> fieldsResponse = new ArrayList<FieldResponse>();

		fields.forEach(field -> {
			
			FieldResponse fieldResponse = new FieldResponse();
			
			fieldResponse.setId(field.getId());
			fieldResponse.setLabel(field.getLabel());
			fieldResponse.setOptions(breakInList(field.getOptions()));
			fieldResponse.setType(field.getType());
			
			fieldsResponse.add(fieldResponse);
			
		});

		return fieldsResponse;
	}

	private List<String> breakInList(String options) {
		String[] optionsArray = options.split(Pattern.quote("|"));
		return Arrays.asList(optionsArray);
	}

}
