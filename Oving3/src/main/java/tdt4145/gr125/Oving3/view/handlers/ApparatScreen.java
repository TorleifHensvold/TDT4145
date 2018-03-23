
package tdt4145.gr125.Oving3.view.handlers;

import java.util.Scanner;

import database.service.ApparatService;
import tdt4145.gr125.Oving3.view.TextInterface;

public class ApparatScreen
{
	private TextInterface tx;

	private String[] opprettApparatOptions = { // The options for oppretApparat
			"Opprett Apparat", //2
			"Back" // 1
			};
	
	private String[] viewApparatOptions = { // The options for viewingApparat
			"Se alle Apparat", // 0
			"Back" // 1
			};

	public ApparatScreen(Scanner scan, TextInterface tx)
	{
		this.tx = tx;
	}

	public void apparatMenu(int i)
	{
		System.out.println("into apparatMenu");
		switch (i)
		{
		case 1:
			opprettApparat();
			break;
		case 2:
			viewApparat();
			break;
		default:
			break;
		}
	}

	private void viewApparat()
	{
		printViewApparatMenu();
		int menuSelected = tx.getMenuSelection(0, 1);
		switch (menuSelected)
		{
		case 0:
			//ApparatService.
			break;
		case 1:
			
			break;
		default:
			break;
		}
	}

	private void printViewApparatMenu()
	{
		String menuName = "------ViewApparatMenu------";
		tx.printMenu(menuName, viewApparatOptions);
	}

	private void opprettApparat()
	{
		printOpprettApparatMenu();
		int menuSelected = tx.getMenuSelection(0, 1);
		switch (menuSelected)
		{
		case 0:

			break;

		default:
			System.out.println("default");
			break;
		}

	}

	private void printOpprettApparatMenu()
	{
		String menuName = "------OpprettApparatMenu------";
		tx.printMenu(menuName, opprettApparatOptions);

	}
}
