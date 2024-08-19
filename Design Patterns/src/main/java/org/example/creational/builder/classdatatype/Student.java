package org.example.creational.builder.classdatatype;

public class Student {
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


    // method introduced to give client context of builder
    public static Builder getBuilder(){
        return new Builder();
    }


    public Student(Builder builder){
        // perform business logic validations
    }

}
