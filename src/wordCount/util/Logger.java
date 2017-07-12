package wordCount.util;


public class Logger {
	
	public static enum DebugLevel{
		CONSTRUCTOR,
		THREAD,
		RESULT,
		DATA_STRUCTURE,
		OUTPUT
	};
	
	private static DebugLevel debuglevel;
	
	public static void setDebugValue(int levelln){
		switch(levelln){
		case 4:debuglevel = DebugLevel.CONSTRUCTOR;
		break;
		case 3:debuglevel = DebugLevel.THREAD;
		break;
		case 2:debuglevel = DebugLevel.RESULT;
		break;
		case 1:debuglevel = DebugLevel.DATA_STRUCTURE;
		break;
		case 0:debuglevel = DebugLevel.OUTPUT;
		break;
		default:
			break;
		
		}
	}
	
	public static void setDebugValue(DebugLevel levelln){
		debuglevel = levelln;
	}
	
	public static void writeMessage(String message,DebugLevel levelln){
		if(levelln == debuglevel){
			System.out.println(message);
		}
	}
	
	public String toString(){
		return "Debug level is "+debuglevel;
	}
}
