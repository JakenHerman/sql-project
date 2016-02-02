
public class Book
{
    // instance variables
    private String title;
    private String author;

    // Constructors:

    public Book( )
    {
       title = "unknown";

    }
    public Book( String startTitle,
                 String startAuthor)
    {
       title = startTitle;
       author = startAuthor;

    }

    // Accessor/mutator methods

    public String getTitle()
    {
       return title;
    }
    public String getAuthor()
    {
       return author;
    }

    public void setTitle( String newTitle )
    {
        title = newTitle;
    }

    public void setAuthor( String newAuthor )
    {
       author = newAuthor;
    }

    public String toString( )
    {

       return "Title: " + title
             + "\n Author: " + author;
    }

    // equals: returns true if fields of parameter object
    //         are equal to fields in this object
    public boolean equals( Book bookA )
    {
       if ( title.equals( bookA.title )
           && author.equals(bookA.author))
           return true;
       else
           return false;
    }
 }
