public class LinkInt
{
	// ---------------------- fields ----------------------
	private int data;
	private LinkInt next;
	
	//----------------------constructors----------------------
	public LinkInt(int data, LinkInt next)
	{
		this.data=data;
		this.next=next;
	}
	
	public LinkInt(int data)
	{
		this(data, null);
	}
	
	//----------------------methods----------------------
	public LinkInt getNext()
	{
		return next;
	}
	
	public void setNext(LinkInt newNext)
	{
		next=newNext;
	}
	
	public int getData()
	{
		return data;
	}
	
	public String toString()
	{
		return ""+getData();
	}
}