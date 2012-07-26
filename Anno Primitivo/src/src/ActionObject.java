package src;

import java.awt.Graphics;

public abstract class ActionObject
{
	private boolean enabled;
	protected int height;
	protected Gui parentGui;
	protected int width;
	protected int x;
	protected int y;

	public ActionObject(int x, int y, int width, int height, Gui gui)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		parentGui = gui;
		enabled = true;
	}

	/**
	 * Gibt zurück, ob das Objekt aktiviert ist.
	 * 
	 * @return Ob das Objekt aktiviert ist.
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * Gibt zurück, ob die Position auf dem Objekt ist.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 * @return Ob die Position auf dem Objekt liegt.
	 */
	public boolean isOnObject(int x, int y)
	{
		if(x >= parentGui.getX() + this.x && x < parentGui.getX() + this.x + width && y >= parentGui.getY() + this.y && y < parentGui.getY() + this.y + height)
		{
			return true;
		}
		return false;
	}

	/**
	 * Wird aufgerufen, wenn das Objekt gezeichnet werden soll.
	 * 
	 * @param g
	 *            Graphics zum Zeichnen des Objects
	 */
	public abstract void paint(Graphics g);

	/**
	 * Aktiviert oder deaktiviert das Objekt.
	 * 
	 * @param flag
	 *            ob das Objekt aktiviert werden soll
	 */
	public void setEnabled(boolean flag)
	{
		enabled = flag;
	}
}