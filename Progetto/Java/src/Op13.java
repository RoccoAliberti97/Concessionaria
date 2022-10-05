import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Op13 {
	
	private Statement stmt;
	
	public Op13(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui13() throws SQLException {

        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello, InfoRip\r\n" + 
        		"FROM riparazione, automobile, revisione\r\n" + 
        		"where Codice = Auto and Rip1 = CodRip and DataFineRev IS NULL");

        System.out.println("Le auto riparate:");
        System.out.println("MARCA\t\tMODELLO\t\tINFO RIPARAZIONI");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t\t");
        System.out.print(rs.getString("Modello") + "\t\t");
      	System.out.println(rs.getString("InfoRip")); }

        rs.close();
        
	}
}