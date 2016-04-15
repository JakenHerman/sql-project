package javadb;

public class Suspect {
    
    private int id;
    private String Name;
    private int Threat;
    private int AssignedAgent;
    private String LastSeen;
    
    public Suspect(int ID, String Name, int Threat, int AssignedAgent, String LastSeen)
    {
        this.id = ID;
        this.Name = Name;
        this.Threat = Threat;
        this.AssignedAgent = AssignedAgent;
        this.LastSeen = LastSeen;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public int getThreat()
    {
        return Threat;
    }
    
    public int getAssignedAgent()
    {
        return AssignedAgent;
    }
    
    public String getLastSeen()
    {
        return LastSeen;
    }
}

