package com.example.exercise_add_another_screen_to_your_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_add_another_screen_to_your_app.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {
    //RECYCLER LIST
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemList>
    private lateinit var adapter: MyAdapter


    private lateinit var imageId: Array<Int>
    private lateinit var titolo : Array<String>


    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //RECYCLER VIEW
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        newRecyclerView = view.findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = layoutManager
        newRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter


        binding.buttonToSecFrag.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }
    }

    private fun dataInitialize() {
        newArrayList = arrayListOf<ItemList>()

        titolo = arrayOf(
            getString(R.string.string1),
            getString(R.string.string2),
            getString(R.string.string3)
        )

        imageId = arrayOf(
            R.drawable.diet,
            R.drawable.hamburger,
            R.drawable.logo_g
        )
        for (i in imageId.indices) {
            val item = ItemList(titolo[i], imageId[i])
            newArrayList.add(item)
        }
    }
}