package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.Utilities.EXTRA_PLAYER
import com.example.swoosh.databinding.ActivityLeagueBinding
import com.example.swoosh.databinding.ActivitySkillBinding

class ActivitySkill : BaseActivity() {

    private lateinit var binding: ActivitySkillBinding
//    var league = ""
//    var skill = ""
    lateinit var player :Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        setContentView(binding.root)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!

        binding.beginnerBtn.setOnClickListener {
            binding.ballerBtn.isChecked = false
            player.skill = "beginner"
        }

        binding.ballerBtn.setOnClickListener {
            binding.beginnerBtn.isChecked = false
            player.skill = "baller"
        }

        binding.finishBtn.setOnClickListener {
            if (player.skill != ""){
                val finishActivity = Intent(this, FinishActivity::class.java)
//                finishActivity.putExtra(EXTRA_LEAGUE, league)
//                finishActivity.putExtra(EXTRA_SKILL, skill)
                  finishActivity.putExtra(EXTRA_PLAYER, player)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}