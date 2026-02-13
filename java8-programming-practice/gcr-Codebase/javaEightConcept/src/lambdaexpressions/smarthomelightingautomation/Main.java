package lambdaexpressions.smarthomelightingautomation;

public class Main {
	public static void main(String[] args) {
		SmartLightSystem lightSystem = new SmartLightSystem();
		
		LightAction motionDetect = ()->System.out.println("Bright White Light On");
		LightAction nightTime= ()->System.out.println("Dim Light On ");
		LightAction voiceCommand = ()->System.out.println("Lights On by Voice Command ");
		
		lightSystem.activate(motionDetect);
		lightSystem.activate(nightTime);
		lightSystem.activate(voiceCommand);
	}
}
