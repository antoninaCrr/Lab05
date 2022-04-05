package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.*;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtInput;

    @FXML
    void doCalcolaAnagramma(ActionEvent event) {
    	String daAnagrammare = this.txtInput.getText();
    	List<String> anagrammi = model.anagramma(daAnagrammare);
    	for(String si : anagrammi) {
    		if(model.isCorrect(si))
    			this.txtCorretti.appendText(si.toString()+"\n");
    		else
    			this.txtErrati.appendText(si.toString()+"\n");
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}