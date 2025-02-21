package com.URPlus.dynamiquePN.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;

import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;

public class DynamiquePNInstallationNodeContribution implements InstallationNodeContribution {
	private final DataModel model;
	private final Locale locale;
	private final DynamiquePNInstallationNodeView view;
	private final InstallationAPIProvider apiProvider;
	private static final String IS_OPTION_A_SELECTED_KEY = "is_option_a_selected";
	private static final boolean IS_OPTION_A_SELECTED_DEFAULT = false;
	private static final String IS_OPTION_B_SELECTED_KEY = "is_option_b_selected";
	private static final boolean IS_OPTION_B_SELECTED_DEFAULT = false;
	private static final String IS_OPTION_C_SELECTED_KEY = "is_option_c_selected";
	private static final boolean IS_OPTION_C_SELECTED_DEFAULT = false;
	private static final String PROGREMS_PATH = "/home/ur/ursim/ursim-5.15.0.126572/programs/";
	private static final String CONFIGURATION_NAME = "dynamiConfiguration.properties";

	public DynamiquePNInstallationNodeContribution(InstallationAPIProvider apiProvider, DynamiquePNInstallationNodeView view,
			DataModel model, CreationContext context) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
		this.apiProvider = apiProvider;
		this.locale = apiProvider.getSystemAPI().getSystemSettings().getLocalization().getLocaleForProgrammingLanguage();
	}

	@Override
	public void openView() {
		// TODO Auto-generated method stub
		view.setCheckboxDynaASelection(getCheckboxDynaASelection());
		view.setCheckboxDynaBSelection(getCheckboxDynaBSelection());
		view.setCheckboxDynaCSelection(getCheckboxDynaCSelection());
	}

	@Override
	public void closeView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateScript(ScriptWriter writer) {
		// TODO Auto-generated method stub

	}
	public void updateDynamiConfig(String filePath, String key, boolean bValue) {
		Properties properties = new Properties();
		File configFile = new File(filePath);
		
		try {
			//check if file exists
			if(configFile.exists()) {
				try(FileInputStream fis = new FileInputStream(configFile)){
					properties.load(fis);
				}
			}else {
				if(configFile.getParent()!=null) {
					configFile.getParentFile().mkdirs();
				}
				configFile.createNewFile();
			}
			//update properties
			properties.setProperty(key, String.valueOf(bValue));
			
			// save properties to file
			try(OutputStream fos = new FileOutputStream(configFile)){
				properties.store(fos, "Updated dynamic configuration");
			}
			System.out.println("Properties update successful, key: "+key+", value: "+bValue);
		}catch(IOException e) {
			System.out.println("Properties update failure: "+e.getMessage());
			e.printStackTrace();
		}
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
	
	public void onCheckboxDynaASelection(boolean bValue) {
//		model.set(IS_OPTION_A_SELECTED_KEY, bValue);
		updateDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_A_SELECTED_KEY, bValue);
	}
	public boolean getCheckboxDynaASelection() {
//		return model.get(IS_OPTION_A_SELECTED_KEY, IS_OPTION_A_SELECTED_DEFAULT);
		return getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_A_SELECTED_KEY);
	}
	public void onCheckboxDynaBSelection(boolean bValue) {
//		model.set(IS_OPTION_B_SELECTED_KEY, bValue);
		updateDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_B_SELECTED_KEY, bValue);
	}
	public boolean getCheckboxDynaBSelection() {
//		return model.get(IS_OPTION_B_SELECTED_KEY, IS_OPTION_B_SELECTED_DEFAULT);
		return getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_B_SELECTED_KEY);
	}
	public void onCheckboxDynaCSelection(boolean bValue) {
//		model.set(IS_OPTION_C_SELECTED_KEY, bValue);
		updateDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_C_SELECTED_KEY, bValue);
	}
	public boolean getCheckboxDynaCSelection() {
//		return model.get(IS_OPTION_C_SELECTED_KEY, IS_OPTION_C_SELECTED_DEFAULT);
		return getDynamiConfig(PROGREMS_PATH+CONFIGURATION_NAME, IS_OPTION_C_SELECTED_KEY);
	}

}