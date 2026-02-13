package lambdaexpressions.notificationfiltering;

class Alert {
	String type;
	String message;
	int priority;

	Alert(String type, String message, int priority) {
		this.type=type;
		this.message=message;
		this.priority=priority;
	}
	 @Override
	    public String toString() {
	        return "Alert Type: " + type +
	               ", Priority: " + priority +
	               ", Message: " + message;
	    }
}
