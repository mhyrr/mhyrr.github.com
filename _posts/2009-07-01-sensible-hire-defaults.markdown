---
layout: post
title: Sensible Hire Defaults
---

Recently, I've been close enough to hiring decisions to realize two things:

1.  Those hiring go about it all wrong.
2.  Because of this, it's remarkably easy to bullshit your way through an interview.

All too often, teams, projects, or companies bring on people that they quickly realize are either completely or partially worthless.  The hiree doesn't actually have the skills on their resume, or didn't have a very large part in that system they said they built, or whatever.  And then all of a sudden you have someone who, because they're quite probably a nice person, you'll have a remarkably hard time firing despite the fact that they're a drag on your code production.

Not that productivity has the last word.  If that person added a lot to culture, or process, or customer relationship insight, or some other slightly more fuzzy metric, then I wouldn't want to get rid of them either.  It's just very hard to tell which people you might hire are actually good at those things.

And that statement introduces the problem quite well.  So I'll repeat it:

*It's very hard to tell which people you might hire are actually good at what they claim to be good at.*

There's lots of reasons why this is true.  The reasons don't really matter.  The topic of being able to find good candidates through resumes and interviews has been covered ad nauseum by many, many others.  It's generally accepted as true.  What's more disturbing is pairing it directly with Brook's Law:

*Assigning more programmers to a project running behind schedule will make it even later.*

This rule is easily made more general.  Adding programmers to a project increases its complexity rapidly.  (For the sake of this article, we'll define 'programmers' to mean those on a project with some relevant base level of technical proficiency, despite their actual duties.)  

#### Hire Filter

When I pair these two statements together, I come up with a rule I want to follow when considering job candidates.

*I need someone I'm looking to hire to prove to me that I should hire them.*

In other words, the default state of my hire filter, before I've even met you, is not to hire you.  I'm sure you're a nice guy or gal.  I'm sure you know Blub.  I'm sure you have experience.  But you need to be able to prove that the value you add to a project is greater than the inherent complexity your addition to the project will create.

In most places I've ever been, and probably in most places everywhere, this isn't done.  Reading various articles about Google (notably Steve Yegge) leads one to the conclusion that Google implements something akin to a default no-hire policy.  They're more willing to take false negatives than they are false positives.

#### Well, he's reasonably intelligent..

For everyone involved, including the interviewee, this should make complete sense.  It's just not very "nice", and maybe that's the reason not many people do it.  I'm not really sure.  I know I've been in that situation before too though.  I've seen someone's resume and thought, "hey, not bad."  Then, I've seen them in an interview and thought, "Well, he's reasonably intelligent..."

And then I remembered George Carlin..  

<George Carlin>
	..Some people are really fucking stupid!
	Did you ever notice that? How many really stupid people you run into during the day? Goddamn there's a lot of stupid bastards walking around.  Carry a little pad and pencil with you. You'll wind up with thirty or forty names by the end of the day.  Look at it this way: *Think of how stupid the average person is and then realize that half of them are stupider than that.*  And it doesn't take you very long to spot one of them does it?  Takes you about eight seconds.  You'll be listening to some guy...then you'll say..."this guy is fucking stupid!"  
	Then there are some people, they're not stupid...they're full of shit.  That doesn't take very long to spot either, does it?  Takes you about the same amount of time.  You'll be listening to some guy..and saying, "Well, he's reasonably intelligent......ahh, he's full of shit!"
</George Carlin>

And again, this isn't entirely fair.  If I take a random 30 minute sampling of my intelligence, chances are it's way way below my running average, especially when I'm in a bland room filled with halogen lights and strangers asking me semi-technical questions.  Yeah, that's when I'm at my best.  Yet we all do that to people all the time, and we take that 30 minute sample as the average, and that's why it's so damn hard to figure out if someone is actually any good in an interview in the first place.

But besides that, part of Carlin's rant is empirically true.  Half the people out there are stupider than the average person, and the average person is rather stupid.  Interviews then become a chance to weed out the really fucking stupid people, because working with them would be just awful.  So there's this apparent tradeoff: you'll ditch the awful candidates and keep the average candidates.  Except according to Carlin they're pretty stupid too.  And according to Brooks, even if they aren't, they still have to overcome the inherent complexity of their addition to the project.  So isn't there some alternative?

Well, yes.  Find someone that blows you away.  Find someone that has an amazing innate sense of design, that can do pointer arithmetic for complex structures in their head, that knows which git branch command line options lists both remote and local branches, whatever.  But be impressed.  When you're impressed, there's a higher percentage shot at actually finding someone competent.  It doesn't guarantee it, you're still taking a random 30 minute sampling, but your chances are better.

#### Evil-ness

Having your default be [NO HIRE](http://github.com/raganwald/homoiconic/blob/master/2009-06-26/no_hire.md#readme) sidesteps other interesting issues too, most notably evil hire practices.  The only reason some company would be ridiculous enough to want access to someone's social networking profiles is to actively find a magical reason *not* to hire someone.  Is it really that hard?  Just don't hire them!  Then, when you find someone really good you actually do want to hire, you won't care that they have drunk pictures of themselves on Facebook or that they're a member of the NRA.

#### Apprenticeships

Even with the no-hire default turned on, interviewing still is not the best thing in the world.  It's exhausting, stressful, uncomfortable, anxious, and you have to deal with lots of people that are either "fucking stupid" or "full of shit".  Fixing the process is a really hard problem, and I don't think there's a good answer out there yet.  My first thought was to bring people on for a trial period of sorts.  You get paid, but you have to prove your worth.  If after 6 months you've had substantial positive overall impact, congratulations you're hired.  

But this sucks too.  In fact I had a series of interviews with a company that went just like that.  The work sounded interesting and the folks I talked to were cool.  Then they gave me the offer - I would basically be temping through an agency for a period of time before becoming an employee.  I immediately said "screw you" very politely and walked the other way.

So that's not so good.  In fact, the only reasonable solution I can think of seems to be: hire people that are already in your "worked-with" social graph, allowing for path length of 2.  In other words, only hire or bring on people that you've worked well with personally or that come highly recommended by someone you've worked with personally.  I think I have a lot more to say about this idea, but I'll save it for another evening, hopefully soon.

The only major omplication with the "worked-with" graph is the severe limit you place on personnel.  You are pulling from a much smaller pool.  If you listen to Joel Spolsky, Steve Yegge, or any of those sort of folks, the amazing candidates aren't generally out there for hire, so it isn't as if you're missing anything anyway.

#### A Conclusion?

To sum up: The default when seeking to fill a position should be no-hire.  This isn't nice on the surface, but it's more honest and solves more problems.   Hiring average fulfills Brook's Law.  Hiring by experiential reference is best.  So what have we learned?  Probably nothing, at least nothing that's going to change anytime soon.  No, that's not true - we learned George Carlin was good at making us laugh at the truth.
