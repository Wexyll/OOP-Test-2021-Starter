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

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}


    public void setup() 
    {
		LoadScore();
    
    }//end setup

	public void LoadScore(){
        notes = new ArrayList<>(score.length());
		int i = 0;

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
                        Notes n = new Notes(n1, n2);
                        notes.add(n);
                    }
                    else 
                    {
                        char n1 = score.charAt(i);
                        Notes n = new Notes(n1, 1);  
                        notes.add(n);
                    }//end if
                }
                catch(Exception OutOfBounds)
                {
                    println(OutOfBounds);
                    VariableChecking = true;
                }
                if(VariableChecking) 
                {
                    notes.add(new Notes(score.charAt(i), 1));
                }
            }//end if
			i++;
        }//end while
        System.out.println(notes.toString());
	}
		

	public void draw(){
		int dur = 0;
		char No;
		int dist = 0;
		int x2 = 100;
		int y2 = 210;
		float border = 0.1f * width;
		background(255);
		
		for(int j =0; j <notes.size(); j++ ){
			dur = notes.get(j).getDuration();
			No = notes.get(j).getNote();
			fill(0);
			textSize(25);
			text(notes.get(j).getNote(), x2, y2);
			x2+=40;	
			
			if(dur ==1){
				drawNotes(1,No, dist);
			}
			else{
				drawNotes(2, No, dist);
			}
			dist += 40;
			
		}//

		for(int i =0; i<5; i++){
			float y = map(i, -5, 5, border, height - border);
			stroke(0);
			line(border, y, width - border, y);
		}
	}

	void drawNotes(int k, char c, int dist)
	{
			if('D'==c){
				DrawN(dist, 65, k);
			}
			if('E'==c){
				DrawN(dist, 50, k);
			}
			if('F'==c){
				DrawN(dist, 40, k);
			}
			if('G'==c){
				DrawN(dist, 30, k);
			}
			if('A'==c){
				DrawN(dist, 20, k);
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

	void DrawN(int j, int k, int dur){
		int x = 100; //edit this
		int y =310;
		x = x + j;
		y = y + k;
		fill(0);
		ellipse(x,y,16,16); //eg x = 20, y =20
		stroke(0);
		strokeWeight(2);
		line(x+8, y,x+8, y-30);
		if(dur ==1){
		line(x+8, y-30, x+18, y-17);
		}
	}
}


