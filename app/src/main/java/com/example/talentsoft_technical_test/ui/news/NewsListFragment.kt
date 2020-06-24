package com.example.talentsoft_technical_test.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentsoft_technical_test.R
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi
import com.example.talentsoft_technical_test.ui.news.view.adapter.NewsListAdapter
import kotlinx.android.synthetic.main.fragment_news_list.*


class NewsListFragment : Fragment() {

    private val viewModel: NewsListViewModel by lazy { NewsListViewModel() }
    private val recyclerAdapter = NewsListAdapter(this::clickOnHolder)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_news_list_recycler_view.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = recyclerAdapter
        }

        viewModel.uiData.observe(viewLifecycleOwner, Observer { pageNewsListUi ->
            recyclerAdapter.submitList(pageNewsListUi.newsList)
        })

        fragment_news_list_sources_spinner.apply {
            val adapter = ArrayAdapter(
                this@NewsListFragment.requireContext(),
                android.R.layout.simple_spinner_item,
                viewModel.getNewsSources()
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            setAdapter(adapter)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    viewModel.getNewsFromSource(0)
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.getNewsFromSource(position)
                }

            }
        }
    }

    private fun clickOnHolder(articleUi: ArticleUi) {
        val action =
            NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(articleUi)
        findNavController().navigate(action)
    }
}