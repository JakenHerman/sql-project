package notthensa;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.text.*;



@SuppressWarnings({ "unused", "serial" })
public class GUI extends JFrame
{ 
private JTextField txtAuthor, txtTitle;
private JLabel lblBookAuthor, lblBookTitle, lblLibraryName;

private JTextArea messageArea;
private JButton cmdList, cmdAdd, cmdDelete, cmdExit;
private JRadioButton both, fiction, nonfiction;
private Container contents;
private Library theWholeLibrary;
public GUI()
{
	super("BookList Library");
	theWholeLibrary = new Library();         // name of library object being created

txtAuthor = new JTextField (20);
txtTitle = new JTextField (20);

lblLibraryName = new JLabel("BookList Library");
lblBookTitle = new JLabel("Book Title");
lblBookAuthor = new JLabel("Book Author");

//text field

//message area to display information inside opened window
messageArea = new JTextArea();
messageArea.setPreferredSize(new Dimension(200, 200));




// radio buttons to select book genre
fiction = new JRadioButton( "Fiction", false );
nonfiction = new JRadioButton( "NonFiction", false);
both = new JRadioButton("Both", true);
//Buttons to press
cmdList = new JButton("LIBRARY LIST");
cmdAdd = new JButton("ADD");
cmdDelete = new JButton("DELETE");
cmdExit = new JButton("EXIT");

ButtonGroup group = new ButtonGroup();
group.add(both);
group.add(fiction);
group.add(nonfiction);

contents = getContentPane( );

contents.setLayout(new BorderLayout());

//panel 1 to display input information
JPanel p1 = new JPanel();
p1.setLayout(new GridLayout (2, 2));
p1.add(lblBookTitle);
p1.add(txtAuthor);
p1.add(lblBookAuthor);
p1.add(txtTitle);

//panel 2 to display output
JPanel p2 = new JPanel();
p2.setLayout(new FlowLayout());
p2.add(messageArea);



//panel 3 to display the buttons
JPanel p3 = new JPanel();
p3.setLayout(new FlowLayout());
p3.add(cmdList);
p3.add(cmdAdd);
p3.add(cmdDelete);
p3.add(cmdExit);

//panel 4 to display radio buttons
JPanel p4 = new JPanel();
p4.setLayout(new FlowLayout());

p4.add(both);
p4.add(fiction);
p4.add(nonfiction);

//action listener, senses when it is pressed
Choices btnAction = new Choices();
cmdList.addActionListener(btnAction);
cmdAdd.addActionListener(btnAction);
cmdDelete.addActionListener(btnAction);
cmdExit.addActionListener(btnAction);
fiction.addActionListener(btnAction);
nonfiction.addActionListener(btnAction);

// add the panels to the main screen
contents.add (p1, BorderLayout.NORTH);
contents.add (p2, BorderLayout.CENTER);
contents.add (p3, BorderLayout.SOUTH);
contents.add (p4, BorderLayout.EAST);

//Frame size
setSize(500, 500);

setVisible(true);
}
public class Choices implements ActionListener
{
public void actionPerformed( ActionEvent event )              
{
	if(event.getActionCommand().equals("LIBRARY LIST"))   // If LIBRARY LIST button is pressed
	{

	if(both.isSelected())                                 // if radio button "both" is selected
	{
		System.out.println("I AM IN LIST BOOKS");
		
		String bookStr = theWholeLibrary.getBookList('B');

		messageArea.setText(bookStr);
        messageArea.setEditable(false);




	}
	else if (fiction.isSelected())
	{
		System.out.println("I AM IN LIST BOOKS FICTION");

		String bookStr = theWholeLibrary.getBookList('F');

        messageArea.setText(bookStr);
        messageArea.setEditable(false);
	}
	else //Assume nonfiction
	{
		System.out.println("I AM IN LIST BOOKS NONFICTION");
		
		String bookStr = theWholeLibrary.getBookList('N');

        messageArea.setText(bookStr);
        messageArea.setEditable(false);

	}


}
if(event.getActionCommand().equals("ADD"))
{

		String title = txtTitle.getText();
		String author = txtAuthor.getText();

		if (title == "" || author == "")
		{
			JOptionPane.showMessageDialog(null,
    		"Title or author is empty");
			
		}

		else if (both.isSelected())
		{
			JOptionPane.showMessageDialog(null,
    		"To add a book, select fiction or nonfiction.");
		}

		else if (fiction.isSelected())
		{
			theWholeLibrary.AddBooks(title,author,'F');

		}

		else if (nonfiction.isSelected())
		{
			theWholeLibrary.AddBooks(title,author,'N');

		}
		System.out.println("I AM IN ADD BOOKS");


}
if(event.getActionCommand().equals("DELETE"))
{
		String title = txtTitle.getText();
		String author = txtAuthor.getText();

		if (title == "" || author == "")
		{
			JOptionPane.showMessageDialog(null,
    		"Title or author is empty");

		}

		else if (both.isSelected())
		{
			JOptionPane.showMessageDialog(null,
    		"To add a book, select fiction or nonfiction.");
		}

		else if (fiction.isSelected())
		{
			theWholeLibrary.RemoveBook(title,author);

		}

		else if (nonfiction.isSelected())
		{
			theWholeLibrary.RemoveBook(title,author);

		}



System.out.println("I AM IN DELETE BOOKS");
}
if(event.getActionCommand().equals("EXIT"))
{ // Exit Program
System.exit(0);
}

}
}
public static void main(String[] args)
{
GUI LibraryWindow = new GUI();
LibraryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}