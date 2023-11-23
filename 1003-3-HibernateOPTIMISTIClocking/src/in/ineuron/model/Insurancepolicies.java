package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


@Entity
public class Insurancepolicies implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer policyId;
	private String policyName;
	private Integer policyTenure;
	
	@Version
	private Integer count;
	
	

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Integer getPolicyTenure() {
		return policyTenure;
	}

	public void setPolicyTenure(Integer policyTenure) {
		this.policyTenure = policyTenure;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Insurancepolicies [policyId=" + policyId + ", policyName=" + policyName + ", policyTenure="
				+ policyTenure + ", count=" + count + "]";
	}

	
	
	
}
