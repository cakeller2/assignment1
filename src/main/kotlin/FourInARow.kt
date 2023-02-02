/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */

/**
 * Assignment 1; Four in a Row
 * @author Camryn Keller
 * @date 2/1/2023
 */
class FourInARow

/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    // clears the board
    override fun clearBoard() {
        for (row in 0 until 6) {
            for (col in 0 until 6) {
                board[row][col] = 0
            }
        }
    }
    //sets the move in board cell
    override fun setMove(player: Int, location: Int) {
        //checks that the random number generation doesn't override placed pieces
        if (board[location/GameConstants.ROWS][location%GameConstants.COLS] == GameConstants.EMPTY) {
            board[location/GameConstants.ROWS][location%GameConstants.COLS] = player
        } else {
            if (player == GameConstants.BLUE) {
                println("There is already a token here, try again")
                userInput = readln()
                println("You entered: $userInput")
                checkForNum()
                setMove(player, userInput.toInt() )
            } else {
                setMove(GameConstants.RED, computerMove)
            }
        }
    }

    //generates computer's move
    override val computerMove: Int
        get() =
            ((0..35).random())


    //checks for winner
    override fun checkForWinner(): Int {
        //horizontal check
        for (rowNum in 0 until 6) {
            for (numInRow in 0 until 3) {
                var playerColor: Int
                if (board[rowNum][numInRow] != 0) {
                    playerColor = board[rowNum][numInRow]
                    if (playerColor == 1 && board[rowNum][numInRow + 1] == playerColor && board[rowNum][numInRow + 2] == playerColor && board[rowNum][numInRow + 3] == playerColor) {
                        return playerColor + 2
                    } else if (board[rowNum][numInRow + 1] == playerColor && board[rowNum][numInRow + 2] == playerColor && board[rowNum][numInRow + 3] == playerColor) {
                        return playerColor
                    }
                }
            }

        }

        //vertical check
        for (colNum in 0 until 6) {
            for (numInCol in 0 until 3) {
                var playerColor :Int
                if (board[numInCol][colNum] != 0) {
                    playerColor = board[numInCol][colNum]
                    if (playerColor == 1 && board[numInCol + 1][colNum] == playerColor && board[numInCol + 2][colNum] == playerColor && board[numInCol + 3][colNum] == playerColor) {
                        return playerColor + 2
                    } else if (board[numInCol + 1][colNum] == playerColor && board[numInCol + 2][colNum] == playerColor && board[numInCol + 3][colNum] == playerColor) {
                        return playerColor
                    }
                }
            }
        }

        //diagonal left check
        for (diaCol in 0 until 3) {
            for (diaRow in 0 until 3) {
                var playerColor :Int
                if (board[diaRow][diaCol] != 0) {
                    playerColor = board[diaRow][diaCol]
                    if (playerColor == 1 && board[diaRow + 1][diaCol + 1] == playerColor && board[diaRow + 2][diaCol + 2] == playerColor && board[diaRow + 3][diaCol + 3] == playerColor) {
                        return playerColor + 2
                    } else if (board[diaRow + 1][diaCol + 1] == playerColor && board[diaRow + 2][diaCol + 2] == playerColor && board[diaRow + 3][diaCol + 3] == playerColor) {
                        return playerColor
                    }
                }
            }
        }

        //diagonal right check
        for (diaCol in 3 until 6) {
            for (diaRow in 0 until 3) {
                var playerColor :Int
                if (board[diaRow][diaCol] != 0) {
                    playerColor = board[diaRow][diaCol]
                    if (playerColor == 1 && board[diaRow + 1][diaCol - 1] == playerColor && board[diaRow + 2][diaCol - 2] == playerColor && board[diaRow + 3][diaCol - 3] == playerColor) {
                        return playerColor + 2
                    } else if (board[diaRow + 1][diaCol - 1] == playerColor && board[diaRow + 2][diaCol - 2] == playerColor && board[diaRow + 3][diaCol - 3] == playerColor) {
                        return playerColor
                    }
                }
            }
        }

        return 0
    }


    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    private fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
}

