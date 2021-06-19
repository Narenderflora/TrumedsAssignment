package com.truemeds.truemeds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "narender_flora_java_output")
public class FinalOutput {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "output")
	private String output;
	@Column(name = "count")
	private int count;
	@Column(name = "name_date")
	private String nameDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNameDate() {
		return nameDate;
	}

	public void setNameDate(String nameDate) {
		this.nameDate = nameDate;
	}

}
