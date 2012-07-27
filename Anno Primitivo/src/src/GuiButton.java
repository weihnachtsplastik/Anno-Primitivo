package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GuiButton extends ActionObject
{
	private int id;
	private String texture[];
	private boolean useTextures;
	private String title;

	public GuiButton(int id, int x, int y, int width, int height, String title, Gui gui)
	{
		super(x, y, width, height, gui);
		this.texture = new String[3];
		this.id = id;
		this.title = title;
		useTextures = false;
		
	}

	public GuiButton(int id, String texture, int x, int y, int width, int height, Gui gui)
	{
		super(x, y, width, height, gui);
		this.texture = new String[3];
		this.id = id;
		for(int i = 0; i < this.texture.length; i++)
		{
			this.texture[i] = texture;
		}
		useTextures = false;
		title = texture;
	}

	public GuiButton(int id, String[] texture, int x, int y, int width, int height, Gui gui)
	{
		this(id, texture[0], x, y, width, height, gui);
		setHoverTexture(texture[1]);
		setDisabledTexture(texture[2]);
	}

	/**
	 * Gibt die ID des Gui Buttons zur�ck.
	 */
	public int getID()
	{
		return id;
	}

	private boolean isHover()
	{
		try
		{
			int x = parentGui.anno.getGamePanel().getMousePosition().x;
			int y = parentGui.anno.getGamePanel().getMousePosition().y;
			if(isOnObject(x, y))
			{
				return true;
			}
		}
		catch(NullPointerException exception)
		{
		}
		return false;
	}

	private String getTexture()
	{
		if(!isEnabled())
		{
			return texture[2];
		}
		if(isHover())
		{
			return texture[1];
		}
		return texture[0];
	}

	@Override
	public void paint(Graphics g)
	{
		if(useTextures)
		{
			g.drawImage(parentGui.anno.getTextureManager().getTexture(getTexture()), parentGui.getX() + x, parentGui.getY() + y,width,height, null);
		}
		else
		{
			g.setColor(Color.black);
			g.fillRect(parentGui.getX() + x, parentGui.getY() + y, width, height);
			if(isEnabled())
			{
				g.setColor(Color.gray);
			}
			else
			{
				g.setColor(Color.darkGray);
			}
			g.fillRect(parentGui.getX() + x, parentGui.getY() + y, width, height / 2);
			if(isEnabled() && isHover())
			{
				g.setColor(Color.blue);
				g.fillRect(parentGui.getX() + x, parentGui.getY() + y, width, height / 2);
			}
			if(isEnabled())
			{
				g.setColor(Color.white);
			}
			else
			{
				g.setColor(Color.gray);
			}
			g.setFont(new Font("Arial", 1, 10));
			g.drawString(title, parentGui.getX() + x + (width / 2 - title.length() * 2), parentGui.getY() + y + (height / 2 - 5));
		}
	}

	/**
	 * Setzt die Textur, die angezeigt werden soll, wenn der Gui Button deaktiviert ist.
	 * 
	 * @param texture
	 *            der Pfad zur Textur.
	 */
	public void setDisabledTexture(String texture)
	{
		this.texture[2] = texture;
	}

	/**
	 * Setzt die Textur, die angezeigt werden soll, wenn die Maus �ber dem Gui Button ist..
	 * 
	 * @param texture
	 *            der Pfad zur Textur.
	 */
	public void setHoverTexture(String texture)
	{
		this.texture[1] = texture;
	}

	/**
	 * Setzt die Textur des Gui Buttons.
	 * 
	 * @param texture
	 *            der Pfad zur Textur.
	 */
	public void setTexture(String texture)
	{
		this.texture[0] = texture;
	}

	/**
	 * Deaktiviert die Standart Texturen und benutzt statt dessen die angegebenen Texturen.
	 */
	public void useTextures()
	{
		useTextures = true;
	}
}
