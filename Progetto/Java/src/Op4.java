import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Op4 {
	
	private Statement stmt;
	private Scanner in;
	
	public Op4(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui4() throws SQLException {
		
        System.out.println("Inserire Anno: ");        
        in = new Scanner(System.in);
        int n = in.nextInt();
        String d = n + "-01-01";
        String d1 = n + "-12-31";
        
        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello\r\n" + 
        		"FROM entratauscita, automobile\r\n" + 
        		"where Codice = CodiceProd and DataEntrata between \"" + d + "\"and\"" + d1 +"\"");

        System.out.println("Auto in entrata nell'anno " + n +":");
        System.out.println("MARCA\tMODELLO");
        while (rs.next()) {
        	System.out.print(rs.getString("Marca") + "\t"); 
            System.out.println(rs.getString("Modello") + "\t");}
      	

        rs.close();
       
}
}
