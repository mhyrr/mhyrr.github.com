---
layout: post
title: Knight's Tour, Take One
---

There's been a lot of little stuff that I've been wanting to practice in the Java language that I haven't gotten the chance to look at in my day job.  So I decided to set myself a little task to try a couple of things.  I'd never really used Generics at all, and I'd never used Java Web Start.  On top of that, I wanted a little bit of extra algorithm practice (this seems to be a recurring theme, what with Project Euler, etc.. maybe I'm just masochistic in general).  I've always been fascinated with chess, even though I'm an abyssmal player.  Throughout history, a lot of very smart people have been fascinated with all of the combinations of moves and strategies.  Some of them became particularly fascinated with the idea of a <a href="http://en.wikipedia.org/wiki/Knight%27s_tour">Knight's Tour</a> - that is the movement of a Knight about a chessboard so that it hits each square only once.  Well, with code it's possible to come up with lots of solutions on variously sized boards.  So that's what I decided to do.

<a href="http://www.infiniteabyss.org/code/tours/tours.jnlp">Knight's Tour WebStart</a>

This is a tidy little app to find Knight's Tours.  The board size can vary (although it only seems to work well with square boards right now) as can the starting position.   Right now the algorithm is pretty crappy, it's just a brute force recursive shot at it.  When I have some time, I'll try to add something that does a better job.  But for right now this also means that the starting position can have a drastic effect on runtime.  To be fair, the Knight's Tour is a particular case of finding a Hamiltonian Cycle (NP-Complete), so it's hard.

If you really, really want to look at the crappy source for this, then fine, <a href="http://www.infiniteabyss.org/code/tours/src/">it's here</a>.  I urge you not to.  Since I used Generics (only very briefly), it requires Java 1.5.  One last note, Knight's Tours only exist for boards that are at least 5x5.
