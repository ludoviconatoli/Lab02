package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	ArrayList<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		this.dizionario = new ArrayList<WordEnhanced>();
	}
	
	public String cercaParola(String alienWord) {
		for(WordEnhanced w: this.dizionario)
			if(w.getAlienWord().equals(alienWord))
				return w.getAlienWord();
		
		return null;
	}
	
	public void addWord(String alienWord, LinkedList<String> translation) {
		
		int p = 0;
		for(WordEnhanced w: this.dizionario)
		{
			if(w.getAlienWord().equals(alienWord))
			{
				w.setTranslation(translation);
				p++;		
			}
		}
		if( p == 0)
		{
			WordEnhanced we = new WordEnhanced(alienWord);
			we.setTranslation(translation);
			this.dizionario.add(we);
		}
	}
	
	public String translateWord(String alienWord) {
		
		for(WordEnhanced w: this.dizionario)
		{	
			if(w.getAlienWord().equals(alienWord))
				return w.toString();
		}
		return null;
	}
	
}
