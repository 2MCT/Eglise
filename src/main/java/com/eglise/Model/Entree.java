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
    public Entree(int id){
        Entree e = Entree.getEntree(id);
        this.idEntree = e.idEntree;
        this.motif = e.motif;
        this.dateEntree = e.dateEntree;
        this.montantEntree = e.montantEntree;
    }
    
    public Entree(){
        
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
        return Entree.listEntree("");
    }
    public static Entree[] listEntree(String motif_like){
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ENTREE WHERE motif LIKE '%"+motif_like+"%';");
            ResultSet res = stmt.executeQuery();
            int l = 0;
            while(res.next()){
                l++;
            }
            Entree[] entrees = new Entree[l];
            stmt = con.prepareStatement("SELECT * FROM ENTREE WHERE motif LIKE '%"+motif_like+"%';");
            res = stmt.executeQuery();
            int i = 0 ;
            while(res.next()){
                entrees[i] = new Entree(res.getInt("identree"),res.getString("motif"),res.getDate("date_entree"),res.getInt("montant_entree"));
                i++;
            }
            System.out.println(entrees.length);
            return entrees;
        }
        catch(SQLException E){
            System.err.println(E);
            return null;
        }
    }
    public int delete(){
        Connection con = Connexion.connect();
        try{
            EgliseModel eglise = EgliseModel.getEglise();
            if(eglise.solde-this.montantEntree < 10000) 
                return -1;
            PreparedStatement stmt = con.prepareStatement("DELETE FROM ENTREE WHERE identree=?;");
            stmt.setInt(1, idEntree);
            if(eglise.addSolde(-this.montantEntree)==1)
                return stmt.executeUpdate();
            return -1;
        }
        catch(SQLException E){
            return -1;
        }
    }
    public static Entree getEntree(int id){
        Entree entree = new Entree();
        entree.idEntree = id;
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT motif, montant_entree, date_entree FROM ENTREE WHERE identree = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                entree.motif = res.getString("motif");
                entree.dateEntree = res.getDate("date_entree");
                entree.montantEntree = res.getInt("montant_entree");
                return entree;
            }
            return null;
        }
        catch(SQLException E){
            return null;
        }
    }
}
