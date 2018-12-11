package edu.esilv.gilded;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class marchand extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Magic shop");
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));

        Inventory inventory = new Inventory();
        Scene scene = new Scene(root, 650, 500, Color.WHITE);
        //Creating a button
        Button btn = new Button();
        btn.setTranslateX(275);
        btn.setTranslateY(-180);
        btn.setText("Update");

        Button btn2 = new Button();
        btn2.setTranslateX(275);
        btn2.setTranslateY(-150);
        btn2.setText("PieChart");

        Button btn3 = new Button();
        btn3.setTranslateX(275);
        btn3.setTranslateY(-120);
        btn3.setText("Barchart");

        Button VendreButton =new Button();
        VendreButton.setTranslateX(275);
        VendreButton.setTranslateY(-60);
        VendreButton.setText("Vendre");



        //Creating a TableView
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> namecol //
                = new TableColumn<>("Item Name");
        TableColumn<Item, String> qualitycol //
                = new TableColumn<>(" Quality");
        TableColumn<Item, String> sellIncol //
                = new TableColumn<>(" sellIn");
        TableColumn<Item, String> datecol //
                = new TableColumn<>(" date");

        //adding our column to the table
        table.getColumns().addAll(namecol, qualitycol, sellIncol, datecol);

        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        qualitycol.setCellValueFactory(new PropertyValueFactory<>("quality"));
        sellIncol.setCellValueFactory(new PropertyValueFactory<>("sellIn"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        ObservableList<Item> itemlist = FXCollections.observableArrayList(inventory.getItems());
        table.setItems(itemlist);


        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                inventory.itemlegacy();
                inventory.updateQuality();
                ObservableList<Item> itemlistup = FXCollections.observableArrayList(inventory.getItems());
                table.setItems(itemlistup);
                table.refresh();

            }
        });



        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Scene scene = new Scene(new Group());
                stage.setTitle("Item repartition");
                stage.setWidth(500);
                stage.setHeight(500);


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
        });

        VendreButton.setOnAction(e -> {
                    Item selectedItem = table.getSelectionModel().getSelectedItem();
                    if (selectedItem.getName() != "Sulfuras, Hand of Ragnaros") {
                        table.getItems().remove(selectedItem);
                        ArrayList<Item> foo = new ArrayList<Item>(table.getItems());
                        Object[] foo2=foo.toArray();
                        Item[] itemp=new Item[inventory.items.length-1];
                        for(int i=0;i<itemp.length;i++)
                        {
                            itemp[i]=(Item)foo2[i];
                        }
                        inventory.items=itemp;

                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Can't Sell That");
                        alert.setContentText("One can not simply sell Sulfuras, Hand of Ragnaros");
                        alert.show();


                    }
                });



        btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Scene scene = new Scene(new Group());
                stage.setTitle("BARCHART");
                stage.setWidth(500);
                stage.setHeight(500);
                stage.setScene(scene);
                stage.show();
            }
        });

        root.getChildren().add(table);
        root.getChildren().add(btn);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(VendreButton);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
