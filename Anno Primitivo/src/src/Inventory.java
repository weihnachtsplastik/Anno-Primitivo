package src;

public class Inventory
{
	private int amount;
	private int itemID;
	private int maxAmount;

	public Inventory()
	{
		maxAmount = 1;
		itemID = -1;
		amount = 0;
	}

	/**
	 * Erhöht die anzahl des Items. Amount muss dabei positiov sein. Die Gesammtanzahl darf maximal die maximale Anzahl sein.
	 * 
	 * @param amount
	 *            um wie viel die Anzahl erhöht werden soll
	 * @return Ob die Anzahl verändert wurde.
	 */
	public boolean add(int amount)
	{
		if(amount < 0 && this.amount + amount <= maxAmount)
		{
			this.amount += amount;
			return true;
		}
		return false;
	}

	/**
	 * Gibt die aktuelle Anzahle des Items zurück.
	 */
	public int getAmount()
	{
		return amount;
	}

	/**
	 * Gibt den freien Platz im Inventar zurück.
	 */
	public int getFreeSpace()
	{
		return maxAmount - amount;
	}

	/**
	 * Gibt die ID des Items im Inventar zurück.
	 */
	public int getItemID()
	{
		return itemID;
	}

	/**
	 * Gibt die maximale Anzahl des Items zurück.
	 */
	public int getMaximumAmount()
	{
		return maxAmount;
	}
	
	/**
	 * Gibt an, ob das Inventar leer ist.
	 */
	public boolean isEmpty()
	{
		return amount == 0;
	}

	/**
	 * Gibt an, ob das Inventar voll ist.
	 */
	public boolean isFull()
	{
		return amount == maxAmount;
	}

	/**
	 * Veringert die anzahl des Items. Amount muss dabei positiov sein. Die Gesammtanzahl darf minimal 0 sein.
	 * 
	 * @param amount
	 *            um wie viel die Anzahl veringert werden soll
	 * @return Ob die Anzahl verändert wurde.
	 */
	public boolean remove(int amount)
	{
		if(amount > 0 && this.amount - amount >= 0)
		{
			this.amount -= amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Setzt die Anzahl des Items. Amount darf dabei nicht negativ sein und maximal die maximale Anzahl haben.
	 * 
	 * @param amount
	 *            die Anzahl, auf die das Item gesetzt werden soll
	 */
	public void setAmount(int amount)
	{
		if(amount >= 0 && amount <= maxAmount)
		{
			this.amount = amount;
		}
	}
	
	/**
	 * Setzt die ID des Items i´m Inventar.
	 * 
	 * @param id
	 *            die ID des Items
	 */
	public void setItemID(int id)
	{
		itemID = id;
	}
	
	/**
	 * Setzt die maximale Anzahl des Items.
	 * 
	 * @param maxAmount
	 */
	public void setMaximumAmount(int maxAmount)
	{
		this.maxAmount = maxAmount;
	}
}
