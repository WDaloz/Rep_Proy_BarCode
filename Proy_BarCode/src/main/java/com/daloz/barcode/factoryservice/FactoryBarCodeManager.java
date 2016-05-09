package com.daloz.barcode.factoryservice;

import com.daloz.barcode.config.enums.TypeBarCode;
import com.daloz.barcode.core.IBarcodeManager;
import com.daloz.barcode.core.impl.Ean13BarCodeManager;

public abstract class FactoryBarCodeManager
{
	public static IBarcodeManager getBarCodeManager(TypeBarCode type)
	{
		switch(type)
		{
			case EAN_13:
				return Ean13BarCodeManager.getInstance();
				
			default:
			    return null;
		}
	}
}
