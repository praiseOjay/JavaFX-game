package uos.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Coin extends Asteroid{

	
	@SuppressWarnings("exports")
	public Coin(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		img = new Image("Coin.png");
	}
	public void move()
	{
		//draws the image on the canvas
		gc.drawImage(img,x,y,width,height);
		updateRectangle();
	}

}
