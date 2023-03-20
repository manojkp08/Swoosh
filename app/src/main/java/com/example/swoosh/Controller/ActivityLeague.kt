package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.Utilities.EXTRA_PLAYER
import com.example.swoosh.databinding.ActivityLeagueBinding


class ActivityLeague : BaseActivity() {

    private  lateinit var binding: ActivityLeagueBinding

    //var selectedLeague = ""
    var player = Player("", "")
    //we created a mutable variable above because if we will create an immutable variable
    // then we will not be able to reassign it later.

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mensLeagueBtn.setOnClickListener {
            binding.womensLeagueBtn.isChecked = false
            binding.coedBtn.isChecked =false
//            selectedLeague = "mens"
            player.league = "mens"
        }

        binding.womensLeagueBtn.setOnClickListener {
            binding.mensLeagueBtn.isChecked = false
            binding.coedBtn.isChecked = false
//            selectedLeague = "womens"
            player.league = "womens"
        }

        binding.coedBtn.setOnClickListener {
            binding.mensLeagueBtn.isChecked = false
            binding.womensLeagueBtn.isChecked = false
//            selectedLeague = "co-ed"
            player.league = "co-ed"
        }

        binding.leagueBtn.setOnClickListener {
            if (/*selectedLeague != "" */ player.league != ""){
                val skillIntent = Intent(this, ActivitySkill::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                // now we will not use string as our 2nd key value as we have used earlier. Now we will use parcelable as our second key.
                startActivity(skillIntent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        savedInstanceState?.let { super.onRestoreInstanceState(it) }
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun leagueNextClicked(view: View) {}
}