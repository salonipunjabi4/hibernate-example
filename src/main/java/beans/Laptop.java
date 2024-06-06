package beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Laptop3")
public class Laptop {
	//Bi-directional Mapping
	
	
	//child class ( in terms of database not object)
	//has a relationship
	@Id
	private int lid;
	private String lname;
	
	@OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rollNo")
	private Student student;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int lid, String lname, Student student) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.student = student;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
