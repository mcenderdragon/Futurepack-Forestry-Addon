/*package futurepack.addons.bees;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeMutationBuilder;
import forestry.api.genetics.IAllele;

public class BreedingManager 
{
	public static void registerBreedings()
	{
		IAlleleBeeSpecies DILIGENT = null, SINISTER = null; 
		try
		{
			Class c_BeeDefinition  = Class.forName("forestry.apiculture.genetics.BeeDefinition");
			Field f_species = c_BeeDefinition.getDeclaredField("species");
			f_species.setAccessible(true);
			Object o_DILIGENT= Enum.valueOf(c_BeeDefinition, "DILIGENT");
			Object o_SINISTER= Enum.valueOf(c_BeeDefinition, "SINISTER");
			
			DILIGENT = (IAlleleBeeSpecies) f_species.get(o_DILIGENT);		
			SINISTER = (IAlleleBeeSpecies) f_species.get(o_SINISTER);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(DILIGENT==null || SINISTER==null)
		{
			System.err.println("Cant get DILIGENT or SINISTER, stop adding Breedings");
			return;
		}
		
		IBeeMutationBuilder modern = BeeManager.beeMutationFactory.createMutation(BeeTypes.Menelaus.getAllele(), DILIGENT, BeeTypes.Modern.getChromosomes(), 15);
		IBeeMutationBuilder neon = BeeManager.beeMutationFactory.createMutation(BeeTypes.Menelaus.getAllele(), BeeTypes.Modern.getAllele(), BeeTypes.Neon.getChromosomes(), 12);
		IBeeMutationBuilder retium = BeeManager.beeMutationFactory.createMutation(BeeTypes.Neon.getAllele(), BeeTypes.Modern.getAllele(), BeeTypes.Retium.getChromosomes(), 10);
		IBeeMutationBuilder glowtit = BeeManager.beeMutationFactory.createMutation(BeeTypes.Neon.getAllele(), SINISTER, BeeTypes.Glowtit.getChromosomes(), 10);
		IBeeMutationBuilder bioterium = BeeManager.beeMutationFactory.createMutation(BeeTypes.Alutin.getAllele(), BeeTypes.Retium.getAllele(), BeeTypes.Bioterium.getChromosomes(), 5);
		IBeeMutationBuilder alutin = BeeManager.beeMutationFactory.createMutation(BeeTypes.Menelaus.getAllele(), BeeTypes.Modern.getAllele(), BeeTypes.Alutin.getChromosomes(), 15);
		IBeeMutationBuilder magnet = BeeManager.beeMutationFactory.createMutation(BeeTypes.Alutin.getAllele(), BeeTypes.Modern.getAllele(), BeeTypes.Magnet.getChromosomes(), 10);
		
		IBeeMutationBuilder futuristic = BeeManager.beeMutationFactory.createMutation(BeeTypes.Metalic.getAllele(), BeeTypes.Cybren.getAllele(), BeeTypes.Futuristic.getChromosomes(), 20);
		IBeeMutationBuilder robotic = BeeManager.beeMutationFactory.createMutation(BeeTypes.Metalic.getAllele(), BeeTypes.Futuristic.getAllele(), BeeTypes.Robotic.getChromosomes(), 15);
		IBeeMutationBuilder neural = BeeManager.beeMutationFactory.createMutation(BeeTypes.Futuristic.getAllele(), BeeTypes.Cybren.getAllele(), BeeTypes.Neural.getChromosomes(), 15);
		IBeeMutationBuilder konstruktion = BeeManager.beeMutationFactory.createMutation(BeeTypes.Futuristic.getAllele(), BeeTypes.Neural.getAllele(), BeeTypes.Konstruktion.getChromosomes(), 8);
		IBeeMutationBuilder inteligent = BeeManager.beeMutationFactory.createMutation(BeeTypes.Neural.getAllele(), BeeTypes.Robotic.getAllele(), BeeTypes.Inteligent.getChromosomes(), 2);
		IBeeMutationBuilder nanobite = BeeManager.beeMutationFactory.createMutation(BeeTypes.Konstruktion.getAllele(), BeeTypes.Inteligent.getAllele(), BeeTypes.Nanobite.getChromosomes(), 1);
		
		
	}
	
	
	private static Object o_AlleleHelper;
	private static Method m_set; 
	private static Method m_set_boolean; 
	private static Method m_set_allele; 
	private static Class c_Allele, c_AlleleEffect;
	
	static 
	{
		try
		{
			c_Allele = Class.forName("forestry.core.genetics.alleles.Allele");		
			c_AlleleEffect = Class.forName("forestry.apiculture.genetics.alleles.AlleleEffect");
			Class c_AlleleHelper = Class.forName("forestry.core.genetics.alleles.AlleleHelper");
			Field f_helper = c_AlleleHelper.getField("instance");
			o_AlleleHelper = f_helper.get(null);
			
			Class c_IAlleleValue = Class.forName("forestry.core.genetics.alleles.IAlleleValue");
			
			m_set = c_AlleleHelper.getMethod("set", IAllele[].class, Enum.class, c_IAlleleValue);
			m_set_boolean =c_AlleleHelper.getMethod("set", IAllele[].class, Enum.class, boolean.class);
			m_set_allele = c_AlleleHelper.getMethod("set", IAllele[].class, Enum.class, IAllele.class);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void set(IAllele[] chromosomes, EnumBeeChromosome bee, boolean b)
	{
		try {
			m_set_boolean.invoke(o_AlleleHelper, chromosomes, bee, b);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(IAllele[] chromosomes, EnumBeeChromosome bee, IAllele b)
	{
		try {
			m_set_allele.invoke(o_AlleleHelper, chromosomes, bee, b);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(IAllele[] chromosomes, EnumBeeChromosome bee, Object o)
	{
		try {
			m_set.invoke(o_AlleleHelper, chromosomes, bee, o);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getEnumAllele(String clazz, String value)
	{
		try
		{
			Class c_EnumAllele = Class.forName("forestry.core.genetics.alleles.EnumAllele$"+clazz);
			return Enum.valueOf(c_EnumAllele, value);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static IAllele getEffect(String name)
	{
		try {
			Field f = c_AlleleEffect.getField("effect"+name);
			IAllele a =  (IAllele) f.get(null);
			if(a==null)
			{
				System.err.println("Why is " + name + " null ?!?");
			}
			return a;
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}
}*/
