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
	public boolean ARSet(String par1category,String par2key,boolean par3default,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		prop.comment  = par4comment;
		return prop.getBoolean(par3default);
	}
	public boolean ARSet(String par1category,String par2key,boolean par3default)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		return prop.getBoolean(par3default);
	}
	public int ARSet(String par1category,String par2key,int par3default,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		prop.comment  = par4comment;
		return prop.getInt();
	}
	public int ARSet(String par1category,String par2key,int par3default)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		return prop.getInt();
	}
	public int ARSetID(String par1category,String par2key,int par3defaultID,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3defaultID);
		prop.comment  = par4comment;
		return prop.getInt();
	}
	public int ARSetID(String par1category,String par2key,int par3defaultID)
	{
		Property prop = cfg.get(par1category, par2key, par3defaultID);
		return prop.getInt();
	}
}
