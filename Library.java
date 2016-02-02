import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.*;


public class Library
{
	private ArrayList<Object> bookList = new ArrayList<Object>();         // to store the entire library book list

	private ArrayList<Object>myList = new ArrayList<Object>();           // to store a user's specific book list
	private int location =-1;                                            // used in LookUp() default set to -1

	private ArrayList<User>users = new ArrayList<User>();               
	private ArrayList<Object>tempMyList = new ArrayList<Object>();
	private User tempUser;

	public Library()
	{
		ReadBooks();

	}
	public Library(User temp)
	{
		tempUser = temp;
		ReadBooks();
		ReadUsers();
	}



public void AddBooks (String newTitle, String newAuthor, char newType)
	{


    	boolean found = LookUp(newTitle, newAuthor);

		if(found)
		{
			System.out.println("The book is already in the list.");
		}
		else if(newType=='F' && found == false)
		{
			Fiction ficBook = new Fiction(newTitle,newAuthor,newType);

			bookList.add(ficBook);


		}
		else if(newType=='N' && found == false)
		{
			NonFiction nonFicBook = new NonFiction(newTitle,newAuthor,newType);
			bookList.add(nonFicBook);

		}
		else if(newType=='B' && found == false)
		{

			System.out.println("Must have nonfiction or fiction selected.");

		}

			bookList.trimToSize();
			WriteBooks();
			ReadBooks();




	}

public String RemoveBook(String newTitle, String newAuthor)
	{
		boolean found = LookUp(newTitle, newAuthor);
		String out = "";

		if (found)
		{
			bookList.remove(getLocation());
			bookList.trimToSize();
			WriteBooks();
			ReadBooks();

		out = ("Book has been removed.");

		}
		else
		{
			out=("Book not found");
		}

		return out;
	}

public boolean LookUp(String newTitle, String newAuthor)
	{
	Object tbook;
 	String title1= "", author1="";
	boolean found = false;
	int booklistsize= bookList.size()-1;
	for(int i = 0; i <booklistsize; i++)
	{
		tbook = bookList.get(i);
		System.out.println(tbook);

		if(tbook instanceof Fiction)
	{
		Fiction tbookFiction =(Fiction)tbook;
		title1 = tbookFiction.getTitle();
		author1 = tbookFiction.getAuthor();
	}
		else if (tbook instanceof NonFiction)
	{
		NonFiction tbookNonFiction = (NonFiction)tbook;
		title1 = tbookNonFiction.getTitle();
		author1 = tbookNonFiction.getAuthor();
	}

	if(title1.equals(newTitle) && author1.equals(newAuthor))
	{
		found = true;
		setLocation(i);
	}



}
	return found;

	}



public void ReadBooks()
	{
try
   {
     FileReader fr = new FileReader( "books.txt" );
     BufferedReader br = new BufferedReader( fr );
	 bookList.clear();
     // declare String variable and prime the read
     String stringRead = br.readLine( );
     
     while( stringRead != null ) // end of the file?
     {
	// process the line read
    	    StringTokenizer st = new
         	StringTokenizer( stringRead, "," );
       		String title = st.nextToken();
       		String author = st.nextToken();
       		char type = st.nextToken().charAt(0);
		if (type=='F')
		{
			Fiction ficBook = new Fiction(title, author, 'F');

			bookList.add(ficBook);
		}

		else if(type=='N')
		{
			NonFiction nonFicBook = new NonFiction(title, author,'N');

			bookList.add(nonFicBook);
		}

		else if (type == 'B')
		{
			NonFiction nonFicBook = new NonFiction(title, author,'N');
			Fiction ficBook = new Fiction(title, author, 'F');
			bookList.add(nonFicBook);
			bookList.add(ficBook);

		}
		bookList.trimToSize();

       // read the next line
       stringRead = br.readLine( );
     }

     // release resources associated with "books.txt"
     br.close( );

  }
   catch( FileNotFoundException fnfe )
   {
     System.out.println( "Unable to find books.txt" );
   }

   catch( IOException ioe )
   {
     ioe.printStackTrace( );
   }


 }


public int getLocation()
{
	return location;
}
public void setLocation(int i)
{
	location = i;
}
public void WriteBooks()
	{
		try
    {
       FileWriter fw = new FileWriter( "books.txt", false );
       // false means we will be writing to output.txt,
       // rather than appending to it

       BufferedWriter bw = new BufferedWriter( fw );

		for ( Object bookRef : bookList )
		{
			if (bookRef instanceof Fiction)            // if object bookRef is of type Fiction
			{
				Fiction tbookFiction = (Fiction)bookRef; //cast it to fiction and write to text file with commas in between
				bw.write(tbookFiction.getTitle()+","+ tbookFiction.getAuthor()+","+ tbookFiction.getType()+","+System.getProperty("line.separator"));

			}

			else if(bookRef instanceof NonFiction)    // if object bookRef is of type nonfiction
			{
				NonFiction tbookNonFiction = (NonFiction)bookRef;  // Cast it to nonfic and write to text file
				bw.write(tbookNonFiction.getTitle()+","+ tbookNonFiction.getAuthor()+","+ tbookNonFiction.getType()+ "," + System.getProperty("line.separator"));

			}
		}

        bw.close( );
        System.out.println( "File written successfully" );
    }
    	catch( IOException ioe )
    	{
      		ioe.printStackTrace( );
    	}

  }

public void SortBooks()
	{
	Object tbook, sbook;
 	String title1= "";
 	String title2= "";
 	int bookListSize = bookList.size()-1;
 	for(int i = 0; i < bookListSize; i++)
 	  for(int ct = 0; ct < bookListSize - i; ct++)
 	  {
 	  	tbook = bookList.get(ct);
 	  	sbook = bookList.get(ct+1);

 	  	if (tbook instanceof Fiction)
 	  	{
 	  		Fiction tbookFiction = (Fiction)tbook;
 	  		title1 = tbookFiction.getTitle();
 	  	}

		else if (tbook instanceof NonFiction)
		{
			NonFiction tbookNonFiction = (NonFiction)tbook;
			title1 = tbookNonFiction.getTitle();
		}
		if (sbook instanceof Fiction)
 	  	{
 	  		Fiction sbookFiction = (Fiction)sbook;
 	  		title2 = sbookFiction.getTitle();
 	  	}

		else if (sbook instanceof NonFiction)
		{
			NonFiction sbookNonFiction = (NonFiction)sbook;
			title2 =sbookNonFiction.getTitle();
		}

		if (title1.compareTo(title2) > 0)         // if title1 is after title 2 alphabetically
 	  	{
 	  		bookList.set( ct, sbook);
 	  		bookList.set( ct+1, tbook);
 	  	}
 	  }




	}


public String getBookList(char type)
 {
 	SortBooks();                    // first sort
 	String outStringList = " ";     // placeholder strings for output       
 	String ficStringList = " ";
 	String nonFicStringList = " ";

	for(int ct=0; ct < bookList.size(); ct++)
	{
		Object obj = bookList.get(ct);  //Gets first book in the list to see what genre it is

		if( obj instanceof Fiction)
		{

			Fiction ficBook = (Fiction) obj;

			//ADD THE TITLE AND AUTHOR TO STRING

			ficStringList += ficBook.getTitle() + "  " + ficBook.getAuthor() + "\n";

		}
		else if(obj instanceof NonFiction)
		{
			NonFiction nonFicBook = (NonFiction) obj;
			nonFicStringList += nonFicBook.getTitle()+ "  " + nonFicBook.getAuthor()+ "\n";

		}



	}
		
		switch(type)
		{

			case 'F':
			{

				outStringList = ficStringList; //ADD FICTION LISTING TO THE FINAL LIST
				break;
			}
			case 'N':
			{
				outStringList = nonFicStringList; //ADD NONFICTION LISTING TO THE FINAL LIST
				break;
			}
			case 'B':
			{
				outStringList += ficStringList + nonFicStringList;

				//ADD BOTH LISTS
				break;
			}

		}

		return 	outStringList;



 }
 
