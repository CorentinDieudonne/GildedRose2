package edu.esilv.gilded;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class marchand extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Magic shop");
        Group root = new Group();
        Scene scene = new Scene(root, 450, 250, Color.WHITE);

        Inventory testInventory = new Inventory();
        Item vest = testInventory.getItems()[0];
        Item brie = testInventory.getItems()[1];
        Item elixir = testInventory.getItems()[2];
        Item sulfuras = testInventory.getItems()[3];
        Item backstage = testInventory.getItems()[4];
        Item cake = testInventory.getItems()[5];

        //Creating a button
        Button btn = new Button();
        btn.setLayoutX(320);
        btn.setLayoutY(220);
        btn.setText("Update");

        //Creating a Text object
        Text text = new Text (5, 30, "Available items :");
        Text text0 = new Text (20, 65, "Item{name='"+vest.getName()+"', sellIn="+vest.getSellIn()+", quality="+vest.getQuality()+"}");
        Text text1 = new Text (20, 90, "Item{name='"+brie.getName()+"', sellIn="+brie.getSellIn()+", quality="+brie.getQuality()+"}");
        Text text2 = new Text (20, 115, "Item{name='"+elixir.getName()+"', sellIn="+elixir.getSellIn()+", quality="+elixir.getQuality()+"}");
        Text text3 = new Text (20, 140, "Item{name='"+sulfuras.getName()+"', sellIn="+sulfuras.getSellIn()+", quality="+sulfuras.getQuality()+"}");
        Text text4 = new Text (20, 165, "Item{name='"+backstage.getName()+"', sellIn="+backstage.getSellIn()+", quality="+backstage.getQuality()+"}");
        Text text5 = new Text (20, 190, "Item{name='"+cake.getName()+"', sellIn="+cake.getSellIn()+", quality="+cake.getQuality()+"}");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                testInventory.updateQuality();
                text0.setText("Item{name='"+vest.getName()+"', sellIn="+vest.getSellIn()+", quality="+vest.getQuality()+"}");
                text1.setText("Item{name='"+brie.getName()+"', sellIn="+brie.getSellIn()+", quality="+brie.getQuality()+"}");
                text2.setText("Item{name='"+elixir.getName()+"', sellIn="+elixir.getSellIn()+", quality="+elixir.getQuality()+"}");
                text3.setText("Item{name='"+sulfuras.getName()+"', sellIn="+sulfuras.getSellIn()+", quality="+sulfuras.getQuality()+"}");
                text4.setText("Item{name='"+backstage.getName()+"', sellIn="+backstage.getSellIn()+", quality="+backstage.getQuality()+"}");
                text5.setText("Item{name='"+cake.getName()+"', sellIn="+cake.getSellIn()+", quality="+cake.getQuality()+"}");
            }
        });
        root.getChildren().add(btn);
        root.getChildren().add(text);
        root.getChildren().add(text0);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
