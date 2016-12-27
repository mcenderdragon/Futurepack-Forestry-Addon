package futurepack.addons.forestry.bees;

import java.util.Arrays;
import java.util.Locale;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import forestry.apiculture.genetics.alleles.AlleleFlowers;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;

public enum BeeBranches implements IBranchDefinition 
{
	MENELAUS("Menelaus")
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{		
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.CACTI);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);	
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGER);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.EFFECT, AlleleEffect.effectNone);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
		}
	},	
	CYBER("cyber")
	{
		@Override
		protected void setBranchProperties(IAllele[] alleles) 
		{		
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.GOURD);			
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.CAVE_DWELLING, true);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.instance.set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);			
		}
	};

	private IClassification branch;
	private final String scientific;

	BeeBranches(String scientific) 
	{
		this.scientific = scientific;
	}

	protected void setBranchProperties(IAllele[] template) 
	{

	}

	public static void setupBranches()
	{
		for(BeeBranches branch : BeeBranches.values())
		{
			branch.setup();
		}
	}
	
	private void setup() 
	{
		branch = BeeManager.beeFactory.createBranch(this.name().toLowerCase(Locale.ENGLISH), scientific);	
	}

	@Override
	public final IAllele[] getTemplate() {
		IAllele[] template = getDefaultTemplate();
		setBranchProperties(template);
		return template;
	}

	@Override
	public final IClassification getBranch() {
		return branch;
	}

	private static IAllele[] defaultTemplate;

	private static IAllele[] getDefaultTemplate() {
		if (defaultTemplate == null) {
			defaultTemplate = new IAllele[EnumBeeChromosome.values().length];

			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTER);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TOLERATES_RAIN, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.instance.set(defaultTemplate, EnumBeeChromosome.EFFECT, AlleleEffect.effectNone);
		}
		return Arrays.copyOf(defaultTemplate, defaultTemplate.length);
}

}
