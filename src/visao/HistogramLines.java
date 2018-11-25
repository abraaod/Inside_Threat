/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ValueRange;
import javafx.scene.chart.Chart;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Henrique
 */
public class HistogramLines extends ApplicationFrame implements ActionListener{

    private XYPlot plot;
    private int datasetIndex = 0;
    
    public HistogramLines(String title, String role) {
        super(title);
        
        final TimeSeriesCollection dataset1 = createRandomDatabase("Usuário 1");
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Papel: " + role, "Horário", "Ações dos Usuários", dataset1, true, false, false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.getLegend().setItemLabelPadding(new RectangleInsets(5.0, 2.0, 10.0, 10));
        chart.getLegend().setPadding(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        chart.setBackgroundPaint(Color.white);
        
        
        this.plot = chart.getXYPlot();
        this.plot.setBackgroundPaint(Color.white);
        this.plot.setDomainGridlinePaint(Color.white);
        this.plot.setRangeGridlinePaint(Color.white);
        this.plot.setOutlineVisible(false);
        this.plot.getRenderer().setSeriesStroke(0, new BasicStroke(2));
        
        
        final ValueAxis axis = this.plot.getDomainAxis();
        axis.setAutoRange(true);
        
        final NumberAxis rangeAxis2 = new NumberAxis("Range Axis 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        
        final JPanel content = new JPanel(new BorderLayout());
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        
        chartPanel.setPreferredSize(new Dimension(1100, 470));
        setContentPane(content);
        
        this.plot.setDataset(1, createRandomDatabase("Usuário 2"));
        this.plot.getRenderer().setSeriesPaint(1, Color.BLACK);
        this.plot.getRenderer().setSeriesStroke(1, new BasicStroke(3));
        this.plot.setRenderer(1, new StandardXYItemRenderer());
        
        
    }
    
    private TimeSeriesCollection createRandomDatabase(final String name){
        final TimeSeries series = new TimeSeries(name);
        double value = 100.0;
        RegularTimePeriod t = new Hour(0, new Day());
        for(int i =0; i < 24; i++){
            series.add(t, value);
            t = t.next();
            value = value * (1.0 + Math.random() / 100);
        }
        
        return new TimeSeriesCollection(series);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
