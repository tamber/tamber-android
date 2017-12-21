package com.tamber.exception;

public class TamberException extends Exception {

	private String requestId;

	public TamberException(Throwable e) {
		super(e);
	}

	public TamberException(String message) {
		super(message, null);
	}

	public TamberException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = 1L;

	public String getRequestId() {
		return requestId;
	}


	public String toString() {
		String reqIdStr = "";
		if (requestId != null) {
			reqIdStr = "; request-id: " + requestId;
		}
		return super.toString() + reqIdStr;
	}
}