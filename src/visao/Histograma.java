/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Henrique
 */
public class Histograma extends JFrame{
    
    public CategoryDataset createDataSet(ArrayList<Horario> horarios){
        // Permite inserir os dados no dataset.
        DefaultCategoryDataset dset = new DefaultCategoryDataset();
        
        for(Horario h : horarios){
            dset.addValue(h.getValor(), h.toString(), "");
        }
        
        return dset;
    }
    
    public JFreeChart createBarChart(CategoryDataset dt){
        JFreeChart grafico = ChartFactory.createBarChart("Dados", "", "Hora", dt, PlotOrientation.VERTICAL, true, false, false);
        return grafico;
    }
    
    public ChartPanel criarGrafico(ArrayList<Horario> horarios){
        CategoryDataset dtset = this.createDataSet(horarios);
        
        JFreeChart grafico = this.createBarChart(dtset);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
        painelGrafico.setPreferredSize(new Dimension(400, 400));
        
        return painelGrafico;
    }
    
}
