package com.amazon.customexception;

@SuppressWarnings("serial")
public class CustomExceptions extends RuntimeException{
	
	public CustomExceptions()
	{
		
	}
	public CustomExceptions(String s)
	{
		super(s);
	}


}
