package org.example.creational.singleton.classloading;

public class DatabaseConnection {
    private String url;
    private String host;
    private String password;



    // this is eager loading
    private static DatabaseConnection dbConnection = new DatabaseConnection();


    private DatabaseConnection(){}

    public static DatabaseConnection getDbConnection(){
        if(dbConnection == null){
            dbConnection = new DatabaseConnection();
        }

        return dbConnection;
    }}
