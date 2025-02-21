package com.URPlus.dynamiquePN.impl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

public class DynamiquePNInstallationNodeView implements SwingInstallationNodeView<DynamiquePNInstallationNodeContribution> {

	private final Style style;
	private final Locale locale;
	private JCheckBox checkBoxDynaA = new JCheckBox("Option A");
	private JCheckBox checkBoxDynaB = new JCheckBox("Option B");
	private JCheckBox checkBoxDynaC = new JCheckBox("Option C");
	public DynamiquePNInstallationNodeView(ViewAPIProvider apiProvider, Style style) {
		// TODO Auto-generated constructor stub
		this.style = style;
		this.locale = apiProvider.getSystemAPI().getSystemSettings().getLocalization().getLocaleForProgrammingLanguage();
	}

	@Override
	public void buildUI(JPanel panel, DynamiquePNInstallationNodeContribution contribution) {
		// TODO Auto-generated method stub
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(createDescription(new JLabel("This is Dynamique PN configuration space.")));
		panel.add(createCheckboxBox(contribution));
	}
	public void setCheckboxDynaASelection(boolean bValue) {
		checkBoxDynaA.setSelected(bValue);
	}
	public void setCheckboxDynaBSelection(boolean bValue) {
		checkBoxDynaB.setSelected(bValue);
	}
	public void setCheckboxDynaCSelection(boolean bValue) {
		checkBoxDynaC.setSelected(bValue);
	}
	
	private Box createDescription(JLabel label) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(label);
		return box;
	}
	private Box createCheckboxBox(final DynamiquePNInstallationNodeContribution contribution) {
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(style.createSpaceing(0, 30));
		checkBoxDynaA.setFocusable(false);
		checkBoxDynaB.setFocusable(false);
		checkBoxDynaC.setFocusable(false);
		checkBoxDynaA.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange() == 1) {
					contribution.onCheckboxDynaASelection(true);
					System.out.println("Option A selected!");
				}else {
					contribution.onCheckboxDynaASelection(false);
					System.out.println("Option A un-selected!");
				}
			}
		});
		checkBoxDynaB.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == 1) {
					contribution.onCheckboxDynaBSelection(true);
					System.out.println("Option B selected!");
				}else {
					contribution.onCheckboxDynaBSelection(false);
					System.out.println("Option B un-selected!");
				}
			}
		});
		checkBoxDynaC.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == 1) {
					contribution.onCheckboxDynaCSelection(true);
					System.out.println("Option C selected!");
				}else {
					contribution.onCheckboxDynaCSelection(false);
					System.out.println("Option C un-selected!");
				}
			}
		});
		box.add(checkBoxDynaA); box.add(style.createVerticalSpacing());
		box.add(checkBoxDynaB); box.add(style.createVerticalSpacing());
		box.add(checkBoxDynaC); box.add(style.createVerticalSpacing());
		return box;
	}
	

}