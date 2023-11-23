package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class BankAccount implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accNo;

	private String accName;
	private String accType;
	
	private Double accBalance;
	public String getAccName() {
		return accName;
	}
	public Long getAccNo() {
		return accNo;
	}

	public String getAccType() {
		return accType;
	}

	public Double getAccBalance() {
		return accBalance;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public Integer getCount() {
		return count;
	}

	
	@CreationTimestamp
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@Version
	private Integer count;

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setAccBalance(Double accBalance) {
		this.accBalance = accBalance;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", accType=" + accType + ", accBalance="
				+ accBalance + ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + ", count=" + count
				+ "]";
	}
	
	
	
	

}
