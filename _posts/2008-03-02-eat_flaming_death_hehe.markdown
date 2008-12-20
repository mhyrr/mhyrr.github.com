---
layout: post
title: Eat Flaming Death.  Hehe.
---

{:perl:     lang=sh code_background_color='#efefff'}

	DB(1) @a = [3, 1, -1, 4, 0, 7];
	DB(2) p @a;
	ARRAY(0x104bfc2c)
	DB(3) $a = (3, 1, -1, 4, 0, 7);
	DB(4) p $a;
	7
	DB(5) eat flaming death
	Can’t locate object method “eat” via package “flaming”
	(perhaps you forgot to load “flaming”?) at
	(eval 27)[/usr/lib/perl5/5.8.2/.perl5db.pl:618] line 2.
	DB(6) @a = (3, 1, -1, 4, 0, 7);
	DB(7) p @a;
	31-1407
	DB(8) p join(‘, ‘, @a);
	3, 1, -1, 4, 0, 7
	DB(9) sort @a;
	DB(10) p @a;
	31-1407
	DB(11) p join(‘, ‘, sort @a);
	-1, 0, 1, 3, 4, 7”
{:perl}

Aside from being an amusing bit of humor, this situation characterizes something that bothers me about how a lot of people tend to use a computer.  In fact, I think it's one of the primary differences between those considered computer-savvy and those that are not.

Those that know what they're doing engage in play.

A computer is not something that breaks easily (nowadays), and usually most breaking is hardware based, not software based.  So unless you have sensitive data that requires saving (a quick operation generally), it should be fairly easy and unassuming to simply play.

I found this goofy little tidbit while reading <a href="http://steve.yegge.googlepages.com/ruby-tour">Steve Yegge's quick guide to Ruby,</a> a language which is rapidly becoming near and dear to me.  Steve uses a nice little example of Ruby's non-destructive functions (sort on an array in this case) and compares it to Perl and Python.  At the end of this interactive Perl session he says "So in Perl, after a bit of friendly interactive experimentation to remember..."  That's it.  I can't remember quite exactly what to do - normal for Perl, God help me - so I'll just figure it out as I go.

That's at the core of using computers today.  A large portion of the population uncertain about this approach is from older generations, and I'm sure we could say some interesting sociocultural things about that - in the post Depression, post WWII era of commodity materialism and casual, misunderstood miserliness.  But at the root of this lack of play is either disinterest or fear.  In most cases, it's usually a fear of breaking something.  Which, of course, in the world of software, memory, bits, and bytes.. is mostly absurd.
