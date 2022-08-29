package com.example.groupproject;

import java.sql.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    String databaseURL = "jdbc:ucanaccess://C:/Users//baile//OneDrive - Kennesaw State University//Fall 2022//SWE//demo//SWE Project.accdb";



    @Override
    public void start(Stage stage) throws IOException {
        GridPane myGrid = new GridPane();
        Scene myScene = new Scene(myGrid,400,300);

        Label header = new Label("Best Pizza");



        TextField phoneCheckText = new TextField();

        myGrid.add(phoneCheckText,1,1);




        myGrid.add(header,7,0);








       //creates the button
        Button checkPhoneNumberButton = new Button("Check Phone Number");
        //this is the action when the button is pressed
        checkPhoneNumberButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if statement searching database for phone#
                try (Connection connection = DriverManager.getConnection(databaseURL)) {
                    PreparedStatement myStatement;
                    String SQLQuery="SELECT PhoneNumber, FullName, Address, DeliveryInfo FROM Customers WHERE PhoneNumber IS NOT NULL AND PhoneNumber='?';";
                    myStatement = connection.prepareStatement(SQLQuery);
                    //sets above sql query to the customer phone number at first question mark(not sure about if its first column or first mark)
                    myStatement.setInt(1,Integer.valueOf(phoneCheckText.getText()));
                    //makes a result set to retrieve matching results from the database
                    ResultSet myRS = myStatement.executeQuery();
                    //sets customer to local variables for the searched phone number
                    while(myRS.next()){
                        Long CustomerPhoneNumber =myRS.getLong("PhoneNumber");
                        String CustomerFullName = myRS.getString("FullName");
                        String CustomerAddress = myRS.getString("Address");
                        String CustomerDeliveryInfo = myRS.getString("DeliveryInfo");


                    }



                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        myGrid.add(checkPhoneNumberButton,7,1);










        //adds the stage/scene and runs
        stage.setScene(myScene);
        stage.show();




    }

    public static void main(String[] args) {
        launch();
    }
}