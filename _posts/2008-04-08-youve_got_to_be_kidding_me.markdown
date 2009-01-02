---
layout: post
title: You've Got To Be Kidding Me
---


<img src="http://imgs.xkcd.com/comics/e_to_the_pi_times_i.png" height="481" width="400" />

Sometimes the universe is just weird.  Not weird in the things-are-really-completely-random way, but in the profound-truth-that-I-can't-possibly-understand way.  You know, [Banack-Tarski Paradox](http://en.wikipedia.org/wiki/Banach-Tarski_paradox) weird.  [Euler's Identity](http://en.wikipedia.org/wiki/Euler's_identity) weird.  Weird like Monty Hall weird.

Ok, I don't really mean Monty Hall, I mean the Monty Hall Problem named after him.  But I'm sure he is weird.  Everything that was popular in the 70s was weird.

Anyway, the Monty Hall Problem.  It's pretty weird.  The basic premise goes like this: you get to choose 1 of 3 doors.  1 of the 3 doors has a new car behind it, the other 2 have goats.  After you've made your choice, Monty Hall shows you a goat behind one of the doors, and asks if you'd like to switch doors to the other remaining unopened door.  Is there a statistical difference between your two choices?  (For a precise definition, see the [Wikipedia article](http://en.wikipedia.org/wiki/Monty_hall_problem).

I won't keep you in suspense.  You've got a 2 in 3 shot at it if you switch, and only a 1 in 3 shot if you don't.  There really is a difference, as the myriad proofs on Wikipedia show.  But it's just a weird answer.  Our gut tells us you've got a 50/50 shot either way.

A while back, I argued with a friend about this for awhile.  She was absolutely convinced that it was 50/50.  We went back and forth for awhile and didn't really get anywhere (my verbal exposition was not up to snuff).  Today I read a [New York Times article](http://query.nytimes.com/gst/fullpage.html?res=9D0CEFDD1E3FF932A15754C0A967958260&amp;sec=&amp;spon=&amp;pagewanted=all) that talks about the problem and it reminded me of her insistence.  Sometimes there's just nothing like empirical evidence.  So I whipped up a little script to run through a large sample set for this problem.

Here's the results from 2 runs:

	DO NOT SWITCH DOORS: 1,000,000 trials conducted

	Results:
	Pick Distribution:
	Door 1:	332588
	Door 2:	333606
	Door 3:	333806
	Goat Distribution:
	Door 1:	333507
	Door 2:	333938
	Door 3:	332555
	Correct: 333134, 33%
	Incorrect: 666866, 67%

	=====

	SWITCH DOORS: 1,000,000 trials conducted

	Results:
	Pick Distribution:
	Door 1:	332871
	Door 2:	333808
	Door 3:	333321
	Goat Distribution:
	Door 1:	333779
	Door 2:	332836
	Door 3:	333385
	Switch Distribution:
	Door 1:	333350
	Door 2:	333356
	Door 3:	333294
	Correct: 666571, 67%
	Incorrect: 333429, 33%

	========================================

	DO NOT SWITCH DOORS: 1,000,000 trials conducted

	Results:
	Pick Distribution:
	Door 1:	334011
	Door 2:	333256
	Door 3:	332733
	Goat Distribution:
	Door 1:	332870
	Door 2:	333830
	Door 3:	333300
	Correct: 333308, 33%
	Incorrect: 666692, 67%

	=====

	SWITCH DOORS: 1,000,000 trials conducted

	Results:
	Pick Distribution:
	Door 1:	333526
	Door 2:	333202
	Door 3:	333272
	Goat Distribution:
	Door 1:	332794
	Door 2:	333637
	Door 3:	333569
	Switch Distribution:
	Door 1:	333680
	Door 2:	333161
	Door 3:	333159
	Correct: 666985, 67%
	Incorrect: 333015, 33%
	
It works out.  But it's still non-intuitive.  I just love that the world works like that sometimes.  If things were always real simple, the entire Universe would be completely knowable, and that would be boring.  So rejoice when things are weird.

Here's the bad code to do it:
<script src="http://gist.github.com/42591.js"> </script>
