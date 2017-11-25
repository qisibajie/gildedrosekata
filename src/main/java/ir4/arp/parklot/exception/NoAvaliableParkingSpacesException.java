package ir4.arp.parklot.exception;

public class NoAvaliableParkingSpacesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoAvaliableParkingSpacesException(String strErrMsg) {
		super(strErrMsg);
	}

}
