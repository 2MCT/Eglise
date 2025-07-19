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
public class EgliseModel {
    public String design;
    public int solde=0;
    public String idEglise="EGL1";
    
    /**
     *
     * @param des
     * @param s
     * @param id
     */
    public EgliseModel(String des, int s, String id){
        this.design = des;
        this.solde = s;
        this.idEglise = id;
    }
    
    /**
     *
     * @param des
     */
    public EgliseModel(String des){
        this.design = des;
    }
    
    public int createEglise(){
        Connection con = Connexion.connect();
        try{
            PreparedStatement s = con.prepareStatement("INSERT INTO EGLISE(ideglise, design, solde) VALUES (?,?,?);");
            s.setString(1, this.idEglise);
            s.setString(2, design);
            s.setInt(3, solde);
            int created = s.executeUpdate();
            return created;
        }
        catch(SQLException E){
            System.out.println(E);
            return 0;
        }
    }
    public static boolean hasEglise(){
        Connection con = Connexion.connect();
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT ideglise FROM EGLISE;");
            while(res.next()){
                String a = res.getString(1);
                System.out.println(a);
                return !a.isEmpty();
            }
            return false;
        }
        catch(SQLException E){
            return false;
        }
    }
    public static EgliseModel getEglise(){
        Connection con = Connexion.connect();
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM EGLISE;");
            if(res.next()){
                EgliseModel eglise = new EgliseModel("");
                eglise.design = res.getString("design");
                eglise.idEglise = res.getString("ideglise");
                eglise.solde = res.getInt("solde");
                return eglise;
            }
            return null;
        }
        catch(SQLException E){
            return null;
        }
    }
}
