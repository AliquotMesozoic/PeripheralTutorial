package bubba.cctutorial.tile;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.ILuaContext;
import dan200.computer.api.IPeripheral;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBlockPeripheral extends TileEntity implements IPeripheral {
	
	private World world;
	
	public TileEntityBlockPeripheral(World world) {
		this.world = world;
	}
	
	@Override
	public String getType() {
		return "example_peripheral"; //When a computer makes a peripheral.getType call, this string is returned
	}

	@Override
	public String[] getMethodNames() {
		//This method will serve two purposes:
		/* Purpose 1) When a computer makes a peripheral.getMethods call, an unpacked table of these methods is returned
		 * Purpose 2) When the callMethod method (below) is called, it refers to this method to check which method is to be executed. More on this in a bi 
		 */
		return new String[] {"method1", "method2"}; //Give us a few methods to mess around with
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, ILuaContext context,
			int method, Object[] arguments) throws Exception {
		/* There's a lot of stuff going on in this method, so bear with me.
		 * IComputerAccess computer: This allows us to perform a few actions with the computer, including but not limited to getting the computer ID and the mount directory
		 * ILuaContext context: This allows us to do things related to Lua itself. For example, here we can ask the computer to yield or wait until an event is fired.
		 * int method: int method: This integer is the method that is being called. In getMethodNames, we have a list of methods deliniated by a String table. The index of the called method is this integer (if this doesn't make sense right now, we'll be going over it more in depth in a bit).
		 * Object[] arguments: This is a list of all the arguments provided when the computer makes a call to this peripheral.
		 */
		
		switch(method){
		case 0:
			return new Object[] {"You called method1!"};
		case 1:
			return new Object[] {"You called method2"};
		default:
			return new Object[] {"Invalid method alert"};
		}
		
	}

	@Override
	public boolean canAttachToSide(int side) {
		//This one's fairly self explanatory. An integer 0-5 represents a side. Returning a boolean specifies whether we can access the peripheral when it is located on a given side.
		return true; //Make sure you change this to true or you won't be able to attach to the peripheral!
	}

	@Override
	public void attach(IComputerAccess computer) {
		//Whenever a computer is placed next to the peripheral and turned on (or vice-versa), this method is called
		//We'll leave this blank for now.
	}

	@Override
	public void detach(IComputerAccess computer) {
		//Whenever the peripheral is broken or the computer is removed, this method is called
		//We'll leave this blank for now
	}

}
