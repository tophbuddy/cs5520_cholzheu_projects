---
layout: posts
---

# A2: Activity Codelabs

date: 2021-23-09

# Lesson 2.1
## GitHub Link -> [Lesson 2-1 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_1/TwoActivities)

![Lesson2_1_1_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-1_Activity.png?raw=true)
![Lesson2_1_2_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-2_Activity.png?raw=true)
![Lesson2_1_3_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-3_Activity1.png?raw=true)
![Lesson2_1_4_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-3_Activity2.png?raw=true)
![Lesson2_1_5_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity1.png?raw=true)
![Lesson2_1_6_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity2.png?raw=true)
![Lesson2_1_7_Activity_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_1_Activity/2-1-4_Activity3.png?raw=true)

### Summary

- Created a new app that had a main and second activty
- Passed a string between the activities and diplayed that string in the second activity using Intents
- Sent data back to the main activty from the second and displayed it

# Lesson 2.2
## GitHub Link -> [Lesson 2-2 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_2/TwoActivities2)

![Lesson2_2_1_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_Activity/Screen%20Shot%202021-09-22%20at%203.37.52%20PM.png?raw=true)
![Lesson2_2_2_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_Activity/Screen%20Shot%202021-09-22%20at%203.44.27%20PM.png?raw=true)
![Lesson2_2_3_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_Activity/Screen%20Shot%202021-09-22%20at%205.49.57%20PM.png?raw=true)
![Lesson2_2_4_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_Activity/Screen%20Shot%202021-09-22%20at%205.50.12%20PM.png?raw=true)

### Summary

- Modified the code from the Lesson 2-1 activity and implemented lifecycle callbacks and show them in logging statements
- Looked at the logcat tab to see the lifecycle state changes as I interacted with the app
- Added functionality that allowed the retention of an Activity instance state that can be recreated when the user triggers a configuration or behavior change
- In the homework, I created a simple app to save the state of a counter variable that would continue to be shown even when the screen orientation is changed. 

### Homework

## GitHub Link -> [Lesson 2-2 HW Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_2_HW)

![Lesson2_2_1_HW_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_HW/Screenshot_1632361870.png?raw=true)
![Lesson2_2_1_HW_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_HW/Screenshot_1632361887.png?raw=true)
![Lesson2_2_1_HW_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_2_HW/Screenshot_1632361894.png?raw=true)

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

![Lesson2_3_1_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screen%20Shot%202021-09-22%20at%207.58.47%20PM.png?raw=true)
![Lesson2_3_2_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screenshot_1632366311.png?raw=true)
![Lesson2_3_3_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screenshot_1632366337.png?raw=true)
![Lesson2_3_4_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screenshot_1632366372.png?raw=true)
![Lesson2_3_5_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screenshot_1632366480.png?raw=true)
![Lesson2_3_6_Activity_Screenshot](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson2_3_Activity/Screenshot_1632368116.png?raw=true)

### Summary

- 
