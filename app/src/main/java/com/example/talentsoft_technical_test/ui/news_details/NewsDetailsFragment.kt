package com.example.talentsoft_technical_test.ui.news_details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.talentsoft_technical_test.R
import com.example.talentsoft_technical_test.databinding.FragmentNewsDetailsBinding

class NewsDetailsFragment : Fragment() {

    private val viewModel: NewsDetailsViewModel by lazy { NewsDetailsViewModel() }
    private val args: NewsDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentNewsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_news_details, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleUi = args.articleUi
        viewModel.setArticleData(articleUi, View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(articleUi.url)
            ContextCompat.startActivity(requireContext(), i, null)
        })
    }
}