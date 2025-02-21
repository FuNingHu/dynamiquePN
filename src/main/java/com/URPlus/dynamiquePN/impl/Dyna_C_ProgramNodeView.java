package com.URPlus.dynamiquePN.impl;


import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Dyna_C_ProgramNodeView implements SwingProgramNodeView<Dyna_C_ProgramNodeContribution> {

	private final ViewAPIProvider apiProvider;
	private final Style style;
	public Dyna_C_ProgramNodeView(ViewAPIProvider apiProvider, Style style) {
		this.apiProvider = apiProvider;
		this.style = style;
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<Dyna_C_ProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(createDescription("This is Dyna C"));
	}
	
	private Box createDescription(String description) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel label = new JLabel(description);
		box.add(label);
		
		return box;
	}


}