package ia.org.knightstour;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


public class TourWindow {

	public TourWindow(String title) {

//		theBoard = new Board( 8, 8 );
		
		initWindow(title);
		
	}
	
	private void initWindow(String title) {
		
		frame = new JFrame(title);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground( Color.WHITE);
		//frame.setSize( 700, 600);
		frame.addWindowListener(new ExitListener() {
			
		});
		mainContent = new JPanel(new BorderLayout() );
		
		frame.getContentPane().add( mainContent );
		
		
		addMenuBar();
		
		JTabbedPane views = new JTabbedPane();
		boardPanel = new JPanel();
//		boardPanel.add( theBoard.display() );
		boardPanel.setPreferredSize( new Dimension(600, 600));
		
		logPanel = new JPanel();
		logPanel.setPreferredSize( new Dimension(600, 600));
		
		
		logger = new JTextArea(35, 50);
		logger.setEditable(false);
		logger.setPreferredSize( new Dimension(600, 600));
		
		JScrollPane scrollLog = new JScrollPane(logger);
		scrollLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		logPanel.add( scrollLog );
		
		views.addTab("The Board", boardPanel);
		views.addTab("Log", logPanel);
		mainContent.add( views, BorderLayout.NORTH );
		
		JPanel options = new JPanel( new BorderLayout() );
		mainContent.add( options, BorderLayout.SOUTH );
		
		JPanel allOptions = new JPanel( new GridLayout( 3, 2 ) );
		JPanel runOptions = new JPanel();
		runOptions.setLayout( new BoxLayout( runOptions, BoxLayout.Y_AXIS));
		options.add(allOptions, BorderLayout.WEST );
		options.add( runOptions, BorderLayout.EAST );
		
		//Board size
		boardWidthLabel = new JLabel("Board width:");
		boardWidth = new JComboBox();
		boardWidth.setEditable(true);
		boardHeightLabel = new JLabel("Board height:");
		boardHeight = new JComboBox();
		boardHeight.setEditable(true);
//		boardWidth.setPreferredSize(new Dimension( 120, 22));
//		boardHeight.setPreferredSize(new Dimension( 120, 22));
		boardWidth.setSelectedItem( "8" );
		boardHeight.setSelectedItem( "8" );
		
		algoType = new JComboBox(algorithms);
		algoTypeLabel = new JLabel("Algorithm Type:");
		
		allOptions.add( boardWidthLabel );
		allOptions.add( boardWidth);
		allOptions.add( boardHeightLabel );
		allOptions.add( boardHeight );
		allOptions.add( algoTypeLabel );
		allOptions.add( algoType );
		allOptions.add(new JLabel());
		allOptions.add(new JLabel());
		
		
		//Starting squares
		startingSquareXLabel = new JLabel("Starting X");
		startingSquareX = new JComboBox();
		startingSquareX.setEditable(true);
		startingSquareYLabel = new JLabel("Starting Y");
		startingSquareY = new JComboBox();
		startingSquareY.setEditable(true);
		startingSquareX.setSelectedItem("0");
		startingSquareY.setSelectedItem("0");
//		startingSquareX.setPreferredSize( new Dimension( 120, 22));
//		startingSquareY.setPreferredSize( new Dimension( 120, 22));
		allOptions.add(startingSquareXLabel);
		allOptions.add(startingSquareX);
		allOptions.add(startingSquareYLabel);
		allOptions.add(startingSquareY);
		
		runIt = new JButton("Run this bitch");
		runIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer x = new Integer( (String) startingSquareX.getSelectedItem() );
					Integer y = new Integer( (String) startingSquareY.getSelectedItem() );
					
					Integer width = new Integer( (String) boardWidth.getSelectedItem() );
					Integer height = new Integer( (String) boardHeight.getSelectedItem() );
					theBoard = new Board( width, height );
					boardPanel.removeAll();
					boardPanel.add(theBoard.display());
//					System.out.println("x y " + width + " " + height );
					theTour = new Tour( theBoard, x.intValue(), y.intValue() );
					
					currentAlgo = (String) algoType.getSelectedItem();
					
					theTour.setCurrentAlgo(currentAlgo);
					
					killIt.setEnabled(true);
					
					theTour.start();
					logger.append("starting..\n");
					
					boardPanel.revalidate();
				}
				catch (NullPointerException npe ) {
					logger.append(" er? ");
				}
				catch (NumberFormatException ex) {
					logger.append("Use valid ints");
				}
			}
		});
		killIt = new JButton("Kill");
		killIt.setEnabled(false);
		killIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				try {
					theTour.stop();
					logger.append("stopped\n");
				}
				catch( Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		runOptions.add( runIt );
		runOptions.add( killIt );
		
		
		frame.pack();
		frame.setVisible(true );
		
		
		
		
	}
	
	public void addToTabs( JComponent comp ) {
		
		boardPanel.add( comp );
	}
	
	private void addMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		exitItem.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.setJMenuBar(menuBar);
		
		
	}
	
	public static void log(String s) {
		
		logger.append(s + "\n");
	}
	
	public static void logg(String s ) {
		logger.append(s);
	}
	
	public String getCurrentAlgo() {
		
		
		return currentAlgo;
	}
	
	
	public class ExitListener extends WindowAdapter {
		  public void windowClosing(WindowEvent event) {
		    System.exit(0);
		  }
		}

	JComboBox boardWidth;
	JComboBox boardHeight;
	JLabel boardWidthLabel;
	JLabel boardHeightLabel;
	
	JComboBox startingSquareX;
	JComboBox startingSquareY;
	JLabel startingSquareXLabel;
	JLabel startingSquareYLabel;
	
	JComboBox algoType;
	JLabel algoTypeLabel;
	
	JFrame frame;
	JPanel mainContent;
	JPanel boardPanel;
	JPanel logPanel;
	
	static JTextArea logger;
	
	JButton runIt;
	JButton killIt;
	
	Board 	theBoard;
	Tour	theTour;
	
	String[] algorithms = {theTour.BRUTE_FORCE, theTour.WARNSDORFF};
	
	public String currentAlgo = "";
	
}
