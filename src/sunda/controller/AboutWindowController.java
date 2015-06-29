package sunda.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class AboutWindowController implements Initializable {

	@FXML
	private TextArea aboutTextArea;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			InputStream inputStream = ClassLoader
					.getSystemResourceAsStream("sunda/resource/license.txt");
			BufferedReader buffReader = new BufferedReader(
					new InputStreamReader(inputStream));

			this.aboutTextArea.setText(buffReader.lines().collect(
					Collectors.joining("\n")));
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
