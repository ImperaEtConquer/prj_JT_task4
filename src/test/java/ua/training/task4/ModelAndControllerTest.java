package ua.training.task4;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;
import ua.training.task4.controller.Controller;
import ua.training.task4.model.Criteria;
import ua.training.task4.model.Document;
import ua.training.task4.model.Faculty;
import ua.training.task4.model.University;
import ua.training.task4.view.GlobalConstants;
import ua.training.task4.view.View;

public class ModelAndControllerTest {

	@Test
	public void testDocumentsTotalAmount() throws InterruptedException {

		ArrayList<University> universities = new ArrayList<>();
		universities.add(new University("Cambridge", Criteria.ONLY_BIOLOGY));
		universities.add(new University("KPI", Criteria.RANDOM));
		universities.add(new University("Oxford", Criteria.ONLY_MATH));

		View view = new View();

		Controller controller = new Controller(universities, view);
		controller.processUser();

		Thread.sleep(6000);

		int documentsTotalAmount = 0;

		for (University uni : universities) {
			documentsTotalAmount += uni.getDocuments().size();
		}

		int actualResult = documentsTotalAmount;
		int expectedResult = GlobalConstants.BIOLOGY_AMOUNT + GlobalConstants.MATH_AMOUNT;

		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testIfAllFacultiesCorrect() throws InterruptedException {

		ArrayList<University> universities = new ArrayList<>();
		universities.add(new University("Cambridge", Criteria.ONLY_BIOLOGY));
		universities.add(new University("KPI", Criteria.RANDOM));
		universities.add(new University("Oxford", Criteria.ONLY_MATH));

		View view = new View();

		Controller controller = new Controller(universities, view);
		controller.processUser();

		Thread.sleep(6000);
		
		Assert.assertTrue(isAllFacultiesTheSame(universities.get(0), Faculty.BIOLOGY));
		Assert.assertTrue(isAllFacultiesTheSame(universities.get(2), Faculty.MATH));

	}

	private boolean isAllFacultiesTheSame(University uni, Faculty fac) {
		for (Document doc : uni.getDocuments()) {
			if (!doc.getFaculty().equals(fac)) {
				return false;
			}
		}
		return true;
	}
}
