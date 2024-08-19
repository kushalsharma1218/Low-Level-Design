package org.example.creational.builder.classdatatype;

import lombok.Getter;
import lombok.Setter;


public class Builder {
    private String fName;
    private String sName;
    private String age;
    private String address;
    private String classNumber;
    private String batch;
    private String addhar;
    private String pan;
    private String idProof;
    private String phoneNumber;

    public Builder setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public Builder setsName(String sName) {
        this.sName = sName;
        return this;
    }

    public Builder setAge(String age) {
        this.age = age;
        return this;
    }

    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Builder setClassNumber(String classNumber) {
        this.classNumber = classNumber;
        return this;
    }

    public Builder setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public Builder setAddhar(String addhar) {
        this.addhar = addhar;
        return this;
    }

    public Builder setPan(String pan) {
        this.pan = pan;
        return this;
    }

    public Builder setIdProof(String idProof) {
        this.idProof = idProof;
        return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getBatch() {
        return batch;
    }

    public String getAddhar() {
        return addhar;
    }

    public String getPan() {
        return pan;
    }

    public String getIdProof() {
        return idProof;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Student build(){
        // put all business logic validations here now
        return new Student(this);
    }
}
