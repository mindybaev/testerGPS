package tester_G320;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import kz.dev04.MessageGPSLock;
import kz.dev04.util.HexHelper;
 
public class Main implements ActionListener {
 
   public Main() {
      initComponents();
   }
 
   private JFrame viewForm;
  
   private void initComponents() {
	   
	   
      viewForm = new JFrame("Тестер замков GPS");
      viewForm.setSize(400, 500);
      viewForm.setLocationRelativeTo(null); 
      viewForm.setVisible(true);
      viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      viewForm.getContentPane().setLayout(null);
      
//////JLabels////////////////////////////////////////////////////////////   
      JLabel IDLabel = new JLabel("ID");
      IDLabel.setLocation(10, 3);
      IDLabel.setSize(70, 30);
      IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
      IDLabel.setForeground(Color.BLUE);
      
      JLabel blueLabel = new JLabel("Latitude");
      blueLabel.setLocation(10, 37);
      blueLabel.setSize(70, 30);
      blueLabel.setHorizontalAlignment(SwingConstants.LEFT);
      blueLabel.setForeground(Color.BLUE);

      
      JLabel longLabel = new JLabel("Longitude ");
      longLabel.setLocation(10, 72);
      longLabel.setSize(70, 30);
      longLabel.setHorizontalAlignment(SwingConstants.LEFT);
      longLabel.setForeground(Color.BLUE);
      
      JLabel altLabel = new JLabel("ALT ");
      altLabel.setLocation(10, 107);
      altLabel.setSize(70, 30);
      altLabel.setHorizontalAlignment(SwingConstants.LEFT);
      altLabel.setForeground(Color.BLUE);
      
      JLabel spdLabel = new JLabel("Speed");
      spdLabel.setLocation(10, 142);
      spdLabel.setSize(70, 30);
      spdLabel.setHorizontalAlignment(SwingConstants.LEFT);
      spdLabel.setForeground(Color.BLUE);
      
      JLabel dirLabel = new JLabel("Direction");
      dirLabel.setLocation(10, 178);
      dirLabel.setSize(70, 30);
      dirLabel.setHorizontalAlignment(SwingConstants.LEFT);
      dirLabel.setForeground(Color.BLUE);
      
      JLabel timeLabel = new JLabel("Time");
      timeLabel.setLocation(10, 215);
      timeLabel.setSize(70, 30);
      timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
      timeLabel.setForeground(Color.BLUE);     
      
      JLabel batLabel = new JLabel("Buttery");
      batLabel.setLocation(10, 250);
      batLabel.setSize(70, 30);
      batLabel.setHorizontalAlignment(SwingConstants.LEFT);
      batLabel.setForeground(Color.BLUE);
            
      JLabel repLabel = new JLabel("ReportReason");
      repLabel.setLocation(10, 280);
      repLabel.setSize(70, 30);
      repLabel.setHorizontalAlignment(0);
      repLabel.setForeground(Color.BLUE);   
      
      JLabel lblTop = new JLabel("______________________________________________________");
      lblTop.setLocation(1, 290);
      lblTop.setSize(380, 50);
      lblTop.setHorizontalAlignment(0);
      lblTop.setForeground(Color.BLUE); 
      
      JLabel lblBot = new JLabel("______________________________________________________");
      lblBot.setLocation(1, 355);
      lblBot.setSize(380, 50);
      lblBot.setHorizontalAlignment(0);
      lblBot.setForeground(Color.BLUE); 
      
////////JTextField////////////////////////////////////////////////////////
      JTextField repID = new JTextField("074052124482", 12);
      repID.setVisible(true);
      repID.setLocation(82, 8);
      repID.setSize(150, 25);
      
      JTextField latField = new JTextField("42884092", 8);
      latField.setVisible(true);
      latField.setLocation(82, 40);
      latField.setSize(150, 25);
      
      JTextField longField = new JTextField("73159040", 8);
      longField.setVisible(true);
      longField.setLocation(82, 75);
      longField.setSize(150, 25);
      
      JTextField altField = new JTextField("0", 1);
      altField.setVisible(true);
      altField.setLocation(82, 110);
      altField.setSize(150, 25);
      
      JTextField spdField = new JTextField("873", 3);
      spdField.setVisible(true);
      spdField.setLocation(82, 145);
      spdField.setSize(150, 25);      
      
      JTextField dirField = new JTextField("53", 3);
      dirField.setVisible(true);
      dirField.setLocation(82, 181);
      dirField.setSize(150, 25);  
      
      JTextField timeField = new JTextField("211109190550", 12);
      timeField.setVisible(true);
      timeField.setLocation(82, 218);
      timeField.setSize(150, 25);   
      
      JTextField butField = new JTextField("396", 3);
      butField.setVisible(true);
      butField.setLocation(82, 253);
      butField.setSize(150, 25);        
      
      JTextField repField = new JTextField("0", 2);
      repField.setVisible(true);
      repField.setLocation(82, 283);
      repField.setSize(150, 25);      

////////JCheckBox///////////////////////////////////////////////////////////////
      JCheckBox cbMove = new JCheckBox("В движении",true);  
      cbMove.setBounds(255,6, 50,50);  
      cbMove.setVisible(true);
      cbMove.setSize(150, 25);
      
      JCheckBox cbGPS= new JCheckBox("GPS",true);  
      cbGPS.setBounds(255,35, 50,50);  
      cbGPS.setVisible(true);
      cbGPS.setSize(150, 25);
      
     
//////JButton///////////////////////////////////////////////////////////////////
      JButton button = new JButton("Отправить");
      button.setVisible(true);
      button.setLocation(100, 400);
      button.setSize(165, 35);            
      
////////JRadioButton/////////////////////////////////////////////////////////////
      JRadioButton rbClose=new JRadioButton("Close",true);    
      rbClose.setActionCommand("1");
      rbClose.setBounds(5,325,100,30); 
      
      JRadioButton rbOpen=new JRadioButton("Open"); 
      rbOpen.setBounds(5,350,100,30);  
      rbOpen.setActionCommand("0");
      
      ButtonGroup bgOpenClose=new ButtonGroup();    
      bgOpenClose.add(rbClose);bgOpenClose.add(rbOpen);    

      JRadioButton rbSeal=new JRadioButton("Seal",true); 
      rbSeal.setActionCommand("1");
      rbSeal.setBounds(105,325,100,30);    
      
      JRadioButton rbUnseal=new JRadioButton("Unseal");   
      rbUnseal.setActionCommand("0");
      rbUnseal.setBounds(105,350,100,30);  
      
      ButtonGroup bgSealUnseal=new ButtonGroup();    
      bgSealUnseal.add(rbSeal);bgSealUnseal.add(rbUnseal);
      
      JRadioButton rbTearN=new JRadioButton("Normal",true); 
      rbTearN.setActionCommand("0");
      rbTearN.setBounds(205,325,100,30); 
      
      JRadioButton rbTearDown=new JRadioButton("Teardown");   
      rbTearDown.setActionCommand("1");  
      rbTearDown.setBounds(205,350,100,30);  
      
      ButtonGroup bgTear=new ButtonGroup();    
      bgTear.add(rbTearN);bgTear.add(rbTearDown);
      
      ////////////////////////////////
      viewForm.getContentPane().add(blueLabel);
      viewForm.getContentPane().add(latField);
      viewForm.getContentPane().add(button);
      viewForm.getContentPane().add(longLabel);
      viewForm.getContentPane().add(longField); 
      viewForm.getContentPane().add(altLabel); 
      viewForm.getContentPane().add(altField); 
      viewForm.getContentPane().add(spdLabel); 
      viewForm.getContentPane().add(spdField); 
      viewForm.getContentPane().add(dirLabel); 
      viewForm.getContentPane().add(dirField); 
      viewForm.getContentPane().add(timeLabel); 
      viewForm.getContentPane().add(timeField); 
      viewForm.getContentPane().add(cbMove); 
      viewForm.getContentPane().add(cbGPS); 
      viewForm.getContentPane().add(batLabel); 
      viewForm.getContentPane().add(butField);     
      viewForm.getContentPane().add(repLabel); 
      viewForm.getContentPane().add(repField); 
      viewForm.getContentPane().add(rbClose); 
      viewForm.getContentPane().add(rbOpen); 
      viewForm.getContentPane().add(rbSeal); 
      viewForm.getContentPane().add(rbUnseal);  
      viewForm.getContentPane().add(rbTearN); 
      viewForm.getContentPane().add(rbTearDown); 
      viewForm.getContentPane().add(repID); 
      viewForm.getContentPane().add(IDLabel);     
      viewForm.getContentPane().add(lblTop);    
      viewForm.getContentPane().add(lblBot);
      viewForm.getContentPane().add(new JLabel());
      
      

      button.addActionListener(new ActionListener() {  
         public void actionPerformed(ActionEvent e) {
        	if (timeField.getText().length()>12 ) {
        		warningMsg("��������� ����� ���� Time");
        		return;
        	}
        	 byte[] msgByte = generationMsg(
        		 repID.getText(),
        	     cbMove.isSelected(),
        	     cbGPS.isSelected(),
        	     latField.getText(),
        	     longField.getText(),
       			 altField.getText(),
       			 spdField.getText(),
       			 dirField.getText(),
       			 timeField.getText(),
       			 bgOpenClose.getSelection().getActionCommand(),
       			 bgSealUnseal.getSelection().getActionCommand(),
       			 butField.getText(),
       			 bgTear.getSelection().getActionCommand(),
       			 repField.getText());
        	 System.out.println(HexHelper.Byte2HexStr(msgByte));
        	try {       		
        	 Socket socket = new Socket("127.0.0.1", 6666);
     		 OutputStream outputStream = socket.getOutputStream();     		
     		 outputStream.write(msgByte);
     		 socket.close();
                }catch (IOException e1) {
            	 warningMsg(e1.getMessage());
		         }
             }        
 
      });

      
   }
   
