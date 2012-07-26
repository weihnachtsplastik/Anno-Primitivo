package src;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class TextureManager
{
	private HashMap<String, Image> map;
	private String[] source = {"/grass.png", "/forest.png", "/rock.png", "/base.png"};

	public TextureManager()
	{
		map = new HashMap<String, Image>();
	}

	/**
	 * Gibt die zur ID gehörige Textur zurück.
	 * 
	 * @param id
	 *            die ID der Textur
	 */
	public Image getTexture(int id)
	{
		return getTexture(source[id]);
	}

	/**
	 * Gibt das angegebene Bild als Textur zurück.
	 * 
	 * @param src
	 *            der Pfad zum Bild
	 */
	public Image getTexture(String src)
	{
		if(!map.containsKey(src))
		{
			ImageIcon icon = new ImageIcon(getClass().getResource(src));
			Image img = icon.getImage();
			map.put(src, img);
		}
		return map.get(src);
	}
}
