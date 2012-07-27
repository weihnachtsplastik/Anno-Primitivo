package main;

public class AnnoRunnableSound implements Runnable
{
	private Anno anno;

	public AnnoRunnableSound(Anno anno)
	{
		this.anno = anno;
	}
	
	@Override
	public void run()
	{
		anno.doTick();
	}

}
