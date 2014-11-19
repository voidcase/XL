package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLMenuBar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Sheet;

public class XL extends JFrame implements Printable {
	private static final int ROWS = 10, COLUMNS = 8;
	private XLCounter counter;
	private StatusLabel statusLabel;
	private CurrentLabel currentLabel;
	private XLList xlList;
	private Sheet sheet;
	private Controller controller;

	public XL(XL oldXL) {
		this(oldXL.xlList, oldXL.counter);
	}

	public XL(XLList xlList, XLCounter counter) {
		super("Untitled-" + counter);
		this.xlList = xlList;
		xlList.add(this);
		this.counter = counter;
		counter.increment();
		sheet = new Sheet();
		controller = new Controller(sheet);
		SheetPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, controller);
		
		statusLabel = new StatusLabel();
		controller.addObserver(statusLabel);
		currentLabel = new CurrentLabel();
		controller.addObserver(currentLabel);
		JPanel statusPanel = new StatusPanel(statusLabel, currentLabel);
		Editor editor = new Editor(controller);
		controller.addObserver(editor);

	
		controller.addObserver(sheetPanel);
		for(Observer o: sheetPanel.getListObservers()) {
			sheet.addObserver(o);
		}
		System.out.println(controller.getCurrent());
		// TODO: add observers to sheet
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);
		setJMenuBar(new XLMenuBar(this, xlList, statusLabel, controller, sheet)); // kolla
																					// konstruktorn,
																					// f�r
																					// sheet
																					// och
																					// controller
																					// skickas
																					// in?
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		xlList.setChanged();
	}

	public static void main(String[] args) {
		new XL(new XLList(), new XLCounter());
	}
}
