package uta_parking.model;

public class ReservationErrorMsgs {

	private String errorMsg;
	private String parking_typeError;

	private String start_timeError;
	private String durationError;
	private String overlapError;
	private String maxForTheDayError;
	
	public ReservationErrorMsgs(){
	 this.errorMsg = "";
	 this.parking_typeError = "";
	 this.start_timeError = "";
	 this.durationError = "";
	 this.overlapError="";
	 this.maxForTheDayError="";
	}
	
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg() {
		
			if ( !parking_typeError.equals("") || 
				 !start_timeError.equals("") || 
				 !durationError.equals(""))
				
				this.errorMsg="Please correct the following errors";
		
					
	}
	
	
	
	
	public String getParking_typeError() {
		return parking_typeError;
	}
	public void setParking_typeError(String parking_typeError) {
		this.parking_typeError = parking_typeError;
	}
	
	public String getStart_timeError() {
		return start_timeError;
	}
	public void setStart_timeError(String start_timeError) {
		this.start_timeError = start_timeError;
	}
	
	public String getDurationError() {
		return durationError;
	}
	public void setDurationError(String durationError) {
		this.durationError = durationError;
	}

	public String getOverlapError() {
		return overlapError;
	}
	public void setOverlapError(String overlapError) {
		this.overlapError = overlapError;
	}
	public String getMaxForTheDayError() {
		return maxForTheDayError;
	}
	public void setMaxForTheDayError(String maxForTheDayError) {
		this.maxForTheDayError = maxForTheDayError;
	}

}