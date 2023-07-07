package com.example.ademolatikare

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ademolatikare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Setup app variables
    private lateinit var binding: ActivityMainBinding
    private var teamOneScore = 0
    private var teamTwoScore = 0
    private var gamePoint = 1;

    //Inflate view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar);
        setupEvents()
    }

    //Setup app event listeners
    private  fun setupEvents(){
        binding.btnAddTeamOne.setOnClickListener {
            teamOneScore  = scoreValidation(teamOneScore+gamePoint)
            updateTeamOneScore()
        }
        binding.btnMinusTeamOne.setOnClickListener {
            teamOneScore  = scoreValidation(teamOneScore-gamePoint)
            updateTeamOneScore()
        }
        binding.btnAddTeamTwo.setOnClickListener {
            teamTwoScore  = scoreValidation(teamTwoScore+gamePoint)
            updateTeamTwoScore()
        }
        binding.btnMinusTeamTwo.setOnClickListener {
            teamTwoScore  = scoreValidation(teamTwoScore-gamePoint)
            updateTeamTwoScore()
        }

        //Allows us to know the selection game point to be used
        binding.gamePointOptions.setOnCheckedChangeListener { _, checkedId ->

            // Check which radio button was clicked
            when (checkedId) {
                R.id.score1RadioButton ->{
                    gamePoint = 1
                }
                R.id.score2RadioButton -> {
                    gamePoint = 2
                }
                R.id.score3RadioButton -> {
                    gamePoint = 3
                }
            }
        }
    }

    //Update team one's score
    private fun updateTeamOneScore(){
        binding.tvScoreTeamOne.text = teamOneScore.toString()
    }

    //Update team two's score
    private fun updateTeamTwoScore(){
        binding.tvScoreTeamTwo.text = teamTwoScore.toString()
    }


    //Validate the score value (i.e min =0 and max = 20) and returns the appropriate value
    private fun scoreValidation(value: Int): Int{
        if(value<0){
            Toast.makeText(this, "Minimum score is 0",Toast.LENGTH_LONG).show()
            return 0;
        }

        if(value>20){
            Toast.makeText(this, "Maximum score is 20",Toast.LENGTH_LONG).show()
            return 20;
        }
        return value;
    }

}