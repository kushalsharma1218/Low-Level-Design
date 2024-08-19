package org.example.creational.prototypeandresgistry.impl;

public class Student {
    private String name;
    private String age;
    private Double studentPercentage;
    private String batch;
    private Double avgBatchPercentage;


    public Student(){}


    // copy constructor
    public Student(Student student) {
        this.batch = student.batch;
        this.age = student.age;
        this.studentPercentage = student.studentPercentage;
        this.avgBatchPercentage = student.avgBatchPercentage;
        this.name = student.name;

    }


    // step 2: create a clone method
    // copy all common attributes only
    public Student clone(){
        return new Student(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(Double studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Double getAvgBatchPercentage() {
        return avgBatchPercentage;
    }

    public void setAvgBatchPercentage(Double avgBatchPercentage) {
        this.avgBatchPercentage = avgBatchPercentage;
    }
}

