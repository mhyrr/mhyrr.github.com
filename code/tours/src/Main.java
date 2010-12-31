package ia.org.knightstour;
import javax.swing.UIManager;


public class Main {

	public static void setNativeLookAndFeel() {
	    try {
	      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch(Exception e) {
	      System.out.println("Error setting native LAF: " + e);
	    }
	  }
	
	public static void main(String[] args) {
		
		debug("Starting up");
		setNativeLookAndFeel();
		
		TourWindow t = new TourWindow(appName);
		
		
	}
	
	public static void debug( String s ) {
		
		if( debug )
			System.out.println( s );
	}
	
	private static boolean debug = false;
	
	public static String appName = "Knights Tour Recursion";
	
	
}
