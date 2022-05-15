/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.transaction;

import Pattern.library.interfaces.transactions;



/**
 *
 * @author Admin
 */
public class transaction implements transactions{
    private static transaction t;
    private transaction(){
        
    }
    public static transaction getIns(){
        if(t == null){
            t = new transaction();
        }
        return t;
    }
    public static transaction newIns(){
        return t = new transaction();
    }
    
    
    private int transactionID;
    private int readerID;
    private int bookID;
    
    @Override
    public transaction builder(transactionBuilder tr){
        transactionID = tr.transactionID;
        readerID = tr.readerID;
        bookID = tr.bookID;
        return this;
    }
    
    @Override
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    @Override
    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }
    @Override
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
