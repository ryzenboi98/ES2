package com.es2.objectpool;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {
    private static ReusablePool single_instance = null;

    private static Integer poolSize;
    private static ArrayList<java.net.HttpURLConnection> connectionfree;
    private static ArrayList<java.net.HttpURLConnection> connectionused;

    private ReusablePool() {
        poolSize = 10;
        connectionfree = new ArrayList<java.net.HttpURLConnection>();
        connectionused = new ArrayList<java.net.HttpURLConnection>();
    }

    public static ReusablePool getInstance() {
        if(single_instance == null)
            synchronized (ReusablePool.class) {
                if (single_instance == null)
                    single_instance = new ReusablePool();
            }
        return single_instance;
    }

    public synchronized HttpURLConnection acquire() throws java.io.IOException,
            PoolExhaustedException{
        if (connectionused.size() >= poolSize)
            throw new PoolExhaustedException();

        HttpURLConnection con;

            if(connectionfree.isEmpty())
                con = (HttpURLConnection) new URL("http://www.ipv.pt").openConnection();
            else {
                con = connectionfree.get(0);
                connectionfree.remove(0);
                con.connect();
            }
            connectionused.add(con);
        return con;
    }

    public synchronized void release(java.net.HttpURLConnection conn)
            throws ObjectNotFoundException {

        if (!connectionused.contains(conn))
            throw new ObjectNotFoundException();

        conn.disconnect();
        connectionused.remove(conn);
        connectionfree.add(conn);
    }

    public synchronized void resetPool() {
        single_instance = null;
    }

    public synchronized void setMaxPoolSize(int size) {
        this.poolSize = size;
    }
}
