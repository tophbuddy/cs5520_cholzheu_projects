---
layout: posts
---

# A2: Activity Codelabs

date: 2021-23-09

# Lesson 2.1
## GitHub Link -> [Lesson 2-1 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_1/TwoActivities)

![Lesson2_1_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-1_Activity.png?raw=true)
![Lesson2_2_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-2_Activity.png?raw=true)
![Lesson2_3_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-3_Activity1.png?raw=true)
![Lesson2_4_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-3_Activity2.png?raw=true)
![Lesson2_5_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity1.png?raw=true)
![Lesson2_6_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity2.png?raw=true)
![Lesson2_7_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity3.png?raw=true)

### Summary

- Created a new app that had a main and second activty
- Passed a string between the activities and diplayed that string in the second activity using Intents
- Sent data back to the main activty from the second and displayed it

# Lesson 2.2
## GitHub Link -> [Lesson 2-2 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_2/TwoActivities2)

### Summary

- 

### Homework

Question 1
If you run the homework app before implementing `onSaveInstanceState()`, what happens if you rotate the device?

Answer: The counter is reset to 0, but the contents of the `EditText` is preserved.

Question 2
What Activity lifecycle methods are called when a device-configuration change (such as rotation) occurs?

Answer: Android shuts down your Activity by calling `onPause()`, `onStop()`, and `onDestroy()`, and then starts it over again, calling `onCreate()`, `onStart()`, and `onResume()`.

Question 3
When in the Activity lifecycle is `onSaveInstanceState()` called?

Answer: `onSaveInstanceState()` is called before the `onStop()` method.

Question 4
Which Activity lifecycle methods are best to use for saving data before the Activity is finished or destroyed?

Answer: `onPause()` or `onStop()`

# Lesson 2.3
## GitHub Link -> [Lesson 2-3 Activity Code Steps 1-3](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_3) [Lesson 2-3 Activity Code Step 4](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_3_Pt2/ImplicitIntentsReceiver)

### Summary

- 
