package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="bankAccount1503")
@SQLDelete(sql = "UPDATE bankAccount1503 SET status = 'closed' where accNo=?")
@Where(clause="STATUS not in('Blocked','Closed')")
public class BankAccount implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer accNo;
	private String accHolderName;
	private Float balance;
	private String status;
	
	
	
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	static {
		System.out.println("Loading of the Bank Account Entity class");
	}
	public BankAccount() {
		System.out.println("No arg constructor is called by hibernate");
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accHolderName=" + accHolderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
	
	
	
}
