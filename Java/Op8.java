import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Op8 {
	
	private Statement stmt;
	private Scanner in;
	
	public Op8(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui8() throws SQLException {
		
        System.out.println("Inserire Anno: ");        
        in = new Scanner(System.in);
        int n = in.nextInt();
        String d = n + "-01-01";
        String d1 = n + "-12-31";
        
        ResultSet rs=stmt.executeQuery("SELECT  automobile.*\r\n" + 
        		"FROM entratauscita, automobile\r\n" + 
        		"where Codice = CodiceProd and DataEntrata between \"" + d + "\"and\"" + d1 +"\"");
        
        System.out.println("Auto in entrata nell'anno " + n + ":");
        System.out.println("MARCA\t\tMODELLO\t\tTIPO\t\tPREZZO\t\tNUMSERIE\t\tNUMPROG\t\tANNOIMMA\t\tPARTITAIVA\t\tCHILOMETRI\t\tSEDE\t\tPADRONE\t\tMOTORE\t\tTELAIO\t\tDATAPRESTITO\t\tDATARESTITUZIONE");
        while (rs.next()) {
           	System.out.print(rs.getString("Marca") + "\t\t");
            System.out.print(rs.getString("Modello") + "\t\t");
          	System.out.print(rs.getString("TipoM") +"\t\t"); 
          	System.out.print(rs.getString("Prezzo") + "\t\t");
           	System.out.print(rs.getString("NumSerie")+ "\t\t"); 
            System.out.print(rs.getString("NumProg") + "\t\t");
          	System.out.print(rs.getString("AnnoImma")+ "\t\t"); 
          	System.out.print(rs.getString("PartitaIva") + "\t\t");
           	System.out.print(rs.getString("Chilometri")+ "\t\t"); 
           	System.out.print(rs.getString("SedeA")+ "\t\t"); 
          	System.out.print(rs.getString("Padrone") + "\t\t");
           	System.out.print(rs.getString("Motore")+ "\t\t"); 
            System.out.print(rs.getString("Telaio") + "\t\t");
            System.out.print(rs.getString("DataPrestito") + "\t\t");
          	System.out.println(rs.getString("DataRestituzione")+ "\t\t"); 
           	}

        rs.close();
        
	}
}
