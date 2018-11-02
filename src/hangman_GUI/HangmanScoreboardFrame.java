package hangman_GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import hangman_logic.Scoreboard;
import hangman_logic.User;
import linked_data_structures.DoublyLinkedList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

/*
 *       Title: HangmanFrame
 * Description: Custom JFrame - displays the scoreboard when the 
 * 				player chooses to see it
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */
public class HangmanScoreboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea txtAreaScoreboard;
	
	public HangmanScoreboardFrame() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 595, 309);
		getContentPane().add(scrollPane);
		
		txtAreaScoreboard = new JTextArea();
		scrollPane.setViewportView(txtAreaScoreboard);
		txtAreaScoreboard.setFont(new Font("Monospaced", Font.PLAIN, 12));
	}//HangmanScoreboardPanel()

	public void printScores(Scoreboard scoreboard) {
		displayColumnHeadings();
		displayScoreboard(scoreboard);
	}//retrieveScores()
	
	private void displayColumnHeadings() {
		txtAreaScoreboard.append(String.format("%-40s%-15s%-15s\n", "User", "Total Games", "Total Wins"));
		String underline = "";
		for (int i = 0; i < 80; ++i)
			underline += "-";
		txtAreaScoreboard.append(String.format("%s\n", underline.toString()));
	}// displayColumnHeading()
	
	private void displayScoreboard(Scoreboard scoreboard) {
		User user = scoreboard.nextUser();
		while(user != null) {
			txtAreaScoreboard.append(String.format("%-40s%-15d%-15d\n", user.getUsername(), user.getTotalGames(),
					user.getTotalWins()));
			txtAreaScoreboard.append("\n");
			user = scoreboard.nextUser();
		}
		
		scoreboard.setCurrPlayer(0);
	}//displayScoreboard(DoublyLinkedList<User>)
}// HangmanScoreboardPanel class
