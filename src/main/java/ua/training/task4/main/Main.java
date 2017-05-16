package ua.training.task4.main;

import ua.training.task4.controller.Controller;
import ua.training.task4.view.View;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller(new View());
		for (int i = 0; i < 25; i++) {
			System.out.println(controller.createRandomDocument());
		}
	}
}
