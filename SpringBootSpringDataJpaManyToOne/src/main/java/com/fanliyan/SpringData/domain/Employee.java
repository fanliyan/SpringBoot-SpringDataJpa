package com.fanliyan.SpringData.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
public class Employee {

    private Integer employeeId;
    private String employeeName;
    private Company company;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @ManyToOne：多对一
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
