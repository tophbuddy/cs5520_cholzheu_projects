---
layout: posts
---

# Final Project Proposal

date: 2021-10-11

## Final Project Choice

For the final project I have decided that I will add new features to my existing ToDo Application instead of creating a brand new app. I feel that I haven't gained
a great grasp of mobile application development yet and by adding new features on my own I believe that I can fix this deficiency in my knowledge.

There are three features that I've chosen to implement into my ToDo App. I will improve the visual design of the UI to improve user experience and the overall
aesthetics of the app. I will add the ability to add a map location to a to-do and lastly I will add the ability to alter the order of to-dos by dragging and dropping. 

## Feature Choice 1: UI Visual Design Upgrade

My approach to improving the UI of my app will start with looking at other existing mobile apps and finding a UI that I like so I have a starting point for
my own design. I will create mockups of what it could look like and that will assist me in deciding the changes to the xml files I will need to make in order
for my app to reflect my proposed redesign.

An example of an app that utilizes a UI design that I like is Trello. Trello is a visual collaboration platform to help teams manage and coordinate their 
projects. I can already see some of the UI features being translatable to my own ToDo App and its concept does derive from managing to-dos on a more 
professional level.

## Feature Choice 2: ToDo Map Location

For this feature, I will have to learn how to use mobile location services and decide whether I want to focus on using cell network, GPS or Wifi positioning for determining a
location that is chosen by the user. This will either be shown on a map on the edit todo activity fragment or it will be link to the location after it is chosen by the user.

## Feature Choice 3: Drag and Drop ToDo Reorder

To implement drag and drop functionality to the to-do list page, I will need to add a class for the drag event with helpers and drag listeners to register the user dragging the to-do. I believe this will be pretty straightforward since I do have fragments implemented for displaying to-dos on the main page list.

## Possible Challenges

There are some challenges that I can identify already with implementing these features. The upgrade of the visual design will be the biggest challenge for me. This will require 
some major edits to my layout xml files and I forsee having to adjust the navigation xml file as well. This will also require me to change my activity files as well since my UI upgrade might not be possible with my current architecture. I will also have challenges implementing the map location feature as well since it is a concept I have not learned yet and will require me to make major adjustments to my activity files as well.

