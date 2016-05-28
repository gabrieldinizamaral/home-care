package br.com.homecare.model.surveyform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class SectionsToSactionsTOConverter {

	public Collection<SectionTO> convert(Collection<Section> sections) {
		List<SectionTO> sectionsTO = new ArrayList();
		
		sections.forEach(section -> {
			
			SectionTO sectionTO = new SectionTO();
			
			sectionTO.setId(section.getId());
			sectionTO.setName(section.getName());
			
			sectionTO.setFields(createFieldsFrom(section.getFields()));
	
			sectionsTO.add(sectionTO);
			
		});
		
		return sectionsTO;
	}

	private List<FieldTO> createFieldsFrom(List<Field> fields) {
		List<FieldTO> fieldsTO = new ArrayList();

		fields.forEach(field -> {
			
			FieldTO fieldTO = new FieldTO();
			
			fieldTO.setId(field.getId());
			fieldTO.setLabel(field.getLabel());
			fieldTO.setOptions(breakInList(field.getOptions()));
			
			fieldsTO.add(fieldTO);
			
		});

		return fieldsTO;
	}

	private List<String> breakInList(String options) {
		String[] optionsArray = options.split(Pattern.quote("|"));
		return Arrays.asList(optionsArray);
	}

}
