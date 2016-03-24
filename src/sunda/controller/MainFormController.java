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
import sunda.util.ChekHanacaraka;
import sunda.util.TranslatorFromInputUser;
import sunda.util.TranslatorFromSundaneseFont;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainFormController implements Initializable {
	@FXML
	private int translate = 0;
	public TextArea inputTextArea;
	public TextArea resultTranslate;
	private Stage stage;
	private List<String> sundaneseCharList;
	private List<String> textSundaneseToBeTranslatedList;
	/*
	 * struktur data untuk menyimpan string unicode per kata
	 */

	@FXML
	private Text modeTranslatingText;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.textSundaneseToBeTranslatedList = new ArrayList<>();
		this.sundaneseCharList = new ArrayList<>();
//		inputTextArea.setOnMouseClicked(x->modeTranslatingText.setText("tina laten"));
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

	@FXML
	private void handleLatinToNgalagena () {
		this.inputTextArea.setText("");
		this.modeTranslatingText.setText("tina laten");
		this.inputTextArea.setEditable(true);
	}
	@FXML
	public void handleNgalagenaToLatin() {
		this.inputTextArea.setEditable(false);
		try {
			this.modeTranslatingText.setText("tina sunda");
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
			stage.setX(0);
			stage.setY(430);

			/*
			 * nu hanap palagi passing referensi ke virtualkeyboard controller 
			 */
			VirtualKeyBoardController virtualKeyBoardController = (VirtualKeyBoardController) fxmlLoader
					.getController();
			virtualKeyBoardController.setInputTextArea(this.inputTextArea);
			//			virtualKeyBoardController.setTranslatingModeText(this.translatingMode.getText());
			virtualKeyBoardController.setStage(stage);
			virtualKeyBoardController
			.setTextToBeTranslated(this.textSundaneseToBeTranslatedList);

			this.resultTranslate.setText("");
			stage.showAndWait();
			stage.sizeToScene();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void translateButton() {
		switch (translate) {
		case 1:
			TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
			textSundaneseToBeTranslatedList
			.forEach(string -> this.resultTranslate
					.appendText(translatorFromSundaneseFont
							.translate(string)));
			textSundaneseToBeTranslatedList.clear();
			break;
		case 0:
			/*
			 * deklarasi
			 */

			TranslatorFromInputUser translatorFromInputUser = new TranslatorFromInputUser();
			ChekHanacaraka chekHanacaraka = new ChekHanacaraka();
			String stringLenght = inputTextArea.getText();
			int isLenght = stringLenght.length();
			System.out.println("masuk kana case 0");
			System.out.println("panjangna = " + isLenght);
			System.out.println("mulai !!!\n");
			sundaneseCharList.clear();

			for (int i = isLenght; i > 0; ) {
				int startString = 0;
				System.out.println("masuk kana for");
				System.out.println("i na = " + i);

				boolean isFourChar = false;
				String getFourChar = null;
				boolean isThreeChar = false;
				String getThreeChar = null;
				boolean isTwoChar = false;
				String getTwoChar = null;
				String getSinggleChar = null;

				if (isLenght >= 4) {
					int startLocal4 = startString;
					int endLocal4 = startString + 4;
					System.out.println(inputTextArea.getText(startLocal4, endLocal4));
					getFourChar = inputTextArea.getText(startLocal4, endLocal4)
							.toLowerCase();
					isFourChar = chekHanacaraka.isFourChar(getFourChar);
				}
				if (isLenght >= 3 && isFourChar == false) {
					int startLocal3 = startString;
					int endLocal3 = startString + 3;
					System.out.println(inputTextArea.getText(startLocal3, endLocal3));
					getThreeChar = inputTextArea.getText(startLocal3, endLocal3)
							.toLowerCase();
					isThreeChar = chekHanacaraka.isTripleChar(getThreeChar);
				}
				if (isLenght >= 2 && isThreeChar == false && isFourChar == false) {
					int startLocal2 = startString;
					int endLocal2 = startString + 2;
					System.out.println(inputTextArea.getText(startLocal2, endLocal2));
					getTwoChar = inputTextArea.getText(startLocal2, endLocal2)
							.toLowerCase();
					isTwoChar = chekHanacaraka.isDoubleChar(getTwoChar);
				}
				if (isLenght >= 1 && isTwoChar == false && isThreeChar == false
						&& isFourChar == false){
					int startLocal1 = startString;
					int endLocal1 = startString + 1;
					System.out.println(inputTextArea.getText(startLocal1, endLocal1));
					getSinggleChar = inputTextArea.getText(startLocal1, endLocal1)
							.toLowerCase();
					chekHanacaraka.isSinggleChar(getSinggleChar);
				}
				System.out.println("beres ngacek");

				if (isFourChar == true) {
					String returnFourChar = translatorFromInputUser.fourCharacter(getFourChar);
					sundaneseCharList.add(returnFourChar);
					startString = startString + 4;
					i = i - 4;
					System.out.println("asup kana 4");
					System.out.println("i pulang dikurang " + i);
				} else if (isThreeChar == true) {
					String returnThreeChar = translatorFromInputUser.tripleChar(getThreeChar);
					sundaneseCharList.add(returnThreeChar);
					startString = startString + 3;
					i = i - 3;
					System.out.println("asup kana 3");
				} else if (isTwoChar == true) {
					String returnTwoChar = translatorFromInputUser.doubleCharacter(getTwoChar);
					sundaneseCharList.add(returnTwoChar);
					startString = startString + 2;
					i = i - 2;
					System.out.println("asup kana 2");
				} else {
					String returnSinggleChar = translatorFromInputUser
							.singgleChar(getSinggleChar);
					sundaneseCharList.add(returnSinggleChar);
					i = i - 1;
					System.out.println("asup kana 1");
				}
				

				System.out.println("beres tina for");
				System.out.println("hurufna = " + sundaneseCharList);
				resultTranslate.setText(sundaneseCharList.toString());
				this.inputTextArea.setEditable(true);
			}
			/*
			 * batas
			 */
		}
		translate = 0;
	}
}
