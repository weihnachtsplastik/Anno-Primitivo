package src;

import java.awt.Graphics;

public class GuiScreen extends Gui
{
	private float zoom;

	public GuiScreen()
	{
		super();
		x = 0;
		y = 0;
		zoom = 0.5F;
	}

	/**
	 * Gibt den aktuellen Zoom Faktor zurück.
	 */
	public float getZoom()
	{
		return zoom;
	}

	@Override
	public boolean onClick(int x, int y)
	{
		anno.getWorld().onClick(x / 32, y / 32);
		return super.onClick(x, y);
	}

	@Override
	public void onGuiOpen()
	{
		width = anno.getGamePanel().getWidth();
		height = anno.getGamePanel().getHeight() - 32;
	}

	@Override
	public void paint(Graphics g)
	{
		for(int y = 0; y < getHeight() / (32 * zoom); y++)
		{
			for(int x = 0; x < getWidth() / (32 * zoom); x++)
			{
				Block block = anno.getWorld().getBlock(x, y);
				if(block.getBlockID() != -1)
				{
					g.drawImage(anno.getTextureManager().getTexture(block.getBlockID()), (int) (x * 32 * zoom), (int) (y * 32 * zoom), (int) (block.getPixelWidth() * zoom), (int) (block.getPixelHeight() * zoom), null);
				}
			}
		}
		anno.getWorld().getEntityManager().paintEntitys(g, zoom);
	}

	/**
	 * Setzt den Zoom auf die Welt. Dieser Faktor ist dafür zuständig, dass man rein und raus zoomen kann. Er muss zwischen 0.25 und 1.0 liegen!
	 * 
	 * @param zoom
	 *            der Zoom Faktor
	 * @throws IllegalArgumentException
	 *             Wenn der Zoom Faktor kleiner als 0.25 oder größer als 1.0 ist.
	 */
	public void setZoom(float zoom) throws IllegalArgumentException
	{
		if(zoom < 0.25F)
		{
			throw new IllegalArgumentException("Zoom can't be smaler then 0.25!");
		}
		else if(zoom > 1.0F)
		{
			throw new IllegalArgumentException("Zoom can't be higher then 1.0!");
		}
		else
		{
			this.zoom = zoom;
		}
	}

	/**
	 * Erhöht den Zoom Faktor. Da dieser kleiner als 1 ist, vergrößert sich dadurch das Bild.
	 */
	public void zoomIn()
	{
		try
		{
			setZoom(getZoom() + 0.0625F);
		}
		catch(IllegalArgumentException exception)
		{
		}
	}

	/**
	 * Veringert den Zoom Faktor. Da dieser kleiner als 1 ist, verkleinert sich dadurch das Bild.
	 */
	public void zoomOut()
	{
		try
		{
			setZoom(getZoom() - 0.0625F);
		}
		catch(IllegalArgumentException exception)
		{
		}
	}
}
