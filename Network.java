/**
 * Network
 * 
 * @author Venkatesh L
 * 
 */

package alpha;

import java.util.LinkedList;
import java.util.ListIterator;

public class Network 
{
	int netID;
	String netName;
	String netBegin;
	String netEnd;
	LinkedList<Line> lneLL = new LinkedList<Line>();
	LinkedList<StopArea> sarLL = new LinkedList<StopArea>();
	
	
	/**
	 * Initializes the Network Objects
	 * @param ID Network Version ID
	 * @param name Network Version Name
	 * @param begin Validity Begin Date
	 * @param end Validity End Date
	 */
	
	Network(int ID, String name, String begin, String end)
	{
		netID = ID;
		netName = name;
		netBegin = begin;
		netEnd = end;
	}
	
	/**
	 * Returns Network Version ID
	 * @return Network VersionID
	 */
	
	public int getNetID()
	{
		return netID;
	}
	
	/**
	 * Returns Network Version Name
	 * @return Network Version Name
	 */
	
	public String getName()
	{
		return netName;
	}
	
	/**
	 * Returns Validity Begin Date
	 * @return Validity Begin Date
	 */
	
	public String getBegin()
	{
		return netBegin;
	}
	
	/**
	 * Returns Validity End Date
	 * @return Validity End Date
	 */
	
	public String getEnd()
	{
		return netEnd;
	}
	
	/**
	 * Returns the Line Object of the Specified Line ID
	 * @param lneID Line ID of the Line Object Required
	 * @return Line Object required for the specified Line ID
	 */
	
	public Line getLineObj(int lneID)
	{
		Line lneObj = null;
		
		ListIterator<Line> itr = lneLL.listIterator();
		
		while(itr.hasNext())
		{
			lneObj = itr.next();
			if(lneObj.getLneID() == lneID)
			{
				break;
			}
		}
		return lneObj;
	}
	
	/**
	 * Returns the StopArea of the specified StopArea Object
	 * @param sarID StopArea ID of the required StopArea Object
	 * @return StopArea of the specified StopArea
	 */
	
	public StopArea getSarObj(int sarID)
	{
		StopArea sarObj = null;
		
		ListIterator<StopArea> itr = sarLL.listIterator();
		
		while(itr.hasNext())
		{
			sarObj = itr.next();
			if(sarObj.getSarID() == sarID)
			{
				break;
			}
		}
		return sarObj;
	}
	
	/**
	 * Adds the Line Object to the Line Linked List
	 * @param lneObj Line Object to be added
	 */
	
	public void addLine(Line lneObj)
	{
		lneLL.add(lneObj);
	}
	
	/**
	 * Adds the StopArea Object to the StopArea Linked List
	 * @param sarObj StopArea Object to be added
	 */
	
	public void addStopArea(StopArea sarObj)
	{
		
		sarLL.add(sarObj);
	}
	 
}
