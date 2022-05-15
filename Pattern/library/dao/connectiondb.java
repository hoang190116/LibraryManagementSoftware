/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class connectiondb {
    private static connectiondb con = null;
    private connectiondb(){
        
    }
    public static connectiondb getIns(){
        if(con==null){
            con = new connectiondb();
        }
        return con;
    }
    public Connection getConn(){
        Connection con = null;
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(jdbcSing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(jdbcSing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
