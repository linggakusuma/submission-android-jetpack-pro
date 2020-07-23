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

    fun generateDummyTv(): List<MovieEntity> {
        val tv = ArrayList<MovieEntity>()
        tv.add(
            MovieEntity(
                "tv1",
                "Thieves of the Wood",
                "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
                "https://image.tmdb.org/t/p/w1280/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
                "January 2, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv2",
                "Star Trek: Picard",
                "Star Trek: Picard features Sir Patrick Stewart reprising his iconic role as Jean-Luc Picard, which he played for seven seasons on Star Trek: The Next Generation. Set twenty years after the events of Star Trek Nemesis, this series follow the now-retired Admiral Picard into the next chapter of his life.",
                "https://image.tmdb.org/t/p/w1280/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg",
                "January 23, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv3",
                "AJ and the Queen",
                "While traveling across the country in a run-down RV, drag queen Ruby Red discovers an unlikely sidekick in AJ: a tough-talking 10-year-old stowaway.",
                "https://image.tmdb.org/t/p/w1280/f4rxVYDVCTeHAyZf1W8tlUMvd1.jpg",
                "January 10, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv4",
                "9-1-1: Lone Star",
                "Nearly 20 years ago, Owen Strand was the lone survivor of his Manhattan firehouse on 9/11. In the wake of the attack, Owen had the unenviable task of rebuilding his station. After a similar tragedy happens to a firehouse in Austin, Owen, along with his troubled firefighter son, T.K., takes his progressive philosophies of life and firefighting down to Texas, where he helps them start anew. On the surface, Owen is all about big-city style and swagger, but underneath he struggles with a secret he hides from the world - one that could very well end his life.",
                "https://image.tmdb.org/t/p/w1280/vE1iYEM52EHkhZSzcEnQP1Uvei8.jpg",
                "January 19, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv5",
                "The Outsider ",
                "When an insidious supernatural force edges its way into a seemingly straightforward investigation into the gruesome murder of a young boy, it leads a seasoned cop and an unorthodox investigator to question everything they believe in.",
                "https://image.tmdb.org/t/p/w1280/aMiPwPQjQI1EZN3xP2V0sSU37dc.jpg",
                "January 12, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv6",
                "Rise of Empires: Ottoman ",
                "Ottoman Sultan Mehmed II wages an epic campaign to take the Byzantine capital of Constantinople and shapes the course of history for centuries.",
                "https://image.tmdb.org/t/p/w1280/nkvdPFYo7o2IQWooJvA9UE0nvAp.jpg",
                "January 24, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv7",
                "Messiah",
                "A wary CIA officer investigates a charismatic man who sparks a spiritual movement and stirs political unrest. Who exactly is he? And what does he want?",
                "https://image.tmdb.org/t/p/w1280/psem2jK9GGC0g7dcjb4N5SCYb1u.jpg",
                "January 1, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv8",
                "COBRA",
                "As widespread power outages cause chaos and threaten lives across the country, the COBRA committee comprised of the UK’s leading experts and politicians, gathers to find a way to turn the lights back on.",
                "https://image.tmdb.org/t/p/w1280/uu44VNAq6yhQi0PamsSXXYS1sLr.jpg",
                "January 17, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv9",
                "October Faction",
                "Monster hunters Fred and Deloris Allen tangle with evil ... and family drama with their teenage twins. From the comics by Steve Niles and Damien Worm.",
                "https://image.tmdb.org/t/p/w1280/7yrXh19tH2ThJHXriORT16WKbBi.jpg",
                "January 23, 2020"
            )
        )
        tv.add(
            MovieEntity(
                "tv10",
                "Outmatched",
                "A blue-collar couple in Atlantic City tries to raise four kids – three of whom just happen to be certified geniuses.",
                "https://image.tmdb.org/t/p/w1280/unDQpkyjUgidICSCcpcUFBjIvu7.jpg",
                "January 23, 2020"
            )
        )
        return tv
    }
}