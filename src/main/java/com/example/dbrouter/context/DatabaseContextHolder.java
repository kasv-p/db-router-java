package com.example.dbrouter.context;

import com.example.dbrouter.enums.DatabaseType;
import org.springframework.util.Assert;

public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> CONTEXT = new ThreadLocal<>();

    public static void set(DatabaseType clientDatabase) {
        Assert.notNull(clientDatabase, "clientDatabase cannot be null");
        CONTEXT.set(clientDatabase);
    }

    public static DatabaseType get() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }

}
