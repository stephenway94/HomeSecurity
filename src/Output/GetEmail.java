/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Output;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author StephenRobert
 */
public class GetEmail {
        private Connection Connect;
    private Statement statement;
    private ResultSet result;
    String[] email = new String[20];
    
    public String[] GetEmail(){
    
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/security","root","security");
            statement = Connect.createStatement();
            //String insert = ("update persons set age= 35 where id = 'Stephen'");
            //statement.executeUpdate(insert);
            
            
            getData();
            
        }catch(Exception ex){
            System.out.println("Error in GetLogInDetails; " + ex);
             
            
        }
        return email;
    }
    public void getData(){
        try{
            String query = "Select * from email";
            result = statement.executeQuery(query);
           
           int i = 0;
            while(result.next()){
                email[i] = result.getString("email");
                System.out.println("email is " + email[i]);
                i++;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
