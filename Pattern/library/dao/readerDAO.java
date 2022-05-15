/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import Pattern.library.factory.AbstractFactory;
import Pattern.library.factory.Types;
import Pattern.library.interfaces.readers;
import Pattern.library.jframe.addReader;
import Pattern.library.reader.reader;
import Pattern.library.reader.readerBuilder;
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
public class readerDAO {
    public static List<readers> findRead(){
        List<readers> list = new ArrayList<>();
        try {
            Connection con = null;
            Statement st = null;
            connectiondb db = connectiondb.getIns();
            con = db.getConn();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from reader");
            while (rs.next())
            {
                AbstractFactory fac = AbstractFactory.getFactory(Types.reader);
                reader r = (reader) fac.getReader(Types.reader);
                r.builder(new readerBuilder().readerID(rs.getInt(1)).name(rs.getString(2)).pass(rs.getString(3)));
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(readerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void insert(readers r){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "insert into reader(name,pass) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getName());
            ps.setString(2, r.getPass());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(readerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(int id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "delete from reader where reader_id = ?";
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, id);
            try{
                ps.execute();
            }catch(Exception e){
                addReader a = new addReader();
                a.showMes();
            }
        } catch (SQLException ex) {
            Logger.getLogger(readerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
