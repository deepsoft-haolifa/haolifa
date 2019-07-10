package com.deepsoft.haolifa.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class Base64 
{
    private static char[] base64EncodeChars = new char[] {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '+', '/' };
 
    private static byte[] base64DecodeChars = new byte[] {
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
    52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
    -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
    -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
 
    private Base64() {}
    
    /**
     * UTF-8����
     * @param s
     * @return
     */
    public static String encode(String s)
    {
    	if(s==null)return null;
    	try 
    	{
			return encodeBytes(s.getBytes("UTF-8"));
		} 
    	catch (UnsupportedEncodingException e) 
    	{
			e.printStackTrace();
		}
    	return null;
    }
    
    public static String decode(String s)
    {
    	if(s==null)return null;
    	try 
    	{
			return new String(decodeBytes(s),"UTF-8");
		} 
    	catch (UnsupportedEncodingException e) 
    	{
			e.printStackTrace();
		}
    	return null;
    }
 
    public static String encodeBytes(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
 
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(
                        base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(
                    base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(
                    base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
 
    public static byte[] decodeBytes(String str) {
        byte[] data = str.getBytes();
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        int i = 0;
        int b1, b2, b3, b4;
 
        while (i < len) {
 
            /* b1 */
            do {
                b1 = base64DecodeChars[data[i++]];
            } while (i < len && b1 == -1);
            if (b1 == -1) {
                break;
            }
 
            /* b2 */
            do {
                b2 = base64DecodeChars[data[i++]];
            } while (i < len && b2 == -1);
            if (b2 == -1) {
                break;
            }
            buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));
 
            /* b3 */
            do {
                b3 = data[i++];
                if (b3 == 61) {
                    return buf.toByteArray();
                }
                b3 = base64DecodeChars[b3];
            } while (i < len && b3 == -1);
            if (b3 == -1) {
                break;
            }
            buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
 
            /* b4 */
            do {
                b4 = data[i++];
                if (b4 == 61) {
                    return buf.toByteArray();
                }
                b4 = base64DecodeChars[b4];
            } while (i < len && b4 == -1);
            if (b4 == -1) {
                break;
            }
            buf.write((int) (((b3 & 0x03) << 6) | b4));
        }
        return buf.toByteArray();
    }
    
    public static void main(String[] args)throws Exception
    {
    	//System.out.println(encode("1#1#1"));//...
    	
    	//System.out.println(encode("2f6f26020b72d12f9455cb7e722b00c0"));//...
    	System.out.println(decode("eyJJbWVpIjoiMDAwMDAwMDAwMCIsIkFwcElkIjoiMTAwMDAwMCIsIk1hYyI6ImI4MTdjMjQ5YWY2NSIsIkF0eXBlIjoxLCJQcml2YXRlRGF0YSI6IjQ1MTQ3NDEiLCJUcmFkZU5vIjoiNDUxNDc0MSJ9"));//
//    	byte[] bs = decodeBytes("R0lGODlhEAAQAPeiAP83Cf9eMP85C9SQkfKajeOUjv6Qb84iC9pwYv8oAIoYIf8/ErpiY/8wBP9rQqUkI/glAPMiAO9AHokdKZ8jIv9qO/hYMvtFHfAiAPlGG/NSLePNzuLOz6waFN5KMP+sjf8rAM3q8v89EP+cepsPDf2GY/8uApULDOZwYeXw9NweAooWIOf2+fZ1Uv4tAuXOzulOL9UZAdc6Iv8sAe74/MEbC8QcCtAhCbsXCuzPzf9OH/9JG/U3D/9fL7ljZOaWjtVsYu4XAOUcAN+UkPf///3//7ApJKIPC/h/Ws8dBuQrCv8xBP9KHOY2FvQbAN7r7v+efP8vBP9rP/9TJf+AWP9sQP8pAP9UJaglItw5Gv9fMfkmAP81CeRvYYAfL/+HYe9CHv9iM6kcGOXNztklDeo7GfhmQOZEJv9rOufOzv9pOf+JZf+JaP8sAP80B/4hAN89I8loYpELDv+KYdAkDa4fF84iDJYOD+RAJPhbNfmFYf9sPPL///86C/8uA/9qOrEcFZsNDP5qQenOzv+ri/98UPhkPvhdOP2IZsFlY/cjANrl6e0gAPBsSI0eKP7//+0eAH8eLv8/E+M1FcIeDuvPzfyKZ9Tv9f9DFMxGM/JTL+AwFP9ZKv8mAJYPD8UfDv+CWv///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH5BAEAAKIALAAAAAAQABAAAAjcAEUJHEiwYMEcKM6UaQIHwSCDogiAsQSFipQAGcj8KEhAA6EvFXpcYSKpj4oCAytJ+FBoj5oAU3YsAGCixhiBXUrMQfMnDCcdmAQ0AHEgjkA8I7Jk8gBDk4U8hwyJsGNE4CRQSi49YcGnSKivDigdEbipCo8Qi1LQIPLoqyAxJATK0CKgUQskehCtYWPAzIQHAoFcAMDFTZQ2nd44CdJBAQOBaegs8eNihhUIGCDZ8OJpw8ACMRJsURSBkRBAkeQMKDgER5Ibn+o4WnFntcEXibAEOkHBBweIwAsGBAA7");
//    	File ff = new File("d:/1.gif");
//    	java.io.FileOutputStream fos = new java.io.FileOutputStream(ff);
//    	fos.write(bs);
//    	fos.flush();
//    	fos.close();
    	
    }
}