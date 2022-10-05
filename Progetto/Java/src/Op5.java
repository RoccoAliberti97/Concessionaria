import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Op5 {
	
	private Statement stmt;
	
	public Op5(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui5() throws SQLException {
		
        ResultSet rs=stmt.executeQuery("SELECT  Modello,Marca\r\n" + 
        		"FROM entratauscita, automobile\r\n" + 
        		"where CodiceProd = Codice and DataUscita IS NULL");

        System.out.println("Le auto presenti in concessionaria:");
        System.out.println("MARCA\t\tMODELLO");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t\t");
      	System.out.println(rs.getString("Modello")); }

        rs.close();
        
	}
}