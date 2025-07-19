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
public class Sortie {
    public int idSortie;
    public String motif;
    public Date dateSortie;
    public int montantSortie;
    
    public Sortie(int id, String mot, Date date, int montant){
        this.idSortie = id;
        this.motif = mot;
        this.dateSortie = date;
        this.montantSortie = montant;
    }
    public Sortie(String mot, int montant){
        this.idSortie = -1;
        this.dateSortie = new Date(System.currentTimeMillis());
        this.montantSortie = montant;
        this.motif = mot;
    }
    
    public int create(){
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SORTIE(motif,montant_sortie,date_sortie) VALUES(?,?,?);");
            stmt.setString(1, motif);
            stmt.setInt(2, montantSortie);
            stmt.setDate(3, dateSortie);
            int result = stmt.executeUpdate();
            if(result==1){
                ResultSet res = stmt.getGeneratedKeys();
                if(res.next()){
                    this.idSortie = res.getInt(1);
                    return this.idSortie;
                }
            }
            return 0;
        }
        catch(SQLException E){
            return 0;
        }
    }
    
    public int update(String mot, Date date, int montant){
        this.dateSortie = new Date(System.currentTimeMillis());
        this.montantSortie = montant;
        this.motif = mot;
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("UPDATE SORTIE SET motif=?, montant_sortie=?, date_sortie=? WHERE idsortie=?;");
            stmt.setString(1, motif);
            stmt.setInt(2, montantSortie);
            stmt.setDate(3, dateSortie);
            stmt.setInt(4, idSortie);
            int result = stmt.executeUpdate();
            return result;
        }
        catch(SQLException E){
            return -1;
        }
    }
}
