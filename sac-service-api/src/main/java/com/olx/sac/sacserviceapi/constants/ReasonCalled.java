package com.olx.sac.sacserviceapi.constants;

public enum ReasonCalled {
	
	PRAISE("Elogios"),
	DOUBTS("Duvidas"),
	SUGGESTIONS("Sugestoes");
	
	private String value;

	ReasonCalled(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static ReasonCalled fromString(String text) {
        for (ReasonCalled b : ReasonCalled.values()) {
          if (b.value.equalsIgnoreCase(text)) {
            return b;
          }
        }
        return null;
     }

}
