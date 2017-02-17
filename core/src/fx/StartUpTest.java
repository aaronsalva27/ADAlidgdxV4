package fx;
import com.badlogic.gdx.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
        try {
            //URL url = new File("core/src/fx/sample.fxml").toURL();
            //getClass().getResource("/sample.fxml")
            //Parent parent = FXMLLoader.load(url);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sample.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent); primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
*/
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);

        Button btn = new Button();
        btn.setText("Lvl");
        btn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }

                        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        System.out.println("btn PLay");

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}