package com.URPlus.dynamiquePN.impl;


import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;

import java.awt.Component;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Dyna_A_ProgramNodeView implements SwingProgramNodeView<Dyna_A_ProgramNodeContribution> {

	private final Style style;
	private final ViewAPIProvider apiProvider;
	private Locale locale;
	
	public Dyna_A_ProgramNodeView(ViewAPIProvider apiProvider, Style style, Locale locale) {
		this.apiProvider = apiProvider;
		this.style = style;
		this.locale = locale;
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<Dyna_A_ProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(createDescription("This is Dyna A"));
	}
	
	private Box createDescription(String description) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel label = new JLabel(description);
		box.add(label);
		
		return box;
	}


}