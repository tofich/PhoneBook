package sprav;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX sprav.App
 */
public class App extends Application {

    private Controller controllerMainForm;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mainForm.fxml"));
        Parent root = loader.load();
        controllerMainForm = loader.getController();
        primaryStage.getIcons().add(new Image("favicon.ico"));
        primaryStage.setTitle("Телефонный справочник 1.0");
        Scene scene = new Scene(root);
        scene.getStylesheets().add( App.class.getClassLoader().getResource( "main.css" ).toExternalForm() );
        primaryStage.setScene(scene);
        primaryStage.show();
        controllerMainForm.initTableView();
        controllerMainForm.initListener();
    }

    @Override
    public void stop(){
        try {
            super.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(controllerMainForm != null)
        {
            controllerMainForm.disconnect();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}