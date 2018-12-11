package edu.esilv.gilded;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartSample extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Number of items by SellIn");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Number of items by SellIn");
        xAxis.setLabel("SellIn");
        yAxis.setLabel("Number of item");


        Inventory inventory = new Inventory();

        int maxSellIn=0, minSellIn=0;
        for (int i = 0; i < inventory.getItems().length; i++) {
            if (inventory.getItems()[i].getSellIn()>maxSellIn){maxSellIn=inventory.getItems()[i].getSellIn();}
            if (inventory.getItems()[i].getSellIn()<minSellIn){minSellIn=inventory.getItems()[i].getSellIn();}
        }

        int tailleTab = maxSellIn-minSellIn;
        int [] tabSellIn = new int [tailleTab];
        for (int i = 0; i<tailleTab; i++)
        {
            for (int j = 0; j < inventory.getItems().length; j++)
            {
                if (i-minSellIn == inventory.getItems()[j].getSellIn())
                {
                    tabSellIn[i]++;
                }
            }
        }

        XYChart.Series series1 = new XYChart.Series();

        for (int i = 0; i<tailleTab; i++)
        {
            series1.getData().add(new XYChart.Data(Integer.toString(i-minSellIn), tabSellIn[i]));
        }

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}