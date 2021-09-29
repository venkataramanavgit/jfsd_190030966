package jfsds6.jfsd6;



import javax.persistence.*;

@Entity
@Table
public class bean 
{
  @Id
  private int id;
  
  private String ename;
  private String dept;
  private double salary;
  private int age;
public int getEid() {
	return id;
}
public void setEid(int eid) {
	this.id = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "bean [eid=" + id + ", ename=" + ename + ", dept=" + dept + ", salary=" + salary + ", age=" + age + "]";
}
 

}