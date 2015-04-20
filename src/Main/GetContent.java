/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author StephenRobert
 */
public class GetContent {
            private Connection Connect;
    private Statement statement;
    private ResultSet result;
    String content;
    HashMap<Integer, String> Store = new HashMap<Integer, String>(); //stores data collected from the database
    
    public String GetContent(int id){
    
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://192.168.0.16:3306/security","root","security");
            statement = Connect.createStatement();
            //String insert = ("update persons set age= 35 where id = 'Stephen'");
            //statement.executeUpdate(insert);
            
            
            getData();
            content = Store.get(id);
            
        }catch(Exception ex){
            System.out.println("Error in GetContent; " + ex);
             
            
        }
        return content;
    }
    public void getData(){
        try{
            String query = "Select * from devices";
            result = statement.executeQuery(query);
           
          
            while(result.next()){
                 
                int id = result.getInt("Device");//gets integer from the device column
                String Description = result.getString("Description");//gets string from description column
                Store.put(id, Description);//puts the retrieved data into the hashmap
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
