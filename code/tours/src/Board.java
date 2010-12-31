package ia.org.knightstour;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;


public class Board {

	public Board() {
		displayBoard = new JTable();
		
	}
	
	public Board( int width, int height) {
		array = new int[width * height];
		
		displayBoard = new JTable( width, height );
		displayBoard.setShowGrid(true);
		displayBoard.setTableHeader(null);
		setCellSize(new Dimension(40,40));
		displayBoard.setPreferredScrollableViewportSize(new Dimension(600, 600));
		displayBoard.setVisible(true);
		
		
		
		clearBoard();
		
		this.width = width;
		this.height = height;
	}
	
    public void setCellSize(Dimension size) {
        TableColumnModel colModel = displayBoard.getColumnModel();
        
        displayBoard.setRowHeight( (int)size.height );
        for(int i=0; i<colModel.getColumnCount(); i++) {
            colModel.getColumn(i).setPreferredWidth( (int)size.width );
            colModel.getColumn(i).setMinWidth( (int)size.width );
            colModel.getColumn(i).setMaxWidth( (int)size.width );
        }
    }

	
	public void setSize( int width, int height ) {
		
		array = new int[ width*height ];
		displayBoard = new JTable( width, height );
		displayBoard.setVisible(false);
		
		clearBoard();
		
		this.width = width;
		this.height = height;
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void clearBoard() {
		
		for(int i = 0; i < width*height; i++ )
			array[i] = EMPTY;
		
		isFinished = false;
	}
	
	public boolean isCovered() {
		
		for(int i = 0; i < width*height; i++)
			if( array[i] == EMPTY )
				return false;
		
		return true;
		
	}
	
	public boolean isSpaceCovered(int i ) {
		
		if( array[i] == EMPTY)
			return false;
		
		return true;
	}
	
	public void coverSpace( int loc, int val ) { 
		
		if( ! isFinished ) {
			array[loc] = COVERED;
			int row = loc % width;
			int col = loc / height;
			displayBoard.setValueAt(val, row, col);
		}
	}
	
	public void uncoverSpace( int loc ) {
		
		if( ! isFinished ) {
			array[loc] = EMPTY;
			int row = loc % width;
			int col = loc / height;
			displayBoard.setValueAt( 0, row, col );
		}
	}
	
	public boolean isValid( int loc, int lastLoc ) {
		
		if( !( (loc >= 0) && (loc < width*height) ) )  {
			return false;
		}
		else {
			int rowSep = getRowSeparation( loc, lastLoc );
			int colSep = getColSeparation( loc, lastLoc );
			
			//Main.debug( "seps: " + rowSep + " " + colSep);
			if ( ! ( (rowSep == 1 && colSep == 2 ) || (rowSep == 2 && colSep == 1 ) ) )
				return false;
			
			if( isSpaceCovered( loc ) )
				return false;
			
		}
		
		return true;
	}
	
	private int getRowSeparation( int loc, int lastLoc ) {
		
		int locRow = loc % width;
		int lastLocRow = lastLoc % width;
		
		return Math.abs( locRow - lastLocRow );
		
	}
	
	private int getColSeparation( int loc, int lastLoc ) {
		
		int locCol = loc / height;
		int lastLocCol = lastLoc / height;
		
		return Math.abs( locCol - lastLocCol );
		
	}
	
	public JComponent display() {
		
		JScrollPane scrollPane = new JScrollPane(displayBoard);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		displayBoard.setPreferredScrollableViewportSize( new Dimension( 600, 576 ) );
		displayBoard.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		return scrollPane;
		
	}
	
	public void setVisible(boolean viz) {
		
		isFinished = true;
		displayBoard.setVisible(viz);
	}
	private int[] array;
	
	private int width;
	private int height;
	
	private static final int EMPTY = 0;
	private static final int COVERED = 1;
	
	private JTable displayBoard;
	
	private boolean isFinished = false;
	
}
