package support;

/**
 * Class for converting between ASCII and Unicode
 * 
 * @author Charles Cao (CSR)
 *
 */
public final class ASCII
{

	/**
	 * @param str
	 *            the input String, must not contains any non-ASCII character
	 * @return ASCII string, as an array of bytes represented ASCII values of the
	 *         input string. Notice that '\0' was added by this method
	 */
	public static byte[] stringToBytes(String str)
	{
		char[] arrChar = str.toCharArray();
		byte[] ret = new byte[arrChar.length + 1];
		for (int i = 0; i < arrChar.length; i++)
		{
			ret[i] = (byte) arrChar[i];
		}
		ret[arrChar.length] = '\0';
		return ret;
	}

	/**
	 * @param bytes
	 *            ASCII string, as an input array of bytes represented ASCII values
	 *            of the input string
	 * @return array of characters represented the input ASCII string
	 */
	public static char[] bytesToCharArray(byte[] bytes)
	{
		char[] arrChar = new char[bytes.length];
		for (int i = 0; i < arrChar.length; i++)
		{
			arrChar[i] = (char) bytes[i];
		}
		return arrChar;
	}

	/**
	 * @param bytes
	 *            ASCII string, as an input array of bytes represented ASCII values
	 *            of the input string
	 * @return Unicode string in Java
	 */
	public static String bytesToString(byte[] bytes)
	{
		return String.valueOf(bytesToCharArray(bytes));
	}

}
