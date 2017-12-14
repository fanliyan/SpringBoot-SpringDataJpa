package com.fanliyan.SpringData.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course implements Serializable{


    private static final long serialVersionUID = 1585275172093626817L;
    private String pid;
    private String courseName;
    private Set<Student> students;

    public Course() {
    }


    public Course(String pid, String courseName, Set<Student> students) {
        this.pid = pid;
        this.courseName = courseName;
        this.students = students;
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

    @Column(name = "course_name", unique = true, length = 64)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    //mappedBy :
    //          表示当前所在表和 Student 的关系是定义在 Student 里面的 course 这个成员上面的，
    //          他表示此表是一对一关系中的从表，也就是关系是在 Student 表中维护的，
    //          Student 表是关系的维护者，有主导权，它有个外键指向 course (Student 中的 getCourse() )
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "course")
    //NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    @NotFound(action = NotFoundAction.IGNORE)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
