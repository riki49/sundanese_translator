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
import sunda.util.TranslatorFromSundaneseFont;
import sunda.util.TranslatorFromLatinFont;
import javafx.fxml.FXML;

public class VirtualKeyBoardController implements Initializable {

	private TextArea inputTextArea;
	private Stage stage;
	private List<String> textToBeTranslatedList;
	@FXML
	Button pamingkalButton;
	@FXML
	Button panyikuButton;
	@FXML
	Button pamaehButton;
	@FXML
	Button panolongButton;
	@FXML
	Button panyakraButton;
	@FXML
	Button paneuleungButton;
	@FXML
	Button panyukuButton;
	@FXML
	Button panelengButton;
	@FXML
	Button pamepetButton;
	@FXML
	Button panyecekButton;
	@FXML
	Button pangwisadButton;
	@FXML
	Button submitButton;
	@FXML
	Button panglayarButton;
	@FXML
	Button panghuluButton;
	@FXML
	Button yaButton;
	@FXML
	Button taButton;
	@FXML
	Button raButton;
	@FXML
	Button ngaButton;
	@FXML
	Button qaButton;
	@FXML
	Button paButton;
	@FXML
	Button waButton;
	@FXML
	Button laButton;
	@FXML
	Button kaButton;
	@FXML
	Button jaButton;
	@FXML
	Button haButton;
	@FXML
	Button gaButton;
	@FXML
	Button faButton;
	@FXML
	Button daButton;
	@FXML
	Button saButton;
	@FXML
	Button naButton;
	@FXML
	Button baButton;
	@FXML
	Button vaButton;
	@FXML
	Button caButton;
	@FXML
	Button xaButton;
	@FXML
	Button zaButton;
	@FXML
	Button nyaButton;
	@FXML
	Button maButton;
	@FXML
	Button spasiButton;
	private List<Button> hanacarakaList;
	private List<Button> metaCharacterList;
	private List<Button> specialMetaCharacter;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.metaCharacterList = Arrays.asList(this.pamaehButton, this.pamepetButton,
				this.panelengButton,
				this.paneuleungButton, this.panghuluButton, this.panolongButton,
				this.panyukuButton);
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		this.specialMetaCharacter = Arrays.asList(this.pamingkalButton,
				this.panglayarButton, this.pangwisadButton, this.panyakraButton,
				this.panyecekButton, this.panyikuButton);
		this.specialMetaCharacter.forEach(metaCharacterList -> metaCharacterList
				.setDisable(true));
		this.hanacarakaList = Arrays.asList(this.baButton, this.caButton,
				this.daButton, this.faButton, this.gaButton, this.haButton,
				this.jaButton, this.kaButton, this.laButton, this.maButton,
				this.naButton, this.ngaButton, this.nyaButton, this.paButton,
				this.qaButton, this.raButton, this.saButton, this.taButton,
				this.vaButton, this.waButton, this.waButton, this.xaButton,
				this.yaButton, this.zaButton);

	}

	public void spaceButton (ActionEvent actionEvent) {
		this.textToBeTranslatedList.add(" ");
		this.inputTextArea.appendText(" ");
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		this.specialMetaCharacter.forEach(specialMetaCharacter -> 
		specialMetaCharacter.setDisable(true));
	}
	
	public void handleCharButton(ActionEvent actionEvent) {

		Button sourceButton = (Button) actionEvent.getSource();
		boolean isHanacaraka = this.hanacarakaList.stream().anyMatch(
				p -> p.getText().equalsIgnoreCase(sourceButton.getText()));
		if (isHanacaraka) {
			this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
					.setDisable(false));
			this.metaCharacterList.forEach(metaCharacter -> metaCharacter
					.setDisable(false));
		}
		/*
		 * simpan setiap click Sundanese character ke dalam list
		 */
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
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
							.getSystemResourceAsStream("sunda/view/VirtualSundaneseKeyBoard.fxml"));
			Scene Scene = new Scene(secondKeyboard);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(Scene);
			stage.show();
			stage.setResizable(false);
			stage.setX(550);
			stage.setY(450);
			// VirtualSundaneseKeyBoardControler
			// virtualSundaneseKeyBoardControler =
			// (VirtualSundaneseKeyBoardControler)fxmlLoader.getController();
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh);
	}

	public void handlePanghuluButton(ActionEvent actionEvent) {
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "i");

	}

	public void handlePanyukuButton(ActionEvent actionEvent) {
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "u");
	}

	public void handlePanelengButton(ActionEvent actionEvent) {
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "é");

		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "eu");
	}

	public void handlePanolongButton(ActionEvent actionEvent) {
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
				.translate(lastIndexOfArraySundaneseCharacter);
		String singleCharFromPamaeh = lastIndexFromResul.substring(0,
				lastIndexFromResul.length() - 1);
		this.textToBeTranslatedList
				.remove(this.textToBeTranslatedList.size() - 1);
		this.textToBeTranslatedList.add(singleCharFromPamaeh + "o");
	}

	public void handlePamepetButton(ActionEvent actionEvent) {
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseFont
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1);
		String lastIndexFromResul = translatorFromSundaneseFont
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		TranslatorFromSundaneseFont translatorFromSundaneseFont = new TranslatorFromSundaneseFont();
		String lastIndexOfArraySundaneseCharacter = this.textToBeTranslatedList
				.get(this.textToBeTranslatedList.size() - 1); // dapatkan index
																// terakhir
		String lastIndexFromResul = translatorFromSundaneseFont
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
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("h");
	}

	public void handlePanglayarButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("r");
	}

	public void handlePanyecekButton(ActionEvent actionEvent) {
		this.specialMetaCharacter.forEach(specialMetaCharacter -> specialMetaCharacter
				.setDisable(true));
		this.metaCharacterList.forEach(metaCharacter -> metaCharacter
				.setDisable(true));
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		Button button = (Button) actionEvent.getSource();
		String sundaneseCharacter = translatorFromLatinFont.translate(button
				.getText());
		this.inputTextArea.appendText(sundaneseCharacter);
		this.textToBeTranslatedList.add("ng");
	}

	public void setTranslatingModeText(String tranlatingModeText) {
		
	}
}
