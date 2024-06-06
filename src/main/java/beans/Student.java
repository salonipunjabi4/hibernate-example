package beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student3")
public class Student {
	
	//parent class
	//rno primary key
	@Id
	private int rollNo;
	private String studName;
	private int marks;
	
	@OneToOne(targetEntity = Laptop.class, cascade = CascadeType.ALL)
	private Laptop laptop;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(int rollNo, String studName, int marks, Laptop laptop) {
		super();
		this.rollNo = rollNo;
		this.studName = studName;
		this.marks = marks;
		this.laptop = laptop;
	}

	

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", studName=" + studName + ", marks=" + marks + "]";
	}
	
	

}
