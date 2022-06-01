package testerGPS;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import kz.dev04.MessageGPSLock;

public class MainShell extends Shell {
	private Text idField;
	private Text latField;
	private Text longField;
	private Text altField;
	private Text spdField;
	private Text dirField;
	private Text timeField;
	private Text butField;
	private Text repField;

	/**
	 * Launch the application.
	 * @param args
	 */
	String strOpen = "1";
	String strSealed = "1";
	String strTear = "1";
	private Text ipField;
	private Text portField;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MainShell shell = new MainShell(display);
			shell.setLocation(700, 200);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the shell.
	 * @param display
	 */
	public MainShell(Display display) {
		super(display, SWT.DIALOG_TRIM);
		
		Label idLabel = new Label(this, SWT.NONE);
		idLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		idLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TEXT_DISABLED_BACKGROUND));
		idLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		idLabel.setBounds(115, 33, 26, 31);
		idLabel.setText("ID:");
		
		Label latLabel = new Label(this, SWT.NONE);
		latLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		latLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		latLabel.setBounds(75, 70, 66, 19);
		latLabel.setText("Latitude:");
		
		Label longLabel = new Label(this, SWT.NONE);
		longLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		longLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		longLabel.setBounds(56, 106, 85, 29);
		longLabel.setText("Longitude:");
		
		Label altLabel = new Label(this, SWT.NONE);
		altLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		altLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		altLabel.setBounds(104, 141, 36, 32);
		altLabel.setText("ALT:");
		
		Label spdLabel = new Label(this, SWT.NONE);
		spdLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		spdLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		spdLabel.setBounds(86, 179, 55, 25);
		spdLabel.setText("Speed:");
		
		Label dirLabel = new Label(this, SWT.NONE);
		dirLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		dirLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		dirLabel.setBounds(66, 218, 75, 19);
		dirLabel.setText("Direction:");
		
		Label timeLabel = new Label(this, SWT.NONE);
		timeLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		timeLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		timeLabel.setBounds(95, 258, 45, 25);
		timeLabel.setText("Time:");
		
		Label batLabel = new Label(this, SWT.NONE);
		batLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		batLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		batLabel.setBounds(75, 297, 66, 25);
		batLabel.setText("Buttery:");
		
		Label repLabel = new Label(this, SWT.NONE);
		repLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		repLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		repLabel.setBounds(22, 332, 119, 25);
		repLabel.setText("Report Reason:");
		
		idField = new Text(this, SWT.BORDER);
		idField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		idField.setText("123456789012");
		idField.setBounds(147, 30, 127, 21);
		
		latField = new Text(this, SWT.BORDER);
		latField.setText("42884092");
		latField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		latField.setBounds(147, 67, 127, 21);
		
		longField = new Text(this, SWT.BORDER);
		longField.setText("73159040");
		longField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		longField.setBounds(146, 103, 127, 21);
		
		altField = new Text(this, SWT.BORDER);
		altField.setText("0");
		altField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		altField.setBounds(146, 138, 127, 21);
		
		spdField = new Text(this, SWT.BORDER);
		spdField.setText("873");
		spdField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		spdField.setBounds(146, 176, 127, 21);
		
		dirField = new Text(this, SWT.BORDER);
		dirField.setText("53");
		dirField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		dirField.setBounds(146, 215, 127, 21);
		
		timeField = new Text(this, SWT.BORDER);		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String text = date.format(formatter);
		timeField.setText(text);
		timeField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		timeField.setBounds(146, 255, 127, 21);
		
		butField = new Text(this, SWT.BORDER);
		butField.setText("396");
		butField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		butField.setBounds(146, 294, 127, 21);
		
		repField = new Text(this, SWT.BORDER);
		repField.setText("0");
		repField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		repField.setBounds(146, 329, 127, 21);
		
		Button button = new Button(this, SWT.NONE);		
		button.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		button.setBounds(293, 382, 141, 31);
		button.setText("Отправить");
		
		Button cbMove = new Button(this, SWT.CHECK);
		cbMove.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		cbMove.setSelection(true);
		cbMove.setBounds(293, 35, 116, 19);
		cbMove.setText("В движении");
		
		Button cbGPS = new Button(this, SWT.CHECK);
		cbGPS.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		cbGPS.setSelection(true);
		cbGPS.setBounds(293, 70, 93, 16);
		cbGPS.setText("GPS");
		
		Label hSpr = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		hSpr.setBounds(10, 363, 418, 2);
		
		Group grpOpenClose = new Group(this, SWT.NONE);
		grpOpenClose.setBounds(293, 103, 133, 62);
		
		Button rbOpen = new Button(grpOpenClose, SWT.RADIO);
		rbOpen.setBounds(70, 29, 50, 16);
		rbOpen.setText("Open");
		
		Button rbClose = new Button(grpOpenClose, SWT.RADIO);
		rbClose.setSelection(true);
		rbClose.setBounds(10, 29, 50, 16);
		rbClose.setText("Close");
		
		Group grpSealunseal = new Group(this, SWT.NONE);
		grpSealunseal.setBounds(293, 176, 133, 62);
		
		Button rbSeal = new Button(grpSealunseal, SWT.RADIO);
		rbSeal.setSelection(true);
		rbSeal.setBounds(10, 25, 42, 16);
		rbSeal.setText("Seal");
		
		Button rbUnseal = new Button(grpSealunseal, SWT.RADIO);
		rbUnseal.setBounds(70, 25, 53, 16);
		rbUnseal.setText("Unseal");		
		
		Group group = new Group(this, SWT.NONE);
		group.setBounds(295, 255, 133, 62);
		
		Button rbTearN = new Button(group, SWT.RADIO);
		rbTearN.setSelection(true);
		rbTearN.setBounds(25, 14, 61, 16);
		rbTearN.setText("Normal");
		
		Button rbTearDown = new Button(group, SWT.RADIO);
		rbTearDown.setBounds(25, 36, 72, 16);
		rbTearDown.setText("Teardown");
		
		Label lblIpAdress = new Label(this, SWT.NONE);
		lblIpAdress.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblIpAdress.setBounds(10, 387, 75, 19);
		lblIpAdress.setText("IP adress:");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel.setBounds(187, 385, 36, 31);
		lblNewLabel.setText("Port:");
		
		ipField = new Text(this, SWT.BORDER);
		ipField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		ipField.setText("192.168.1.104");
		ipField.setBounds(75, 384, 107, 21);
		
		portField = new Text(this, SWT.BORDER);
		portField.setText("10004");
		portField.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		portField.setBounds(226, 384, 55, 21);

		createContents();
		
		rbClose.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strOpen = "1";
                }
            }
        });
		
		rbOpen.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strOpen = "0";
                }
            }
        });
		
		
		rbSeal.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strSealed = "1";
                }
            }
        });
		
		rbUnseal.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strSealed = "0";
                }
            }
        });
		
		rbTearN.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strTear = "1";
                }
            }
        });
		
		rbTearDown.addSelectionListener(new SelectionAdapter()  {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                if(source.getSelection())  {
                	strTear = "0";
                }
            }
        });		
		
		//

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	         	if (timeField.getText().length()>12 ) {
	         		warningMsg("Превышена длина поля Time");
	         		return;
	         	}
	         	if (ipField.getText().length()<1 ) {
	         		warningMsg("Некорректный IP адрес");
	         		return;
	         	}
	         	if ((portField.getText().length()<1) | (portField.getText().equals("0")) | (Integer.valueOf(portField.getText())>65535) ){
	         		warningMsg("Некорректный порт");
	         		return;
	         	}
	         	 byte[] msgByte = generationMsg(
	         		 idField.getText(),
	         	     cbMove.getSelection(),
	         	     cbGPS.getSelection(),
	         	     latField.getText(),
	         	     longField.getText(),
	        		 altField.getText(),
	        		 spdField.getText(),
	        		 dirField.getText(),
	        		 timeField.getText(),
	        		 strOpen,
	        		 strSealed,
	        		 butField.getText(),
	        		 strTear,
	        		 repField.getText());
	         //	 System.out.println(HexHelper.Byte2HexStr(msgByte));
	         	try {   
	         	 log("Connect");	
	         	 Socket socket = new Socket(ipField.getText(), Integer.valueOf(portField.getText()));
	         	 socket.getSoTimeout();
	      		 OutputStream outputStream = socket.getOutputStream();     		
	      		 outputStream.write(msgByte);
	      	     log("Data sended");
	      	     //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       //	     String fromServer = in.readLine();
	      		 Thread.sleep(3000);
	      		 socket.close();
	      		 log("Disconnect");
	                 }catch (IOException e1) {
	             	 warningMsg(e1.getMessage());
	 		         } catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}     
		});
		
	}
	
	void log(String log){
  		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - ");
		String text = date.format(formatter);
  		System.out.println(text+log);		
	}


	protected byte[] generationMsg(String terminalId,
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

	/**
	 * Create contents of the shell.
	 */
	
	protected void createContents() {
		setText("Тестер замков GPS");
		setSize(458, 479);
	}
	
    void warningMsg(String theMessage) {
	   JOptionPane.showMessageDialog(null,
			    theMessage,
			    "Внимание",
			    JOptionPane.WARNING_MESSAGE);

	  }
    

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
