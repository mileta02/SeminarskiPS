/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import controller.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;

/**
 *
 * @author milan
 */
public class DatabaseBroker {

    public Instruktor getUserByPassword(String korisnicko, String sifra) {
        
        
        String upit = "SELECT * FROM instruktor WHERE korisnickoIme = ? AND sifra = ?";

        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, korisnicko);
            ps.setString(2, sifra);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int idInstruktor = rs.getInt("instruktor.idInstruktor");
            String ime = rs.getString("instruktor.ime");
            String prezime = rs.getString("instruktor.prezime");
            String kontakt = rs.getString("instruktor.kontakt");
            String korisnickoIme = rs.getString("instruktor.korisnickoIme");
            String sifraa = rs.getString("instruktor.sifra");
            Instruktor i = new Instruktor(idInstruktor, ime, prezime, kontakt, korisnickoIme, sifraa);
            return i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return null;

    }

    public boolean doesInstructorExists(String korisnicko) {

        String upit = "SELECT * FROM instruktor WHERE korisnickoIme = ?";

        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, korisnicko);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void registerIns(String korisnicko, String sifra, String kontakt, String ime, String prezime) {
        String upit = "INSERT INTO instruktor (ime, prezime, kontakt, korisnickoIme, sifra)  VALUES (?,?,?,?,?);";
        
        PreparedStatement ps;
        try {
            ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, kontakt);
            ps.setString(4, korisnicko);
            ps.setString(5, sifra);
         
            int rowsAff = ps.executeUpdate();
            if(rowsAff==1)
                JOptionPane.showMessageDialog(null, "Uspesno registrovan");
            else
                JOptionPane.showMessageDialog(null, "Greska");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
