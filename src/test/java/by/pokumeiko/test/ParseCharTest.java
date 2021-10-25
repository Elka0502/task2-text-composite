package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.Char;
import by.pokumeiko.models.CompositeText;
import by.pokumeiko.service.ActionsButton;

class ParseCharTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Char("C"));
		ActionsButton.compositeText.addChild(new Char("h"));
		ActionsButton.compositeText.addChild(new Char("a"));
		ActionsButton.compositeText.addChild(new Char("r"));

		Assertions.assertEquals("Char: \"C\"\nChar: \"h\"\nChar: \"a\"\nChar: \"r\"\n", 
        		ActionsButton.showParseTextAction("Char"));
	}
	
}
