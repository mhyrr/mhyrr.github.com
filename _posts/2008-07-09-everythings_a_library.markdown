---
layout: post
title: Everything's A Library
---

{:quote:     code_background_color='#efffef'}

{:ruby:      lang=ruby code_background_color='#efffef'}

{:java:		 lang=java code_background_color='#efffef'}

{:c:		 lang=c code_background_color='#efffef'}

I seem to alternate between one technical and one (somewhat) non-technical post - excepting travel logs.  That's fine by me.  It provides some harmony and balance to at least one thing I do.  That's important on any task, though usually I fail abysmally.  If I'm working out consistently, I'm giving something else up.  If I'm doing a lot of coding, I'm not seeing much sunlight.  The world runs on trends, so I suppose it makes sense that individuals do the same thing.  Another trend I follow is an introductory paragraph that has nothing to do with anything.  Like this one.

As another small side note, this is my first post using [TextMate's](http://www.macromates.com) Blogging bundle.  So far, so good.  I started using TextMate about four months ago for all personal development, and I've been really impressed so far.  Great syntax highlighting, great shortcuts, a fabulous bundle system, and absolutely fantastic autocompletion and shortcuts.  If you've got a Mac, you've got to use it.  It's worth the price.

I'm going to be rambling for awhile at a ten thousand foot level on computing and computing machines.  It's necessary so I can figure out what it is I'm trying to say, and I'm sure I'll trip up here and there.  So be prepared for gross generalizations being tossed all over the place.

#### Main()

Recently I've been doing some reading on various programming languages and their various flavors.  This is part of my catch up from an [epic failure](http://icanhascheezburger.com/2007/11/07/epic-fail/) of education.  I've been [doing it wrong](http://icanhascheezburger.com/2007/03/14/youre-doing-it-wrong/).  (Alright, enough needless links.  I admit it - it was just to play with the Blogging bundle's markdown features - which apparently also screw up code written in block quotes earlier - doh!).

There seems to be a general consensus that it's important to use a popular language for a big project (1); more important, in fact, than the language's intrinsic feature set.  That's kind of interesting by itself, since the general consensus is also that choosing a language for a project based on a priori knowledge of the language is shortsighted.  I'm not sure yet how these jive together, but I do agree that the number of developers working with a given language - and thus the libraries, tools and general knowledge available - is important to the quality of a project.

But what makes a language *popular*?  Or rather, how does a language jump the gap, and move from relative obscurity to fame and fortune on the Internets?  It sometimes seems to happen overnight, but it's always preceded by the release of some interesting project.  So here's a hypothesis: for a language to become popular, hip, and cool, *something important has to be written in that language.*  Let's look at a couple of examples, shall we?

#### C

Go back into [negative time](http://en.wikipedia.org/wiki/Unix_time) (January 1, 1970) and all operating systems were written in assembly.  Great, big, bad Multics was written in assembly.  Early iterations of Unics were written in assembly.  If you've ever done assembly programming, you'll know that it's a pain in the ass.  Everything sucks.  Imagine trying to think out a sentence, but having to write each letter as a series of dots in the correct pattern, and only being allowed to write one dot per second.  By the time you finished the first letter, you'll have forgotten the purpose of the sentence.  That's assembly.

So in an effort to make better, easier to read, and more portable code, some of the original Unix guys came up with C as a more expressive alternative to assembly.  It still provided all the low level accesses to a von Neumann architecture that you needed, but without some of the pain.  C pushed Unix.  Unix pushed C.  Their popularity is fundamentally tied together.  Unix was, and still is, C's killer app.

#### Perl

What about a very high level language like Perl?  Unix does a lot of plaintext stuff, and awk/sed only get you so far.  So Larry Wall designed Perl to do a lot of simple text processing tasks for Unix.  Plus C has absolutely no real support for Strings (no - chars, pointers, and libraries don't count).  So, without trying too hard, Perl basically took over everything that awk/sed was used for previously, and some other things too.  That was it's first killer app.  When the web began, a lot of people started using Perl for quick processing of CGI stuff.  That was it's second killer app.

#### Java

Ok, this one is a bit different.  Java was meant as a handy alternative to C++ without dealing with all the intricacies of compiling on 8,874 varieties of hardware (and other things).  Java as a language seems to still be growing, at a glacial pace, but it's killer app is actually written in C.  The JVM is what really carries along the Java programming language.  As far as I know, the JVM is the first very widespread use of a virtual machine to resolve multiple portability and security issues.  It's a big deal.  And as more and more languages can be run on the JVM (and Microsoft's CLR for that matter), it will be an even bigger deal.  The JVM is Java's killer app.

#### Ruby

Ruby is perhaps the most obvious example of one app making a language popular.  Ruby began its life way back in 1993, and it has been a cute little language for a long time.  But nobody ever bothered to pay attention until DHH decided to write a very nice MVC web framework in it.  He called it Ruby on Rails and a star was born.. actually two.  Rails instantly became a success, and people were suddenly scrambling to know Ruby.  Now there's libraries for everything from XMPP to pinning captions on your cat.  Rails is Ruby's killer app.

#### Python

Python is still a bit of an enigma to me.  The most I've done with it, aside from some one liners, is ported a bunch of crap over to Java.  And frankly, I can't think of an answer for Python.  It's got loads of support.  It's got tons of libraries.  People love it.  I have no idea how that happened.  The language must just suck less than others - which means I ought to learn more of it.

#### Lisp

I don't know Lisp yet.  I'm just now trying to learn Scheme.  Lisp was originally a new syntax for computation.  It wasn't even supposed to be a programming language.  Then a grad student wrote an interpreter and wham-o!  Lisp was a language.  For computation.  That makes it entirely different than the other languages I've mentioned thus far.  Their purpose is to execute instructions on a machine.  Lisp's purpose is to compute things.  Because of that, it's probably the most fundamental, universal language we have.  The [lambda calculus](http://en.wikipedia.org/wiki/Lambda_Calculus) is Lisp's killer app. (Can't you just feel the metaphor stretching?)

#### Ad Nauseum

This could go on..  It's important to use a popular language when working on a project.  Obscure languages must be used (or be acknowledged as useful) to write something important for them to become popular (2).  So why would anyone bother then?  Pretty much everything, including the kitchen sink, is [Turing-equivalent](http://en.wikipedia.org/wiki/Turing-complete), so why not just use a common, well-known language?

#### Syntactic Sugar

Let's consider one of the useful goodies of Perl (inherited from sed, I think).  Regular expressions are remarkably convenient little structures that let us say all sorts of things.  Finding a given pattern inside a string isn't a difficult problem, and it could be done in any language.  But let's say I'm doing it a lot, and the patterns change.  Instead of writing various chunks of code for each situation, it would be a much more elegant solution to come up with a single construct, and plug in the individual expressions there.  I'd want to write a library for it.  That's essentially what regular expressions are.  They're native to Perl, and more or less in other languages, so now they're considered a pretty standard language feature.  But back in the day it was quite a novelty - it was the coding equivalent of one of those giant 3 foot long Pixie sticks you used to down as a ten year old.  Time has changed it from syntactic sugar to a standard language feature.

We can make the same case for even more basic language constructs, like loops.  Ruby lets me write 
	(1..100).each {|i| ..}  
{:ruby}	
C let's me write 
	for (int i = 0; i <= 100; i++) {...}
{:c}	
Lisps use tail recursion.  But what does any of that matter when I can simply store a number in a register, perform some set of operations, and then iterate the register manually, and check the register manually?  God help me, but if I had to do that, I'd want to write a library for it.

#### Power

All languages provide varying degrees of syntactic sugar for a von Neumann architecture, which is to say, for a simple, cheap hardware implementation of a Turing Machine.  A lot of sugar is very useful.  Some can be worthless.

The syntax, the sugar, for writing on this architecture is the only thing that really varies.  We call into various syntaxes to accomplish the tasks we require, and they get executed on a Turing-equivalent machine.  A Turing machine wants lots of 1s and 0s in a certain order to denote instructions and data.  Anything on top of that is just a useful library for writing in the Turing machine's language.

That sounds goofy.  If you're sane you probably think I'm nuts.  So let's look at an example of power and see if we can't see some differences between language abstractions and syntaxes, libraries, and the sugar.

Here's problem 20 from Project Euler:

		n! means n * (n - 1) * ... * 3 * 2 * 1

		Find the sum of the digits in the number 100!

		Relatively simple, but requires a little bit of work.  Certainly not something you'd want to compute by hand, or by calculator.  100! is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000.  
{:quote}
I don't think it fits in 32 bits (or 64 smartass..)!  So what do we do?

Here's some solutions in a couple of languages.

Java:
	import java.math.*;
	import java.lang.*;

	public final class Euler20 {

		public static void main(String[] args) {

			int total = 0;
			BigInteger b = factorial(100);

			System.out.println("b = " + b.toString());
			String[] digs = b.toString().split("");

			for( int i = 0; i &lt; digs.length; i++ ) {
				if ( ! digs[i].equals("") ) {
					int x = (new Integer( digs[i] )).intValue();
					total += x;
				}
			}
			System.out.println("total is " + total);
		}

		public static BigInteger factorial( int n ) {
			if ( n &lt;= 1 )
				return BigInteger.valueOf(1);
			else
				return BigInteger.valueOf(n).multiply( factorial( n - 1 ) );
		}

	}
{:java}

That's a little bit long (30 lines), and I had to use the BigInteger class for arbitrarily long integers.  Note I didn't use any particularly exciting Java language features either.  I could've made the loops shorter and other neat things.  Whatever, it's a quick and dirty.  Deal with it.

Here's the same thing in Ruby:

	puts (1..100).inject(1) {|mult, num| mult * num }.to_s.split("").inject(0) {|sum, dig| sum + dig.to_i }
{:ruby}

Wow!  1 Line!  But what's all this inject and |foo| nonsense?  How are we dealing with any variables in here?

Here's one more solution I pulled from the Project Euler forums, courtesy of nsg.  This is about as terse as I think you can get.  The J Language is known for that sort of thing:

	+/"."0":!100x
{:c}

Yes, that really is the whole thing.  13 characters.

Java code first, since there's clearly more of it.  Those imports, they're arguably language features, but they really just call into Java's vast libraries.  Class and method declarations are certainly part of the language.  Semicolons are part of the language.  Since there's no overloading, we should call the primitive operators a part of the language syntax.  Even the actual multiplication is being handed off to the BigInteger class.  The syntax itself is pretty barren.  There's not much beyond object oriented structures, conditionals, loops, and operators.

I won't comment on J except to say "Damn".  Ruby is pretty sparse too.  The loop is passed off to a Range object, which calls the inject method.  Both inject methods take a block and execute it - library calls, with subtleties handling the blocks.  The operators are really methods.  1+2 is equivalent to 1.+2.  The rest is more obviously just method calls on objects.

Or is it?  Ruby is built completely from the ground up on the object oriented paradigm, so how do we separate the two?  Everything is an object.  Everything is part of the API.  Are we just playing at semantics, or is there really a difference between the language abstractions and syntax and a set of libraries?  Is there ever really a difference?

One of the glorious things about Ruby for me (coming from Java and, earlier, C) is that the syntax of the language sort of melts away.  I don't have to worry about semicolons, but I can use them if it makes me comfortable.  I don't have to worry about 32 bits for ints.  The Integer class has two subclasses, Fixnum and Bignum, which handle numbers smaller and larger than 31 bits respectively.  Ruby casts between the two types for you, so you don't have to worry about it.  Now *that* is a language feature.

It also naturally abstracts away some of the variables for me.  I don't need to worry too much about totaling my factorial function because I can toss blocks around that will accomplish the same thing for me.  That's really nice.  It's the sort of thing I'd expect a library to do - streamline a set of operations to make it near trivial to accomplish.

Taking the limit: having no syntax is the best syntax.  The Lisps seem to want to get as close to that as possible.  They have certain language abstractions (car and cdr, operators), but I've only ever seen two characters of syntax in Lisp: ( and ).  Maybe I have seen the occasional \` or , in there as well.  That's still very terse.

I think this is what most people really mean when they talk about the power of a language.  It's terse.  Some of the demigods on stilts whose blogs we read may be considering some of the outstanding metaprogramming and macro abstractions of a language when talking about power, but we mere mortals generally mean it on a simpler level.  Power equates to a language being terse.  If I can write 10 lines in language A to do the work of 50 lines in language B, I'll generally consider language A more powerful.

This breaks down for practical reasons.  Humans want to have things like maintainability and readability.  They don't want to spend 10 minutes to understand 13 characters of J.  It may be elegant to write, but it's not elegant to grok.  Humans seem to like the decimal number system too.  It's comfortable and it maps well to our anatomy.  Machines like binary as a reasonable and efficient number system for recording information.  We could use unary though.  It would suck.  33 in binary is 100001.  33 in unary is 111111111111111111111111111111111 (or pick your arbitrary character of choice).  You can see where this is going.

There's lots of esoteric programming languages that push it too far as well.  Brainfuck is a good example.  What a name for a programming language huh?  Brainfuck.  I'd like to propose we use Brainfuck for this implementation of your problem.  Hey, have you done any brainfuck lately?  Let's work on this brainfuck code here.  Great name.

Anyway, brainfuck was an attempt to have as few operations as possible.  It has a compiler that fits into 200 bytes.  It has only eight operators and none of them take any arguments.  And it's Turing Complete.  [LOLCode](http://www.lolcode.com) has been proven Turing Complete too.

#### von Neumann

"We have reached the limits of what is possible with computers."
John Von Neumann, 1949

I've heard that quote a few times before, mostly amidst a bunch of other technology quotes that make us laugh at those old feebleminded geniuses and their sightlessness.  I'm sure you've heard the one from the president of IBM, talking about the world market for computers being limited to a total of four?

Yeah, these two quotes have nothing to do with each other.  One is shortsighted, one is not.

The really interesting bit about that von Neumann quote is that he was right.  By the 1940s, the limits of what is and is not computable had been hypothesized under at least 3 different types of abstraction: [Turing machines](http://en.wikipedia.org/wiki/Turing_machine) (the most famous, perhaps), the Lambda Calculus, and recursion.  All three are [equivalent](http://en.wikipedia.org/wiki/Church-Turing_thesis).  ENIAC was Turing-equivalent in 1946.

ENIAC couldn't do anything that we do regularly today.  Heck, my computer in college couldn't handle the photo processing I do regularly now.

So let's back up a second.  Turing Machines, lambda functions or any other mode of computation make no accommodation for time/space complexity.  Turing's original notion of a Turing Machine included an infinite tape for input.  There's never a concession for when a program will halt, only that it may halt.  Turing machines are also difficult to use to model certain common computer tasks that require lots of input, like word processing.  Lastly, modern computers are Turing-equivalent, but they're hampered by all of the state limitations of the implementation.  In other words, if I have a von Neumann architecture (like we all do), I'm limited by each of it's parts: CPU, memory, disk, bus, etc.  So I'll always be able to "do more" as time presses on and the limitations on the finite space of a machine become less severe (3).  But give me enough vacuum tubes and a couple million years and I'll get ENIAC to compute a Mersenne prime for you.

#### The Abstraction Tree

The foundations of computability are very well known (4).  A bunch of reasonable and cheap hardware architectures have been built to model this computation.  On top of those architectures have been built a set of very simple languages (syntaxes) to manipulate the state of the hardware.  Those languages are still too difficult for humans to manipulate with any advanced meaning, so another set of abstracted language constructs got built on top of those.  This gets us to assembly and C, which is the underlying basis for a lot of other abstractions, including things like the JVM, the CLR and a lot of the Ruby "language" (library).  On top of assembly and C, both of which are great for manipulating a Turing-equivalent von Neumann architecture, we can make all sorts of abstractions and families of syntaxes for easily describing any number of problems.  We can build parsers, compilers, or interpreters for everything from markup to duck typing to brainfuck.  The limitations at this level of abstraction are the ones known to us: hardware speed and capacity, syntax obfuscation, and our own stupidity.

The further up the abstraction tree we move, assuming we pick the proper tool, which is no mean feat, the simpler it should be to fit our problem to the abstraction.  It makes me wonder what set of abstractions, if any, are in our future.  Are there any layers that we haven't reached yet, or are we simply building the different types of tools that each different job requires?  DSLs are gaining popularity for certain types of tasks, and it even seems like the newer, hip languages are just new combinations and subsets of older languages.  Are we really gaining anything new?  Or are we simply building tools and libraries to fill in the holes?

So pick your poison.  I mean syntax.  No, I mean poison.  Everything's a library.  The language is computation!

(1)  The value of big can vary, let's set the bar low and say anything over 10,000 lines.

(2)  This won't necessarily make it popular though.  Apple writes all their tasty bits in Objective-C, and that isn't exactly booming in popularity.

(3) Cloud computing will make this extremely interesting.  It's bursting the seams of what computations are possible.  Some things are still difficult.  But some computations are [embarassingly parallel](http://en.wikipedia.org/wiki/Embarassingly_parallel), and many others at least manageable.  Flinging nearly endless machines at the problem allows computations over vast datasets.

(4) Although not completely well known.  There are still open questions like [P = NP](http://en.wikipedia.org/wiki/P_%3D_NP_problem) and quantum cmputing which could totally change the types of computations possible.
