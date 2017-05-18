package ua.training.task4.main;

import java.util.ArrayList;

import ua.training.task4.controller.Controller;
import ua.training.task4.model.Criteria;
import ua.training.task4.model.University;
import ua.training.task4.view.View;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<University> universities = new ArrayList<>();
		universities.add(new University("Cambridge", Criteria.ONLY_BIOLOGY));
		universities.add(new University("KPI", Criteria.RANDOM));
		universities.add(new University("Oxford", Criteria.ONLY_MATH));
		
		View view = new View();

		Controller controller = new Controller(universities, view);
		controller.processUser();

	}
}
