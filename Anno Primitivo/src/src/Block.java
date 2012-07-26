package src;

public class Block
{
	protected int id;

	public Block(int id)
	{
		this.id = id;
	}

	/**
	 * Gibt die ID des Blocks zurück.
	 */
	public int getBlockID()
	{
		return id;
	}

	/**
	 * Gibt die ID zurück, die gedropt werden soll, wenn der Block abgebaut wird.
	 */
	public int getDropID()
	{
		return -1;
	}

	/**
	 * Wird ausgelöst, wenn auf den Block geklickt wird.
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
}
