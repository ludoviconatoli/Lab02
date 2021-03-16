package it.polito.tdp.alien;

public class Word {
	
	private String AlienWord;
	private String translation;
	
	public Word(String a, String t) {
		this.AlienWord = a;
		this.translation = t;
	}

	
	public String getAlienWord() {
		return AlienWord;
	}


	public void setAlienWord(String alienWord) {
		AlienWord = alienWord;
	}


	public String getTranslation() {
		return translation;
	}


	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
}
