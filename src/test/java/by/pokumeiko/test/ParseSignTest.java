package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Sign;
import by.pokumeiko.service.ActionsButton;

class ParseSignTest {
	
	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Sign("ь"));
		ActionsButton.compositeText.addChild(new Sign("ъ"));
			
		Assertions.assertEquals("Sign: \"ь\"\nSign: \"ъ\"\n", 
	    		ActionsButton.showParseTextAction("Sign"));
	}
}
