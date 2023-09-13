# Yahtzee Game Project

This project implements a 2-player game of Yahtzee. Players take turns rolling dice to make various combinations and maximize their scores. The game consists of 13 rounds, with each player getting one turn per round. 

## Classes

### CategoryValue

An enumeration representing the categories in Yahtzee, along with their associated values and names.

### Die

A class representing a single die. It has a value between 1 and 6, and can be rolled to get a random value.

### Dice

A container for `Die` objects. It allows for adding, removing, and manipulating dice, as well as counting and summing their values.

### DiceRoll

A specialization of `Dice` that allows rolling all the dice at once.

### Category

An abstract base class for all categories on the scorecard. It contains a score and a flag indicating if it has been used.

### Ones, Twos, Threes, Fours, Fives, Sixes, ThreeOfAKind, FourOfAKind, FullHouse, SmStraight, LgStraight, FiveOfAKind, Chance

Subclasses of `Category` that implement specific scoring rules for each category.

### Scorecard

A collection of categories, as well as scores for the top, bottom, and total sections. It also handles scoring logic.

### Game

The main class that controls the flow of the game. It manages player turns, displays the scorecard, and prompts for user input.

### GameDriver

The class that starts the game. It creates an instance of `Game` and initiates gameplay.

## Running the Game

To run the game, execute the `GameDriver` class. Follow the prompts to play Yahtzee.

## Contact

For any inquiries or issues, please contact [Nolan Cyr](mailto:nolangcyr@gmail.com)
