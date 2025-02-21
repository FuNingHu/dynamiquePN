package com.URPlus.dynamiquePN.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.ContributionConfiguration;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.domain.data.DataModel;

public class DynamiquePNInstallationNodeService
		implements SwingInstallationNodeService<DynamiquePNInstallationNodeContribution, DynamiquePNInstallationNodeView> {

	public DynamiquePNInstallationNodeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return "DynaPN Config";
	}

	@Override
	public DynamiquePNInstallationNodeView createView(ViewAPIProvider apiProvider) {
		// TODO Auto-generated method stub
		Style style = apiProvider.getSystemAPI().getSoftwareVersion().getMajorVersion() >= 5? new V5Style() : new V3Style();
		return new DynamiquePNInstallationNodeView(apiProvider, style);
	}

	@Override
	public DynamiquePNInstallationNodeContribution createInstallationNode(InstallationAPIProvider apiProvider,
			DynamiquePNInstallationNodeView view, DataModel model, CreationContext context) {
		// TODO Auto-generated method stub
		return new DynamiquePNInstallationNodeContribution(apiProvider, view, model, context);
	}

}