
import java.io.*;
public class Address implements Serializable
{

	private String street;
	private String city;
	private String state;
	private int zip;

	public Address()
	{
		setStreet("");
		setCity("");
		setState("");
		setZip(0);
	}

	public Address(String s, String c, String st, int z)
	{
		setStreet(s);	
		setCity(c);
		setState(st);
		setZip(z);
	}

	public void setStreet(String s)
	{
		street = s;
	}

	public void setCity(String c)
	{
		city = c;
	}

	public void setState(String st)
	{
		state = st;
	}

	public void setZip(int z)
	{
		zip = z;
	}
	
	public String getStreet()
	{
		return street;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public int getZip()
	{
		return zip;
	}

	public String toString()
	{
		return(" Street " + street + " City " + city + " State " + state + " Zip " + zip);
	}



}