package org.example.creational.singleton.eagerloading;

public class DbConnection {
    private String url;
    private String host;
    private String password;


    private static DbConnection dbConnection;


    private DbConnection(String url, String host){
        this.url = url;
        this.host = host;
    }

    public static DbConnection getDbConnection(){
        if(dbConnection == null){
            dbConnection = new DbConnection("url", "host");
        }

        return dbConnection;
    }
}
