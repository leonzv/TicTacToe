package com.example.apptestgit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnClick(view: View) {
        val btnSelect = view as Button
        var cellID = 0

        when (btnSelect.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9

        }
        playGame(cellID, btnSelect)
    }

    //arrays to save each player's moves
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    //Player's turn
    var activeplayer = 1

    fun playGame(cellID: Int, btnSelect: Button) {

        if (activeplayer == 1) {
            btnSelect.text = "X"
            btnSelect.setBackgroundColor(Color.BLUE)
            player1.add(cellID)
            activeplayer = 2
        } else {
            btnSelect.text = "O"
            btnSelect.setBackgroundColor(Color.RED)
            player2.add(cellID)
            activeplayer = 1
        }
        btnSelect.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        //linha
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //diagonal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        //coluna
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        //winner
        if (winner !=- 1) {
            if (winner == 1) {
                Toast.makeText(applicationContext, "Player 1 won the game!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Player 2 won the game!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}