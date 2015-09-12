
import java.util.*;
import java.io.*;

public abstract class Property implements TaxRates,Serializable
{
	private int accountNumber;
	private Address propertyAddress;
	private double marketValue;
	private Date datePurchased;
	private int squareFeet;
	public enum PropertyTier{TIER1,TIER2,TIER3,TIER4};
	private PropertyTier propertyTier = PropertyTier.TIER1;
	

	public Property()
	{
		setAccountNumber(0);
		setPropertyAddress(new Address());
		setMarketValue(0.0);
		setDatePurchased(new Date());
		setSquareFeet(0);
	}

	public Property(int n, Address a, double v, Date d, int f, PropertyTier t)
	{
		setAccountNumber(n);
		setPropertyAddress(a);
		setMarketValue(v);
		setDatePurchased(d);
		setSquareFeet(f);
		setPropertyTier(t);
	}

	public void setAccountNumber(int n)
	{
		accountNumber = n;
	}

	public void setPropertyAddress(Address a)
	{
		propertyAddress = a;
	}

	public void setMarketValue(double v)
	{
		marketValue = v;
	}

	public void setDatePurchased(Date d)
	{
		datePurchased = d;
	}

	public void setSquareFeet(int f)
	{
		squareFeet = f;
	}

	public void setPropertyTier(PropertyTier t)
	{
		propertyTier = t;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public Address getPropertyAddress()
	{
		return propertyAddress;
	}

	public double getMarketValue()
	{
		return marketValue;
	}

	public Date getDatePurchased()
	{
		return datePurchased;
	}

	public int getSquareFeet()
	{
		return squareFeet;
	}

	public PropertyTier getPropertyTier()
	{
		return propertyTier;
	}

	public String toString()
	{
		return (" Account Number " + accountNumber + " Property Address " + propertyAddress 
		+ " Market Value " + marketValue + " Purchased Date " + datePurchased + " Square Feet " 
		+ squareFeet + " PropertyTier " + propertyTier);
	}

	public abstract double calculateTaxes();
	
}