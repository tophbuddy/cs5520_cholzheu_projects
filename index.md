---
layout: default
title: Chris Holzheu
---
## Welcome to My CS5520 Git Project Page


## Posts

<ul class="posts">
	  {% for post in site.posts %}
	    <li><a href="/cs5520_cholzheu_projects{{ post.url }}" title="{{ post.title }}">{{ post.title }}</a></li>
	  {% endfor %}
	</ul>

