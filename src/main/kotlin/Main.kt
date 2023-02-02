/**
 * Assignment 1; Four in a Row
 * Main class to run program
 * @author Camryn Keller
 * @date 2/1/2023
 */

import kotlin.system.exitProcess

val FIR_board = FourInARow()
var userInput = "-1"

//checks is the input is a number and loops until a number is put in
fun checkForNum() {
 while (userInput.toIntOrNull() == null) {
  //checks if the input that is not a number is q to quit
  if (userInput == "q" || userInput == "Q") {
   println("Goodbye")
   exitProcess(0)
  }
  println("That is not an option.\nTry again")
  userInput = readln()
  println("You entered: $userInput")
 }
//checks if the number input is within bounds
 while (userInput.toInt() < 0 || userInput.toInt() > 35) {
  println("That is not an option.\nTry again")
  userInput = readln()
  println("You entered: $userInput")
 }
}

/** The entry main method (the program starts here)  */
fun main() {
 var currentState: Int = GameConstants.PLAYING
 var turns = 0
 //game loop
 println("Welcome to Four in Row")
 do {
  //prints the board
  FIR_board.printBoard()
  println("Your turn\nPlease enter a number between 0-35 to place your token")
  //reads the user's input
  userInput = readln()
  println("You entered: $userInput")

  //calling to check the userInput
  checkForNum()

  //sets the user move after checking it won't break the program
  FIR_board.setMove(GameConstants.BLUE, userInput.toInt())

  FIR_board.printBoard()

  //sets computer move
  println("\nComputer's Turn")

  FIR_board.setMove(GameConstants.RED, FIR_board.computerMove)
  // counts turns
  turns += 1

  //check for winner
  if (FIR_board.checkForWinner() == GameConstants.BLUE_WON) {
   FIR_board.printBoard()
      currentState = GameConstants.BLUE_WON
  } else if (FIR_board.checkForWinner() == GameConstants.RED_WON) {
   FIR_board.printBoard()
      currentState = GameConstants.RED_WON
  } else if (turns == 18) {
   FIR_board.printBoard()
      currentState = GameConstants.TIE
  }

 } while (currentState == GameConstants.PLAYING)

 when (currentState) {
     GameConstants.BLUE_WON -> {
      println("You win! Great job!")
     }
     GameConstants.RED_WON -> {
      println("You lose! Better luck next time.")
     }
     GameConstants.TIE -> {
      println("Its a tie! Try again!")
     }
 }
}
 