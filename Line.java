package alpha;

import java.util.LinkedList;
import java.util.ListIterator;

public class Line 
{
	int netID;
	int lneID;
	int lneTypID;
	String lneName;
	String lneDesc;
	LinkedList<Route> rutLL = new LinkedList<Route>();
	
	/**
	 * Parameterized Constructor that initializes all the data members of the Line Class
	 * @param nID Network ID
	 * @param ID Line ID
	 * @param typID Line Type ID
	 * @param Name Line Name
	 * @param Desc Line Description
	 */
	
	Line(int nID, int ID, int typID, String Name, String Desc)
	{
		netID = nID;
		lneID = ID;
		lneTypID = typID;
		lneName = Name;
		lneDesc = Desc;
	}
	
	/**
	 * Returns the Network ID
	 * @return Network ID
	 */
	
	public int getNetID()
	{
		return netID;
	}
	
	/**
	 * Returns the Line ID
	 * @return Line ID
	 */
	
	public int getLneID()
	{
		return lneID;
	}
	
	/**
	 * Returns the Line Type ID
	 * @return Line Type ID
	 */
	
	public int getLneTypID()
	{
		return lneTypID;
	}
	
	/**
	 * Returns the Line Name
	 * @return Line Name
	 */
	
	public String getLneName()
	{
		return lneName;
	}
	
	/**
	 * Returns the Line Description
	 * @return Line Description
	 */
	
	public String getLneDesc()
	{
		return lneDesc;
	}
	
	/**
	 * Get Route Object from Route List
	 * @param rutID to get the Route from the List
	 * @return The Route Object with the respective Route ID
	 */
	
	public Route getRutObj(int rutID)
	{
		Route rteObj = null;
		
		ListIterator<Route> itr = rutLL.listIterator();
		
		while(itr.hasNext())
		{
			rteObj = itr.next();
			if(rteObj.getRutID() == rutID)
			{
				break;
			}
		}
		return rteObj;
	}
	
	/**
	 *Adds the Route Object to the Route Linked List 
	 * @param rteObj Route Object to be added
	 */
	
	public void addRoute(Route rteObj)
	{
		rutLL.add(rteObj);
	}
}
