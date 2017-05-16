package ua.training.task4.model;

public class Document {
	private String id;
	private Faculty faculty;

	public Document(String id, Faculty faculty) {
		this.id = id;
		this.faculty = faculty;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public String getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return id + " : " + faculty;
	}
}
