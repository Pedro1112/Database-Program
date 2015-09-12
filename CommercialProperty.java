
import java.io.*;

public class CommercialProperty extends Property implements Serializable
{
	private String businessName;
	private String stateCode;

	public CommercialProperty()
	{
		super();
		setBusinessName("");
		setStateCode("");
	}

	public CommercialProperty(int n, Address a, double v, Date d, int s, PropertyTier t,String b, String c)
	{
		super(n,a,v,d,s,t);
		setBusinessName(b);
		setStateCode(c);
	}

	public void setBusinessName(String b)
	{
		businessName = b;
	}

	public void setStateCode(String c)
	{
		stateCode = c;
	}

	public String getBusinessName()
	{
		return businessName;
	}

	public String getStateCode()
	{
		return stateCode;
	}

	public String toString()
	{
		return(super.toString() + " Business Name " + businessName + " State Code " + stateCode);
	}

	public double calculateTaxes()
	{
		double tax = .25 * getSquareFeet();
		
		if(getPropertyTier() == PropertyTier.TIER1)
			tax += getMarketValue() * TIER1/100;

		if(getPropertyTier() == PropertyTier.TIER2)
			tax += getMarketValue() * TIER2/100;

		if(getPropertyTier() == PropertyTier.TIER3)
			tax += getMarketValue() * TIER3/100;

		if(getPropertyTier() == PropertyTier.TIER4)
			tax += getMarketValue() * TIER4/100;

		return tax;	
	}



}