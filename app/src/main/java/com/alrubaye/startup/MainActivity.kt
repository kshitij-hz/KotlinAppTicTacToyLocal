package com.alrubaye.startup

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun restartGame(view: View){
        player1.clear()
        player2.clear()
        winnerArray.clear()
        ActivePlayer = 1
        reinitializeBoxes(bu1)
        reinitializeBoxes(bu2)
        reinitializeBoxes(bu3)
        reinitializeBoxes(bu4)
        reinitializeBoxes(bu5)
        reinitializeBoxes(bu6)
        reinitializeBoxes(bu7)
        reinitializeBoxes(bu8)
        reinitializeBoxes(bu9)
        winnerMsg.text = ""
    }

     private fun reinitializeBoxes(btn: Button){
        btn.isEnabled = true
        btn.text = ""
        btn.setBackgroundResource(R.color.colorPrimary)
    }

     fun buClick(view: View){
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.bu1 ->  cellId = 1
            R.id.bu2 ->  cellId = 2
            R.id.bu3 ->  cellId = 3
            R.id.bu4 ->  cellId = 4
            R.id.bu5 ->  cellId = 5
            R.id.bu6 ->  cellId = 6
            R.id.bu7 ->  cellId = 7
            R.id.bu8 ->  cellId = 8
            R.id.bu9 ->  cellId = 9
        }

        // Toast.makeText(this, "ID: " + cellId, Toast.LENGTH_LONG).show()
        PlayGame(cellId, buSelected)
        CheckWinner()

    }

    private fun changeWinnerColor(){
        if(1 in winnerArray) bu1.setBackgroundResource(R.color.colorWinnerGreen)
        if(2 in winnerArray) bu2.setBackgroundResource(R.color.colorWinnerGreen)
        if(3 in winnerArray) bu3.setBackgroundResource(R.color.colorWinnerGreen)
        if(4 in winnerArray) bu4.setBackgroundResource(R.color.colorWinnerGreen)
        if(5 in winnerArray) bu5.setBackgroundResource(R.color.colorWinnerGreen)
        if(6 in winnerArray) bu6.setBackgroundResource(R.color.colorWinnerGreen)
        if(7 in winnerArray) bu7.setBackgroundResource(R.color.colorWinnerGreen)
        if(8 in winnerArray) bu8.setBackgroundResource(R.color.colorWinnerGreen)
        if(9 in winnerArray) bu9.setBackgroundResource(R.color.colorWinnerGreen)
    }

     private fun CheckWinner() {
        var winner = -1
         // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
            winnerArray.add(1)
            winnerArray.add(2)
            winnerArray.add(3)
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
            winnerArray.add(1)
            winnerArray.add(2)
            winnerArray.add(3)
        }

        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
            winnerArray.add(4)
            winnerArray.add(5)
            winnerArray.add(6)
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
            winnerArray.add(4)
            winnerArray.add(5)
            winnerArray.add(6)
        }

        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
            winnerArray.add(7)
            winnerArray.add(8)
            winnerArray.add(9)
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
            winnerArray.add(7)
            winnerArray.add(8)
            winnerArray.add(9)
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
            winnerArray.add(1)
            winnerArray.add(4)
            winnerArray.add(7)
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
            winnerArray.add(1)
            winnerArray.add(4)
            winnerArray.add(7)
        }

        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
            winnerArray.add(2)
            winnerArray.add(5)
            winnerArray.add(8)
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
            winnerArray.add(2)
            winnerArray.add(5)
            winnerArray.add(8)
        }

        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
            winnerArray.add(3)
            winnerArray.add(6)
            winnerArray.add(9)
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
            winnerArray.add(3)
            winnerArray.add(6)
            winnerArray.add(9)
        }

        // diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
            winnerArray.add(1)
            winnerArray.add(5)
            winnerArray.add(9)
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
            winnerArray.add(1)
            winnerArray.add(5)
            winnerArray.add(9)
        }

        // diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
            winnerArray.add(3)
            winnerArray.add(5)
            winnerArray.add(7)
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
            winnerArray.add(3)
            winnerArray.add(5)
            winnerArray.add(7)
        }

        if(winner != -1){
            changeWinnerColor()
            Toast.makeText(this, "Player " + winner + " win the game", Toast.LENGTH_LONG).show()
            bu1.isEnabled = false
            bu2.isEnabled = false
            bu3.isEnabled = false
            bu4.isEnabled = false
            bu5.isEnabled = false
            bu6.isEnabled = false
            bu7.isEnabled = false
            bu8.isEnabled = false
            bu9.isEnabled = false
            winnerMsg.text = "Player $winner wins"
        }
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var winnerArray = ArrayList<Int>()
    var ActivePlayer = 1

     private fun PlayGame(cellId: Int, buSelected: Button) {
        if(ActivePlayer==1){
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.colorCream)
            player1.add(cellId)
            ActivePlayer = 2
        }
        else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.colorLightBlue)
            player2.add(cellId)
            ActivePlayer = 1

        }
        buSelected.isEnabled = false
    }
}
