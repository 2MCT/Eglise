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
    public Sortie(int id){
        Sortie e = Sortie.getSortie(id);
        this.idSortie = e.idSortie;
        this.motif = e.motif;
        this.dateSortie = e.dateSortie;
        this.montantSortie = e.montantSortie;
    }
    
    public Sortie(){
        
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
    public static Sortie[] listSortie(){
        return Sortie.listSortie("");
    }
    public static Sortie[] listSortie(String motif_like){
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM SORTIE WHERE motif LIKE '%"+motif_like+"%';");
            ResultSet res = stmt.executeQuery();
            int l = 0;
            while(res.next()){
                l++;
            }
            Sortie[] sorties = new Sortie[l];
            stmt = con.prepareStatement("SELECT * FROM SORTIE WHERE motif LIKE '%"+motif_like+"%';");
            res = stmt.executeQuery();
            int i = 0 ;
            while(res.next()){
                sorties[i] = new Sortie(res.getInt("idsortie"),res.getString("motif"),res.getDate("date_sortie"),res.getInt("montant_sortie"));
                i++;
            }
            System.out.println(sorties.length);
            return sorties;
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
            PreparedStatement stmt = con.prepareStatement("DELETE FROM SORTIE WHERE idsortie=?;");
            stmt.setInt(1, idSortie);
            if(eglise.addSolde(this.montantSortie)==1)
                return stmt.executeUpdate();
            return -1;
        }
        catch(SQLException E){
            return -1;
        }
    }
    public static Sortie getSortie(int id){
        Sortie sortie = new Sortie();
        sortie.idSortie = id;
        Connection con = Connexion.connect();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT motif, montant_sortie, date_sortie FROM SORTIE WHERE idsortie = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                sortie.motif = res.getString("motif");
                sortie.dateSortie = res.getDate("date_sortie");
                sortie.montantSortie = res.getInt("montant_sortie");
                return sortie;
            }
            return null;
        }
        catch(SQLException E){
            return null;
        }
    }
}
