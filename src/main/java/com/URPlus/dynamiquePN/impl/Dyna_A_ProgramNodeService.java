package com.URPlus.dynamiquePN.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;


public class Dyna_A_ProgramNodeService implements SwingProgramNodeService<Dyna_A_ProgramNodeContribution, Dyna_A_ProgramNodeView> {

	@Override
	public String getId() {

		return "dynaA";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		configuration.setDisplayOrderId(10.0);
		configuration.setChildrenAllowed(false);
	
	}

	@Override
	public String getTitle(Locale locale) {
	
		return "Dyna A";
	}

	@Override
	public Dyna_A_ProgramNodeView createView(ViewAPIProvider apiProvider) {
		Style style = apiProvider.getSystemAPI().getSoftwareVersion().getMajorVersion() >=5 ? new V5Style() : new V3Style();
		Locale locale = apiProvider.getSystemAPI().getSystemSettings().getLocalization().getLocaleForProgrammingLanguage();
		return new Dyna_A_ProgramNodeView(apiProvider, style, locale);

	}

	@Override
	public Dyna_A_ProgramNodeContribution createNode(ProgramAPIProvider apiProvider, Dyna_A_ProgramNodeView view,
			DataModel model, CreationContext context) {

		return new Dyna_A_ProgramNodeContribution(apiProvider, view, model, context);
	}

}