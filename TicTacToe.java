/*
  * Game is formatted, so that two players can play.
  * The first time a square is clicked, it will show an X; the next square clicked will be an O
  * For the purpose of this assignment, however, a button can be pressed multiple times alternating between X's and O's
  * even though this should not be a feature of an actual game of Tic-Tac-Toe
*/

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
				if(source != currentButton) currentButton.setEnabled(false);
			
				String lastTurn = currentButton.getText();
				
				if(lastTurn.equals("X")) source.setText("O");
				else if(lastTurn.equals("O")) source.setText("X");
				else source.setText("X");
				
				currentButton = source;
			}
			
			//check to see if there is three in a row
				
			if((_buttons[0].getText().equals(_buttons[1].getText()) && _buttons[1].getText().equals(_buttons[2].getText()) && _buttons[0].getText().equals("X"))
			|| (_buttons[0].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[8].getText()) && _buttons[0].getText().equals("X"))
			|| (_buttons[0].getText().equals(_buttons[3].getText()) && _buttons[3].getText().equals(_buttons[6].getText()) && _buttons[0].getText().equals("X"))
			|| (_buttons[1].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[7].getText()) && _buttons[1].getText().equals("X"))
			|| (_buttons[2].getText().equals(_buttons[5].getText()) && _buttons[5].getText().equals(_buttons[8].getText()) && _buttons[2].getText().equals("X"))
			|| (_buttons[2].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[6].getText()) && _buttons[2].getText().equals("X"))
			|| (_buttons[3].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[5].getText()) && _buttons[3].getText().equals("X"))
			|| (_buttons[6].getText().equals(_buttons[7].getText()) && _buttons[7].getText().equals(_buttons[8].getText()) && _buttons[6].getText().equals("X")))
			{
				//X's win
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "X's Won!\nStarting a new game automatically.");
				currentButton = new JButton();
				for(int i = 0; i < 9; i++)
				{
					_buttons[i].setText("_");
					_buttons[i].setEnabled(true);
				}
			}
			else
			{
				if((_buttons[0].getText().equals(_buttons[1].getText()) && _buttons[1].getText().equals(_buttons[2].getText()) && _buttons[0].getText().equals("O"))
				|| (_buttons[0].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[8].getText()) && _buttons[0].getText().equals("O"))
				|| (_buttons[0].getText().equals(_buttons[3].getText()) && _buttons[3].getText().equals(_buttons[6].getText()) && _buttons[0].getText().equals("O"))
				|| (_buttons[1].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[7].getText()) && _buttons[1].getText().equals("O"))
				|| (_buttons[2].getText().equals(_buttons[5].getText()) && _buttons[5].getText().equals(_buttons[8].getText()) && _buttons[2].getText().equals("O"))
				|| (_buttons[2].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[6].getText()) && _buttons[2].getText().equals("O"))
				|| (_buttons[3].getText().equals(_buttons[4].getText()) && _buttons[4].getText().equals(_buttons[5].getText()) && _buttons[3].getText().equals("O"))
				|| (_buttons[6].getText().equals(_buttons[7].getText()) && _buttons[7].getText().equals(_buttons[8].getText()) && _buttons[6].getText().equals("O")))
				{
					//O's win
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "O's Won!\nStarting a new game automatically.");
					currentButton = new JButton();
					for(int i = 0; i < 9; i++)
					{
						_buttons[i].setText("_");
						_buttons[i].setEnabled(true);
					}
				}
			}
		}
    	}
}
