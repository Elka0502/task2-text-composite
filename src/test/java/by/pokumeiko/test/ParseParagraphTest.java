package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Paragraph;
import by.pokumeiko.service.ActionsButton;

class ParseParagraphTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Paragraph("Цель этой книги — помочь в изучении Java."));
		ActionsButton.compositeText.addChild(new Paragraph(" В ней описываются принципы создания приложений "
				+ "с графическим пользовательским интерфейсом на примере двух игр."));
		
		Assertions.assertEquals("Paragraph: Цель этой книги — помочь в изучении Java.\nParagraph:  В ней описываются принципы создания приложений "
				+ "с графическим пользовательским интерфейсом на примере двух игр.\n", 
        		ActionsButton.showParseTextAction("Paragraph"));
	}
}
