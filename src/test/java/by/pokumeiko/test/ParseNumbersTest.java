package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Numbers;
import by.pokumeiko.service.ActionsButton;

class ParseNumbersTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Numbers("1"));
		ActionsButton.compositeText.addChild(new Numbers("2"));
		ActionsButton.compositeText.addChild(new Numbers("3"));
		ActionsButton.compositeText.addChild(new Numbers("4"));
		
		Assertions.assertEquals("Number: \"1\"\nNumber: \"2\"\nNumber: \"3\"\nNumber: \"4\"\n", 
        		ActionsButton.showParseTextAction("Numbers"));
	}
}
