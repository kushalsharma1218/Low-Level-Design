package org.example.creational.singleton;

public class MultiThreadedDbConnection2 {
    private String url;
    private String host;
    private String password;

    private static MultiThreadedDbConnection2 dbConnection;


    private MultiThreadedDbConnection2(){}

    /*
    public synchronized static MultiThreadedDbConnection2 getDbConnection(){
        // ------------------------------------> lock
        if(dbConnection == null){
            dbConnection = new MultiThreadedDbConnection2();
        }

        return dbConnection;
        // ------------------------------------> unlock
    }
     */

    // So now, less thread will acquire lock and perm is improved
    public synchronized static MultiThreadedDbConnection2 getDbConnection() {
        if (dbConnection == null) {
            // lock
            if (dbConnection == null) {
                dbConnection = new MultiThreadedDbConnection2();
            }
            // ------------------------------------> unlock
        }

        return dbConnection;
    }
}
