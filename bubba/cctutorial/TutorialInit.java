package bubba.cctutorial;

import bubba.cctutorial.block.BlockPeripheral;
import bubba.cctutorial.tile.TileEntityBlockPeripheral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="bubba.cctutorial", dependencies="required-after:ComputerCraft;after:CCTurtle")

@NetworkMod(clientSideRequired=true, serverSideRequired=true)

public class TutorialInit {
	
	Block blockPeripheral = new BlockPeripheral(496,Material.ground);
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEntityBlockPeripheral.class, "blockPeripheralTileEntity.bubba.cctutorial");
		GameRegistry.registerBlock(blockPeripheral, "blockPeripheral.bubba.cctutorial");
		LanguageRegistry.addName(blockPeripheral, "Example Peripheral");
		blockPeripheral.setCreativeTab(CreativeTabs.tabMisc);
	}
}
