package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Main extends Application {
	
	Pane root;
	Scene scene;
	
	TextField tfFirstName, tfMiddleName, tfLastName, tfCompany, tfEmail;
	Button addContact;
	
	TableColumn<Contact, String> firstNameCol, middleNameCol, lastNameCol, companyCol, emailCol;
	TableView<Contact> tv = new TableView<Contact>();
	final ObservableList<Contact> contactsList = FXCollections.observableArrayList();
	
	File contactsFile = new File("src/application/contacts.csv");

	public void loadContactsFile() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(contactsFile));
		
		String st = br.readLine();
		while((st = br.readLine()) != null) {
			String[] split = st.split(",");
			contactsList.add(new Contact(split[2], split[3], split[4], split[0], split[1]));
		}
		
		br.close();
		
	}
	
	public void saveContactsFile() throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(contactsFile));
		
		bw.write("Email,Company,First Name,Middle Name,Last Name\n");
		for(int i = 0; i < contactsList.size(); i++) {
			bw.write(contactsList.get(i).getEmail() + "," + 
					contactsList.get(i).getCompany() + "," + 
					contactsList.get(i).getFirstName() + "," + 
					contactsList.get(i).getMiddleName() + "," +
					contactsList.get(i).getLastName() + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public void loadFxObjects() {
		
		//All JavaFx objects
		tfFirstName = new TextField();
		tfFirstName.setPromptText("First Name*");
		tfFirstName.setPrefHeight(30);
		tfFirstName.setPrefWidth(180);
		tfFirstName.setLayoutX(10);
		tfFirstName.setLayoutY(10);
		root.getChildren().add(tfFirstName);
		
		tfMiddleName = new TextField();
		tfMiddleName.setPromptText("Middle Name");
		tfMiddleName.setPrefHeight(30);
		tfMiddleName.setPrefWidth(180);
		tfMiddleName.setLayoutX(tfFirstName.getLayoutX() + tfFirstName.getPrefWidth() + 5);
		tfMiddleName.setLayoutY(10);
		root.getChildren().add(tfMiddleName);
		
		tfLastName = new TextField();
		tfLastName.setPromptText("Last or Family Name*");
		tfLastName.setPrefHeight(30);
		tfLastName.setPrefWidth(220);
		tfLastName.setLayoutX(tfMiddleName.getLayoutX() + tfMiddleName.getPrefWidth() + 5);
		tfLastName.setLayoutY(10);
		root.getChildren().add(tfLastName);
		
		tfCompany = new TextField();
		tfCompany.setPromptText("Company");
		tfCompany.setPrefHeight(30);
		tfCompany.setPrefWidth(120);
		tfCompany.setLayoutX(10);
		tfCompany.setLayoutY(45);
		root.getChildren().add(tfCompany);
		
		tfEmail = new TextField();
		tfEmail.setPromptText("Email");
		tfEmail.setPrefHeight(30);
		tfEmail.setPrefWidth(240);
		tfEmail.setLayoutX(tfCompany.getLayoutX() + tfCompany.getPrefWidth() + 5);
		tfEmail.setLayoutY(tfCompany.getLayoutY());
		root.getChildren().add(tfEmail);
		
		addContact = new Button("Add Contact");
		addContact.setPrefHeight(30);
		addContact.setPrefWidth(220);
		addContact.setLayoutX(tfEmail.getLayoutX() + tfEmail.getPrefWidth() + 5);
		addContact.setLayoutY(tfEmail.getLayoutY());
		addContact.setOnAction(event -> { 
			
			if(!(tfFirstName.getText().equals("") || tfLastName.getText().equals("") || !(!tfEmail.getText().equals("") || !tfCompany.getText().equals("") || !tfMiddleName.getText().equals("")))) {
			
				contactsList.add(new Contact(
					tfFirstName.getText(),
					tfMiddleName.getText(),
					tfLastName.getText(),
					tfEmail.getText(),
					tfCompany.getText()
				));
				//Add save code to the csv
				tfFirstName.setText("");
				tfMiddleName.setText("");
				tfLastName.setText("");
				tfCompany.setText("");
				tfEmail.setText("");
				
				try { saveContactsFile(); } 
				catch (IOException e) { e.printStackTrace(); }
				
			} else if(!(tfFirstName.getText().equals("") || tfLastName.getText().equals(""))) {
			
				contactsList.add(new Contact(
					tfFirstName.getText(),
					tfLastName.getText()
				));
				//Add save code to the csv
				tfFirstName.setText("");
				tfMiddleName.setText("");
				tfLastName.setText("");
				tfCompany.setText("");
				tfEmail.setText("");
				
				try { saveContactsFile(); } 
				catch (IOException e) { e.printStackTrace(); }
				
			}
			
		}); root.getChildren().add(addContact);
		
		firstNameCol = new TableColumn<Contact, String>("First Name");
        firstNameCol.setMinWidth(90);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
        	    new EventHandler<CellEditEvent<Contact, String>>() {
        	        @Override
        	        public void handle(CellEditEvent<Contact, String> t) {
        	        	
        	        	int row = t.getTablePosition().getRow();
        	        	String newVal = t.getNewValue();
        	            ((Contact) t.getTableView().getItems().get(row)).setFirstName(newVal);
        	            
        	            try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
        	            
        	        }
        	    }
        	);

        middleNameCol = new TableColumn<Contact, String>("Middle Name");
        middleNameCol.setMinWidth(90);
        middleNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("middleName"));
        middleNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        middleNameCol.setOnEditCommit(
        	    new EventHandler<CellEditEvent<Contact, String>>() {
        	        @Override
        	        public void handle(CellEditEvent<Contact, String> t) {
        	        	
        	        	int row = t.getTablePosition().getRow();
        	        	String newVal = t.getNewValue();
        	            ((Contact) t.getTableView().getItems().get(row)).setMiddleName(newVal);
        	            
        	            try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
        	            
        	        }
        	    }
        	);
        
        lastNameCol = new TableColumn<Contact, String>("Last Name");
        lastNameCol.setMinWidth(110);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
        	    new EventHandler<CellEditEvent<Contact, String>>() {
        	        @Override
        	        public void handle(CellEditEvent<Contact, String> t) {
        	        	
        	        	int row = t.getTablePosition().getRow();
        	        	String newVal = t.getNewValue();
        	            ((Contact) t.getTableView().getItems().get(row)).setLastName(newVal);
        	            
        	            try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
        	            
        	        }
        	    }
        	);
 
        companyCol = new TableColumn<Contact, String>("Company");
        companyCol.setMinWidth(100);
        companyCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("company"));
        companyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        companyCol.setOnEditCommit(
        	    new EventHandler<CellEditEvent<Contact, String>>() {
        	        @Override
        	        public void handle(CellEditEvent<Contact, String> t) {
        	        	
        	        	int row = t.getTablePosition().getRow();
        	        	String newVal = t.getNewValue();
        	            ((Contact) t.getTableView().getItems().get(row)).setCompany(newVal);
        	            
        	            try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
        	            
        	        }
        	    }
        	);
        
        emailCol = new TableColumn<Contact, String>("Email");
        emailCol.setMinWidth(195);
        emailCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
        	    new EventHandler<CellEditEvent<Contact, String>>() {
        	        @Override
        	        public void handle(CellEditEvent<Contact, String> t) {
        	        	
        	        	int row = t.getTablePosition().getRow();
        	        	String newVal = t.getNewValue();
        	            ((Contact) t.getTableView().getItems().get(row)).setEmail(newVal);
        	            
        	            try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
        	            
        	        }
        	    }
        	);

		tv.setEditable(true);
        tv.setItems(contactsList);
        tv.getColumns().addAll(firstNameCol, middleNameCol, lastNameCol, companyCol, emailCol);
        tv.setLayoutX(10);
        tv.setLayoutY(80);
        tv.setPrefWidth(590);
        tv.setOnKeyPressed(
        	new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					// TODO Auto-generated method stub
					if(event.getCode() == KeyCode.DELETE) {
						
						contactsList.remove(tv.getSelectionModel().getSelectedItems().get(0));
						
						try { saveContactsFile(); } 
        				catch (IOException e) { e.printStackTrace(); }
						
					}
				}
        	}
        );
        root.getChildren().add(tv);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		root = new Pane();
		scene = new Scene(root,610,490);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Load .csv into the contactsList
		loadContactsFile();

		loadFxObjects();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
