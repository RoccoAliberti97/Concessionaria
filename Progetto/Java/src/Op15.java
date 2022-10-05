import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Op15 {
	
	private Statement stmt;
	
	public Op15(Statement stmt) {
		
		this.stmt = stmt;
		
	}
	
	public void Esegui15() throws SQLException {

        ResultSet rs=stmt.executeQuery("SELECT *\r\n" + 
        		"FROM impiegati\r\n");

        System.out.println("CODICE\tNOME\tCOGNOME\tETA'\tCODICE FISCALE\tANNI DI LAVORO\tORE DI LAVORO\tGIORNI DI LAVORO\tSTIPENDIO\tDATA DI ASSUNZIONE\tRUOLO\tTITOLO\tSEDE");
        while (rs.next()) {
        	System.out.print(rs.getString(1) + "\t");
            System.out.print(rs.getString(2) + "\t");
            System.out.print(rs.getString(3) + "\t");
            System.out.print(rs.getString(4) + "\t");
            System.out.print(rs.getString(5) + "\t");
            System.out.print(rs.getString(6) + "\t");
            System.out.print(rs.getString(7) + "\t");
            System.out.print(rs.getString(8) + "\t");
            System.out.print(rs.getString(9) + "\t");
            System.out.print(rs.getString(10) + "\t");
            System.out.print(rs.getString(11) + "\t");
            System.out.print(rs.getString(12) + "\t");
            System.out.println(rs.getString(13));}
          	
        rs.close();
     
	}
}