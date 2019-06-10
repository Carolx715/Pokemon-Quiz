package pokeGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MainPokeFrame {
	// variables for main panel
	static JLabel mainTitle, scoreTotal;
	static JLabel poke1, expl, poke2, lblLeague;
	static JButton section1, section2, section3, quitBtn, resultsBtn; // buttons
	// to select the section

	static Color neutral = Color.decode("0xDDDDDD"), bug = Color.decode("0xB7CA2B"), fairy = Color.decode("#FAC9EF"),
			flying = Color.decode("#DCBFF8"), correct = Color.decode("0x69B65A"), wrong = Color.decode("#DD5530");
	static DecimalFormat d = new DecimalFormat("#0.02f");

	static JPanel mainPanel;
	static JPanel topPanel, btnPanel;
	static JFrame mainFrame = new JFrame("Pokemon Trivia Quiz"); //
	static ImageIcon masterBall, league;
	static int score = 0, numAnswered = 0;

	static Font titleFont = new Font("Tahoma 11 Plain", Font.BOLD, 24);
	static Font queFont = new Font("Tahoma 11 Plain", Font.BOLD, 18);
	static Font otherFont = new Font("Tahoma 11 Plain", Font.PLAIN, 15);
	static Font quitFont = new Font("Tahoma 11 Plain", Font.BOLD, 15);
	static Font correctFont = new Font("Tahoma 11 Plain", Font.BOLD, 17);

	// variables for multiple choice
	static JLabel mainTitle1, MCScore, space2, que1Title, que2Title, que3Title, que4Title;
	static JLabel ask1, ask2, ask3, ask3b, ask4; // za questions
	static JButton que1, que2, que3, que4, quitBtn1; // buttons for the "main
	// multiple choice panel
	static JButton viewBtn1, viewBtn2, viewBtn3, viewBtn4; // checking the
	// answers
	static ButtonGroup group1, group2, group3, group4;
	static JRadioButton q1m[] = new JRadioButton[4];
	static JRadioButton q2m[] = new JRadioButton[4];
	static JRadioButton q3m[] = new JRadioButton[7];
	static JRadioButton q4m[] = new JRadioButton[7];
	static JPanel mainPanel1, mul1Panel, mul2Panel, mul3Panel, mul4Panel;
	static JFrame mainFrame1 = new JFrame("Main Panel"); //
	static JFrame mul1Frame = new JFrame("Question 1"); //
	static JFrame mul2Frame = new JFrame("Question 2"); // frames for the
	// different panels
	// (doing multiple
	// guiApps).
	static JFrame mul3Frame = new JFrame("Question 3"); //
	static JFrame mul4Frame = new JFrame("Question 4"); //
	static String ans[] = new String[4]; // possible answers for question 1
	static String ans2[] = new String[4]; // possible answers for question 2
	static String ans3[] = new String[7]; // possible answers for question 3
	static String ans4[] = new String[7]; // possible answers for question 4

	// variables for true and false
	static JFrame TF = new JFrame("True vs False");
	static JFrame subTF1 = new JFrame("True vs False Question 1");
	static JFrame subTF2 = new JFrame("True vs False Question 2");
	static JFrame subTF3 = new JFrame("True vs False Question 3");

	static JPanel mainTF, submainTF1, submainTF2, submainTF3;

	static JLabel lblTitle, tfq1, tfq2, tfq3;
	static JLabel output1, output2, output3, imgLabel, imgQ1, imgQ2, imgQ3;
	static JLabel scoreTF;
	static JButton tf1, tf2, tf3, b1, b2, b3;
	static JButton quit1;
	static ImageIcon img, img1, img2, img3;
	static JRadioButton true1, false1, true2, false2, true3, false3;
	static ButtonGroup Group1, Group2, Group3;

	// variables for Select All That Apply
	static int questionNumber = 0;
	static JLabel SATPScore;

	static JFrame SATPFrame;
	static JButton openQ1, openQ2, openQ3, exitSATP;
	static JButton[] submit = new JButton[3];
	static JLabel SATP;
	static Container contentPane;
	static JPanel mainPanelCar, q1Panel, q2Panel, q3Panel;
	static JPanel qPanel1, qPanel2, qPanel3;
	static JPanel tPanel1, tPanel2, tPanel3;
	static JPanel cardPanel = new JPanel(new CardLayout());

	static JCheckBox[] qCheckBox1 = new JCheckBox[5];
	static JCheckBox[] qCheckBox2 = new JCheckBox[5];
	static JCheckBox[] qCheckBox3 = new JCheckBox[5];

	static JLabel q1, q2, q3;

	static ImageIcon hm1, hm2, grass1, grass2, move1, move2;
	static JLabel grassHM, dragonHM, venusaur, shaymin, physical, special;

	// variables for Results
	static JFrame finalFrame;
	static JLabel lblInstruct, lblFeedback, lblFinalScore;
	static DefaultListModel listModel;
	static JList questionList;
	static JButton btnCheck;
	static String[] ansList = new String[10];

	/////////////////////////////////////////////////////////////////////////////////////////
	// Main Menu GUI (all) //
	/////////////////////////////////////////////////////////////////////////////////////////

	private static void guiApp() {
		ImageIcon masterBall = new ImageIcon("masterBall.png");
		poke1 = new JLabel("", JLabel.CENTER);
		poke1.setIcon(masterBall);
		poke2 = new JLabel("", JLabel.CENTER);
		poke2.setIcon(masterBall);
		league = new ImageIcon("pokemonLeague.jpg");

		lblLeague = new JLabel();
		lblLeague.setIcon(league);
		mainFrame.getLayeredPane().add(lblLeague, new Integer(Integer.MIN_VALUE));
		lblLeague.setBounds(-13, 0, league.getIconWidth(), league.getIconHeight());
		Container contain6 = mainFrame.getContentPane();
		((JPanel) contain6).setOpaque(false);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel(null);
		mainPanel.setLayout(new GridLayout(6, 1));
		mainPanel.setOpaque(false);
		// mainPanel.setBackground(Color.white);

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3));
		topPanel.setOpaque(false);
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 3));

		mainTitle = new JLabel("Pokémon Trivia Quiz", JLabel.CENTER);
		// slightly larger title font:
		mainTitle.setFont(new Font("Tahoma 11 Plain", Font.BOLD, 30));
		expl = new JLabel(
				"<html><body style='text-align: center'>The ultimate test of your Pokémon game knowledge!</html>",
				JLabel.CENTER);
		expl.setFont(queFont);

		section2 = new JButton("True or False (1pt each)");
		section2.setEnabled(true);
		section2.setFont(otherFont);

		section1 = new JButton("Multiple Choice (3pts each)");
		section1.setEnabled(true);
		section1.setFont(otherFont);

		section3 = new JButton("Select All That Apply (5pts each)");
		section3.setEnabled(true);
		section3.setFont(otherFont);

		scoreTotal = new JLabel("Total score: " + score, JLabel.CENTER);
		scoreTotal.setFont(queFont);

		quitBtn = new JButton("Quit");
		quitBtn.setEnabled(true);
		quitBtn.setFont(quitFont);

		resultsBtn = new JButton("See Results");
		resultsBtn.setEnabled(false);
		resultsBtn.setFont(quitFont);

		mainTitle.setForeground(Color.white);
		expl.setForeground(Color.white);
		scoreTotal.setForeground(Color.white);

		// comment these out on mac
		// section2.setForeground(Color.white);
		// section1.setForeground(Color.white);
		// section3.setForeground(Color.white);
		// quitBtn.setForeground(Color.white);
		// resultsBtn.setForeground(Color.white);

		ButtonHandler onClick = new ButtonHandler();
		section1.addActionListener(onClick);
		section1.setBackground(Color.black);
		section2.addActionListener(onClick);
		section2.setBackground(Color.black);
		section3.addActionListener(onClick);
		section3.setBackground(Color.black);
		quitBtn.addActionListener(onClick);
		quitBtn.setBackground(Color.black);
		resultsBtn.addActionListener(onClick);
		resultsBtn.setBackground(Color.black);

		topPanel.add(poke1);
		topPanel.add(expl);
		topPanel.add(poke2);

		btnPanel.add(section2);
		btnPanel.add(section1);
		btnPanel.add(section3);

		mainPanel.add(mainTitle);
		mainPanel.add(topPanel);
		mainPanel.add(btnPanel);
		mainPanel.add(scoreTotal);
		mainPanel.add(quitBtn);
		mainPanel.add(resultsBtn);

		mainFrame.getContentPane().add(mainPanel);
		mainFrame.pack();
		mainFrame.setSize(790, 665);
		mainFrame.setVisible(true);
		mainFrame.setLocation(270, 50);
		mainFrame.setResizable(false);
	}

	private static class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String whichOne = e.getActionCommand();

			if (whichOne.equals("Multiple Choice (3pts each)"))
				mainFrame1.setVisible(true);
			if (whichOne.equals("True or False (1pt each)"))
				TF.setVisible(true);
			if (whichOne.equals("Select All That Apply (5pts each)"))
				SATPFrame.setVisible(true);
			if (whichOne.equals("Quit"))
				System.exit(0);
			if (whichOne.equals("See Results")) {
				lblFinalScore.setText("Final Score: " + score + "/30");
				finalFrame.setVisible(true);
			}

		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	// True False GUI (Yuchen) //
	/////////////////////////////////////////////////////////////////////////////////////////

	private static void guiAppTF() {
		ImageIcon img = new ImageIcon("CutePokemon3.jpg");
		TF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel mainTF = new JPanel(null);
		mainTF.setBackground(Color.WHITE);
		lblTitle = new JLabel("Pokémon Quiz: True & False");
		lblTitle.setBounds(155, 20, 370, 50);
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(titleFont);
		imgLabel = new JLabel();
		imgLabel.setIcon(img);
		TF.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		Container contain = TF.getContentPane();
		((JPanel) contain).setOpaque(false);

		scoreTF = new JLabel("Current Score: " + score, JLabel.CENTER);
		scoreTF.setBounds(227, 70, 200, 50);
		scoreTF.setForeground(Color.white);
		scoreTF.setFont(queFont);

		tf1 = new JButton("Question 1");
		tf1.setFont(otherFont);
		tf1.setBounds(230, 135, 200, 50);
		tf1.setOpaque(true);

		tf2 = new JButton("Question 2");
		tf2.setFont(otherFont);
		tf2.setBounds(230, 205, 200, 50);
		tf2.setOpaque(true);

		tf3 = new JButton("Question 3");
		tf3.setFont(otherFont);
		tf3.setBounds(230, 275, 200, 50);
		tf3.setOpaque(true);

		quit1 = new JButton("Quit");
		quit1.setFont(quitFont);
		quit1.setBounds(230, 345, 200, 50);
		quit1.setOpaque(true);

		tf1.addActionListener(new TFPanelHandler());
		tf1.setBackground(Color.pink);
		tf2.addActionListener(new TFPanelHandler());
		tf2.setBackground(Color.pink);
		tf3.addActionListener(new TFPanelHandler());
		tf3.setBackground(Color.pink);
		quit1.addActionListener(new TFPanelHandler());
		quit1.setBackground(Color.pink);

		mainTF.add(lblTitle);
		mainTF.add(scoreTF);
		mainTF.add(tf1);
		mainTF.add(tf2);
		mainTF.add(tf3);
		mainTF.add(quit1);
		mainTF.add(imgLabel);

		TF.getContentPane().add(mainTF);
		TF.pack();
		TF.setSize(640, 470);
		TF.setVisible(false);

		// first question
		subTF1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ImageIcon img1 = new ImageIcon("images.png");

		submainTF1 = new JPanel(null);
		submainTF1.setBackground(Color.WHITE);

		tfq1 = new JLabel("A Timid nature is the best nature on a Machamp.");
		tfq1.setBounds(50, 1, 500, 150);
		tfq1.setFont(queFont);
		output1 = new JLabel("");
		output1.setBounds(170, 350, 400, 50);
		output1.setFont(otherFont);
		imgQ1 = new JLabel();
		imgQ1.setIcon(img1);
		subTF1.getLayeredPane().add(imgQ1, new Integer(Integer.MIN_VALUE));
		imgQ1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
		Container contain1 = subTF1.getContentPane();
		((JPanel) contain1).setOpaque(false);

		true1 = new JRadioButton("True", false);
		true1.setBounds(170, 120, 300, 50);
		true1.setBackground(Color.pink);

		false1 = new JRadioButton("False", false);
		false1.setBounds(170, 200, 300, 50);
		false1.setBackground(Color.pink);

		Group1 = new ButtonGroup();
		Group1.add(true1);
		Group1.add(false1);

		b1 = new JButton("Check");
		b1.setBounds(190, 300, 250, 40);

		TFScoreHandler1 c2 = new TFScoreHandler1();
		b1.addActionListener(c2);

		submainTF1.add(tfq1);
		submainTF1.add(true1);
		submainTF1.add(false1);
		submainTF1.add(b1);
		submainTF1.add(output1);
		submainTF1.add(imgQ1);

		subTF1.getContentPane().add(submainTF1);
		subTF1.pack();
		subTF1.setSize(600, 460);
		subTF1.setVisible(false);

		// question2
		subTF2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon img2 = new ImageIcon("LifeOrb.png");

		submainTF2 = new JPanel(null);
		submainTF2.setBackground(Color.WHITE);

		tfq2 = new JLabel("A Life Orb restores HP by 1/10th each turn at the cost of attack power.", JLabel.CENTER);
		tfq2.setFont(queFont);
		tfq2.setBounds(12, 1, 700, 150);
		output2 = new JLabel("");
		output2.setBounds(170, 350, 400, 50);
		output2.setFont(otherFont);
		imgQ2 = new JLabel();
		imgQ2.setIcon(img2);
		subTF2.getLayeredPane().add(imgQ2, new Integer(Integer.MIN_VALUE));
		imgQ2.setBounds(20, 20, img2.getIconWidth() + 20, img2.getIconHeight() + 20);

		true2 = new JRadioButton("True", false);
		true2.setBounds(200, 120, 300, 50);
		true2.setBackground(Color.pink);

		false2 = new JRadioButton("False", false);
		false2.setBounds(200, 200, 300, 50);
		false2.setBackground(Color.pink);

		Group2 = new ButtonGroup();
		Group2.add(true2);
		Group2.add(false2);

		b2 = new JButton("Check");
		b2.setBounds(220, 300, 250, 40);
		TFScoreHandler2 c3 = new TFScoreHandler2();
		b2.addActionListener(c3);

		submainTF2.add(tfq2);
		submainTF2.add(true2);
		submainTF2.add(false2);
		submainTF2.add(b2);
		submainTF2.add(output2);
		submainTF2.add(imgQ2);

		subTF2.getContentPane().add(submainTF2);
		subTF2.pack();
		subTF2.setSize(730, 450);
		subTF2.setVisible(false);

		// question 3
		subTF3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon img3 = new ImageIcon("TrickRoom.png");

		submainTF3 = new JPanel(null);
		submainTF3.setBackground(Color.white);

		Font myFont = new Font("TimesRoman BOLDITALIC", Font.BOLD, 15);

		tfq3 = new JLabel("Trick Room automatically swaps the items of your Pokemon with \nyour opponents’.",
				JLabel.CENTER);
		tfq3.setFont(myFont);
		tfq3.setBounds(10, 1, 670, 150);
		output3 = new JLabel("");
		output3.setBounds(170, 350, 400, 50);
		output3.setFont(otherFont);
		imgQ3 = new JLabel();
		imgQ3.setIcon(img3);
		subTF3.getLayeredPane().add(imgQ3, new Integer(Integer.MIN_VALUE));
		imgQ3.setBounds(-40, 0, img3.getIconWidth() - 40, img3.getIconHeight());
		Container contain3 = subTF3.getContentPane();
		((JPanel) contain3).setOpaque(false);

		true3 = new JRadioButton("True", false);
		true3.setBounds(170, 120, 300, 50);
		true3.setBackground(Color.pink);

		false3 = new JRadioButton("False", false);
		false3.setBounds(170, 200, 300, 50);
		false3.setBackground(Color.pink);

		Group3 = new ButtonGroup();
		Group3.add(true3);
		Group3.add(false3);

		b3 = new JButton("Check");
		b3.setBounds(190, 300, 250, 40);
		TFScoreHandler3 click3 = new TFScoreHandler3();
		b3.addActionListener(click3);

		submainTF3.add(tfq3);

		submainTF3.add(true3);
		submainTF3.add(false3);
		submainTF3.add(b3);
		submainTF3.add(output3);
		submainTF3.add(imgQ3);

		subTF3.getContentPane().add(submainTF3);
		subTF3.pack();
		subTF3.setSize(685, 430);
		subTF3.setVisible(false);

	}

	private static class TFPanelHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String whichO = e.getActionCommand();

			if (whichO.equals("Question 1"))
				subTF1.setVisible(true);
			if (whichO.equals("Question 2"))
				subTF2.setVisible(true);
			if (whichO.equals("Question 3"))
				subTF3.setVisible(true);
			if (whichO.equals("Quit"))
				TF.setVisible(false);
		}
	}

	private static class TFScoreHandler1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String w1 = e.getActionCommand();

			if (true1.isSelected() || false1.isSelected()) {
				if (false1.isSelected() && w1.equals("Check")) {
					ansList[0] = "False";
					score += 1;
					JOptionPane.showMessageDialog(null, "You got it! You have " + score + " points now.");
					output1.setText("You got it. You have " + score + " points now.");

					// indicates user answered that question correctly
					tf1.setBackground(correct);

					// updates score IF correct - if incorrect score doesn't
					// change
					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);

				} else if (true1.isSelected() && w1.equals("Check")) {
					ansList[0] = "True";
					JOptionPane.showMessageDialog(null, "Incorrect! You have " + score + " points now.");
					output1.setText("Incorrect! You have " + score + " points now.");
					tf1.setBackground(Color.red);
				}

				subTF1.setVisible(false);
				false1.setEnabled(false);
				true1.setEnabled(false);
				b1.setText("Quit");
				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);

			} else if (w1.equals("Quit")) {
				subTF1.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}
		}
	}

	private static class TFScoreHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String w2 = e.getActionCommand();
			if (true2.isSelected() || false2.isSelected()) {
				if (false2.isSelected() && w2.equals("Check")) {
					ansList[1] = "False";
					score += 1;
					JOptionPane.showMessageDialog(null, "You got it! You have " + score + " points now.");
					output2.setText("You got it. You have " + score + " points now.");

					// indicates user answered that question correctly
					tf2.setBackground(correct);

					// updates score IF correct
					// Also updates score in all places
					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);
				} else if (true2.isSelected() && w2.equals("Check")) {
					ansList[1] = "True";
					JOptionPane.showMessageDialog(null, "Incorrect! You have " + score + " points now.");
					output2.setText("Incorrect! You have " + score + " points now.");

					tf2.setBackground(Color.red);
				}

				subTF2.setVisible(false);
				false2.setEnabled(false);
				true2.setEnabled(false);
				b2.setText("Quit");
				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);

			} else if (w2.equals("Quit")) {
				subTF2.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}

		}
	}

	private static class TFScoreHandler3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String w3 = e.getActionCommand();
			if (true3.isSelected() || false3.isSelected()) {
				if (false3.isSelected() && w3.equals("Check")) {
					ansList[2] = "False";
					score += 1;
					JOptionPane.showMessageDialog(null, "You got it! You have " + score + " points now.");
					output3.setText("You got it. You have " + score + " points now.");

					// indicates user answered that question correctly
					tf3.setBackground(correct);

					// updates score IF correct - if incorrect score doesn't
					// change
					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);
				} else if (true3.isSelected() && w3.equals("Check")) {
					ansList[2] = "True";
					JOptionPane.showMessageDialog(null, "Incorrect! You have " + score + " points now.");
					output3.setText("You got it. You have " + score + " points now.");

					tf3.setBackground(Color.red);

				}
				subTF3.setVisible(false);
				false3.setEnabled(false);
				true3.setEnabled(false);
				b3.setText("Quit");
				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);

			} else if (w3.equals("Quit")) {
				subTF3.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Multiple Choice GUI (Chris) //
	/////////////////////////////////////////////////////////////////////////////////////////

	private static void guiAppMC() {
		ImageIcon rocks = new ImageIcon("WeatherRocks.jpg");
		ImageIcon special = new ImageIcon("Amnesia.png");

		mainFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		mainPanel1 = new JPanel();
		mainPanel1.setLayout(new GridLayout(8, 1));
		mainPanel1.setBackground(Color.white);

		mainTitle1 = new JLabel("Pokémon Quiz: Multiple Choice", JLabel.CENTER);
		mainTitle1.setFont(titleFont);

		MCScore = new JLabel("Current Score: " + score, JLabel.CENTER);
		MCScore.setFont(queFont);

		que1 = new JButton("Question 1");
		que1.setEnabled(true);
		que1.setFont(otherFont);

		que2 = new JButton("Question 2");
		que2.setEnabled(true);
		que2.setFont(otherFont);

		que3 = new JButton("Question 3");
		que3.setEnabled(true);
		que3.setFont(otherFont);

		que4 = new JButton("Question 4");
		que4.setEnabled(true);
		que4.setFont(otherFont);

		space2 = new JLabel();

		quitBtn1 = new JButton("Quit");
		quitBtn1.setEnabled(true);
		quitBtn1.setFont(quitFont);

		// comment these out on mac
		// que1.setForeground(Color.white);
		// que2.setForeground(Color.white);
		// que3.setForeground(Color.white);
		// que4.setForeground(Color.white);
		// quitBtn1.setForeground(Color.white);

		ButtonHandler1 onClick = new ButtonHandler1();
		que1.addActionListener(onClick);
		que1.setBackground(Color.black);
		que2.addActionListener(onClick);
		que2.setBackground(Color.black);
		que3.addActionListener(onClick);
		que3.setBackground(Color.black);
		que4.addActionListener(onClick);
		que4.setBackground(Color.black);
		quitBtn1.addActionListener(onClick);
		quitBtn1.setBackground(Color.black);

		mainPanel1.add(mainTitle1);
		mainPanel1.add(MCScore);
		mainPanel1.add(que1);
		mainPanel1.add(que2);
		mainPanel1.add(que3);
		mainPanel1.add(que4);
		mainPanel1.add(space2);
		mainPanel1.add(quitBtn1);

		mainFrame1.getContentPane().add(mainPanel1);
		mainFrame1.pack();
		mainFrame1.setSize(450, 330);
		mainFrame1.setLocation(460, 240);
		mainFrame1.setVisible(false);

		// First Question

		mul1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		mul1Panel = new JPanel();
		mul1Panel.setLayout(new GridLayout(7, 1));
		mul1Panel.setBackground(Color.white);

		que1Title = new JLabel("Question 1", JLabel.CENTER);
		que1Title.setFont(titleFont);

		ask1 = new JLabel("What does the Choice Band do?", JLabel.CENTER);
		ask1.setFont(queFont);

		ans[0] = ("<html>Allows you to choose any move to use regardless of status, Abilities, etc.</html>");
		ans[1] = ("Boosts Attack by 1.5X but limits you to one move");
		ans[2] = ("Extends weather effects to last 8 turns");
		ans[3] = ("<html>Boosts Special Defense by 1.5X but you can only use attacking moves</html>");

		group1 = new ButtonGroup();
		for (int i = 0; i < 4; i++) {
			q1m[i] = new JRadioButton(ans[i], false);
			q1m[i].setFont(otherFont);
			group1.add(q1m[i]);
		}

		viewBtn1 = new JButton("Check");
		viewBtn1.setEnabled(true);
		viewBtn1.setFont(otherFont);
		viewBtn1.setForeground(Color.black);

		MCPanelHandler1 onClick2 = new MCPanelHandler1();
		viewBtn1.addActionListener(onClick2);

		mul1Panel.add(que1Title);
		mul1Panel.add(ask1);

		for (int i = 0; i < 4; i++)
			mul1Panel.add(q1m[i]);

		mul1Panel.add(viewBtn1);

		mul1Frame.getContentPane().add(mul1Panel);
		mul1Frame.pack();
		mul1Frame.setSize(500, 400);
		mul1Frame.setVisible(false);

		// Second Question

		mul2Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		mul2Panel = new JPanel();
		mul2Panel.setLayout(new GridLayout(7, 1));
		mul2Panel.setBackground(Color.white);

		que2Title = new JLabel("Question 2", JLabel.CENTER);
		que2Title.setFont(titleFont);

		ask2 = new JLabel("What does the Wiki Berry do?", JLabel.CENTER);
		ask2.setFont(queFont);

		ans2[0] = ("Restores 1/4 HP at 1/2 HP or less");
		ans2[1] = ("Raises Speed by 1 stage at 1/4 HP or less");
		ans2[2] = ("<html>Restores 1/2 HP at 1/4 HP or less; confuses if Nature hinders Special Attack</html>");
		ans2[3] = ("<html>Restores 1/4 max HP after holder is hit by a supereffective move</html>");

		group2 = new ButtonGroup();
		for (int i = 0; i < 4; i++) {
			q2m[i] = new JRadioButton(ans2[i], false);
			q2m[i].setFont(otherFont);
			group2.add(q2m[i]);
		}

		viewBtn2 = new JButton("Check");
		viewBtn2.setEnabled(true);
		viewBtn2.setFont(otherFont);
		viewBtn2.setForeground(Color.black);

		MCPanelHandler2 onClick3 = new MCPanelHandler2();
		viewBtn2.addActionListener(onClick3);

		mul2Panel.add(que2Title);
		mul2Panel.add(ask2);

		for (int i = 0; i < 4; i++)
			mul2Panel.add(q2m[i]);

		mul2Panel.add(viewBtn2);

		mul2Frame.getContentPane().add(mul2Panel);
		mul2Frame.pack();
		mul2Frame.setSize(500, 400);
		mul2Frame.setVisible(false);

		// Third Question

		mul3Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		mul3Panel = new JPanel();
		mul3Panel.setLayout(new GridLayout(11, 1));
		mul3Panel.setBackground(Color.white);
		mul3Panel.setOpaque(false);

		que3Title = new JLabel("Question 3", JLabel.CENTER);
		que3Title.setFont(titleFont);

		ask3 = new JLabel("In what generation were the effects of the abilities Drizzle, Drought,", JLabel.CENTER);
		ask3b = new JLabel("Sand Stream, and Snow Warning reduced to 5 turns?", JLabel.CENTER);
		ask3.setFont(queFont);
		ask3b.setFont(queFont);

		ans3[0] = ("Gen I");
		ans3[1] = ("Gen II");
		ans3[2] = ("Gen III");
		ans3[3] = ("Gen IV");
		ans3[4] = ("Gen V");
		ans3[5] = ("Gen VI");
		ans3[6] = ("Gen VII");

		group3 = new ButtonGroup();
		for (int i = 0; i < 7; i++) {
			q3m[i] = new JRadioButton(ans3[i], false);
			q3m[i].setFont(otherFont);
			group3.add(q3m[i]);
		}

		viewBtn3 = new JButton("Check");
		viewBtn3.setEnabled(true);
		viewBtn3.setFont(otherFont);
		viewBtn3.setForeground(Color.black);

		MCPanelHandler3 onClick4 = new MCPanelHandler3();
		viewBtn3.addActionListener(onClick4);

		mul3Panel.add(que3Title);
		mul3Panel.add(ask3);
		mul3Panel.add(ask3b);

		for (int i = 0; i < 7; i++)
			mul3Panel.add(q3m[i]);

		mul3Panel.add(viewBtn3);

		mul3Frame.getContentPane().add(mul3Panel);
		mul3Frame.pack();
		mul3Frame.setSize(700, 550);
		mul3Frame.setVisible(false);

		JLabel weatherRocks = new JLabel();
		weatherRocks.setIcon(rocks);
		mul3Frame.getLayeredPane().add(weatherRocks, new Integer(Integer.MIN_VALUE));
		weatherRocks.setBounds(200, 150, rocks.getIconWidth(), rocks.getIconHeight());
		Container contain = mul3Frame.getContentPane();
		((JPanel) contain).setOpaque(false);

		// Fourth Question
		JLabel amnesia = new JLabel();
		amnesia.setIcon(special);
		mul4Frame.getLayeredPane().add(amnesia, new Integer(Integer.MIN_VALUE));
		amnesia.setBounds(300, 115, special.getIconWidth(), special.getIconHeight());
		Container contain1 = mul4Frame.getContentPane();
		((JPanel) contain1).setOpaque(false);

		mul4Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		mul4Panel = new JPanel();
		mul4Panel.setLayout(new GridLayout(10, 1));
		mul4Panel.setBackground(Color.white);
		mul4Panel.setOpaque(false);

		que4Title = new JLabel("Question 4", JLabel.CENTER);
		que4Title.setFont(titleFont);

		ask4 = new JLabel("In what generation was the Special stat split into Sp. Atk and Sp. Def?", JLabel.CENTER);
		ask4.setFont(queFont);

		ans4[0] = ("Gen I");
		ans4[1] = ("Gen II");
		ans4[2] = ("Gen III");
		ans4[3] = ("Gen IV");
		ans4[4] = ("Gen V");
		ans4[5] = ("Gen VI");
		ans4[6] = ("Gen VII");

		group4 = new ButtonGroup();
		for (int i = 0; i < 7; i++) {
			q4m[i] = new JRadioButton(ans4[i], false);
			q4m[i].setFont(otherFont);
			group4.add(q4m[i]);
		}

		viewBtn4 = new JButton("Check");
		viewBtn4.setEnabled(true);
		viewBtn4.setFont(otherFont);
		viewBtn4.setForeground(Color.black);

		MCPanelHandler4 onClick5 = new MCPanelHandler4();
		viewBtn4.addActionListener(onClick5);

		mul4Panel.add(que4Title);
		mul4Panel.add(ask4);

		for (int i = 0; i < 7; i++)
			mul4Panel.add(q4m[i]);

		mul4Panel.add(viewBtn4);

		mul4Frame.getContentPane().add(mul4Panel);
		mul4Frame.pack();
		mul4Frame.setSize(700, 550);
		mul4Frame.setVisible(false);
	}

	private static class ButtonHandler1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String whichOne = e.getActionCommand();

			if (whichOne.equals("Question 1"))
				mul1Frame.setVisible(true);
			if (whichOne.equals("Question 2"))
				mul2Frame.setVisible(true);
			if (whichOne.equals("Question 3"))
				mul3Frame.setVisible(true);
			if (whichOne.equals("Question 4"))
				mul4Frame.setVisible(true);
			if (whichOne.equals("Quit"))
				mainFrame1.setVisible(false);
		}
	}

	private static class MCPanelHandler1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String wO = e.getActionCommand();

			if (wO.equals("Check")
					&& (q1m[0].isSelected() || q1m[1].isSelected() || q1m[2].isSelected() || q1m[3].isSelected())) {
				// highlight correct answer
				q1m[1].setFont(correctFont);
				q1m[1].setForeground(correct);

				if (wO.equals("Check") && (q1m[0].isSelected() || q1m[2].isSelected() || q1m[3].isSelected())) {
					JOptionPane.showMessageDialog(null, "Incorrect. You have " + score + " points.");
					que1.setBackground(Color.red);
				}

				else if (wO.equals("Check") && q1m[1].isSelected()) {
					score = score + 3;

					JOptionPane.showMessageDialog(null, "Correct. You have " + score + " points.");
					que1.setBackground(Color.green);

					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);

				}

				for (int i = 0; i < q1m.length; i++)
					q1m[i].setEnabled(false);
				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);

				// add user answer to ansList
				for (int i = 0; i < q1m.length; i++) {
					if (q1m[i].isSelected())
						ansList[3] = q1m[i].getText();

					// override pesky html tags
					if (q1m[0].isSelected())
						ansList[3] = "Allows you to choose any move to use regardless of status, Abilities, etc.";
					else if (q1m[3].isSelected())
						ansList[3] = "Boosts Special Defense by 1.5X but you can only use attacking moves";
				}

				viewBtn1.setText("Quit");
				mul1Frame.setVisible(false);
			} else if (wO.equals("Quit")) {
				mul1Frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}

		}
	}

	private static class MCPanelHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String wO = e.getActionCommand();

			if (wO.equals("Check")
					&& (q2m[0].isSelected() || q2m[1].isSelected() || q2m[2].isSelected() || q2m[3].isSelected())) {
				// highlight correct answer
				q2m[2].setFont(correctFont);
				q2m[2].setForeground(correct);

				if (wO.equals("Check") && (q2m[0].isSelected() || q2m[1].isSelected() || q2m[3].isSelected())) {
					JOptionPane.showMessageDialog(null, "Incorrect. You have " + score + " points.");
					que2.setBackground(Color.red);
				} else if (wO.equals("Check") && q2m[2].isSelected()) {
					score = score + 3;

					JOptionPane.showMessageDialog(null, "Correct. You have " + score + " points.");
					que2.setBackground(Color.green);

					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);

				}
				for (int i = 0; i < q2m.length; i++)
					q2m[i].setEnabled(false);

				// add user answer to ansList
				for (int i = 0; i < q2m.length; i++) {
					if (q2m[i].isSelected())
						ansList[4] = q2m[i].getText();

					// override pesky html tags
					if (q2m[2].isSelected())
						ansList[4] = "Restores 1/2 HP at 1/4 HP or less; confuses if Nature hinders Special Attack";
					else if (q2m[3].isSelected())
						ansList[4] = "Restores 1/4 HP after holder is hit by a supereffective move";
				}

				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);
				mul2Frame.setVisible(false);
				viewBtn2.setText("Quit");
			} else if (wO.equals("Quit")) {
				mul2Frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}
		}

	}

	private static class MCPanelHandler3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String wO = e.getActionCommand();

			if (wO.equals("Check") && (q3m[0].isSelected() || q3m[1].isSelected() || q3m[2].isSelected()
					|| q3m[3].isSelected() || q3m[4].isSelected() || q3m[5].isSelected() || q3m[6].isSelected())) {
				// highlight correct answer
				q3m[5].setFont(correctFont);
				q3m[5].setForeground(correct);

				if (wO.equals("Check") && (q3m[0].isSelected() || q3m[1].isSelected() || q3m[2].isSelected()
						|| q3m[3].isSelected() || q3m[4].isSelected() || q3m[6].isSelected())) {
					JOptionPane.showMessageDialog(null, "Incorrect. You have " + score + " points.");
					que3.setBackground(Color.red);
				} else if (wO.equals("Check") && q3m[5].isSelected()) {
					score = score + 3;

					JOptionPane.showMessageDialog(null, "Correct. You have " + score + " points.");
					que3.setBackground(Color.green);

					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);

				}
				for (int i = 0; i < q3m.length; i++)
					q3m[i].setEnabled(false);

				// add user answer to ansList
				for (int i = 0; i < q3m.length; i++)
					if (q3m[i].isSelected())
						ansList[5] = q3m[i].getText();

				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);
				viewBtn3.setText("Quit");
				mul3Frame.setVisible(false);
			} else if (wO.equals("Quit")) {
				mul3Frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}
		}
	}

	private static class MCPanelHandler4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String wO = e.getActionCommand();

			if (wO.equals("Check") && (q4m[0].isSelected() || q4m[1].isSelected() || q4m[2].isSelected()
					|| q4m[3].isSelected() || q4m[4].isSelected() || q4m[5].isSelected() || q4m[6].isSelected())) {
				// highlight correct answer
				q4m[1].setFont(correctFont);
				q4m[1].setForeground(correct);

				if (wO.equals("Check") && (q4m[0].isSelected() || q4m[2].isSelected() || q4m[3].isSelected()
						|| q4m[4].isSelected() || q4m[5].isSelected() || q4m[6].isSelected())) {
					JOptionPane.showMessageDialog(null, "Incorrect. You have " + score + " points.");
					que4.setBackground(Color.red);
				}

				else if (wO.equals("Check") && q4m[1].isSelected()) {
					score = score + 3;
					JOptionPane.showMessageDialog(null, "Correct. You have " + score + " points.");
					que4.setBackground(Color.green);

					scoreTF.setText("Current Score: " + score);
					MCScore.setText("Current Score: " + score);
					SATPScore.setText("Current Score: " + score);
					scoreTotal.setText("Total Score: " + score);

				}
				for (int i = 0; i < q4m.length; i++)
					q4m[i].setEnabled(false);

				// add user answer to ansList
				for (int i = 0; i < q4m.length; i++)
					if (q4m[i].isSelected())
						ansList[6] = q4m[i].getText();

				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);
				mul4Frame.setVisible(false);
				viewBtn4.setText("Quit");
			} else if (wO.equals("Quit")) {
				mul4Frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "You must select one option.");
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Select All That Apply GUI (Carol) //
	/////////////////////////////////////////////////////////////////////////////////////////

	private static void guiAppSATP() {
		// select all that apply
		// create and set up frames
		SATPFrame = new JFrame("Select All That Apply");
		SATPFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// create and set up panels
		mainPanelCar = new JPanel(new GridLayout(6, 1));
		q1Panel = new JPanel(new BorderLayout());
		q2Panel = new JPanel(new BorderLayout());
		q3Panel = new JPanel(new BorderLayout());

		qPanel1 = new JPanel(new GridLayout(5, 1));
		qPanel2 = new JPanel(new GridLayout(5, 1));
		qPanel3 = new JPanel(new GridLayout(5, 1));

		tPanel1 = new JPanel(new BorderLayout());
		tPanel2 = new JPanel(new GridLayout(1, 3));
		tPanel3 = new JPanel(new GridLayout(1, 3));

		// objects for mainPanel
		SATP = new JLabel("Pokémon Quiz - Select All That Apply", JLabel.CENTER);
		SATP.setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 20));
		SATP.setBackground(Color.white);
		SATP.setOpaque(true);
		SATPScore = new JLabel("Current Score: " + score, JLabel.CENTER);
		SATPScore.setFont(queFont);
		SATPScore.setBackground(Color.white);
		SATPScore.setOpaque(true);
		openQ1 = new JButton("Question 1 (5pts)");
		openQ2 = new JButton("Question 2 (5pts)");
		openQ3 = new JButton("Question 3 (5pts)");
		exitSATP = new JButton("Quit");
		exitSATP.setFont(quitFont);

		openQ1.setBackground(neutral);
		openQ1.setOpaque(true);
		openQ1.addActionListener(new PanelHandler());

		openQ2.setBackground(neutral);
		openQ2.setOpaque(true);
		openQ2.addActionListener(new PanelHandler());

		openQ3.setBackground(neutral);
		openQ3.setOpaque(true);
		openQ3.addActionListener(new PanelHandler());

		exitSATP.setBackground(neutral);
		exitSATP.setOpaque(true);
		exitSATP.addActionListener(new PanelHandler());

		mainPanelCar.add(SATP);
		mainPanelCar.add(SATPScore);
		mainPanelCar.add(openQ1);
		mainPanelCar.add(openQ2);
		mainPanelCar.add(openQ3);
		mainPanelCar.add(exitSATP);

		////////////////////////////////////////////////////////////////////

		// objects for q1Panel
		q1 = new JLabel("<html>1.\tWhat HMs became TMs in Generation V? Select all that apply.</html>", JLabel.CENTER);
		q1.setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 20));
		q1.setBackground(fairy);
		q1.setOpaque(true);

		qCheckBox1[0] = new JCheckBox("Surf", false);
		qCheckBox1[1] = new JCheckBox("Rock Smash", false);
		qCheckBox1[2] = new JCheckBox("Volt Switch", false);
		qCheckBox1[3] = new JCheckBox("Rock Climb", false);
		qCheckBox1[4] = new JCheckBox("Defog", false);

		for (int i = 0; i < qCheckBox1.length; i++) {
			qCheckBox1[i].setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 15));
			qCheckBox1[i].setBackground(fairy);
			qCheckBox1[i].setOpaque(true);
		}

		for (int i = 0; i < submit.length; i++) {
			submit[i] = new JButton("Submit");
			submit[i].setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 30));
			submit[i].addActionListener(new QuestionHandler());
			submit[i].setOpaque(true);

		}
		submit[0].setBackground(fairy);

		// images for q1Panel
		hm1 = new ImageIcon("grassTM.png");
		grassHM = new JLabel(hm1);
		hm2 = new ImageIcon("dragonTM.png");
		dragonHM = new JLabel(hm2);

		tPanel1.add(grassHM, BorderLayout.LINE_START);
		tPanel1.add(q1, BorderLayout.CENTER);
		tPanel1.add(dragonHM, BorderLayout.LINE_END);
		tPanel1.setBackground(fairy);
		tPanel1.setOpaque(true);

		q1Panel.add(tPanel1, BorderLayout.PAGE_START);

		// add things to qPanel1
		for (int i = 0; i < qCheckBox1.length; i++)
			qPanel1.add(qCheckBox1[i]);

		qPanel1.setBackground(fairy);
		qPanel1.setOpaque(true);
		q1Panel.add(qPanel1, BorderLayout.CENTER);
		q1Panel.add(submit[0], BorderLayout.PAGE_END);
		q1Panel.setBackground(fairy);
		q1Panel.setOpaque(true);

		//////////////////////////////////////////////////////////

		// objects for q2Panel
		q2 = new JLabel("<html>2.\tSelect all the grass types from the following list:</html>");
		q2.setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 20));
		q2.setBackground(bug);
		q2.setOpaque(true);

		qCheckBox2[0] = new JCheckBox("Pineco", false);
		qCheckBox2[1] = new JCheckBox("Caterpie", false);
		qCheckBox2[2] = new JCheckBox("Burmy - Plant Cloak", false);
		qCheckBox2[3] = new JCheckBox("Nincada", false);
		qCheckBox2[4] = new JCheckBox("Florges", false);

		for (int i = 0; i < qCheckBox2.length; i++) {
			qCheckBox2[i].setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 15));
			qCheckBox2[i].setBackground(bug);
			qCheckBox2[i].setOpaque(true);
		}

		submit[1].setBackground(bug);

		// images for q2Panel
		grass1 = new ImageIcon("venusaur4.png");
		venusaur = new JLabel(grass1);
		venusaur.setBackground(bug);
		venusaur.setOpaque(true);
		grass2 = new ImageIcon("shaymin3.png");
		shaymin = new JLabel(grass2);
		shaymin.setBackground(bug);
		shaymin.setOpaque(true);

		tPanel2.add(venusaur, BorderLayout.LINE_START);
		tPanel2.add(q2, BorderLayout.CENTER);
		tPanel2.add(shaymin, BorderLayout.LINE_END);
		tPanel2.setBackground(bug);
		tPanel2.setOpaque(true);

		q2Panel.add(tPanel2, BorderLayout.PAGE_START);
		q2Panel.setBackground(bug);
		q2Panel.setOpaque(true);

		// add things to qPanel2
		for (int i = 0; i < qCheckBox2.length; i++)
			qPanel2.add(qCheckBox2[i]);

		qPanel2.setBackground(bug);
		qPanel2.setOpaque(true);
		q2Panel.add(qPanel2, BorderLayout.CENTER);
		q2Panel.add(submit[1], BorderLayout.PAGE_END);

		//////////////////////////////////////////////////////////
		// objects for q3Panel
		q3 = new JLabel("<html>3.\tSelect all the moves that are Z-Moves from the following list:</html>");
		q3.setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 20));
		q3.setBackground(flying);
		q3.setOpaque(true);

		qCheckBox3[0] = new JCheckBox("Twinkle Tackle", false);
		qCheckBox3[1] = new JCheckBox("Let’s Snuggle Forever", false);
		qCheckBox3[2] = new JCheckBox("Leaf Storm", false);
		qCheckBox3[3] = new JCheckBox("Extreme Speed", false);
		qCheckBox3[4] = new JCheckBox("All Out Pummelling", false);

		for (int i = 0; i < qCheckBox3.length; i++) {
			qCheckBox3[i].setFont(new Font("Tahoma 11 Plain", Font.PLAIN, 15));
			qCheckBox3[i].setBackground(flying);
			qCheckBox3[i].setOpaque(true);
		}

		submit[2].setBackground(flying);

		// images for q3Panel
		move1 = new ImageIcon("physical.png");
		physical = new JLabel(move1);
		physical.setBackground(flying);
		physical.setOpaque(true);
		move2 = new ImageIcon("special.png");
		special = new JLabel(move2);
		special.setBackground(flying);
		special.setOpaque(true);

		tPanel3.add(physical, BorderLayout.LINE_START);
		tPanel3.add(q3, BorderLayout.CENTER);
		tPanel3.add(special, BorderLayout.LINE_END);
		tPanel3.setBackground(flying);
		tPanel3.setOpaque(true);

		q3Panel.add(tPanel3, BorderLayout.PAGE_START);

		// add things to qPanel3
		for (int i = 0; i < qCheckBox3.length; i++)
			qPanel3.add(qCheckBox3[i]);

		qPanel3.setBackground(flying);
		qPanel3.setOpaque(true);
		q3Panel.add(qPanel3, BorderLayout.CENTER);
		q3Panel.add(submit[2], BorderLayout.PAGE_END);
		q3Panel.setBackground(flying);
		q3Panel.setOpaque(true);

		// add cards to cardPanel
		cardPanel.add(mainPanelCar);
		cardPanel.add(q1Panel, "Question 1");
		cardPanel.add(q2Panel, "Question 2");
		cardPanel.add(q3Panel, "Question 3");
		// add mainPanel to frame and display window
		contentPane = SATPFrame.getContentPane();
		contentPane.add(cardPanel);
		SATPFrame.pack();
		SATPFrame.setSize(500, 400);
		SATPFrame.setLocation(800, 10);
		SATPFrame.setVisible(false);

	}

	private static class PanelHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String whichOne = e.getActionCommand();
			// contentPane.remove(mainPanel);
			mainPanelCar.setVisible(false);

			if (whichOne.equals("Question 1 (5pts)") || whichOne.equals("Question 1 (Submitted)")) {
				q1Panel.setVisible(true);
				questionNumber = 1;

			} else if (whichOne.equals("Question 2 (5pts)") || whichOne.equals("Question 2 (Submitted)")) {
				q2Panel.setVisible(true);
				questionNumber = 2;

			} else if (whichOne.equals("Question 3 (5pts)") || whichOne.equals("Question 3 (Submitted)")) {
				q3Panel.setVisible(true);
				questionNumber = 3;
			} else if (whichOne.equals("Quit")) {
				SATPFrame.setVisible(false);
			}
		}
	}

	private static class QuestionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String whichOne = e.getActionCommand();
			int numCorrect = 0;

			if (whichOne.equals("Submit")) {
				if (questionNumber == 1) {
					if (!qCheckBox1[0].isSelected()) {
						score++;
						numCorrect++;
					}
					if (qCheckBox1[1].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox1[2].isSelected()) {
						score++;
						numCorrect++;
					}
					if (qCheckBox1[3].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox1[4].isSelected()) {
						score++;
						numCorrect++;
					}
					// for now I'm only setting the ones that should have been
					// selected to green, maybe set the ones that should have
					// been not selected to red later?
					qCheckBox1[1].setForeground(correct);
					qCheckBox1[1].setFont(new Font("Tahoma 11 Plain", Font.BOLD, 17));
					qCheckBox1[3].setForeground(correct);
					qCheckBox1[3].setFont(new Font("Tahoma 11 Plain", Font.BOLD, 17));

					submit[0].setText("Return to Menu");
					openQ1.setText("Question 1 (Submitted)");

					// add user answer to ansList (with concatenation this time)
					String temp = "";
					for (int i = 0; i < qCheckBox1.length; i++) {
						if (qCheckBox1[i].isSelected()) {
							if (temp.equals(""))
								temp = temp + qCheckBox1[i].getText();
							else
								temp = temp + ", " + qCheckBox1[i].getText();
						}
					}
					// if user selected nothing
					if (temp.equals(""))
						ansList[7] = "None of the given answers";
					else
						ansList[7] = temp;

				} else if (questionNumber == 2) {
					if (!qCheckBox2[0].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox2[1].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox2[2].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox2[3].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox2[4].isSelected()) {
						score++;
						numCorrect++;
					}
					// set ones that should have been selected to green (none)

					submit[1].setText("Return to Menu");
					openQ2.setText("Question 2 (Submitted)");

					// add user answer to ansList (with concatenation this time)
					String temp = "";
					for (int i = 0; i < qCheckBox2.length; i++) {
						if (qCheckBox2[i].isSelected()) {
							if (temp.equals(""))
								temp = temp + qCheckBox2[i].getText();
							else
								temp = temp + ", " + qCheckBox2[i].getText();
						}
					}
					// if user selected nothing
					if (temp.equals(""))
						ansList[8] = "None of the given answers";
					else
						ansList[8] = temp;
				} else if (questionNumber == 3) {
					if (qCheckBox3[0].isSelected()) {
						score++;
						numCorrect++;
					}
					if (qCheckBox3[1].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox3[2].isSelected()) {
						score++;
						numCorrect++;
					}
					if (!qCheckBox3[3].isSelected()) {
						score++;
						numCorrect++;
					}
					if (qCheckBox3[4].isSelected()) {
						score++;
						numCorrect++;
					}
					// set ones that should have been selected to green
					qCheckBox3[0].setForeground(correct);
					qCheckBox3[0].setFont(new Font("Tahoma 11 Plain", Font.BOLD, 17));
					qCheckBox3[1].setForeground(correct);
					qCheckBox3[1].setFont(new Font("Tahoma 11 Plain", Font.BOLD, 17));
					qCheckBox3[4].setForeground(correct);
					qCheckBox3[4].setFont(new Font("Tahoma 11 Plain", Font.BOLD, 17));

					submit[2].setText("Return to Menu");
					openQ3.setText("Question 3 (Submitted)");

					// add user answer to ansList (with concatenation this time)
					String temp = "";
					for (int i = 0; i < qCheckBox3.length; i++) {
						if (qCheckBox3[i].isSelected()) {
							if (temp.equals(""))
								temp = temp + qCheckBox3[i].getText();
							else
								temp = temp + ", " + qCheckBox3[i].getText();
						}
					}
					// if user selected nothing
					if (temp.equals(""))
						ansList[9] = "None of the given answers";
					else
						ansList[9] = temp;
				}
				JOptionPane.showMessageDialog(null,
						"You got " + numCorrect + " correct out of 5\nCurrent score: " + score);

				scoreTF.setText("Current Score: " + score);
				MCScore.setText("Current Score: " + score);
				SATPScore.setText("Current Score: " + score);
				scoreTotal.setText("Total Score: " + score);
				numAnswered++;

				// IF they have answered all 10
				if (numAnswered >= 10)
					resultsBtn.setEnabled(true);

				// now set the checkboxes to disabled because I want them to see
				// it be green for a little bit
				if (questionNumber == 1) {
					for (int i = 0; i < 5; i++)
						qCheckBox1[i].setEnabled(false);
				} else if (questionNumber == 2) {
					for (int i = 0; i < 5; i++)
						qCheckBox2[i].setEnabled(false);
				} else if (questionNumber == 3) {
					for (int i = 0; i < 5; i++)
						qCheckBox3[i].setEnabled(false);
				}

			} else if (whichOne.equals("Return to Menu")) {
				if (questionNumber == 1)
					q1Panel.setVisible(false);
				else if (questionNumber == 2)
					q2Panel.setVisible(false);
				else if (questionNumber == 3)
					q3Panel.setVisible(false);
				mainPanelCar.setVisible(true);

				questionNumber = 0;
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Final Panel //
	/////////////////////////////////////////////////////////////////////////////////////////

	private static void guiAppAns() {

		// create and set up window
		finalFrame = new JFrame("Answers");
		finalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// create components
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		lblFinalScore = new JLabel("Final Score: " + score, JLabel.CENTER);
		lblFinalScore.setFont(titleFont);

		lblInstruct = new JLabel("Correct Answers:", JLabel.CENTER);
		lblInstruct.setFont(queFont);

		listModel = new DefaultListModel();
		listModel.addElement("TF Question #1");
		listModel.addElement("TF Question #2");
		listModel.addElement("TF Question #3");
		listModel.addElement("Multiple Choice Question #1");
		listModel.addElement("Multiple Choice Question #2");
		listModel.addElement("Multiple Choice Question #3");
		listModel.addElement("Multiple Choice Question #4");
		listModel.addElement("Select All That Apply Question #1");
		listModel.addElement("Select All That Apply Question #2");
		listModel.addElement("Select All That Apply Question #3");
		btnCheck = new JButton("Show Answer");

		questionList = new JList(listModel);
		questionList.setFont(otherFont);
		questionList.setVisibleRowCount(5);
		questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane listScroll = new JScrollPane(questionList);

		// create a new ButtonHandler instance
		ShowAnswers onClick = new ShowAnswers();
		btnCheck.addActionListener(onClick);

		panel.add(lblFinalScore);
		panel.add(lblInstruct);
		panel.add(listScroll);
		panel.add(btnCheck);

		// add panel to frame and display window
		Container contentPane = finalFrame.getContentPane();
		contentPane.add(panel);
		finalFrame.pack();
		finalFrame.setSize(300, 300);
		finalFrame.setVisible(false);
	}

	private static class ShowAnswers implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String question = (String) questionList.getSelectedValue();

			try {
				if (question.equals("TF Question #1"))
					JOptionPane.showMessageDialog(null,
							"Q: A Timid nature is the best nature on a Machamp.\nYour Answer: " + ansList[0]
									+ "\nA: False");
				else if (question.equals("TF Question #2"))
					JOptionPane.showMessageDialog(null,
							"Q: A Life Orb restores HP by 1/10th each turn at the cost of attack power.\nYour Answer: "
									+ ansList[1] + "\nA: False");
				else if (question.equals("TF Question #3"))
					JOptionPane.showMessageDialog(null,
							"Q: Trick Room swaps the items of your Pokemon with your opponents’.\nYour Answer: "
									+ ansList[2] + "\nA: False");
				else if (question.equals("Multiple Choice Question #1")) {
					JOptionPane.showMessageDialog(null, "Q: What does the Choice Band do?\nYour Answer: " + ansList[3]
							+ "\nA: Boosts Attack by 1.5X but limits you to one move");
				} else if (question.equals("Multiple Choice Question #2")) {
					JOptionPane.showMessageDialog(null, "Q: What does the Wiki Berry do?\nYour Answer: " + ansList[4]
							+ "\nA: Restores 1/2 HP at 1/4 HP or less; confuses if Nature hinders Special Attack");
				} else if (question.equals("Multiple Choice Question #3")) {
					JOptionPane.showMessageDialog(null,
							"Q: In what generation were the effects of the abilities Drizzle, Drought, \nSand Stream, and Snow Warning reduced to 5 turns?\nYour Answer: "
									+ ansList[5] + "\nA: Gen VI");
				} else if (question.equals("Multiple Choice Question #4")) {
					JOptionPane.showMessageDialog(null,
							"Q: In what generation was the Special stat split into Sp. Atk and Sp. Def?\nYour Answer: "
									+ ansList[6] + "\nA: Gen II");
				} else if (question.equals("Select All That Apply Question #1")) {
					JOptionPane.showMessageDialog(null,
							"Q: What HMs became TMs in Generation V? Select all that apply.\nYour Answer: " + ansList[7]
									+ "\nA: Rock Smash, Rock Climb");
				} else if (question.equals("Select All That Apply Question #2")) {
					JOptionPane.showMessageDialog(null,
							"Q: Select all the grass types from the following list:\nYour Answer: " + ansList[8]
									+ "\nA: None of the given answers");
				} else if (question.equals("Select All That Apply Question #3")) {
					JOptionPane.showMessageDialog(null,
							"Q: Select all the moves that are Z-Moves from the following list:\nYour Answer: "
									+ ansList[9] + "\nA: Twinkle Tackle, Let's Snuggle Forever, All Out Pummelling");
				}
			} catch (NullPointerException x) {
				JOptionPane.showMessageDialog(null, "Select a question to see the answer.");
			}
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				guiApp();
				guiAppTF();
				guiAppMC();
				guiAppSATP();
				guiAppAns();
			}
		});
	} // main method
}