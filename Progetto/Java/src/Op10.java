import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Op10 {
	
	private Statement stmt;
	
	public Op10(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	public void Esegui10() throws SQLException {        
        
        ResultSet rs=stmt.executeQuery("SELECT * \r\n" + 
        		"from concessionaria.telaio");
        
        System.out.println("I telai presenti in concessionaria è:");
        System.out.println("CODICE\tCOLORE\tTIPOLOGIA");
        while (rs.next()) {
        System.out.print(rs.getString(1) + "\t");
        System.out.print(rs.getString(2) + "\t");
        System.out.println(rs.getString(3));}
      	

        rs.close();
       
	}
}