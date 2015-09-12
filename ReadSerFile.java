
import java.io.*;
import java.util.*;

public class ReadSerFile implements Serializable
{
	public static void main(String args[])
	{
		Property.PropertyTier tier = null;
		ResidentialProperty.Subdivision subdivision = null;
		
		ArrayList <Owner> ownerList = new ArrayList<Owner>();
		
		Owner w1 = new Owner("Jones", new Address("111 W. 2nd St.", "Tulsa", "Oklahoma", 58934));
		Owner w2 = new Owner("Smith", new Address("7345 Lane Road", "Dallas", "Texas", 75000));
		Owner w3 = new Owner("Willis", new Address("596 Dale Lane", "Fort Worth", "Texas", 76123));
		Owner w4 = new Owner("Traver", new Address("512 Ball Court", "Burleson", "Texas", 76138));
		Owner w5 = new Owner("Merrit", new Address("11 Flower Road", "North Richland Hills", "Texas", 77126));
		
		ownerList.add(w1);
		ownerList.add(w2);
		ownerList.add(w3);
		ownerList.add(w4);
		ownerList.add(w5);
		
		ArrayList<Property> property = new ArrayList<Property>();
		
		ResidentialProperty p1 = new ResidentialProperty(12345, new Address("111 W. 2nd St.", "Tulsa", "Oklahoma", 58934),  135000.00, new Date(1, 13, 2013), 1575, tier.TIER2, true, subdivision.STATELY_ESTATES);
		ResidentialProperty p2 = new ResidentialProperty(65892, new Address("92 Davis St.", "Arlington", "Texas", 90000), 90000.00, new Date(3,25, 2010), 2235, tier.TIER2, false, subdivision.GREEN_GABLES);
		CommercialProperty p3 = new CommercialProperty(72634, new Address("3865 Cooper St.", "Arlington", "Texas", 76018), 235000.00, new Date(5, 2, 1999), 1300, tier.TIER4,"Joe's Paint Shop", "A546J");
		CommercialProperty p4 = new CommercialProperty(14256, new Address("111 Smart Road", "New Orleans", "Lousiana", 34562), 65000.00, new Date(7, 15, 2005), 5000, tier.TIER4,"Tacos Galore", "R782D");
		ResidentialProperty p5 = new ResidentialProperty(98765, new Address("252 Park Lane", "Atlanta", "Georgia", 60606),  155000.00, new Date(2, 1, 2014), 1850, tier.TIER1, true, subdivision.KING_MANOR);
		CommercialProperty p6 = new CommercialProperty(19385, new Address("605 Green Blvd", "Arlington", "Texas", 76015), 275000.00, new Date(10,21, 2012), 4221, tier.TIER2, "Battery City", "G921G");
		ResidentialProperty p7 = new ResidentialProperty(72634, new Address("835 Third Avenue", "New York", "NY", 90123), 96000.00, new Date(4, 3, 2008), 3025, tier.TIER3,false, subdivision.KINGLY_ESTATES);
	
		property.add(p1);
		property.add(p2);
		property.add(p3);
		property.add(p4);
		property.add(p5);
		property.add(p6);
		property.add(p7);

		
		writeOwner(ownerList);
		writeProperty(property);
		System.out.println("\nOwners:");
		readOwner();
		System.out.println();
		System.out.println();
		System.out.println("Properties:");
		readProperty();
	}

	public static void writeOwner(ArrayList<Owner> oList)
	{
		ObjectOutputStream output;
		
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("Owners.ser"));
			
			for(Owner w: oList)
			{
				output.writeObject(w);
			}
		
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeProperty(ArrayList<Property> pList)
	{
		ObjectOutputStream output;
	
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("Properties.ser"));
		
			for(Property p: pList)
			{
				output.writeObject(p);
			}
	
		}
	
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}


	public static void readOwner()
	{
		ObjectInputStream input;
		Object obj;
		
		try
		{
			input = new ObjectInputStream(new FileInputStream("Owners.ser"));
			
			while(true)
			{
				obj = (Object)input.readObject();
				System.out.println(((Owner)obj).toString());
			}
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
			}
	}

	public static void readProperty()
	{
		ObjectInputStream input;
		Object obj;
	
		try
		{
			input = new ObjectInputStream(new FileInputStream("Properties.ser"));
		
			while(true)
			{
				obj = (Object)input.readObject();
				System.out.println(((Property)obj).toString());
			}
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}


}





