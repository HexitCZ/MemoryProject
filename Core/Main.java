package Core;

import javax.swing.JFrame;

import GUI.UI;

public class Main
{
	public static boolean appOn = true;

	public static void main(String[] args)
	{
		Memory memory = new Memory();

		UI ui = new UI();
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setVisible(true);
		memory.DEBUGSETUP();
		ui.pack(); 
		while (appOn)
		{
			ui.informationDisplay.setText(memory.cells.toString());
		}

	}

}

