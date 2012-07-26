package src;

public class ItemMoney extends Item
{
	public ItemMoney(int id)
	{
		super(id);
	}

	/**
	 * Veringert die Anzahl der Items. Amount muss dabei positiv sein. Die Gesammtanzahl kann minimal -9999 betragen.
	 * 
	 * @param amount
	 *            um wieviel die Anzahl veringert werden soll
	 * @return Ob die Anzahl verändert wurde.
	 */
	public boolean remove(int amount)
	{
		if(amount > 0 && this.amount - amount > -10000)
		{
			this.amount -= amount;
			return true;
		}
		return false;
	}
}
