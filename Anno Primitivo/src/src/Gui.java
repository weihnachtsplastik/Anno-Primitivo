package src;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import main.Anno;

public abstract class Gui
{
	protected Anno anno;
	protected List<ActionObject> controlList;
	protected int height;
	private boolean keyEventEnabled;
	protected int width;
	protected int x;
	protected int y;

	/**
	 * Der Konstruktor von Gui.
	 * 
	 * @param gamepanel
	 *            das GamePanel der Gui
	 */
	public Gui()
	{
		controlList = new ArrayList<ActionObject>();
		keyEventEnabled = false;
	}

	/**
	 * Schlie�t die Gui.
	 */
	public void close()
	{
		anno.getGuiManager().closeGui(this);
	}

	/**
	 * Aktiviert, dass das Tippen einer Taste an die Gui weitergeleitet wird und die Standarttasten deaktiviert werden.
	 */
	public void enableKeyEvent()
	{
		keyEventEnabled = true;
	}

	/**
	 * Gibt die H�he der Gui zur�ck.
	 * 
	 * @return Die H�he der Gui.
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Gibt die Breite der Gui zur�ck.
	 * 
	 * @return Die Breite der Gui.
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Gibt die X-Position auf dem Fenster zur�ck.
	 * 
	 * @return Die X-Position der Gui.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Gibt die X-Position auf dem Fenster plus die Breite der Gui zur�ck.
	 * 
	 * @return Die X-Position des 2. Punkts der Gui.
	 */
	public int getX2()
	{
		return x + width;
	}

	/**
	 * Gibt die Y-Position auf dem Fenster zur�ck.
	 * 
	 * @return Die Y-Position der Gui.
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Gibt die Y-Position auf dem Fenster plus die H�he der Gui zur�ck.
	 * 
	 * @return Die Y-Position des 2. Punkts der Gui.
	 */
	public int getY2()
	{
		return y + height;
	}

	/**
	 * Gibt an, ob das Tippen einer Taste an die Gui weitergeleitet werden soll und die Standarttasten deaktiviert werden sollen.
	 * 
	 * @return Ob ein "onKeyType" Event ausgel�st werden soll.
	 */
	public boolean isKeyEventEnabled()
	{
		return keyEventEnabled;
	}

	/**
	 * �berpr�ft, ob die angegebene Position auf der Gui liegt.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 * @return Ob die Position auf der Gui liegt.
	 */
	public boolean isOnGui(int x, int y)
	{
		if(x >= getX() && x < getX2() && y >= getY() && y < getY2())
		{
			return true;
		}
		return false;
	}

	/**
	 * Wird aufgerufen, wenn auf die Gui geklickt wird.
	 * 
	 * @param x
	 *            die X-Position auf der Gui
	 * @param y
	 *            die Y-Position auf der Gui
	 * @return ob eine Aktion durchgef�hrt wurde
	 */
	public boolean onClick(int x, int y)
	{
		for(int i = 0; i < controlList.size(); i++)
		{
			if(controlList.get(i).isOnObject(this.x + x, this.y + y))
			{
				if(controlList.get(i) instanceof GuiButton)
				{
					return onGuiButtonClick(((GuiButton) controlList.get(i)));
				}
			}
		}
		return false;
	}

	/**
	 * Wird aufgerufen, wenn auf einen Guibutton in der controlList geklickt wird.
	 * 
	 * @param id
	 *            die ID des Guibuttons
	 * @return ob eine Aktion durchgef�hrt wurde
	 */
	public boolean onGuiButtonClick(GuiButton buttons )
	{
		return false;
	}

	/**
	 * Wird aufgerufen, wenn die Gui geschlossen wird.
	 */
	public void onGuiClose()
	{

	}

	/**
	 * Wird aufgerufen, wenn die Gui ge�ffnet wird.
	 */
	public void onGuiOpen()
	{

	}

	/**
	 * Wird aufgerufen, wenn eine Taste gedr�ckt wird.
	 * 
	 * @param key
	 *            die gedr�ckte Taste
	 * @param id
	 *            die ID der Taste
	 * @return ob eine Aktion durchgef�hrt wurde
	 */
	public boolean onKeyType(char key, int id)
	{
		return false;
	}

	/**
	 * Wird jedesmal aufgerufen, wenn das Bild auf dem Bildschirm aktualisiert wird.
	 */
	public void onUpdateScreen()
	{

	}

	/**
	 * Wird zum Zeichnen der Gui aufgerufen.
	 * 
	 * @param g
	 *            Graphics zum Zeichnen
	 */
	public abstract void paint(Graphics g);

	/**
	 * Zeichnet die gesammte Gui mit Controll Elementen.
	 * 
	 * @param g
	 *            Graphics zum Zeichen
	 */
	public void paintGui(Graphics g)
	{
		paint(g);
		for(int i = 0; i < controlList.size(); i++)
		{
			controlList.get(i).paint(g);
		}
	}

	/**
	 * Gibt an, ob das Spiel durch das �ffnen der Gui unterbrochen werden soll.
	 * 
	 * @return Ob das Spiel unterbrochen werden soll.
	 */
	public boolean pausesGame()
	{
		return false;
	}
	
	/**
	 * Setzt anno auf den �bergebenen wert.
	 * @param anno das neue Anno
	 */
	public void setAnno(Anno anno)
	{
		this.anno = anno;
	}
}
