package src;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class TextureManager
{
	private HashMap<String, Image> mapTextures;
	private HashMap<Integer, String> mapID;

	public TextureManager()
	{
		mapTextures = new HashMap<String, Image>();
		mapID = new HashMap<Integer, String>();
		fillMap();
	}
	
	private void fillMap()
	{
		//Blöcke
		mapID.put(0, "/blocks/grass.png");
		mapID.put(1, "/blocks/forest.png");
		mapID.put(2, "/blocks/rock.png");
		mapID.put(100, "/blocks/base.png");
		
		//Items
		mapID.put(256, "/items/money.png");
		mapID.put(257, "/items/wood.png");
		mapID.put(258, "/items/stone.png");
	}

	/**
	 * Gibt die zur ID gehörige Textur zurück.
	 * 
	 * @param id
	 *            die ID der Textur
	 */
	public Image getTexture(int id)
	{
		return getTexture(mapID.get(id));
	}

	/**
	 * Gibt das angegebene Bild als Textur zurück.
	 * 
	 * @param src
	 *            der Pfad zum Bild
	 */
	public Image getTexture(String src)
	{
		if(!mapTextures.containsKey(src))
		{
			ImageIcon icon = new ImageIcon(getClass().getResource(src));
			Image img = icon.getImage();
			mapTextures.put(src, img);
		}
		return mapTextures.get(src);
	}
}
