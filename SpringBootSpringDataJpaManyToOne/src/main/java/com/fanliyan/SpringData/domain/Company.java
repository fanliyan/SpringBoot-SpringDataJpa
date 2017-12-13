package com.fanliyan.SpringData.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_company")
public class Company {

    private Integer companyId;
    private String companyName;
    private Set<Employee> employees;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @OneToMany 一对多
     * mappedBy,参考了Employee,与 OneToOne相似
     */
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
