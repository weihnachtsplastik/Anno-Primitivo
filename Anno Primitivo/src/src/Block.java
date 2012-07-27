package src;

public class Block
{
	protected int id;
	protected int width;
	protected int height;

	public Block(int id,int width,int height)
	{
		this.id = id;
		this.width = width;
		this.height = height;
	}

	/**
	 * Gibt die ID des Blocks zur�ck.
	 */
	public int getBlockID()
	{
		return id;
	}

	/**
	 * Gibt die ID zur�ck, die gedropt werden soll, wenn der Block abgebaut wird.
	 */
	public int getDropID()
	{
		return -1;
	}

	/**
	 * Gibt die H�he in Pixeln zur�ck.
	 */
	public int getPixelHeight()
	{
		return 32;
	}

	/**
	 * Gibt die Breite in Pixeln zur�ck.
	 */
	public int getPixelWidth()
	{
		return 32;
	}

	/**
	 * Wird ausgel�st, wenn auf den Block geklickt wird.
	 * 
	 * @param x
	 *            die X-Position des Blocks
	 * @param y
	 *            die Y-Position des Blocks
	 * @param world
	 *            die Welt, in der der Block ist
	 */
	public void onClick(int x, int y, World world)
	{

	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
