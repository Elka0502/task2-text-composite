package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Paragraph;
import by.pokumeiko.service.ActionsButton;

class RecoverText {

	@Test
  	public void testRecover () {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Paragraph("Книга ориентирована на читателей,"
				+ " уже имеющих опыт в программировании на каком-либо языке. "
				+ "В десятом издании рассматривается Java SE 8."));
		ActionsButton.compositeText.addChild(new Paragraph(" Книга состоит из двух томов."
				+ " В данной подборке рассматривается первый том."));
		
        Assertions.assertEquals("Книга ориентирована на читателей,"
        		+ " уже имеющих опыт в программировании на каком-либо языке. "
        		+ "В десятом издании рассматривается Java SE 8.\n Книга состоит из двух томов."
        		+ " В данной подборке рассматривается первый том.\n", 
        		ActionsButton.recoverAction());
    }
}
