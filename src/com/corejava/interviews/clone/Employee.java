package com.corejava.interviews.clone;

public class Employee implements Cloneable{
	 
    private int empoyeeId;
    private String employeeName;
    private Department department;
 
    public Employee(int id, String name, Department dept)
    {
        this.setEmpoyeeId(id);
        this.setEmployeeName(name);
        this.setDepartment(dept);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	public int getEmpoyeeId() {
		return empoyeeId;
	}
	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
     
    //Getters and Setters
}