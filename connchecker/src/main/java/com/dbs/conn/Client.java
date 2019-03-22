package com.dbs.conn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Client {

    public static void main(String[] args) {
        DataSource mySqlDataSource = new ComboPooledDataSource();
        DataSource oracleDataSource = new ComboPooledDataSource("customerOracle");

        try {
            Connection mySqlConnection = mySqlDataSource.getConnection();
            if(mySqlConnection == null){
                throw new SQLException("The mysql connection is null");
            }
            System.out.println("create mysql connection successfully.");
        } catch (SQLException e) {
            System.out.println("create mysql connection Fail.");
            System.out.println(e);
        }
        try {
            Connection oracleConnection = oracleDataSource.getConnection();
            if(oracleConnection == null){
                throw new SQLException("The oracle connection is null");
            }
            System.out.println("create oracle connection successfully.");
        } catch (SQLException e) {
            System.out.println("create oracle connection Fail.");
            System.out.println(e);
        }

    }

}
