package main;


public class AnnoRunnableUpdate implements Runnable
{
	private Anno anno;

	public AnnoRunnableUpdate(Anno anno)
	{
		this.anno = anno;
	}

	@Override
	public void run()
	{
		anno.doTick();
	}
}
