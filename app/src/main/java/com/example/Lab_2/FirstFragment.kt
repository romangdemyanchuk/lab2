package com.example.Lab_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.Lab_2.databinding.FirstActivityBinding


class FirstFragment : Fragment() {

    lateinit var binding: FirstActivityBinding

    lateinit var adapter: Adapter
    val navController by lazy { findNavController() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstActivityBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rw = requireActivity().findViewById<RecyclerView>(R.id.rw)

        adapter = Adapter(requireContext()) { cat, position ->
            Toast.makeText(requireContext(), "${cat.Name}", Toast.LENGTH_SHORT).show()


        }
        adapter.setNewData(createGames())
        rw.adapter = adapter
    }


}