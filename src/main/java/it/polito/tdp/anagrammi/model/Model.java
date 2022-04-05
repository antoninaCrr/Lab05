package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<String> anagrammi;

	public List<String> anagramma(String s) { // interfaccia pubblica che ti permette di preparare i dati che servono alla ricorsione
		anagrammi = new LinkedList<String>();
		anagramma_ricorsiva("", 0, s); // soluzione parziale vuota, livello 0, s come lettere rimanenti
		// questo è l'avvio della ricorsione
		return anagrammi;
	}
	
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if (rimanenti.length() == 0) { /* caso terminale */
			this.anagrammi.add(parziale); 
			return;
		} else {
			/* caso normale */
			// es: parziale="AC", livello=2, rimanenti="BD"
			// devo decomporre il problema in tanti sotto problemi quanti sono le lettere rimanenti
			for (int pos = 0; pos < rimanenti.length(); pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos); // prendo la soluzione parziale e aggiungo al primo for B e al secondo D
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1); // prendo la stringa rimamenti e tolgo il carattere aggiunto alla soluzione parziale
																									 // prendo i caratteri dalla posizione 0 alla posizione pos(esclusa) + i car dalla posizione pos+1 fino alla fine della stringa
				anagramma_ricorsiva(nuova_parziale, livello + 1, nuova_rimanenti);
				
				
			}
		}
	}
}
