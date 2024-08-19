package org.example.creational.singleton.double_check_locking;

public class DatabaseConnection {
    private String url;
    private String host;
    private String password;

    private static DatabaseConnection dbConnection;


    private DatabaseConnection(){}

    /*
    this was time consuming
    public synchronized static MultiThreadedDbConnection2 getDbConnection(){
        // ------------------------------------> lock
        if(dbConnection == null){
            dbConnection = new MultiThreadedDbConnection2();
        }

        return dbConnection;
        // ------------------------------------> unlock
    }
     */

    // more optimised version of singleton
    // So now, less thread will acquire lock and perm is improved
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
