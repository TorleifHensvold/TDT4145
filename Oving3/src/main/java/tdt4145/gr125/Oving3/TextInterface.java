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
	}

	public void mainMenu()
	{
		int menuSelected = getMenuSelection(5);
		
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
			
			break;
		}
	}
	
	public int getMenuSelection(int maxNumber)
	{
		printMainMenu();
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
					}
				}
				catch (Exception e)
				{
					System.out.println(e);
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
		System.out.println("------MENU------");
		for (int i = 0; i < menu.length; i++)
		{
			System.out.println("[" + i + "] " + menu[i]);
		}
	}

	public static void main(String[] args)
	{
		TextInterface annt = new TextInterface();
		annt.printMainMenu();
	}

}
