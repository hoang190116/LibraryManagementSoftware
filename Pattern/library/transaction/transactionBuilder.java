/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.transaction;


/**
 *
 * @author Admin
 */
public class transactionBuilder {
    public int transactionID;
    public int readerID;
    public int bookID;
    
    public transactionBuilder id(int id){
        transactionID = id;
        return this;
    }
    
    public transactionBuilder readerID(int id){
        readerID = id;
        return this;
    }
    
    public transactionBuilder bookID(int id){
        bookID = id;
        return this;
    }
    
    public transaction build(){
        return transaction.newIns().builder(this);
    }
}
