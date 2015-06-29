package sunda.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import sunda.util.SundaneseFontTranslator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class HelpingCharacter {
	private TextArea inputTextArea;
	private List<String> sundaneseCharacterList;
	private ArrayList<Object> latinCharacterList;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.latinCharacterList = new ArrayList<>();
	}
	@FXML
	Button pamaeh;
	Button panyck;
	Button pnglyr;
	Button pngwsd;
	Button pmngkl;
	Button pnykra;
	Button panyiku;
	Button pnghlu;
	Button pnyuku;
	Button pnleeng;
	Button pnlong;
	Button pmepet;
	Button pnleung;
	public void helpingButton(ActionEvent actionEvent) {
		String latinCharacter = ((Button) actionEvent.getSource()).getText();
		SundaneseFontTranslator sundaneseFontTranslator = new SundaneseFontTranslator(
				latinCharacter);
		if (!this.pamaeh.isDisable()) {
			this.pamaeh.setDisable(true);
			String lastLatinCharacter = (String) this.latinCharacterList
					.get(this.latinCharacterList.size() - 1);
			String newLatinCharacter = lastLatinCharacter.substring(0,
					lastLatinCharacter.length() - 1);
			this.sundaneseCharacterList
			.add(sundaneseFontTranslator.translate());
			this.inputTextArea.appendText(this.sundaneseCharacterList
					.get(this.sundaneseCharacterList.size() - 1));
			this.latinCharacterList.remove(this.latinCharacterList.size() - 1);
			this.latinCharacterList.add(newLatinCharacter);
		}

	}
}
