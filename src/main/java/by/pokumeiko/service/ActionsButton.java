package by.pokumeiko.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.pokumeiko.models.*;

public class ActionsButton {
	private static final String DEFAULT_PACKAGE = "by.pokumeiko.models.";
	private static final Logger LOGGER = LoggerFactory.getLogger(ActionsButton.class);
	public static CompositeText compositeText;
	
	/**Parse all*/
	public static void parseAction(String text) {
		
		compositeText = new CompositeText(text);
		compositeText.addChild (parseParagraph (text));
		LOGGER.info("Parse all.");
		
	}
	
	/**Parse into paragraphs*/
	public static ArrayList<TextInterface> parseParagraph(String text) {
		Paragraph paragraph;
		ArrayList<TextInterface> textInterface = new ArrayList<TextInterface>();
		Pattern patternParagraph = Pattern.compile("(?<=[\n\r])");
		
		String[] splitParagraph = patternParagraph.split(text);	

		for (int i = 0; i < splitParagraph.length; i++) {
    		paragraph = new Paragraph(splitParagraph[i].replace("\n", ""));
      		textInterface.add(paragraph);
      		if (!splitParagraph[i].replaceAll("\n|\r|\s|\t", "").equals(""))
      			paragraph.addChild (parseSentence (splitParagraph[i]));
       	}

    	return textInterface;
	}

	/**Parse into sentences*/
	public static ArrayList<TextInterface> parseSentence (String splitParagraph) {
		Sentence sentence;
		ArrayList<TextInterface> textInterface = new ArrayList<TextInterface>();
		Pattern patternSentence = Pattern.compile("(?<=[.!?]+)");
		
		String[] splitSentence = patternSentence.split(splitParagraph.replaceAll("\n", "")); 
		
    	for (int i = 0; i < splitSentence.length; i++) {
    		sentence = new Sentence(splitSentence[i]);
    		textInterface.add(sentence);
    		sentence.addChild(parseWordPunctuation (splitSentence[i]));
    	}
    	
    	return textInterface;
	}

	/**Parse into words and punctuation*/
	public static ArrayList<TextInterface> parseWordPunctuation (String splitSentence) {  
		Word word;
		String splitWordPunctuation;
		ArrayList<TextInterface> textInterface = new ArrayList<TextInterface>();

		Pattern patternWordPunctuation = Pattern.compile("[a-zA-Zа-яёЁА-Я0-9]+[ ]*|\\p{Punct}|—|«|»[ \n]*");
		Pattern patternPunctuation = Pattern.compile("[\\p{Punct}|—|«|»]");
		Matcher matcherWordPunctuation = patternWordPunctuation.matcher(splitSentence);
       	
      	while (matcherWordPunctuation.find()) {
      		splitWordPunctuation = splitSentence.substring(matcherWordPunctuation.start(), matcherWordPunctuation.end());
            if (patternPunctuation.matcher(splitWordPunctuation).find()) {
            	
            	textInterface.add(new Punctuation(splitWordPunctuation));
            	
            } else {
            	
            	word = new Word(splitWordPunctuation);
            	textInterface.add(word);
            	word.addChild(parseSymbol(splitWordPunctuation));
            	
            }
       	}
      	
      	return textInterface;
	}

	/**Parse into chars*/
	public static ArrayList<TextInterface> parseSymbol (String splitWordPunctuation) {
		Char symbol = new Char("");
		ArrayList<TextInterface> textInterface = new ArrayList<TextInterface>();
		
		char[] splitSymbol = splitWordPunctuation.replace(" ", "").toCharArray();
		
    	for (int i = 0; i < splitSymbol.length; i++) {
    		symbol = new Char(String.valueOf(splitSymbol[i]));
    		textInterface.add(symbol);
    		symbol.addChild(parseConsonantVowelNumberSign(splitSymbol[i]));
    	}

    	return textInterface;
	}
	
	/**Parse into chars*/
	public static ArrayList<TextInterface> parseConsonantVowelNumberSign (char splitSymbol) {
		
		ArrayList<TextInterface> textInterface = new ArrayList<TextInterface>();
		
		Pattern patternConsonant = Pattern.compile("[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩqwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]");
		Pattern patternVowel = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯeyuioaEYUIOA]");
		Pattern patternNumber = Pattern.compile("[0-9]");
		Pattern patternSign = Pattern.compile("[ьъЬЪ]");
		String ch  = String.valueOf(splitSymbol);

		if (patternConsonant.matcher(ch).find()) {
			
			textInterface.add( new Consonant(ch));	
			
		} else if (patternVowel.matcher(ch).find()) {
			
			textInterface.add( new Vowel(ch));
			
		} else if (patternNumber.matcher(ch).find()) {
			
			textInterface.add( new Numbers(ch));
			
		} else if (patternSign.matcher(ch).find()) {
			
			textInterface.add( new Sign(ch));
			
		}

		return textInterface;
	}
	
	/**Print parse text*/
	public static String showParseTextAction(String stringClass) {
		
		StringBuilder resultText = new StringBuilder("");
		
		if (stringClass.equals("All")) {
			resultText.append(compositeText.printParseAll());
		} else if (stringClass.equals("Word/Punctuation")) {
			for (TextInterface text: compositeText.getChildren()) {
				if (text.getClass().getName().equals(DEFAULT_PACKAGE + "Word")||
					text.getClass().getName().equals(DEFAULT_PACKAGE + "Punctuation")) {
					
						resultText.append(text.print());
				}
			}
		} else {
			for (TextInterface text: compositeText.getChildren()) {
				if (text.getClass().getName().equals(DEFAULT_PACKAGE + stringClass)) {
					
					resultText.append(text.print());
					
				}
			}
		}	
		
		LOGGER.info(String.format("Show parse into %s", stringClass));
		return resultText.toString();		
	}
	
	/**Recovery text*/
	public static String recoverAction() {
		String resultText = "";
		
		resultText = compositeText.printRecover();
		compositeText.clear();
		
		LOGGER.info(String.format("Show parse"));
		return resultText;	
	}
	
	/**Task 12. Из текста удалить все слова заданной длины, начинающиеся на согласную букву.*/
	public static String taskAction(String text, Integer number) {
		
		StringBuilder resultText = new StringBuilder("");
		String regexString = String.format("(\\b[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩqwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]{1}[a-zA-Zа-яА-Я]{%d}\\b)", number-1);
		Pattern pattern = Pattern.compile(regexString);
	   	Matcher matcher = pattern.matcher(text);
	   	
	   	resultText.append(matcher.replaceAll(""));
       	
      	LOGGER.info("Result Task_12.");
		return resultText.toString();
	}
}
