package uos.spacegame;

import java.io.File;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SpaceGame extends Application{
	Pane root = new Pane();
	Scene scene = new Scene(root,800,600);
	Canvas canvas = new Canvas(800,600);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	
	//stores Asteroid objects
	ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	
	//stores Coin objects
	ArrayList<Coin> coins = new ArrayList<Coin>();
	
	//creates the spaceShip object
	SpaceShip spaceShip = new SpaceShip(200,200,gc);
	
	//sets the image that will be used for the background
	Image bgImage = new Image("Galaxy.jpg");
	
	//outputs the user's score
	Label score = new Label();
	Font font = new Font("Arial", 50);
	
	//outputs a message to the player
	Label message = new Label();
	
	
	//stores the users score
	int points = 0;
	
	//store the player's lives
	int lives = 3;
	
	//sound files
	public static final String COIN_SOUND = "CoinFX.wav";
	public static final String DEATH_SOUND = "DeathFX.wav";
	Media sound;
	MediaPlayer mediaPlayer;

	//allows the user to control the space ship whenever the following keys are pressed
	EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent> () {
		@Override
		public void handle(KeyEvent event) {
			if(event.getCode() == KeyCode.D) {
				spaceShip.moveRight();
			}
			if(event.getCode() == KeyCode.A) {
				spaceShip.moveLeft();
			}
			if(event.getCode() == KeyCode.S) {
				spaceShip.moveDown();
			}
			if(event.getCode() == KeyCode.W) {
				spaceShip.moveUp();
			}
		}};
	
	
		AnimationTimer timer = new AnimationTimer () {
			@Override
			public void handle(long now) {
				//sets the background image
				gc.drawImage(bgImage, 0, 0, canvas.getWidth(), canvas.getHeight());
				
				spaceShip.move();
				addEnemies();
				addCoins();
				
				message.setLayoutX(270);
				message.setLayoutY(270);
				message.setFont(font);
				message.setTextFill(Color.WHITE);
				message.setOpacity(0);
				
				score.setText("" + points);
				score.setLayoutX(670);
				score.setLayoutY(15);
				score.setFont(font);
			}};
			

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ALIENS & ASTEROIDS");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		root.getChildren().addAll(canvas,score,message);
		gc.setFill(Color.YELLOW);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	

		
		//starts the animation
		timer.start();
		
		
		//adds the asteroid object and its subclasses to the Asteroid array
		asteroids.add(new Asteroid(10, 10, gc));
		asteroids.add(new Asteroid(500, 300, gc));
		asteroids.add(new Asteroid(10, 10, gc));
		asteroids.add(new Asteroid(400, 400, gc));
		asteroids.add(new Alien(300,300, gc));
		asteroids.add(new Alien(100,100, gc));
		
		//adds the coin objects and its subclasses to the Coin array
		coins.add(new Coin(50, 100, gc));
		coins.add(new Coin(100, 300, gc));
		coins.add(new Coin(350, 480, gc));
		coins.add(new Coin(280, 50, gc));
		coins.add(new Coin(400, 450, gc));
		coins.add(new Coin(700, 50, gc));
		coins.add(new Coin(600, 100, gc));
		
		//triggers the keyHandler event whenever W, A, S, D, is pressed
		scene.setOnKeyPressed(keyHandler);
			
	}
	
	public void addEnemies() {
		for(Asteroid a : asteroids) {
			a.move();//moves the asteroid objects around the screen
			//checks if the spaceship touches the asteroid objects 
			if(spaceShip.r.intersects(a.r.getX(),a.r.getY(),a.r.getWidth(),a.r.getHeight())) {
				gc.setFill(Color.RED);
				gc.fillRect(spaceShip.r.getX(),spaceShip.r.getY(),spaceShip.r.getWidth(),spaceShip.r.getHeight());
				sound = new Media(new File(DEATH_SOUND).toURI().toString());
				mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.play();//plays a sound whenever the player touches an asteroid or alien
				lives--;//reduces the players lives
				if (lives == 0) {//checks the players lives
					timer.stop();//ends the game if the player runs of lives
					//System.exit(0);
					}
				}
			}
		}
	
	public void addCoins() {
		for(Coin c : coins) {
			c.move();// draws the coin object on the screen
			//checks if the spaceship touches the coin objects 
			if(spaceShip.r.intersects(c.r.getX(),c.r.getY(),c.r.getWidth(),c.r.getHeight())) {
				gc.setFill(Color.GREEN);
				gc.fillRect(spaceShip.r.getX(),spaceShip.r.getY(),spaceShip.r.getWidth(),spaceShip.r.getHeight());
				sound = new Media(new File(COIN_SOUND).toURI().toString());
				mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.play();//plays a sound whenever the player collects a coin
				points++;//gives the player a point
				coins.remove(c);//removes coin
				if (coins.size() == 0)
				{
					message.setText("You Win!!");//Outputs message to the player
					message.setOpacity(1);//makes the message visible
					timer.stop();//ends the game
				}
			}
		}
	}
	
}




