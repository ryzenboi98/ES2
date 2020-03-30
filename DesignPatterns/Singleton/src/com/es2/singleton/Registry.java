package com.es2.singleton;

import java.nio.file.Path;

public class Registry {

    private static Registry single_instance = null;
    private String Path;
    private String connectionString;

    private Registry() {
    }

    public static Registry getInstance() {
        if(single_instance == null)
            synchronized (Registry.class) {
                if (single_instance == null)
                    single_instance = new Registry();
            }
        return single_instance;
    }

    public void setPath(java.lang.String path) {
        this.Path = path;
    }

    public java.lang.String getPath() {
        return Path;
    }

    public void setConnectionString(java.lang.String connectionString) {
        this.connectionString = connectionString;
    }

    public java.lang.String getConnectionString() {
        return connectionString;
    }
}
