package bubba.cctutorial.block;

import bubba.cctutorial.tile.TileEntityBlockPeripheral;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockPeripheral extends BlockContainer {

	public BlockPeripheral(int blockID, Material blockMaterial) {
		super(blockID, blockMaterial);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBlockPeripheral(world);
	}

}
