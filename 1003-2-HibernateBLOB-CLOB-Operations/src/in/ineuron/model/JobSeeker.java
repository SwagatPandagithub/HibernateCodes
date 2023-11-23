package in.ineuron.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;


@Entity
public class JobSeeker implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer Id;
	private String name;
	private String age;
	
	
	@Lob
	private byte[] photo;
	
	@Lob
	private char[] resume;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "JobSeeker [Id=" + Id + ", name=" + name + ", age=" + age + ", photo=" + Arrays.toString(photo)
				+ ", resume=" + Arrays.toString(resume) + "]";
	}

}
