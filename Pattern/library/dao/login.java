/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import Pattern.library.interfaces.librarians;
import Pattern.library.librarian.librarian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class login {
    public static int loginCheck(librarians li){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "select * from librarian where name like ? AND pass like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, li.getName());
            ps.setString(2, li.getPass());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return 1;
            }
            sql = "select * from reader where name like ? AND pass like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, li.getName());
            ps.setString(2, li.getPass());
            rs = ps.executeQuery();
            if(rs.next()){
                return 2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
