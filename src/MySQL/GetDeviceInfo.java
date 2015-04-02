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
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author StephenRobert
 */
public class GetDeviceInfo implements HomeStrategy{

    private Connection Connect;
    HashMap<Integer, String> Store = new HashMap<Integer, String>(); //stores data collected from the database
    private ResultSet result;

    private Statement statement;

    public GetDeviceInfo() {

        MakeConnection();

    }
    public void DeviceStart(){
        MakeConnection();
        
    }
    public HashMap<Integer, String> MakeConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://192.168.0.18:3306/security", "root", "security");//connects to the db
            statement = Connect.createStatement(); //creates a statement (used later)
            GetInfo(); //Retrieves database information

        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
        return Store; //returns store hashmap

    }

    public void GetInfo() {
        try {
            String query = "Select * from devices";//selects the devices table
            result = statement.executeQuery(query);//creates result whic is used to retrieve data within the table

            while (result.next()) {  //whilst there is data in the table
                int id = result.getInt("Device");//gets integer from the device column
                String Description = result.getString("Description");//gets string from description column
                Store.put(id, Description);//puts the retrieved data into the hashmap
                

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }



}
