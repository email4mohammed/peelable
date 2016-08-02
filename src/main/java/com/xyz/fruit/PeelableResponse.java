package com.xyz.fruit;

public class PeelableResponse {
	
	

	public static enum MessageCode {
		SUCCESS, FAILURE
	}
	private MessageCode messageCode;
	
	private String message;
	
	
	public PeelableResponse(MessageCode messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public String getMessage() {
		return message;
	}


}
