/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.util.ArrayList;
import java.util.List;
import nizekAccountant.logic.DocModels.NormalDoc;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Lenovo
 */
public class CreditorChart extends javax.swing.JFrame {

    List<NormalDoc.DayModel> listD = new ArrayList<>();

//    List<NormalDoc.DayModel> dayModelList = new ArrayList<>();
    public CreditorChart() {

        final CategoryDataset dataset1 = createDataset();

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
                "نمودار تراز", // chart title
                "تاریخ", // domain axis label
                "مبلغ", // range axis label
                dataset1, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips?
                false // URL generator?  Not required...
        );

        //   chart.notify();

        CategoryDataset dataset = createDataset();

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        chart.setBackgroundPaint(Color.white);

    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (NormalDoc.DayModel day : listD) {

            dataset.addValue(day.debt, "بدهکار", day.dateForChart.toString());
            dataset.addValue(day.credit, "بستانکار", day.dateForChart.toString());

        }

        return dataset;

    }

    public void setListD(List<NormalDoc.DayModel> listD) {
        this.listD = listD;

    }

//    private CategoryDataset createDataset1() {
//
//        // row keys...
//        final String series1 = "First";
//        final String series2 = "Second";
//        final String series3 = "Third";
//
//        // column keys...
//        final String category1 = "Category 1";
//        final String category2 = "Category 2";
//        final String category3 = "Category 3";
//        final String category4 = "Category 4";
//        final String category5 = "Category 5";
//        final String category6 = "Category 6";
//        final String category7 = "Category 7";
//        final String category8 = "Category 8";
//
//        // create the dataset...
//        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(1.0, series1, category1);
//        dataset.addValue(4.0, series1, category2);
//        dataset.addValue(3.0, series1, category3);
//        dataset.addValue(5.0, series1, category4);
//        dataset.addValue(5.0, series1, category5);
//        dataset.addValue(7.0, series1, category6);
//        dataset.addValue(7.0, series1, category7);
//        dataset.addValue(8.0, series1, category8);
//
//        dataset.addValue(5.0, series2, category1);
//        dataset.addValue(7.0, series2, category2);
//        dataset.addValue(6.0, series2, category3);
//        dataset.addValue(8.0, series2, category4);
//        dataset.addValue(4.0, series2, category5);
//        dataset.addValue(4.0, series2, category6);
//        dataset.addValue(2.0, series2, category7);
//        dataset.addValue(1.0, series2, category8);
//
//        dataset.addValue(4.0, series3, category1);
//        dataset.addValue(3.0, series3, category2);
//        dataset.addValue(2.0, series3, category3);
//        dataset.addValue(3.0, series3, category4);
//        dataset.addValue(6.0, series3, category5);
//        dataset.addValue(3.0, series3, category6);
//        dataset.addValue(4.0, series3, category7);
//        dataset.addValue(3.0, series3, category8);
//
//        return dataset;
//
//    }

   

    }


