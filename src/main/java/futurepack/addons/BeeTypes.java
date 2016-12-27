package futurepack.addons;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IAlleleBeeSpeciesBuilder;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeFactory;
import forestry.api.apiculture.IBeeSpriteColourProvider;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class BeeTypes
{
	private static Item combs = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeCombs"));
	private static Item tools = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:spaceship"));
	private static ArrayList<BeeTypes> list = new ArrayList<BeeTypes>(16);
	
	public static final BeeTypes Menelaus = new BeeMenelaus("Menelaus", 0xcd7742, 0xbb6332).addProduct(new ItemStack(combs,1,7), 0.2F).setHumidity(EnumHumidity.ARID).setTemperature(EnumTemperature.HOT).setNatural();
	public static final BeeTypes Modern = new BeeModern("Modern", 0x55463c, 0x6c7d95).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL);
	public static final BeeTypes Neon = new BeeNeon("Neon", 0x55463c, 0x42c3ff).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs,1,CombTypes.NeonComb.getId()), 0.05F);
	public static final BeeTypes Retium = new BeeNeon("Retium", 0x55463c, 0xe41515).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.RetiumComb.getId()), 0.05F);
	public static final BeeTypes Glowtit = new BeeGlowtit("Glowtit", 0x55463c, 0xebfe13).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.GlowtitComb.getId()), 0.05F);
	public static final BeeTypes Bioterium = new BeeNeon("Bioterium", 0x55463c, 0x24ff46).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.BioteriumComb.getId()), 0.05F);
	public static final BeeTypes Alutin = new BeeNeon("Alutin", 0x55463c, 0xd4e4e7).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.AlutinComb.getId()), 0.05F);
	public static final BeeTypes Magnet = new BeeMagnetic("Magnet", 0x55463c, 0x4d5874).addProduct(new ItemStack(combs,1,3), 0.2F).setHumidity(EnumHumidity.NORMAL).setTemperature(EnumTemperature.NORMAL).addSpecial(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F);
	

	public static final BeeTypes Metalic = new BeeMetalic("Metalic", 0x7d838e, 0x949494).setCyber(true).addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F).addSpecial(new ItemStack(tools, 1, 7), 0.1F);
	public static final BeeTypes Cybren = new BeeCybren("Cybren", 0x7d838e, 0xbbeade).setCyber(true).addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F).addSpecial(new ItemStack(tools, 1, 11),  0.1F);
	public static final BeeTypes Futuristic = new BeeCybren("Futuristic", 0x7d838e, 0xc78b2e).setCyber(true).addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F).addSpecial(new ItemStack(tools,1,15), 0.1F);
	public static final BeeTypes Robotic = new BeeRobotic("Robotic", 0x7d838e, 0xcfcfcf).setCyber(true).addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.15F).addSpecial(OreDictionary.getOres("dustIron").get(0),  0.15F);
	public static final BeeTypes Neural = new BeeNeural("Neural", 0x7d838e, 0x98f893).setCyber(true).addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F).addSpecial(new ItemStack(tools, 1, 10),  0.1F);
	public static final BeeTypes Konstruktion = new BeeKonstruction("Konstruktion", 0x7d838e, 0x7757b8).setCyber(true).addProduct(new ItemStack(tools,1,13), 0.20F).addSpecial(new ItemStack(tools,1,14), 0.05F); 
	public static final BeeTypes Inteligent = new BeeInteligend("Inteligent", 0x8bb1da, 0x395ea0).setCyber(true).addSpecial(new ItemStack(tools, 1, 15),  0.2F).addSpecial(new ItemStack(tools, 1, 15),  0.1F); 	//special: Custom Comb (1%)
	public static final BeeTypes Nanobite = new BeeNanobite("Nanobite", 0x8bb1da, 0xffd606).setCyber(true).addSpecial(new ItemStack(tools,1,13), 0.20F).addSpecial(new ItemStack(tools,1,14), 0.10F);				//Product : Custom Comb (2%)
	
	
	public static void registerBees()
	{
		IBeeFactory fac = BeeManager.beeFactory;
		
//		IBeeIconProvider fpIconProvider = new IBeeIconProvider()
//		{
//			IIcon body1;
//			IIcon body2Drone;
//			IIcon body2Princess;
//			IIcon body2Queen;
//			IIcon outlineDrone;
//			IIcon outlinePrincess;
//			IIcon outlineQueen;
//				
//			IIcon larvaobody, larvaebody2, larvaeoutline;
//			
//			@Override
//			public void registerIcons(IIconRegister register)
//			{
//				body1 = register.registerIcon(FPForestryAddon.ID + ":cyberbody1");
//				outlineDrone = register.registerIcon(FPForestryAddon.ID + ":cyberdrone.outline");
//				outlinePrincess = register.registerIcon(FPForestryAddon.ID + ":cyberprincess.outline");
//				outlineQueen = register.registerIcon(FPForestryAddon.ID + ":cyberqueen.outline");
//				body2Drone = register.registerIcon(FPForestryAddon.ID + ":cyberdrone.body2");
//				body2Princess = register.registerIcon(FPForestryAddon.ID + ":cyberprincess.body2");
//				body2Queen = register.registerIcon(FPForestryAddon.ID + ":cyberqueen.body2");
//				
//				larvaobody = register.registerIcon("forestry:bees/default/larvae.body");
//				larvaebody2 = register.registerIcon("forestry:bees/default/larvae.body2");
//				larvaeoutline = register.registerIcon("forestry:bees/default/larvae.outline");
//			}
//			
//			@Override
//			public IIcon getIcon(EnumBeeType type, int renderPass)
//			{	
//				if(renderPass == 0)
//				{
//					return type==EnumBeeType.LARVAE ? larvaobody : body1;
//				}		
//				else if(renderPass==1)
//				{
//					return type==EnumBeeType.DRONE?outlineDrone : type==EnumBeeType.PRINCESS ? outlinePrincess : type==EnumBeeType.QUEEN ? outlineQueen : larvaeoutline; 
//				}
//				else if(renderPass==2)
//				{
//					return type==EnumBeeType.DRONE?body2Drone : type==EnumBeeType.PRINCESS ? body2Princess : type==EnumBeeType.QUEEN ? body2Queen : larvaebody2;
//				}
//				else
//				{
//					return null;
//				}
//			}
//		};
		IClassification nature = fac.createBranch("menelaus", "menelaus");
		IClassification cyber = fac.createBranch("cyber", "cyber");
		AlleleManager.alleleRegistry.getClassification("family.apidae").addMemberGroup(nature);
		AlleleManager.alleleRegistry.getClassification("family.apidae").addMemberGroup(cyber);
		
		
		
		for(BeeTypes type : list)
		{
			type.branch=type.isCyber ? cyber : nature;
			type.allele = fac.createSpecies(type.uid, type.dominant, type.authority, type.unlocalizedName, type.unlocalizedDescription, type.branch, type.binomial, type.primaryColor, type.secondaryColor);
//			AlleleManager.alleleRegistry.registerAllele(type.allele);
			if(type.isCyber)
			{
//				type.allele.setCustomBeeIconProvider(fpIconProvider);
			}
			type.postRegister();
		}
		
		IBee bbe = BeeManager.beeRoot.getMember((ItemStack)null);
	}

	protected final String uid;
	protected final int primaryColor;
	protected final int secondaryColor;
	protected final String authority = "Future Sarcina";
	protected final String unlocalizedName;
	protected final String unlocalizedDescription;
	
	protected String scientific = "";
	protected boolean dominant = false;
	protected String binomial = "";
	protected EnumHumidity humidity= null;
	protected EnumTemperature temperature = null;
	protected HashMap<ItemStack, Float> products = new HashMap<ItemStack, Float>();
	protected HashMap<ItemStack, Float> special = new HashMap<ItemStack, Float>();
	protected boolean isCyber = false;
	protected boolean isSecret = true;
	
	protected IClassification branch;
	protected IAlleleBeeSpeciesBuilder allele;
	protected IAlleleBeeSpecies bee;
	
	public BeeTypes(String name, int firstCol, int secondCol)
	{
		this.uid = "forestry.species"+name;
		this.unlocalizedName = "fpf.bees.species."+name.toLowerCase();
		this.unlocalizedDescription = this.unlocalizedName + ".desc";
		
		this.primaryColor = firstCol;
		this.secondaryColor = secondCol;
		this.binomial = Integer.toHexString((this.primaryColor & this.secondaryColor));
		
		list.add(this);
	}
	
	public BeeTypes setCyber(boolean isCyber)
	{
		this.isCyber = isCyber;
		return this;
	}
	
	public BeeTypes setScientific(String scientific)
	{
		this.scientific = scientific;
		return this;
	}
	
	public BeeTypes setDominant(boolean dominant)
	{
		this.dominant = dominant;
		return this;
	}
	
	public void setBinomial(String binomial)
	{
		this.binomial = binomial;
	}
	
	public BeeTypes addProduct(ItemStack it, float chance)
	{
		products.put(it, chance);
		return this;
	}
	
	public BeeTypes addSpecial(ItemStack it, float chance)
	{
		special.put(it, chance);
		return this;
	}
	
	public BeeTypes setHumidity(EnumHumidity humidity)
	{
		this.humidity = humidity;
		return this;
	}
	
	public BeeTypes setTemperature(EnumTemperature temperature)
	{
		this.temperature = temperature;
		return this;
	}
	
	public BeeTypes setNatural() 
	{
		this.isSecret = false;
		return this;
	}
	
	public IAlleleBeeSpecies getAllele()
	{
		return bee;
	}
	
	protected void postRegister()
	{
		if(humidity!=null)
		{
			allele.setHumidity(humidity);
		}
		if(temperature!=null)
		{
			allele.setTemperature(temperature);
		}
		if(!products.isEmpty())
		{
			for(Entry<ItemStack,Float> entry : products.entrySet())
			{
				allele.addProduct(entry.getKey(), entry.getValue());
			}
		}
		if(!special.isEmpty())
		{
			for(Entry<ItemStack,Float> entry : special.entrySet())
			{
				allele.addSpecialty(entry.getKey(), entry.getValue());
			}
		}
		if(this.isSecret)
		{
			allele.setIsSecret();
		}
		BeeManager.beeRoot.registerTemplate(this.uid, getChromosomes());
	}

	public IAllele[] getChromosomes()
	{
		IAllele[] array = new IAllele[13];
		bee = allele.build();
		array[EnumBeeChromosome.SPECIES.ordinal()] = getAllele();
		
		return array;
	}

}
