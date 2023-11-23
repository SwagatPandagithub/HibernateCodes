package in.cg.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="STUDENT_Table")
@DynamicInsert(value = true)//when you want some customization in the gregenerated queries.
public class Student {
	
	
	/*
		1.	@GenericGenerator(name="gen1", strategy ="increment")
			@GeneratedValue(generator ="gen1")
			
		2.	@GenericGenerator(name="gen1", strategy ="sequence")
			@GeneratedValue(generator ="gen1")
			
		3.	@GenericGenerator(name="gen1", strategy ="identity")
			@GeneratedValue(generator ="gen1")	
	 
	 */
	
	
	@Id
	@Column(name="studId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	
	@Column(name="studName")
	private String sName;
	
	@Column(name="studAge")
	private Integer sAge;
	
	@Column(name="studAddress")
	private String sAddress;
	
	
	
	
	
	public Student() {
		super();
		
		System.out.println("Zero parameterised constructor is called ......");
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer sId, String sName, Integer sAge, String sAddress) {
		super();
		System.out.println("parameterised constructor is called .by the hibernate internally.....");
		this.sId = sId;
		this.sName = sName;
		this.sAge = sAge;
		this.sAddress = sAddress;
	}
	
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsAge() {
		return sAge;
	}
	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sAge=" + sAge + ", sAddress=" + sAddress + "]";
	}

}
