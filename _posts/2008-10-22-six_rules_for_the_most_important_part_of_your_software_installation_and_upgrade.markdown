---
layout: post
title: Six Rules for the Most Important Part of Your Software: Installation and Upgrade
---

It doesn't take the extreme examples to realize that the general state of user interfaces in software suck.  The available levels of interface design are passable, bad, and OMG WTF?!  If you want to sell a product, it makes sense that you want to quell your user's use of expletives.  In fact, you don't just want to pacify them with something that's "good enough", you want to make them love you.  You want them exalting you with such loyalty that they'd rather cut off pieces of anatomy than let someone they care about use a competitor's deficient product.  That's how you increase your sales, your branding, and your karma in the world.

Once a customer buys in to your product, what's the first thing they do?  They install it on their computer. (If it's a webapp, they register, create an account, etc.. the same rules apply.)  This is your big chance!  You can either Wow your new customer with something amazing, or you can bore them with the same cheesy install wizard and pray that they've become so immune to the stupidity of UI design that they won't recognize the inanity of it.

First impressions last forever.  That's why the install and upgrade processes are so remarkably important.  Over the last few months, my team has revamped our entire installation process for our product.  Along the way, I've gotten to thinking more about installations and have paid more attention to the hoops many people jump through with common pieces of software.

Here are some rules for making a great first impression.

### One Click Is All It Takes

No piece of end-user software, aside from maybe an operating system, is so important that it needs to take more than one click to install.  You don't coddle a user by flashing a Welcome Screen that introduces them to your install wizard.  You coddle them by making them say, "Gosh, that's it?  That was easy."  On our product, we went from a series of 4 or 5 dialogs asking various questions or supplying intermediate steps.  The user input between steps was generally just to click "Next".  They really don't need to do that.  Now, our install process can be completed in one click.  They hit the install button and off it runs.  After completion, it brings up the app for you.

### As Simple As Possible, But Not Simpler

Most apps have some configuration options that can be set during installation.  Our install screen provides a couple of options for configuration, but it doesn't force the user to act on any of them.  They can still just click "Install".  We've taken pains to provide smart defaults so that 90% of our users don't have to do a thing.  And that's perfect.  Most users don't care.  You might be aghast that your log files don't end up in a certain directory, but normal people aren't.

Gall's Law applies here.  To be fair, it applies most places.

"*A complex system that works is invariably found to have evolved from a simple system that worked. The inverse proposition also appears to be true: A complex system designed from scratch never works and cannot be made to work. You have to start over, beginning with a working simple system.*"

Starting with a big dialog with lots of different options and settings is a bad idea.  Putting one setting on each page of your "wizard" and making a user hit "Next" in between doesn't help.  Instead of starting with all of your configuration, start with nothing and see if you can add *nothing* to it.  I'll bet you can.  Only in rare cases, like operating systems, is there any configuration that is really and truly necessary.  Get to the point when there isn't anything left to remove from your install options.

“*You know you’ve achieved perfection in design, not when you have nothing more to add, but when you have nothing more to take away.*” - Antoine de Saint Exupery

### Stay Responsible Over Your Domain

There are libraries and installers available to take the coding work for install off your hands.  This seems intriguing at first.  It should let you focus on your very important, application specific, domain specific code.  I recommend resisting this temptation and writing your installers yourself.

Our original installer for our Java product was IzPack. That made it needlessly long, and it did not fail gracefully when it failed.  I looked at replacing it with another IzPack installer as well as JSmooth, Launch4J, and Antigen.  In my botched attempts, I still had no warm and fuzzy feeling that I was doing anything better than the previous installer.  There were still multiple dialogs and they were still overwhelmingly filled with that ridiculously melancholy Windows gray color (where did they get that?).

In the end, we ended up writing the whole installer ourselves.  I feel rather pleased with it.  It's simple and effective.  More importantly, it doesn't piss off our users.  If you believe, like me, that first impressions are important, then installation ranks just as highly as all of your really exciting business logic.  Your user just gave you money, or is deciding to give you money.  Your job is to convince them they're making the right choice.  It shouldn't be ambiguous.

### Be Elegant

The default Windows blue and grey is, to me, as depressing as deteriorating cubicle walls affixed with Dilbert cartoons.  You can do better, especially if you're keeping control of the design and coding of installation.  Pick a color theme that resonates with your product.  Make your widgets look like they do in your app.  Keep the fonts appropriate.  If you have a designer available, make sure to get input.   First impressions, and all that.

### Leave The User In Charge

Finally, the one truly unforgivable wrong is taking control away from the user.  When the iPhone 2.0 software first came out, the biggest complaint was the lack of control.  If I hit the lock button there was a several second pause before I heard the little clicky sound.  The same several second pause occurred when opening Mail or SMS messages.  It made most people on edge and frustrated.  [Joel talks a lot about that clicky sound](http://www.joelonsoftware.com/articles/HighNotes.html).

During installation, a user should have knowledge of what's going on at all times.  If you're busy doing something in the background, give them a progress bar that updates appropriately.  A step shouldn't be surprising in duration in any way.  If it takes 4 seconds or 40 seconds, it's your job to make sure the expectation is set.

### Imitate What You Like

I love the Mac install process.  You just drag and drop your application into the Applications folder.  That's it, nothing else.  A lot of apps go one step further, [like Firefox](http://www.myfirstmac.com/images/uploads/articleImages/FIREFOX-WINDOW.gif).  The window lets you do only one thing - drag the Firefox app icon into the Apps folder.  Simple, elegant with a nice little semi-transparent Firefox logo, and effective.  I immediately think that this browser must be a slim, elegant little piece of software that stays out of the way when I'm using it for it's primary purpose: browsing web pages.  It just does its job.

[Posterous](http://posterous.com/) is an excellent webapp example.  They've removed the install process completely - if you want to start a Posterous account, you just email your first post and they do the account setup for you.  What a great system!

Keep an eye out on what other apps do (./configure,make don't count).  Keep your interface elegant.  Keep it simple.  And keep control of the code.
