---
layout: posts
---

# A2: Activity Codelabs

date: 2021-23-09

# Lesson 2.1
## GitHub Link [Lesson 2-1 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_1/TwoActivities)

### What I Learned

- 

# Lesson 2.2
## GitHub Link [Lesson 2-2 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson2_2/TwoActivities2)

### What I Learned

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

### What I Learned

- 
