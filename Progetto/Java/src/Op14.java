import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Op14 {
	
	private Statement stmt;
	
	public Op14(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui14() throws SQLException {

        ResultSet rs=stmt.executeQuery("SELECT  Modello,Marca\r\n" + 
        		"FROM officina, automobile, revisione\r\n" + 
        		"where Codice = Auto and Rip1 = CodRip and DataFineRev IS NULL and TipoM = \"Usata\"");

        System.out.println("Auto usate presenti in officina:");
        System.out.println("MARCA\t\tMODELLO");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t\t");
      	System.out.println(rs.getString("Modello")); }

        rs.close();
        
	}
}