package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.Char;
import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Consonant;
import by.pokumeiko.models.Numbers;
import by.pokumeiko.models.Paragraph;
import by.pokumeiko.models.Punctuation;
import by.pokumeiko.models.Sentence;
import by.pokumeiko.models.Vowel;
import by.pokumeiko.models.Word;
import by.pokumeiko.service.ActionsButton;

class ParseAllTest  {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Paragraph("Привет, Java7!"));
		ActionsButton.compositeText.addChild(new Sentence("Привет, Java7!"));
		ActionsButton.compositeText.addChild(new Word("Привет"));
		ActionsButton.compositeText.addChild(new Char("П"));
		ActionsButton.compositeText.addChild(new Consonant("П"));
		ActionsButton.compositeText.addChild(new Char("р"));
		ActionsButton.compositeText.addChild(new Consonant("р"));
		ActionsButton.compositeText.addChild(new Char("и"));
		ActionsButton.compositeText.addChild(new Vowel("и"));
		ActionsButton.compositeText.addChild(new Char("в"));
		ActionsButton.compositeText.addChild(new Consonant("в"));
		ActionsButton.compositeText.addChild(new Char("е"));
		ActionsButton.compositeText.addChild(new Vowel("е"));
		ActionsButton.compositeText.addChild(new Char("т"));
		ActionsButton.compositeText.addChild(new Consonant("т"));
		ActionsButton.compositeText.addChild(new Punctuation(","));
		ActionsButton.compositeText.addChild(new Word("Java7"));
		ActionsButton.compositeText.addChild(new Char("J"));
		ActionsButton.compositeText.addChild(new Consonant("J"));
		ActionsButton.compositeText.addChild(new Char("a"));
		ActionsButton.compositeText.addChild(new Vowel("a"));	
		ActionsButton.compositeText.addChild(new Char("v"));
		ActionsButton.compositeText.addChild(new Consonant("v"));
		ActionsButton.compositeText.addChild(new Char("a"));
		ActionsButton.compositeText.addChild(new Vowel("a"));
		ActionsButton.compositeText.addChild(new Char("7"));
		ActionsButton.compositeText.addChild(new Numbers("7"));
		ActionsButton.compositeText.addChild(new Punctuation("!"));
			
		Assertions.assertEquals("Paragraph: Привет, Java7!\n"
				+ "     Sentence: Привет, Java7!\n"
				+ "            Word: Привет\n"
				+ "                Char: \"П\" - consonant\n                Char: \"р\" - consonant\n                Char: \"и\" - vowel\n                Char: \"в\" - consonant\n                Char: \"е\" - vowel\n                Char: \"т\" - consonant\n"
				+ "            Punctuation: ,\n"
				+ "            Word: Java7\n"
				+ "                Char: \"J\" - consonant\n                Char: \"a\" - vowel\n                Char: \"v\" - consonant\n                Char: \"a\" - vowel\n                Char: \"7\" - number\n"
				+ "            Punctuation: !\n", 
        		ActionsButton.showParseTextAction("All"));
	}
}
