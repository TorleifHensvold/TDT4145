package table;

public class Treningsokt 
{
	private int oktID;
	private String dato;
	private String tidspunkt;
	private int varighet;
	private int form;
	private int prestasjon;
	private String notat;
	
	public Treningsokt(int oktID, String dato, String tidspunkt, 
			int varighet, int form, int prestasjon, String notat) throws Exception
	{
		setOktID(oktID);
		setDato(dato);
		setTidspunkt(tidspunkt);
		setVarighet(varighet);
		setForm(form);
		setPrestasjon(prestasjon);
		setNotat(notat);
	}
	
	// ---------------------- Getters ------------------------------- //
	
	public int getOktID() 
	{
		return this.oktID;
	}
	
	public String getDato() 
	{
		return this.dato;
	}
	
	public String getTidspunkt() 
	{
		return this.tidspunkt;
	}
	
	public int getVarighet() 
	{
		return this.varighet;
	}
	
	public int getForm() 
	{
		return this.form;
	}
	
	public int getPrestasjon() 
	{
		return this.prestasjon;
	}
	
	public String getNotat() 
	{
		return this.notat;
	}
	
	// --------------------------- Setters ------------------ //
	
	private void setOktID(int oktID)  throws Exception
	{
		if (checkInt(oktID, false))
		{
			this.oktID = oktID;
		}
	}
	
	private void setDato(String dato)  throws Exception
	{
		if (checkString(dato, 30, false))
		{
			this.dato = dato;
		}
	}
	
	private void setTidspunkt(String tidspunkt)  throws Exception
	{
		if (checkString(tidspunkt, 30, false))
		this.tidspunkt = tidspunkt;
	}
	
	public void setVarighet(int varighet)  throws Exception
	{
		if (checkInt(oktID, false))
		{
			this.varighet = varighet;
		}
	}
	
	private void setForm(int form)  throws Exception
	{
		if (checkInt(oktID, true))
		{
			this.form = form;
		}
	}
	
	private void setPrestasjon(int prestasjon)  throws Exception
	{
		if (checkInt(oktID, true))
		{
			this.prestasjon = prestasjon;
		}
	}
	
	private void setNotat(String notat)  throws Exception
	{
		if (checkString(notat, 500, true))
		this.notat = notat;
	}
	
	private boolean checkInt(int tall, boolean nullAllowed) throws Exception
	{
		if (!nullAllowed)
		{
			if (tall > 1000000000)
			{
				throw new IllegalArgumentException("The number was too long to be an integer in Java.");
			}
			else 
			{
				return true;
			}
		}
		else
		{
			if (tall == 0)
			{
				return true;
			}
			else if (tall > 1000000000)
			{
				throw new IllegalArgumentException("The number was too long to be an integer in Java.");
			}
			else
			{
				return true;
			}
		}
	}
	
	private boolean checkString(String tekst, int lengde, boolean nullAllowed) throws Exception
	{
		if (!nullAllowed)	// If we don't allow NULL, we check the length.
		{
			if (tekst.length() > lengde)	// If the length is longer than allowed, throw illegalargument.
			{
				throw new IllegalArgumentException("The length of the text was too long, it must be less than " + lengde + ".");
			}
			else
			{
				return true;
			}
		}
		else		// null is implicitly allowed.
		{
			if (tekst == null)
			{
				return true;
			}
			else if (tekst.length() > lengde)
			{
				throw new IllegalArgumentException("The length of the text was too long, it must be less than " + lengde + ".");
			}
			else
			{
				return true;
			}
		}
	}
	
}
