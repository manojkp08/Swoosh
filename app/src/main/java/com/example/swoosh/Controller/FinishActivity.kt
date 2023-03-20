package com.example.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swoosh.Model.Player
import com.example.swoosh.R
//import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_PLAYER
//import com.example.swoosh.Utilities.EXTRA_SKILL
import com.example.swoosh.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_finish)

//        val league = intent.getStringExtra(EXTRA_LEAGUE)
//        val skill = intent.getStringExtra(EXTRA_SKILL)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        if (player != null) {
            binding.searchLeagText.text = "Looking for ${player.league} ${player.skill} league near you..."
        }
    }
}

class ActivityFinishBinding {

}
