/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogIn;

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
public class Retrieve {
        private Connection Connect;
    private Statement statement;
    private ResultSet result;
    private HashMap< String, String> LogInInformation = new HashMap< String, String>();
    private LogIn LogIn;
    
    public HashMap<String,String> Retrieve() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://192.168.0.18:3306/securitytest","root","security");
            statement = Connect.createStatement();
            //String insert = ("update persons set age= 35 where id = 'Stephen'");
            //statement.executeUpdate(insert);
            
            
            getData();
            
        }catch(Exception ex){
            System.out.println("Error " + ex);
            
            
        }
        return LogInInformation;
    }
    public void getData(){
        try{
            String query = "Select * from persons";
            result = statement.executeQuery(query);
           
            while(result.next()){
                String id = result.getString("id");
                String inout = result.getString("inout");
                LogInInformation.put(id,inout);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }


}
