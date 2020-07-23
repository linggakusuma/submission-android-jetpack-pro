package com.example.submissionandroidjetpack.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionandroidjetpack.R
import com.example.submissionandroidjetpack.databinding.FragmentViewPagerBinding
import com.example.submissionandroidjetpack.ui.movie.MovieFragment
import com.example.submissionandroidjetpack.ui.tv.TvFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerFragment

class ViewPagerFragment : DaggerFragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var pagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewPagerBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPagerAdapter()
        initTabLayout()
    }

    private fun initPagerAdapter() {
        pagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.apply {
            offscreenPageLimit = 2
            adapter = pagerAdapter
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.movie)
                else -> getString(R.string.tv_show)
            }
        }.attach()
    }

    private inner class ViewPagerAdapter(
        fm: FragmentManager,
        lifecycle: Lifecycle
    ) : FragmentStateAdapter(fm, lifecycle) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> MovieFragment.newInstance()
            else -> TvFragment.newInstance()
        }
    }

}
