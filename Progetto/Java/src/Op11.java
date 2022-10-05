import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Op11 {
	
	private Statement stmt;
	
	public Op11(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui11() throws SQLException {
		
        ResultSet rs=stmt.executeQuery("SELECT * \r\n" + 
        		"from concessionaria.motore, concessionaria.carburante \r\n"
        		+ "where CodCarb = CodiceC");
        
        System.out.println("I motori presenti in concessionaria è:");
        System.out.println("CODICE\tCILINDRATA\tCAVALLI\tCARBURANTE");
        while (rs.next()) {
        System.out.print(rs.getString("CodiceM") + "\t");
        System.out.print(rs.getString("CC") + "\t");
        System.out.print(rs.getString("Cavalli") + "\t");
        System.out.println(rs.getString("TipoC"));}
      	

        rs.close();
      
	}
}