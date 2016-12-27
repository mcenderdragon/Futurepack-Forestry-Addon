package futurepack.addons.bees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeRobotic extends BeeMetalic
{

	public BeeRobotic(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
	}
	
	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
		BreedingManager.set(array, EnumBeeChromosome.FERTILITY, BreedingManager.getEnumAllele("Fertility", "NORMAL"));	
		return array;
	}

}
