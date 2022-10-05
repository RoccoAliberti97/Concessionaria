import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Op7 {
	
	private Statement stmt;
	private Scanner in;
	
	public Op7(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui7() throws SQLException {
		
        System.out.println("Inserire Marca: ");        
        in = new Scanner(System.in);
        String d = in.nextLine();
        
        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello\r\n" + 
        		"FROM automobile\r\n" + 
        		"where Marca = \"" + d + "\"");

        System.out.println("Auto " + d + ":");
        System.out.println("MARCA\tMODELLO");
        while (rs.next()) {
        System.out.print(rs.getString("Marca") + "\t"); 
        System.out.println(rs.getString("Modello") + "\t");}
      	

        rs.close();
     
	}
}
