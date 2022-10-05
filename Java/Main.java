
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	static final   String driver = "com.mysql.jdbc.Driver";	
	static final     String url = "jdbc:mysql://localhost:3306/Concessionaria";
	private static Scanner in;
	
	public static void main(String[] args) {
		
try {
			
			Class.forName(driver);

	      	Connection conn = DriverManager.getConnection(url,"root","root");
	           
	        for (SQLWarning warn = conn.getWarnings(); warn != null; 					
	       	warn= warn.getNextWarning()) 
	        {
	        	System.out.println("SQL Warning:");
	        	System.out.println("State  : " + warn.getSQLState());
	        	System.out.println("Message: " + warn.getMessage());
	        	System.out.println("Error  : " + warn.getErrorCode());
	        }

	        Statement stmt = conn.createStatement();
	     	

		int n;
		boolean i=true;
		do {		
		System.out.println("\nOp. 1: Inserimento dei dati relativi ad una nuova automobile.");
		System.out.println("Op. 2: Modifica dei dati di un’automobile.");
		System.out.println("Op. 3: Visualizzazione/Stampa dei dati di una automobile. (Marca, modello e codice).");
		System.out.println("Op. 4: Lista complessiva delle automobili in entrata in un certo anno.");
		System.out.println("Op. 5: Lista delle automobili attualmente in concessionaria");
		System.out.println("Op. 6: Lista delle automobili entrate in una certa data.");
		System.out.println("Op. 7: Lista delle automobili di una determinata marca.");
		System.out.println("Op. 8: Visualizzazione delle automobili in entrata in un certo anno.");
		System.out.println("Op. 9: Visualizzazione del numero di automobili in concessionaria.");
		System.out.println("Op. 10: Visualizzazione dei telai presenti nel concessionario. ");
		System.out.println("Op. 11: Visualizzazione dei motori presenti nel concessionario."); 
		System.out.println("Op. 12: Visualizzazione delle automobili noleggiate.");
		System.out.println("Op. 13: Visualizzazione delle informazioni che riguardano le riparazioni.");
		System.out.println("Op. 14: Visualizzazione delle auto usate presenti in officina.");
		System.out.println("Op. 15: Visualizzazione di tutti gli impiegati della concessionaria.");
		System.out.println("0 Per terminare.");
		
		System.out.println("Inserire operazione da eseguire: ");
		in = new Scanner(System.in);
		n = in.nextInt();
		
			switch (n) {
			
			case 0:
				
				stmt.close();
				conn.close();
				System.out.println("Operazioni Completate!");
				i = false;
				break;
				
			case 1: 
				
				Op1 a = new Op1(stmt);
				a.Esegui1();
				break;
				
			case 2:
			
				Op2 b = new Op2(stmt);
				b.Esegui2();
				break;
				
			case 3: 
				
				Op3 c = new Op3(stmt);
				c.Esegui3();
				break;
				
			case 4:
				
				Op4 d = new Op4(stmt);
				d.Esegui4();
				break;
				
			case 5: 

				Op5 e = new Op5(stmt);
				e.Esegui5();
				break;
			
			case 6: 
			
				Op6 f = new Op6(stmt);
				f.Esegui6();
				break;
				
			case 7: 
				
				Op7 g = new Op7(stmt);
				g.Esegui7();
				break;
				
			case 8:
				
				Op8 h = new Op8(stmt);
				h.Esegui8();
				break;
				
			case 9:
				
				Op9 z = new Op9(stmt);
				z.Esegui9();
				break;
				
			case 10:
				
				Op10 l = new Op10(stmt);
				l.Esegui10();
				break;
				
			case 11:
				
				Op11 m = new Op11(stmt);
				m.Esegui11();
				break;
				
			case 12:
				
				Op12 w = new Op12(stmt);
				w.Esegui12();
				break;
				
			case 13:
				
				Op13 o = new Op13(stmt);
				o.Esegui13();
				break;
				
			case 14: 
				
				Op14 p = new Op14(stmt);
				p.Esegui14();
				break;
				
			case 15:
				
				Op15 q = new Op15(stmt);
				q.Esegui15();
				break;
				
			default:
				System.out.println("Errore inserimento!");
				break;
			}
	}	
		while (i);
		
		}catch (SQLException se) {
			System.out.println("SQL Exception:");

			while (se != null) {
	System.out.println("State  : " + se.getSQLState());
	System.out.println("Message: " + se.getMessage());
	System.out.println("Error  : " + se.getErrorCode());
	se = se.getNextException();
	}
} catch (Exception e) {
    System.out.println(e);
		}
}
}
