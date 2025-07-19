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
public class Entree {
    public int idEntree;
    public String motif;
    public Date dateEntree;
    public int montantEntree;
    
    public Entree(int id, String mot, Date date, int montant){
        this.idEntree = id;
        this.motif = mot;
        this.dateEntree = date;
        this.montantEntree = montant;
    }
    public Entree(String mot, int montant){
        this.idEntree = -1;
        this.dateEntree = new Date(System.currentTimeMillis());
        this.montantEntree = montant;
        this.motif = mot;
    }
    
    public int create(){
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ENTREE(motif,montant_entree,date_entree) VALUES(?,?,?);");
            stmt.setString(1, motif);
            stmt.setInt(2, montantEntree);
            stmt.setDate(3, dateEntree);
            int result = stmt.executeUpdate();
            if(result==1){
                ResultSet res = stmt.getGeneratedKeys();
                if(res.next()){
                    this.idEntree = res.getInt(1);
                    return this.idEntree;
                }
            }
            return 0;
        }
        catch(SQLException E){
            return 0;
        }
    }
    
    public int update(String mot, Date date, int montant){
        this.dateEntree = new Date(System.currentTimeMillis());
        this.montantEntree = montant;
        this.motif = mot;
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("UPDATE ENTREE SET motif=?, montant_entree=?, date_entree=? WHERE identree=?;");
            stmt.setString(1, motif);
            stmt.setInt(2, montantEntree);
            stmt.setDate(3, dateEntree);
            stmt.setInt(4, idEntree);
            int result = stmt.executeUpdate();
            return result;
        }
        catch(SQLException E){
            return -1;
        }
    }
    public static Entree[] listEntree(){
        Connection con = Connexion.connect();
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ENTREE;");
            int l = 0;
            while(res.next()){
                l++;
            }
            Entree[] entrees = new Entree[l];
            stmt = con.createStatement();
            res = stmt.executeQuery("SELECT * FROM ENTREE;");
            int i = 0 ;
            while(res.next()){
                entrees[i] = new Entree(res.getInt("identree"),res.getString("motif"),res.getDate("date_entree"),res.getInt("montant_entree"));
                i++;
            }
            System.out.println(entrees.length);
            return entrees;
        }
        catch(SQLException E){
            return null;
        }
    }
}
