
package tdt4145.gr125.Oving3.view.handlers;


import database.service.OvelseService;
import table.Ovelse;
import tdt4145.gr125.Oving3.view.TextInterface;

public class OvelseScreen
{
	private TextInterface tx;

	private String[] opprettOvelseOptions = { // The options for oppretOvelse
			"Back",  // 0
			"Opprett Øvelse" // 1
	};

	private String[] viewOvelseOptions = { // The options for viewingOvelse
			"Back", // 0
			"Se alle Øvelse" // 1
	};

	public OvelseScreen(TextInterface tx)
	{
		this.tx = tx;
	}

	public void OvelseMenu(int i)
	{
		//System.out.println("into ovelseMenu");
		switch (i)
		{
		case 1:
			opprettOvelse();
			break;
		case 2:
			viewOvelse();
		default:
			break;
		}
	}

	private void viewOvelse()
	{
		System.out.println("into viewOvelse");
		while (true)
		{
			printViewOvelseMenu();
			int menuSelected = tx.getMenuSelection(0, 1);
			//System.out.println("out of getMenuSelection");
			switch (menuSelected)
			{
			case 0:
				return;
			case 1:
				try
				{
					System.out.println(OvelseService.ovelseListeToString(OvelseService.getAllOvelser()));
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

	private void printViewOvelseMenu()
	{
		String menuName = "------ViewOvelseMenu------";
		tx.printMenu(menuName, viewOvelseOptions);
	}

	private void opprettOvelse()
	{
		while (true)
		{
			printOpprettOvelseMenu();
			int menuSelected = tx.getMenuSelection(0, 1);
			switch (menuSelected)
			{
			case 0:
				return;
			case 1:
				initOvelse();
				break;
			default:
				System.out.println("default");
				return;
			}
		}
	}

	private void initOvelse()
	{
		System.out.printf("Navn på Øvelse:");
		String ovelseNavn = tx.getInputString();
		
		try
		{
			int prevOvID = OvelseService.getMaxOvelsesID();
			int ovelsesID = prevOvID + 1;
			Ovelse ovelse = new Ovelse(ovelsesID, ovelseNavn);
			OvelseService.addOvelse(ovelse);;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	private void printOpprettOvelseMenu()
	{
		String menuName = "------OpprettOvelseMenu------";
		tx.printMenu(menuName, opprettOvelseOptions);

	}
}
