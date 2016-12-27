//package futurepack.addons;
//
//import java.util.Map;
//
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.IIcon;
//import net.minecraft.world.World;
//
//import com.mojang.authlib.GameProfile;
//
//import forestry.api.apiculture.EnumBeeType;
//import forestry.api.apiculture.IAlleleBeeSpeciesCustom;
//import forestry.api.apiculture.IBeeGenome;
//import forestry.api.apiculture.IBeeHousing;
//import forestry.api.apiculture.IBeeIconProvider;
//import forestry.api.apiculture.IBeeRoot;
//import forestry.api.apiculture.IJubilanceProvider;
//import forestry.api.core.EnumHumidity;
//import forestry.api.core.EnumTemperature;
//import forestry.api.core.IIconProvider;
//import forestry.api.genetics.IAlleleSpeciesCustom;
//import forestry.api.genetics.IClassification;
//import forestry.api.genetics.IIndividual;
//
//public class BeeSpeciesCustomComb implements IAlleleBeeSpeciesCustom
//{
//	final IAlleleBeeSpeciesCustom parent;
//	
//	public BeeSpeciesCustomComb(IAlleleBeeSpeciesCustom allele)
//	{
//		this.parent = allele;
//	}
//	
//	@Override
//	public IBeeRoot getRoot()
//	{
//		return parent.getRoot();
//	}
//
//	@Override
//	public boolean isNocturnal()
//	{
//		return parent.isNocturnal();
//	}
//
//	@Override
//	public Map<ItemStack, Float> getProductChances()
//	{
//		return parent.getProductChances();
//	}
//
//	@Override
//	public Map<ItemStack, Float> getSpecialtyChances()
//	{
//		return parent.getSpecialtyChances();
//	}
//
//	@Override
//	public boolean isJubilant(IBeeGenome genome, IBeeHousing housing)
//	{
//		return parent.isJubilant(genome, housing);
//	}
//
//	@Override
//	public IIcon getIcon(EnumBeeType type, int renderPass)
//	{
//		return parent.getIcon(type, renderPass);
//	}
//
//	@Override
//	public String getEntityTexture()
//	{
//		return parent.getEntityTexture();
//	}
//
//	@Override
//	public Map<ItemStack, Integer> getProducts()
//	{
//		return parent.getProducts();
//	}
//
//	@Override
//	public Map<ItemStack, Integer> getSpecialty()
//	{
//		return parent.getSpecialty();
//	}
//
//	@Override
//	public String getDescription()
//	{
//		return parent.getDescription();
//	}
//
//	@Override
//	public String getBinomial()
//	{
//		return parent.getBinomial();
//	}
//
//	@Override
//	public String getAuthority()
//	{
//		return parent.getAuthority();
//	}
//
//	@Override
//	public IClassification getBranch()
//	{
//		return parent.getBranch();
//	}
//
//	@Override
//	public int getComplexity()
//	{
//		return parent.getComplexity();
//	}
//
//	@Override
//	public float getResearchSuitability(ItemStack itemstack)
//	{
//		return parent.getResearchSuitability(itemstack);
//	}
//
//	@Override
//	public ItemStack[] getResearchBounty(World world, GameProfile gameProfile, IIndividual individual, int bountyLevel) 
//	{
//		return parent.getResearchBounty(world, gameProfile, individual, bountyLevel);
//	}
//
//	@Override
//	public EnumTemperature getTemperature()
//	{
//		return parent.getTemperature();
//	}
//
//	@Override
//	public EnumHumidity getHumidity()
//	{
//		return parent.getHumidity();
//	}
//
//	@Override
//	public boolean hasEffect()
//	{
//		return parent.hasEffect();
//	}
//
//	@Override
//	public boolean isSecret()
//	{
//		return parent.isSecret();
//	}
//
//	@Override
//	public boolean isCounted()
//	{
//		return parent.isCounted();
//	}
//
//	@Override
//	public int getIconColour(int renderPass)
//	{
//		return parent.getIconColour(renderPass);
//	}
//
//	@Override
//	public IIconProvider getIconProvider()
//	{
//		return parent.getIconProvider();
//	}
//
//	@Override
//	public String getUID()
//	{
//		return parent.getUID();
//	}
//
//	@Override
//	public boolean isDominant()
//	{
//		return parent.isDominant();
//	}
//
//	@Override
//	public String getName()
//	{
//		return parent.getName();
//	}
//
//	@Override
//	public String getUnlocalizedName()
//	{
//		return parent.getUnlocalizedName();
//	}
//
//	@Override
//	public IAlleleSpeciesCustom setTemperature(EnumTemperature temperature)
//	{
//		return parent.setTemperature(temperature);
//	}
//
//	@Override
//	public IAlleleSpeciesCustom setHumidity(EnumHumidity humidity)
//	{
//		return parent.setHumidity(humidity);
//	}
//
//	@Override
//	public IAlleleSpeciesCustom setHasEffect()
//	{
//		return parent.setHasEffect();
//	}
//
//	@Override
//	public IAlleleSpeciesCustom setIsSecret()
//	{
//		return parent.setIsSecret();
//	}
//
//	@Override
//	public IAlleleSpeciesCustom setIsNotCounted()
//	{
//		return parent.setIsNotCounted();
//	}
//
//	@Override
//	public IAlleleBeeSpeciesCustom addProduct(ItemStack product, Float chance)
//	{
//		return parent.addProduct(product, chance);
//	}
//
//	@Override
//	public IAlleleBeeSpeciesCustom addSpecialty(ItemStack specialty, Float chance)
//	{
//		return parent.addSpecialty(specialty, chance);
//	}
//
//	@Override
//	public IAlleleBeeSpeciesCustom setJubilanceProvider( IJubilanceProvider provider)
//	{
//		return parent.setJubilanceProvider(provider);
//	}
//
//	@Override
//	public IAlleleBeeSpeciesCustom setNocturnal()
//	{
//		return parent.setNocturnal();
//	}
//
//	@Override
//	public IAlleleBeeSpeciesCustom setCustomBeeIconProvider( IBeeIconProvider beeIconProvider)
//	{
//		return parent.setCustomBeeIconProvider(beeIconProvider);
//	}
//
//}
