/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.interfaces;

import Pattern.library.transaction.transaction;
import Pattern.library.transaction.transactionBuilder;

/**
 *
 * @author Admin
 */
public interface transactions {
    public transaction builder(transactionBuilder tr);
    public int getTransactionID();
    public int getReaderID();
    public int getBookID();
}
