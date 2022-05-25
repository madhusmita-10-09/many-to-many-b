package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("madhusmita");
		student1.setAge(21);

		Student student2 = new Student();
		student2.setName("smita");
		student2.setAge(22);

		Student student3 = new Student();
		student3.setName("madhu");
		student3.setAge(23);

		Course course1 = new Course();
		course1.setName("java");
		course1.setDuration(2);

		Course course2 = new Course();
		course2.setName("html");
		course2.setDuration(1);

		Course course3 = new Course();
		course3.setName("css");
		course3.setDuration(2);

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);

		student1.setCourse(courses);
		student2.setCourse(courses);
		student3.setCourse(courses);

		course1.setStudent(students);
		course2.setStudent(students);
		course3.setStudent(students);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);

		entityTransaction.commit();

	}

}
