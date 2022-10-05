import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Op2 {
	
	private Statement stmt;
	private Scanner in;

	public Op2(Statement stmt) {
		this.stmt = stmt;
	}
	
	
	@SuppressWarnings("resource")
	public void Esegui2() throws SQLException {
		
		boolean i = true;
		BigDecimal partitiva;
		int km, g = 0, r = 0;
		String datap, datar, x = null;
        
        ResultSet rs=stmt.executeQuery("SELECT  Marca, Modello, Codice \n" + 
        		"FROM automobile\n" );
        
        System.out.println("CODICE\t\tMARCA\t\tMODELLO");
        while (rs.next()) {
        System.out.print(rs.getString("Codice") + "\t\t");
      	System.out.print(rs.getString("Marca")+ "\t\t"); 
      	System.out.println(rs.getString("Modello"));
      	}

        
        System.out.println("\nInserire Codice Auto da modificare: ");
        in = new Scanner (System.in);
        int cod = in.nextInt();
        
       do {
        rs=stmt.executeQuery("SELECT * \n" + 
        		"FROM automobile, entratauscita\n"
        		+ "where Codice =" + cod + "AND Codice = CodiceProd" );
        System.out.println("MARCA\t\tMODELLO\t\tTIPOM\t\tPREZZO\t\tSEDE\t\tMOTORE\t\tTELAIO\t\tDATAENTRATA\t\tDATAUSCITA");
        while (rs.next()) {
        System.out.print(rs.getString(2)+ "\t\t");
      	System.out.print(rs.getString(3)+ "\t\t"); 
      	System.out.print(rs.getString(4)+ "\t\t");
      	x = rs.getString(4);
      	System.out.print(rs.getString(5)+ "\t\t");
      	System.out.print(rs.getString(8)+ "\t\t");
      	g = rs.getInt(8);
      	System.out.print(rs.getString(15)+ "\t\t");
      	System.out.print(rs.getString(16)+ "\t\t");
      	System.out.print(rs.getString(18)+ "\t\t");
      	System.out.println(rs.getString(19));
        }
        
        rs=stmt.executeQuery("SELECT * \n" + 
        		"FROM revisione\n"
        		+ "where Codice =" + cod + "AND Codice = Auto" );
        
        while (rs.next()) {
            r = rs.getInt(2);
        }
        
        System.out.println("Cosa vuoi modificare?  [0 per terminare]");
        in = new Scanner (System.in);
        String s = in.nextLine();
        
        
        switch (s) {
        
        case "Marca":
        
        System.out.println("Inserire Nuova Marca: ");
        in = new Scanner (System.in);
        String marca = in.nextLine(); 
        
        stmt.executeUpdate("UPDATE concessionaria.automobile \r\n" + 
        		"SET Marca =\""+ marca +"\"\n"+ 
        		"where Codice = " + cod);
        
        System.out.println("Le modifiche sono state effettuate!\n");
        	break;
        
        case "Modello":
            
            System.out.println("Inserire Nuovo Modello: ");
            in = new Scanner (System.in);
            String mod = in.nextLine(); 
            
            stmt.executeUpdate("UPDATE concessionaria.automobile \r\n" + 
            		"SET Modello =\""+ mod +"\"\n"+ 
            		"where Codice = " + cod);   
            
            System.out.println("Le modifiche sono state effettuate!\n");
            break;
            
        case "Nuova":
        	
        	if (x.equals("Usata")) {
        		stmt.executeUpdate("DELETE FROM pass_proprietà\r\n" + 
                		"where CodiceP = " + cod);
        	}
        	
    		System.out.println("Inserire Nuova Partita IVA Auto: ");
    		in = new Scanner (System.in);
    		partitiva = in.nextBigDecimal();
    		
    		stmt.executeUpdate("update concessionaria.automobile\n" + 
            		"set  tipoM =  \""+ s +"\", PartitaIva = "+ partitiva +"\n"+
            		"where Codice = "+ cod );
    		
    		System.out.println("Le modifiche sono state effettuate!\n");
    		break;

        case "Usata":
        	
        	if (x.equals("Nuova")) {
        		stmt.executeUpdate("DELETE FROM tagliando\r\n" + 
                		"where CodiceT = " + cod);
        	}
        	
    		System.out.println("Inserire Nuovi Chilometri Auto: ");
			in = new Scanner (System.in);
			km = in.nextInt();
			
			stmt.executeUpdate("update concessionaria.automobile\n" + 
            		"set tipoM =  \""+ s +"\", Chilometri = "+ km +"\n" +
            		"where Codice = "+ cod );
	        
	        rs = stmt.executeQuery("SELECT * \n"
	        		+ "FROM concessionaria.padrone");
	        
	        while(rs.next()) {
	        	System.out.print(rs.getString(1)+ "\t\t");
	          	System.out.print(rs.getString(2)+ "\t\t"); 
	          	System.out.print(rs.getString(3)+ "\t\t");
	          	System.out.print(rs.getString(4)+ "\t\t");
	          	System.out.println(rs.getString(5));
	        }
	        
	        
	        System.out.println("Il nuovo padrone è presente nel database?");
            in = new Scanner (System.in);
            String o = in.nextLine();
            
            if (o.equals("si") || (o.equals("Si")) || (o.equals("sI")) || (o.equals("SI"))) {
            	System.out.println("Inserire il codice fiscale: ");
                in = new Scanner (System.in);
                String f = in.nextLine();
                
                stmt.executeUpdate("update concessionaria.automobile\n" + 
                		"set Padrone = "+ f +"\n" +
                		"where Codice = "+ cod );
            	}
            else if ((o.equals("no")) || (o.equals("No")) || (o.equals("nO")) || (o.equals("NO"))) {
	        	
	        System.out.println("Inserire il Codice Fiscale del proprietario: ");
		    in = new Scanner(System.in);
		    String cf = in.nextLine();
	        
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
            
	        stmt.executeUpdate("update concessionaria.automobile\n" + 
            		"set Padrone = "+ cf +"\n" +
            		"where Codice = "+ cod );
            }
            
            System.out.println("Le modifiche sono state effettuate!\n");
			break;
    	    	
        case "Noleggio":
            
        	if (x.equals("Nuova")) {
        		stmt.executeUpdate("DELETE FROM tagliando\r\n" + 
                		"where CodiceT = " + cod);
        	}
        	
        	if (x.equals("Usata")) {
        		stmt.executeUpdate("DELETE FROM pass_proprietà\r\n" + 
                		"where CodiceP = " + cod);
        	}
        	
    		System.out.println("Inserire Nuova data di inizio del noleggio : [AA/MM/GG]");
            in = new Scanner(System.in);
            datap = in.nextLine();
            
            System.out.println("La macchina è stata restituita? [s/n]");
            in = new Scanner (System.in);
            String a = in.nextLine();
          
            if (a.equals("s")) {
            System.out.println("Inserire la data della fine del noleggio: [AA/MM/GG]");
            in = new Scanner(System.in);
            datar = in.nextLine();
            
            stmt.executeUpdate("update concessionaria.automobile \n" + 
            		"set tipoM =  \""+ s +"\", DataPrestito = \"" + datap +"\", DataRestituzione = \""+ datar +"\"\n" +
            		"where Codice = "+ cod );
            }
            else {
            	stmt.executeUpdate("update concessionaria.automobile \n" + 
                		"set tipoM =  \""+ s +"\", DataPrestito = \"" + datap +"\"\n" +
                		"where Codice = "+ cod );
            }
            
            System.out.println("Le modifiche sono state effettuate!\n");
            break;
            
        case "Prezzo":    
        	
            System.out.println("Inserire Nuovo Prezzo Auto: ");
            in = new Scanner (System.in);
            BigDecimal prezzo = in.nextBigDecimal();  
          
            stmt.executeUpdate("UPDATE concessionaria.automobile \r\n" + 
            		"SET Prezzo ="+ prezzo +"\n"+ 
            		"where Codice = " + cod);
            
            System.out.println("Le modifiche sono state effettuate!\n");
            break;
            
        case "Sede":    
        	
        	rs=stmt.executeQuery("SELECT * \n" + 
            		"FROM concessionaria.sede\n");
        	
        	System.out.println("CODICE\t\tCOMUNE\t\tINDIRIZZO\t\tPADIGLIONE");
        	while (rs.next()) {
                System.out.print(rs.getString(1)+ "\t\t");
              	System.out.print(rs.getString(2)+ "\t\t"); 
              	System.out.print(rs.getString(3)+ "\t\t");
              	System.out.println(rs.getString(4));
                }
        	
            System.out.println("Inserire Codice della nuova sede: ");
            in = new Scanner (System.in);
            int sede = in.nextInt();  
          
            stmt.executeUpdate("UPDATE concessionaria.automobile \r\n" + 
            		"SET SedeA ="+ sede +"\n"+ 
            		"where Codice = " + cod);
            
            stmt.executeUpdate("UPDATE concessionaria.sede \r\n" + 
            		"SET NumAuto = NumAuto - 1 \r\n" + 
            		"where CodSede = " + g);
            
            stmt.executeUpdate("UPDATE concessionaria.sede \r\n" + 
            		"SET NumAuto = NumAuto + 1 \r\n" + 
            		"where CodSede = " + sede);
            
            System.out.println("Le modifiche sono state effettuate!\n");
            break;
            
        case "Motore":
        	
        	rs=stmt.executeQuery("SELECT * \n" + 
            		"FROM concessionaria.motore\n");
        	
        	System.out.println("CODICE\t\tCILINDRATA\t\tCAVALLI\t\tCARBURANTE");
        	while (rs.next()) {
                System.out.print(rs.getString(1)+ "\t\t");
              	System.out.print(rs.getString(2)+ "\t\t"); 
              	System.out.print(rs.getString(3)+ "\t\t");
              	System.out.println(rs.getString(4));
                }
            
            System.out.println("Cambiare il motore con uno già esistente?");
            in = new Scanner (System.in);
            String n = in.nextLine();
            
            if (n.equals("si") || (n.equals("Si")) || (n.equals("sI")) || (n.equals("SI"))) {
            	System.out.println("Inserire il codice del nuovo motore: ");
                in = new Scanner (System.in);
                int m = in.nextInt();
                
                stmt.executeUpdate("update concessionaria.automobile\n" + 
                		"set Motore = "+ m +"\n" +
                		"where Codice = "+ cod );
            	}
            else if ((n.equals("no")) || (n.equals("No")) || (n.equals("nO")) || (n.equals("NO"))) {
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
                 
                 stmt.executeUpdate("update concessionaria.automobile\n" + 
                 		"set Motore = "+ motore +"\n" +
                 		"where Codice = "+ cod );
            }
            else {
            	System.out.println("ERRORE");
            	System.exit(0);
            }
            
            System.out.println("Le modifiche sono state effettuate!\n");
        	break;
        	
        case "Telaio":
        	
        	rs=stmt.executeQuery("SELECT * \n" + 
            		"FROM concessionaria.telaio\n");
        	
        	System.out.println("CODICE\t\tCOLORE\t\tTIPOLOGIA");
        	 while (rs.next()) {
                 System.out.print(rs.getString(1)+ "\t\t");
               	System.out.print(rs.getString(2)+ "\t\t"); 
               	System.out.println(rs.getString(3));
                 }
        	
        	System.out.println("Cambiare il telaio con uno già esistente?");
            in = new Scanner (System.in);
            String z = in.nextLine();
            
            if (z.equals("si") || (z.equals("Si")) || (z.equals("sI")) || (z.equals("SI"))) {
            	System.out.println("Inserire il codice del nuovo telaio: ");
                in = new Scanner (System.in);
                int t = in.nextInt();
                
                stmt.executeUpdate("update concessionaria.automobile\n" + 
                		"set Telaio = "+ t +"\n" +
                		"where Codice = "+ cod );
            	}
            else if ((z.equals("no")) || (z.equals("No")) || (z.equals("nO")) || (z.equals("NO"))) {
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
                
                stmt.executeUpdate("update concessionaria.automobile\n" + 
                		"set Telaio = "+ telaio +"\n" +
                		"where Codice = "+ cod );
                
            }
            else {
            	System.out.println("ERRORE");
            	System.exit(0);
            }
            
            System.out.println("Le modifiche sono state effettuate!\n");
        	break;
        	
        case "Data Entrata":   
        	
        	System.out.println("Inserire la nuova data di entrata:  [AAAA-MM-GG]");
            in = new Scanner(System.in);
            String datE = in.nextLine();
        	
        	stmt.executeUpdate("UPDATE concessionaria.entratauscita \r\n" + 
            		"SET DataEntrata  = \""+ datE +"\" \r\n" + 
            		"where CodiceProd = " + cod);
        	
        	stmt.executeUpdate("UPDATE concessionaria.riparazione \r\n" + 
            		"SET DataFineRev  = \""+ datE +"\" \r\n" + 
            		"where CodRip = " + r );
        	
        	System.out.println("Le modifiche sono state effettuate!\n");
        	break;
        	
        case "Data Uscita":   
        	
        	System.out.println("Inserire la nuova data di uscita:  [AAAA-MM-GG]");
            in = new Scanner(System.in);
            String datU = in.nextLine();
        	
        	stmt.executeUpdate("UPDATE concessionaria.entratauscita \r\n" + 
            		"SET DataUscita  = \""+ datU +"\" \r\n" + 
            		"where CodiceProd = " + cod);
        	
        	stmt.executeUpdate("UPDATE concessionaria.riparazione \r\n" + 
            		"SET DataFineRev  = \""+ datU +"\" \r\n" + 
            		"where CodRip = " + r);
        	
        	System.out.println("Le modifiche sono state effettuate!\n");
        	break;
        	
        case "0":
        	i = false;
        	break;
        	
        }
       }while (i);
	}
}