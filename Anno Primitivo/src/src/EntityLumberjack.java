package src;

import java.awt.Color;
import java.awt.Graphics;

public class EntityLumberjack extends Entity
{
	public EntityLumberjack(int id)
	{
		super(id);
	}
	
	@Override
	public void updateEntity()
	{
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillOval(x, y, 5, 5);
	}
}
