package javadb;

public class Agent {
    
    private int id;
    private String Name;
    private int AssignedSuspect;
   
   
    
    public Agent(int ID, String Name, int AssignedSuspect)
    {
        this.id = ID;
        this.Name = Name;
        this.AssignedSuspect = AssignedSuspect;
       
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public int getAssignedSuspect()
    {
        return AssignedSuspect;
    }
    
  
}

