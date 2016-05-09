package com.daloz.barcode.config.enums;


public enum TypeBarCode
{
	EAN_13("Ean13", "Este tipo");
	
	private String type, description;
	
	private TypeBarCode(String type, String description)
	{
		this.type = type;
		this.description = description;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	
	
}
