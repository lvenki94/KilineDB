package alpha;

import java.io.*;
import java.util.ListIterator;

public class Extract
{
	
	public void extractPoint(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/point.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int ID, coorX, coorY;
		int ind, nxtind;
		char ch = '|';
		
		String temp;
		
		while((temp = br.readLine())!=null)
		{
			ind = temp.indexOf(ch);
			
			ID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch, ++ind);
			
			coorX = Integer.parseInt(temp.substring(ind,nxtind));
					
			ind = ++nxtind;
			
			coorY = Integer.parseInt(temp.substring(ind));
			
			Point pntObj = new Point(ID, coorX, coorY);
			obj.addPoint(pntObj);
		}
		
		br.close();
	}
	
	public void extractNetwork(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/network_vrsn.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID;
		String nName, nBegin, nEnd;
		int ind, nxtind;
		char ch = '|';
		
		String temp;
		
		Network netObj = null;
		
		while((temp = br.readLine()) != null)
		{
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			nName = temp.substring(ind,nxtind);
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			nBegin = temp.substring(ind,nxtind);
			
			ind = ++nxtind;
			
			nEnd = temp.substring(ind);
			
			netObj = new Network(nID, nName, nBegin, nEnd);
			obj.addNetwork(netObj);
		}
		br.close();		
	}
	
	public void extractStopArea(Application obj)throws IOException
	{
		
		FileReader fr = new FileReader("data/stoparea.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID, sarID, sarPrin;
		String sarName;
		
		Network netObj = obj.netLL.get(0);
		
		String temp;
		int ind, nxtind;
		char ch ='|';
		
		StopArea sarObj = null;
		
		while((temp = br.readLine()) != null)
		{
			
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			sarID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			sarName = temp.substring(ind,nxtind);
			
			ind = ++nxtind;
			
			sarPrin = Integer.parseInt(temp.substring(ind));
			
			sarObj = new StopArea(nID, sarID, sarName, sarPrin);
			
			if(netObj.getNetID() != nID)
			{
				netObj = obj.getNetworkObj(nID);
			}
			
			netObj.addStopArea(sarObj);
		}
		
		br.close();
		
	}
	
	public void extractStopPoint(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/stopoint.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID, stID, saID, daID, ptID;
		String stDesc;
		
		int ind, nxtind;
		String temp;
		char ch = '|';
		
		Network netObj = obj.netLL.get(0);
		StopArea sarObj = obj.netLL.get(0).sarLL.get(0);
		Point pntObj = obj.pntLL.get(0);
		
		ListIterator<Point> itr = obj.pntLL.listIterator();
		
		
		while((temp = br.readLine()) != null)
		{
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			stID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			saID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			daID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			ptID = Integer.parseInt(temp.substring(ind,nxtind));
			
			
			ind = ++nxtind;
			
			stDesc = temp.substring(ind);
			if(ptID != -1)
			{
				while(itr.hasNext())
				{
					if(pntObj.getPntID() == ptID)
					{
						break;
					}
					pntObj = itr.next();
				}
				StopPoint stObj = new StopPoint(nID, stID, saID, daID, pntObj, stDesc);
			
				if(netObj.getNetID() != nID)
				{
					netObj = obj.getNetworkObj(nID);
				}
			
				if(sarObj.getSarID() != saID)
				{
					sarObj = netObj.getSarObj(saID);
				}
			
				sarObj.addStopPoint(stObj);
			}
		}
		br.close();
	}
	
	public void extractLink(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/link.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int lkID, ptBegin, ptEnd;
		String  lkDesc, lkDate;
		
		
		Point pntBgObj = obj.pntLL.get(0);
		Point pntEdObj = obj.pntLL.get(0);
		
		int ind, nxtind;
		String temp;
		char ch = '|';
		
		Link lnkObj = null;
		
		
		while((temp = br.readLine()) != null)
		{	
			ind = temp.indexOf(ch);
			
			lkID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			ptBegin = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			ptEnd = Integer.parseInt(temp.substring(ind,nxtind));
			
			pntBgObj = obj.getPntObj(ptBegin);
			pntEdObj = obj.getPntObj(ptEnd);
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			lkDesc = temp.substring(ind,nxtind);
			
			ind = ++nxtind;
			lkDate = temp.substring(ind);
			
			lnkObj = new Link(lkID, pntBgObj, pntEdObj, lkDesc, lkDate);
			
			obj.addLink(lnkObj);
		}
		br.close();
	}
	
	public void extractLine(Application obj)throws IOException
	{
		
		FileReader fr = new FileReader("data/line.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int lnNetID, lnTypID, lnID;
		String  lnName, lnDesc;
		
		Network netObj = obj.netLL.get(0);
		Line lneObj = null;
		
		int ind, nxtind;
		String temp;
		char ch = '|';
		
		while((temp = br.readLine())!=null)
		{
			ind = temp.indexOf(ch);
			
			lnNetID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			lnID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			lnTypID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			lnName = temp.substring(ind,nxtind);
			
			ind = ++nxtind;
			
			lnDesc = temp.substring(ind);
			
			
			
			if(netObj.getNetID() != lnNetID)
			{
				netObj = obj.getNetworkObj(lnNetID);
			}
			
			lneObj = new Line(lnNetID, lnID, lnTypID, lnName, lnDesc);
			netObj.addLine(lneObj);
		}
		br.close();
	}
	
	public void extractRoute(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/route.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID, lID, rID;
		
		Network netObj = obj.netLL.get(0);
		Line lneObj = netObj.lneLL.get(0);
		
		int ind, nxtind;
		char ch = '|';
		
		String temp;
		
		Route rteObj = null;
		
		while((temp = br.readLine()) != null)
		{
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			lID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			
			rID = Integer.parseInt(temp.substring(ind));
			
			rteObj = new Route(nID, lID, rID);
			
			if(netObj.getNetID() != nID)
			{
				netObj = obj.getNetworkObj(nID);
			}
			
			if(lneObj.getLneID() != lID)
			{
				lneObj = netObj.getLineObj(lID);
			}
			
			lneObj.addRoute(rteObj);
		}
		br.close();
	}
	
	public void extractStopPointToRoute(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/sar_on_rte.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID, saID, lnID, rtID, stID;
		
		int ind, nxtind;
		char ch ='|';
		
		String temp;
		
		Network netObj = obj.netLL.get(0);
		Line lneObj = netObj.lneLL.get(0);
		Route rteObj = lneObj.rutLL.get(0);
		StopArea sarObj = netObj.sarLL.get(0);
	    StopPoint stpObj = sarObj.stpPntLL.get(0);
		
		while((temp = br.readLine())!=null)
		{
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			saID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			lnID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			rtID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			stID = Integer.parseInt(temp.substring(ind,nxtind));
			
			if(netObj.getNetID() != nID)
			{
				netObj = obj.getNetworkObj(nID);
			}
			if(sarObj.getSarID() != saID)
			{
				sarObj = netObj.getSarObj(saID);
			}
			
			
			stpObj = sarObj.getStopPointObj(stID);
			if(stpObj != null)
			{
				
				if(lneObj.getLneID() != lnID)
				{
					lneObj = netObj.getLineObj(lnID);
				}
				
				if(rteObj.getRutID() != rtID)
				{
					rteObj = lneObj.getRutObj(rtID);
				}
				
				if(rteObj.getRutID() == rtID)
				{
					rteObj.addStopPoint(stpObj);
				}
			}
			
		}
		br.close();
	}
	
	public void extractLinkToRoute(Application obj)throws IOException
	{
		FileReader fr = new FileReader("data/lnk_on_rte.dat");
		BufferedReader br = new BufferedReader(fr);
		
		int nID, lnID, rtID, lkID;
		
		int ind,nxtind;
		char ch = '|';
		
		String temp;
		
		Network netObj = obj.netLL.get(0);
		Line lneObj = netObj.lneLL.get(0);
		Route rteObj = lneObj.rutLL.get(0);
		Link lnkObj = null;
		
		while((temp = br.readLine()) != null)
		{
			ind = temp.indexOf(ch);
			
			nID = Integer.parseInt(temp.substring(0,ind));
			
			nxtind = temp.indexOf(ch,++ind);
			
			lnID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			rtID = Integer.parseInt(temp.substring(ind,nxtind));
			
			ind = ++nxtind;
			nxtind = temp.indexOf(ch,ind);
			
			lkID = Integer.parseInt(temp.substring(ind,nxtind));
			
			netObj = obj.getNetworkObj(nID);
			lneObj = netObj.getLineObj(lnID);
			rteObj = lneObj.getRutObj(rtID);
			lnkObj = obj.getLinkObj(lkID);
			
			if(rteObj.getRutID() == rtID)
			{
				rteObj.addLink(lnkObj);
			}
			
		}
		br.close();
	}
	
}
