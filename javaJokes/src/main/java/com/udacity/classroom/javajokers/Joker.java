package com.udacity.classroom.javajokers;

import java.util.Random;

public class Joker {
    public String getJoke() {
        String[] jokes = {"Q. How does a computer get drunk? A. It takes screenshots.",
            "Q: What did the spider do on the computer? A: Made a website!",
            "Q: What did the computer do at lunchtime? A: Had a byte!",
            "Q: Why was the computer cold? A: It left it's Windows open!",
            "Q: What do you get when you cross a computer with an elephant? A: Lots of memory!"};

        return jokes[new Random().nextInt(jokes.length)];
    }
}
