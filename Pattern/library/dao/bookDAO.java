/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.dao;

import Pattern.library.book.book;
import Pattern.library.book.bookBuilder;
import Pattern.library.factory.AbstractFactory;
import Pattern.library.factory.Types;
import Pattern.library.interfaces.books;
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
public class bookDAO {
    public static List<books> search(String name){
        List<books> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "select * from book where book_name like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AbstractFactory fac = AbstractFactory.getFactory(Types.book);
                book b = (book) fac.getBook(Types.book);
                b.builder(new bookBuilder().book_id(rs.getInt(1)).book_name(rs.getString(2)).author(rs.getString(3))
                        .publish(rs.getString(4)).type(rs.getString(5)).area(rs.getString(6)));
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(readerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static List<books> findBook(){
        List<books> list = new ArrayList<>();
        try {
            Connection con = null;
            Statement st = null;
            connectiondb db = connectiondb.getIns();
            con = db.getConn();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book");
            while (rs.next())
            {
                AbstractFactory fac = AbstractFactory.getFactory(Types.book);
                book b = (book) fac.getBook(Types.book);
                bookBuilder b2 = new bookBuilder().book_id(rs.getInt(1)).book_name(rs.getString(2)).author(rs.getString(3))
                        .publish(rs.getString(4)).type(rs.getString(5)).area(rs.getString(6));
                b2.build();
                b.builder(b2);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(librarianDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void delete(String name)
    {
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "delete from book where book_name like ?";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void update(books b){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "update book set book_name=?,author=?,publish=?,type=?,area=? where book_id = ?";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, b.getBook_name());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublish());
            ps.setString(4, b.getType());
            ps.setString(5, b.getArea());
            ps.setInt(6, b.getBook_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(books b){
        Connection con = null;
        PreparedStatement ps = null;
        connectiondb db = connectiondb.getIns();
        con = db.getConn();
        String sql = "insert into book(book_name, author, publish, type, area) values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getBook_name());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublish());
            ps.setString(4, b.getType());
            ps.setString(5, b.getArea());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
