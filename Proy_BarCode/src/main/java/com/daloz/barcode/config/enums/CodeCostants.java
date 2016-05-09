package com.daloz.barcode.config.enums;

public enum CodeCostants
{
	CODE_COUNTRY(770),	
	CODE_COMPANY(7777);
	
	private Integer code;
	
	private CodeCostants(Integer code)
	{
		this.code = code;
	}

	public Integer getCode()
	{
		return code;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}
	
	
}
