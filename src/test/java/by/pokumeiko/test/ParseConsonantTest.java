package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Consonant;
import by.pokumeiko.service.ActionsButton;

class ParseConsonantTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Consonant("к"));
		ActionsButton.compositeText.addChild(new Consonant("д"));
		ActionsButton.compositeText.addChild(new Consonant("t"));
		ActionsButton.compositeText.addChild(new Consonant("n"));
		
		Assertions.assertEquals("Consonant: \"к\"\nConsonant: \"д\"\nConsonant: \"t\"\nConsonant: \"n\"\n", 
        		ActionsButton.showParseTextAction("Consonant"));
	}
}
