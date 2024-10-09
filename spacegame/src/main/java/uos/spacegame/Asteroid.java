package uos.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Asteroid extends GameObject{
	protected double x,y;
	protected Image img;
	protected GraphicsContext gc;
	protected double dx=1, dy=1;
	protected double width=50, height=50;
	protected Rectangle r;
	
	
	@SuppressWarnings("exports")
	public Asteroid(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		this.x = x;
		this.y = y;
		this.gc = gc;
		r=new Rectangle(0,0,width,height);
		img = new Image("Asteroid.jpg");		
	}

	public void move()
	{
		//stops the Asteroid and its subclasses from going out of bounds on the canvas
		x+=dx;
		if(x>(800-width))
			dx=-dx;
		if(x<0)
			dx=-dx;
		y+=dy;
		if(y>(600-height))
			dy=-dy;
		if(y<0)
			dy=-dy;
		gc.drawImage(img,x,y,width,height);//draws the image on the canvas
		updateRectangle();//updates the position of the Asteroids and its subclasses.
	}
	
	public void updateRectangle()
	{
		//updates the position of the object.
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
	}

}
