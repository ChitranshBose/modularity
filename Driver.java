import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
public class Driver extends Menu{
	public static void main(String args[])throws Exception{
		int choice;
		ClockLabel dateLable = new ClockLabel("date");
	    ClockLabel timeLable = new ClockLabel("time");
	    ClockLabel dayLable = new ClockLabel("day");
	 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame f = new JFrame(" ");
	    f.setSize(300,150);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setLayout(new GridLayout(3, 1));
	 
	    f.add(dateLable);
	    f.add(timeLable);
	    f.add(dayLable);
	 
	    f.getContentPane().setBackground(Color.BLACK);
	 
	    f.setVisible(true);
	  
		do{
			Input in=new Input();
			Output out=new Output();
			Sort sort=new Sort();
			Search search=new Search();
			Menu menu=new Menu();
			System.out.println("1-INSERT MODULE\n2-REPORT MODULE\n3-SORTING MODULE\n4-SEARCHING MODULE\n5-HELP\n6-EXIT");
			System.out.println("Enter your choice.");
			choice=sc.nextInt();
			switch(choice){
			case 1:
					in.Insert();
					break;
			case 2:
					out.Report();
					break;
			case 3:
					sort.Sorting();
					break;
			case 4:
					search.searching();
					break;
			case 5:
					menu.Info();
					break;
			case 6:
					System.out.println("Thank you for your time.Exit........");
					System.exit(0);
			default:
					System.out.println("Invalid choice.Try again.");
			}
		}while(choice!=0);
	}
}
class Clk extends JLabel implements ActionListener {
	 
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	String type;
	  SimpleDateFormat sdf;
	 
	  public Clk(String type) {
	    this.type = type;
	    setForeground(Color.WHITE);
	 
	    switch (type) {
	      case "date" : sdf = new SimpleDateFormat("  MMMM dd yyyy");
	                    setFont(new Font("sans-serif", Font.ITALIC, 16));
	                    setHorizontalAlignment(SwingConstants.LEFT);
	                    break;
	      case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
	                    setFont(new Font("sans-serif", Font.ITALIC, 40));
	                    setHorizontalAlignment(SwingConstants.CENTER);
	                    break;
	      case "day"  : sdf = new SimpleDateFormat("EEEE  ");
	                    setFont(new Font("sans-serif", Font.ITALIC, 16));
	                    setHorizontalAlignment(SwingConstants.RIGHT);
	                    break;
	      default     : sdf = new SimpleDateFormat();
	                    break;
	    }
	 
	    Timer t = new Timer(1000, this);
	    t.start();
	  }
	 
	  public void actionPerformed(ActionEvent ae) {
	    Date d = new Date();
	    setText(sdf.format(d));
	  }
	}
