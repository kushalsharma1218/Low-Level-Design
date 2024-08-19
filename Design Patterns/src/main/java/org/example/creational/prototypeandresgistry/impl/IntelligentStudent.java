package org.example.creational.prototypeandresgistry.impl;

public class IntelligentStudent extends Student {
    private Double iq;

    public IntelligentStudent(){}

    public IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent); // this will initialise all variables in super
        this.iq = intelligentStudent.iq; // we can initialise all variable of current class here
    }

    // we cant just create IntelligentStudent object here and set all common properties present in
    // parent and child, cause there might be some fields for which setters and getters are not provided
    // suppose we are not able to access parent attributes
    public Student clone(){
        return new IntelligentStudent(this);
    }

    public Double getIq() {
        return iq;
    }

    public void setIq(Double iq) {
        this.iq = iq;
    }
}
