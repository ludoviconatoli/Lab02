package it.polito.tdp.alien;

import java.util.ArrayList;

public class AlienDictionary {
	
	ArrayList<Word> dizionario;
	
	public AlienDictionary() {
		this.dizionario = new ArrayList<Word>();
	}
	
	public String cercaParola(String alienWord) {
		for(Word w: this.dizionario)
			if(w.getAlienWord().equals(alienWord))
				return w.getAlienWord();
		
		return null;
	}
	
	public void addWord(String alienWord, String translation) {
		
		int p = 0;
		for(Word w: this.dizionario)
		{
			if(w.getAlienWord().equals(alienWord))
			{
				w.setTranslation(translation);
				p++;		
			}
		}
		if( p == 0)
		{
			this.dizionario.add(new Word(alienWord, translation));
		}
	}
	
	public String translateWord(String alienWord) {
		
		for(Word w: this.dizionario)
		{	
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		}
		return null;
	}

}
