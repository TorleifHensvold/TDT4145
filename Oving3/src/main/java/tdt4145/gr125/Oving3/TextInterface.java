package tdt4145.gr125.Oving3;

import java.util.Scanner;

public class TextInterface
{
	private String[] menu = 
		{"Exit", 	// 0 
		"",			// 1
		"",			// 2
		"",			// 3
		"",			// 4
		"",			// 5
		};
	
	public void mainScreen()
	{
		System.out.println("This is the main screen. Here you will be able to choose different options.");
		System.out.println("");
		mainMenu();
	}

	public void mainMenu()
	{
		System.out.println("into mainMenu");
		int menuSelected = getMenuSelection(5);
		System.out.println("Out of getMenuSelection");
		
		switch (menuSelected)
		{
		case 0:
			System.out.println("Bye.");
			System.exit(0);
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 1000:
			mainMenu();
			break;
		}
	}
	
	public int getMenuSelection(int maxNumber)
	{
		System.out.println("Into getMenuSelection");
		printMainMenu();
		System.out.println("Out of printMainMenu");
		String oppfordre = "\nType in a number given in brackets in the menu, from 0 to " + Integer.toString(maxNumber);
		System.out.println(oppfordre);
		int selection = 1000;
		try
		{
			Scanner scan = new Scanner(System.in);
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
			scan.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return selection;
	}
	
	public void printMainMenu()
	{
		System.out.println("Into printMainMenu");
		System.out.println("------MENU------");
		for (int i = 0; i < menu.length; i++)
		{
			System.out.println("[" + i + "] " + menu[i]);
		}
		return;
	}

	public static void main(String[] args)
	{
		TextInterface annt = new TextInterface();
		annt.mainScreen();
		//annt.printMainMenu();
	}

}
