package com.assignment.clothes;

public class inventory 
{
	public String[] trousersA = {"Black Skinny Jeans €40", "Weathered Stretch Jeans €55", "Grey School Trousers €20", "Green Combat Trousers €35", "Black Suit Trousers €70", "Blue Plain Jeans €30"};
	public String[] tShirtsA = {"White Polo Shirt €15", "Black Designer Shirt €35", "Baggy Yellow Shirt €25", "Tight Black Shirt €15", "Grey Collar Shirt  €30", "'Unique' Logo Shirt €45"};
	public String[] jacketsA = {"Black Leather Jacket €60", "White Rain Jacket €30", "Dark Blue Jacket €35", "Fine Leather Jackter €90", "Black Rain Jacket €25", "Yellow Rain Jacktet €20"};
	public String[] shoesA = {"Black Designer Shoes €90", "Grey School Shoes €20", "Pink Dance Shoes €40", "White Hip-Hop Shoes €80", "Blue Plain Shoes €15", "Yellow Running Shoes €55"};
	public String[] sweatersA = {"Grey Baggy Sweater €35", "Red Designer Sweater €55", "'Rock' Band Logo Sweater €65", "Cosy Blue Sweater €40", "Lazy Yellow Sweater €30", "Brown Fuzzy Sweater €45"};
	
	// Random selection generator
	public static String randomGen(String[] randomArray)
	{
		int randomNumber;
		
		randomNumber = (int)(Math.random() * randomArray.length);
		return randomArray[randomNumber];
	}
}