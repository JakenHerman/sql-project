import java.util.*;
public class User
{

 private String userID = " ";
 private String userPassword = " ";
 private String name = " ";
 private ArrayList<Object>myList = new ArrayList<Object>();


public User(String id, String pass,String n, ArrayList<Object> UserList)
	{
		setUserID(id);
		setUserPassword(pass);
		setName(n);
		setArrayList(UserList); 

	}

public void setUserID(String id)
{
	userID = id;
}

public String getUserID()
{
	return userID;
}

public void setUserPassword(String pass)
{
	userPassword = pass;
}

public String getUserPassword()
{
	return userPassword;
}
public void setName(String newName)
{
	name = newName;
}

public String getName()
{
	return name;
}

public ArrayList <Object> getMyList()
{
	return myList;
}
public void setArrayList(ArrayList <Object> newList)
{
	myList = newList;
}



}