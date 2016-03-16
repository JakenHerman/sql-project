import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



@SuppressWarnings("serial")
public class userGUI extends JFrame
{ 
private JTextField txtBookAuthor, txtBookTitle;
private JLabel lblBookAuthor, lblBookTitle;

private JTextArea messageArea;
private JButton cmdMyList, cmdList, cmdCheckIn, cmdCheckOut, cmdExit;
private JRadioButton fiction, nonfiction, both;
private Container contents;
private User tempUser;


private Library libraryObject;
public userGUI(User temp)
{
	super("User Books");
	tempUser = temp;
	libraryObject = new Library(tempUser);



lblBookTitle = new JLabel("Book Title");
lblBookAuthor = new JLabel("Book Author");

txtBookAuthor = new JTextField (20);
txtBookTitle = new JTextField (20);

messageArea = new JTextArea();
messageArea.setPreferredSize(new Dimension(200, 200));

cmdMyList = new JButton("MYLIST");
cmdList = new JButton("LIST LIBRARY");
cmdCheckIn = new JButton("CHECKIN");
cmdCheckOut = new JButton("CHECKOUT");
cmdExit = new JButton("EXIT");

   both = new JRadioButton( "Both", false );
   fiction = new JRadioButton( "Fiction", false );
   nonfiction = new JRadioButton( "NonFiction", false);


ButtonGroup group = new ButtonGroup();

group.add(fiction);
group.add(nonfiction);
group.add(both);


contents = getContentPane( );

contents.setLayout(new BorderLayout());

JPanel p1 = new JPanel();
p1.setLayout(new GridLayout (2, 2));
p1.add(lblBookTitle);
p1.add(txtBookTitle);
p1.add(lblBookAuthor);
p1.add(txtBookAuthor);

JPanel p2 = new JPanel();
p2.setLayout(new FlowLayout());
p2.add(messageArea);






JPanel p3 = new JPanel();
p3.setLayout(new FlowLayout());
p3.add(cmdMyList);
p3.add(cmdList);
p3.add(cmdCheckIn);
p3.add(cmdCheckOut);
p3.add(cmdExit);



JPanel p4 = new JPanel();
p4.setLayout(new FlowLayout());

p4.add(both);
p4.add(fiction);
p4.add(nonfiction);


Choices btnAction = new Choices();
cmdMyList.addActionListener(btnAction);
cmdList.addActionListener(btnAction);
cmdCheckIn.addActionListener(btnAction);
cmdCheckOut.addActionListener(btnAction);
cmdExit.addActionListener(btnAction);

fiction.addActionListener(btnAction);
nonfiction.addActionListener(btnAction);


contents.add (p1, BorderLayout.NORTH);
contents.add (p2, BorderLayout.CENTER);
contents.add (p3, BorderLayout.SOUTH);
contents.add (p4, BorderLayout.EAST);

//frame size
setSize(500, 500);
//show frame
setVisible(true);
}
public class Choices implements ActionListener
{
	public void actionPerformed( ActionEvent event )
{

if(event.getActionCommand().equals("MYLIST"))
	{
		if(both.isSelected())
	{
			System.out.println("I AM IN MYLIST BOTH");
			String bookStr = libraryObject.getMyList('B');
        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);
	}
		else if(fiction.isSelected())
	{
			System.out.println("I AM IN MYLIST FICTION");
			String bookStr = libraryObject.getMyList('F');
        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);

	}else{
			System.out.println("I AM IN MYLIST NONFICTION");
			String bookStr = libraryObject.getMyList('N');
        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);

	}
	}
if(event.getActionCommand().equals("LIST LIBRARY"))
	{

		if(both.isSelected())
	{

			System.out.println("I AM IN LIST BOOKS");
			String bookStr = libraryObject.getBookList('B');
        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);

	}
		else if (fiction.isSelected())
	{
			System.out.println("I AM IN LIST BOOKS FICTION");
			String bookStr = libraryObject.getBookList('F');



        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);
	}
		else //Assume nonfiction
	{
			System.out.println("I AM IN LIST BOOKS NONFICTION");
			String bookStr = libraryObject.getBookList('N');



        	messageArea.setText(bookStr);
        	messageArea.setEditable(false);

	}
	}
if(event.getActionCommand().equals("CHECKIN"))
{

	String title = txtBookTitle.getText();
	String author = txtBookAuthor.getText();

	if (title == "" || author == "")
	{
		JOptionPane.showMessageDialog(null,
    	"Title or author is empty");

	}
	if (both.isSelected())
	{
		JOptionPane.showMessageDialog(null,
    	"Must have fiction or nonfiction selected.");
	}
	else if (fiction.isSelected())
	{ 	title = txtBookTitle.getText();
		author = txtBookAuthor.getText();
		libraryObject.checkIn(title,author);
		libraryObject.AddBooks(title,author,'F');
		String someStr = libraryObject.getBookList('F');
		messageArea.setText(someStr);
		messageArea.setEditable(false);
	}
	else if (nonfiction.isSelected())
	{	title = txtBookTitle.getText();
	    author = txtBookAuthor.getText();
	    libraryObject.checkIn(title,author);
	    libraryObject.AddBooks(title,author,'N');
		String someStr = libraryObject.getBookList('N');
		messageArea.setText(someStr);
		messageArea.setEditable(false);
	}
	System.out.println("I AM IN CHECKIN BOOKS");
	

}

if(event.getActionCommand().equals("CHECKOUT"))
{

	String title = txtBookTitle.getText();
	String author = txtBookAuthor.getText();

	if (title == "" || author == "")
	{
		JOptionPane.showMessageDialog(null,
    	"Title or author is empty");

	}
	if (both.isSelected())
	{
		JOptionPane.showMessageDialog(null,
    	"Fiction or nonfiction must be selected when checking in/out books");
	}
	else if (fiction.isSelected())
	{	title = txtBookTitle.getText();
	    author = txtBookAuthor.getText();
	    libraryObject.RemoveBook(title,author);
	    libraryObject.checkOut(title,author,'F');
		String someStr = libraryObject.getBookList('F');
		messageArea.setText(someStr);
		messageArea.setEditable(false);
	}
	else if (nonfiction.isSelected())
	{   title = txtBookTitle.getText();
	    author = txtBookAuthor.getText();
	    libraryObject.RemoveBook(title,author);
	    libraryObject.checkOut(title,author,'N');
		String someStr = libraryObject.getBookList('N');
		messageArea.setText(someStr);
		messageArea.setEditable(false);
	}
	System.out.println("I AM IN CHECKOUT BOOKS");

}

else if(event.getActionCommand().equals("EXIT"))    // Write new information to text file IF exit is pressed
{	
	libraryObject.ReadUsers();
	libraryObject.WriteUsers();
	System.exit(0);
}
	}

}
}
