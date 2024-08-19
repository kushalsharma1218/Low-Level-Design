package org.example.creational.prototypeandresgistry.impl;

public class Client {
    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegister(studentRegistry);


        Student copyStudent = studentRegistry.get("FEB 24 LLD").clone();
        //set other attributes in copy
        Student inCopy = studentRegistry.get("FEB 24 LLD Intelligent").clone();
        //set other attributes in inCopy


    }

    private static void fillRegister(StudentRegistry studentRegistry) {
        Student student = new Student();
        student.setBatch("FEB 24 LLD");
        student.setAvgBatchPercentage(89.0);

        studentRegistry.register("FEB 24 LLD", student);


        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setBatch("FEB 24 LLD Intelligent");
        intelligentStudent.setAvgBatchPercentage(89.0);
        intelligentStudent.setIq(90.0);

        studentRegistry.register("FEB 24 LLD Intelligent", intelligentStudent);

    }
}
