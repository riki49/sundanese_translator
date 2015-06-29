package sunda.controller;

import java.net.URL;

import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sunda.util.SundaneseFontTranslator;
import javafx.fxml.FXML;

public class VirtualKeyBoardController implements Initializable {

	private TextArea inputTextArea;
	private Stage stage;
	private List<String> sundaneseCharacterList;
	@FXML
	Button pamaehButton;
	private List<String> latinCharacterList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.latinCharacterList = new ArrayList<>();
	}

	@FXML
	public void handleOnClickPamaehButton(ActionEvent actionEvent) {
		HelpingCharacter helpingCharacter = new HelpingCharacter();
		helpingCharacter.helpingButton(actionEvent);
//		String latinCharacter = ((Button) actionEvent.getSource()).getText();
//		SundaneseFontTranslator sundaneseFontTranslator = new SundaneseFontTranslator(
//				latinCharacter);
//		if (!this.pamaehButton.isDisable()) {
//			this.pamaehButton.setDisable(true);
//			String lastLatinCharacter = this.latinCharacterList
//					.get(this.latinCharacterList.size() - 1);
//			String newLatinCharacter = lastLatinCharacter.substring(0,
//					lastLatinCharacter.length() - 1);
//			this.sundaneseCharacterList
//					.add(sundaneseFontTranslator.translate());
//			this.inputTextArea.appendText(this.sundaneseCharacterList
//					.get(this.sundaneseCharacterList.size() - 1));
//			this.latinCharacterList.remove(this.latinCharacterList.size() - 1);
//			this.latinCharacterList.add(newLatinCharacter);
//			
//			
//
//		}
	}

	public void handleCharButton(ActionEvent actionEvent) {
		Button button = (Button) actionEvent.getSource();
		String latinCharacter = button.getText();
		SundaneseFontTranslator sundaneseFontTranslator = new SundaneseFontTranslator(
				latinCharacter);
		String sundaneseCharacter = sundaneseFontTranslator.translate();
		if (sundaneseFontTranslator.isHanacaraka()) {
			this.pamaehButton.setDisable(false);
		}
		this.latinCharacterList.add(latinCharacter);
		this.sundaneseCharacterList.add(sundaneseCharacter); // simpan setiap
																// click
																// sundanese
																// character ke
																// dalam list
		this.inputTextArea.appendText(sundaneseCharacter);

	}

	public void handleSubmitButton() {
		this.inputTextArea.setEditable(true);
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
		this.sundaneseCharacterList
				.remove(this.sundaneseCharacterList.size() - 1); // hapus item terakhir list
		this.inputTextArea.setText(newString);
	}

	public void handleOnClickHanacaraka() {
		this.pamaehButton.setDisable(false);
	}

	public void setSundaneseCharacterList(List<String> textToBeTranslatedList) {
		this.sundaneseCharacterList = textToBeTranslatedList; // hubungken ka list to beTranslate
	}

	public void setLatinCharacterList(List<String> latinCharacterList) {
		this.latinCharacterList = latinCharacterList;
	}

}
