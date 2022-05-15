/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import Pattern.library.factory.AbstractFactory;
import Pattern.library.factory.Types;
import Pattern.library.interfaces.librarians;
import Pattern.library.librarian.librarian;
import Pattern.library.librarian.librarianBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class librarianDAO {
    public static List<librarians> findLibra(){
        List<librarians> list = new ArrayList<>();
        try {
            Connection con = null;
            Statement st = null;
            connectiondb db = connectiondb.getIns();
            con = db.getConn();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from librarian");
            while (rs.next())
            {
                AbstractFactory fac = AbstractFactory.getFactory(Types.librarian);
                librarian li = (librarian) fac.getLibrarian(Types.librarian);
                li.builder(new librarianBuilder().name(rs.getString(1)).pass(rs.getString(2)));
                list.add(li);
            }
        } catch (SQLException ex) {
            Logger.getLogger(librarianDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void insert(librarians li){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "insert into librarian values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, li.getName());
            ps.setString(2, li.getPass());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
