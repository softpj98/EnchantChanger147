package ak.EnchantChanger;

import ak.EnchantChanger.Client.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public CommonProxy(){}
	public void registerRenderInformation(){}

	public void registerTileEntitySpecialRenderer(){}

	//returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		if(id == EnchantChanger.guiIdMaterializer)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			//return new EcContainerMaterializer(world, player.inventory, (EcTileEntityMaterializer) tileEntity);
			return new EcContainerMaterializer(world, player.inventory);
		}
		else if(id == EnchantChanger.guiIdPortableEnchantmentTable)
		{
			return new EcContainerPortableEnchantment(player.inventory, world, x, y, z);
		}
		else if(id == EnchantChanger.guiIdHugeMateria)
		{
			TileEntity t = world.getBlockTileEntity(x, y, z);
			if(t != null)
				return new EcContainerHugeMateria(player.inventory, (EcTileEntityHugeMateria)t);
			else
			{
//				System.out.println("error");
				return null;
			}
		}
		else
			return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if(id == EnchantChanger.guiIdMaterializer)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			return new EcGuiMaterializer(world, player.inventory);
		}
		else if(id == EnchantChanger.guiIdPortableEnchantmentTable)
		{
			return new EcGuiPortableEnchantment(player.inventory, world, x, y, z);
		}
		else if(id == EnchantChanger.guiIdHugeMateria)
		{
			TileEntity t = world.getBlockTileEntity(x, y, z);
			if(t != null)
				return new EcGuiHugeMateria(player.inventory, (EcTileEntityHugeMateria)t);
			else
			{
//				System.out.println("error");
				return null;
			}
		}
		else
			return null;
	}
	public World getClientWorld()
	{
		return null;
	}
}