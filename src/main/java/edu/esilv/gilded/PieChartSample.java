package edu.esilv.gilded;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class PieChartSample extends Application {

    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Item repartition");
        stage.setWidth(500);
        stage.setHeight(500);

        Inventory inventory = new Inventory();
        int countBrie=0, countConcert=0, countVest=0, countElixir=0, countCake=0, countRagnaros=0;

        for (int i = 0; i < inventory.getItems().length; i++) {
            if (inventory.getItems()[i].getName().equals("Aged Brie")){countBrie++;}
            if (inventory.getItems()[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){countConcert++;}
            if (inventory.getItems()[i].getName().equals("+5 Dexterity Vest")){countVest++;}
            if (inventory.getItems()[i].getName().equals("Elixir of the Mongoose")){countElixir++;}
            if (inventory.getItems()[i].getName().equals("Conjured Mana Cake")){countCake++;}
            if (inventory.getItems()[i].getName().equals("Sulfuras, Hand of Ragnaros")){countRagnaros++;}
        }


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("AgedBrie", countBrie),
                        new PieChart.Data("Concert passes", countConcert),
                        new PieChart.Data("Dexterity vest", countVest),
                        new PieChart.Data("Elixir", countElixir),
                        new PieChart.Data("ManaCake", countCake),
                        new PieChart.Data("Ragnaros", countRagnaros));
        /*new PieChart.Data(Integer.toString(countBrie), countBrie),
                        new PieChart.Data(Integer.toString(countConcert), countConcert),
                        new PieChart.Data(Integer.toString(countVest), countVest),
                        new PieChart.Data(Integer.toString(countElixir), countElixir),
                        new PieChart.Data(Integer.toString(countCake), countCake),
                        new PieChart.Data(Integer.toString(countRagnaros), countRagnaros));*/
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Item repartition");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}