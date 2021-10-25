package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Vowel;
import by.pokumeiko.service.ActionsButton;

class ParseVowelTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Vowel("а"));
		ActionsButton.compositeText.addChild(new Vowel("ю"));
		ActionsButton.compositeText.addChild(new Vowel("i"));
		ActionsButton.compositeText.addChild(new Vowel("u"));
		
		Assertions.assertEquals("Vowel: \"а\"\nVowel: \"ю\"\nVowel: \"i\"\nVowel: \"u\"\n", 
        		ActionsButton.showParseTextAction("Vowel"));
	}
}
