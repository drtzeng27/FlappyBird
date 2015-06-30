package Flap;
import apcs.Window;


public class FlappyBird {

	static int birdY = 50;
	static int birdYspeed = 0;
	static int pipeX = 520;
	static int pipeX2 = 800;
	static int gap1 = 50 + Window.rollDice(300);
	static int gap2 = 50 + Window.rollDice(300);
	static boolean hasGivenScoreforPipe1 = false;
	static boolean hasGivenScoreforPipe2 = false;
	static int score = 0;
	
	public static void main(String[] args) {
		

		while(true){
			Window.out.image("Flap/bg.png",0,0);
			
			pipeX = pipeX - 5;
			pipeX2 = pipeX2 - 5;
			
			
			if(pipeX < -25){
				pipeX = 530;
				gap1 = 50 + Window.rollDice(300);
				hasGivenScoreforPipe1 = false;
			}
			
			if(pipeX2 < -25){
				pipeX2 = 530;
				gap2 = 50 + Window.rollDice(300);
				hasGivenScoreforPipe2 = false;
			}
			birdY = birdY + birdYspeed;
			birdYspeed = birdYspeed + 1;
					
			Window.out.color("red");
			drawBird(150, birdY);
			
			if(Window.key.pressed("space")){
				birdYspeed = -10;
			}
			if(birdY > 490 || birdY < 10){
				gameOver();
			}
			
			if(isCollision(gap1, pipeX, birdY) || isCollision(gap2, pipeX2, birdY) ){
				gameOver();
			}
			
			if (150 > pipeX + 20 && hasGivenScoreforPipe1 == false){
				score = score + 1;
				hasGivenScoreforPipe1 = true;
			}
			if (150 > pipeX2 + 20 && hasGivenScoreforPipe2 == false){
				score = score + 1;
				hasGivenScoreforPipe2 = true;
			}
			Window.out.font("Black Ops One", 60);
			Window.out.print(score, 250, 150);
			
			drawPipe(gap1, pipeX, 40);
			drawPipe(gap2, pipeX2, 40); 
			
			Window.frame();
		}
	}


	private static boolean isCollision(int gap, int pipeX, int birdY) {
		boolean isOnLeft = 150 <= pipeX - 20;
		boolean isOnRight = 150 >= pipeX + 20;
		boolean isInCenter = Math.abs(pipeX - 150) < 21 && Math.abs(gap - birdY) < 51;
		if(isOnLeft || isOnRight || isInCenter){
			return false;
		}else{
			return true;
		}
	}

	private static void drawPipe(int gap, int x, int width) {
		Window.out.color(222, 255, 36);
		Window.out.rectangle(x, ((gap - 50)/ 2) , width , (gap - 50));
		Window.out.rectangle(x, (500 - (500 - (gap + 50)) / 2), width, (500 - (gap + 50)));
	}

	public static void gameOver() { 
		Window.out.font("Arial", 50);
		Window.out.print("Game Over", 125, 125);
		Window.out.print("You got " + score, 140, 195);
		Window.out.font("Consolas", 35);
		Window.out.print("Press Space to Continue", 30, 265);
		Window.frame(500);
		while(!Window.key.pressed("space")){
		}	
		Window.sleep(100);
		birdY = 50;
		birdYspeed = 0;
		pipeX = 520;
		pipeX2 = 765;
		gap1 = 50 + Window.rollDice(300);
		gap2 = 50 + Window.rollDice(300);
		score = 0;
		
		
		
	}

	private static void drawBird(int xPos, int yPos) {
		Window.out.color("black");
		Window.out.oval(xPos, yPos, 37, 30);
		Window.out.color(255, 217, 112);
		Window.out.oval(xPos, yPos, 34, 27);
		Window.out.color("black");
		Window.out.circle(xPos + 5, yPos - 4, 3);   
	}

}






















/*import apcs.Window;


public class FlappyBird {

	static int birdY = 50;
	static int birdYspeed = 0;
	static int pipeX = 520;
	static int pipeX2 = 800;
	static int gap1 = 50 + Window.rollDice(300);
	static int gap2 = 50 + Window.rollDice(300);
	static int score = 0;
	
	public static void main(String[] args) {
		

		while(true){
			Window.out.image("Flap/bg.png",0,0);
			
			pipeX = pipeX - 5;
			pipeX2 = pipeX2 - 5;
			
			
			if(pipeX < -25){
				pipeX = 530;
				gap1 = 50 + Window.rollDice(300);
			}
			
			if(pipeX2 < -25){
				pipeX2 = 530;
				gap2 = 50 + Window.rollDice(300);
			}
			birdY = birdY + birdYspeed;
			birdYspeed = birdYspeed + 1;
					
			Window.out.color("red");
			drawBird(150, birdY);
			
			if(Window.key.pressed("space")){
				birdYspeed = -10;
			}
			if(birdY > 490 || birdY < 10){
				gameOver();
			}
		
			
			if(isCollision(gap1, pipeX, birdY) || isCollision(gap2, pipeX2, birdY) ){
				gameOver();
			}
			
			drawPipe(gap1, pipeX, 40);
			drawPipe(gap2, pipeX2, 40); 
			
			if(birdY > pipeX || birdY > pipeX2){
				score = score + 1;
				System.out.print(score);
			}
				
			
			Window.frame();
	}
}
	private static boolean isCollision(int gap, int pipeX, int birdY) {
		boolean isOnLeft = 150 <= pipeX - 20;
		boolean isOnRight = 150 >= pipeX + 20;
		boolean isInCenter = Math.abs(pipeX - 150) < 21 && Math.abs(gap - birdY) < 51;
		if(isOnLeft || isOnRight || isInCenter){
			return false;
		}else{
			return true;
		}
	}

	private static void drawPipe(int gap, int x, int width) {
		Window.out.color(222, 255, 36);
		Window.out.rectangle(x, ((gap - 50)/ 2) , width , (gap - 50));
		Window.out.rectangle(x, (500 - (500 - (gap + 50)) / 2), width, (500 - (gap + 50)));
	}

	private static void gameOver() {
		Window.out.font("Arial", 50);
		Window.out.print("Game Over", 125, 125);
		Window.out.print("You got " + score, 125, 195);
		Window.out.font("Consolas", 35);
		Window.out.print("Press Space to Continue", 20, 265);
		Window.frame(500);
		while(!Window.key.pressed("space")){
		}	
		Window.sleep(100);
		birdY = 50;
		birdYspeed = 0;
		pipeX = 520;
		pipeX2 = 765;
		gap1 = 50 + Window.rollDice(300);
		gap2 = 50 + Window.rollDice(300);
		score = 0;
		
		
		
	}

	private static void drawBird(int xPos, int yPos) {
		Window.out.color("black");
		Window.out.oval(xPos, yPos, 37, 30);
		Window.out.color(255, 217, 112);
		Window.out.oval(xPos, yPos, 34, 27);
		Window.out.color("black");
		Window.out.circle(xPos + 5, yPos - 4, 3);   
	}

}
		
		
		
		
		
		/*int y = 250;
		int speed = 1;
		int yspeed = 5;
	
		Window.out.background("white");
		Window.out.color("red");
		Window.out.circle(250, y, 20);
		
		y = y + speed;
		speed = speed + 1;
		
		if(Window.key.pressed("space")){
			y = y + speed;
			speed = speed + 1;
			
		}
			
		
	}

}
*/







		
		
		
		
		
