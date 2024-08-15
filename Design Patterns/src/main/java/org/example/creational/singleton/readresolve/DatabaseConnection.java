package org.example.creational.singleton.readresolve;

import java.io.Serializable;

public class DatabaseConnection implements Serializable {
    private String url;
    private String host;
    private String password;

    private static DatabaseConnection dbConnection;

    /** this would resolve our serialization problem,
     *  this method is being called at the time of deserialization
     */
    protected Object readResolve() {
        return getDbConnection();
    }

    private DatabaseConnection(){}

    public  static DatabaseConnection getDbConnection() {
        if (dbConnection == null) {
            // lock
            synchronized (DatabaseConnection.class) {
                if (dbConnection == null) {
                    dbConnection = new DatabaseConnection();
                }
            }
            // ------------------------------------> unlock
        }

        return dbConnection;
    }
}
