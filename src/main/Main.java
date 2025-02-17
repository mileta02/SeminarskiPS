/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.Controller;
import db.Konekcija;

/**
 *
 * @author milan
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println(Konekcija.getInstance().getConnection());
    }
}

