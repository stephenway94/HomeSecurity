/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenerManager;

import Strategies.HomeStrategy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author StephenRobert
 */
public class UpdateLogIn implements HomeStrategy{

    private ResultSet result;

    private Connection Connect;
    private Statement statement;
 
    UpdateLogIn(int id, int update)  {
        
        MakeConnection();
        Update(id, update);
        

    }

    public void MakeConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/security", "root", "security"); //connects to the db
            statement = Connect.createStatement(); //creates a statement (used later)

        } catch (Exception ex) {
            System.out.println("Error in UpdateDB Makeconnection:  " + ex);
        }

    }

    public void Update(int id, int update) {
        try {
            // int getValue = dbcheck.get(inout);

            System.out.println("packet is " + update + " and getValue is " + id);

            String insert = ("update login set LogInfo= '" + update + "' where id='" + id + "'"); //changes 1101 description
            statement.executeUpdate(insert); // inputs insert into the database

        } catch (Exception ex) {
            System.out.println("Error in Update Update;  " + ex);
        }

    }

  

}
