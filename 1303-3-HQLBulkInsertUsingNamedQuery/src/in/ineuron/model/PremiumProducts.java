package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="HQL_TRANFER_QUERY",query = "INSERT INTO in.ineuron.model.PremiumProducts(prodId,prodName,prodPrice,prodQty) SELECT i.prodId,i.prodName,i.prodPrice,i.prodQty FROM in.ineuron.model.Product as i WHERE i.prodQty>=:minQty")
public class PremiumProducts implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer prodId;
	private String prodName;
	private String prodPrice;
	private Integer prodQty;
	
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Integer getProdQty() {
		return prodQty;
	}
	public void setProdQty(Integer prodQty) {
		this.prodQty = prodQty;
	}
	
	public PremiumProducts() {
		System.out.println("no arg constructor used by hibernate...");
	}
	
	
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQty="
				+ prodQty + "]";
	}
	
	

}
