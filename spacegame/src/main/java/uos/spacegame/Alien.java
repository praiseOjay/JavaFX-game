package uos.spacegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alien extends Asteroid{
	@SuppressWarnings("exports")
	public Alien(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		dx=5;
		dy=-5;
		img=new Image("Alien ship 1.png");
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
		gc.drawImage(img,x,y,width,height);
	}
}
