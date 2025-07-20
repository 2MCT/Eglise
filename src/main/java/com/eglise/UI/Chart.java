/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eglise.UI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.sql.Date;

/**
 *
 * @author christalin
 */

public class Chart extends JPanel {

    public Chart(int[] values, Date[] dates) {
        setSize(500, 800);
        // Création des données
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0; i < values.length; i++){
            dataset.addValue(values[i], "Montant", dates[i].toString()+i);
            System.out.println(values[i]);
        }
        // Création du graphique
        JFreeChart barChart = ChartFactory.createBarChart("Flux Monétaire", "Date", "Montant", dataset);
        // Panneau pour afficher le graphique
        ChartPanel chartPanel = new ChartPanel(barChart);
        this.add(chartPanel, java.awt.BorderLayout.WEST);
    }
}
