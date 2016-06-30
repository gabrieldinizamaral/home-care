package br.com.homecare.model.surveyform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.homecare.model.survey.Type;

public class SurveyFormToSurveyFormResponseConverterTest {

	private SurveyFormToSurveyFormResponseConverter converter;

	@Test
	public void shouldConvert() {
		converter = new SurveyFormToSurveyFormResponseConverter();

		SurveyForm surveyForm = createSurveyForm();
		SurveyFormResponse surveyFormResponse = converter.convert(surveyForm);

		List<Section> sections = surveyForm.getSections();
		List<SectionResponse> sectionsResponse = surveyFormResponse.getSections();

		assertTrue(sectionsResponse.size() == 2);

		Section section1 = sections.get(0);
		SectionResponse sectionResponse1 = sectionsResponse.get(0);
		assertEquals(section1.getId(), sectionResponse1.getId());
		assertEquals(section1.getName(), sectionResponse1.getName());
		assertTrue(sectionResponse1.getFields().size() == 4);

		assertFieldsSection1(sectionResponse1.getFields());

		Section section2 = sections.get(1);
		SectionResponse sectionResponse2 = sectionsResponse.get(1);
		assertEquals(section2.getId(), sectionResponse2.getId());
		assertEquals(section2.getName(), sectionResponse2.getName());
		assertTrue(sectionResponse2.getFields().size() == 2);

		assertFieldsSection2(sectionResponse2.getFields());
	}

	private void assertFieldsSection1(List<FieldResponse> fields) {
		FieldResponse fieldResponse1 = fields.get(0);
		assertEquals(new Long(1), fieldResponse1.getId());

		FieldResponse fieldResponse2 = fields.get(1);
		assertEquals(new Long(2), fieldResponse2.getId());

		FieldResponse fieldResponse3 = fields.get(2);
		assertEquals(new Long(3), fieldResponse3.getId());

		FieldResponse fieldResponse4 = fields.get(3);
		assertEquals(new Long(4), fieldResponse4.getId());
	}

	private void assertFieldsSection2(List<FieldResponse> fields) {
		FieldResponse fieldResponse8 = fields.get(0);
		assertEquals(new Long(8), fieldResponse8.getId());
		assertEquals(Type.MULTIPLE_FIELD, fieldResponse8.getType());
		assertTrue(fieldResponse8.getFields().size() == 2);

		FieldResponse fieldResponse6 = fieldResponse8.getFields().get(0);
		assertEquals(new Long(6), fieldResponse6.getId());
		assertEquals(Type.MULTIPLE_FIELD, fieldResponse6.getType());
		assertTrue(fieldResponse6.getFields().size() == 1);

		FieldResponse fieldResponse5 = fieldResponse6.getFields().get(0);
		assertEquals(new Long(5), fieldResponse5.getId());

		FieldResponse fieldResponse7 = fieldResponse8.getFields().get(1);
		assertEquals(new Long(7), fieldResponse7.getId());

		FieldResponse fieldResponse9 = fields.get(1);
		assertEquals(new Long(9), fieldResponse9.getId());
	}

	private SurveyForm createSurveyForm() {
		SurveyForm surveyForm = new SurveyForm();

		surveyForm.setId(1L);
		surveyForm.setName("Survey Home Care");
		List<Section> sections = new ArrayList<>();

		sections.add(createSection1());
		sections.add(createSection2());

		surveyForm.setSections(sections);
		surveyForm.setId(1L);

		return surveyForm;
	}

	private Section createSection1() {
		Section section = new Section();

		section.setName("Section 1");

		List<Field> fields = new ArrayList<>();

		Field field1 = new Field();
		field1.setSection(section);
		field1.setLabel("Field 1");
		field1.setOptions("Options Field1");
		field1.setType(Type.BOOLEAN);
		field1.setId(1L);
		fields.add(field1);

		Field field2 = new Field();
		field2.setSection(section);
		field2.setLabel("Field 2");
		field2.setOptions("Options Field2");
		field2.setType(Type.DATETIME);
		field2.setId(2L);
		fields.add(field2);

		Field field3 = new Field();
		field3.setSection(section);
		field3.setLabel("Field 3");
		field3.setOptions("Options Field3");
		field3.setType(Type.LARGE_TEXT);
		field3.setId(3L);
		fields.add(field3);

		Field field4 = new Field();
		field4.setSection(section);
		ArrayList<Field> fields2 = new ArrayList<Field>();
		fields2.add(field3);
		field4.setFields(fields2);
		field4.setLabel("Field 4");
		field4.setOptions("Options Field4");
		field4.setType(Type.LARGE_TEXT);
		field4.setId(4L);
		fields.add(field4);

		section.setFields(fields);

		section.setId(1L);

		return section;
	}

	private Section createSection2() {
		Section section = new Section();

		section.setName("Section 2");

		List<Field> fields = new ArrayList<>();

		Field field5 = new Field();
		field5.setSection(section);
		field5.setLabel("Field 5");
		field5.setOptions("Options Field5");
		field5.setType(Type.BOOLEAN);
		field5.setId(5L);
		fields.add(field5);

		Field field6 = new Field();
		ArrayList<Field> fields2 = new ArrayList<Field>();
		fields2.add(field5);
		field6.setFields(fields2);
		field6.setSection(section);
		field6.setLabel("Field 6");
		field6.setOptions("Options Field6");
		field6.setType(Type.MULTIPLE_FIELD);
		field6.setId(6L);
		fields.add(field6);

		Field field7 = new Field();
		field7.setSection(section);
		field7.setLabel("Field 7");
		field7.setOptions("Options Field7");
		field7.setType(Type.LARGE_TEXT);
		field7.setId(7L);
		fields.add(field7);

		Field field8 = new Field();
		ArrayList<Field> fields3 = new ArrayList<Field>();
		fields3.add(field6);
		fields3.add(field7);
		field8.setFields(fields3);
		field8.setSection(section);
		field8.setLabel("Field 8");
		field8.setOptions("Options Field8");
		field8.setType(Type.MULTIPLE_FIELD);
		field8.setId(8L);
		fields.add(field8);

		Field field9 = new Field();
		field9.setSection(section);
		field9.setLabel("Field 9");
		field9.setOptions("Options Field9");
		field9.setType(Type.LARGE_TEXT);
		field9.setId(9L);
		fields.add(field9);

		section.setFields(fields);

		section.setId(1L);

		return section;
	}

}
