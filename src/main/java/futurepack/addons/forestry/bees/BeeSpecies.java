package futurepack.addons.forestry.bees;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IAlleleBeeSpeciesBuilder;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeFactory;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.core.IModelManager;
import forestry.api.genetics.IAllele;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeVariation;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;
import futurepack.addons.forestry.common.FPForestryAddon;
import futurepack.addons.forestry.items.CombTypes;
import futurepack.addons.forestry.items.FPFAItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public enum BeeSpecies implements IBeeDefinition
{
	MENELAUS(BeeBranches.MENELAUS, "Menelaus", true, new Color(0xcd7742), new Color(0xbb6332))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.setNocturnal();
			beeSpecies.addProduct(new ItemStack(combs,1,7), 0.2F);
			beeSpecies.setHumidity(EnumHumidity.ARID);
			beeSpecies.setTemperature(EnumTemperature.HOT);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
			AlleleHelper.instance.set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST);
		}

		@Override
		protected void registerMutations()
		{
		}
	},
	
	CYBERN(BeeBranches.CYBER, "Cybern", true, new Color(0x7d838e), new Color(0xbbeade))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			beeSpecies.addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F);
			beeSpecies.addSpecialty(new ItemStack(tools, 1, 11),  0.1F);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
		}

		@Override
		protected void registerMutations()
		{
		}
		
		@Override
		protected IBeeFactory getBeeFactory()
		{
			return CyberBeeFactory.instance;
		}
	};
	
	private static Item combs;
	public static Item tools;
	
	private final IBranchDefinition branch;
	private final boolean dominant;
	private IAlleleBeeSpecies species;
	private final Color primary;
	private final Color secondary;
	private final String binomial;

	private IAllele[] template;
	private IBeeGenome genome;

	BeeSpecies(IBranchDefinition branch, String binomial, boolean dominant, Color primary, Color secondary)
	{
		this.branch = branch;
		this.dominant = dominant;
		this.primary = primary;
		this.secondary = secondary;
		this.binomial = binomial;
	}
	
	protected IBeeFactory getBeeFactory() {
		return BeeManager.beeFactory;
	}

	public static void setupBees()
	{
		combs = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeCombs"));
		tools = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:spaceship"));
		
		BeeBranches.setupBranches();
		
		for(BeeSpecies bs : BeeSpecies.values())
		{
			bs.setupBee();
		}
	}
	
	private void setupBee()
	{
		String lowercaseName = this.toString().toLowerCase(Locale.ENGLISH);
		String species = "species" + WordUtils.capitalize(lowercaseName);

		String ID = FPForestryAddon.modID + '.' + species;
		String description = FPForestryAddon.modID + ".description." + species;
		String name = "fpfa.bees.species." + lowercaseName;

		IAlleleBeeSpeciesBuilder speciesBuilder = getBeeFactory().createSpecies(ID, dominant, "McEnderdragon", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
		if(isSecret())
		{
			speciesBuilder.setIsSecret();
		}
		setSpeciesProperties(speciesBuilder);
		this.species = speciesBuilder.build();
	}
	
	public static void registerModels(Item i, IModelManager m)
	{
		for(BeeSpecies bs : BeeSpecies.values())
		{
			if(bs.getBeeFactory() != BeeManager.beeFactory)
			{
				bs.registerModel(i, m);
			}
		}
	}
	
	public void registerModel(Item i, IModelManager m)
	{
		species.registerModels(i, m);
	}
	
	public static void initBees()
	{
		for(BeeSpecies bs : BeeSpecies.values())
		{
			bs.init();
		}
		for(BeeSpecies bs : BeeSpecies.values())
		{
			bs.registerMutations();
		}
	}

	protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

	protected abstract void setAlleles(IAllele[] template);

	protected abstract void registerMutations();

	protected boolean isSecret()
	{
		return false;
	}
	
	public static void preInit()
	{

	}

	private void init()
	{
		template = branch.getTemplate();
		AlleleHelper.instance.set(template, EnumBeeChromosome.SPECIES, species);
		setAlleles(template);

		genome = BeeManager.beeRoot.templateAsGenome(template);

		BeeManager.beeRoot.registerTemplate(template);
	}

	@Override
	public final IAllele[] getTemplate()
	{
		return Arrays.copyOf(template, template.length);
	}

	@Override
	public final IBeeGenome getGenome()
	{
		return genome;
	}

	@Override
	public final IBee getIndividual()
	{
		return new Bee(genome);
	}

	@Override
	public final ItemStack getMemberStack(EnumBeeType beeType)
	{
		IBee bee = getIndividual();
		return BeeManager.beeRoot.getMemberStack(bee, beeType);
	}
/*
	public final IBeeDefinition getRainResist()
	{
		return new BeeVariation.RainResist(this);
	}*/
	
}
