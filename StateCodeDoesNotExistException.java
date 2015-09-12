
class StateCodeDoesNotExistException extends RuntimeException
{
	public StateCodeDoesNotExistException()
	{
		super("State Code Does Not Exist\nMust Have \" LnnnL\" Format");
	}
		
} 