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
	 * Gibt den aktuellen Zoom Faktor zur�ck.
	 */
	public float getZoom()
	{
		return zoom;
	}

	@Override
	public boolean onClick(int x, int y)
	{
		if(anno.getWorld().getBlockID( (int)(x/(32*zoom)) , (int)(y/(32*zoom)) ) < 100){
			switch(anno.getCursor().getCursorID()){
				case 101:
					anno.getWorld().setBlock((int)(x/(32*zoom)),(int)(y/(32*zoom)), new BlockWay());break;
				case 102:
					if(checkForReserved((int)(x/(32*zoom)), (int)(y/(32*zoom)), new BlockLumberjackhood())){
					anno.getWorld().setBlock((int)(x/(32*zoom)),(int)(y/(32*zoom)), new BlockLumberjackhood());
					anno.getWorld().setBlock((int)(x/(32*zoom)+1),(int)(y/(32*zoom)), new BlockEmpty());
					anno.getWorld().setBlock((int)(x/(32*zoom)),(int)(y/(32*zoom)+1), new BlockEmpty());
					anno.getWorld().setBlock((int)(x/(32*zoom)+1),(int)(y/(32*zoom)+1), new BlockEmpty());
					break;
					}
			}
		}
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
					g.drawImage(anno.getTextureManager().getTexture(block.getBlockID()), (int) (x * 32 * zoom), (int) (y * 32 * zoom),(int)((32 * zoom) * block.getWidth()),(int)(32 * zoom * block.getHeight()), null);
				}
			}
		}
		anno.getWorld().getEntityManager().paintEntitys(g, zoom);
		anno.getCursor().paintCursor(g, zoom);
	}

	/**
	 * Setzt den Zoom auf die Welt. Dieser Faktor ist daf�r zust�ndig, dass man rein und raus zoomen kann. Er muss zwischen 0.25 und 1.0 liegen!
	 * 
	 * @param zoom
	 *            der Zoom Faktor
	 * @throws IllegalArgumentException
	 *             Wenn der Zoom Faktor kleiner als 0.25 oder gr��er als 1.0 ist.
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
	 * Erh�ht den Zoom Faktor. Da dieser kleiner als 1 ist, vergr��ert sich dadurch das Bild.
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
	
	public boolean checkForReserved(int x, int y, Block b){
		if(b instanceof BlockLumberjackhood){
			if( anno.getWorld().getBlockID(x+1,y)<100  && anno.getWorld().getBlockID(x+1,y+1) < 100 && anno.getWorld().getBlockID(x,y+1)<100) return true; 
		}
		
		return false;
	}
	
	
	
}
