package com.example.Controllers;

import com.example.DeliveryInfoObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CustomerInfoPageController {
    @FXML
    TextField nameTextField;
    @FXML
    TextField addressTextField;
    @FXML
    TextField deliveryTextFeild;
    @FXML
    RadioButton deliveryTypeD;
    @FXML
    RadioButton deliveryTypeP;
    @FXML
    Button continueButton;
    @FXML
    Label IDLabel;
    @FXML
    Label warningLabel;

    private Parent root;
    private Stage stage;
    private  Scene scene;
    private String address;
    private String customerName;
    private String deliveryInfo;
    private String deliveryType;





    public void setDelp(){
        deliveryTypeP.setSelected(true);
        deliveryTypeD.setSelected(false);
        deliveryType="Pickup";
    }
    public void setDeld(){
        deliveryTypeD.setSelected(true);
        deliveryTypeP.setSelected(false);
        deliveryType="Delivery";
    }

    public void checkButtons(){
        if(deliveryType==null){
            warningLabel.setText("please select a delivery type");
            return;
        }else if(addressTextField.getText()==null){
            warningLabel.setText("please enter an address");
            return;
        }
    }

    public void saveCustomerDetails() throws IOException{
        checkButtons();

        stage = (Stage)((Node)IDLabel).getScene().getWindow();


        String databaseURL ="jdbc:ucanaccess://C:/Users/hitsf/IdeaProjects/GroupProject/PizzaProject.accdb";
        //gets the username and password from database

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            PreparedStatement addAddStatement;
            String SQLUpdate = "UPDATE CUSTOMER SET Address = ? WHERE Username = ? AND Password = ?";
            addAddStatement = connection.prepareStatement(SQLUpdate);
            addAddStatement.setString(1, addressTextField.getText());

            String userData = (String) stage.getUserData();
            //sets userdata to the info from customerLoginController's stage.setUserData

            String[] arr = userData.split("-");




            String customerUsername = arr[0];
            String customerPassword = arr[1];

            addAddStatement.setString(2,customerUsername);
            addAddStatement.setString(3,customerPassword);
            addAddStatement.executeUpdate();
            address=addressTextField.getText();
            deliveryInfo=deliveryTextFeild.getText();

            DeliveryInfoObject customerInfo = new DeliveryInfoObject(address, deliveryInfo, deliveryType);

            stage.setUserData(customerInfo);

            switchToOrderView1();

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void switchToOrderView1() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/FXMLfiles/OrderView1.fxml"));
        stage = (Stage)((Node)IDLabel).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





}
