package com.ty.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String drivername;
	private double cost;
	@ManyToMany
	@JoinTable(name = "my_cab_person", joinColumns = @JoinColumn(name = "my_cab_id"), inverseJoinColumns = @JoinColumn(name = "my_person_id"))
	List<Person> person;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the drivername
	 */
	public String getDrivername() {
		return drivername;
	}

	/**
	 * @param drivername
	 *            the drivername to set
	 */
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the person
	 */
	public List<Person> getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(List<Person> person) {
		this.person = person;
	}

}
