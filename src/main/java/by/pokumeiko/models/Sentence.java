package by.pokumeiko.models;

import java.util.ArrayList;

public class Sentence implements TextInterface{
	
	private ArrayList<TextInterface> texts;
	private String name;
	
	public Sentence (String name) {
		texts = new ArrayList<TextInterface>();
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public ArrayList<TextInterface> getTexts() {
		return texts;
	}
	
	@Override
	public String print() {
		return String.format("Sentence: %s\n", this.name.replace("\n", ""));
	}
	
	@Override
	public String printParseAll() {
		
		StringBuilder resultText = new StringBuilder("");
		
		resultText.append (String.format("     Sentence: %s\n", this.name.replace("\n", "")));
		
		for (TextInterface text: texts) {
			resultText.append(text.printParseAll());
		}
		
		return resultText.toString();
	}
	
	@Override
	public String printRecover() {
		return this.name;
	}

	@Override
	public ArrayList<TextInterface> getChildren() {
		ArrayList<TextInterface> arrayChildren = new ArrayList<TextInterface>();
		
		for (TextInterface text: texts) {
			arrayChildren.add (text);
			arrayChildren.addAll(text.getChildren());
		}
		return arrayChildren;
	}
	
	@Override
	public void addChild (TextInterface text) {
		texts.add(text);
	}
	
	@Override
	public void addChild (ArrayList<TextInterface> text) {
		texts.addAll(text);
	}
	
	@Override
	public void removeChild (TextInterface text) {
		texts.remove(text);
	}
	
	@Override
	public void clear() {
		texts.clear();
	}
}