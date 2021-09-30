---
layout: posts
---

# A3: Create and Deploy To-Do List

date: 2021-29-09

## GitHub Link: [Todo App Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/TodoApp)

# Project Summary

In the first milestone of the To-Do App assignment, I implemented the initial layout, a `MainActiviy`, a secondary activity `TaskEditActivity`, and the functionality to add todos to a ListView and to edit the todo in another activity to add a description.

# Project Status

I implemented the initial Main activity to handle the `onCreate()` actions. In the `MainActivity` I added two click listeners, one to register a long click for deleting a task from an `ArrayList`, `todos`, and one for going into a task to the second activity, `TaskEditActivity`, that uses an intent to pass in the title of of the task as a `String` message. In the `TaskEditActivty`. I also implemented a `ListView` to display the todos on the main page with an `ArrayAdapter` to take the items in the `ArrayList` and convert them for the display. I still need to finishing implementing a data stucture so I can access the todo data from there and retain data integrity. I also to need to improve the layouts to be more intuitive and aesthetically pleasing for all types of devices.

![Todo1_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screen%20Shot%202021-09-29%20at%204.50.35%20PM.png?raw=true)
![Todo1_Screenshot2](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screen%20Shot%202021-09-29%20at%204.51.23%20PM.png?raw=true)
![Todo1_Screenshot3](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screenshot_1632959523.png?raw=true)
![Todo1_Screenshot4](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screenshot_1632959526.png?raw=true)
![Todo1_Screenshot5](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screenshot_1632959532.png?raw=true)
![Todo1_Screenshot6](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Todo_Project/Screenshot_1632959557.png?raw=true)