    void warningMsg(String theMessage) {
	   JOptionPane.showMessageDialog(null,
			    theMessage,
			    "Внимание",
			    JOptionPane.WARNING_MESSAGE);

	  }
 
   public void actionPerformed(ActionEvent action) {
   }
 
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Main();
         }
      });
   }
   

   public static byte[] generationMsg(String terminalId,
			boolean _vibr, 
			boolean _gps, 
			String lat, 
			String lon, 
			String alt, 
			String speed, 
			String dir,
			String date,
			String open,
			String sealed,
			String bat,
			String tearDown,
			String reason) {
		
		MessageGPSLock messageGPSLock = new MessageGPSLock();
		
		// String body = "0000000000000003028E5BFC045C518000000369003521110919055033362A4D30302C34352C31313339363030393030323335393426303030303030303030303030263132333435363738393031323334353623";
				
		ByteBuffer bbBody = ByteBuffer.allocate(84);
			
		bbBody.putInt(0);
		
		int vibr = _vibr?1:0;
		int gps = _gps?1:0;
				
		bbBody.putInt(vibr | (gps << 1)); //
		
		bbBody.putInt(Integer.parseInt(lat)); // lat  42884092
		bbBody.putInt(Integer.parseInt(lon)); // lon  73159040
		
		bbBody.putShort((short) Short.parseShort(alt));  // alt
		bbBody.putShort((short) Short.parseShort(speed)); // speed 873
		bbBody.putShort((short) Short.parseShort(dir)); // dir 53
		
		
		bbBody.put(new BigInteger(date, 16).toByteArray()); // "211109190550"
		
		//System.out.println(HexHelper.Byte2HexStr(new BigInteger("211109190550", 16).toByteArray()));
				
		//bbBody.put(HexHelper.hexStringToByteArray("33362A4D30302C34352C31313339363030393030323335393426303030303030303030303030263132333435363738393031323334353623"));
		
		
		bbBody.put((byte) 51);
		bbBody.put((byte) 54);
		
		//System.out.println(HexHelper.Byte2HexStr(bbBody.array()));
		
		//String s = "*M00,45,113960090023594&000000000000&1234567890123456#";
		
		String s = String.format("*M00,45,%s%s%s%s%s90023594&000000000000&1234567890123456#", open,sealed,bat,tearDown,reason);
		
		bbBody.put(s.getBytes(StandardCharsets.US_ASCII));
		
		
		return messageGPSLock.generateSendingMessage((short) 0, bbBody.array(), (short)1, (short)512, terminalId);  // "074052124482"
		
	} 
}