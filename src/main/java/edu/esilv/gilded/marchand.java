package edu.esilv.gilded;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        Scene scene = new Scene(root, 450, 300, Color.WHITE);
        //Creating a button
        Button btn = new Button();
        btn.setTranslateX(170);
        btn.setTranslateY(35);


        btn.setText("Update");
        //Creating a TableView

        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> namecol //
                = new TableColumn<>("Item Name");
        TableColumn<Item, String> qualitycol //
                = new TableColumn<>(" Quality");
        TableColumn<Item, String> sellIncol //
                = new TableColumn<>(" sellIn");

        //adding our column to the table
        table.getColumns().addAll(namecol, qualitycol, sellIncol);

        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        qualitycol.setCellValueFactory(new PropertyValueFactory<>("quality"));
        sellIncol.setCellValueFactory(new PropertyValueFactory<>("sellIn"));
        ObservableList<Item> itemlist= FXCollections.observableArrayList(inventory.getItems());
        table.setItems(itemlist);







        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                inventory.updateQuality();
                ObservableList<Item> itemlistup= FXCollections.observableArrayList(inventory.getItems());
                table.setItems(itemlistup);
                table.refresh();

            }
        });

        root.getChildren().add(table);
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
