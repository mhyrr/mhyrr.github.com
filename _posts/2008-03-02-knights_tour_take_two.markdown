---
layout: post
title: Knight's Tour, Take Two
---

Well, after last night's post I did a little bit of reading on better ways to do this, aside from my horrible, ridiculously slow recursive implementation. Turns out that a guy named Warnsdorff discovered a clever little heuristic for the recurvsive implementation in the 19th century. All you do is take all the possible moves for each one of your possible moves and move to the next square with the least number of possible moves. This works for small boards ( less than 76x76). A bunch more is described on <a href="http://mathworld.wolfram.com/KnightsTour.html">Wolfram's MathWorld</a>.

Anyway, I implemented the improvement this morning, and it's pretty trick. Most boards get computed in linear time. Most boards get completed in less than 100 ms. There's apparently a neural net solution that is pretty neat that I may implement at some point. I'd like to do some custom painting to show the path better too.

Here's the link again: <a href="http://www.infiniteabyss.org/code/tours/tours.jnlp">Knight's Tour</a>

** Quick Edit.. the custom painting is in now too, but only for the Warnsdorff solution, I didn't feel like tracking my backtracking.
