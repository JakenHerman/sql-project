
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


// Library program. Admin can add or delete books from the Library. 
// User's can login and checkin/checkout books to add to their list.
// On exiting, program should save all additions/deletions of books to a text file.
// When used again, program will read saved info from text file and update GUI

@SuppressWarnings({ "serial", "unused" })
public class Login extends JFrame
{
	
	//GUI 
 private Container screen;
 private JLabel idLabel, passwordLabel, message;
 private JPasswordField password;
 private JTextField id;


 // Constructor
 public Login( )
 {
  super( "Login" );
  screen = getContentPane( );
  screen.setLayout( new FlowLayout( ) );
 
  idLabel = new JLabel( "Enter id" ); // id label
  id = new JTextField( "", 12 );      // create text field for ID

  passwordLabel = new JLabel( "Enter password" ); // password label
  password = new JPasswordField( 8 ); // create password field
  password.setEchoChar( '*' );        // password will show up as '****'
  setSize( 500,400 );
  setVisible( true );

  JLabel message = new JLabel("Log in to access database", SwingConstants.CENTER);
  
 
  JButton loginButton = new JButton("Login");
  // put items into the container
  
  screen.add( idLabel );
  screen.add( id );
  screen.add( passwordLabel );
  screen.add( password );
  screen.add( message);
  screen.add(loginButton);


  Choices actionButton = new Choices();
  loginButton.addActionListener(actionButton);
  
  
 }
 
 public class Choices implements ActionListener         // What to do when button is pressed
 {
 public void actionPerformed( ActionEvent eventButton )
 {
	// If login is pressed and username/password are NOT EMPTY
 	if(eventButton.getActionCommand().equals("Login"))
 	{
 		
    boolean found = false; // boolean value, defaulted to false, true whenever correct login information is entered
	String userID = " ";      // Place holders for the file to read and enter information                   
    String userPassword = " ";                       
    String name = " "; 
	String ID = id.getText();
	String PASS = new String(password.getPassword());
  	ArrayList<Object>myList = new ArrayList<Object>();  //Create Array List of objects to hold user's books
  
  	   
  	if(ID.equals("admin") && ( PASS.equals("password")) && ((!ID.equalsIgnoreCase("") && !PASS.equals(""))))
   	{
   		
        found = true;
   		GUI adminGUI = new GUI();

   		
   	}
   	else if (!ID.equals("admin") && ( !PASS.equals("password")) && ((!ID.equalsIgnoreCase("") || !PASS.equals("")))){  // else admin info not entered, so we will see if we have the user info already saved in text file.                                
		try
	   {
	   	 Object tbook;        // Object variable to hold a book
	   	 String author1,title1;

	   	 String userid = id.getText();
	   	 String userpass = new String(password.getPassword());

	     FileReader fr = new FileReader( "user.txt");   // read from user.txt
	     BufferedReader br = new BufferedReader( fr );
	     myList.clear();

	     
	     String stringRead = br.readLine( );      //store read values into String variable
	  
	     while( stringRead != null || !found) // end of the file?
	     {
			// read lines
	    	 
	    	 StringTokenizer st = new StringTokenizer( stringRead, "," );  // Every time a "," is encountered in the text file it saves everything read since the last comma
		     userID = st.nextToken( );      // User Id is listed first                              
		     userPassword = st.nextToken(); // Password is after userID                             
		     name = st.nextToken();         // user's actual name                               
		     int noBooks = Integer.parseInt(st.nextToken()); // number of books in user list



		       	// if the user entered a name and password that equals an already saved username and password
		   	if (userid.equals(userID) && (userpass.equals(userPassword)))        
		   	{                                                                    
		  
		   		found = true;

			   	for(int ct = 0; ct < noBooks; ct++)      //Loop through the number of books previously saved
			   	{
				   		String title = st.nextToken( );  
		       			String author = st.nextToken();
		       			char type = st.nextToken().charAt(0); //Save the genre

                      
				    if (type == 'F') // if genre = fiction
				    {
				    	Fiction FicBook = new Fiction(title,author,'F');  // create a Fiction book with the read value from text file
						myList.add(FicBook);      // add to array list to hold current user's books                 
						myList.trimToSize();      
				    }
					else if (type == 'N') // if genre = nonfiction
				    {

						NonFiction nonFicBook = new NonFiction(title,author,'N');
						myList.add(nonFicBook);
						myList.trimToSize();
				    }



				}
		  }


			stringRead = br.readLine( );
	     }


			User tempUser = new User(userID,userPassword,name,myList);        //Create user object to hold the read user's data
			userGUI tempGUI = new userGUI(tempUser);                         // Create GUI for the user
			br.close( );
	   }

   	
	 	catch( FileNotFoundException fnfe )
	   {
	     System.out.println( "Unable to find user.txt" );
	   }

	   catch( IOException ioe )
	   {
	     ioe.printStackTrace( );
	   }

		}



if (!found)
{
	JOptionPane.showMessageDialog(null,
    		"Title or author is empty or not valid");
}
}
 
 }
 } 
	 public static void main( String [] args )
	 {
		 
	  Login login = new Login( );
	  login.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  
	 }
}
