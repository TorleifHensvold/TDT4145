
package tdt4145.gr125.Oving3.view.handlers;


import java.sql.SQLException;
import java.util.List;

import database.service.ApparatService;
import database.service.ApparatovelseService;
import database.service.OvelseService;
import database.service.UtenapparatService;
import table.Apparat;
import table.Apparatovelse;
import table.Ovelse;
import table.Utenapparat;
import tdt4145.gr125.Oving3.view.TextInterface;
import tdt4145.gr125.Oving3.view.handlers.ApparatScreen;

public class OvelseScreen
{
	private TextInterface tx;

	private String[] opprettOvelseOptions = { // The options for oppretOvelse
			"Back",  // 0
			"Opprett Øvelse" // 1
	};

	private String[] viewOvelseOptions = { // The options for viewingOvelse
			"Back", // 0
			"Se alle Øvelser" // 1
	};

	public OvelseScreen(TextInterface tx)
	{
		this.tx = tx;
	}

	public void OvelseMenu(int i) throws Exception
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
	//	System.out.println("into viewOvelse");
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

	private void opprettOvelse() throws Exception
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
				initApparatOvelse();
				break;
			case 2:
				initUtenApparat();
				break;
			default:
				System.out.println("default");
				return;
			}
		}
	}

	private void initUtenApparat() throws SQLException
	{	// Har ØvelsesID, Navn og Beskrivelse
		System.out.println("Navn på Øvelsen");
		String ovelsesNavn = tx.getInputString();
		System.out.println("Beskrivelse av Øvelsen");
		String ovelsesBeskrivelse = tx.getInputString();
		boolean createdOvelse = initOvelse(ovelsesNavn);
		if (createdOvelse)
		{
			try
			{
				//UtenapparatService
			}
			catch (Exception e)
			{
				System.out.println(e);
				OvelseService.deleteOvelseByID(OvelseService.getMaxOvelsesID());
			}
		}
	}

	private void initApparatOvelse() throws SQLException
	{
		System.out.println("Navn på Øvelsen");
		String ovelsesNavn = tx.getInputString();
		System.out.println("Antall Kilo i Øvelsen");
		int ovelsesKilo = tx.getMenuSelection(0, 1000);
		System.out.println("Antall Sett i Øvelsen");
		int ovelsesSett = tx.getMenuSelection(0, 1000);
		boolean createdOvelse = initOvelse(ovelsesNavn);
		if (createdOvelse)
		{
			try
			{
				List<Apparat> apList = ApparatService.getAllApparat();
				int choice = ApparatScreen.getApparatByNumber(apList, tx);
				Apparatovelse apo = new Apparatovelse(OvelseService.getMaxOvelsesID(), ovelsesKilo, ovelsesSett, apList.get(choice));
				// ApparatovelseService // TODO create method to create ApparatOvelse in Service
			}
			catch (Exception e)
			{
				System.out.println(e);
				OvelseService.deleteOvelseByID(OvelseService.getMaxOvelsesID());
			}
		}
	}

	protected boolean initOvelse(String ovelsesNavn)
	{
		try
		{
			int prevOvID = OvelseService.getMaxOvelsesID();
			int ovelsesID = prevOvID + 1;
			Ovelse ovelse = new Ovelse(ovelsesID, ovelsesNavn);
			OvelseService.addOvelse(ovelse);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void printOpprettOvelseMenu()
	{
		String menuName = "------OpprettOvelseMenu------";
		tx.printMenu(menuName, opprettOvelseOptions);

	}
}
