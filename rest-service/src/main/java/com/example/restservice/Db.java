package com.example.restservice;

public interface Db{
  static final String JDBC_DRIVER = "org.h2.Driver";   
  static final String DB_URL = "jdbc:h2:file:./dbase";
  static final String USER = "sa"; 
  static final String PASS = "password";
}