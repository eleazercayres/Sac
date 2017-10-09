package com.olx.sac.sacserviceapi.constants;

public enum TypeOfCall {

	TELEFONE("Telefone"),
	CHAT("Chat"),
	EMAIL("E-mail");
	
	private String value;

	TypeOfCall(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static TypeOfCall fromString(String text) {
        for (TypeOfCall b : TypeOfCall.values()) {
          if (b.value.equalsIgnoreCase(text)) {
            return b;
          }
        }
        return null;
     }

}
