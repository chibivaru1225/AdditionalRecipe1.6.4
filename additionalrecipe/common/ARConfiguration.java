package chibivaru.additionalrecipe.common;

import java.util.HashMap;
import java.util.logging.Level;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ARConfiguration
{
	public Configuration cfg;
	public void init(FMLPreInitializationEvent event)
	{
		cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
		}
		catch (Exception e)
		{
			ARLogger.logger.warning("Config Load Failure.");
			//FMLLog.log(Level.SEVERE, e, AdditionalRecipe.CONSOLE + "Config Load Failure.");
		}
		finally
		{
			cfg.save();
		}
	}
	public void ARLoadItemID(HashMap par1HashMap)
	{
		
	}
	public Property ARLoadItemID(String par1category,String par2key,int par3defaultID,String par4comment)
	{
		Property prop = new Property();
		return prop;
	}
}
