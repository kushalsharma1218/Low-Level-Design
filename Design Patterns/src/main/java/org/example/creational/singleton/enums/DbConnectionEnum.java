package org.example.creational.singleton.enums;


public enum DbConnectionEnum {
    DbConnection;

    int value;

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public void someMethod(){}
}
