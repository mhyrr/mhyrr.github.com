---
layout: post
title:  My Evented Life - Why Asynchronous I/O Does Not Work Everyday
---

Recently, I (re)read two articles that made clear to me the misappropriation of time in most people's lives.  The first was Paul Graham's ["Maker's Schedule, Manager's Schedule"](http://www.paulgraham.com/makersschedule.html).  The second was Alex Payne's rundown of his [life as a series of queues](http://al3x.net/2008/12/22/life-as-queues.html).

Most people, including me, tend to operate their lives based on events, where we can define an event as any outside stimuli requiring a response.  Want some callback examples?  

For a wakeup alarm:

		function(evt:AlarmEvent):void {
			if it's a weekday && there's an important early meeting:
				getUp()
			else if it's a weekday && no pressing meeting:
				snooze()
			else it's a weekend:
				turnOffAlarm() //shouldn't have been on!
		}

For a meeting:

		function(evt:MeetingEvent):void {
			if it's important:
				dropEverythingImmediatelyAndAttend()
			else
				blatantlyIgnore()
		}

For a phone call:

		function(evt:PhoneCallEvent):void {
			if known_caller:
				answer()
			else
				ignoreAndPonderListeningToStupidVoicemail()
		}

We could use this for ChatEvents, TwitterEvents, FacebookEvents, EmailEvents, and on and on.  The sheer volume of stimuli we respond to today can be overwhelming.  We wait for these things constantly and we hang on the chance to respond.  Even when we ignore the event, we've dealt with it somehow.  The event has still caused an interrupt!  Nothing substantive ever gets done this way.  It sucks.

One of my favorite quotes from Don Knuth is on his FAQ under "Why did you stop using email [back in 1990!]".  The quote:

> Email is a wonderful thing for people whose role in life is to be on top of things. 
> But not for me; my role is to be on the bottom of things. 

Education over the last few decades has been driven more and more by the idea that everyone should get a college degree.  This has meant a huge glut of marketing, business, public relations, history, english, and communications majors with no real direction aside from the abstract concept that American capitalism needs more middle managers.  That's what they've been taught.

In the same way, every industry that makes up American capitalism has naturally trended towards more and more frequent communication and meetings.

The important point to consider is whether the particular role someone plays requires them to be on top of things or on the bottom of things.

A customer service rep, PR spinner, nurse, or real estate agent most certainly needs to be on top of things.  A computer scientist, writer, engineer, or scientist generally needs to be on the bottom of things.  In the same way that we need to do a better job of teaching intuition and design in our schools, we need to do a better job of allowing intuition and design to happen at our jobs.

More personally, my goal this year has been to set aside some time each week, usually on Saturday mornings, where I get to be on the bottom of things.  Writing is not my job (yet..), it's just something I'm very fond of doing.  When I have the chance, I take my laptop to my favorite bagel place, which has no Wifi, and I either write or code.  For a couple of blessed hours, silence reigns.  Thinking is possible.  

More of this would be a good thing.  


** I have some more particular things to say about this in a coding environment, which I'll save for later. **