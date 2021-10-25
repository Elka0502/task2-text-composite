package by.pokumeiko.models;

import java.util.ArrayList;

public interface TextInterface {
	
	public String getName();
	public void setName(String text);
	public ArrayList<TextInterface> getTexts();
	public String print();
	public String printParseAll();
	public String printRecover();
	public ArrayList<TextInterface> getChildren();
	public void addChild(TextInterface text);
	public void addChild(ArrayList<TextInterface> text);
	public void removeChild(TextInterface text);
	public void clear();
	
}
