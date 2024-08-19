package org.example.creational.singleton.classloading;

public class DatabaseConnection {
    private String url;
    private String host;
    private String password;



    // we cant pass define attributes here
    private static DatabaseConnection dbConnection = new DatabaseConnection();


    private DatabaseConnection(){}

    public static DatabaseConnection getDbConnection(){
        return dbConnection;
    }}
