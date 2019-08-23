package org.zhoup.springboot.pojo;

import javax.persistence.*;
import java.io.Serializable;

//使用jpa注解映射关系
@Entity //告诉Jpa这是一个实体类，与数据库表映射
@Table(name="student")
public class Student{
    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY) //自增主键
    private int sno;    //学号111
    @Column
    private String sname;   //姓名
    @Column
    private int sage;   //年龄
    @Column
    private String saddress;    //地址
    public Student(int sno,String sname, int sage, String saddress) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public Student(String sname, int sage, String saddress) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }
    public Student() {

    }

    public Student(int sno) {
        this.sno = sno;
    }



    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }



}
