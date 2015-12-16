package chibivaru.additionalrecipe.common;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import chibivaru.additionalrecipe.AdditionalRecipe;

import java.util.logging.Level;

public class ARLogger
{
	public static Logger logger;
	public static void init(String par1modid)
	{
		logger = Logger.getLogger(par1modid);
	}
}
