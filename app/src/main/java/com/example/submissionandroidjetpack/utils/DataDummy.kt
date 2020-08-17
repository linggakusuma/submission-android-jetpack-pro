package com.example.submissionandroidjetpack.utils

import com.example.submissionandroidjetpack.data.MovieEntity
import com.example.submissionandroidjetpack.data.source.remote.response.Movie

object DataDummy {

    fun generateDummyMovie(): List<Movie> {
        val movies = ArrayList<Movie>()
        movies.add(
            Movie(
                "297761",
                "/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg",
                "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
                "Suicide Squad",
                null,
                "5.91",
                "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                "2016-08-03",
                null
            )
        )

        return movies
    }

    fun generateDummyTv(): List<Movie> {
        val tv = ArrayList<Movie>()
        tv.add(
            Movie(
                "2734",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
                null,
                "Law & Order: Special Victims Unit",
                "5.91",
                "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                "2016-08-03",
                null
            )
        )
        return tv
    }
}