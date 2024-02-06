package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Maya Cruz - Gcruz
 * CIS175 - Spring 2024
 * Feb 5, 2024
 */

@Entity
@Table(name="items")
public class ListPet {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TYPE")
	private String type;
	@Column(name="NAME")
	private String name;
	@Column(name="Age")
	private int age;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 */
	public ListPet() {
		super();
	}
	/**
	 * @param type
	 * @param name
	 * @param age
	 */
	
	public ListPet(String type, String name, int age) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
	}
	
	//Method to return pet details
	public String returnPetDetails() {
		return "Pet type:" + this.type + "|| Pet name:" +  this.name + "|| Pet age:" + this.age; 
	}

}
