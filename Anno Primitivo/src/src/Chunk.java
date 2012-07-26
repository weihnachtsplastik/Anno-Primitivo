package src;

public class Chunk
{
	private Block[][] blocks;
	private Coordinates coords;

	public Chunk(Coordinates coordinates)
	{
		this(coordinates.x, coordinates.y);
	}

	public Chunk(int x, int y)
	{
		coords = new Coordinates(x, y);
		blocks = new Block[16][16];
	}

	/**
	 * Gibt den Block an der angegebenen Positon zurück.
	 * 
	 * @param coordinates
	 *            die Koordinaten des Blocks.
	 */
	public Block getBlock(Coordinates coordinates)
	{
		return getBlock(coordinates.x, coordinates.y);
	}

	/**
	 * Gibt den Block an der angegebenen Positon zurück.
	 * 
	 * @param x
	 *            die X-Position des Blocks
	 * @param y
	 *            die Y-Position des Blocks
	 */
	public Block getBlock(int x, int y)
	{
		return blocks[x][y];
	}

	/**
	 * Gibt die Koordinate des Chunks zurück.
	 */
	public Coordinates getCoordinates()
	{
		return coords;
	}

	/**
	 * Setzt den Block an der angegebenen Position auf dem angegenbenen Block.
	 * 
	 * @param coordinates
	 *            die Koordinaten des Blocks
	 * @param block
	 *            der Block, der gesetzt werden soll.
	 */
	public void setBlock(Coordinates coordinates, Block block)
	{
		setBlock(coordinates.x, coordinates.y, block);
	}

	/**
	 * Setzt den Block an der angegebenen Position auf dem angegenbenen Block.
	 * 
	 * @param x
	 *            die X-Position des Blocks
	 * @param y
	 *            die Y-Position des Blocks
	 * @param block
	 *            der Block, der gesetzt werden soll.
	 */
	public void setBlock(int x, int y, Block block)
	{
		blocks[x][y] = block;
	}
}
