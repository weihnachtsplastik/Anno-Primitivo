package src;

import java.util.ArrayList;
import java.util.List;

public class WorldData
{
	private List<Item> itemList;

	public WorldData()
	{
		itemList = new ArrayList<Item>();
		registerItems();
	}

	/**
	 * Gibt das Item mit der angegebenen ID zurück.
	 * 
	 * @param id
	 *            die ID des Items
	 */
	public Item getItem(int id)
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			if(itemList.get(i).getShiftedIndex() == id)
			{
				return itemList.get(i);
			}
		}
		return null;
	}

	private void registerItems()
	{
		itemList.add(new ItemMoney(0));
		itemList.add(new Item(1));
		itemList.add(new Item(2));
	}
}
