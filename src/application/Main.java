package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

	VLBinarySearchTree bST = new VLBinarySearchTree();

	GridPane grid = new GridPane();


	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane border = new BorderPane();

			// Vertical Box
			VBox vbox = new VBox();
			vbox.setPadding(new Insets(15));
			vbox.setSpacing(8);

			Text title = new Text("Actions");
			title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			vbox.getChildren().add(title);

			Button buttonCurrent = new Button("Load file");
			buttonCurrent.setPrefSize(100, 20);
			buttonCurrent.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> load(primaryStage));

			Button btnShow = new Button("In Order");
			btnShow.setPrefSize(100, 20);
			btnShow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> inOrderPrint());

			Button prePrintNames = new Button("Pre Order");
			prePrintNames.setPrefSize(100, 20);
			prePrintNames.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> prePrintNames());

			Button postPrintNames = new Button("Post Order");
			postPrintNames.setPrefSize(100, 20);
			postPrintNames.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> postPrintNames());

			Button breadthFirstNames = new Button("Breadth First");
			breadthFirstNames.setPrefSize(100, 20);
			breadthFirstNames.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> breadthFirstNames());

			GridPane grid = addGridPane();
			bST.setGrid(grid);

			Text comment = new Text(" ");
			comment.setFill(Color.BLACK);

			ChoiceBox<String> choiceBox = new ChoiceBox();
			choiceBox.setPrefSize(100, 20);
			choiceBox.getItems().addAll("First Name", "Last Name", "First Name Length", "Last Name Length");
			choiceBox.setValue("First Name");

			TextField inputField = new TextField();
			inputField.setPromptText("Search Name Here!");
			inputField.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> inputField.selectAll());
			inputField.setOnKeyReleased(keyEvent -> {
				grid.getChildren().clear();
				switch (choiceBox.getValue())// Switch on choiceBox value
				{

				case "First Name": // Search By First Name

					if (keyEvent.getCode() == KeyCode.ENTER) {

						
						String fName = inputField.getText().toLowerCase();

						List<Person> nameResults = new ArrayList<>();
						ArrayList<Text> nameResultstxt = new ArrayList<Text>();
						bST.searchByFName(bST.root, fName, nameResults);

						for (Person p : nameResults) {
							Text result = new Text(p.getFirstName() + " " + p.getLastName());
							nameResultstxt.add(result);
						}
						int yPos = 0;
						int xPos = 0;

						for (int i = 0; i < nameResultstxt.size(); i++) {
							if (i % 10 == 0) {
								xPos = 0;
								yPos++;
							}

							grid.add(nameResultstxt.get(i), xPos + (i % 10), yPos);
						}

						if (nameResultstxt.size() == 0) {
							grid.getChildren().add(comment);
							comment.setText("Not Found");
						}
					}

					break;

				case "Last Name": // Search By Last Name

					if (keyEvent.getCode() == KeyCode.ENTER) {

						
						String lName = inputField.getText().toLowerCase();

						List<Person> nameResults = new ArrayList<>();
						ArrayList<Text> nameResultstxt = new ArrayList<Text>();
						bST.searchByLName(bST.root, lName, nameResults);

						for (Person p : nameResults) {
							Text result = new Text(p.getFirstName() + " " + p.getLastName());
							nameResultstxt.add(result);
						}
						int yPos = 0;
						int xPos = 0;

						for (int i = 0; i < nameResultstxt.size(); i++) {
							if (i % 10 == 0) {
								xPos = 0;
								yPos++;
							}

							grid.add(nameResultstxt.get(i), xPos + (i % 10), yPos);
						}

						if (nameResultstxt.size() == 0) {
							grid.getChildren().add(comment);
							comment.setText("Not Found");
						}
					}

					break;

				case "First Name Length": // Search By First Name Length

					if (keyEvent.getCode() == KeyCode.ENTER) {

						int length = Integer.parseInt(inputField.getText());
						List<Person> nameLengthResults = new ArrayList<>();
						ArrayList<Text> nameLengthResultstxt = new ArrayList<Text>();
						bST.searchByFNameLength(bST.root, length, nameLengthResults);

						for (Person p : nameLengthResults) {
							Text result = new Text(p.getFirstName() + " " + p.getLastName());
							nameLengthResultstxt.add(result);
						}
						int yPos = 0;
						int xPos = 0;

						for (int i = 0; i < nameLengthResultstxt.size(); i++) {
							if (i % 10 == 0) {
								xPos = 0;
								yPos++;
							}

							grid.add(nameLengthResultstxt.get(i), xPos + (i % 10), yPos);
						}

						if (nameLengthResultstxt.size() == 0) {
							grid.getChildren().add(comment);
							comment.setText("Not Found");
						}

					}

					break;

				case "Last Name Length": // Search By Last Name Length
					if (keyEvent.getCode() == KeyCode.ENTER) {

						
						int length = Integer.parseInt(inputField.getText());
						List<Person> nameLengthResults = new ArrayList<>();
						ArrayList<Text> nameLengthResultstxt = new ArrayList<Text>();
						bST.searchByLNameLength(bST.root, length, nameLengthResults);

						for (Person p : nameLengthResults) {
							Text result = new Text(p.getFirstName() + " " + p.getLastName());
							nameLengthResultstxt.add(result);
						}
						int yPos = 0;
						int xPos = 0;

						for (int i = 0; i < nameLengthResultstxt.size(); i++) {
							if (i % 10 == 0) {
								xPos = 0;
								yPos++;
							}

							grid.add(nameLengthResultstxt.get(i), xPos + (i % 10), yPos);
						}

						if (nameLengthResultstxt.size() == 0) {
							grid.getChildren().add(comment);
							comment.setText("Not Found");
						}

					}

					break;
				}
			});

			choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
				if (newVal != null) {
					inputField.setText("");

				}
			});

			Button clearPane = new Button("Clear Pane");
			grid.getChildren().clear();
			clearPane.setPrefSize(100, 20);
			clearPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> clearPane());

			Button clearBST = new Button("Clear Data"); // for clearing BST in case user wants to re-load a different
														// file
			clearBST.setPrefSize(100, 20);
			clearBST.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> clearBST());

			Hyperlink link1 = new Hyperlink("mswdev.csv");

			link1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {

					try {

						FileInputStream inFile = new FileInputStream("Resources/mswdev.csv");
						Scanner scan = new Scanner(inFile);

						while (scan.hasNext()) {
							String name1 = scan.next();
							String name2 = scan.next();

							Person p = new Person(name1, name2);
							bST.addPerson(p);
						}
						scan.close();

						Alert a = new Alert(AlertType.NONE);
						a.setAlertType(AlertType.CONFIRMATION);
						a.setContentText("File loaded sucessfully!!");
						a.show();

					} catch (IOException e) {
						System.out.println("File Errors");
					}

				}
			});

			Hyperlink link2 = new Hyperlink("more_names.csv");

			link2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {

					try {

						FileInputStream inFile = new FileInputStream("Resources/more_names.csv");
						Scanner scan = new Scanner(inFile);

						while (scan.hasNext()) {
							String name1 = scan.next();
							String name2 = scan.next();

							Person p = new Person(name1, name2);
							bST.addPerson(p);
						}
						scan.close();

						Alert a = new Alert(AlertType.NONE);
						a.setAlertType(AlertType.CONFIRMATION);
						a.setContentText("File loaded succesfully!!");
						a.show();

					} catch (IOException e) {
						System.out.println("File Errors");
					}

				}
			});

			vbox.getChildren().addAll(buttonCurrent, btnShow, prePrintNames, postPrintNames, breadthFirstNames,
					inputField, choiceBox, clearPane, clearBST, link1, link2);

			border.setLeft(vbox);
			border.setCenter(grid);

			grid.setStyle("-fx-background-image:url(\"file:Resources/wallpaper.jpg\");");

			Scene scene = new Scene(border, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inOrderPrint() {

		grid.getChildren().clear();
		bST.inOrderPrintAll();
	}

	public void prePrintNames() {

		grid.getChildren().clear();
		bST.prePrintAll();
	}

	public void postPrintNames() {

		grid.getChildren().clear();
		bST.postPrintAll();
	}

	public void breadthFirstNames() {

		grid.getChildren().clear();
		bST.bFPrintAll();
	}

	public void clearBST() {

		ArrayList<Text> texts = new ArrayList<Text>();
		texts.removeAll(texts);

		grid.getChildren().clear();
		bST.clearAll();

	}

	public void clearPane() {

		ArrayList<Text> texts = new ArrayList<Text>();
		texts.removeAll(texts);

		grid.getChildren().clear();

	}

	public GridPane addGridPane() {

		grid.setStyle("-fx-background-color: #999999;");
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		return grid;
	}

	public void load(Stage primaryStage) {

		try {

			FileChooser fileChooser = new FileChooser();

			File inFile = fileChooser.showOpenDialog(primaryStage);
			Scanner scan = new Scanner(inFile);

			while (scan.hasNext()) {
				String name1 = scan.next();
				String name2 = scan.next();

				Person p = new Person(name1, name2);
				bST.addPerson(p);
			}
			scan.close();

			Alert a = new Alert(AlertType.NONE);
			a.setAlertType(AlertType.CONFIRMATION);
			a.setContentText("File loaded successfully!!");
			a.show();

		} catch (IOException e) {
			System.out.println("File Errors");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
