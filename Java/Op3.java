import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Op3 {
	
	private Statement stmt;
	
	public Op3(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	
	public void Esegui3() throws SQLException{
		
		
        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello, Codice \n" + 
        		"FROM automobile\n" );

        System.out.println("MARCA\t\tMODELLO\t\tCODICE");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t\t");
      	System.out.print(rs.getString("Modello")+ "\t\t"); 
      	System.out.println(rs.getString("Codice"));
      	}

        rs.close();
        
	}
}