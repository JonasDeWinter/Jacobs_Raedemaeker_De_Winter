package sample;

import Model.Auditor;
import Model.Bank;
import Model.Rekening;
import Model.RekeningLogger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Bank bank = new Bank("bank");
        Auditor auditor = new Auditor(bank);
        RekeningLogger rekeningLogger = new RekeningLogger(bank);

        Rekening rekening1 = new Rekening("BE6451615",0.2, LocalDate.now());
        Rekening rekening2 = new Rekening("BE6451615",12000, LocalDate.now());

        bank.addRekening(rekening2);
        bank.addRekening(rekening1);
        bank.opnemen(rekening1, 0.1);
        bank.storten(rekening1,10000);
    }
}
