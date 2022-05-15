/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import Pattern.library.factory.AbstractFactory;
import Pattern.library.factory.Types;
import Pattern.library.interfaces.transactions;
import Pattern.library.jframe.transactionJF;
import Pattern.library.transaction.transaction;
import Pattern.library.transaction.transactionBuilder;
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
public class transactionDAO {
    public static List<transactions> findTrans(){
        List<transactions> list = new ArrayList<>();
        try {
            Connection con = null;
            Statement st = null;
            connectiondb db = connectiondb.getIns();
            con = db.getConn();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from transaction");
            while (rs.next())
            {
                AbstractFactory fac = AbstractFactory.getFactory(Types.transaction);
                transaction tr = (transaction) fac.getTransaction(Types.transaction);
                tr.builder(new transactionBuilder().id(rs.getInt(1)).readerID(rs.getInt(2)).bookID(rs.getInt(3)));
                list.add(tr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(transactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void insert(transactions tr){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "insert into transaction(reader_id, book_id) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tr.getReaderID());
            ps.setInt(2, tr.getBookID());
            try{
                ps.execute();
            }catch(Exception e){
                transactionJF tra = new transactionJF();
                tra.showMes();
            }
        } catch (SQLException ex) {
            Logger.getLogger(transactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(int id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "delete from transaction where transaction_id ="+id;
        try {
            ps = con.prepareCall(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(transactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
