package support;

/**
 * The class for storage of iClicker Answer Packet.</br>
 * 
 * Some useful methods (converters between int32 to byte[4], and a method to
 * check the validity of iClicker ID) are also included in this class.
 * 
 * @author CSR
 *
 */
public class AnswerPacket implements Cloneable
{
	private int ID;
	private byte[] arrID;
	private Answer answer;

	/**
	 * The default constructor. Set ID to be 0x00000000 and the answer to P (Ping)
	 */
	public AnswerPacket()
	{
		ID = 0x00_00_00_00;
		arrID = intToByteArray(ID);
		answer = Answer.P;
	}

	/**
	 * @param answer
	 *            the iClicker Answer
	 * @param ID
	 *            the iClicker ID,represented as an int32, must be valid,
	 */
	public AnswerPacket(Answer answer, int ID)
	{
		this();
		if (!isValidID(ID))
		{
			onInvalidID();
			return;
		}
		this.answer = answer;
		this.ID = ID;
		this.arrID = intToByteArray(ID);
	}

	/**
	 * @param answer
	 *            the iClicker Answer
	 * @param arrID
	 *            the iClicker ID,represented as an array of bytes, must be valid
	 */
	public AnswerPacket(Answer answer, byte[] arrID)
	{
		this(answer, byteArrayToInt(arrID));
	}

	/**
	 * @return the iClicker ID in this packet.
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * @param ID
	 *            the ID to set in this packet.
	 */
	public void setID(int ID)
	{
		if (!isValidID(ID))
		{
			onInvalidID();
			return;
		}
		this.ID = ID;
		arrID = intToByteArray(ID);
	}

	/**
	 * @param arrID
	 *            the ID to set in this packet.
	 */
	public void setID(byte[] arrID)
	{
		if (!isValidID(arrID))
		{
			onInvalidID();
			return;
		}
		this.arrID = arrID;
		this.ID = byteArrayToInt(arrID);
	}

	/**
	 * @return the answer in this packet.
	 */
	public Answer getAnswer()
	{
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set in this packet.
	 */
	public void setAnswer(Answer answer)
	{
		this.answer = answer;
	}

	/**
	 * @return the iClicker ID in this packet, represented as an array of bytes.
	 */
	public byte[] getArrID()
	{
		return arrID;
	}

	/**
	 * @param arrID
	 *            the iClicker ID, represented as an array of bytes.
	 * @return if it is a valid iClicker ID
	 */
	public static boolean isValidID(byte[] arrID)
	{
		if (arrID.length < 4)
			return false;
		return ((arrID[0] ^ arrID[1] ^ arrID[2]) == arrID[3]);
	}

	/**
	 * @param arrID
	 *            the iClicker ID, represented as an int32.
	 * @return if it is a valid iClicker ID
	 */
	public static boolean isValidID(int ID)
	{
		return isValidID(intToByteArray(ID));
	}

	/**
	 * The private method that would be invoked when trying to set a invalid ID.
	 */
	private void onInvalidID()
	{
		IllegalArgumentException exception = new IllegalArgumentException("Invalid ID");
		exception.printStackTrace();
	}

	@Override
	public Object clone()
	{
		return new AnswerPacket(this.answer, this.arrID);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !obj.getClass().equals(this.getClass()))
			return false;
		AnswerPacket other = (AnswerPacket) obj;
		return other.ID == this.ID && other.answer.equals(this.answer);
	}

	/**
	 * @return the ID</br>
	 * 
	 *         Since each of the iClicker IDs should be unique in this world, we
	 *         could just directly use it as a hashCode.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return this.ID;
	}

	/**
	 * @param input
	 *            an int32
	 * @return an array of bytes, representing the input int32.(Little Endian)
	 */
	public static byte[] intToByteArray(int input)
	{
		return new byte[]
		{ (byte) (input >> 24 & 0xFF), (byte) (input >> 16 & 0xFF), (byte) (input >> 8 & 0xFF), (byte) (input & 0xFF) };
	}

	/**
	 * @param input
	 *            an array of bytes.
	 * @return an int32, representing the input byte array.(Little Endian)
	 */
	public static int byteArrayToInt(byte[] input)
	{
		try
		{
			return input[3] & 0xFF | (input[2] & 0xFF) << 8 | (input[1] & 0xFF) << 16 | (input[0] & 0xFF) << 24;
		} catch (IndexOutOfBoundsException e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		return -1;
	}
}
