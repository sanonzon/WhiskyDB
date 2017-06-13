package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;


    @Override
    public void start(Stage dummyStage) throws Exception{
        primaryStage = dummyStage;
        Parent root = FXMLLoader.load(getClass().getResource("../Views/DBView.fxml"));


//        setupGui();


        primaryStage.setTitle("Whisky Test");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void setupGui(){
        Button dbInfoButton = new Button("Set DB info");
        dbInfoButton.setOnAction(e->{
            createDbStage();
        });


    }

    public void createDbStage(){
        Stage dbStage = new Stage();
        dbStage.setTitle("DB info");
    }
}
