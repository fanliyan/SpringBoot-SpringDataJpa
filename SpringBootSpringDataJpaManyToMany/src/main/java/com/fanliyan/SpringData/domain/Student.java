package com.fanliyan.SpringData.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable{

    private static final long serialVersionUID = -3543000916477257732L;
    private String pid;
    private String studentName;
    private Set<Course> course;

    public Student(){

    }

    public Student(String pid, String studentName, Set<Course> course) {
        this.pid = pid;
        this.studentName = studentName;
        this.course = course;
    }

    @Id
    @Column(name = "pid", unique = true, nullable = false, length = 32)
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Column(name = "student_name", unique = true, length = 64)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Hibernate 会自动创建一张关系表stu_cou， 里边有俩字段stu_id和cou_id分别为两表主键
     *
     * @return
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stu_cou", joinColumns = {@JoinColumn(name = "stu_id")}, inverseJoinColumns = {@JoinColumn(name = "cou_id")})
    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }
}
