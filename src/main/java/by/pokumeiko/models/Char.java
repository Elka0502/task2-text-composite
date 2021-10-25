package by.pokumeiko.models;

import java.util.ArrayList;

public class Char implements TextInterface {
	
	private ArrayList<TextInterface> texts;
	private String name = "";
	
	public Char(String name) {
		texts = new ArrayList<TextInterface>();
		this.name = name;;
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
		return String.format("Char: \"%s\"\n", this.name);
	}
	
	@Override
	public String printParseAll() {
		StringBuilder resultText = new StringBuilder("");
		
		resultText.append (String.format("                Char: \"%s\" - ", this.name));
		
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
		return texts;
	}
	
	@Override
	public void addChild(TextInterface text) {
		texts.add(text);	
	}

	@Override
	public void addChild(ArrayList<TextInterface> text) {
		texts.addAll(text);
	}

	@Override
	public void removeChild(TextInterface text) {
		texts.remove(text);
	}
	
	@Override
	public void clear() {
		texts.clear();
	}
	
}
