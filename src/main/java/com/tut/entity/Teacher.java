package com.tut.entity;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private String qualification;
    private String remarks;
    private String address;
    private float salary;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", qualification='" + qualification + '\'' +
            ", remarks='" + remarks + '\'' +
            ", address='" + address + '\'' +
            ", salary=" + salary +
            '}';
  }
}
