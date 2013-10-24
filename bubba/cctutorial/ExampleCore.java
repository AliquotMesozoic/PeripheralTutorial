package bubba.cctutorial;

import bubba.cctutorial.blocks.BlockExample;
import bubba.cctutorial.tiles.TileEntityExample;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="bubba.cctutorial", dependencies="required-after:ComputerCraft;after:CCTurtle")

public class ExampleCore {
	public BlockExample blockInstance = new BlockExample(496, Material.ground);
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		blockInstance.setCreativeTab(CreativeTabs.tabMisc);
		GameRegistry.registerBlock(blockInstance, "bubba.cctutorial.block.example");
		GameRegistry.registerTileEntity(TileEntityExample.class, "bubba.cctutorial.tile.example");
		LanguageRegistry.addName(blockInstance, "Example Peripheral");
	}
}
