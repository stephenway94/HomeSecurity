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
public class DeviceLog implements HomeStrategy{
    private Connection Connect;
    private Statement statement;
    private ResultSet result;
    
    public DeviceLog() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://192.168.0.16:3306/security","root","security");
            statement = Connect.createStatement();
           // String insert = ("update  set age= 35 where id=1");
            String name = "Dining room window";
            String time = "'25-02-2015 22:59:59'";
            String insert = "insert into devices VALUES('" + name + "' , " + time + ")";
            statement.executeUpdate(insert);
            
            getData();
            
        }catch(Exception ex){
            System.out.println("Error " + ex);
            
            
        }
    }
    public void getData(){
        try{
            String query = "Select * from devices";
            result = statement.executeQuery(query);
           
            System.out.println("Records from database");
            while(result.next()){
                String name = result.getString("Device");
                String age = result.getString("time");
                System.out.println("Name: " +name + " age " + age);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
