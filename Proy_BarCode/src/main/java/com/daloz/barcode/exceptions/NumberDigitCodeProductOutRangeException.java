package com.daloz.barcode.exceptions;

import static com.daloz.barcode.config.enums.LibraryProcessMessages.*;

@SuppressWarnings("serial")
public class NumberDigitCodeProductOutRangeException extends Exception
{
	public NumberDigitCodeProductOutRangeException()
	{
		super(NUMBER_DIGIT_CODE_PRODUCT_OUT_RANGE_EXCEPTION.getMessage());
	}
}
