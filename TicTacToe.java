import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TicTacToe 
{
    	JFrame _frame = new JFrame("Tic-Tac-Toe");
	JButton[] _buttons = new JButton[9];
	JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
	JButton currentButton = new JButton();
	JButton newGame = new JButton();

	public static void main(String[] args)
	{
		new TicTacToe(); 
	}
	
	public TicTacToe()
	{
		_frame.setSize(400, 400);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);
		
		for (int j=0; j<9; j++)
		{
			// Make a new button in the array location with text "_"
			_buttons[j] = new JButton("_");
			
			// Associate a new ButtonListener to the button (see below)
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			
			
			// Set the font on the button
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
			
			// Add this button to the _ttt panel
			_ttt.add(_buttons[j]);
		}
		
		newGame.setText("NEW GAME");
		newGame.setSize(new Dimension(400,400));
		_newPanel.add(newGame);
		
		ActionListener buttonListener = new ButtonListener();
		newGame.addActionListener(buttonListener);
			
		// Refresh window - otherwise we will not be able to see it
		// THIS IS A COMMON SOURCE OF BUGS!
		_frame.setVisible(true);
	}
	class ButtonListener implements ActionListener 
	{
		// Every time we click the button, it will perform
		// the following action.

		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
			
			if(source == newGame)
			{
				currentButton = new JButton();
				for(int i = 0; i < 9; i++)
				{
					_buttons[i].setText("_");
					_buttons[i].setEnabled(true);
				}
			}
			else 
			{
				if(source != currentButton)
					currentButton.setEnabled(false);
				
				currentButton = source;
				String currentText = source.getText();
				if(currentText.equals("X")) source.setText("O");
				else source.setText("X");
			}
		}
   	 }
}
