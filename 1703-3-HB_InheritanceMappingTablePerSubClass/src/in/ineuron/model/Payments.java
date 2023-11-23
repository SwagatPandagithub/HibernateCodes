package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payments implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer pId;
	private Integer amount;
	
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Payments [pId=" + pId + ", amount=" + amount + "]";
	}
	
	
	
	

}
