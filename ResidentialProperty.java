
import java.io.*;

public class ResidentialProperty extends Property implements Exemption,Serializable
{

	public enum Subdivision{NONE,KINGLY_ESTATES,STATELY_ESTATES,KING_MANOR,GREEN_GABLES};
	private Subdivision subdivision = Subdivision.NONE;
	private boolean floodZone = false;
	private double exemption;

	public ResidentialProperty()
	{	
		super();
	}

	public ResidentialProperty(int n, Address a, double v, Date d, int f, PropertyTier t, boolean z, Subdivision s)
	{
		super(n,a,v,d,f,t);
		setFloodZone(z);
		setSubdivision(s);
	}

	public void setSubdivision(Subdivision s)
	{
		subdivision = s;
	}
	
	public void setFloodZone(boolean z)
	{
		floodZone = z;
	}

	public void setExemption(double e)
	{
		exemption = e;
	}

	public Subdivision getSubdivision()
	{
		return subdivision;
	}

	public boolean getFloodZone()
	{
		return floodZone;
	}

	public String toString()
	{
		return (super.toString() + " Subdivision " + subdivision + " Flood Zone " + floodZone);
	}

	public double getExemption()
	{
		return exemption;
	}

	public double calculateTaxes()
	{
		double tax = .05 * getSquareFeet();

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

	public String calculateExemption()
	{
		String msg = "";
		msg += String.format("County $%,.2f     City $%,.2f     School $%,.2f     Medical $%,.2f", getMarketValue() * COUNTY/100, getMarketValue() * CITY/100, getMarketValue() * SCHOOL/100, getMarketValue() * MEDICAL/100);
		return msg;

	}


}