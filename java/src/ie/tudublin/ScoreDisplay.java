/*
Student: Alec Keane
Date: 21/04/2021
ID: C19326126
Test: Object Oriented Programming
Description: 
A test to display musical notes and to add a variety of notes to an arrayList
Then make them appear on a mapped set of lines and if you hover them they will highlight in red.
*/

package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	//Declaring arrayList
	ArrayList<Notes> notes = new ArrayList<>();
	
	public void settings(){
		size(1000, 500);
	}


    public void setup() 
    {
		LoadScore();
		printScores();
    
    }//end setup

	//Loading the notes and their durations into an arrayList
	public void LoadScore(){
        notes = new ArrayList<>(score.length());
		int i = 0;

		//beggining checks to ensure that if a letter has a duration such as 2 that it recieves it
		//Otherwise the letter's assinged a default value of 1
		while(i < score.length()) 
        {
            if(Character.isLetter(score.charAt(i))) 
            {
                boolean VariableChecking = false;    
                try 
                {
                    if(Character.isDigit(score.charAt(i+1))) 
                    {
                        char n1 = score.charAt(i);
                        int n2 = score.charAt(i + 1) - '0';
                        Notes n = new Notes(n1, n2); //assign note duration 2
                        notes.add(n);
                    }
                    else 
                    {
                        char n1 = score.charAt(i);
                        Notes n = new Notes(n1, 1); //assigning note and a default duration.
                        notes.add(n);
                    }//end if
                }
                catch(Exception OutOfBounds)
                {
                    VariableChecking = true;
                }
                if(VariableChecking) 
                {
                    notes.add(new Notes(score.charAt(i), 1));
                }
            }//end if
			i++;
        }//end while
	}

	//displays the notes and their corresponding duration and type
	public void printScores()
	{
    	for (int i = 0; i < notes.size(); i++)
    	{
        	if (notes.get(i).getDuration() == 1)
        	{
            	println(notes.get(i).getNote() + "\t" + notes.get(i).getDuration() + "\t" + "Quaver");
        	}
        	else{
            	println(notes.get(i).getNote() + "\t" + notes.get(i).getDuration() + "\t" + "Crotchet");
        	}
		}
	}
		

	//draw function to begin mapping of lines and the symbols for the notes.
	public void draw(){
		int dur = 0;
		char Character;
		int D = 0;
		int x = 125;
		int y = 210;
		float border = 0.1f * width;
		background(255);

		//Mapping the lines to the screen
		for(int i =0; i<5; i++){
			float M = map(i, -5, 5, border, height - border);
			stroke(0);
			strokeWeight(1);;
			line(border, M, width - border, M);
		}

		//for loop will place the characters above the mapped lines and call a function
		//The function will place the symbols along the mapped lines
		for(int j =0; j <notes.size(); j++ ){
			dur = notes.get(j).getDuration();
			Character = notes.get(j).getNote();

			fill(0);
			textSize(30);
			text(notes.get(j).getNote(), x, y);
			x+=40;	
			
			if(dur ==1){
				drawNotes(1,Character, D); //pass duration, the character in the array, and the distance
			}
			else{
				drawNotes(2, Character, D);
			}
			D += 40;
			
		}//end for
	}

	//passed Duration, Character parsed from our array, and the X value distance.
	void drawNotes(int k, char c, int dist)
	{
			if('D'==c){
				DrawN(dist, 65, k); //passing distance for x, 65 for y and k is the duration
			}
			if('E'==c){
				DrawN(dist, 50, k); //X, Y, Duration
			}
			if('F'==c){
				DrawN(dist, 40, k);
			}
			if('G'==c){
				DrawN(dist, 30, k);
			}
			if('A'==c){
				DrawN(dist, 10, k);
			}
			if('B'==c){
				DrawN(dist, 0, k);
			}
			if('c'==c){
				DrawN(dist, -10, k);
			}
			if('d'==c){
				DrawN(dist, -20, k);
			}
		} 

	//X Y Duration passed in
	void DrawN(int Dist, int NoteY, int dur){

		//starting positions of the notes
		int x = 130;
		int y =300;

		//changing the note position depending on the note
		x = x + Dist;
		y = y + NoteY;

		//if mouse hovers exactly over a symbol then the symbol will highlight in red and thicken
		//Otherwise the symbol will remian black and with a lower thickness.
		if(mouseX < x + 10 && mouseX > x- 10
			&& mouseY < y+10 && mouseY > y-10){
			fill(255,0,0);
			stroke(255,0,0);
			strokeWeight(2);
		}else{
		fill(0);
		stroke(0);
		strokeWeight(1);
		}
		ellipse(x,y,20,20); 

		line(x+10, y,x+10, y-30);
		if(dur ==2){ //if crotchet passed in change note type
		line(x+10, y-30, x+18, y-17);
		}
	}
}


