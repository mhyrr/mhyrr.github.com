---
layout: post
title: Scraping PBase
---

CSS: /css/syntax.css

{:ruby:     lang=ruby code_background_color='#efefff'}

While I've liked having PBase, my family has decided to move to SmugMug. This was for a number of reasons, but the biggest is simply that PBase works on bandwidth, while SmugMug is a flat annual fee for unlimited storage (I'm not a huge fan of Flickr's interface).

Unfortunately though, this presented a problem. I've got a lot (* GB) of photos on PBase that I don't have on local drives and I want to keep them and put them up on SmugMug. I thought other people might occasionally run into this problem, so here's the script I'm using to scrape my space and grab them all.

Run as follows: ruby ./pbasescraper.rb first_image_page_url folder_name

Note that the first argument is the webpage with the first image in a given gallery. The script then moves through the gallery and grabs the image on each page and puts them in the given folder.

Note also that curl is Mac's version of wget.

Here's the script:

	#!/usr/bin/ruby

	require 'open-uri'

	html = ARGV[0]
	img = 0
	top_level = "http://www.pbase.com"
	folder = ARGV[1]
	`mkdir #{folder}`
	more = true
	while more 
	  open(html) { |f|

	    f.each_line {|line|  
    
	      line.split(/ /).each { |part|
   
	        if line =~ /ALT=/
	          if part =~ /http\:\/\//
	            part.gsub!(/src=\"/, "").gsub!(/\"/, "")
	            puts part
	            `curl #{part} > #{folder}/img#{img}.jpg`
	            img += 1
	          end
	        end          
	        if part =~ />next<\//            
	          if part =~ /<\/span>/
	            more = false
	          end
	          html = top_level + part.gsub(/href=\"/, "").gsub(/\">next<\/a>\n/, "") + "/original"
	          puts html
	        end     
	      }
	    }
	  }
	end  
{:ruby}
