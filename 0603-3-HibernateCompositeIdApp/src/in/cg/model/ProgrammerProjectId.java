package in.cg.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class ProgrammerProjectId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer pId;	
	private Integer projId;
	
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjectId [pId=" + pId + ", projId=" + projId + "]";
	}
	
	

}
