package fx;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import servidor.MapPartidas;
import utils.LecturaFichero;


import java.util.concurrent.CountDownLatch;


public class StartUpTest extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static StartUpTest startUpTest = null;

    public static void setStartUpTest(StartUpTest startUpTest0) {
        startUpTest = startUpTest0;
        latch.countDown();
    }

    public StartUpTest() {
        setStartUpTest(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text t = new Text();
        t.setFont(new Font(20));
        t.setWrappingWidth(200);
        t.setTextAlignment(TextAlignment.JUSTIFY);
        t.setText("Partidas:");
        Text tpuntos = new Text();

        Task dynamicTimeTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {
                    updateMessage(String.valueOf(MapPartidas.getObjPartids()));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
                return null;
            }
        };
        tpuntos.textProperty().bind(dynamicTimeTask.messageProperty());
        Thread t2 = new Thread(dynamicTimeTask);
        t2.setName("Tesk Time Updater");
        t2.setDaemon(true);
        t2.start();

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

        Scene scene = new Scene(grid, 350, 600);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Samuel v0.4");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        Label pw = new Label("Select Level:");
        grid.add(pw, 0, 1);

        grid.add(btn1, 0, 2);
        grid.add(btn2, 0, 3);
        grid.add(btn3, 0, 4);

        grid.add(t,0,5);
        grid.add(tpuntos,0,6);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}