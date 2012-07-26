package src;

import java.awt.Graphics;

public class Entity
{
	protected int health;
	protected int id;
	protected Inventory inv;
	protected float x;
	protected float y;

	public Entity(int id)
	{
		this.id = id;
		inv = new Inventory();
		x = 0;
		y = 0;
		setHealth(20);
	}

	/**
	 * Fügt das angegebene Item, wenn möglich, dem Inventar hinzu.
	 * 
	 * @param item
	 *            das Item, das hinzugefügt werden soll
	 * @return Ob das Item hinzugefügt wurde.
	 */
	public boolean add(Item item)
	{
		if(inv.isEmpty())
		{
			inv.setItemID(item.getItemID());
			inv.setAmount(item.getAmount());
			return true;
		}
		else if(inv.getItemID() == item.getShiftedIndex())
		{
			return inv.add(item.getAmount());
		}
		return false;
	}

	/**
	 * Gibt die Gesundheit des Entitys zurück.
	 */
	public int getHealth()
	{
		return health;
	}

	/**
	 * Gibt die ID des Entitys zurück.
	 */
	public int getID()
	{
		return id;
	}

	/**
	 * Gibt die aktuelle X-Position des Entitys zurück.
	 */
	public float getX()
	{
		return x;
	}

	/**
	 * Gibt die aktuelle Y-Position des Entitys zurück.
	 */
	public float getY()
	{
		return y;
	}

	/**
	 * Zeichnet den Entity.
	 * 
	 * @param g
	 *            Graphics zum Zeichnen des Entitys
	 */
	public void paint(Graphics g, float zoom)
	{
		
	}

	/**
	 * Setzt die Gesundheit des Entitys.
	 * 
	 * @param health
	 *            die Gesundheit, die der Entity bekommen soll
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}

	/**
	 * Setzt die Postion des Entitys auf die angegeben Position.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 */
	public void setPosition(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Setzt die X-Position des Entitys auf die angegeben X-Position.
	 * 
	 * @param x
	 *            die X-Position
	 */
	public void setX(float x)
	{
		this.x = x;
	}

	/**
	 * Setzt die Y-Position des Entitys auf die angegeben Y-Position.
	 * 
	 * @param y
	 *            die Y-Position
	 */
	public void setY(float y)
	{
		this.y = y;
	}

	/**
	 * Aktualisiert den Entity.
	 */
	public void updateEntity()
	{

	}
}
