package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Core.Memory;

public class UI extends JFrame
{
	public static int currentIndex = 0;
	public Memory memory;

	private JTextField memoryIndex;
	public JTextField informationDisplay;
	private JButton lButton;
	private JButton rButton;
	private JTextArea addInput;
	private JLabel addLabel;
	private JButton addButton;
	private JTextArea indexToDel;
	private JLabel delLabel;
	private JToggleButton remapToggle;
	private JButton delBtn;
	private JLabel name;
	private JLabel rwLabel;
	private JTextArea rwIndex;
	private JTextArea rwNewInfo;
	private JButton rwBtn;

	public UI()
	{
		memory = new Memory();

		memoryIndex = new JTextField(1);
		informationDisplay = new JTextField(1);
		lButton = new JButton("<==");
		rButton = new JButton("==>");
		addInput = new JTextArea(5, 5);
		addLabel = new JLabel("Add cell");
		addButton = new JButton("Add");
		indexToDel = new JTextArea(1, 1);
		delLabel = new JLabel("Delete");
		remapToggle = new JToggleButton("Remap Memory?", false);
		delBtn = new JButton("Delete");
		name = new JLabel("Memory Controller by Hex");
		rwLabel = new JLabel("Rewrite");
		rwIndex = new JTextArea(1, 1);
		rwNewInfo = new JTextArea(5, 5);
		rwBtn = new JButton("Rewrite");

		addInput.setToolTipText("Write Information");
		indexToDel.setToolTipText("Write here which cell to delete");

		setPreferredSize(new Dimension(741, 343));
		setLayout(null);

		add(memoryIndex);
		add(informationDisplay);
		add(lButton);
		add(rButton);
		add(addInput);
		add(addLabel);
		add(addButton);
		add(indexToDel);
		add(delLabel);
		add(remapToggle);
		add(delBtn);
		add(name);
		add(rwLabel);
		add(rwIndex);
		add(rwNewInfo);
		add(rwBtn);

		name.setBounds(10, 5, 370, 25);
		rwLabel.setBounds(400, 200, 100, 25);
		delLabel.setBounds(400, 110, 100, 25);
		addLabel.setBounds(400, 5, 100, 25);

		remapToggle.setBounds(500, 135, 130, 25);

		informationDisplay.setBounds(10, 85, 370, 175);
		memoryIndex.setBounds(10, 35, 130, 40);
		addInput.setBounds(400, 30, 95, 75);
		indexToDel.setBounds(400, 135, 95, 25);
		rwNewInfo.setBounds(400, 255, 315, 40);
		rwIndex.setBounds(400, 225, 95, 25);

		lButton.setBounds(10, 270, 100, 25);
		rButton.setBounds(125, 270, 100, 25);
		addButton.setBounds(500, 80, 130, 25);
		delBtn.setBounds(400, 165, 95, 25);
		rwBtn.setBounds(505, 225, 100, 25);

		lButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// System.out.println(remapToggle.isSelected());

			}
		});
		rButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});
		delBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (remapToggle.isSelected())
				{
					memory.Delete(Integer.parseInt(indexToDel.getText()));
					memory.Remap();
				} else
				{
					memory.Delete(Integer.parseInt(indexToDel.getText()));
				}

			}
		});
		rwBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				memory.cells.get(Integer.parseInt(rwIndex.getText()));
				memory.Remap();

			}
		});

	}
}
