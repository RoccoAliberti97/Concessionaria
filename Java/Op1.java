import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Op1 {
	
	private Statement stmt;
	private Scanner in;
	
	public Op1(Statement stmt) {
		
		this.stmt = stmt;
	}
	
	public void Esegui1() throws SQLException {
		BigDecimal partitiva;
		int km, n = 0;
		String annoimma = null;
		String datap = null;
		String datar = null;
		String c = null;	     	
        
        ResultSet rs = stmt.executeQuery("SELECT max(NumProg) \n" + 
        		"FROM concessionaria.automobile");
        
        while (rs.next()) {
            n = rs.getInt(1); }
        n = n+1;
        
        System.out.println("Inserire Codice Auto: ");
        in = new Scanner (System.in);
        int cod = in.nextInt();
        
        System.out.println("Inserire Data di entrata dell'auto: [AAAA-MM-GG] ");
        in = new Scanner (System.in);
        String date = in.nextLine();
        
        stmt.executeUpdate("insert into concessionaria.entratauscita (CodiceProd, DataEntrata)"
        		+ "values ("+ cod + ",\"" + date +"\")");        
        
        System.out.println("Inserire Marca Auto: ");
        in = new Scanner (System.in);
        String marca = in.nextLine();
        
        System.out.println("Inserire Modello Auto: ");
        in = new Scanner (System.in);
        String mod = in.nextLine();
        
        System.out.println("Inserire Tipo Auto: [Nuova/Usata/Noleggio]");
        in = new Scanner (System.in);
        String tipo = in.nextLine();
        
        if ((tipo.equals("Nuova")) || (tipo.equals("Usata")) || (tipo.equals("Noleggio"))) {
        
        System.out.println("Inserire Prezzo Auto: ");
        in = new Scanner (System.in);
        BigDecimal prezzo = in.nextBigDecimal();
        
        System.out.println("Inserire Numero di Serie dell'Auto: ");
        in = new Scanner (System.in);
        int nums = in.nextInt();
        
        System.out.println("Inserire la data di Immatricolazione dell'Auto: [AAAA-MM-GG]");
        in = new Scanner(System.in);
        annoimma = in.nextLine();
        
        System.out.println("Inserire il codice della sede: ");
        in = new Scanner(System.in);
        int sede = in.nextInt();        
        
        System.out.println("Inserire il codice del motore: ");
        in = new Scanner(System.in);
        int motore = in.nextInt();
        
        System.out.println("Inserire cilindrata del motore: ");
        in = new Scanner(System.in);
        int cc = in.nextInt();
        
        System.out.println("Inserire cavalli del motore: ");
        in = new Scanner(System.in);
        int cavalli = in.nextInt();
        
        System.out.println("Inserire tipo del carburante: ");
        in = new Scanner(System.in);
        String carb = in.nextLine();
        
        stmt.executeUpdate("insert into concessionaria.motore (CodiceM, CC, Cavalli, Carburante)"
        		+ "values ("+ motore + "," + cc +","+ cavalli +",\""+ carb +"\")");
        
        System.out.println("Inserire il codice del telaio: ");
        in = new Scanner(System.in);
        int telaio = in.nextInt();
        
        System.out.println("Inserire il colore del telaio: ");
        in = new Scanner(System.in);
        String col = in.nextLine();
        
        System.out.println("Inserire la tipologia del telaio: ");
        in = new Scanner(System.in);
        String tip = in.nextLine();
        
        stmt.executeUpdate("insert into concessionaria.telaio (CodiceTe, Colore, Tipologia)"
        		+ "values ("+ telaio + ",\"" + col +"\",\""+ tip +"\")");
        
        if (tipo.equals("Nuova")) {
    		System.out.println("Inserire Partita IVA Auto: ");
    		in = new Scanner (System.in);
    		partitiva = in.nextBigDecimal();
    	
    		stmt.executeUpdate("insert into concessionaria.automobile (Codice, Marca, Modello, TipoM, Prezzo, NumSerie, AnnoImma, SedeA, Motore, Telaio, PartitaIva, NumProg)"
                		+ "values (" + cod +", \"" + marca +"\", \""+ mod + "\", \""+ tipo +"\","+ prezzo +","+ nums +",\""+ annoimma + "\"," + sede + "," + motore+ "," + telaio + "," + partitiva +","+ n +")");
    		
    		System.out.println("Inserire Prezzo del tagliando: ");
    		in = new Scanner (System.in);
    		BigDecimal tagliando = in.nextBigDecimal();
    		
    		stmt.executeUpdate("insert into concessionaria.tagliando (CodiceT, PrezzoT)"
            		+ "values (" + cod +","+ tagliando +")");
		
            }

        if (tipo.equals("Usata")) {
    		System.out.println("Inserire Chilometri Auto: ");
			in = new Scanner (System.in);
			km = in.nextInt();
	        
			System.out.println("Inserire il Codice Fiscale del proprietario: ");
	        in = new Scanner(System.in);
	        String cf = in.nextLine();
	        
	        rs = stmt.executeQuery("SELECT CodiceFiscale \n"
	        		+ "FROM concessionaria.padrone");
	        
	        while(rs.next()) {
	        	c = rs.getString(1);
	        	if (cf.equals(c)){
	        		cf = c;
	        		break;
	        	}
	        }
	        if (cf.equals(c)) {
	        	 stmt.executeUpdate("insert into concessionaria.automobile (Codice, Marca, Modello, TipoM, Prezzo, NumSerie, AnnoImma, SedeA, Motore, Telaio, Chilometri, Padrone, NumProg)"
	             		+ "values (" + cod +", \"" + marca +"\", \""+ mod + "\", \""+ tipo +"\","+ prezzo +","+ nums +",\""+ annoimma + "\"," + sede + "," + motore + "," + telaio + "," + km +",\""+ cf +"\"," + n +")");
	        }
	        
	        else {
			System.out.println("Inserire il Nome: ");
	        in = new Scanner(System.in);
	        String nome = in.nextLine();
	        
	        System.out.println("Inserire il Cognome: ");
	        in = new Scanner(System.in);
	        String cognome = in.nextLine();
	        
	        System.out.println("Inserire l'Età: ");
	        in = new Scanner(System.in);
	        int età = in.nextInt();
	        
	        System.out.println("Inserire l'Indirizzo: ");
	        in = new Scanner(System.in);
	        String indirizzo = in.nextLine();
	        
	        stmt.executeUpdate("insert into concessionaria.padrone (CodiceFiscale, Nome, Cognome, Età, Indirizzo)"
	        		+ "values (\""+ cf + "\",\"" + nome +"\", \"" + cognome +"\","+ età +",\"" + indirizzo + "\")"); 
	        
	        stmt.executeUpdate("insert into concessionaria.automobile (Codice, Marca, Modello, TipoM, Prezzo, NumSerie, AnnoImma, SedeA, Motore, Telaio, Chilometri, Padrone, NumProg)"
            		+ "values (" + cod +", \"" + marca +"\", \""+ mod + "\", \""+ tipo +"\","+ prezzo +","+ nums +",\""+ annoimma + "\"," + sede + "," + motore + "," + telaio + "," + km +",\""+ cf +"\"," + n +")");
    	}
	        
	        System.out.println("Inserire Prezzo del bollo: ");
    		in = new Scanner (System.in);
    		BigDecimal bollo = in.nextBigDecimal();
    		
	        stmt.executeUpdate("insert into concessionaria.pass_proprietà (CodiceP, Bollo)"
            		+ "values (" + cod +","+ bollo +")");
        }
    	
        if (tipo.equals("Noleggio")) {
            
    		System.out.println("Inserire la data di inizio del noleggio : [AAAA-MM-GG]");
            in = new Scanner(System.in);
            datap = in.nextLine();
            
            System.out.println("La macchina è stata restituita? [Si/No]");
            in = new Scanner (System.in);
            String a = in.nextLine();
            if (a.equals("si") || (a.equals("Si")) || (a.equals("sI")) || (a.equals("SI"))) {
            
            System.out.println("Inserire la data della fine del noleggio: [AAAA-MM-GG]");
            in = new Scanner(System.in);
            datar = in.nextLine();
            
            stmt.executeUpdate("insert into concessionaria.automobile (Codice, Marca, Modello, TipoM, Prezzo, NumSerie, AnnoImma, SedeA, Motore, Telaio, DataPrestito, DataRestituzione, NumProg)"
            		+ "values (" + cod +", \"" + marca +"\", \""+ mod + "\", \""+ tipo +"\","+ prezzo +","+ nums +",\""+ annoimma + "\"," + sede + "," + motore +","+ telaio +",\""+ datap +"\",\""+ datar +"\","+ n +")");
            }
            else if ((a.equals("no")) || (a.equals("No")) || (a.equals("nO")) || (a.equals("NO"))) {
            	stmt.executeUpdate("insert into concessionaria.automobile (Codice, Marca, Modello, TipoM, Prezzo, NumSerie, AnnoImma, SedeA, Motore, Telaio, DataPrestito, NumProg)"
                		+ "values (" + cod +", \"" + marca +"\", \""+ mod + "\", \""+ tipo +"\","+ prezzo +","+ nums +",\""+ annoimma + "\"," + sede + "," + motore +","+ telaio +",\""+ datap +"\","+ n +")");
            }
            else {
            	System.out.println("ERRORE");
            	System.exit(0);
            }
        }
        
        stmt.executeUpdate("UPDATE concessionaria.sede \r\n" + 
        		"SET NumAuto = NumAuto + 1 \r\n" + 
        		"where CodSede = " + sede);
        
        stmt.executeUpdate("insert into concessionaria.riparazione (CodRip, DataInizioRev)"
        		+ "values (" + n +",\""+ date +"\")");
        
        stmt.executeUpdate("insert into concessionaria.revisione (Auto, Rip1)"
        		+ "values (" + cod +","+ n +")");
        
        System.out.println("La macchina è stata caricata nel database!");
        }
        else {
        	System.out.println("ERRORE");
        	System.exit(0);
        }
	}
}