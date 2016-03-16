package notthensa;

import java.sql.*;

public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect(String user, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/notthensa",user, password);
            st = con.createStatement();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public boolean userValidation(String user, String pass) throws Exception{
        String query = "Select * from users_table Where username='" + user + "' and password='" + pass + "'";
        try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (rs.next()) {
            return true;
        } else {
        	 return false;
        }
    }
    
}