package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "CHEQUE")
public class ChequePayments extends Payments implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String chequeNo;
	private String chequeType;
	private LocalDate expiryDate;
	
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate localDate) {
		this.expiryDate = localDate;
	}
	@Override
	public String toString() {
		return "ChequePayments [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	

}
