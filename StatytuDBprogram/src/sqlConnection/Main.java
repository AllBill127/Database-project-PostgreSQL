package sqlConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:postgresql://db";
		String loginInfoFile = "login.txt";
		String user = null;
		String password = null;
		
		
		//============================ Log in ==================================
		System.out.println("Reading login from file");
		try 
		{
			File myObj = new File(loginInfoFile);
		    Scanner myReader = new Scanner(myObj);
		    
		    while (myReader.hasNextLine())
		    {
		    	String data = myReader.nextLine();
		        user = data;
		        data = myReader.nextLine();
		        password = data;
		    }
		    myReader.close();
		    System.out.println(user);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("An error occurred reading file.");
			ex.printStackTrace();
		}
		
		if (user == null || password == null)
			return;
		
		//=============================== Create connection to data base ===========================
		SQL sql = new SQL(connectionUrl, user, password);
		
		//=============================== Start console UI ============================
		ConsoleUI ui = new ConsoleUI(sql);
		ui.Choices();
	}
}
