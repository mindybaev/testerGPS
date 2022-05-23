package kz.dev04;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kz.dev04.util.HexHelper;


public class MessageGPSLock {
	public static final byte indentifire = 0x7e;
	private static final short swapByte7e = 32002;
	private static final short swapByte7d = 32001;
	//private final byte[] responseMsgID = new byte[] {(byte) 0x80, 0x01};
	public static final short responseMsgID = -32767;
	
	public static final short shortConnection = 16384;
	public static final short longConnection = 0;
	//public byte[] header = new byte[12];
	//public MessageHeader header;
	private byte[] bodyRaw;
	//public MessageBodyGPSLock body;
	public byte verificationCode;
	
	public byte[] rawBytes;
	
	private ByteBuffer rawConvert;
	
	private byte verification(byte[] b) {
		byte v = 0;
		for (int i = 0; i < b.length; i ++) {
			v = (byte) (v ^ b[i]);
		}
		//System.out.println(v);
		return v;
	}

	
	public byte[] generateSendingMessage(short connectionProperty, byte[] messageResponse, short counterResponse, short messageId, String terminalId) {
		ByteBuffer bbResponse = ByteBuffer.allocate(messageResponse.length + 13);
		
		bbResponse.putShort(messageId);
		short msgBodyProp = (short) (connectionProperty | messageResponse.length);
		bbResponse.putShort(msgBodyProp);
		bbResponse.put(HexHelper.hexStringToByteArray(terminalId));
		bbResponse.putShort(counterResponse);
		bbResponse.put(messageResponse);
		bbResponse.put(verification(bbResponse.array()));
		bbResponse.flip();
		
		ByteBuffer bbResponseConvert =  ByteBuffer.allocate(bbResponse.limit()*2);
		int msgLength = 2;
		bbResponseConvert.put(MessageGPSLock.indentifire);
		while (bbResponse.remaining() > 0) {
			byte b = bbResponse.get();
			if (b == 0x7e) {
				bbResponseConvert.putShort(MessageGPSLock.swapByte7e);
				msgLength += 2;
			} else if (b == 0x7d) {
				bbResponseConvert.putShort(MessageGPSLock.swapByte7d);
				msgLength += 2;
			} else {
				bbResponseConvert.put(b);
				msgLength++;
			}
		}
		bbResponseConvert.put(MessageGPSLock.indentifire);
		bbResponseConvert.flip();
				
		return Arrays.copyOf(bbResponseConvert.array(), msgLength);
	}
	
}