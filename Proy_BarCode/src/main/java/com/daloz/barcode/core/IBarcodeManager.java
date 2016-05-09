package com.daloz.barcode.core;

import com.daloz.barcode.dataobjects.FileProcessResponse;

public interface IBarcodeManager
{
	FileProcessResponse generateCode(Long codProd, String... path);
	FileProcessResponse generateBarCode(Long code, String path);
	FileProcessResponse readBarCode();
}
