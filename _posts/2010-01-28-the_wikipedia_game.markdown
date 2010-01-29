---
layout: post
title: The Wikipedia Game
---

I've created a new game.  Quite originally, I've called it the Wikipedia Game.

Here's how you play:

1.  Choose a destination Wikipedia page at random.
2.  Start at the Wikipedia main page.  
3.  Using only the mouse (i.e. only hyperlinks), try to navigate to the chosen Wikipedia page (1).  You may use only the content of the page; no special pages along the sidebars/top/bottom.  For the main page, you may use the blue, green, and purple sections.
4.  The person with the least number of hops (pages) wins.  Alternatively, the person that gets there in the least amount of time wins.

This is sort of neat for several reasons.  [Wikipedia](http://en.wikipedia.org/wiki/Main_Page) is an enormous hyperconnected graph of information.  The challenge is a combination of speed, knowledge, and intuition based on what connections articles have.  I'm not convinced that there's a path from any article to any other article (in the limit case at least), but this can generally be accepted as true.  The browser takes care of recording a player's moves, so you can follow paths anywhere and if it doesn't pan out you just use the back button to retreat.  The browser will always report the last path, so when you arrive at the destination you'll have the full history (and it's easy to check).

The unique and different thing about The Wikipedia Game is that it relies on a sort of relational knowledge that people have.  Expertise in the subjects of the pages traversed isn't necessary at all; rather a feel for how the path of knowledge might spread to the goal is what determines success.

### e.g.

An example might help.  I tried this on January 15th and picked "Laser" at random.  My path was:

1.  Main Page
2.  Solar Eclipse of Jan 15, 2010
3.  Sun
4.  Thermal Radiation
5.  Electromagnetic Radiation
6.  [Laser](http://en.wikipedia.org/wiki/Laser)

6 Hops.  Not too bad.  

Next, I tried True Blood on January 28th.  The path: 

1.  Main Page
2.  Avatar (2009 film)
3.  Epic film
4.  Film
5.  Broadcast programming
6.  Category: Television Schedules
7.  Category: United States primetime network television schedules
8.  Category: 2008-2009 United States network television schedule
9.  Category: 2008 in American television
10.  Category: 2008 American television series debuts
11.  Category: 2008 American television series debuts
12.  [True Blood](http://en.wikipedia.org/wiki/True_blood)

Ugh.  A shorter try:

1.  Main Page
2.  Avatar (2009 film)
3.  List of highest grossing films in Canada and the United States
4.  The Twilight Saga: New Moon
5.  Category: Vampires in film and Television
6.  Category: Vampires in film and Television
7.  [True Blood](http://en.wikipedia.org/wiki/True_blood)

Better, but I still feel a bit iffy about using Categories.  It feels cheapish.

The strategy seems to be to pick something relevant, or at least orthogonal, and move to a very general page and then back to the specific page.  I suspect certain subjects will be easier than others.  Geography, history, or animal and plant species seem relatively easy compared to a more esoteric entry like, say, [Illegal Primes](http://en.wikipedia.org/wiki/Illegal_primes).

I suspect that a score over 10 isn't really trying too hard, especially if you allow Category pages.  Once you get down to about 6 or 7, dropping off each step will get harder.  Wikipedia has on the order of 10^6 articles, so that feels about right.

### Variants

Some variations include:

#### Starting page
* Use the Main page as described above.  This is unfortunately date specific.
* Use a different very general page to start from.  [Human](http://en.wikipedia.org/wiki/Human), [A](http://en.wikipedia.org/wiki/A) and the self referential joy of using [Wikipedia](http://en.wikipedia.org/wiki/Wikipedia) seem fun.

#### Special pages
* No special pages as described above.  This includes Category, Portal, Special, Talk, Wikipedia, etc.
* Allow only Category
* Allow any special page.  This would be most interesting if playing for speed.

#### Destination page
* Allow viewing of the destination page.
* Disallow viewing of the destination page.  This could be rough.

#### Keyboard use
* For speed games, allow Ctrl-F
