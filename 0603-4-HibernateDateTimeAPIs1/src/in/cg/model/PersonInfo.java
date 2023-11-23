package in.cg.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PersonInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer pId;
	private String pName;
	private LocalDate doj;
	private LocalDateTime dob;
	private LocalTime dom;
	
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalTime getDom() {
		return dom;
	}
	public void setDom(LocalTime dom) {
		this.dom = dom;
	}
	
	
	@Override
	public String toString() {
		return "PersonInfo [pId=" + pId + ", pName=" + pName + ", doj=" + doj + ", dob=" + dob + ", dom=" + dom + "]";
	}
	
	
	
	

}
