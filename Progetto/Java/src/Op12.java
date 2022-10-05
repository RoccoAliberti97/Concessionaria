import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Op12 {
	
	private Statement stmt;
	
	public Op12(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui12() throws SQLException {
		
	     ResultSet rs=stmt.executeQuery("SELECT * \r\n" + 
        		"from concessionaria.automobile \r\n"
        		+ "where DataRestituzione is NULL AND TipoM = \"Noleggio\"");
        
        
        System.out.println("Auto noleggiate:");
        System.out.println("MARCA\t\tMODELLO\t\tPREZZO\t\tNUMSERIE\t\tNUMPROG\t\tANNOIMMA\t\tSEDE\t\tMOTORE\t\tTELAIO\t\tDATAPRESTITO\t\tDATARESTITUZIONE");
        while (rs.next()) {
        	System.out.print(rs.getString("Marca") + "\t\t");
            System.out.print(rs.getString("Modello") + "\t\t");
          	System.out.print(rs.getString("Prezzo") + "\t\t");
           	System.out.print(rs.getString("NumSerie")+ "\t\t"); 
            System.out.print(rs.getString("NumProg") + "\t\t");
          	System.out.print(rs.getString("AnnoImma")+ "\t\t"); 
          	System.out.print(rs.getString("SedeA") + "\t\t");
           	System.out.print(rs.getString("Motore")+ "\t\t"); 
           	System.out.print(rs.getString("Telaio")+ "\t\t");
            System.out.print(rs.getString("DataPrestito") + "\t\t");
          	System.out.println(rs.getString("DataRestituzione")+ "\t\t"); 
        }

        rs.close();
       
	}
}
