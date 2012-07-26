package src;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import main.Anno;

public class GuiManager
{
	private Anno anno;
	private List<Gui> guiList;

	public GuiManager(Anno anno)
	{
		guiList = new ArrayList<Gui>();
		this.anno = anno;
	}

	/**
	 * Schlie�t eine Gui.
	 * 
	 * @param gui
	 *            die Gui, die geschlossen werden soll
	 */
	public void closeGui(Gui gui)
	{
		gui.onGuiClose();
		guiList.remove(gui);
		updateGamePause();
	}

	/**
	 * F�hrt die Aktion der obersten Gui, die beim Klick auf diese Position eine Aktion durch zu f�hren hat, aus.
	 * 
	 * @param x
	 *            die X-Position auf dem Fenster
	 * @param y
	 *            die Y-Position auf dem Fenster
	 * @return Ob eine Aktion durchgef�hrt wurde.
	 */
	public boolean fireClick(int x, int y)
	{
		for(int i = guiList.size() - 1; i >= 0; i--)
		{
			Gui gui = guiList.get(i);
			if(gui.isOnGui(x, y))
			{
				return gui.onClick(x - gui.getX(), y - gui.getY());
			}
		}
		return false;
	}

	/**
	 * L�st ein KeyTyped Event bei der obersten Gui, die diese aktiviert hat, aus.
	 * 
	 * @param key
	 *            die gedr�ckte Taste
	 * @param id
	 *            die ID der gedr�ckten Taste
	 * @return Ob eine Aktion durchgef�hrt wurde.
	 */
	public boolean fireKeyType(char key, int id)
	{
		for(int i = guiList.size() - 1; i >= 0; i--)
		{
			Gui gui = guiList.get(i);
			if(gui.isKeyEventEnabled() && gui.onKeyType(key, id))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Gibt die aktuelle Aktions Ordnung zur�ck. Nach dieser Ordnung werden die Guis, mit dem ersten in der Liste beginnend, gezeichnet.
	 * 
	 * @return Die Liste in der Aktions Reihenfolge.
	 */
	public List<Gui> getActOrder()
	{
		return guiList;
	}

	/**
	 * Gibt die ge�ffnete Gui der angegebenen Klasse zur�ck.
	 * 
	 * @param c
	 *            die Klasse der Gui
	 * @return Die Gui der Klasse.
	 */
	public Gui getGui(Class<?> c)
	{
		for(int i = 0; i < guiList.size(); i++)
		{
			if(guiList.get(i).getClass() == c)
			{
				return guiList.get(i);
			}
		}
		return null;
	}

	/**
	 * �ffnet eine Gui.
	 * 
	 * @param gui
	 *            die Gui, die ge�ffnet werden soll
	 */
	public void openGui(Gui gui)
	{
		gui.setAnno(anno);
		gui.onGuiOpen();
		guiList.add(gui);
		updateGamePause();
	}

	/**
	 * Zeichnet alle ge�ffneten Guis.
	 * 
	 * @param g
	 *            Graphics zum Zeichnen der Guis
	 */
	public void paintGuis(Graphics g)
	{
		for(int i = 0; i < guiList.size(); i++)
		{
			guiList.get(i).paintGui(g);
		}
	}

	/**
	 * �berschreibt die aktuelle Aktions Ordnung. Nach dieser Ordnung werden die Guis, mit dem ersten in der Liste beginnend, gezeichnet.
	 * 
	 * @param list
	 *            die Liste mit den Guis
	 */
	public void setActOrder(List<Gui> list)
	{
		guiList = list;
	}

	private void updateGamePause()
	{
		boolean flag = false;
		for(int i = 0; i < guiList.size(); i++)
		{
			if(guiList.get(i).pausesGame())
			{
				flag = true;
			}
		}
		if(flag)
		{
			anno.pauseGame();
		}
		else
		{
			anno.unpauseGame();
		}
	}

	/**
	 * Aktualisiert alle Guis.
	 */
	public void updateGuis()
	{
		for(int i = 0; i < guiList.size(); i++)
		{
			guiList.get(i).onUpdateScreen();
		}
	}
}
