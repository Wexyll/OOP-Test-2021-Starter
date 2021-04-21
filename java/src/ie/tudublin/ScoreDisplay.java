package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	//Declaring arrayList
	ArrayList<Notes> notes = new ArrayList<>();
	
	
	public void settings(){
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() {
		notes = new ArrayList<>(score.length());
        notes.add(new Notes(('A'),1));
	}

	public void draw(){
		int x2 = 350;
		int y2 = 210;
		float border = 0.1f * width;
		background(255);
		
		for(int j =0; j <score.length(); j++ ){
			fill(0);
			text(score.charAt(j), x2, y2);
			x2+=40;
		}

		for(int i =0; i<5; i++){
			float y = map(i, -5, 5, border, height - border);

			stroke(0);
			line(border, y, width - border, y);

		}
		DrawNote(500,150);
		
	}

	void drawNotes()
	{

	}

	void DrawNote(int x, int y){
		fill(0);
		ellipse(x,y,16,16); //eg x = 20, y =20
		stroke(0);
		strokeWeight(2);
		line(x+8, y,x+8, y-30);
		line(x+8, y-30, x+18, y-17);
	}
}
