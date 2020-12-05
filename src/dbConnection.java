
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmohi
 */
public final class dbConnection {
   public final static Connection connect(){
        
       Connection conn= null;
       try{
           conn = DriverManager.getConnection("jdbc:db2://dashdb-txn-sbox-yp-lon02-04.services.eu-gb.bluemix.net:50000/BLUDB", "tfg22796", "d0bkv2+pgggjpzb4");
       }
       catch(SQLException e){
           System.out.println("Something went wrong: " + e.getMessage());
       }
       return conn;
    }
}
