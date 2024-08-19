package org.example.creational.builder.mapdatatype;

import java.util.Map;

public class StudentWithMap {
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


    public StudentWithMap(Map<String, Object> classValues){
        if(classValues.containsKey("fName")){
            this.fName = (String)classValues.get("fName");
        }
    }

}
