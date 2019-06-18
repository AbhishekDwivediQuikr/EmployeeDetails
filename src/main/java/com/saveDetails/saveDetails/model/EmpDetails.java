package com.saveDetails.saveDetails.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpDetails {
    @Id
    private int empid;
    private String Name;
    private String designation;
    private int salary;
    public EmpDetails()
    {

    }

    public EmpDetails(int empId, String name, String designation, int salary) {
        empid = empId;
        Name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empId) {
        this.empid = empId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpDetails{" +
                "EmpId=" + empid +
                ", Name='" + Name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
