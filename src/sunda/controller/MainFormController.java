package sunda.controller;

import java.net.URL;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import sunda.util.ChekerHelpingChar;
import sunda.util.LatinTranslator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MainFormController implements Initializable {

	@FXML
	private TextArea inputTextArea;
	public TextArea resultTranslate;
	private Stage stage;
	private List<String> textSundaneseToBeTranslatedList; // struktur data untuk memenggal string unicode per kata
	private List<String> sundaneseCharacterList;
	private List<String> latinCharacterList;
	private int translate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.textSundaneseToBeTranslatedList = new ArrayList<>();
		this.sundaneseCharacterList = new ArrayList<>();
		this.latinCharacterList = new ArrayList<>();
	}

	@FXML
	public void handleNgalagenaToLatin() {
		try {
			translate = 1;
			this.stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane root = (AnchorPane) fxmlLoader
					.load(ClassLoader
							.getSystemResourceAsStream("sunda/view/VirtualKeyBoard.fxml"));
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setX(500);
			stage.setY(450);

			VirtualKeyBoardController virtualKeyBoardController = (VirtualKeyBoardController) fxmlLoader
					.getController();
			virtualKeyBoardController.setInputTextArea(this.inputTextArea);
			virtualKeyBoardController.setStage(stage);
			virtualKeyBoardController.setLatinCharacterList(this.latinCharacterList);
			virtualKeyBoardController
					.setSundaneseCharacterList
					(this.textSundaneseToBeTranslatedList); // passing referensi ke virtualkeyboard controller

			this.resultTranslate.setText("");
			stage.showAndWait();
			stage.sizeToScene();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleTranslateToLatinButton() {
		this.stage.close();
		this.inputTextArea.setEditable(true);
		this.inputTextArea.clear();
		this.resultTranslate.setText("");
		translate = 0;
	}

	@FXML
	public void translateButton() {
		if (translate == 1) {
			LatinTranslator latinTranslator = new LatinTranslator();
			this.latinCharacterList
					.forEach(string -> this.resultTranslate
							.appendText(latinTranslator.translate(string)));
			this.latinCharacterList.clear();
		} else {
			ChekerHelpingChar chekerHelpingChar = new ChekerHelpingChar();
			int stringLenght = inputTextArea.getLength();
			int startString = 0;
			int endString = 1;
			for (int i = 0; i < stringLenght; i++) {
				sundaneseCharacterList.add(chekerHelpingChar
						.cheker(inputTextArea.getText(startString, endString)));
				startString = startString + 1;
				endString = endString + 1;
			}
			sundaneseCharacterList.forEach(text -> resultTranslate
					.appendText(text));
			sundaneseCharacterList.clear();
		}
	}

	@FXML
	public void handleAboutMenuItem() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Stage stage = new Stage();
			AnchorPane root = (AnchorPane) fxmlLoader.load(ClassLoader
					.getSystemResourceAsStream("sunda/view/AboutWindow.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	public void handleExitButton() {
		Platform.exit();
	}

}