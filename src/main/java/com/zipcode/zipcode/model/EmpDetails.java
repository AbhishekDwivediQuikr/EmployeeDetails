package com.zipcode.zipcode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class EmpDetails {
    @Id
    @NotNull
    private int empid;
    private String Name;
    private String designation;
    private int salary;
    public EmpDetails()
    {

    }

    public EmpDetails(int empid, String name, String designation, int salary) {
        this.empid = empid;
        this.Name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return this.Name;
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
                "Empid=" + this.empid +
                ", Name='" + this.Name + '\'' +
                ", designation='" + this.designation + '\'' +
                ", salary=" + this.salary +
                '}';
    }
}
