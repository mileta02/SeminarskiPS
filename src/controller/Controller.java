/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.DatabaseBroker;
import db.Konekcija;
import model.Instruktor;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author milan
 */
public class Controller {
    private static Controller instance;
    private DatabaseBroker db = new DatabaseBroker();
    private Controller(){
        
    }
    
    public static Controller getInstance(){
        if(instance==null)
            instance = new Controller();
        return instance;
    }
    
    public Instruktor getUserByPassword(String korisnicko, String sifra){
        return db.getUserByPassword(korisnicko,sifra);
    }



    public boolean doesInstructorExists(String korisnicko) {
        return db.doesInstructorExists(korisnicko);
    }

    public void registerIns(String korisnicko, String sifra, String kontakt, String ime, String prezime) {
        db.registerIns(korisnicko,sifra,kontakt,ime,prezime);
      }



    
}
