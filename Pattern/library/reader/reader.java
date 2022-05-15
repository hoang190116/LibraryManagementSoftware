/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.reader;


import Pattern.library.interfaces.readers;

/**
 *
 * @author Admin
 */
public class reader implements readers{
    private static reader r = null;
    private reader(){
        
    }
    public static reader getIns(){
        if(r==null){
            r = new reader();
        }
        return r;
    }
    public static reader newIns(){
        return r = new reader();
    }
    private int readerID;
    private String name;
    private String pass;
    
    @Override
    public reader builder(readerBuilder re){
        readerID = re.readerID;
        name = re.name;
        pass = re.pass;
        return this;
    }

    @Override
    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
