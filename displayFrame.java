package com.assignment.clothes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox; 
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import java.applet.*;
import java.io.*;  
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class displayFrame extends JFrame implements ActionListener
{
	// JPanels
	public JPanel contentPane;
	
	// JButtons
	public JButton btnRandom;
	public JButton btnReset;	
	public JButton trousersView;
	public JButton shirtsView;
	public JButton jacketsView;
	public JButton shoesView;
	public JButton sweatersView;
	
	// JCheckboxes
	public JCheckBox keepTrousers;
	public JCheckBox keepShirts;
	public JCheckBox keepJackets;
	public JCheckBox keepShoes;
	public JCheckBox keepSweaters;
	
	// JLabels
	public JLabel trousersLabel;
	public JLabel tshirtsLabel;
	public JLabel jacketsLabel;
	public JLabel shoesLabel;
	public JLabel sweatersLabel;
	public JLabel priceOutputLabel;
	public JLabel shopImage;
	public JLabel euroLabel;
	
	// ImageIcon
	public ImageIcon shopLogo;
	
	// Price variables
	public int trousersPrice = 0;
	public int tshirtsPrice = 0;
	public int jacketsPrice = 0;
	public int shoesPrice = 0;
	public int sweatersPrice = 0;
	public int totalPrice = 0;
	
	// JMenuItems
	public JMenuItem exitOption;
	public JMenuItem readmeOption;
	public JMenuItem popupReadme;
	public JMenuItem popupExit;
	
	// Inventory Class
	public inventory stock;
	
	// JPopupMenus
	public JPopupMenu popupMenu;
	
	// Display variables
	public String trousersField;
	public String tshirtsField;
	public String jacketsField;
	public String shoesField;
	public String sweatersField;

	// Audio for the buttons
	public File btnSound = new File("buttonSound.wav");
	public AudioClip sound;

	// Create the frame
	public displayFrame() 
	{
		super("Title");
		setTitle("Clothes Shop");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		stock = new inventory();
		
		// Adding the JMenuBar to the frame
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Adding the fileMenu to the JMenuBar
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		// Adding the exitOption and the ActionListener
		exitOption = new JMenuItem("Exit");
		exitOption.addActionListener(this);
		fileMenu.add(exitOption);
		
		// Adding the helpMenu to the JMenuBar
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		// Adding the readmeOption and the ActionListener
		readmeOption = new JMenuItem("Readme");
		readmeOption.addActionListener(this);
		helpMenu.add(readmeOption);
		
		// Creating the main JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		// Adding the JPopupMenu
		popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		// Populating the JPopupMenu with the Readme option
		popupReadme = new JMenuItem("Readme");
		popupReadme.addActionListener(this);
		popupMenu.add(popupReadme);
		
		// Populating the JPopupMenu with the Exit Item
		popupExit = new JMenuItem("Exit");
		popupExit.addActionListener(this);
		popupMenu.add(popupExit);
		
		// Adding the random JButton and ActionListener
		btnRandom = new JButton("Select Outfit");
		btnRandom.addActionListener(this);
		btnRandom.setBounds(210, 377, 120, 25);
		contentPane.add(btnRandom);
		
		// Adding the reset JButton and ActionListener
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setBounds(222, 405, 97, 25);
		contentPane.add(btnReset);
		
		// Assigning the ImageIcon with the Shop's Logo
		shopLogo = new ImageIcon("logo.png");
		
		// "Total Price: " JLabel
		JLabel totalPriceLabel = new JLabel("Total Price:");
		totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		totalPriceLabel.setBounds(216, 348, 74, 16);
		contentPane.add(totalPriceLabel);
		
		// Price output after addition
		priceOutputLabel = new JLabel("0");
		priceOutputLabel.setBounds(302, 348, 69, 16);
		contentPane.add(priceOutputLabel);
		
		// =============================== //
		
		// JCheckBoxes	
		keepTrousers = new JCheckBox("Keep");
		keepTrousers.setFont(new Font("Tahoma", Font.ITALIC, 13));
		keepTrousers.setBounds(8, 127, 113, 25);
		contentPane.add(keepTrousers);
		
		keepShirts = new JCheckBox("Keep");
		keepShirts.setFont(new Font("Tahoma", Font.ITALIC, 13));
		keepShirts.setBounds(222, 127, 113, 25);
		contentPane.add(keepShirts);
		
		keepJackets = new JCheckBox("Keep");
		keepJackets.setFont(new Font("Tahoma", Font.ITALIC, 13));
		keepJackets.setBounds(8, 263, 113, 25);
		contentPane.add(keepJackets);
		
		keepShoes = new JCheckBox("Keep");
		keepShoes.setFont(new Font("Tahoma", Font.ITALIC, 13));
		keepShoes.setBounds(222, 263, 113, 25);
		contentPane.add(keepShoes);
		
		keepSweaters = new JCheckBox("Keep");
		keepSweaters.setFont(new Font("Tahoma", Font.ITALIC, 13));
		keepSweaters.setBounds(8, 405, 113, 25);
		contentPane.add(keepSweaters);
		
		// =============================== //
		
		// JLabels	
		JLabel titleTrousers = new JLabel("Trousers");
		titleTrousers.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleTrousers.setBounds(8, 13, 99, 25);
		contentPane.add(titleTrousers);
		
		JLabel titleTshirts = new JLabel("T-shirts");
		titleTshirts.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleTshirts.setBounds(222, 13, 83, 25);
		contentPane.add(titleTshirts);
		
		JLabel titleJackets = new JLabel("Jackets");
		titleJackets.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleJackets.setBounds(8, 161, 99, 25);
		contentPane.add(titleJackets);
		
		JLabel titleShoes = new JLabel("Shoes");
		titleShoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleShoes.setBounds(222, 161, 83, 25);
		contentPane.add(titleShoes);
		
		JLabel titleSweaters = new JLabel("Sweaters");
		titleSweaters.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleSweaters.setBounds(8, 297, 99, 25);
		contentPane.add(titleSweaters);
		
		// Clothes name output JLabels		
		trousersLabel = new JLabel("");
		trousersLabel.setBounds(12, 66, 190, 16);
		contentPane.add(trousersLabel);
		
		tshirtsLabel = new JLabel("");
		tshirtsLabel.setBounds(222, 66, 166, 16);
		contentPane.add(tshirtsLabel);
		
		jacketsLabel = new JLabel("");
		jacketsLabel.setBounds(8, 216, 190, 16);
		contentPane.add(jacketsLabel);
		
		shoesLabel = new JLabel("");
		shoesLabel.setBounds(222, 216, 166, 16);
		contentPane.add(shoesLabel);
		
		sweatersLabel = new JLabel("");
		sweatersLabel.setBounds(8, 348, 190, 16);
		contentPane.add(sweatersLabel);
		
		// The "€" sign JLabel		
		euroLabel = new JLabel("\u20AC");
		euroLabel.setBounds(293, 348, 56, 16);
		contentPane.add(euroLabel);
		
		// Shop's Logo JLabel		
		shopImage = new JLabel(shopLogo);
		shopImage.setBounds(383, 13, 200, 413);
		contentPane.add(shopImage);	
		
		// JButtons to view the clothes
		trousersView = new JButton("View");
		trousersView.setBounds(10, 100, 97, 25);
		trousersView.addActionListener(this);
		contentPane.add(trousersView);
		
		shirtsView = new JButton("View");
		shirtsView.setBounds(222, 100, 97, 25);
		shirtsView.addActionListener(this);
		contentPane.add(shirtsView);
		
		jacketsView = new JButton("View");
		jacketsView.setBounds(10, 237, 97, 25);
		jacketsView.addActionListener(this);
		contentPane.add(jacketsView);
		
		shoesView = new JButton("View");
		shoesView.setBounds(222, 237, 97, 25);
		shoesView.addActionListener(this);
		contentPane.add(shoesView);
		
		sweatersView = new JButton("View");
		sweatersView.setBounds(10, 377, 97, 25);
		sweatersView.addActionListener(this);
		contentPane.add(sweatersView);
		
		// =============================== //
		
		// Assigning "sound" with the "btnSound" <- 'buttonSound.wav'		
		try
		{
			sound = Applet.newAudioClip(btnSound.toURL());
		}  
		catch(Exception e)
		{
			e.printStackTrace();
		}  
	}
	
	// ActionListener for options selected
	public void actionPerformed(ActionEvent e)
	{	
		// Play the sound when an action is preformed
		sound.play();
		
		// To exit the program if its selected through the popupMenu/helpMenu
		if(e.getSource() == exitOption || e.getSource() == popupExit)
		{
			System.exit(0);
		}
		
		// To display the ReadMe if its selected through the popupMenu/helpMenu
		if(e.getSource() == readmeOption || e.getSource() == popupReadme)
		{
			try
			{
				Runtime.getRuntime().exec("notepad readme.txt");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			} 
		}
		
		// To reset the display fields if the reset button is pressed
		if(e.getSource() == btnReset)
		{	
			if(keepTrousers.isSelected() == false)
			{
				trousersLabel.setText("");
				trousersPrice = 0;
			}
			
			if(keepShirts.isSelected() == false)
			{
				tshirtsLabel.setText("");
				tshirtsPrice = 0;
			}
			
			if(keepJackets.isSelected() == false)
			{
				jacketsLabel.setText("");
				jacketsPrice = 0;
			}
			
			if(keepShoes.isSelected() == false)
			{
				shoesLabel.setText("");
				shoesPrice = 0;
			}
			
			if(keepSweaters.isSelected() == false)
			{
				sweatersLabel.setText("");
				sweatersPrice = 0;
			}
		}
		
		// To randomize the selection of clothing if the Random button is pressed
		if(e.getSource() == btnRandom)
		{			
			// Checks to see if the "Keep" option is selected from Trousers
			if(keepTrousers.isSelected() == false)
			{				
				trousersField = inventory.randomGen(stock.trousersA);
				trousersLabel.setText(trousersField);
				
				if(trousersField == stock.trousersA[0])
				{
					trousersPrice = 40;
				}
				else if(trousersField == stock.trousersA[1])
				{
					trousersPrice = 55;
				}
				else if(trousersField == stock.trousersA[2])
				{
					trousersPrice = 20;
				}
				else if(trousersField == stock.trousersA[3])
				{
					trousersPrice = 35;
				}
				else if(trousersField == stock.trousersA[4])
				{
					trousersPrice = 70;
				}
				else if(trousersField == stock.trousersA[5])
				{
					trousersPrice = 30;
				}
			}
			
			// Checks to see if the "Keep" option is selected from t-Shirts
			if(keepShirts.isSelected() == false)
			{
				tshirtsField = inventory.randomGen(stock.tShirtsA);
				tshirtsLabel.setText(tshirtsField);
				
				if(tshirtsField == stock.tShirtsA[0])
				{
					tshirtsPrice = 15;
				}
				else if(tshirtsField == stock.tShirtsA[1])
				{
					tshirtsPrice = 35;
				}
				else if(tshirtsField == stock.tShirtsA[2])
				{
					tshirtsPrice = 25;
				}
				else if(tshirtsField == stock.tShirtsA[3])
				{
					tshirtsPrice = 15;
				}
				else if(tshirtsField == stock.tShirtsA[4])
				{
					tshirtsPrice = 30;
				}
				else if(tshirtsField == stock.tShirtsA[5])
				{
					tshirtsPrice = 45;
				}
			}
			
			// Checks to see if the "Keep" option is selected from Jackets
			if(keepJackets.isSelected() == false)
			{
				jacketsField = inventory.randomGen(stock.jacketsA);
				jacketsLabel.setText(jacketsField);
				
				if(jacketsField == stock.jacketsA[0])
				{
					jacketsPrice = 60;
				}
				else if(jacketsField == stock.jacketsA[1])
				{
					jacketsPrice = 30;
				}
				else if(jacketsField == stock.jacketsA[2])
				{
					jacketsPrice = 35;
				}
				else if(jacketsField == stock.jacketsA[3])
				{
					jacketsPrice = 90;
				}
				else if(jacketsField == stock.jacketsA[4])
				{
					jacketsPrice = 25;
				}
				else if(jacketsField == stock.jacketsA[5])
				{
					jacketsPrice = 20;
				}
			}
			
			// Checks to see if the "Keep" option is selected from Shoes
			if(keepShoes.isSelected() == false)
			{
				shoesField = inventory.randomGen(stock.shoesA);
				shoesLabel.setText(shoesField);
				
				if(shoesField == stock.shoesA[0])
				{
					shoesPrice = 90;
				}
				else if(shoesField == stock.shoesA[1])
				{
					shoesPrice = 20;
				}
				else if(shoesField == stock.shoesA[2])
				{
					shoesPrice = 40;
				}
				else if(shoesField == stock.shoesA[3])
				{
					shoesPrice = 80;
				}
				else if(shoesField == stock.shoesA[4])
				{
					shoesPrice = 15;
				}
				else if(shoesField == stock.shoesA[5])
				{
					shoesPrice = 55;
				}
			}
			
			// Checks to see if the "Keep" option is selected from Sweaters
			if(keepSweaters.isSelected() == false)
			{
				sweatersField = inventory.randomGen(stock.sweatersA);
				sweatersLabel.setText(sweatersField);
				
				if(sweatersField == stock.sweatersA[0])
				{
					sweatersPrice = 35;
				}
				else if(sweatersField == stock.sweatersA[1])
				{
					sweatersPrice = 55;
				}
				else if(sweatersField == stock.sweatersA[2])
				{
					sweatersPrice = 65;
				}
				else if(sweatersField == stock.sweatersA[3])
				{
					sweatersPrice = 40;
				}
				else if(sweatersField == stock.sweatersA[4])
				{
					sweatersPrice = 30;
				}
				else if(sweatersField == stock.sweatersA[5])
				{
					sweatersPrice = 45;
				}
			}
		}
		
		// To display the appropriate image when View is pressed for Trousers
		if(e.getSource() == trousersView)
		{
			try
			{
				if(trousersField == stock.trousersA[0])
				{
					Runtime.getRuntime().exec("explorer trousersOne.png");
				}
				else if(trousersField == stock.trousersA[1])
				{
					Runtime.getRuntime().exec("explorer trousersTwo.png");
				}
				else if(trousersField == stock.trousersA[2])
				{
					Runtime.getRuntime().exec("explorer trousersThree.png");
				}
				else if(trousersField == stock.trousersA[3])
				{
					Runtime.getRuntime().exec("explorer trousersFour.png");
				}
				else if(trousersField == stock.trousersA[4])
				{
					Runtime.getRuntime().exec("explorer trousersFive.png");
				}
				else if(trousersField == stock.trousersA[5])
				{
					Runtime.getRuntime().exec("explorer trousersSix.png");
				}
			} 
			catch (IOException e1) 
			{					
				e1.printStackTrace();
			} 
		}
		
		// To display the appropriate image when View is pressed for t-Shirts
		if(e.getSource() == shirtsView)
		{
			try
			{
				if(tshirtsField == stock.tShirtsA[0])
				{
					Runtime.getRuntime().exec("explorer tshirtsOne.png");
				}
				else if(tshirtsField == stock.tShirtsA[1])
				{
					Runtime.getRuntime().exec("explorer tshirtsTwo.png");
				}
				else if(tshirtsField == stock.tShirtsA[2])
				{
					Runtime.getRuntime().exec("explorer tshirtsThree.png");
				}
				else if(tshirtsField == stock.tShirtsA[3])
				{
					Runtime.getRuntime().exec("explorer tshirtsFour.png");
				}
				else if(tshirtsField == stock.tShirtsA[4])
				{
					Runtime.getRuntime().exec("explorer tshirtsFive.png");
				}
				else if(tshirtsField == stock.tShirtsA[5])
				{
					Runtime.getRuntime().exec("explorer tshirtsSix.png");
				}
			} 
			catch (IOException e1) 
			{					
				e1.printStackTrace();
			} 
		}
		
		// To display the appropriate image when View is pressed for Jackets
		if(e.getSource() == jacketsView)
		{
			try
			{
				if(jacketsField == stock.jacketsA[0])
				{
					Runtime.getRuntime().exec("explorer jacketsOne.png");
				}
				else if(jacketsField == stock.jacketsA[1])
				{
					Runtime.getRuntime().exec("explorer jacketsTwo.png");
				}
				else if(jacketsField == stock.jacketsA[2])
				{
					Runtime.getRuntime().exec("explorer jacketsThree.png");
				}
				else if(jacketsField == stock.jacketsA[3])
				{
					Runtime.getRuntime().exec("explorer jacketsFour.png");
				}
				else if(jacketsField == stock.jacketsA[4])
				{
					Runtime.getRuntime().exec("explorer jacketsFive.png");
				}
				else if(jacketsField == stock.jacketsA[5])
				{
					Runtime.getRuntime().exec("explorer jacketsSix.png");
				}
			} 
			catch (IOException e1) 
			{					
				e1.printStackTrace();
			} 
		}
		
		// To display the appropriate image when View is pressed for Shoes
		if(e.getSource() == shoesView)
		{
			try
			{
				if(shoesField == stock.shoesA[0])
				{
					Runtime.getRuntime().exec("explorer shoesOne.png");
				}
				else if(shoesField == stock.shoesA[1])
				{
					Runtime.getRuntime().exec("explorer shoesTwo.png");
				}
				else if(shoesField == stock.shoesA[2])
				{
					Runtime.getRuntime().exec("explorer shoesThree.png");
				}
				else if(shoesField == stock.shoesA[3])
				{
					Runtime.getRuntime().exec("explorer shoesFour.png");
				}
				else if(shoesField == stock.shoesA[4])
				{
					Runtime.getRuntime().exec("explorer shoesFive.png");
				}
				else if(shoesField == stock.shoesA[5])
				{
					Runtime.getRuntime().exec("explorer shoesSix.png");
				}
			} 
			catch (IOException e1) 
			{					
				e1.printStackTrace();
			} 
		}
		
		// To display the appropriate image when View is pressed for Sweaters
		if(e.getSource() == sweatersView)
		{
			try
			{
				if(sweatersField == stock.sweatersA[0])
				{
					Runtime.getRuntime().exec("explorer sweatersOne.png");
				}
				else if(sweatersField == stock.sweatersA[1])
				{
					Runtime.getRuntime().exec("explorer sweatersTwo.png");
				}
				else if(sweatersField == stock.sweatersA[2])
				{
					Runtime.getRuntime().exec("explorer sweatersThree.png");
				}
				else if(sweatersField == stock.sweatersA[3])
				{
					Runtime.getRuntime().exec("explorer sweatersFour.png");
				}
				else if(sweatersField == stock.sweatersA[4])
				{
					Runtime.getRuntime().exec("explorer sweatersFive.png");
				}
				else if(sweatersField == stock.sweatersA[5])
				{
					Runtime.getRuntime().exec("explorer sweatersSix.png");
				}
			} 
			catch (IOException e1) 
			{					
				e1.printStackTrace();
			} 
		}
		
		// Total Price of the clothing displayed to a JLabel through the 'toString' method
		totalPrice = (trousersPrice + tshirtsPrice + jacketsPrice + shoesPrice + sweatersPrice);
		Integer.toString(totalPrice);
		priceOutputLabel.setText(Integer.toString(totalPrice));
		
	}
	
	// Method to do show the popupMenu when rightclick is pressed on the contentPane
	public static void addPopup(Component component, final JPopupMenu popup)
	{
		component.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger()) 
				{
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e)
			{
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
