
package tdt4145.gr125.Oving3.view.handlers;

import java.util.Scanner;

import database.service.ApparatService;
import table.Apparat;
import tdt4145.gr125.Oving3.view.TextInterface;

public class OvelseScreen
{
	private TextInterface tx;

	private String[] opprettApparatOptions = { // The options for oppretApparat
			"Back",  // 0
			"Opprett Apparat" // 1
	};

	private String[] viewApparatOptions = { // The options for viewingApparat
			"Back", // 0
			"Se alle Apparat" // 1
	};

	public OvelseScreen(Scanner scan, TextInterface tx)
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
		System.out.println("into viewApparat");
		while (true)
		{
			printViewApparatMenu();
			int menuSelected = tx.getMenuSelection(0, 1);
			System.out.println("out of getMenuSelection");
			switch (menuSelected)
			{
			case 0:
				return;
			case 1:
				try
				{
					System.out.println(ApparatService.apparatListeToString(ApparatService.getAllApparat()));
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				break;
			default:
				return;
			}
		}
	}

	private void printViewApparatMenu()
	{
		String menuName = "------ViewApparatMenu------";
		tx.printMenu(menuName, viewApparatOptions);
	}

	private void opprettApparat()
	{
		while (true)
		{
			printOpprettApparatMenu();
			int menuSelected = tx.getMenuSelection(0, 1);
			switch (menuSelected)
			{
			case 0:
				return;
			case 1:
				initApparat();
				break;
			default:
				System.out.println("default");
				return;
			}
		}
	}

	private void initApparat()
	{
		System.out.printf("Navn på Apparatet:");
		String apparatNavn = tx.getInputString();
		System.out.printf("\nBeskrivelse av Apparatet:");
		String apparatBeskrivelse = tx.getInputString();
		try
		{
			Apparat ap = new Apparat(apparatNavn, apparatBeskrivelse);
			ApparatService.NewApparat(ap);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	private void printOpprettApparatMenu()
	{
		String menuName = "------OpprettApparatMenu------";
		tx.printMenu(menuName, opprettApparatOptions);

	}
}
