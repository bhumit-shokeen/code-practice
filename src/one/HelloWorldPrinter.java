package one;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class HelloWorldPrinter implements Printable, ActionListener {

	private String printIt;

	public String getPrintIt() {
		return printIt;
	}

	public void setPrintIt(String printIt) {
		this.printIt = printIt;
	}

	public void fill(Fields fields) {

		printIt = "I, " + fields.getName() + ", S/O " + fields.getFathersName() + " R/O  " + fields.getAddress()
				+ ",      do hereby solemnly  declare as under:-\n" + "\n"
				+ "   1.  That I am citizen of India and presently residing at the above mentioned address.\n"
				+ "   2.  That my nationality is Indian.\n"
				+ "   3.  That the my true and correct Exact date of birth is  " + fields.getDateOfBirth() + "\n"
				+ "   4.  That I have no any documentary proof in support of my above  said declaration.\n"
				+ "   5.  That I take oath and solemnly declare / affirm that the particulars furnished by me above are correct and that I have not concealed or misrepresented any facts.\n"
				+ "   6.  That It is my true and correct  statement.\n\n\n\n" + "\n\n";

		print();
	}

	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		/* Now we perform our rendering */
		// g.drawString(printIt, 100, 100);
		g.drawString("AFFIDAVIT ", 250, 375);

		int x = 50;
		int y = 400;
		int index = 0;
		for (String line : printIt.split("\n")) {
			if (y >= 400 && y <= 448 && line.length() > 88) {
				index = find(line, 88);
				if (index >= 0) {
					g.drawString(line.substring(0, index + 1), x, y += g.getFontMetrics().getHeight());
					g.drawString(line.substring(index + 1), x, y += g.getFontMetrics().getHeight());
				}
			} else if (line.length() > 85) {
				index = find(line, 85);

				if (index >= 0) {
					g.drawString(line.substring(0, index + 1), x, y += g.getFontMetrics().getHeight());
					g.drawString("        " + line.substring(index + 1), x, y += g.getFontMetrics().getHeight());
				}
			} else
				g.drawString(line, x, y += g.getFontMetrics().getHeight());

		}

		g.drawString("	Deponent", 450, y += g.getFontMetrics().getHeight() + 45);
		g.drawString("Verification:-", 50, y += g.getFontMetrics().getHeight());
		g.drawString("   Verified  on this that the contents of this affidavit are true and correct to the  best", x,
				y += g.getFontMetrics().getHeight());
		g.drawString("   of my knowledge and belief and nothing in material has been concealed therefrom.", x,
				y += g.getFontMetrics().getHeight());
		g.drawString("   The contents of this affidavit have been read out to me.", x,
				y += g.getFontMetrics().getHeight());
		g.drawString("	Deponent", 450, y += g.getFontMetrics().getHeight() + 30);

		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	private int find(String line, int index) {
		while (index > 0 && line.charAt(index) != ' ') {
			index--;
		}

		return index;
	}

	public void print() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}
	/*
	 * public static void main(String args[]) { HelloWorldPrinter
	 * helloWorldPrinter = new HelloWorldPrinter(); helloWorldPrinter.print();
	 * 
	 * 
	 * UIManager.put("swing.boldMetal", Boolean.FALSE); JFrame f = new JFrame(
	 * "Hello World Printer"); f.addWindowListener(new WindowAdapter() { public
	 * void windowClosing(WindowEvent e) { System.exit(0); } }); JButton
	 * printButton = new JButton("Print Hello World");
	 * printButton.addActionListener(new HelloWorldPrinter()); f.add("Center",
	 * printButton); f.pack(); f.setVisible(true);
	 * 
	 * }
	 */

}
