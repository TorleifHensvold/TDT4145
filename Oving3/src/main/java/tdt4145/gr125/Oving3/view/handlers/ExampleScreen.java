
package tdt4145.gr125.Oving3.view.handlers;

import tdt4145.gr125.Oving3.view.TextInterface;

// Just an example of the usage for the different things we can do.
// DO NOT USE; Copy it and make a new class.

public class ExampleScreen
{
	private TextInterface tx; // This handles input from user and showing menus to users.

	private String[] opprettClassOptions = { // The options connected to the number given by user.
			"Back", //
			"", //
	}

	;

	public ExampleScreen(TextInterface tx)
	{
		this.tx = tx; // Makes sure we have a 
	}

	public void classMenu(int i)
	{
		System.out.println("into classMenu");
		switch (i)
		{
		case 0:
			
			return;
		case 2:

			break;
		default:
			break;
		}
	}

	private void opprettClass()
	{
		printOpprettClassMenu(); // Shows the options to the user
		int menuSelected = tx.getMenuSelection(0, 1);	// handles getting options from the user.
		switch (menuSelected)
		{
		case 0:

			break;

		default:
			System.out.println("default");
			break;
		}

	}

	private void printOpprettClassMenu()
	{
		String menuName = "------OpprettclassMenu------";
		tx.printMenu(menuName, opprettClassOptions);

	}
}
