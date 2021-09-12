---
layout: default
title: Chris Holzheu
---
## Welcome to My CS5520 Git Project Page


## Posts

<ul class="posts">
	  {% for post in site.posts %}
	    <li><a href="/CS5520{{ post.url }}" title="{{ post.title }}">{{ post.title }}</a></li>
	  {% endfor %}
	</ul>

