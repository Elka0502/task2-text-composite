package by.pokumeiko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.pokumeiko.models.CompositeText;
import by.pokumeiko.models.Punctuation;
import by.pokumeiko.models.Word;
import by.pokumeiko.service.ActionsButton;

class ParseWordPunctuationTest {

	@Test
	void test() {
		ActionsButton.compositeText = new CompositeText("");
		ActionsButton.compositeText.addChild(new Word("Эта"));
		ActionsButton.compositeText.addChild(new Word("книга"));
		ActionsButton.compositeText.addChild(new Punctuation("-"));
		ActionsButton.compositeText.addChild(new Word("короткое"));
		ActionsButton.compositeText.addChild(new Word("введение"));
		ActionsButton.compositeText.addChild(new Word("в"));
		ActionsButton.compositeText.addChild(new Word("Java"));
		ActionsButton.compositeText.addChild(new Punctuation("."));

		Assertions.assertEquals("Word: Эта\nWord: книга\nPunctuation: -\nWord: короткое\nWord: введение\nWord: в\nWord: Java\nPunctuation: .\n", 
        		ActionsButton.showParseTextAction("Word/Punctuation"));
	}
}
