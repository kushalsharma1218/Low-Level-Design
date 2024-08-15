package org.example.creational.singleton;

public class MultiThreadedDbConnection1 {
    private String url;
    private String host;
    private String password;



    // this is eager loading
    private static MultiThreadedDbConnection1 dbConnection = new MultiThreadedDbConnection1();


    private MultiThreadedDbConnection1(){}

    public static MultiThreadedDbConnection1 getDbConnection(){
        if(dbConnection == null){
            dbConnection = new MultiThreadedDbConnection1();
        }

        return dbConnection;
    }}
