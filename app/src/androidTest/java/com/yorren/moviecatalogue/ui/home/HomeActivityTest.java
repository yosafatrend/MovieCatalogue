package com.yorren.moviecatalogue.ui.home;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class HomeActivityTest {
    private ArrayList<Movies> dummyMovies = DataDummy.generateDummyMovies();
    private ArrayList<TvShows> dummyTvShows = DataDummy.generateDummyTvShows();

    @Rule
    public ActivityScenarioRule activityScenarioRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
    }

    @Test
    public void loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies.get(0).getTitle())));
        onView(withId(R.id.tv_director)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_director)).check(matches(withText("Directed by : " +dummyMovies.get(0).getDirector())));
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date)).check(matches(withText("Release date : " +dummyMovies.get(0).getReleaseDate())));
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration)).check(matches(withText("Duration : " +dummyMovies.get(0).getDuration())));
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre)).check(matches(withText("Genre : " +dummyMovies.get(0).getGenre())));
    }

    @Test
    public void loadTvShows(){
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition(dummyTvShows.size()));
    }

    @Test
    public void loadDetailTvShows(){
        onView(withText("Tv Shows")).perform(click());
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShows.get(0).getTitle())));
        onView(withId(R.id.tv_director)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_director)).check(matches(withText("Directed by : " +dummyTvShows.get(0).getDirector())));
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release_date)).check(matches(withText("Release date : " +dummyTvShows.get(0).getReleaseDate())));
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration)).check(matches(withText("Episodes : " +dummyTvShows.get(0).getEpisodes())));
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre)).check(matches(withText("Genre : " +dummyTvShows.get(0).getGenre())));
    }
}