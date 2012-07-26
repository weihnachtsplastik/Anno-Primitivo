package src;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class EntityManager
{
	private List<Entity> entityList;

	public EntityManager()
	{
		entityList = new ArrayList<Entity>();

	}

	/**
	 * F�gt einen Entity zur Liste hinzu.
	 * 
	 * @param entity
	 *            der Entity, der hinzugef�gt werden soll.
	 */
	public void addEntity(Entity entity)
	{
		entityList.add(entity);
	}

	/**
	 * Gibt den Entity mit der angegebenen ID zur�ck.
	 * 
	 * @param id
	 *            die ID des Entitys
	 */
	public Entity getEntity(int id)
	{
		for(int i = 0; i <= entityList.size(); i++)
		{
			if(entityList.get(i).getID() == id)
			{
				return entityList.get(i);
			}

		}
		return null;
	}

	/**
	 * Zeichnet alle Entitys
	 * 
	 * @param g
	 *            Graphics zum Zeichnen der Entitys
	 */
	public void paintEntitys(Graphics g, float zoom)
	{
		for(int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).paint(g, zoom);
		}
	}

	/**
	 * Gibt die Gr��e der Entity Liste zur�ck.
	 */
	public int size()
	{
		return entityList.size();
	}

	/**
	 * Aktuallisiert alle Entitys.
	 */
	public void updateEntitys()
	{
		for(int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).updateEntity();
		}
	}
}
