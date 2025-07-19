/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eglise.Model;
import java.sql.*;

/**
 *
 * @author christalin
 */
public class Connexion {
    public static Connection connect(){
        String url = "jdbc:mysql://localhost:3306/Eglise";
        try{
            Connection con = DriverManager.getConnection(url,"chris","Chriskely@123");
            return con;
        }
        catch(SQLException E){
            System.out.println(E);
            return null;
        }
    }
}
