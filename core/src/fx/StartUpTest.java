package fx;
import com.badlogic.gdx.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import samuel.Samuel;
import screens.GameScreen;
import stages.GameStage;
import utils.Constants;
import utils.LecturaFichero;


import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.concurrent.CountDownLatch;


public class StartUpTest extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static StartUpTest startUpTest = null;

    public static StartUpTest waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startUpTest;
    }

    public static void setStartUpTest(StartUpTest startUpTest0) {
        startUpTest = startUpTest0;
        latch.countDown();
    }

    public StartUpTest() {
        setStartUpTest(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
/*
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
*/
        Button btn1 = new Button();
        btn1.setText("Easy");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LecturaFichero.setFichero("easy.txt");
            }
        });
        Button btn2 = new Button();
        btn2.setText("Medium");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LecturaFichero.setFichero("medium.txt");
            }
        });
        Button btn3 = new Button();
        btn3.setText("Hardcore");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LecturaFichero.setFichero("hardcore.txt");
            }
        });
        StackPane root = new StackPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Samuel v0.4");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        Label pw = new Label("Select Level:");
        grid.add(pw, 0, 1);

        grid.add(btn1, 0, 2);
        grid.add(btn2, 0, 3);
        grid.add(btn3, 0, 4);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}