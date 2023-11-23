package in.ineuron.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;


@Entity
@Table(name="Employee_CollectionMapping")
public class Employee implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer eId;
	private String empName;
	private String empAddr;
	
	
	@ElementCollection  //inorder to work and map with collection
	@Column(name="friend_name")
	@CollectionTable(name="EMP_FRIENDS", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	@OrderColumn(name="friend_no")//as it is a index based collection, the list index is named
	@ListIndexBase(value = 1) //to start the index from 1
	private List<String> friendList;
	
	
	@ElementCollection
	@Column(name="mobile_no")
	@CollectionTable(name="EMP_FRIENDS", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	private Set<Long> phones;  // as set is not a index based collection we dont use any of the ordercolumns

	@ElementCollection
	@Column(name="account_number")
	@CollectionTable(name="Emp_accounts",joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eId"))
	@MapKeyColumn(name="bankName",length = 10)
	private Map<String, Long> bankAccounts;

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public List<String> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}

	public Set<Long> getPhones() {
		return phones;
	}

	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", empName=" + empName + ", empAddr=" + empAddr + ", friendList=" + friendList
				+ ", phones=" + phones + ", bankAccounts=" + bankAccounts + "]";
	}
	
	
	
	

	
	
}
