package ua.training.task4.controller;

import java.util.Random;

import ua.training.task4.model.Document;
import ua.training.task4.model.Faculty;
import ua.training.task4.view.View;

public class Controller {

	private View view;

	public Controller(View view) {
		this.view = view;
	}

	public void process() {

	}

	public Document createRandomDocument() {
		char[] arr = new char[8];
		Random r = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ('A' + r.nextInt(15));
		}

		String id = String.copyValueOf(arr);
		Faculty faculty = Faculty.values()[r.nextInt(2)];

		return new Document(id, faculty);
	}

}
