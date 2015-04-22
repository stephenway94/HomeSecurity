/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessPacketInfo;

import LogIn.LogIn;
import Strategies.HomeStrategy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author StephenRobert
 */
public class getLogInDetails implements HomeStrategy{

  
    private Connection Connect;
    private Statement statement;
    private ResultSet result;
    private HashMap< Integer, Integer> LogInInformation = new HashMap< Integer,Integer>();
    private LogIn LogIn;

    
    
    public HashMap<Integer,Integer> getLogInDetails() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://192.168.0.16:3306/security","root","security");
            statement = Connect.createStatement();
            //String insert = ("update persons set age= 35 where id = 'Stephen'");
            //statement.executeUpdate(insert);
            
            
            getData();
            
        }catch(Exception ex){
            System.out.println("Error in GetLogInDetails; " + ex);
             
            
        }
        return LogInInformation;
    }
    public void getData(){
        try{
            String query = "Select * from login";
            result = statement.executeQuery(query);
           
            while(result.next()){
                int id = result.getInt("id");
                int inout = result.getInt("LogInfo");
                LogInInformation.put(id,inout);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    }
    
