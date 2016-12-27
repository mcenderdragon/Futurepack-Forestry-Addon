package futurepack.addons.items.frames;

public class FrameType
{
	
	public static FrameType ironFrame = new FrameType("iron", 1000).setProductionMod(1.2F).setLifespanMod(1.2F);
	public static FrameType neonFrame = new FrameType("neon", 1000).setProductionMod(2F);
	public static FrameType retiumFrame = new FrameType("retium", 1000);
	public static FrameType glowtitFrame = new FrameType("glowtit", 1000).setSelfLighted(true).setSunlightSimulated(true).setSealed(true).setHellish(true);
	public static FrameType bioteriumFrame = new FrameType("bioterium", 1000).setMutationMod(3F);
	public static FrameType impirialFrame = new FrameType("impirial", 1000).setTerritoryMod(2F);
	
	public static FrameType princessFrame = new FrameType("prinzess", 1000).setProductionMod(0.5F);
	
	
	public float territoryMod = 1F;
	public float mutationMod = 1F;
	public float lifespanMod = 1F;
	public float productionMod = 1F;
	public float floweringMod = 1F;
	public float geneticDecay = 0.3F;
	public boolean isSealed = false;
	public boolean isSelfLighted = false;
	public boolean isSunlightSimulated = false;
	public boolean isHellish = false;
	public int maxDamage;
	public String name;
	
	public FrameType(String name, int maxdmg)
	{
		this.name = name;
		maxDamage = maxdmg;
	}
	
	public FrameType setTerritoryMod(float territoryMod)
	{
		this.territoryMod = territoryMod;
		return this;
	}
	
	public FrameType setMutationMod(float mutationMod)
	{
		this.mutationMod = mutationMod;
		return this;
	}
	
	public FrameType setLifespanMod(float lifespanMod)
	{
		this.lifespanMod = lifespanMod;
		return this;
	}
	
	public FrameType setProductionMod(float productionMod)
	{
		this.productionMod = productionMod;
		return this;
	}
	
	public FrameType setFloweringMod(float floweringMod) 
	{
		this.floweringMod = floweringMod;
		return this;
	}
	
	public FrameType setGeneticDecay(float geneticDecay)
	{
		this.geneticDecay = geneticDecay;
		return this;
	}
	
	public FrameType setSealed(boolean isSealed)
	{
		this.isSealed = isSealed;
		return this;
	}
	
	public FrameType setSelfLighted(boolean isSelfLighted) 
	{
		this.isSelfLighted = isSelfLighted;
		return this;
	}
	
	public FrameType setSunlightSimulated(boolean isSunlightSimulated)
	{
		this.isSunlightSimulated = isSunlightSimulated;
		return this;
	}
	
	public FrameType setHellish(boolean isHellish)
	{
		this.isHellish = isHellish;
		return this;
	}
	
	
}
