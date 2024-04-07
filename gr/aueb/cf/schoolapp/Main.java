package gr.aueb.cf.schoolapp;

import java.awt.EventQueue;

public class Main {

	private static Menu menu;
	private static TeachersSearchForm teachersSearchForm;
	private static TeachersInsertForm teachersInsertForm;
	private static TeachersUpdateDeleteForm teachersUpdateDeleteForm; 
	private static StudentsSearchForm studentsSearchForm;
	private static StudentsInsertForm studentsInsertForm;
	private static StudentsUpdateDeleteForm studentsUpdateDeleteForm;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu = new Menu();
					menu.setVisible(true);
					
					teachersSearchForm = new TeachersSearchForm();
					teachersSearchForm.setVisible(false);
					
					studentsSearchForm = new StudentsSearchForm();
					studentsSearchForm.setVisible(false);;
					
					teachersInsertForm = new TeachersInsertForm();
					teachersInsertForm.setVisible(false);
					
					studentsInsertForm = new StudentsInsertForm();
					studentsInsertForm.setVisible(false);
					
					teachersUpdateDeleteForm = new TeachersUpdateDeleteForm();
					teachersUpdateDeleteForm.setVisible(false);
					
					studentsUpdateDeleteForm = new StudentsUpdateDeleteForm();
					studentsUpdateDeleteForm.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Menu getMenu() {
		return menu;
	}

	public static TeachersSearchForm getTeachersSearchForm() {
		return teachersSearchForm;
	}

	public static TeachersInsertForm getTeachersInsertForm() {
		return teachersInsertForm;
	}

	public static TeachersUpdateDeleteForm getTeachersUpdateDeleteForm() {
		return teachersUpdateDeleteForm;
	}

	public static StudentsSearchForm getStudentsSearchForm() {
		return studentsSearchForm;
	}

	public static StudentsInsertForm getStudentsInsertForm() {
		return studentsInsertForm;
	}

	public static StudentsUpdateDeleteForm getStudentsUpdateDeleteForm() {
		return studentsUpdateDeleteForm;
	}
	
	
}