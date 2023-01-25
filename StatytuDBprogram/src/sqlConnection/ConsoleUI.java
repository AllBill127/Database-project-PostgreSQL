package sqlConnection;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class ConsoleUI 
{
	private SQL sql = null;
	
	public ConsoleUI(SQL sql)
	{
		this.sql = sql;
	}
	
	public Scanner scanner = new Scanner(System.in);
	
	public void Choices()
	{
		System.out.println("Pasirinkite veiksmo numeri: \n"
				 + "1.firmos informacija \n"
				 + "2.pastato informacija \n"
				 + "3.asmens informacija \n"
				 + "4.darbuotojo informacija \n"
				 + "5.sukurti firma \n"
				 + "6.prideti padalini \n"
				 + "7.pradeti statyti pastata \n"
				 + "8.idarbinti asmeni \n"
				 + "9.priskirti pastata firmos padaliniui \n"
				 + "10.nustatyti pastato pardavimo kaina \n"
				 + "11.atleisti darbuotoja \n"
				 + "12.pakelti darbuotojo atlyginima \n"
				 + "13.parduoti pastata \n"
				 + "14.exit program\n");
		
		Actions();
	}
	
	public void Actions()
	{	
		String action = scanner.nextLine();
		String choice;
		
		switch(action)
		{
			case "1":
				System.out.println("\n===================");
				sql.visosFirmos();
				System.out.println("===================");
				System.out.println("iveskite firmos id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					sql.firmosInfo(Integer.parseInt(choice));
				}
				
				BackOrNah(action);
				Choices();
				break;
			
			case "2":
				System.out.println("\n===================");
				sql.visiPastatai();
				System.out.println("===================");
				System.out.println("iveskite pastato id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					sql.pastatoInfo(Integer.parseInt(choice));
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "3":
				System.out.println("\n===================");
				sql.visiAsmenys();
				System.out.println("===================");
				System.out.println("iveskite asmens koda\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					sql.asmensInfo(choice);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "4":
				System.out.println("\n===================");
				sql.visiDarbuotojai();
				System.out.println("===================");
				System.out.println("iveskite darbuotojo id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					sql.darbuotojoInfo(Integer.parseInt(choice));
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "5":
				System.out.println("\n===================");
				System.out.println("iveskite firmos id, pavadinima, sukurimo data, verte, kapitala\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int id = Integer.parseInt(choice);
					String pav = scanner.nextLine();
					Date iData = Date.valueOf(scanner.nextLine());
					BigDecimal verte = new BigDecimal(scanner.nextLine());
					BigDecimal kapitalas = new BigDecimal(scanner.nextLine());
					sql.sukurtiFirma(id, pav, iData, verte, kapitalas);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "6":
				System.out.println("\n===================");
				sql.visosFirmos();
				System.out.println("===================");
				System.out.println("iveskite firmos id, padalinio atsakomybe\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int id = Integer.parseInt(choice);
					String atsakomybe = scanner.nextLine();
					sql.pridetiPadalini(id, atsakomybe);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "7":
				System.out.println("\n===================");
				sql.visosFirmos();
				System.out.println("===================");
				System.out.println("iveskite adresa, pradejimo data, satatybu kaina, pardavimo kaina, statancios firmos id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					String adresas = choice;
					Date pData = Date.valueOf(scanner.nextLine());
					BigDecimal statybu_kaina = new BigDecimal(scanner.nextLine());
					BigDecimal pardavimo_kaina = new BigDecimal(scanner.nextLine());
					int firmos_id = Integer.parseInt(scanner.nextLine());
					sql.pradetiStatytiPastata(adresas, pData, statybu_kaina, pardavimo_kaina, firmos_id);
				}
				
				BackOrNah(action);
				Choices();
				break;
			
			case "8":
				System.out.println("\n===================");
				sql.visiAsmenys();
				sql.visiPadaliniai();
				System.out.println("===================");
				System.out.println("iveskite asmens koda, atlyginimas, firmos id, padalinio nr\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					String ak = choice;
					BigDecimal atlyginimas = new BigDecimal(scanner.nextLine());
					int firmos_id = Integer.parseInt(scanner.nextLine());
					int padalinio_nr = Integer.parseInt(scanner.nextLine());
					sql.idarbintiAsmeni(ak, atlyginimas, firmos_id, padalinio_nr);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "9":
				System.out.println("\n===================");
				sql.visiPadaliniai();
				sql.visiPastatai();
				System.out.println("===================");
				System.out.println("iveskite firmos id, padalinio nr, pastato id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int firmos_id = Integer.parseInt(choice);
					int nr = Integer.parseInt(scanner.nextLine());
					int pastato_id = Integer.parseInt(scanner.nextLine());
					sql.priskirtiPastataPadaliniui(firmos_id, nr, pastato_id);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "10":
				System.out.println("\n===================");
				sql.visiPastatai();
				System.out.println("===================");
				System.out.println("iveskite pastato id, pardavimo kaina\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int id = Integer.parseInt(choice);
					BigDecimal kaina = new BigDecimal(scanner.nextLine());
					sql.nustatytiPardavimoKaina(id, kaina);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "11":
				System.out.println("\n===================");
				sql.visiDarbuotojai();
				System.out.println("===================");
				System.out.println("iveskite darbuotojo id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int id = Integer.parseInt(choice);
					sql.atleistiDarbuotoja(id);
				}
				
				BackOrNah(action);
				Choices();
				break;
			
			case "12":
				System.out.println("\n===================");
				sql.visiDarbuotojai();
				System.out.println("===================");
				System.out.println("iveskite darbuotojo asmens koda\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					String ak = choice;
					sql.pakeltiAtlyginima(ak);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "13":
				System.out.println("\n===================");
				sql.visiPastatai();
				System.out.println("===================");
				System.out.println("iveskite pastato id\narba \"atgal\"\n");
				
				choice = scanner.nextLine();
				
				if (choice.equals("atgal"))
				{
					Choices();
					break;
				}
				else
				{
					int pastato_id = Integer.parseInt(choice);
					sql.parduotiPastata(pastato_id);
				}
				
				BackOrNah(action);
				Choices();
				break;
				
			case "14":
				System.out.println("Program has finished");
				break;
				
			default :
				System.out.println("Nera tokio pasirinkimo");
				break;
		}
	}
	
	public void BackOrNah(String action)
	{
		System.out.println("\nPasirinkite veiksmo numeri:\n"
				 + "1.kartoti veiksma\n"
				 + "2.grizti atgal");

		String choice = scanner.nextLine();
		
		switch(choice)
		{
			case "1": 
				
				Actions(/*action*/);
				break;
			case "2":
				break;
		}
	}
}
