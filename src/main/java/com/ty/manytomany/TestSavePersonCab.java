package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person1 = new Person();
		person1.setName("rashmi");
		person1.setAge(23);

		Person person2 = new Person();
		person2.setName("soumya");
		person2.setAge(23);

		Person person3 = new Person();
		person3.setName("madhu");
		person3.setAge(21);

		Cab cab1 = new Cab();
		cab1.setDrivername("nitish");
		cab1.setCost(500);

		Cab cab2 = new Cab();
		cab2.setDrivername("sandeep");
		cab2.setCost(300);

		Cab cab3 = new Cab();
		cab3.setDrivername("niraj");
		cab3.setCost(400);

		List<Cab> cabs = new ArrayList<Cab>();
		cabs.add(cab1);
		cabs.add(cab2);
		cabs.add(cab3);

		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);

		person1.setCab(cabs);
		person2.setCab(cabs);
		person3.setCab(cabs);

		cab1.setPerson(persons);
		cab2.setPerson(persons);
		cab3.setPerson(persons);

		entityTransaction.begin();
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityManager.persist(cab3);

		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();

	}

}
