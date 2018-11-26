/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dominio.Analyzer;
import dominio.User;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.event.AnnotationChangeListener;
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
public class HistogramLines extends JFrame implements ActionListener {

    private XYPlot plot;
    private int datasetIndex = 0;

    public HistogramLines(String title, User user1, User user2) {
        super(title);
        String role_ = "Role: ";
        if (user2 != null) {

            if (user1.getRole().equals(user2.getRole())) {
                role_ += user1.getRole();
            } else {
                role_ += user1.getRole() + " and " + user2.getRole();
            }
        } else {
            role_ = "Role: " + user1.getRole();
        }
        
        final TimeSeriesCollection dataset1 = createDatabase(user1);
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                role_, "Horário", "Ações dos Usuários", dataset1, true, false, false);
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

        if (user2 != null) {
            this.plot.setDataset(1, createDatabase(user2));
        }
        this.plot.getRenderer().setSeriesPaint(1, Color.BLACK);
        this.plot.getRenderer().setSeriesStroke(1, new BasicStroke(3));
        this.plot.setRenderer(1, new StandardXYItemRenderer());

    }

    private TimeSeriesCollection createDatabase(User user1) {
        final TimeSeries series = new TimeSeries(user1.getId());
        int[] hist = user1.getHist();
        RegularTimePeriod t = new Hour(0, new Day());
        for (int i = 0; i < 24; i++) {
            series.add(t, hist[i]);
            t = t.next();
        }

        return new TimeSeriesCollection(series);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
