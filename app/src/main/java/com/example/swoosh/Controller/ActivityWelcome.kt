package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import com.example.swoosh.databinding.ActivityWelcomeBinding

class ActivityWelcome : BaseActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getStartedBtn.setOnClickListener{
            val leagueIntent = Intent(this, ActivityLeague::class.java)
            startActivity(leagueIntent)
        }
    }
}