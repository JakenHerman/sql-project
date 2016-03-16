package notthensa;

public class Fiction extends Book
{

	private char type;

    public Fiction()
    {
    	super();            // call super class constructor
		type = 'F';

    }

    public Fiction(String title,
                 String author,char type)
   {
   	   
   	   super(title, author);                 //call Book's overloaded constructor
   	   setType(type);

   }

   public char getType()
   {
   	 return type;
   }


   public void setType(char newType)
   {
   		type = newType;

   }
   public String toString()
   {
		String out = super.toString() + " \nGenre = Fiction";
		return out;
   }



}