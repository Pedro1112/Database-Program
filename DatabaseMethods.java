

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class DatabaseMethods
{
	static final String DATABASE_URL = "jdbc:mysql://localhost/properties";
	static private int num;
	static int numberOfColumns;
	static ResultSetMetaData metaData;
	static ResultSet resultSet;

	static Connection connection;
	static Statement statement;

	
	static PreparedStatement insertOwner = null;
	static PreparedStatement insertCommercial = null;
	static PreparedStatement insertResidential = null;
	
	static PreparedStatement readOwner= null;
	static PreparedStatement readCommercial= null;
	static PreparedStatement readResidential= null;	

	static PreparedStatement selectAllOwners = null;
	static PreparedStatement selectAllCommercialProperty = null;
	static PreparedStatement selectAllResidentialProperty = null;
	static int res =0;
	
        static ArrayList<Owner>ownersList = new ArrayList<Owner>();
	static ArrayList<CommercialProperty>commercialList = new ArrayList<CommercialProperty>();
	static ArrayList<ResidentialProperty>residentialList = new ArrayList<ResidentialProperty>();

	static Property.PropertyTier tier;
	static ResidentialProperty.Subdivision subdivision;
	



	public static ResidentialProperty.Subdivision determineDivision(String s)
    	{
        	ResidentialProperty.Subdivision subdivision;
        
        	if(s.equals("KINGLY_ESTATES"))
            		subdivision = ResidentialProperty.Subdivision.KINGLY_ESTATES;
        	else if(s.equals("STATELY_ESTATES"))
            		subdivision = ResidentialProperty.Subdivision.STATELY_ESTATES;
        	else if(s.equals("KING_MANOR"))
            		subdivision = ResidentialProperty.Subdivision.KING_MANOR;
        	else
            		subdivision = ResidentialProperty.Subdivision.GREEN_GABLES;
        
        	return subdivision;                                   
    	}
	
	public boolean determineFlood(String f)
    	{
        	boolean floodZone;
        
        	if(f.equals("Yes"))
        	{
          		floodZone = true;
        	}
        	else
        	{
            		floodZone = false;
        	}
        	return floodZone;
    	}

	

	
	public static List<Owner> readOwners()
	{
		
		List<Owner> results = null;
		resultSet = null;
		
		

		try
		{			
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");

			selectAllOwners = connection.prepareStatement( "SELECT * FROM Owners" );
			resultSet = selectAllOwners.executeQuery();
			results = new ArrayList<Owner>();
		
			while(resultSet.next())
			{
				results.add(new Owner(
				resultSet.getString("OwnerName"),new Address(resultSet.getString("street"),resultSet.getString("city"),resultSet.getString("state"),resultSet.getInt("zip"))));
						
					
				ownersList.add(new Owner(resultSet.getString("OwnerName"),new Address(resultSet.getString("street"),resultSet.getString("city"),resultSet.getString("state"),resultSet.getInt("zip"))));
				

				
			}
			System.out.println("\nReading in Owners Table\n");
			System.out.print(results);
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
      		{
         		try 
         		{
           			resultSet.close();
         		} // end try
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			//close();
         		} // end catch

			

      		} // end finally
      
      		return ownersList;

		
   	} // end method
		
	
	public static List<Property> readCommercialProperty()
	{
		List<Property> results = null;
		resultSet = null;

		Date datePurchased = null;
		subdivision = null;
		
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
			selectAllCommercialProperty = connection.prepareStatement("SELECT * FROM CommercialProperties");
			
			resultSet = selectAllCommercialProperty.executeQuery();
			//resultSet = readCommercialProperties.executeQuery();
			results = new ArrayList<Property>();


			while(resultSet.next())
			{

				if (resultSet.getString("propertytier").equals("TIER1"))
					tier = Property.PropertyTier.TIER1; 
		
				if (resultSet.getString("propertytier").equals("TIER2"))
					tier = Property.PropertyTier.TIER2;
		
				if (resultSet.getString("propertytier").equals("TIER3"))
					tier = Property.PropertyTier.TIER3; 
		
				if (resultSet.getString("propertytier").equals("TIER4"))
					tier = Property.PropertyTier.TIER4;
				
				commercialList.add(new CommercialProperty(resultSet.getInt("AccountNumber"), new Address(resultSet.getString("Street"), resultSet.getString("City"), 
								resultSet.getString("State"), resultSet.getInt("Zip")), resultSet.getDouble("MarketValue"),new Date(resultSet.getInt("month"),resultSet.getInt("day"),resultSet.getInt("year")),resultSet.getInt("squarefeet"),tier,
								resultSet.getString("businessname"),resultSet.getString("StateCode")));
						

				for(Owner ow:ownersList)
				{
					if(resultSet.getString("PropertyType").equals("Commercial"));
					{	
						if(resultSet.getString("ownername").equals(ow.getName()))
						{
							ow.addProperty(new CommercialProperty(resultSet.getInt("AccountNumber"), new Address(resultSet.getString("Street"), resultSet.getString("City"), 
								resultSet.getString("State"), resultSet.getInt("Zip")), resultSet.getDouble("MarketValue"),new Date(resultSet.getInt("month"),resultSet.getInt("day"),resultSet.getInt("year")),resultSet.getInt("squarefeet"),tier,
								resultSet.getString("businessname"),resultSet.getString("StateCode")));
						}
					}
				}
				
				
				
			}  // end while
			System.out.println("\nReading in Commercial Property Table\n");
			System.out.println(commercialList);
		}
		catch ( SQLException sqlException )
      		{
         		sqlException.printStackTrace();         
      		} // end catch
      		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} // end try
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			//close();
         		} // end catch
      		} // end finally
      
		return results;

   	} // end method 
	
	
	public static List<Property> readResidentialProperty()
	{		
		List<Property> results = null;
		resultSet = null;
		subdivision = null;
		
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
			selectAllResidentialProperty = connection.prepareStatement("SELECT * FROM ResidentialProperties");
	
			resultSet = selectAllResidentialProperty.executeQuery();
			results = new ArrayList<Property>();
		
			
			
			while(resultSet.next())
			{
				if (resultSet.getString("propertytier").equals("TIER1"))
					tier = Property.PropertyTier.TIER1; 
		
				if (resultSet.getString("propertytier").equals("TIER2"))
					tier = Property.PropertyTier.TIER2;
		
				if (resultSet.getString("propertytier").equals("TIER3"))
					tier = Property.PropertyTier.TIER3; 
		
				if (resultSet.getString("propertytier").equals("TIER4"))
					tier = Property.PropertyTier.TIER4;

				residentialList.add(new ResidentialProperty(resultSet.getInt("AccountNumber"), new Address(resultSet.getString("Street"), resultSet.getString("City"), 
								resultSet.getString("State"), resultSet.getInt("Zip")), resultSet.getDouble("MarketValue"),new Date(resultSet.getInt("month"),resultSet.getInt("day"),resultSet.getInt("year")),resultSet.getInt("squarefeet"),tier,
								resultSet.getBoolean(1),determineDivision(resultSet.getString("subdivision"))));


				for(Owner ow:ownersList)
				{
					if(resultSet.getString("PropertyType").equals("Residential"));
					{	
						if(resultSet.getString("ownername").equals(ow.getName()))
						{
							ow.addProperty(new ResidentialProperty(resultSet.getInt("AccountNumber"), new Address(resultSet.getString("Street"), resultSet.getString("City"), 
								resultSet.getString("State"), resultSet.getInt("Zip")), resultSet.getDouble("MarketValue"),new Date(resultSet.getInt("month"),resultSet.getInt("day"),resultSet.getInt("year")),resultSet.getInt("squarefeet"),tier,
								resultSet.getBoolean(1),determineDivision(resultSet.getString("subdivision"))));
						}
					}
				}

			}  // end while
			System.out.println("\nReading in Residential Property Table\n");
			System.out.println(residentialList);
			
		} // end try
		catch ( SQLException sqlException )
      		{
         		sqlException.printStackTrace();         
      		} // end catch
      		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} // end try
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			//close();
         		} // end catch
      		} // end finally
      
      		return results;
   	} // end method

	
	

	public static void addOwner(String ln, String str ,String ct,String sta,int zp)
	{
		String name = ln;
		String street = str;
		String city = ct;
		String state = sta;
		int zip = zp;
		
		
		
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
	
			statement = connection.createStatement();

			insertOwner = connection.prepareStatement("INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES(?,?,?,?,?)");

		
			insertOwner.setString(1,ln);
			insertOwner.setString(2,str);
			insertOwner.setString(3,ct);
			insertOwner.setString(4,sta);
			insertOwner.setInt(5,zp);

			res = insertOwner.executeUpdate();

		}
	
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
	}  // end addOwner

	
	public static void addCommercial(String propertyType, String name, int accountNumber, String street,String city, String state, int zip, double marketValue, int day, int month, int year, int squareFeet, String tier,String businessName, String stateCode) 
	{
		
			
		
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
	
			statement = connection.createStatement();

			insertCommercial = connection.prepareStatement("INSERT INTO CommercialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,day,month,year,SquareFeet,PropertyTier,BusinessName,StateCode) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
	
			insertCommercial.setString(1, propertyType);
			insertCommercial.setString(2, name);
			insertCommercial.setInt(3, accountNumber);
			insertCommercial.setString(4, street);
			insertCommercial.setString(5, city);
			insertCommercial.setString(6, state);
			insertCommercial.setInt(7, zip);
			insertCommercial.setDouble(8, marketValue);
			insertCommercial.setInt(9, day);
			insertCommercial.setInt(10, month);
			insertCommercial.setInt(11, year);
			insertCommercial.setInt(12, squareFeet);
			insertCommercial.setString(13, tier);
			insertCommercial.setString(14, businessName);
			insertCommercial.setString(15, stateCode);
		
			res = insertCommercial.executeUpdate();

		}

		catch(SQLException sqle)
		{
			sqle.printStackTrace();

		}

		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}


	}  // End addCommercial


	public static void addResidential(String propertyType, String name, int accnumber, String street,String city, String state, int zip, double marketValue, int day, int month, int year, int squareFeet, String tier,boolean floodZone, String subdivision)
	{
		
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
	
			statement = connection.createStatement();
	
			insertResidential = connection.prepareStatement("INSERT INTO ResidentialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day,Month,Year,SquareFeet,PropertyTier,FloodZone,Subdivision) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			
			
			insertResidential.setString(1,propertyType);
			insertResidential.setString(2,name);
			insertResidential.setInt(3,accnumber);	
			insertResidential.setString(4,street);
			insertResidential.setString(5,city);
			insertResidential.setString(6,state);
			insertResidential.setInt(7,zip);
			insertResidential.setDouble(8,marketValue);
			insertResidential.setInt(9,day);
			insertResidential.setInt(10,month);
			insertResidential.setInt(11,year);
			insertResidential.setInt(12,squareFeet);
			insertResidential.setString(13,tier);
			insertResidential.setBoolean(14,floodZone);
			insertResidential.setString(15,subdivision);
		
			res = insertResidential.executeUpdate();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();

		}

		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
	
	}  // end addResidential()


	public static void writeDatabase()
	{	
		connection = null;
		statement = null;
		resultSet = null;

		try
		{							 
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");

			
			statement = connection.createStatement();

							
			resultSet = statement.executeQuery("SELECT * from Owners");

			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();
			System.out.println("Owners table of Properties Database:\n");

			for(int i = 1; i<= numberOfColumns; i++)
				System.out.printf( "%-8s\t",metaData.getColumnName(i));
			System.out.println();

			while(resultSet.next())
			{
				for(int i = 1;i<=numberOfColumns;i++)
					System.out.printf("%-8s\t",resultSet.getObject(i));
			System.out.println();
			System.out.println();

			}  // end while

		
		//***************************************************
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");

			statement = connection.createStatement();

							
			resultSet = statement.executeQuery("SELECT * from CommercialProperties");

			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();
			System.out.println("Commercial Properties Table of Properties Database:\n");

			for(int i = 1; i<= numberOfColumns; i++)
				System.out.printf( "%-8s\t",metaData.getColumnName(i));
			System.out.println();

			while(resultSet.next())
			{
				for(int i = 1;i<=numberOfColumns;i++)
					System.out.printf("%-8s\t",resultSet.getObject(i));
			System.out.println();
			System.out.println();

			}  // end while

	 	  //****************************************************
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");

			statement = connection.createStatement();

							
			resultSet = statement.executeQuery("SELECT * from ResidentialProperties");

			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();
			System.out.println("\nResidential Properties Table of Properties Database:\n");

			for(int i = 1; i<= numberOfColumns; i++)
				System.out.printf( "%-8s\t",metaData.getColumnName(i));
			System.out.println();

			while(resultSet.next())
			{
				for(int i = 1;i<=numberOfColumns;i++)
					System.out.printf("%-8s\t",resultSet.getObject(i));
			System.out.println();
			System.out.println();

			}  // end while

		  //****************************************************
			
		}  // end try

		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}

		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
		
			catch(Exception exception)
			{
				exception.printStackTrace();

			}
		} // end finally
		

	} // end writeDatabase()

	
	public static void writeOwnerList()
	{
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,"cdavis","fall2013");
	
			statement = connection.createStatement();
	
			resultSet = statement.executeQuery("SELECT * FROM Owners");
	
			metaData = resultSet.getMetaData();

			numberOfColumns = metaData.getColumnCount();

			System.out.println("Owners List\n");		

	
			for(int i = 1; i <= numberOfColumns; i++)
			{
				System.out.printf("%-8s\t", metaData.getColumnName(i));
				
			}
			while(resultSet.next())
			{
				for(int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
					System.out.println();
			}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
	}

		
	
}// end class





