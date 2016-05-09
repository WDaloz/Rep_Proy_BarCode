package com.daloz.barcode.exceptions;

import static com.daloz.barcode.config.enums.LibraryProcessMessages.*;

@SuppressWarnings("serial")
public class NumberDigitCodeOutRangeException extends Exception
{
	public NumberDigitCodeOutRangeException()
	{
		super(NUMBER_DIGIT_CODE_OUT_RANGE_EXCEPTION.getMessage());
	}
}
