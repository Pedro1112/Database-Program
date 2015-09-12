
import java.io.*;
import java.util.*;

public class WriteFiles
{

	static Formatter output;

	public static void main(String[]args)
	{
		writeOwners();
		writeProperties();
		

	}

	public static void writeOwners()
	{
		try
		{
			output = new Formatter("owners.txt");
			output.format("%s;%s;%s;%s;%d\n", "Jones", "221 Smith St", "Arlington", "Texas", 76019);
			output.format("%s;%s;%s;%s;%d\n", "Smith", "7345 Lane Rd", "Dallas","Texas", 75000);
			output.format("%s;%s;%s;%s;%d\n", "Willis", "596 Dale Lane", "Fort Worth", "Texas", 76123);
			output.format("%s;%s;%s;%s;%d\n", "Traver", "512 Ball Court", "Burleson", "Texas", 76138);
			output.format("%s;%s;%s;%s;%d\n", "Merrit", "11 Flower Road", "North Richardland Hills", "Texas", 77126);

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}	
			
	}

	public static void writeProperties()
	{
		try
		{
			output = new Formatter("properties.txt");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Residential", "Jones",12345,"111 W. 2nd St.","Tulsa","Oklahoma",58934,135000,1,3,2013,1575,"TIER2","True","Stately Estates");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Residential", "Smith",65892,"92 Davis St.", "Arlington", "Texas",76019,90000,3,25,2010,2235,"TIER3","False","Green Gables");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Commercial", "Willis", 75634, "3865 Cooper St.", "Arlington","Texas",76018,235000,5,2,1999,1300,"TIER4","Joe Paint Shop","A546J");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Commerical", "Jones", 14256, "111 Smart Rd.","New Orleans","Louisiana",34562,65000,7,15,2005,5000,"TIER4","Tacos Galore","R782D");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Residential", "Traver",98765,"252 Park Lane","Atlanta","Georgia",60606,155000,2,1,2014,1850,"TIER1","True","King Manor");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Commercial","Merrit",19385,"605 Green Blvd","Arlington","Texas",76015,275000,10,21,2012,4321,"TIER2","Battery City","G921G");
			output.format("%s;%s;%d;%s;%s;%s;%d;%d;%d;%d;%d;%d;%s;%s;%s\n", "Residential","Willis",38767,"853 Third Avenue","New York","New York",90123,96000,4,3,2008,3025,"TIER3","False","Kingly Estate");
			output.close();

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}
	}
}