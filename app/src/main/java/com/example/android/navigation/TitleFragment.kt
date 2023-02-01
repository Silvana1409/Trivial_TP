/*
Auteur : Silvana Esquivel H.
Annéé : 2022-2023
*/

package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
        val binding :FragmentTitleBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_title, container,false)
      // binding.playButton.setOnClickListener{view : View ->
          // Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)  }
        //code plus simple, navigation peut créer :
        binding.playButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )

        //pour dire q' nous avons un Menu associé au TitleFragm..
        setHasOptionsMenu(true)
        return binding.root
    }

    //Menus créés dans cette méthode:
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }
    //Quand un élément du Menu est appuyé
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}