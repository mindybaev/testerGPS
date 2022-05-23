package kz.dev04.util;

public class HexHelper {
	
	 public static String Byte2HexStr(byte buf[]) {   
         StringBuffer sb = new StringBuffer();   
         for (int i = 0; i < buf.length; i++) {   
                 String hex = Integer.toHexString(buf[i] & 0xFF);   
                 if (hex.length() == 1) {   
                         hex = '0' + hex;   
                 }   
                 sb.append(hex.toUpperCase());   
         }   
         return sb.toString();   
	 }   
	 
	 public static String Byte2HexStrInverse(byte buf[]) {   
		 StringBuffer sb = new StringBuffer();   
         for (int i = buf.length - 1; i >= 0 ; i--) {   
                 String hex = Integer.toHexString(buf[i] & 0xFF);   
                 if (hex.length() == 1) {   
                         hex = '0' + hex;   
                 }   
                 sb.append(hex.toUpperCase());   
         }   
         return sb.toString(); 
	 }
	 
	 public static String Byte2HexStr2(byte[] bytes) {   
		 StringBuilder sb = new StringBuilder();
		    for (byte b : bytes) {
		        sb.append(String.format("%02X", b));
		    }   
         return sb.toString();   
	 }
	 
	 public static byte[] hexStringToByteArray(String s) {
	        int len = s.length();
	        byte[] data = new byte[len / 2];
	        for (int i = 0; i < len; i += 2) {
	            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                    + Character.digit(s.charAt(i + 1), 16));
	        }
	        return data;
	  }
	 
	 public static void reverseArray(byte[] _array) {
	        byte tmp;
	        for (int i = 0; i < _array.length / 2; i++) {
	            tmp = _array[i];
	            _array[i] = _array[_array.length - i - 1];
	            _array[_array.length - i - 1] = tmp;
	        }
	    }
}
