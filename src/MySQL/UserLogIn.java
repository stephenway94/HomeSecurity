/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import Strategies.HomeStrategy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author StephenRobert
 */
public class UserLogIn implements HomeStrategy {
    private Connection Connect;
    private Statement statement;
    private ResultSet result;
    
    public UserLogIn() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/security","root","security");
            statement = Connect.createStatement();
            String insert = ("update persons set age= 35 where id = 'Stephen'");
            statement.executeUpdate(insert);
            
            getData();
            
        }catch(Exception ex){
            System.out.println("Error " + ex);
            
            
        }
    }
    public void getData(){
        try{
            String query = "Select * from persons";
            result = statement.executeQuery(query);
           
            System.out.println("Records from database");
            while(result.next()){
                String name = result.getString("id");
                String age = result.getString("age");
                System.out.println("Name: " +name + " age " + age);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    
}
