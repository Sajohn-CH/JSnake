package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JSettingsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public JSettingsPanel(final Snake2 snake2) {
		JLabel lblSettings = new JLabel(snake2.lang.UI_SETTINGS.toUpperCase());
		JButton btnMenu = new JButton(snake2.lang.UI_MENU);
		
		JLabel lblGameSettings = new JLabel(snake2.lang.UI_GAME_SETTINGS);
		JLabel lblSleeptime = new JLabel(snake2.lang.UI_SPEED + ": ");
		final JTextField tFieldSleeptime = new JTextField(5);
		
		JLabel lblResolutionSettings = new JLabel(snake2.lang.UI_RES_SETTINGS);
		final JCheckBox ckBoxMaxRes = new JCheckBox(snake2.lang.UI_MAXRES);
		JLabel lblWidth = new JLabel(snake2.lang.UI_DISPLAYWIDTH + ": ");
		final JTextField tFieldWidth = new JTextField(5);
		JLabel lblHeight = new JLabel(snake2.lang.UI_DISPLAYHEIGHT + ": ");
		final JTextField tFieldHeight = new JTextField(5);
		
		JLabel lblLanguageSettings = new JLabel(snake2.lang.UI_LANG_SETTINGS);
		JLabel lblLanguage = new JLabel(snake2.lang.UI_LANGUAGE);
		String[] languages = snake2.settings.SUPPORTEDLANG;
		final JComboBox<String> comboLang = new JComboBox<>(languages);
		JButton btnNewLang = new JButton(snake2.lang.UI_NEW_LANG);
		
		lblSleeptime.setToolTipText(snake2.lang.UI_EXPL_SPEED);
		comboLang.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		lblLanguage.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		ckBoxMaxRes.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		lblWidth.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		tFieldWidth.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		lblHeight.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		tFieldHeight.setToolTipText(snake2.lang.UI_EXPL_LANGUAGE);
		
		//write the values in the TextFields
		tFieldSleeptime.setText(String.valueOf(snake2.settings.SLEEPTIME));
		ckBoxMaxRes.setSelected(snake2.settings.USEMAXRESOLUTION);
		tFieldWidth.setText(String.valueOf(snake2.settings.DISPWIDTH));
		tFieldHeight.setText(String.valueOf(snake2.settings.DISPHEIGHT));
		comboLang.setSelectedItem(snake2.settings.LANG);
		
		//Fonts
		lblSettings.setFont(snake2.FONT_SMALL_TITLE);
		btnMenu.setFont(snake2.FONT_MENUTEXT);
		
		lblGameSettings.setFont(snake2.FONT_SMALL_TITLE);
		lblSleeptime.setFont(snake2.FONT_TEXT);
		tFieldSleeptime.setFont(snake2.FONT_TEXT);
		
		lblResolutionSettings.setFont(snake2.FONT_SMALL_TITLE);
		ckBoxMaxRes.setFont(snake2.FONT_TEXT);
		lblWidth.setFont(snake2.FONT_TEXT);
		tFieldWidth.setFont(snake2.FONT_TEXT);
		lblHeight.setFont(snake2.FONT_TEXT);
		tFieldHeight.setFont(snake2.FONT_TEXT);
		
		lblLanguageSettings.setFont(snake2.FONT_SMALL_TITLE);
		lblLanguage.setFont(snake2.FONT_TEXT);
		comboLang.setFont(snake2.FONT_TEXT);
		btnNewLang.setFont(snake2.FONT_TEXT);
		
		//Layout 
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 20, 0);
		c.gridwidth = 3;
		add(lblSettings, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridwidth = 2;
		add(lblGameSettings, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(lblSleeptime, c);
		
		c.gridx = 1;
		c.gridy = 2;
		add(tFieldSleeptime, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		add(lblResolutionSettings, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		add(ckBoxMaxRes, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		add(lblWidth, c);
		
		c.gridx = 1;
		c.gridy = 5;
		add(tFieldWidth, c);
		
		c.gridx = 0;
		c.gridy = 6;
		add(lblHeight, c);
		
		c.gridx = 1;
		c.gridy = 6;
		add(tFieldHeight, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		add(lblLanguageSettings, c);
		
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		add(lblLanguage, c);
		
		c.gridx = 1;
		c.gridy = 8;
		add(comboLang, c);
		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		add(btnNewLang, c);
		
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridwidth = 3;
		add(btnMenu, c);
		
		//ActionListeners
		ActionListener goMenu = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboLang.getSelectedItem() != snake2.settings.LANG) {
					JOptionPane.showConfirmDialog(snake2.mainFrame, snake2.lang.UI_NEEDS_RESTART, "!!", JOptionPane.OK_OPTION);
				}
				//Write all new settings in the settings-class
				snake2.settings.SLEEPTIME = Integer.valueOf(tFieldSleeptime.getText());
				snake2.settings.USEMAXRESOLUTION = ckBoxMaxRes.isSelected();
				snake2.settings.DISPWIDTH = Integer.valueOf(tFieldWidth.getText());
				snake2.settings.DISPHEIGHT = Integer.valueOf(tFieldHeight.getText());
				snake2.settings.LANG = comboLang.getSelectedItem().toString();
				
				//Change panel back to the Menu-Panel
				snake2.pnlSettings.setVisible(false);
				snake2.pnlMenu.setVisible(true);
			}
		};
		
		ActionListener goNewLang = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				snake2.pnlSettings.setVisible(false);
				snake2.pnlNewLang.setVisible(true);
			}
		};
		
		btnMenu.addActionListener(goMenu);
		btnNewLang.addActionListener(goNewLang);
		
		setVisible(false);
	}
}