 public String checkIn(String newTitle, String newAuthor)   
{
		boolean found = LookUpUser(newTitle,newAuthor);
		String out = "";

		if (found)
	{
			myList.remove(location);
			myList.trimToSize();
			WriteUsers();
			ReadUsers();

		    out = ("Book has been removed from your list and added to the library's.");

	}




		else
	{
			out=("Book not found");
	}

		return out;
	}
public void checkOut (String newTitle, String newAuthor, char newType)
	{


	 if(newType=='F')
	{
			Fiction ficBook = new Fiction(newTitle,newAuthor,'F');

			myList.add(ficBook);
			myList.trimToSize();
			tempMyList.add(ficBook);
			tempMyList.trimToSize();
			


	}
		else if(newType=='N')
	{
			NonFiction nonFicBook = new NonFiction(newTitle,newAuthor,'N');
			myList.add(nonFicBook);
			myList.trimToSize();
			tempMyList.add(nonFicBook);
			tempMyList.trimToSize();
			
	}


}





public boolean LookUpUser(String newTitle, String newAuthor)          // look up user books
	{
	Object tbook;
 	String title1= "", author1="";
	boolean found = false;
	myList = tempUser.getMyList();
	int mylistsize = myList.size()-1;
	for(int i = 0; i <mylistsize; i++)
	{
		tbook = myList.get(i);

		if(tbook instanceof Fiction)                              
	{
		Fiction tbookFiction =(Fiction)tbook;
		title1 = tbookFiction.getTitle();
		author1 = tbookFiction.getAuthor();
	}
		else if (tbook instanceof NonFiction)
	{
		NonFiction tbookNonFiction = (NonFiction)tbook;
		title1 = tbookNonFiction.getTitle();
		author1 = tbookNonFiction.getAuthor();
	}

	if(title1.equals(newTitle) && author1.equals(newAuthor))
	{
		found = true;
		location = i;
	}



}
	return found;

	}

public void ReadUsers()
	{

try
   {
     FileReader fr = new FileReader( "user.txt" );
     BufferedReader br = new BufferedReader( fr );
     String stringRead = br.readLine( );

     while( stringRead != null )
     {

       		StringTokenizer st = new StringTokenizer( stringRead, "," );
       		String userID = st.nextToken( );
		    String userPassword = st.nextToken();
		    String name = st.nextToken();
		    int noBooks = Integer.parseInt(st.nextToken());

		for(int ct = 0; ct<noBooks;ct++)
		{
			String title = st.nextToken( );
       		String author = st.nextToken();
       		char type = st.nextToken().charAt(0);

		if (type=='F')
		{


			Fiction ficBook = new Fiction(title, author, 'F');
			tempMyList.add(ficBook);
			tempMyList.trimToSize();
			

		}

		else if(type=='N')
		{
			NonFiction nonFicBook = new NonFiction(title, author,'N');
			tempMyList.add(nonFicBook);
			tempMyList.trimToSize();
			


		}
		}
		if(userID.equals(tempUser.getUserID()) && userPassword.equals(tempUser.getUserPassword()))
		{
			users.add(tempUser);
			users.trimToSize();

		}
		
		else
		{
			User tUser = new User(userID,userPassword,name,tempMyList);
			users.add(tUser);
			users.trimToSize();
		}

		

	
		

       // read the next line
       stringRead = br.readLine( );
     }

     // release resources associated with "books.txt"
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


public void WriteUsers()
	{
		try
    {
       FileWriter fw = new FileWriter( "user.txt", false );
       
       // false means we will be writing to user.txt,
       // rather than appending to it

       BufferedWriter bw = new BufferedWriter( fw );

		for (int ct = 0; ct< users.size()-1;ct++)
		{	System.out.println(users.size());
			User tempUser = users.get(ct);
			
			tempMyList = tempUser.getMyList();
			int size = tempMyList.size();
			String out =(tempUser.getUserID() + "," + tempUser.getUserPassword() + "," + tempUser.getName()+ "," + size + ",");
			bw.write(out);

		for( int i=0; i<tempMyList.size(); i++)
		{	Object tbook = tempMyList.get(i);

			if (tbook instanceof Fiction)
			{
				Fiction tbookFiction = (Fiction)tbook;
				String fic = (tbookFiction.getTitle() + "," + tbookFiction.getAuthor() + "," + tbookFiction.getType() + ",");
				bw.write(fic);
			}
			
			else if (tbook instanceof NonFiction)
			{
				NonFiction nonficbook = (NonFiction)tbook;
				String nonfic = (nonficbook.getTitle() + "," + nonficbook.getAuthor() + "," + nonficbook.getType() + ",");
				bw.write(nonfic);
			}

		}
		
		
		

		}
		
        bw.close( );
        System.out.println( "File written successfully" );
    }
    	catch( IOException ioe )
    	{
      		ioe.printStackTrace( );
    	}

  }




public void SortUserBooks()
	{
	Object tbook, sbook;
 	String title1= "";
 	String title2= "";
 	int myListSize = myList.size()-1;
 	for(int i = 0; i < myListSize; i++)
 	  for(int ct = 0; ct < myListSize - i; ct++)
 	  {
 	  	tbook = myList.get(ct);
 	  	sbook = myList.get(ct+1);

 	  	if (tbook instanceof Fiction)
 	  	{
 	  		Fiction tbookFiction = (Fiction)tbook;
 	  		title1 = tbookFiction.getTitle();
 	  	}

		else if (tbook instanceof NonFiction)
		{
			NonFiction tbookNonFiction = (NonFiction)tbook;
			title1 = tbookNonFiction.getTitle();
		}
		if (sbook instanceof Fiction)
 	  	{
 	  		Fiction sbookFiction = (Fiction)sbook;
 	  		title2 = sbookFiction.getTitle();
 	  	}

		else if (sbook instanceof NonFiction)
		{
			NonFiction sbookNonFiction = (NonFiction)sbook;
			title2 =sbookNonFiction.getTitle();
		}

		if (title1.compareTo(title2) > 0)
 	  	{
 	  		myList.set( ct, sbook);
 	  		myList.set( ct+1, tbook);
 	  	}
 	  }




	}






public String getMyList(char type)
 {
 	SortUserBooks();

 	String outStringList = " ";


 	String ficStringList = " ";
 	String nonFicStringList = " ";


	myList = tempUser.getMyList();

	for(int ct=0; ct < myList.size(); ct++)
	{

		Object obj = myList.get(ct);


		if( obj instanceof Fiction)
		{

			Fiction ficBook = (Fiction) obj;
			ficStringList += ficBook.getTitle()+ " " + ficBook.getAuthor() + "\n";

		}
		else if(obj instanceof NonFiction)
		{
			NonFiction nonFicBook = (NonFiction) obj;
			nonFicStringList += nonFicBook.getTitle()+ "  " + nonFicBook.getAuthor()+ "\n";

		}



	}

		switch(type)
		{

			case 'F':
			{
				outStringList = ficStringList;
				break;
			}
			case 'N':
			{
				outStringList = nonFicStringList;
				break;
			}
			case 'B':
			{
				outStringList += ficStringList + nonFicStringList;


				break;
			}

		}

		return 	outStringList;



 }
 
 
 
 
 
 
 
 
 
 
 
  
	}

