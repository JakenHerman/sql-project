package notthensa;
public class NonFiction extends Book
{
	private char type;   // Genre

 public NonFiction()
    {
    	super(); 
		type = 'N';

    }

    public NonFiction(String title,
                 String author,char type)
   {
   	   
   	   super(title, author);
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
		String out = super.toString() + " \nGenre = NonFiction";
		return out;
   }



}