package by.pokumeiko.test;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import by.pokumeiko.service.ActionsButton;


class TaskTest {

	@ParameterizedTest
    @MethodSource("task12")
	public void testTask (String text, Integer number, String result) {
			
		String textTest = text;
		Integer numberTest = number;
 
		String resultText = ActionsButton.taskAction(textTest, numberTest); 
		
        Assertions.assertEquals(result, resultText);
    }
	
	public static Stream<Object> task12() {
		String startString1 = "Книга по Java довольно небольшая (около 190 страниц).";
		String resultString1 = " по Java довольно небольшая (около 190 страниц).";
		
		String startString2 = "В ней достаточно сжато подаются основы языка Java,"
		 		+ " но после прочтения книги станет возможным писать собственные приложения на Java.";
		String resultString2 = "В ней достаточно  подаются основы языка Java, "
				+ "но  прочтения  станет возможным писать собственные приложения на Java.";

		return Stream.of (
				 Arguments.of (startString1, 5, resultString1),
				 Arguments.of (startString2, 5, resultString2)
		);
	}
	
}
