package bubba.cctutorial.tiles;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.ILuaContext;
import dan200.computer.api.IPeripheral;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityExample extends TileEntity implements IPeripheral {
	
	private World theWorld;
	
	public TileEntityExample(World world) {
		theWorld = world;
	}

	@Override
	public String getType() {
		return "Example_Peripheral";
	}

	@Override
	public String[] getMethodNames() {
		return new String[] {"createExplosion"};
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, ILuaContext context,
			int method, Object[] arguments) throws Exception {
		switch(method) {
		case 0: {
			double explosionX = ((Number) arguments[0]).doubleValue();
			double explosionY = ((Number) arguments[1]).doubleValue();
			double explosionZ = ((Number) arguments[2]).doubleValue();
			float explosionSize = ((Number) arguments[3]).floatValue();
			EntityCreeper exploder = new EntityCreeper(theWorld);
			theWorld.createExplosion(exploder, explosionX, explosionY, explosionZ, explosionSize, true);
			exploder.setDead();
			return new Object[] {true};
		} default:
			return null;
		}
	}

	@Override
	public boolean canAttachToSide(int side) {
		return true;
	}

	@Override
	public void attach(IComputerAccess computer) {}

	@Override
	public void detach(IComputerAccess computer) {}

}