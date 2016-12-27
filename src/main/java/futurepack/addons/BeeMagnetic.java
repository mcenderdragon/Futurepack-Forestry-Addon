package futurepack.addons;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeMagnetic extends BeeNeon
{

	public BeeMagnetic(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
	}

	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
		BreedingManager.set(array, EnumBeeChromosome.CAVE_DWELLING, true);
		array[EnumBeeChromosome.FLOWER_PROVIDER.ordinal()] = FlowerTypes.Erze;
		array[EnumBeeChromosome.EFFECT.ordinal()] = PotionMagnetism.effect;
		
		return array;
	}
}
