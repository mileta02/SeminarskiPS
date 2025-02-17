/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milan
 */
public class Licenca implements OpstiDomenskiObjekat{
    private int idLicence;
    private String zvanjeInstruktora;
    private String nazivLicence;

    public Licenca() {
    }

    public Licenca(int idLicence, String zvanjeInstruktora, String nazivLicence) {
        this.idLicence = idLicence;
        this.zvanjeInstruktora = zvanjeInstruktora;
        this.nazivLicence = nazivLicence;
    }

    @Override
    public String toString() {        
        return nazivLicence;      
    }

    public int getIdLicence() {
        return idLicence;
    }

    public void setIdLicence(int idLicence) {
        this.idLicence = idLicence;
    }

    public String getZvanjeInstruktora() {
        return zvanjeInstruktora;
    }

    public void setZvanjeInstruktora(String zvanjeInstruktora) {
        this.zvanjeInstruktora = zvanjeInstruktora;
    }

    public String getNazivLicence() {
        return nazivLicence;
    }

    public void setNazivLicence(String nazivLicence) {
        this.nazivLicence = nazivLicence;
    }

    @Override
    public String vratiNazivTabele() {
        return "licenca";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idLicence = rs.getInt("licenca.idLicence");
            String zvanjeInstruktora = rs.getString("licenca.zvanjeInstruktora");
            String nazivLicence = rs.getString("licenca.nazivLicence");
            Licenca l = new Licenca(idLicence, zvanjeInstruktora, nazivLicence);
            lista.add(l);
        }
        return lista;    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "zvanjeInstruktora,nazivLicence";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'"+zvanjeInstruktora+"','"+nazivLicence+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "licenca.idLicence="+idLicence;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "zvanjeInstruktora='"+zvanjeInstruktora+"',nazivLicence='"+nazivLicence+"'";
    }
    
    
    
}
