package com.URPlus.dynamiquePN.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;


public class Dyna_C_ProgramNodeService implements SwingProgramNodeService<Dyna_C_ProgramNodeContribution, Dyna_C_ProgramNodeView> {

	@Override
	public String getId() {

		return "dyna c";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		configuration.setDisplayOrderId(30.0);
		configuration.setChildrenAllowed(false);
	
	}

	@Override
	public String getTitle(Locale locale) {
	
		return "Dyna C";
	}

	@Override
	public Dyna_C_ProgramNodeView createView(ViewAPIProvider apiProvider) {
		Style style = apiProvider.getSystemAPI().getSoftwareVersion().getMajorVersion() >=5 ? new V5Style() : new V3Style();
		return new Dyna_C_ProgramNodeView(apiProvider, style);

	}

	@Override
	public Dyna_C_ProgramNodeContribution createNode(ProgramAPIProvider apiProvider, Dyna_C_ProgramNodeView view,
			DataModel model, CreationContext context) {

		return new Dyna_C_ProgramNodeContribution(apiProvider, view, model, context);
	}

}