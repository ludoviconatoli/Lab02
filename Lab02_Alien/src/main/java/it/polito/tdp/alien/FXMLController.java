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
    	
    	String[] parole =  txtAnswer.getText().toLowerCase().split(" ");
    	
    	for(int i=0; i<parole.length; i++)
    		for(int j=0; j<vetNum.length; j++)
    			if(parole[i].contains(vetNum[j]))
    			{
    				txtResult.setText("Le parole non possono contenere numeri");
    				return;
    			}
    	
    	for(int i=0; i<parole.length; i++)
    		for(int j=0; j<carSpeciali.length; j++)
    			if(parole[i].contains(carSpeciali[j]))
    			{
    				txtResult.setText("Le parole non possono contenere caratteri speciali");
    				return;
    			}
    	
    	if(parole.length == 1 && parole[0].matches("[a-zA-Z]+"))
    	{
    		String s = this.ad.translateWord(parole[0]);
    		if(s != null)
    		{
    			txtResult.setText(s);
    			return;
    		}
    		txtResult.setText("La parola non è presente nel dizionario");
    		return;
    	}
    	
    	if(parole.length > 1)
    	{
    		LinkedList<String> s = new LinkedList<String>();
    		for(int i=1; i<parole.length; i++)
    			s.add(parole[i]);
    		
    		this.ad.addWord(parole[0], s);
    		txtResult.setText("Parola aggiunta al dizionario");
    		return;
    	}
    	
    	txtResult.setText("Devi inserire almeno una parola");
    	return;
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
