class PrintNos 
{
	synchronized void display(String threadName)
	{
		System.out.println("\n(*) Thread : " + threadName + " - calling display().");
		for(int i=1;i<=1000;i++)
		{
			System.out.print(i + " ");
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				System.out.println("$ Exception occurred : " + e);
			}
		}
		System.out.println();
		System.out.println("(*) Thread : " + threadName + " - display() exiting.");
		System.out.println();
	}
}
class MyThread extends Thread
{
	PrintNos obj;	
	MyThread(PrintNos obj)
	{
		this.obj = obj;
	}
	
	public void run()
	{
		System.out.println("\n// Running Thread name : " + this.getName());
		obj.display(this.getName());
		System.out.println("\n// Thread name : " + this.getName() + " exiting.\n");
	}
}
public class Multithreading
{
	public static void main(String[] args)
	{
		PrintNos obj = new PrintNos();
		MyThread t1 = new MyThread(obj);
		t1.setName("T1");		
		MyThread t2 = new MyThread(obj);
		t2.setName("T2");
		t1.start();
		t2.start();
	}
}