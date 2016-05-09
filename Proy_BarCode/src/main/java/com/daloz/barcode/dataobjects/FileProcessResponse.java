package com.daloz.barcode.dataobjects;

/**
 * Esta entidad me permite definir las propiedades útiles para informar el
 * proceso de crear, generar y leer codigo de barras.
 * 
 * @author Daloz
 * @version 1.0
 */
public class FileProcessResponse
{
	// Codigo y/o Cod de barra generado.
	private Long code;

	// Boolean que define el exito.
	private Boolean success;

	// Mensaje del proceso.
	private String message;

	// Tiempo de duración del proceso.
	private Double durationProcess;

	// Ruta de la imagen generada.
	private String path;

	
	// -- Get / Set
	public Boolean getSuccess()
	{
		return success;
	}

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Double getDurationProcess()
	{
		return durationProcess;
	}

	public void setDurationProcess(Double durationProcess)
	{
		this.durationProcess = durationProcess;
	}

	public Long getCode()
	{
		return code;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public void setCode(Long code)
	{
		this.code = code;
	}

	public void generatingMappingSatisfactory(Long code, long starTime, long endTime, String message, String pathImage)
	{
		this.code = code;
		this.durationProcess = (endTime - starTime) / 1000000000.0;
		this.message = message;
		this.success = true;
		this.path = (pathImage != null) ? pathImage : "---";
	}

	/**
	 * Método que genera un mapeao automatico cuando se produce un error como
	 * respuesta de una excepción.
	 * 
	 * @param e
	 *            : Es la excepción generada.
	 */
	public void generatingMappingErrors(Exception e)
	{
		this.success = false;
		this.durationProcess = 0.0;
		this.message = e.getMessage();
	}

	public String getReport()
	{
		StringBuilder report = new StringBuilder();

		report.append("Proceso exitoso -> ").append(this.success).append(", code: ").append(this.code)
				.append(", duración: ").append(this.durationProcess).append(", mensaje: ").append(this.message)
				.append(", ruta: ").append(this.path);

		return report.toString();
	}

}
