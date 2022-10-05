import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 public class Op9 {
	 
		private Statement stmt;
		
		public Op9(Statement stmt) {
			
			this.stmt = stmt;
			
		}
	public void Esegui9() throws SQLException {
		       
        ResultSet rs=stmt.executeQuery("SELECT sum(NumAuto)\r\n" + 
        		"from concessionaria.sede");
        
        System.out.println("Il numero di auto presenti in concessionaria è:");
        while (rs.next()) {
        System.out.println(rs.getString(1));}
      	

        rs.close();
       
	}
}