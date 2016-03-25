package sunda.controller;

import java.io.IOException;
import java.net.URL;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import sunda.util.TranslatorFromSundaneseKeyboard;
import sunda.util.TranslatorFromLatinKeyboard;
import javafx.fxml.FXML;

public class VirtualHanacarakaKeyBoardController implements Initializable {

	private TextArea inputTextArea;
	private Stage stage;
	private List<String> textToBeTranslatedList;
	@FXML
	Button submitButton;
	@FXML
	Button pamingkalButton, panyikuButton, pamaehButton, panolongButton,
			panyakraButton, paneuleungButton, panyukuButton, panelengButton,
			pamepetButton, panyecekButton, pangwisadButton, panglayarButton, panghuluButton;
	@FXML
	Button yaButton, taButton, raButton, ngaButton, qaButton, paButton, waButton,
			laButton, kaButton, jaButton, haButton, gaButton, faButton, daButton,
			saButton, naButton, baButton, vaButton, caButton, xaButton, zaButton,
			nyaButton, maButton;
	@FXML
	Button spasiButton, aButton, iButton, éButton, eButton, euButton, uButton, oButton;
	@FXML
	Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton,
			sevenButton, eightButton, nineButton;

	private List<Button> hanacarakaList;
	private List<Button> metaCharacter;
	private List<Button> specialMetaCharacter;
	private List<Button> vocalAndNumberCharacter;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.metaCharacter = Arrays.asList(this.pamaehButton, this.pamepetButton,
				this.panelengButton, this.paneuleungButton, this.panghuluButton,
				this.panolongButton, this.panyukuButton);
//		this.metaCharacter.forEach(metaCharacter -> metaCharacter
//				.setDisable(true));
		this.specialMetaCharacter = Arrays.asList(this.pamingkalButton,
				this.panglayarButton, this.pangwisadButton, this.panyakraButton,
				this.panyecekButton, this.panyikuButton);
//		this.specialMetaCharacter.forEach(metaCharacterList -> metaCharacterList
//				.setDisable(true));
		this.hanacarakaList = Arrays.asList(this.baButton, this.caButton,
				this.daButton, this.faButton, this.gaButton, this.haButton,
				this.jaButton, this.kaButton, this.laButton, this.maButton,
				this.naButton, this.ngaButton, this.nyaButton, this.paButton,
				this.qaButton, this.raButton, this.saButton, this.taButton,
				this.vaButton, this.waButton, this.waButton, this.xaButton,
				this.yaButton, this.zaButton);

		this.vocalAndNumberCharacter = Arrays.asList(this.aButton, this.eButton, this.iButton,
				this.éButton, this.uButton, this.oButton, this.euButton, this.zeroButton,
				this.oneButton, this.twoButton, this.threeButton, this.fourButton, this.fiveButton,
				this.sixButton, this.sevenButton, this.eightButton, this.nineButton);
	}

	public void spaceButton (ActionEvent actionEvent) {
		this.textToBeTranslatedList.add(" ");
		this.inputTextArea.appendText(" ");
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		this.specialMetaCharacter.forEach(specialMetaCharacter -> 
		specialMetaCharacter.setDisable(true));
	}

	public void handleCharButton(ActionEvent actionEvent) {

		Button sourceButton = (Button) actionEvent.getSource();
		boolean isHanacaraka = this.hanacarakaList.stream().anyMatch(
				p -> p.getText().equalsIgnoreCase(sourceButton.getText()));
		boolean isVocalChar = this.vocalAndNumberCharacter.stream().anyMatch
				(p -> p.getText().equalsIgnoreCase(sourceButton.getText()));
		if (isHanacaraka) {
			this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
					.setDisable(false));
			this.metaCharacter.forEach(metaCharacter -> metaCharacter
					.setDisable(false));
		} else if (isVocalChar){
			this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
					.setDisable(true));
			this.metaCharacter.forEach(metaCharacter -> metaCharacter
					.setDisable(true));
		}
		/*
		 * simpan setiap click Sundanese character ke dalam list
		 */
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.textToBeTranslatedList.add(sundaneseCharacter);
		this.inputTextArea.appendText(sundaneseCharacter);
	}

	public void setTextToBeTranslated(List<String> textToBeTranslatedList) {
		this.textToBeTranslatedList = textToBeTranslatedList;
		/*
		 * hubungken ka list to beTranslate
		 */
	}

	public void sundaneseVirtualKeyboard() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			this.stage = new Stage();
			AnchorPane secondKeyboard = fxmlLoader
					.load(ClassLoader
							.getSystemResourceAsStream("sunda/view/VirtualNgalagenaKeyBoard.fxml"));
			Scene Scene = new Scene(secondKeyboard);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(Scene);
			stage.show();
			stage.setResizable(false);
			stage.setX(550);
			stage.setY(450);
			stage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleSubmitButton() {
		//		this.inputTextArea.setEditable(true);
		this.stage.close();
	}

	public void setInputTextArea(TextArea inputTextArea) {
		this.inputTextArea = inputTextArea;
		this.inputTextArea.setEditable(false);
		this.inputTextArea.setText("");
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void deleteButton() {
		String oldString = inputTextArea.getText();
		String newString = oldString.substring(0, oldString.length() - 1);

		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		/*
		 * hapus item di index terakhir list
		 */
		this.inputTextArea.setText(newString);
	}

	public void handlePamaehButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh);
	}

	public void handlePanghuluButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "i");

	}

	public void handlePanyukuButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "u");
	}

	public void handlePanelengButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "é");

		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		String captureStringFromTextArea = inputTextArea.getText();
		String potonganDariCaptureString;
		String stringForShow = null;
		String lastIndex = null;
		if (captureStringFromTextArea.length() <= 1) {
			lastIndex = sundaneseCharacter + captureStringFromTextArea;
			this.inputTextArea.setText(lastIndex);
		} else if (captureStringFromTextArea.length() >= 2) {
			lastIndex = sundaneseCharacter
					+ captureStringFromTextArea.substring(
							captureStringFromTextArea.length() - 1,
							captureStringFromTextArea.length());
		}
		potonganDariCaptureString = captureStringFromTextArea.substring(0,
				captureStringFromTextArea.length() - 1);
		stringForShow = potonganDariCaptureString + lastIndex;
		this.inputTextArea.setText(stringForShow);
	}

	public void handlePaneuleungButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "eu");
	}

	public void handlePanolongButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "o");
	}

	public void handlePamepetButton(ActionEvent actionEvent) {
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "e");
	}

	public void handlePamingkalButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		String singleLastChar = lastIndexFromResul.substring(lastIndexFromResul
				.length() -1, lastIndexFromResul.length());
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "y" + singleLastChar);
	}

	public void handlePanyakraButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		String singleLastChar = lastIndexFromResul.substring(lastIndexFromResul
				.length() -1, lastIndexFromResul.length());
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "r" + singleLastChar);
	}

	public void handlePanyikuButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
		// terakhir
		String lastIndexFromResul = translatorFromSundaneseKeyboard
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		String singleLastChar = lastIndexFromResul.substring(lastIndexFromResul
				.length() -1, lastIndexFromResul.length());
		this.textToBeTranslatedList
		.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "l" + singleLastChar);
	}

	public void handlePangwisadButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("h");
	}

	public void handlePanglayarButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("r");
	}

	public void handlePanyecekButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacter.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinKeyboard translatorFromLatinKeyboard = new TranslatorFromLatinKeyboard();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinKeyboard.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("ng");
	}

	public void setTranslatingModeText(String tranlatingModeText) {

	}
}
