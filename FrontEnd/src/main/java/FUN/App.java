package FUN;

import Animals.Animal;
import Animals.Dog;
import Animals.Gender;
import Animals.TempTestClass;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    GridPane grid = new GridPane();

    private ObservableList<Animal> animals = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"));

        animals.addAll(Animal.getAnimal());
        //GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scene = new Scene(grid, 300, 300);

        Text title = new Text("Animal Shelter");
        title.setFont(Font.font("Arial", FontWeight.NORMAL,20));

        grid.add(title, 0, 0, 2, 1);

        Label name = new Label("Name of animal:");
        grid.add(name, 0, 1);

        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label gender = new Label("Gender:");
        grid.add(gender, 0,2);

        ChoiceBox genderCB = new ChoiceBox(FXCollections.observableArrayList("Male", "Female"));
        grid.add(genderCB, 1, 2);

        Button btn = new Button("Add animal");
        HBox hbBtn = new HBox(10);

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        ListView listView = new ListView(animals);

        grid.add(listView, 1, 5);

        btn.setOnAction(actionEvent -> {
            Animal dog = new Dog(nameTextField.getText(), Gender.valueOf(genderCB.getValue().toString()));
            animals.add(dog);
        });

        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}