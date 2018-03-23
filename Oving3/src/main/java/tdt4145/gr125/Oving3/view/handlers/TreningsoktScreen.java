
package tdt4145.gr125.Oving3.view.handlers;

import table.Treningsokt;
import tdt4145.gr125.Oving3.view.TextInterface;


public class TreningsoktScreen
{
	private TextInterface tx; // This handles input from user and showing menus to users.

	private String[] opprettClassOptions = { // The options connected to the number given by user.
			"Back", //
			"", //
	}

	;

	public TreningsoktScreen(TextInterface tx)
	{
		this.tx = tx; // Makes sure we have a 
	}

	public void classMenu(int i)
	{
	//	System.out.println("into classMenu");
		switch (i)
		{
		case 1:
			opprettTreningsokt();
			return;
		case 2:

			break;
		default:
			break;
		}
	}

	private void opprettTreningsokt()
	{
		printOpprettTreningsoktMenu(); // Shows the options to the user
		int menuSelected = tx.getMenuSelection(0, 1);	// handles getting options from the user.
		switch (menuSelected)
		{
		case 0:
			initTreningsokt();
			break;
		case 1:
			
			break;
		default:
			System.out.println("default");
			break;
		}

	}

	private void initTreningsokt()
	{
		
		return;
		//Treningsokt tren = new Treningsokt(oktID, dato, tidspunkt, varighet, form, prestasjon, notat)
		
	}

	private void printOpprettTreningsoktMenu()
	{
		String menuName = "------OpprettclassMenu------";
		tx.printMenu(menuName, opprettClassOptions);

	}
}
