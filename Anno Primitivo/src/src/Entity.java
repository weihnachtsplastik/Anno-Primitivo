package src;

import java.awt.Graphics;

public class Entity
{
	protected int health;
	protected int id;
	protected Inventory inv;
	protected int x;
	protected int y;

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
	 * Gibt die aktuelle Position des Entitys zurück.
	 */
	public Coordinates getPosition()
	{
		return new Coordinates(x, y);
	}

	/**
	 * Gibt die aktuelle X-Position des Entitys zurück.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Gibt die aktuelle Y-Position des Entitys zurück.
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Zeichnet den Entity.
	 * 
	 * @param g
	 *            Graphics zum Zeichnen des Entitys
	 */
	public void paint(Graphics g)
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
	 * @param coordinates
	 *            die Postition, auf die der Entity gesetzt werden soll
	 */
	public void setPosition(Coordinates coordinates)
	{
		x = coordinates.x;
		y = coordinates.y;
	}

	/**
	 * Setzt die Postion des Entitys auf die angegeben Position.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 */
	public void setPosition(int x, int y)
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
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Setzt die Y-Position des Entitys auf die angegeben Y-Position.
	 * 
	 * @param y
	 *            die Y-Position
	 */
	public void setY(int y)
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
