package com.URPlus.dynamiquePN.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */
public class Activator implements BundleActivator {
	
	private static final String IS_OPTION_A_SELECTED_KEY = "is_option_a_selected";
	private static final boolean IS_OPTION_A_SELECTED_DEFAULT = false;
	private static final String IS_OPTION_B_SELECTED_KEY = "is_option_b_selected";
	private static final boolean IS_OPTION_B_SELECTED_DEFAULT = false;
	private static final String IS_OPTION_C_SELECTED_KEY = "is_option_c_selected";
	private static final boolean IS_OPTION_C_SELECTED_DEFAULT = false;
	private static final String PROGREMS_PATH = "/home/ur/ursim/ursim-5.15.0.126572/programs/";
	private static final String CONFIGURATION_NAME = "dynamiConfiguration.properties";
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		bundleContext.registerService(SwingInstallationNodeService.class, new DynamiquePNInstallationNodeService(), null);
		
		if(getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_A_SELECTED_KEY)) {
			bundleContext.registerService(SwingProgramNodeService.class, new Dyna_A_ProgramNodeService(), null);
		}
		if(getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_B_SELECTED_KEY)) {
			bundleContext.registerService(SwingProgramNodeService.class, new Dyna_B_ProgramNodeService(), null);
		}
		if(getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_C_SELECTED_KEY)) {
			bundleContext.registerService(SwingProgramNodeService.class, new Dyna_C_ProgramNodeService(), null);
		}
		System.out.println("Dynamique PN says Hello World!");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Dynamique says Goodbye World!");
	}
	
	public boolean getDynamiConfig(String filePath, String key) {
		Properties properties = new Properties();
	    File configFile = new File(filePath);
	    try {
	    	//check if file exists
	    	if(configFile.exists()) {
	    		try(FileInputStream fis = new FileInputStream(configFile)){
	    			properties.load(fis);
	    		}
	    		
	    		// acquire key's value
	    		String value = properties.getProperty(key);
	    		return Boolean.parseBoolean(value);
	    	}
	    } catch(IOException e) {
	    	System.err.println("Error in readign configuration: "+e.getMessage());
	    	e.printStackTrace();
	    	return IS_OPTION_A_SELECTED_DEFAULT;
	    }
	    //if file non-exists or encountering exception, return false
	    return IS_OPTION_A_SELECTED_DEFAULT;
	}
}



