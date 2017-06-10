public class Link
{
	//--------------------fields--------------------
	private Object data;
	private Link next;
	
	//--------------------constructors--------------------
	public Link(Object data, Link next)//Constructs a link with specified data and next link.
	{
		this.data=data;
		this.next=next;
	}
	
	public Link(Object data)
	{
		this(data, null);
	}//Constructs a link with specified data.
	
	//--------------------methods--------------------
	public Object getData()
	{
		return data;
	}//Returns the link's data
	
	public Link getNext()
	{
		return next;
	}//Returns the next link
	
	public void setNext(Link next)
	{
		this.next=next;
	}//Replaces the next link in another and returns the previous one.
	
	public Object setData(Object data)//Replaces the data field in another and returns the previous one.
	{
		Object tmp=this.data;
		this.data=data;
		return tmp;
	}
	
	public String toString()
	{
		return data.toString();
	}//Returns the course's description
	
	public boolean equals(Object other)//Checks if this link's data is equals to the other link's data
	{
		//throw new UnsupportedOperationException();
		return other instanceof Link && getData().equals(((Link)other).getData());
	}
}