
import java.util.ArrayList;
import java.io.*;

public class Owner implements Serializable
{
	private String name;
	private Address ownerAddress;
	private ArrayList<Property> propertyList = new ArrayList<Property>();
	private double totalTaxes;

	public Owner()
	{
		setName("");
		setOwnerAddress(new Address());
	}

	public Owner(String n, Address a)
	{
		setName(n);
		setOwnerAddress(a);
	}

	public String getName()
	{
		return name;
	}

	public Address getOwnerAddress()
	{
		return ownerAddress;
	}

	public double getTotalTaxes()
	{
		return totalTaxes;
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setOwnerAddress(Address a)
	{
		ownerAddress = a;
	}

	public void setTotalTaxes(double t)
	{
		totalTaxes = t;
	}

	public void addProperty(Property p)
	{
		propertyList.add(p);
	}

	public ArrayList<Property> getPropertyList()
	{
		return propertyList;
	}

	public String makeList()
	{
		String msg = "";
		for(Property p : propertyList)
			msg += p.toString() + "\n";
		return msg;
		
	}

	public String toString()
	{
		return (" Name " + name + " Owner Address " + ownerAddress.toString() + " Property List " + makeList() + " Total Taxes " + totalTaxes);
	}
}