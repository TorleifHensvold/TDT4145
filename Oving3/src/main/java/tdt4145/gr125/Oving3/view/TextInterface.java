
package tdt4145.gr125.Oving3.view;

import java.util.Scanner;

import tdt4145.gr125.Oving3.view.handlers.ApparatScreen;
import tdt4145.gr125.Oving3.view.handlers.OvelseScreen;
import tdt4145.gr125.Oving3.view.handlers.TreningsoktScreen;

public class TextInterface
{
	private Scanner scan;
	private String[] menu = { "Exit", // 0
			"Registrer Apparat", // 1
			"Registrer Øvelse", // 2
			"Registrer Treningsøkt", // 3
			"Lag Øvelsesgruppe", // 4
			"Lag Undergruppe", // 5
			"Se Apparat", // 6
			"Se Øvelse"	// 7
			};

	private void mainScreen() throws Exception
	{
		System.out.println("This is the main screen. Here you will be able to choose different options.");
		System.out.println("");
		mainMenu();
	//	System.out.println("out of mainMenu");
	}

	private void mainMenu() throws Exception
	{
	//	System.out.println("into mainMenu");
		scan = new Scanner(System.in);
		while (true)
		{
		//	System.out.println("into while(true)");
			printMainMenu();
		//	System.out.println("Out of printMainMenu");
			int menuSelected = getMenuSelection(0, this.menu.length);
		//	System.out.println("Out of getMenuSelection");

			switch (menuSelected)
			{
			case 0:	// Exit
				System.out.println("Hade.");
				System.exit(0);
			case 1: // Registrer Apparat
				ApparatScreen apScreen1 = new ApparatScreen(scan, this);
				apScreen1.apparatMenu(1);
				//System.out.println("out of apparatMenu");
				break;
			case 2:	// Registrer Øvelse
				OvelseScreen ovScreen1 = new OvelseScreen(this);
				ovScreen1.OvelseMenu(1);
				break;
			case 3:	// Registrer Treningsøkt
				TreningsoktScreen trenScreen1 = new TreningsoktScreen(this);
				trenScreen1.classMenu(1);
				break;
			case 4: // Lag Øvelsesgruppe

				break;
			case 5:	// Lag Undergruppe

				break;
			case 6:	// Se Apparat
				ApparatScreen apScreen2 = new ApparatScreen(scan, this);
				apScreen2.apparatMenu(2);
				break;
			case 7: // Se Øvelser
				OvelseScreen ovScreen2 = new OvelseScreen(this);
				ovScreen2.OvelseMenu(2);
				break;
			case 8:	// Se Treningsøkt
				
			case 1000:
				break;
			}
			//System.out.println("out of switch statement");
		}
		// scan.close();
	}

	public int getMenuSelection(int minNumber, int maxNumber)
	{
	//	System.out.println("Into getMenuSelection");
		String oppfordre = "\nType in a number given in brackets in the menu, from " + minNumber + " to "
				+ Integer.toString(maxNumber);
		System.out.println(oppfordre);
		int selection = 1000;
		try
		{
			boolean gotNumber = false;
			while (!gotNumber)
			{
				String str = scan.nextLine();
				try
				{
					int choice = Integer.parseInt(str);
					if (choice <= maxNumber && choice >= 0)
					{
						selection = choice;
						gotNumber = true;
					}
				}
				catch (Exception e)
				{
					System.out.println("Error:");
					System.out.println(e);
					System.out.println(oppfordre);
				}
			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return selection;
	}
	
	public String getInputString()
	{
		return scan.nextLine();
	}

	private void printMainMenu()
	{
	//	System.out.println("Into printMainMenu");
		String menuName = "------MENU------";
		printMenu(menuName, this.menu);
		// System.out.println("------MENU------");
		// for (int i = 0; i < menu.length; i++)
		// {
		// System.out.println("[" + i + "] " + menu[i]);
		// }
		// return;
	}

	public void printMenu(String menuName, String[] menuOptions)
	{
	//	System.out.println("into printMenu");
		System.out.println(menuName);
		for (int i = 0; i < menuOptions.length; i++)
		{
			System.out.println("[" + i + "] " + menuOptions[i]);
		}
	}

	public static void main(String[] args)
	{
		// Create a new instance of TextInterface.
		TextInterface annt = new TextInterface();
		// Start it at the correct screen.
		try
		{
			annt.mainScreen();
		}
		catch (Exception e) 
		{
			System.out.println(e);
			System.exit(0);
		}

		// annt.printMainMenu();
	}

}
