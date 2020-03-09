package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.ResultSet; 
import java.sql.Statement;

public class Users implements Db{

  private List<User> getUsers(String queryString){
    Connection conn = null;   
    Statement stmt = null;
    List<User> allUsers = new ArrayList<>();
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(queryString);
      while(rs.next()) {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        allUsers.add(new User(id, firstName, lastName));
      }
      stmt.close(); 
      conn.close(); 
   } catch(SQLException se) {
      se.printStackTrace(); 
   } catch(Exception e) {
      e.printStackTrace(); 
   } finally {
      try{ 
         if(stmt!=null) stmt.close(); 
      } catch(SQLException se2) {}
      try { 
         if(conn!=null) conn.close(); 
      } catch(SQLException se){ 
         se.printStackTrace(); 
      }
   }
   return allUsers;
  }

  public List<User> getUserById(int findId){
    String sql =  "SELECT * FROM billionaires WHERE id=" + findId;
    List<User> allUsers = getUsers(sql);
    return allUsers;
  }

  public List<User> getAllUsers(){
    String sql =  "SELECT * FROM billionaires";
    List<User> allUsers = getUsers(sql);
    return allUsers;
  }
}