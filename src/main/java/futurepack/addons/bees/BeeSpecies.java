package futurepack.addons.bees;


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
import forestry.api.apiculture.IBeeGenome;
import forestry.api.genetics.IAllele;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeVariation;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;
import futurepack.addons.common.FPForestryAddon;
import futurepack.addons.items.CombTypes;
import futurepack.addons.items.FPFAItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public enum BeeSpecies implements IBeeDefinition
{
	CYBERN(BeeBranches.Menelaus, "Menelaus", true, new Color(0x6d6d6d), new Color(0xffdc16))
	{
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies)
		{
			//beeSpecies.addProduct(new ItemStack(FPFAItems.specialCombs, 1, CombTypes.MagneticComb.getId()), 0.05F).addSpecialty(new ItemStack(FPForestryAddon.tools, 1, 11),  0.1F);
		}

		@Override
		protected void setAlleles(IAllele[] template)
		{
			AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
			AlleleHelper.instance.set(template, EnumBeeChromosome.EFFECT, AlleleEffect.effectDrunkard);
		}

		@Override
		protected void registerMutations()
		{
		}
	};
	
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
	
	public static void setupBees()
	{
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
		String name = "for.bees.species." + lowercaseName;

		IAlleleBeeSpeciesBuilder speciesBuilder = CyberBeeFactory.instance.createSpecies(ID, dominant, "McEnderdragon", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
		if(isSecret())
		{
			speciesBuilder.setIsSecret();
		}
		setSpeciesProperties(speciesBuilder);
		this.species = speciesBuilder.build();
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

	public final IBeeDefinition getRainResist()
	{
		return new BeeVariation.RainResist(this);
	}
	
}
