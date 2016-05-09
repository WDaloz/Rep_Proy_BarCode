package com.daloz.barcode.config.enums;

public enum LibraryProcessMessages
{
	NUMBER_DIGIT_CODE_PRODUCT_OUT_RANGE_EXCEPTION
	("Fuera de rango el numero de digitos para el codigo del producto segun el tipo"),
	
	NUMBER_DIGIT_CODE_OUT_RANGE_EXCEPTION
	("Fuera de rango el numero de digitos del codigo segun el tipo");

	private String message;

	private LibraryProcessMessages(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}
