package src;

public class Item
{
	protected int amount;
	private int id;

	public Item(int id)
	{
		this.id = id;
		amount = 0;
	}

	/**
	 * Erh�ht die Anzahl der Items. Amount muss dabei positiv sein. Die Gesammtanzahl kann maximal 99999 betragen.
	 * 
	 * @param amount
	 *            um wieviel die Anzahl erh�ht werden soll
	 * @return Ob die Anzahl ver�ndert wurde.
	 */
	public boolean add(int amount)
	{
		if(amount > 0)
		{
			if(this.amount + amount < 100000)
			{
				this.amount += amount;
				return true;
			}
			else
			{
				this.amount = 99999;
			}
		}
		return false;
	}

	/**
	 * Gibt die aktuelle Anzahl des Items zur�ck.
	 * 
	 * @return Die aktuelle Anzahl.
	 */
	public int getAmount()
	{
		return amount;
	}

	/**
	 * Gibt die ID des Items zur�ck.
	 * 
	 * @return Die ID des Items.
	 */
	public int getItemID()
	{
		return id;
	}

	/**
	 * Gibt die ID des Item beginnend bei 256 zur�ck.
	 * @return DIe ID des Items beginnend bei 256.
	 */
	public int getShiftedIndex()
	{
		return 256 + id;
	}
	
	/**
	 * Veringert die Anzahl der Items. Amount muss dabei positiv sein. Die Gesammtanzahl kann minimal 0 betragen.
	 * 
	 * @param amount
	 *            um wieviel die Anzahl veringert werden soll
	 * @return Ob die Anzahl ver�ndert wurde.
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
}
