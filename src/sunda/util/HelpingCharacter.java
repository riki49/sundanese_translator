package sunda.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
	Button pamaeh, panyck, pnglyr, pngwsd, pmngkl, pnykra,
	panyiku, pnghlu, pnyuku, pnleeng, pnlong, pmepet, pnleung;

	@FXML
	public void helpingButton(ActionEvent actionEvent) {
		TranslatorFromLatinFont translatorFromLatinFont = new TranslatorFromLatinFont();
		String latinCharacter = ((Button) actionEvent.getSource()).getText();
		translatorFromLatinFont.translate(latinCharacter);
		if (!this.pamaeh.isDisable()) {
			this.pamaeh.setDisable(false);
			String lastLatinCharacter = (String) this.latinCharacterList
					.get(this.latinCharacterList.size() - 1);
			String newLatinCharacter = lastLatinCharacter.substring(0,
					lastLatinCharacter.length() - 1);
			this.sundaneseCharacterList
			.add(translatorFromLatinFont.translate(newLatinCharacter));
			this.inputTextArea.appendText(this.sundaneseCharacterList
					.get(this.sundaneseCharacterList.size() - 1));
			this.latinCharacterList.remove(this.latinCharacterList.size() - 1);
			this.latinCharacterList.add(newLatinCharacter);
		}
	}
}
