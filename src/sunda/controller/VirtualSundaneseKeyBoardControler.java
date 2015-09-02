package sunda.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VirtualSundaneseKeyBoardControler implements Initializable {
	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}

	public void latinVirtualKeyboard() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Stage stage = new Stage();
			AnchorPane firstVirtualKeyboard = fxmlLoader.load(ClassLoader.getSystemResourceAsStream("sunda/view/VirtualKeyBoard.fxml"));
			Scene scene = new Scene(firstVirtualKeyboard);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
			stage.setX(550);
			stage.setY(450);
			this.stage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void handleSubmitButton() {
		this.stage.close();
	}
}
