/*
Auteur : Silvana Esquivel H.
Annéé : 2022-2023
*/

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener{ view :View ->
            //view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            //REMPLACEMENT la navigation par un ID d'action
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        //obtenir les aguments du Groupe WON
        var args = GameWonFragmentArgs.fromBundle(arguments!!)
        //Pour afficher q les arguments ont été passés avec succès
        Toast.makeText( context,"Num correct: ${args.numCorrect},NumQuestions: ${args.numQuestions}",
            Toast.LENGTH_SHORT).show()
        return binding.root
    }
}
