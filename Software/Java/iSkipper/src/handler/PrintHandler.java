/**
 * 
 */
package handler;

import device.ReceivedPacketEvent;
import support.ASCII;

/**
 * @author CSR
 *
 */
public class PrintHandler implements ReceivedPacketHandlerInterface
{

	@Override
	public void onReceivedPacketEvent(ReceivedPacketEvent packetEvent)
	{
		System.out.print(ASCII.bytesToString(packetEvent.getReceivedData()));
	}

}
