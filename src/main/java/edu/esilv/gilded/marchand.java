package edu.esilv.gilded;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class marchand extends Application {

    public int compteurSellIn=0;
    public int compteurBuy=0;

    public int getCompteurSellIn() {
        return compteurSellIn;
    }

    public void setCompteurSellIn(int compteurSellIn) {
        this.compteurSellIn = compteurSellIn;
    }

    public int getCompteurBuy() {
        return compteurBuy;
    }

    public void setCompteurBuy(int compteurBuy) {
        this.compteurBuy = compteurBuy;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Magic shop");
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));

        Inventory inventory = new Inventory();
        Scene scene = new Scene(root, 670, 500, Color.WHITE);

        Button btnUpdate = new Button();
        btnUpdate.setTranslateX(275);
        btnUpdate.setTranslateY(-180);
        btnUpdate.setText("Update");

        Button btnPiechart = new Button();
        btnPiechart.setTranslateX(275);
        btnPiechart.setTranslateY(-90);
        btnPiechart.setText("PieChart");

        Button btnSellIn = new Button();
        btnSellIn.setTranslateX(275);
        btnSellIn.setTranslateY(-30);
        btnSellIn.setText("SellIn Barchart");

        Button btnLoad =new Button();
        btnLoad.setTranslateX(275);
        btnLoad.setTranslateY(-150);
        btnLoad.setText("Load File");
        Label chosen = new Label();

        Button btnDate =new Button();
        btnDate.setTranslateX(275);
        btnDate.setTranslateY(-60);
        btnDate.setText("Date Barchart");

        Button btnSell =new Button();
        btnSell.setTranslateX(275);
        btnSell.setTranslateY(-120);
        btnSell.setText("Vendre");

        Button btnBuy = new Button();
        btnBuy.setTranslateX(275);
        btnBuy.setTranslateY(0);
        btnBuy.setText("Buy");

        Button btnBarchartXY = new Button();
        btnBarchartXY.setTranslateX(250);
        btnBarchartXY.setTranslateY(30);
        btnBarchartXY.setText("Barchart Sells and Buys");

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


        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                inventory.itemlegacy();
                inventory.updateQuality();
                ObservableList<Item> itemlistup = FXCollections.observableArrayList(inventory.getItems());
                table.setItems(itemlistup);
                table.refresh();

            }
        });
        btnBuy.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Scene scene = new Scene(new Group());
                stage.setTitle("Buy");
                stage.setWidth(500);
                stage.setHeight(500);
                ComboBox comboBox = new ComboBox<>();
                comboBox.getItems().addAll("+5 Dexterity Vest",
                        "Aged Brie",
                        "Elixir of the Mongoose",
                        "Sulfuras, Hand of Ragnaros",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Conjured Mana Cake");
                comboBox.setPromptText("Choose an item to Buy");
                ((Group) scene.getRoot()).getChildren().add(comboBox);
                stage.setScene(scene);
                stage.show();




            }
        });
        btnBarchartXY.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                Stage stage = new Stage();
                stage.setTitle("Number of items sold and bought");
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
                bc.setTitle("Number of items sold and bought");
                xAxis.setLabel("Date");
                yAxis.setLabel("Number of item sold");

                LocalDateTime maxDate= inventory.getItems()[0].getDate(), minDate= inventory.getItems()[0].getDate();
                for (int i = 0; i < inventory.getItems().length; i++) {
                    if (inventory.getItems()[i].getDate().compareTo(maxDate)>0){maxDate=inventory.getItems()[i].getDate();}
                    if (inventory.getItems()[i].getDate().compareTo(minDate)<0){minDate=inventory.getItems()[i].getDate();}
                }

                int tailleTab = inventory.getItems().length+1;


                for (int i = 0; i < inventory.getItems().length-1; i++) {
                    for (int j = i+1; i < inventory.getItems().length; i++) {
                        if (inventory.getItems()[i].getDate().compareTo(inventory.getItems()[j].getDate()) == 0) {
                            tailleTab--;
                        }
                    }
                }
                LocalDateTime [] tabDate = new LocalDateTime[tailleTab];
                int [] tabCompteur = new int [tailleTab];
                tabDate[0]=minDate;

                for (int i = 1; i<tailleTab; i++)
                {
                    LocalDateTime tempDate = maxDate;
                    for (int j = 0; j < inventory.getItems().length; j++)
                    {
                        if (inventory.getItems()[j].getDate().compareTo(minDate) > 0 && inventory.getItems()[j].getDate().compareTo(tempDate)<0){
                            tempDate=inventory.getItems()[j].getDate();
                        }
                    }
                    tabDate[i]=tempDate;
                    minDate=tempDate;
                }


                DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");



            }
        });


        btnPiechart.setOnAction(new EventHandler<ActionEvent>() {
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

                final PieChart chart = new PieChart(pieChartData);
                chart.setTitle("Item repartition");

                ((Group) scene.getRoot()).getChildren().add(chart);
                stage.setScene(scene);
                stage.show();
            }
        });



        btnSellIn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();

                    stage.setTitle("Number of items by SellIn");
                    final CategoryAxis xAxis = new CategoryAxis();
                    final NumberAxis yAxis = new NumberAxis();
                    final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
                    bc.setTitle("Number of items by SellIn");
                    xAxis.setLabel("SellIn");
                    yAxis.setLabel("Number of item");


                    int maxSellIn=0, minSellIn=0;
                    for (int i = 0; i < inventory.getItems().length; i++) {
                        if (inventory.getItems()[i].getSellIn()>maxSellIn){maxSellIn=inventory.getItems()[i].getSellIn();}
                        if (inventory.getItems()[i].getSellIn()<minSellIn){minSellIn=inventory.getItems()[i].getSellIn();}
                    }

                    int tailleTab = maxSellIn-minSellIn+1;
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
                        series1.getData().add(new XYChart.Data(Integer.toString(i+minSellIn), tabSellIn[i]));
                    }

                    Scene scene  = new Scene(bc,800,600);
                    bc.getData().addAll(series1);
                    stage.setScene(scene);
                    stage.show();
            }
        });


        btnDate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Number of items by Date");
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
                bc.setTitle("Number of items by Date");
                xAxis.setLabel("Date");
                yAxis.setLabel("Number of item");

                LocalDateTime maxDate= inventory.getItems()[0].getDate(), minDate= inventory.getItems()[0].getDate();
                for (int i = 0; i < inventory.getItems().length; i++) {
                    if (inventory.getItems()[i].getDate().compareTo(maxDate)>0){maxDate=inventory.getItems()[i].getDate();}
                    if (inventory.getItems()[i].getDate().compareTo(minDate)<0){minDate=inventory.getItems()[i].getDate();}
                }


                int tailleTab = inventory.getItems().length+1;


                for (int i = 0; i < inventory.getItems().length-1; i++) {
                    for (int j = i+1; i < inventory.getItems().length; i++) {
                        if (inventory.getItems()[i].getDate().compareTo(inventory.getItems()[j].getDate()) == 0) {
                            tailleTab--;
                        }
                    }
                }

                LocalDateTime [] tabDate = new LocalDateTime[tailleTab];
                int [] tabCompteur = new int [tailleTab];
                tabDate[0]=minDate;

                for (int i = 1; i<tailleTab; i++)
                {
                    LocalDateTime tempDate = maxDate;
                    for (int j = 0; j < inventory.getItems().length; j++)
                    {
                        if (inventory.getItems()[j].getDate().compareTo(minDate) > 0 && inventory.getItems()[j].getDate().compareTo(tempDate)<0){
                            tempDate=inventory.getItems()[j].getDate();
                        }
                    }
                    tabDate[i]=tempDate;
                    minDate=tempDate;
                }

                for (int i = 0; i<tailleTab; i++)
                {
                    int compteur = 0;
                    for (int j = 0; j < inventory.getItems().length; j++)
                    {
                        String a = inventory.getItems()[j].getDate().toString();
                        if (inventory.getItems()[j].getDate().compareTo(tabDate[i]) == 0)
                        {
                            compteur = compteur + 1;
                        }
                    }
                    tabCompteur[i]=compteur;
                }

                DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


                XYChart.Series series1 = new XYChart.Series();
                for (int i = 0; i<tailleTab; i++)
                {
                    String formattedString = tabDate[i].format(aFormatter);
                    series1.getData().add(new XYChart.Data(formattedString, tabCompteur[i]));
                }

                Scene scene  = new Scene(bc,800,600);
                bc.getData().addAll(series1);
                stage.setScene(scene);
                stage.show();
            }
        });

        btnLoad.setOnAction(event -> {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                String fileAsString = file.toString();
                Item [] items=json.jsonrecup(fileAsString);
                chosen.setText("Chosen: " + fileAsString);
                Item [] itemsconca=new Item[items.length+inventory.items.length];
                int i=0; int j=0,k=0;
                while (j<items.length && i<itemsconca.length){
                    itemsconca[i]=items[j];
                    i++; j++;
                }
                while (k<inventory.items.length &&i<itemsconca.length){
                    itemsconca[i]=inventory.items[k];
                    i++; k++;
                }
                inventory.items=itemsconca;
                List<Item> liste= Arrays.asList(itemsconca);
                ObservableList<Item> liste2=FXCollections.observableArrayList(liste);
                table.setItems(liste2);
                table.refresh();

            } else {
                chosen.setText(null);
            }

        });


        btnSell.setOnAction(e -> {
            Item selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem.getName() != "Sulfuras, Hand of Ragnaros") {
                table.getItems().remove(selectedItem);
                ArrayList<Item> foo = new ArrayList<Item>(table.getItems());
                Object[] foo2=foo.toArray();
                Item[] itemp=new Item[inventory.items.length-1];
                setCompteurSellIn(compteurSellIn+1);
                for(int i=0;i<itemp.length;i++)
                {
                    itemp[i]=(Item)foo2[i];
                }
                inventory.items=itemp;

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Can't Sell That");
                alert.setContentText("One can not simply sell Sulfuras, Hand of Ragnaros");
                alert.show();


            }
        });

        root.getChildren().add(table);
        root.getChildren().add(btnUpdate);
        root.getChildren().add(btnBuy);
        root.getChildren().add(btnPiechart);
        root.getChildren().add(btnSellIn);
        root.getChildren().add(btnSell);
        root.getChildren().add(btnLoad);
        root.getChildren().add(btnDate);
        root.getChildren().add(btnBarchartXY);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
