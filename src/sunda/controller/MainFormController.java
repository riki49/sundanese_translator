package sunda.controller;

import java.net.URL;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
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
import sunda.util.TranslatorFromSundaneseKeyboard;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainFormController implements Initializable {
	@FXML
	private int statusTranslate = 0;
	public TextArea inputTextArea;
	public TextArea resultTextArea;
	private Stage stage;
//	private List<String> sundaneseCharList;
	private List<String> textSundaneseToBeTranslatedList;
	/*
	 * struktur data untuk menyimpan string unicode per kata
	 */

	@FXML
	private Text modeTranslatingText;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.textSundaneseToBeTranslatedList = new ArrayList<>();
//		this.sundaneseCharList = new ArrayList<>();
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
		this.resultTextArea.setText("");
		this.modeTranslatingText.setText("tina laten kana Ngalagena");
		this.inputTextArea.setEditable(true);
		statusTranslate = 0;
	}

	@FXML
	public void handleHanacarakaKeyboard() {
		this.inputTextArea.setEditable(false);
		try {
			this.modeTranslatingText.setText("tina Ngalagena kana Laten");
			statusTranslate = 1;
			this.stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane root = (AnchorPane) fxmlLoader
					.load(ClassLoader
							.getSystemResourceAsStream("sunda/view/VirtualHanacarakaKeyBoard.fxml"));

			Scene scene = new Scene(root);
			//palagi ngalengitken bingkai windows
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);//tepi dieu
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setX(0);
			stage.setY(430);

			/*
			 * nu hanap palagi passing referensi ke virtualkeyboard controller
			 */
			VirtualHanacarakaKeyBoardController virtualKeyBoardController = (VirtualHanacarakaKeyBoardController) fxmlLoader
					.getController();
			virtualKeyBoardController.setInputTextArea(this.inputTextArea);
			//			virtualKeyBoardController.setTranslatingModeText(this.translatingMode.getText());
			virtualKeyBoardController.setStage(stage);
			virtualKeyBoardController
					.setTextToBeTranslated(this.textSundaneseToBeTranslatedList);

			this.resultTextArea.setText("");
			stage.showAndWait();
			stage.sizeToScene();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleNgalagenaKeyBoard () {
		this.inputTextArea.setEditable(false);
		try {
			this.modeTranslatingText.setText("tina ngalagena kana Laten");
			statusTranslate = 1;
			this.stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane root = (AnchorPane) fxmlLoader
					.load(ClassLoader
							.getSystemResourceAsStream("sunda/view/VirtualNgalagenaKeyBoard.fxml"));

			Scene scene = new Scene(root);
			//palagi ngalengitken bingkai windows
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);//tepi dieu
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setX(0);
			stage.setY(430);

			/*
			 * nu hanap palagi passing referensi ke virtualkeyboard controller
			 */
			VirtualHanacarakaKeyBoardController virtualKeyBoardController = (VirtualHanacarakaKeyBoardController) fxmlLoader
					.getController();
			virtualKeyBoardController.setInputTextArea(this.inputTextArea);
			//			virtualKeyBoardController.setTranslatingModeText(this.translatingMode.getText());
			virtualKeyBoardController.setStage(stage);
			virtualKeyBoardController
					.setTextToBeTranslated(this.textSundaneseToBeTranslatedList);

			this.resultTextArea.setText("");
			stage.showAndWait();
			stage.sizeToScene();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void translateButton() {
		switch (statusTranslate) {
			case 0:
			/*
			 * deklarasi
			 */
				inputTextArea.setEditable(false);
				TranslatorFromInputUser translatorFromInputUser = new TranslatorFromInputUser();
				ChekHanacaraka chekHanacaraka = new ChekHanacaraka();
				String stringLenght = inputTextArea.getText();
				int lenghtInputUser = stringLenght.length();
				System.out.println("masuk kana case 0");
				System.out.println("panjangna = " + lenghtInputUser);
				System.out.println("mulai !!!\n");
				int startString = 0;
				String kumpulanString = "";
//				sundaneseCharList.clear();
				for (int i = lenghtInputUser; i > 0; ) {
					System.out.println("masuk kana for");
					System.out.println("i na = " + i);

					boolean isFourChar = false;
					String getFourChar = null;
					boolean isThreeChar = false;
					String getThreeChar = null;
					boolean isTwoChar = false;
					String getTwoChar = null;
					boolean isSingleChar = false;
					String getSinggleChar = null;

					if (i >= 4) {
						int startLocal4 = startString;
						int endLocal4 = startString + 4;
						System.out.println(inputTextArea.getText(startLocal4, endLocal4));
						getFourChar = inputTextArea.getText(startLocal4, endLocal4)
								.toLowerCase();
						isFourChar = chekHanacaraka.isFourChar(getFourChar);
						if (isFourChar != false) {
							String returnFourChar = translatorFromInputUser.fourCharacter(getFourChar);
//							sundaneseCharList.add(returnFourChar);
							startString += 4;
							i -= 4;
							System.out.println("asup kana 4");
							System.out.println("i pulang dikurang " + i);
							//resultTextArea.appendText(sundaneseCharList.toString());
							kumpulanString += returnFourChar;
							resultTextArea.appendText(kumpulanString);
							System.out.println("kumpulan string " + kumpulanString);
							kumpulanString = "";
//							sundaneseCharList.clear();
						}
						System.out.println("kaluar ti 4");
					}
					if (i >= 3) {
						System.out.println("asup if 3");
						int startLocal3 = startString;
						int endLocal3 = startString + 3;
						System.out.println(inputTextArea.getText(startLocal3, endLocal3));
						getThreeChar = inputTextArea.getText(startLocal3, endLocal3)
								.toLowerCase();
						isThreeChar = chekHanacaraka.isTripleChar(getThreeChar);
						if (isThreeChar != false && isFourChar == false) {
							String returnThreeChar = translatorFromInputUser.tripleChar(getThreeChar);
//							sundaneseCharList.add(returnThreeChar);
							startString += 3;
							i = i - 3;
							//resultTextArea.appendText(sundaneseCharList.toString());
							kumpulanString += returnThreeChar;
							resultTextArea.appendText(kumpulanString);
							kumpulanString = "";
//							sundaneseCharList.clear();
							System.out.println("asup kana 3");
						}
					}
					if (i >= 2) {
						System.out.println("asup kana if 2");
						int startLocal2 = startString;
						int endLocal2 = startString + 2;
						System.out.println(inputTextArea.getText(startLocal2, endLocal2));
						getTwoChar = inputTextArea.getText(startLocal2, endLocal2)
								.toLowerCase();
						isTwoChar = chekHanacaraka.isDoubleChar(getTwoChar);
						if (isTwoChar !=false && isThreeChar != true) {
							String returnTwoChar = translatorFromInputUser.doubleCharacter(getTwoChar);
//							sundaneseCharList.add(returnTwoChar);
							startString = startString + 2;
							i = i - 2;
//							resultTextArea.appendText(sundaneseCharList.toString());
							kumpulanString += returnTwoChar;
							resultTextArea.appendText(kumpulanString);
							kumpulanString = "";
//							sundaneseCharList.clear();
							System.out.println("kaluar tina if 2");
						}
					}
					if (i >= 1 && isTwoChar == false && isFourChar != true) {
						System.out.println("asup kana if 1");
						int startLocal1 = startString;
						int endLocal1 = startString + 1;
						System.out.println(inputTextArea.getText(startLocal1, endLocal1));
						getSinggleChar = inputTextArea.getText(startLocal1, endLocal1)
								.toLowerCase();
						isSingleChar = chekHanacaraka.isSinggleChar(getSinggleChar);
						if (isSingleChar != false && !getSinggleChar.equals(" ")) {
							String returnSingleChar = translatorFromInputUser.singgleChar(getSinggleChar);
//							sundaneseCharList.add(returnSingleChar);
							startString +=1;
							i -=1;
//							resultTextArea.appendText(sundaneseCharList.toString());
							kumpulanString += returnSingleChar;
							resultTextArea.appendText(kumpulanString);
							kumpulanString = "";
//							sundaneseCharList.clear();
						} else if (getSinggleChar.equals(" ")){
							resultTextArea.appendText("      ");
							startString +=1;
							i -=1;
						} else {
							resultTextArea.appendText(getSinggleChar);
							startString +=1;
							i -=1;
						}
					}
				}
				System.out.println("beres ngacek");
				System.out.println("beres tina for");
//				System.out.println("hurufna = " + sundaneseCharList);
//				sundaneseCharList.clear();
				statusTranslate = 0;
			/*
			 * batas
			 */

			case 1:
				TranslatorFromSundaneseKeyboard translatorFromSundaneseKeyboard = new TranslatorFromSundaneseKeyboard();
				textSundaneseToBeTranslatedList
						.forEach(string -> this.resultTextArea
								.appendText(translatorFromSundaneseKeyboard
										.translate(string)));
				textSundaneseToBeTranslatedList.clear();
				statusTranslate = 1;
				break;
		}
	}
}
