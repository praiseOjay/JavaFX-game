# Aliens & Asteroids

Aliens & Asteroids is an interactive JavaFX game designed to help teach young children aspects of science in a fun way. Players control a spaceship navigating through space, collecting coins while avoiding various threats like asteroids and aliens.

## Features

- Interactive spaceship control using W, A, S, D keys
- Randomly generated asteroids and coins
- Collision detection with sound effects
- Educational space theme for primary school children

## Technologies Used

- Java
- JavaFX
- Object-Oriented Programming (OOP)

## Design Patterns

1. **Delegation Pattern**: Used for implementing spaceship control through KeyEvent handling.
2. **Factory Pattern**: Implemented for creating various game objects (Asteroids, Aliens, Coins) with shared behaviors.

## Key Classes

- `SpaceGame`: Main class responsible for creating the scene and canvas.
- `SpaceShip`: Represents the player-controlled spaceship.
- `Asteroid`: Base class for obstacles.
- `Alien`: Subclass of Asteroid.
- `Coin`: Collectible items for the player.

## Installation

1. Ensure you have Java and JavaFX installed on your system.
2. Clone the repository:
   ```
   git clone https://github.com/yourusername/aliens-and-asteroids.git
   ```
3. Open the project in your preferred Java IDE.
4. Run the `SpaceGame` class to start the game.

## How to Play

- Use W, A, S, D keys to control the spaceship.
- Collect all coins on the screen.
- Avoid colliding with asteroids and aliens.

## Future Improvements

- Add a life bar or counter to the screen.
- Implement multiple stages with increased difficulty.
- Introduce more enemy variety.

## Contributing

Contributions to improve the game are welcome. Please feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact

Praise Ojerinola - ojerinolapraise@gmail.com

Project Link: https://github.com/praiseOjay/JavaFX-game.git
