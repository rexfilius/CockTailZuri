package com.github.rexfilius.cocktailzuri.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.github.rexfilius.cocktailzuri.R
import com.github.rexfilius.cocktailzuri.api.Api
import com.github.rexfilius.cocktailzuri.api.DrinkDetail
import com.github.rexfilius.cocktailzuri.api.Repository
import com.github.rexfilius.cocktailzuri.databinding.FragmentDetailBinding
import com.github.rexfilius.cocktailzuri.fragments.main.MainFragment.Companion.ID_ARGS

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val drinksDetail = mutableListOf<DrinkDetail>()

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this, DetailViewModelFactory(Repository(Api.apiService)))
            .get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = ""
        arguments?.let {
            id = it.getString(ID_ARGS).toString()
        }
        viewModel.getDrinksDetail(id)

        viewModel.drinksDetailLiveData.observe(viewLifecycleOwner, {
            drinksDetail.addAll(it)
        })

        binding?.instructionTv?.text = drinksDetail[0].instruction
        binding?.thumbIv?.load(drinksDetail[0].drinkThumb)

        activity?.title = drinksDetail[0].drinkName

    }


}