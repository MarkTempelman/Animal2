package FUN;

import Animals.*;
import Serialization.AnimalSerializer;
import Serialization.IAnimalSerializer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    GridPane grid = new GridPane();
    private IAnimalSerializer animalSerializer = new AnimalSerializer();

    private ObservableList<Animal> animals = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"));

        animals.addAll(Animal.getAnimals(animalSerializer));
        //GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scene = new Scene(grid, 500, 500);

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

        Label animalType = new Label("Animal type:");
        grid.add(animalType, 0,3);

        ChoiceBox animalTypeCB = new ChoiceBox(FXCollections.observableArrayList("Dog", "Cat"));
        grid.add(animalTypeCB, 1, 3);

        Label badHabits = new Label("Bad habits:");
        grid.add(badHabits, 0, 4);

        TextField badHabitsTextField = new TextField();
        grid.add(badHabitsTextField, 1, 4);

        Button btn = new Button("Add animal");
        grid.add(btn, 1, 5);

        ListView listView = new ListView(animals);

        grid.add(listView, 1, 6, 2, 3);

        btn.setOnAction(actionEvent -> {
            Animal animal;
            if(animalTypeCB.getValue() == "Dog"){
                animal = new Dog(nameTextField.getText(), Gender.valueOf(genderCB.getValue().toString()), animalSerializer);
            } else {
                animal = new Cat(nameTextField.getText(), Gender.valueOf(genderCB.getValue().toString()), badHabitsTextField.getText());
            }
            animal.setPrice(animal.calculatePrice());
            animalSerializer.saveAnimal(animal);
            animals.add(animal);
        });

        Label reservorName = new Label("Name:");
        grid.add(reservorName, 0, 10);

        TextField reservorTextField = new TextField();
        grid.add(reservorTextField, 1, 10);

        Button reservorBtn = new Button("Reserve");

        grid.add(reservorBtn, 1, 11);

        reservorBtn.setOnAction(actionEvent -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            animals.get(index).reserve(reservorTextField.getText());
            ArrayList<Animal> exportAnimals = new ArrayList<>();
            exportAnimals.addAll(animals);
            animalSerializer.saveAllAnimals(exportAnimals);
            listView.refresh();
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