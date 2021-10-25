package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Sentence;
import by.pokumeiko.service.ActionsButton;

class ParseSentenceTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Sentence("Цель этой книги — помочь в изучении Java."));
		ActionsButton.compositeText.addChild(new Sentence(" В ней описываются принципы создания приложений "
				+ "с графическим пользовательским интерфейсом на примере двух игр."));
		
		Assertions.assertEquals("Sentence: Цель этой книги — помочь в изучении Java.\nSentence:  В ней описываются принципы создания приложений "
				+ "с графическим пользовательским интерфейсом на примере двух игр.\n", 
        		ActionsButton.showParseTextAction("Sentence"));
	}
}
