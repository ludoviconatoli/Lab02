package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.alien.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary ad;
	String[] vetNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	String[] carSpeciali = {"?", "^", "@", "#", "!", "%", "$", "£", "€"};
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnswer;

    @FXML
    private Button btTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btClearText;
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtAnswer.clear();
    	txtResult.clear();
    	return;
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
		txtResult.clear();
		String riga = this.txtAnswer.getText().toLowerCase();

		// Controllo sull'input
		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		String[] st = riga.split(" ");
		
		/* Controllo su String Tokenizer (superfluo)
		if (!st.hasMoreElements()) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}*/

		// Estraggo la prima parola
		String alienWord = st[0];

		if (st.length > 1) {
			// Devo inserire nel dizionario

			// Estraggo la seconda parola
			String translation = st[1];

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			// Aggiungo la parola aliena e traduzione nel dizionario
			ad.addWord(alienWord, translation);

			txtResult.setText("La parola: " + alienWord + " traduzione: " + translation + " è stata inserita.");

		} else {

			// Controllo che non ci siano caratteri non ammessi
			if (!alienWord.matches("[a-zA-Z?]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation;

			if (alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {

				// Traduzione con WildCard
				translation = ad.translateWordWildCard(alienWord);

			} else {

				// Traduzione classica
				translation = ad.translateWord(alienWord);
			}

			if (translation != null) {
				txtResult.setText(translation);
			} else {
				txtResult.setText("La parola cercata non esiste nel dizionario.");
			}
		}
    }

    @FXML
    void initialize() {
        assert txtAnswer != null : "fx:id=\"txtAnswer\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btTranslate != null : "fx:id=\"btTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btClearText != null : "fx:id=\"btClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        
        ad = new AlienDictionary();
    }
}
