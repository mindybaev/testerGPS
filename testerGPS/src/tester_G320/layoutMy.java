package testerGPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kz.dev04.util.HexHelper;

public class layoutMy extends JFrame {
	public layoutMy (String title) {
		super(title);
		this.setSize(700,300);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button1 = new JButton("Закрыть");
		JButton button2 = new JButton("Отправить");
		JButton button3 = new JButton("Button3");
		JButton button4 = new JButton("Button4");
		JButton button5 = new JButton("Button5");
		JButton button6 = new JButton("Button6");
		JButton button7 = new JButton("Button7");
		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		mainContainer.setBackground(Color.YELLOW);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.green));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.black,3));
		topPanel.setBackground(Color.orange);
		topPanel.setLayout(new FlowLayout(5));
		topPanel.add(button1);
		topPanel.add(button2);
		topPanel.add(button3);
		topPanel.add(button4);
		mainContainer.add(topPanel,BorderLayout.NORTH);
		
	      button1.addActionListener(new ActionListener() {
	    	  
	          public void actionPerformed(ActionEvent e) {
	        	  // byte[] msgByte =	 generationMsg(
	        	  //		 repID.getText(),
	        	  //  cbMove.isSelected(),
	        	  //   cbGPS.isSelected(),
	        	  //		 bField.getText(),
	        	  //			 LongitudeField.getText(),
	        	  //		 altField.getText(),
	        	  //			 spdField.getText(),
	        	  //		 dirField.getText(),
	        	  //		 timeField.getText(),
	        	  //		 bgOpenClose.getSelection().getActionCommand(),
	        	  //		 bgSealUnseal.getSelection().getActionCommand(),
	        	  //		 butField.getText(),
	        	  //		 bgTear.getSelection().getActionCommand(),
	        	  //		 repField.getText());
	        	  //System.out.println(HexHelper.Byte2HexStr(msgByte));
	        	  System.out.println("SDFSDFSDF");
	          }
	          
	  
	       });
		
		
	}

	public static void main(String[] args) {
		layoutMy myLayout = new layoutMy("Test");
		myLayout.setVisible(true);
	}
	
	
}
