 package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCorsiPerPeriodo;

    @FXML
    private Button btnStampaNumeroStudenti;

    @FXML
    private Button btnStampaStudenti;

    @FXML
    private Button btnStampaDivisioneStudenti;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	
    	txtRisultato.clear();
    	
    	String inputUtente = txtPeriodo.getText();
    	int pd;
    	try {
    		pd = Integer.parseInt(inputUtente);
    	}catch(NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero, 1 o 2");
    		return;
    	}
    	
    	if(pd != 1 && pd != 2) {
    		txtRisultato.setText("Devi inserire un numero, 1 o 2");
    		return;
    	}
    	//Se arriviamo qui l'imput è corretto
    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(pd);
    	
    	for(Corso c : corsi) {
    		txtRisultato.appendText(c.toString() + "\n");
    	}
    }

    @FXML
    void stampaDivisione(ActionEvent event) {
    	

    }

    @FXML
    void stampaNumeroStudenti(ActionEvent event) {
    	
    	txtRisultato.clear();

    	String inputUtente = txtPeriodo.getText();
    	int pd;
    	try {
    		pd = Integer.parseInt(inputUtente);
    	}catch(NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero, 1 o 2");
    		return;
    	}
    	
    	if(pd != 1 && pd != 2) {
    		txtRisultato.setText("Devi inserire un numero, 1 o 2");
    		return;
    	}
    	//Se arriviamo qui l'imput è corretto
    	
    	Map<Corso, Integer> statistiche = this.model.getIscrittiByPeriodo(pd);
    	
    	for(Corso c : statistiche.keySet()) {
    		txtRisultato.appendText(c.getNome() + " " + statistiche.get(c) + "\n");
    	}
    }

    @FXML
    void stampaStudenti(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStampaNumeroStudenti != null : "fx:id=\"btnStampaNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStampaStudenti != null : "fx:id=\"btnStampaStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStampaDivisioneStudenti != null : "fx:id=\"btnStampaDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}

    


    
   

