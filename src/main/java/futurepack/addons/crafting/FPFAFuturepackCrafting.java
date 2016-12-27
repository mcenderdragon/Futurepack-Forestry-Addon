package futurepack.addons.crafting;

import java.lang.reflect.Method;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.genetics.IIndividual;
import futurepack.addons.bees.BeeTypes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class FPFAFuturepackCrafting 
{
	public static void setup()
	{
		try
		{
			Method m_addAssemblyRecipe;
			Class c = Class.forName("futurepack.depend.api.RegistryCollection");
			m_addAssemblyRecipe = c.getMethod("addAssemblyRecipe", ItemStack[].class, ItemStack.class);
			
			ItemStack drone = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeDroneGE")));
			ItemStack princess = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beePrincessGE")));
			
			ItemStack chip = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:chip")),1,0);
			ItemStack eisen = new ItemStack(Items.IRON_INGOT);
			IIndividual bee = BeeManager.beeRoot.templateAsIndividual(BeeTypes.Metalic.getChromosomes());
			ItemStack droneOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);	
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{drone,chip,eisen}, droneOut);
			
			ItemStack princessOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);		
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{princess,chip,eisen}, princessOut);
			
			chip = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:chip")),1,1);
			eisen = OreDictionary.getOres("ingotRetium").get(0);
			bee = BeeManager.beeRoot.templateAsIndividual(BeeTypes.Cybren.getChromosomes());
			droneOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{drone,chip,eisen}, droneOut);
			
			princessOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{princess,chip,eisen}, princessOut);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
