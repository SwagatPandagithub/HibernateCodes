package in.cg.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo {

	@EmbeddedId
	private ProgrammerProjectId id;
	private String pName;
	private Integer deptNo;
	private String projName;
	
	public ProgrammerProjectId getId() {
		return id;
	}
	public void setId(ProgrammerProjectId id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", pName=" + pName + ", deptNo=" + deptNo + ", projName=" + projName
				+ "]";
	}
	
	
	
}
