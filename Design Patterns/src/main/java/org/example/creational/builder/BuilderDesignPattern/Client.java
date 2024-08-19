package org.example.creational.builder.BuilderDesignPattern;

public class Client {
    /*
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setFName("someName");
        builder.setSName("someName");

        Student student = new Student(builder);
    }
     */

    public static void main(String[] args) {
        Student student = Student
                .getBuilder()
                .setfName("someThis")
                .setsName("Something")
                .build();
    }
}
