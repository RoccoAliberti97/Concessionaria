import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Op6 {
	
	private Statement stmt;
	private Scanner in;
	
	public Op6(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui6() throws SQLException {
		
        System.out.println("Inserire Data: [AAAA-MM-GG]");        
        in = new Scanner(System.in);
        String d = in.nextLine();
        
        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello\r\n" + 
        		"FROM entratauscita, automobile\r\n" + 
        		"where Codice = CodiceProd and DataEntrata = \"" + d + "\"");

        System.out.println("Auto in entrata nella data " + d + ":");
        System.out.println("MARCA\tMODELLO");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t"); 
        System.out.println(rs.getString("Modello") + "\t");}
      	

        rs.close();
    
	}
}
