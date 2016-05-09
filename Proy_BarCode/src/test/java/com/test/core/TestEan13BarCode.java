package com.test.core;

import static com.daloz.barcode.config.enums.TypeBarCode.*;
import static com.daloz.barcode.util.Log4jU.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.barcode.core.IBarcodeManager;
import com.daloz.barcode.dataobjects.FileProcessResponse;
import com.daloz.barcode.factoryservice.FactoryBarCodeManager;

public class TestEan13BarCode
{
	static IBarcodeManager ean13 = null;

	@BeforeClass
	public static void setUpClass()
	{
		ean13 = FactoryBarCodeManager.getBarCodeManager(EAN_13);
		setLogger(TestEan13BarCode.class);
	}
	
	@Test
	public void testGenerateBarcode()
	{
		String myPath = "src/test/resources/data/ouput/prueba.png";
		FileProcessResponse  fResp= ean13.generateBarCode(new Long("7707777123459"), myPath);
		
		Assert.assertEquals(myPath, fResp.getPath());
		logger.info(fResp.getReport());
	}
	
	@Test
	public void testGenerateCode()
	{
		FileProcessResponse fResp = ean13.generateCode(new Long(12345));
		
		Assert.assertEquals(new Long("7707777123459"), fResp.getCode());
	}
	
}
