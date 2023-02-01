/*
Auteur : Silvana Esquivel H.
Annéé : 2022-2023
*/

package com.example.android.navigation

import android.content.Intent
import android.os.Bundle
import android.view.*
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
        //var args = GameWonFragmentArgs.fromBundle(arguments!!)
        //Pour afficher q les arguments ont été passés avec succès
        //Toast.makeText( context,"Num correct: ${args.numCorrect},NumQuestions: ${args.numQuestions}",
          //  Toast.LENGTH_SHORT).show()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu,menu)
    }
    //méthode pour l'intention partage
    private fun getShareIntent(): Intent{
        //on déplace les arguments de fragment de WON
        var args = GameWonFragmentArgs.fromBundle(arguments!!)
        //nvelle intention implicite de partage
        val shareIntent = Intent(Intent.ACTION_SEND)
        //Type de données q on va partager
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,
                getString(R.string.share_success_text,args.numCorrect,args.numQuestions))

        return shareIntent

    }
    //méthode supp pour réaliser le partage
    private fun shareSucces(){
        //démarre l'activité avec l'intention qui démarre notre nvll intention
        startActivity(getShareIntent())

    }
    //quand on appui sur partage
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.share->shareSucces()
        }
        return super.onOptionsItemSelected(item)
    }
}
