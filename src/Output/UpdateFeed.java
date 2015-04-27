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
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author StephenRobert
 */
public class UpdateFeed {

    private ResultSet result;
    private int PACKETSIZE = 4;

    private Connection Connect;
    private Statement statement;
    Calendar calendar = Calendar.getInstance();
    Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

   

    public UpdateFeed(String id) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/security", "root", "security"); //connects to the db
            statement = Connect.createStatement(); //creates a statement (used later)
            Update(id);

        } catch (Exception ex) {
            System.out.println("Error in UpdateDB Makeconnection:  " + ex);
        }

    }

    public void Update(String id) {
        try {

            String insert = ("INSERT INTO feed (Description, time) VALUES('"+ id +"','"+ currentTimestamp + "')"); //changes 8803 description
            statement.executeUpdate(insert); // inputs insert into the database

        } catch (Exception ex) {
            System.out.println("Error in feed;  " + ex);
        }

    }

}
