---
layout: post
title: Operator and Method Precedence in Ruby
---

<em>Spoiler Alert!</em> If you care about solving problems on <a href="http://projecteuler.net">Project Euler</a>, this is #56, so skip it if you really care.

<strong>[</strong><strong>audio http://wpcom.files.wordpress.com/2007/01/mattmullenweg-interview.mp3]</strong>

I was toying around with some problems again last night and ran into a curious situation in Ruby.  Here's the problem description:
<blockquote>A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b &lt; 100, what is the maximum digital sum?</blockquote>
This problem is fairly simple, and like a lot of things with Ruby, it can be condensed nicely and remain readable.  A simple brute force approach is to loop from 1 to 99 twice, compute the value, split on the digits and add them up.  With Ruby I don't need to worry about the size of the result.  Ruby subclasses Integer into Fixnum and Bignum and translates between the two classes as needed.  In other words, if it fits into a Fixnum it will, if it doesn't, Ruby will use a Bignum.  Convenient.  But I still agonized over this solution; it just wasn't working the way I expected.

[flickr video=2431720072]

Lets look at a couple Ruby snippets briefly and see if we can't distinguish some differences..

<strong>1.</strong>

(1...100).each do |x|

(1...100).each do |y|

puts x**y.to_s.split("").inject(0) {|sum, dig| sum+dig.to_i}

end

end

<strong>2.</strong>
<code>
(1...100).each do |x|
(1...100).each do |y|
puts (x**y).to_s.split("").inject(0) {|sum, dig| sum+dig.to_i}
end
end
</code>

<strong>3.</strong>
<code>
(1...100).each do |x|
(1...100).each do |y|
puts ( (x**y).to_s.split("").inject(0) {|sum, dig| sum+dig.to_i} )
end
end</code>

These three pieces of code produce different results.  It's hard to even notice the difference, but it's only parentheses.   So what gives?  And which one is right?

The 3rd version does what I wanted it to do, although whether it's "right" or not is still an open question.

To figure out exactly what's going on here, I tried a single iteration of the loop with irb.  Here's that output:

<code>
&gt;&gt; a = 4
=&gt; 4
&gt;&gt; b = 5
=&gt; 5
&gt;&gt; ((a**b).to_s.split("").inject(0) {|sum, dig| sum+dig.to_i })
=&gt; 7
&gt;&gt; (a**b).to_s.split("").inject(0) {|sum, dig| sum+dig.to_i }
=&gt; 7
&gt;&gt; a**b.to_s.split("").inject(0) {|sum, dig| sum+dig.to_i }
=&gt; 1024
&gt;&gt; a**b
=&gt; 1024</code>

Here, wrapping the a**b in parentheses provides the same answer, but without parentheses we still get something weird.  The key to this bit of mild goofiness is to remember that<em> everything</em> in Ruby is an object.  Ranges include Enumerable, which is what allows <code>(1...100).each</code>.   Integers (Fixnum and Bignum) subclass from Numeric, which includes Comparable, and so allows the comparison of any numeric using those methods: &lt;, &lt;=, ==, &gt;=, &gt;.  Integer also implements some other methods, like +, -, and **.

That's right, ** is a method on Integer rather than an operator.  Compared to Java, that's sort of interesting.  Java is designed well for object oriented programming.  Yet it has primitive types that do not act as objects, and operators that act on these primitives, much like other, older languages.  Ruby's sort of a paradigm shift, or at least a fulfillment of the promises of higher level abstraction through objects (to be fair, not all <a href="http://www.techotopia.com/index.php/Ruby_Operator_Precedence">operators in Ruby</a> are methods on objects).

So let's work backwards, and rewrite:
<code>a**b   .to_s.split("").inject(0) {|sum, dig| sum+dig.to_i }</code>
as
<code>a.**b   .to_s.split("").inject(0) {|sum, dig| sum+dig.to_i }</code>
Knowing that .** is a method rather than an operator, it's expected that the methods are executed in order.  When I run <code>foo.to_a.sort.uniq</code>, to_a operates on foo, sort operates on the result of to_a, and uniq operates on the result of sort.  Similarly, in our original line of code, to_s operates on b, not on a.**b.   So we're adding up all the digits in b (5), which is the same as b itself (5), so a.**(operation on b) is the same as a.**b.  Thus, they both evaluate to 1024.  Adding parentheses around a**b ensures that our operations are performed on 1024 instead.  The second set of parentheses does not change this evaluation.

Ok, back to our original example now.  Snippet #2 is by far the most interesting.   When sitting inside the nested loop, puts evaluates only (x**y).  Sitting on its own, however, puts prints the entire expression.  I'm not entirely sure why yet.  Adding parentheses around the entire expression for puts, as in snippet #3, provides the expected result.  Ditching all the parentheses, as in snippet #1, now makes sense when we consider .** as a method.  If anyone has an answer for #2, I'd love to hear it.  I'm sure I'm missing something quite simple.
