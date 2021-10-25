package by.pokumeiko.service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Enumeration;
import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 900;
	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_SIZE = 16;
	private static final String DEFAULT_FONT = "Serif";
	private static final String textStart = "Книга довольно небольшая (около 190 страниц)."
			+ " В ней достаточно сжато подаются основы языка Java, но после прочтения книги"
			+ " станет возможным писать собственные приложения на Java.\nПособие наполнено:"
			+ " иллюстрациями, поясняющими результат исполнения кода. Книга подойдет для тех,"
			+ " кому нужно максимально быстро освоить синтаксис Java.";
	
	private ButtonGroup group;
	private JTextArea textArea;
	private JPanel panelSouth;
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JRadioButton radiobutton;
	private JScrollPane scroll;
	private JButton buttonShowParseText;
	private JButton buttonParseText;
	private JButton buttonRecover;
	private JButton buttonTask;

	/**Create frame*/
	public void frame() {
	    panelSouth = new JPanel();
	    panelNorth = new JPanel();
	    panelCenter = new JPanel();
	    
	    addButtonParseText("Parse text");
	    addButtonRecover("Recover text");
		addButtonTask("Task_12");
		addTextArea();
		
        group = new ButtonGroup();
        addRadioButton("Consonant");
        addRadioButton("Vowel");
        addRadioButton("Sign");
        addRadioButton("Numbers");        
        addRadioButton("Char");
        addRadioButton("Word/Punctuation");
		addRadioButton("Sentence");
		addRadioButton("Paragraph");
		addRadioButton("All");

		addButtonShowParseText("Show parse text");	
		addFrame ("task2-text-composite");
	}

	/**Add Frame*/
	private void addFrame (String name) {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	    setResizable(false);
	    setTitle (name);
	    setLocation((dimension.width - getWidth()) / 2, (dimension.height - getHeight()) / 2);
	    
	    getContentPane().add(BorderLayout.CENTER, panelCenter);
        getContentPane().add(BorderLayout.SOUTH, panelSouth);
        getContentPane().add(BorderLayout.NORTH, panelNorth);
        
        add(scroll);
        setVisible(true);
	}
	
	/**Add TextArea to panel*/
	private void addTextArea() {
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText(textStart);
		panelCenter.add(textArea);
		
		scroll = new JScrollPane (textArea);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panelCenter.add(scroll);
	    
	}
	
	/**Add RadioButton to panel*/	
	private void addRadioButton(String name) {
		
		radiobutton = new JRadioButton(name, false);
		radiobutton.setFont(new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_SIZE));
		group.add(radiobutton);
		panelSouth.add(radiobutton);
		radiobutton.setSelected(true);
		
	}

	/**Add ButtonParseText to panel*/
	private void addButtonParseText(String name) {
		
		buttonParseText = new JButton(name);
		buttonParseText.setFont(new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_SIZE));
		panelNorth.add(buttonParseText);
		
		ActionListener listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				if (!textArea.getText().equals("")) {
					
					ActionsButton.parseAction(textArea.getText());
										
					buttonShowParseText.setEnabled(true);
					buttonRecover.setEnabled(true);
					buttonParseText.setEnabled(false);
					
				} else JOptionPane.showMessageDialog(null, "Enter text!");
			}
		};

		buttonParseText.addActionListener(listener);
	}
			
	/**Add ButtonShowParseText to panel*/	
	private void addButtonShowParseText(String name) {
		
		buttonShowParseText = new JButton(name);
		buttonShowParseText.setFont(new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_SIZE));
		panelSouth.add(buttonShowParseText);
		buttonShowParseText.setEnabled(false);
		
		ActionListener listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button1 = buttons.nextElement();
		            if (button1.isSelected()) {
		            	
		               	textArea.setText(ActionsButton.showParseTextAction(button1.getText()));
		            	textArea.setCaretPosition(0);
		           
		            }
				}
			}
		};
		
		buttonShowParseText.addActionListener(listener);
	}
	
	/**Add ButtonRecover to panel*/
	private void addButtonRecover(String name) {
		
		buttonRecover = new JButton(name);
		buttonRecover.setFont(new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_SIZE));
		panelNorth.add(buttonRecover);
		buttonRecover.setEnabled(false);
		
		ActionListener listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				textArea.setText(ActionsButton.recoverAction());
				textArea.setCaretPosition(0);
				
				buttonShowParseText.setEnabled(false);
				buttonRecover.setEnabled(false);
				buttonParseText.setEnabled(true);
			}
		};
		
		buttonRecover.addActionListener(listener);
	}
	
	/**Add ButtonTask to panel*/	
	private void addButtonTask(String name)	{

		buttonTask = new JButton(name);
		buttonTask.setFont(new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_SIZE));
		panelNorth.add(buttonTask);
		
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				String inputString;
				
				if (!textArea.getText().replaceAll("[\\s\\t\\n]", "").equals("")) {
					
					inputString = JOptionPane.showInputDialog(null,	"Task 12. Из текста удалить все слова заданной длины,"
	            			+ " начинающиеся на согласную букву.\nВведите длину слова: ");
					
	            	if (!(inputString==null)) {
		                if (NumberUtils.isDigits(inputString)) {
		                    textArea.setText(ActionsButton.taskAction(textArea.getText(), Integer.parseInt(inputString)));
		                   	textArea.setCaretPosition(0);
		                } else {
		                	JOptionPane.showMessageDialog(null, "Input value is not correct");
		                }
	            	}
	            	
				} else JOptionPane.showMessageDialog(null, "Enter text!");
			}
		};
		
		buttonTask.addActionListener(listener);
	}
}
