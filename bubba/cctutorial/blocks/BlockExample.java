package bubba.cctutorial.blocks;

import bubba.cctutorial.tiles.TileEntityExample;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {

	public BlockExample(int blockID, Material blockMaterial) {
		super(blockID, blockMaterial);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityExample(world);
	}

}
