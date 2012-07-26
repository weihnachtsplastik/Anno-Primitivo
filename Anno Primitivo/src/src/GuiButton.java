package src;

import java.awt.Graphics;

public class GuiButton extends ActionObject
{
	private int id;
	private String texture[];

	public GuiButton(int id, String texture, int x, int y, int width, int height, Gui gui)
	{
		super(x, y, width, height, gui);
		this.texture = new String[3];
		this.id = id;
		for(int i = 0; i < this.texture.length; i++)
		{
			this.texture[i] = texture;
		}
	}
	
	public GuiButton(int id, String[] texture, int x, int y, int width, int height, Gui gui)
	{
		this(id, texture[0], x, y, width, height, gui);
		setHoverTexture(texture[1]);
		setDisabledTexture(texture[2]);
	}

	public int getID()
	{
		return id;
	}

	private String getTexture()
	{
		if(!isEnabled())
		{
			return texture[2];
		}
		try
		{
			int x = parentGui.anno.getGamePanel().getMousePosition().x;
			int y = parentGui.anno.getGamePanel().getMousePosition().y;
			if(isOnObject(x, y))
			{
				return texture[1];
			}
		}
		catch(NullPointerException exception)
		{
		}
		return texture[0];
	}

	public void paint(Graphics g)
	{
		g.drawImage(parentGui.anno.getTextureManager().getTexture(getTexture()), parentGui.getX() + x, parentGui.getY() + y, null);
	}

	public void setDisabledTexture(String texture)
	{
		this.texture[2] = texture;
	}

	public void setHoverTexture(String texture)
	{
		this.texture[1] = texture;
	}

	public void setTexture(String texture)
	{
		this.texture[0] = texture;
	}
}
