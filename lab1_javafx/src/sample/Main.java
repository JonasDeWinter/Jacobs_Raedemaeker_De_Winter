package sample;
import Model.CD;
import Model.Film;
import Model.Game;
import Model.Shop;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Shop shop = new Shop();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = createNodeHierarchy();
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane createNodeHierarchy() {
        Button btnAdd = new Button("Add new prduct");
        Button btnShowProduct = new Button("Show specific product");
        Button btnPrice = new Button("Show price from product");
        Button btnAllProducts = new Button("Show all products");
        Button btnReturn = new Button("Return a product");
        Button btnExit = new Button("Exit");
        TilePane p2 = new TilePane();
        p2.setTileAlignment(Pos.CENTER);
        p2.setHgap(20);
        p2.setVgap(20);
        p2.getChildren().addAll(btnAdd, btnShowProduct, btnPrice, btnAllProducts, btnReturn, btnExit);

        Label title = new Label("Choose what you want to do!");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 1.5));
        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);

        p1.getChildren().addAll(title, p2);
        btnAdd.setOnAction(new AddProductHandler());
        btnShowProduct.setOnAction(new ShowProductHandler());
        btnPrice.setOnAction(new ShowPriceHandler());
        btnAllProducts.setOnAction(new ShowAllProductsHandler());
        btnReturn.setOnAction(new ReturnProductHandler());
        btnExit.setOnAction(new ExitHandler(btnExit));
        return p1;
    }

    public void addProduct(Stage primaryStage) throws Exception {
        Pane root = addProductPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane addProductPane() {
        Label lblTitel = new Label("The title of product");
        TextField txtTitel = new TextField();
        Label lblType = new Label("Type of product: M/G or CD");
        TextField txtType = new TextField();
        TilePane p3 = new TilePane();
        p3.setTileAlignment(Pos.CENTER);
        p3.setHgap(20);
        p3.setVgap(20);
        p3.getChildren().addAll(lblTitel, txtTitel, lblType, txtType);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        Button btnVoegToe = new Button("Add product");

        Button btnExit = new Button("exit");
        btnExit.setOnAction(new ExitHandler(btnExit));
        p2.getChildren().addAll(btnVoegToe, btnExit);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        Label title = new Label("Add here a new product");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        p1.getChildren().addAll(title, p3, p2);

        class AddHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String type = txtType.getText();
                String titel = txtTitel.getText();
                System.out.println(type);
                if (!type.equals("M") && !type.equals("G") && !type.equals("C"))
                    throw new IllegalArgumentException("Moet G, M of C zijn");

                if (type.equalsIgnoreCase("M")) {
                    shop.addProduct(new Film(titel));
                } else if (type.equalsIgnoreCase("G")) {
                    shop.addProduct(new Game(titel));
                } else {
                    shop.addProduct(new CD(titel));
                }
                Stage stage = (Stage) btnVoegToe.getScene().getWindow();
                stage.close();
            }
        }
        ;
        btnVoegToe.setOnAction(new AddHandler());
        return p1;
    }

    public void showProduct(Stage primaryStage) throws Exception {
        Pane root = showProductPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane showProductPane() {
        Label lblId = new Label("Give the id of the product");
        TextField txtId = new TextField();
        TilePane p3 = new TilePane();
        p3.setTileAlignment(Pos.CENTER);
        p3.setHgap(20);
        p3.setVgap(20);
        p3.getChildren().addAll(lblId, txtId);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        Button btnShow = new Button("Show product");
        Button btnExit = new Button("exit");
        btnExit.setOnAction(new ExitHandler(btnExit));
        p2.getChildren().addAll(btnShow, btnExit);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        Label title = new Label("Show specific product");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        Label lblResult = new Label();
        Button btnUitlenen = new Button("Uitlenen?");
        Button btnNietUitlene = new Button("Niet uitlenen");
        btnNietUitlene.setVisible(false);
        btnUitlenen.setVisible(false);
        p1.getChildren().addAll(title, p3, p2, lblResult, btnUitlenen, btnNietUitlene);

        class ShowHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String id = txtId.getText();
                int integerid = Integer.parseInt(id);
                lblResult.setText((shop.showProduct(integerid)));
                if (shop.getProducten().showProduct(integerid).getBeschikbaar()) {
                    btnNietUitlene.setVisible(true);
                    btnUitlenen.setVisible(true);
                }
            }
        }

        class UitlenenHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String id = txtId.getText();
                int integerid = Integer.parseInt(id);
                shop.getProducten().showProduct(integerid).wijzigBeschikbaar(false);
                Stage stage = (Stage) btnShow.getScene().getWindow();
                stage.close();
            }
        }

        btnUitlenen.setOnAction(new UitlenenHandler());
        btnShow.setOnAction(new ShowHandler());
        return p1;
    }

    public void showPriceProduct(Stage primaryStage) throws Exception {
        Pane root = showPriceProductPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane showPriceProductPane() {
        Label lbltitle = new Label("Show price product");
        double size = lbltitle.getFont().getSize();
        lbltitle.setFont(new Font(size * 2));
        Label lblId = new Label("Give the id of the product");
        TextField txtId = new TextField();
        Label lblDays = new Label("Give the amount of days");
        TextField txtDays = new TextField();
        TilePane p3 = new TilePane();
        p3.setTileAlignment(Pos.CENTER);
        p3.setHgap(20);
        p3.setVgap(20);
        p3.getChildren().addAll(lblId, txtId, lblDays, txtDays);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        Button btnShow = new Button("Show price");
        Button btnExit = new Button("exit");
        btnExit.setOnAction(new ExitHandler(btnExit));
        p2.getChildren().addAll(btnShow, btnExit);

        VBox p1 = new VBox(8);
        Label lblReslt = new Label();
        lblReslt.setVisible(false);
        p1.getChildren().addAll(lbltitle, p3, p2, lblReslt);

        class ShowProductPriceHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String id = txtId.getText();
                int integerid = Integer.parseInt(id);
                String days = txtDays.getText();
                int integerDays = Integer.parseInt(days);
                double result = shop.showPrice(integerid, integerDays);
                lblReslt.setText(Double.toString(result));
                lblReslt.setVisible(true);
            }
        }

        btnShow.setOnAction(new ShowProductPriceHandler());
        return p1;
    }

    public void showProducts(Stage primaryStage) throws Exception {
        Pane root = showProductsPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane showProductsPane() {
        Label lbltitle = new Label("All products");
        double size = lbltitle.getFont().getSize();
        lbltitle.setFont(new Font(size * 2));
        VBox p1 = new VBox(4);
        p1.setAlignment(Pos.CENTER);
        Label lblResult = new Label();
        lblResult.setText(shop.showProducten());
        Button btnExit = new Button("Exit");
        p1.getChildren().addAll(lbltitle, lblResult,btnExit);
        btnExit.setOnAction(new ExitHandler(btnExit));
        return p1;
    }

    public void ReturnProduct(Stage primaryStage) throws Exception {
        Pane root = ReturnProductPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Shop");
        primaryStage.show();
    }

    private Pane ReturnProductPane() {
        Label lbltitle = new Label("Return a product");
        double size = lbltitle.getFont().getSize();
        lbltitle.setFont(new Font(size * 2));
        Label lblId = new Label("Give the id of the product");
        TextField txtId = new TextField();
        TilePane p5 = new TilePane();
        p5.setTileAlignment(Pos.CENTER);
        p5.setHgap(20);
        p5.setVgap(20);
        p5.getChildren().addAll(lblId, txtId);

        HBox p4 = new HBox(8);
        p4.setAlignment(Pos.CENTER);
        Button btnVerder = new Button("next");
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(new ExitHandler(btnExit));
        p4.getChildren().addAll(btnVerder, btnExit);

        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER);
        p3.getChildren().addAll(p5, p4);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        Label lblterugBrengen = new Label("Do you want to return the product?");
        Button btnYes = new Button("yes");
        Button btnNo = new Button("no");
        btnYes.setVisible(false);
        btnNo.setVisible(false);
        lblterugBrengen.setVisible(false);
        p2.getChildren().addAll(lblterugBrengen, btnYes,btnNo);

        Label lblNiet = new Label();
        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        p1.getChildren().addAll(lbltitle, p3,p2,lblNiet);

        class ReturnHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String id = txtId.getText();
                int integerid = Integer.parseInt(id);
                try {
                    if(!shop.getProducten().showProduct(integerid).getBeschikbaar()) {
                        lblterugBrengen.setVisible(true);
                        btnYes.setVisible(true);
                        btnNo.setVisible(true);
                        lblterugBrengen.setVisible(true);
                    }else{
                        lblNiet.setText("Product is niet uitgeleend");
                    }
                }catch (NullPointerException n){
                    lblNiet.setText("Dit product is nog niet toegevoegd");
                }

            }
        }
        btnVerder.setOnAction(new ReturnHandler());

        class NoHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnNo.getScene().getWindow();
                stage.close();
            }
        }
        btnNo.setOnAction(new NoHandler());

        class YesHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                String id = txtId.getText();
                int integerid = Integer.parseInt(id);
                    shop.getProducten().showProduct(integerid).wijzigBeschikbaar(true);
                Stage stage = (Stage) btnYes.getScene().getWindow();
                stage.close();
            }
        }
        btnYes.setOnAction(new YesHandler());
        return p1;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class AddProductHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Stage test = new Stage();
            try {
                addProduct(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class ShowProductHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Stage test = new Stage();
            try {
                showProduct(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class ShowPriceHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Stage test = new Stage();
            try {
                showPriceProduct(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class ShowAllProductsHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Stage test = new Stage();
            try {
                showProducts(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class ReturnProductHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Stage test = new Stage();
            try {
                ReturnProduct(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ExitHandler implements EventHandler<ActionEvent> {
        Button btn;
        public ExitHandler(Button btnExit) {
            btn = btnExit;
        }

        @Override
        public void handle(ActionEvent event) {
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.close();
        }
    }
}
