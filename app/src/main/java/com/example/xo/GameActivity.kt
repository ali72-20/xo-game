package com.example.xo

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.xo.conset.Conest
import com.example.xo.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar
enum class FeasibleState {
    NOT_SET,
    PLAYER_ONE,
    PLAYER_TWO
}
class GameActivity : AppCompatActivity() {

    lateinit var viewBinding : ActivityGameBinding
    lateinit var currentPlayer: String
    lateinit var name1:String
    lateinit var name2:String
    lateinit var turn:String
    private var gameState = mutableListOf<FeasibleState>()
    lateinit var grid : MutableList<Button>
    private var fieldsUsed = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.appBarTil.toolBar)
        initView()

    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
         name1 = intent.getStringExtra(Conest.firstName)?:""
         name2 = intent.getStringExtra(Conest.secondName)?:""
        viewBinding.name1.text = name1
        viewBinding.name2.text = name2
        currentPlayer = name1
        turn = "X"
        var i = 0
        while (i < 9) {
            gameState.add(FeasibleState.NOT_SET)
            i++
        }
        grid = mutableListOf()
        grid.add(viewBinding.cell0)
        grid.add(viewBinding.cell1)
        grid.add(viewBinding.cell2)
        grid.add(viewBinding.cell3)
        grid.add(viewBinding.cell4)
        grid.add(viewBinding.cell5)
        grid.add(viewBinding.cell6)
        grid.add(viewBinding.cell7)
        grid.add(viewBinding.cell8)


        grid.forEach{button->
            viewBinding.turn.text = "$currentPlayer $turn"
            button.setOnClickListener{
                pressButton(button)
                viewBinding.turn.text = "$currentPlayer $turn"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun pressButton(button: Button) {
        if(button.text.toString() == "X" || button.text.toString() == "O"){
            Toast.makeText(this,"In valid  cell",Toast.LENGTH_SHORT).show()
            return
        }
        fieldsUsed++
        viewBinding.turn.text = "$currentPlayer $turn"
           button.setText(turn)
           button.setTextColor(Color.WHITE)
        var isWinnerFound  = false
            val bulider : AlertDialog.Builder = AlertDialog.Builder(this)
            if(turn == "X"){
                button.setBackgroundColor(Color.BLUE)
                gameState[button.tag.toString().toInt()] = FeasibleState.PLAYER_ONE
                if(checkGameState(FeasibleState.PLAYER_ONE)){
                    isWinnerFound = true
                }
            }else{
               button.setBackgroundColor(Color.RED)
                gameState[button.tag.toString().toInt()] = FeasibleState.PLAYER_TWO
                if(checkGameState(FeasibleState.PLAYER_TWO)){
                   isWinnerFound = true
                }
            }
        if(isWinnerFound) {
            bulider.setTitle("$currentPlayer is Winner").setPositiveButton("Ok"){dialog, wich->
                finish()
            }
            val dialog : AlertDialog = bulider.create()
            dialog.show()
        }
        turn = if(turn == "X") "O"
        else "X"

        currentPlayer = if(currentPlayer == name1) name2
        else name1
        if(fieldsUsed == 9){
            bulider.setTitle("Game is Draw").setPositiveButton("Ok"){dialog, wich->
                finish()
            }
            val dialog : AlertDialog = bulider.create()
            dialog.show()
        }

    }

    private fun checkGameState(currentPlayer: FeasibleState): Boolean {
        if (gameState[0] === currentPlayer && gameState[1] === currentPlayer
            && gameState[2] === currentPlayer) {
            return true
        }

        if (gameState[3] === currentPlayer && gameState[4] === currentPlayer
            && gameState[5] === currentPlayer) {
            return true
        }

        if (gameState[6] === currentPlayer && gameState[7] === currentPlayer
            && gameState[8] === currentPlayer) {
            return true
        }

        if (gameState[0] === currentPlayer && gameState[3] === currentPlayer
            && gameState[6] === currentPlayer) {
            return true
        }

        if (gameState[1] === currentPlayer && gameState[4] === currentPlayer
            && gameState[7] === currentPlayer) {
            return true
        }

        if (gameState[2] === currentPlayer && gameState[5] === currentPlayer
            && gameState[8] === currentPlayer) {
            return true
        }

        if (gameState[0] === currentPlayer && gameState[4] === currentPlayer
            && gameState[8] === currentPlayer) {
            return true
        }

        if (gameState[2] === currentPlayer && gameState[4] === currentPlayer
            && gameState[6] === currentPlayer) {
            return true
        }

        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}

private fun AlertDialog.Builder.setPositiveButton(s: String, function: () -> Unit) {

}
