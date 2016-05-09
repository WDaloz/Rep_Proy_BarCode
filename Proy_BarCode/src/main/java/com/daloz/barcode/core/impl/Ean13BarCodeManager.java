package com.daloz.barcode.core.impl;

import com.daloz.barcode.core.IBarcodeManager;
import com.daloz.barcode.dataobjects.FileProcessResponse;
import com.daloz.barcode.exceptions.NumberDigitCodeProductOutRangeException;
import com.daloz.barcode.exceptions.NumberDigitCodeOutRangeException;

import static com.daloz.barcode.config.enums.CodeCostants.CODE_COMPANY;
import static com.daloz.barcode.config.enums.CodeCostants.CODE_COUNTRY;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Ean13;

public class Ean13BarCodeManager implements IBarcodeManager
{
	private static Ean13BarCodeManager instance = null;
	private static JBarcodeBean jBarcodeBean = null;

	private Ean13BarCodeManager()
	{

	}

	public static Ean13BarCodeManager getInstance()
	{
		if (instance == null)
		{
			instance = new Ean13BarCodeManager();
			jBarcodeBean = new JBarcodeBean();
		}
		return instance;
	}

	@Override
	public FileProcessResponse generateCode(Long codeProd, String... path)
	{
		FileProcessResponse fResponse = new FileProcessResponse();

		try
		{
			if (codeProd.toString().length() >= 6)
			{
				throw new NumberDigitCodeProductOutRangeException();
			}

			long starTime = System.nanoTime();

			String contZero = "";

			for (int i = 1; i <= 5 - codeProd.toString().length(); i++)
			{
				contZero = String.valueOf(0).concat(contZero);
			}

			Long code = Long.parseLong(new StringBuilder().append(CODE_COUNTRY.getCode().toString())
					.append(CODE_COMPANY.getCode().toString()).append(contZero.concat(codeProd.toString())).toString());

			code = Long.parseLong(code.toString().concat(generateCheckDigit(code).toString()));
			String pathImage = null;

			if (path.length != 0)
			{
				generateBarCode(code, path[0]);
				pathImage = path[0];
			}

			long endTime = System.nanoTime();

			fResponse.generatingMappingSatisfactory(code, starTime, endTime, "Proceo realizado con exito.", pathImage);

		}
		catch (NumberDigitCodeProductOutRangeException e)
		{
			fResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}

		return fResponse;
	}

	@Override
	public FileProcessResponse generateBarCode(Long code, String path)
	{
		FileProcessResponse fResponse = new FileProcessResponse();
		try
		{
			if (code.toString().length() >= 14)
			{
				throw new NumberDigitCodeOutRangeException();
			}
			
			long starTime = System.nanoTime();

			jBarcodeBean.setCodeType(new Ean13());
			jBarcodeBean.setCode(code.toString());
			jBarcodeBean.setCheckDigit(true);

			BufferedImage bufferedImage = jBarcodeBean.draw(new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB));

			File file = new File(path);
			ImageIO.write(bufferedImage, "png", file);

			long endTime = System.nanoTime();

			fResponse.generatingMappingSatisfactory(code, starTime, endTime, "Proceso realizado con exito.", path);
		}
		catch (IOException | NumberDigitCodeOutRangeException e)
		{
			fResponse.generatingMappingErrors(e);
			e.printStackTrace();
		}

		return fResponse;
	}

	@Override
	public FileProcessResponse readBarCode()
	{
		return null;
	}

	private Integer generateCheckDigit(Long code)
	{
		// Convertimos los numeros en un arreglo de digitos.
		char[] charDigits = code.toString().toCharArray();

		// arreglo para multiplicar pares e impares.
		int[] ean13 = { 1, 3 };

		// Contenera la suma realizada.
		Integer sum = 0;

		for (int i = 0; i < charDigits.length; i++)
		{
			// digito * ean13[indice % 2](la posicion lo define el residuo)
			sum += Character.getNumericValue(charDigits[i] * ean13[i % 2]);
		}

		Integer checkSum = 10 - (sum % 10);

		if (checkSum == 10)
		{
			return 0;
		}
		return checkSum;
	}
}
