package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced{
	
	private String alienWord;
	private LinkedList<String> translation;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = new String();
		this.translation = new LinkedList<String>();
	}

	
	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		alienWord = alienWord;
	}

	public void addTranslation (String t) {
		this.translation.add(t);
	}
	
	public List getTranslation() {
		return this.translation;
	}
	
	public void setTranslation(List<String> t) {
		this.translation.addAll(t);
	}
	
	public String toString() {
		String s = "";
		for(int i=0; i<this.translation.size(); i++)
		{
			if(i < this.translation.size()-1)
				s = s + this.translation.get(i) +", ";
			else
				s = s + this.translation.get(i);
		}
		
		if(!s.equals(""))
		   return s;
		
		return null;
	}
}
