package com.ar.stocksapp;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UpdTrigger implements Trigger {
    @Override
    public void init(Connection connection, String schemaName, String triggerName, String tableName, boolean before, int type) throws SQLException {

    }

    @Override
    public void fire(Connection connection, Object[] oldRow, Object[] newRow) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO log_tracking SELECT *, now() FROM symbols");

        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(newRow).forEach((row) -> {
            try {
                stmt.setObject(index.getAndIncrement(), row);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        stmt.executeUpdate();
    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public void remove() throws SQLException {

    }
}
