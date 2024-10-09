package uos.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceShip extends Asteroid{
	@SuppressWarnings("exports")
	public SpaceShip(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		dx=5;
		dy=5;
		img=new Image("Spaceship.jpg");
	}
	
	public void move()
	{
		//draws the spaceship on the canvas
		gc.drawImage(img,x,y,width,height);
		updateRectangle();
	}
	
	public void moveLeft()
	{
		x = x-10;//moves the spaceship to the left
	}
	
	public void moveRight()
	{
		x = x+10;//moves the spaceship to the right
	}
	
	public void moveUp()
	{
		y = y-10;//moves the spaceship to the up
	}
	
	public void moveDown()
	{
		y = y+10;//moves the spaceship to the down
	}
}
