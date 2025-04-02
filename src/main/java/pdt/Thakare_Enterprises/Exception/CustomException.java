package pdt.Thakare_Enterprises.Exception;

public class CustomException extends Exception {
	
	private String errorcode;
	
	private String errordescription;

	public CustomException(String errorcode, String errordescription) {
		super();
		this.errorcode = errorcode;
		this.errordescription = errordescription;
	}

	

	
}
