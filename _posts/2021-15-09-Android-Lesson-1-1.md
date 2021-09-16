---
layout: posts
---

# Hello Mad

date: 2021-15-09

# Lesson 1.1
## GitHub Link [Lesson 1-1 Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/Assingment1/lesson1_1)

### What I learned

- How to naviate Android Studio and create projects
- The importance of choosing the right minimum SDK
- How to interpret and add log statements on differnet levels (Debug, Error, Info, etc)
- Where to locate the files necessary to edit the apps layout and functions

### Homework

Question 1 
What is the name of the layout file for the main activity?

Answer: `activity_main.xml`

Question 2
What is the name of the string resource that specifies the application's name?

Answer: `applicationId`

Question 3
Which tool do you use to create a new emulator?

Answer: AVD Manager

Question 4
Assume that your app includes this logging statement:

`Log.i("MainActivity", "MainActivity layout is complete");`

You see the statement "MainActivity layout is complete" in the Logcat pane if the Log level menu is set to which of the following?

Answer: Verbose, Debug, Info

### Lesson 1.1 HW App

[1.1 GitHub Link](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/Lesson1_1_hw)

![HW1_1_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_1_HW/Lesson1_1_HW.png?raw=true)

# Lesson 1.2A
## GitHub Link [Lesson 1-2A Activity Code](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/Lesson1_2/hello_toast)

### What I learned

- View, ViewGroup, layouts, and their parent/child relationship
- Using the layout editor to manipulate elements of the app and the layout
- Setting layout width and height to match the constraints set by the parent

# Lesson 1.2B
## GitHub Link [Lesson 1_2B Activity](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson1_2/hello_toast)

### What I Learned

- Learned how to use the layout editor to preview and create new layout variants (landscape mode, tablet)
- Used `ConstraintLayout` to align elements based on baseline constraints
- Used `LinearLayout` to align elements based on horizontal ot vertical row and learned of its advantages

### Homework

Question 1
Which two layout constraint attributes on the Zero Button position it vertically equal distance between the other two Button elements?

Answer: `android:layout_marginBottom="8dp"` and `android:layout_marginTop="8dp"`

Question 2
Which layout constraint attribute on the Zero Button positions it horizontally in alignment with the other two Button elements?

Answer: `app:layout_constraintLeft_toLeftOf="parent"`

Question 3
What is the correct signature for a method used with the android:onClick XML attribute?

Answer: `public void callMethod(View view)`

Question 4
The click handler for the Count Button starts with the following method signature:
`public void countUp(View view)`
Which of the following techniques is more efficient to use within this handler to change the Button element's background color?

Answer: Use the `view` parameter that is passed to the click handler with `setBackgroundColor()`: `view.setBackgroundColor()`

Homework 1.2B App
GitHub Link [Lesson 1-2B HW](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson1_2/HelloConstraint)

![Lesson1_B_HW_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_2B_HW/Screenshot_1631764678.png?raw=true)

![Lesson1_B_HW_Screenshot2](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_2B_HW/Screenshot_1631764689.png?raw=true)

![Lesson1_B_HW_Screenshot3](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_2B_HW/Screenshot_1631764692.png?raw=true)

![Lesson1_B_HW_Screenshot4](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_2B_HW/Screenshot_1631764697.png?raw=true)

# Lesson 1.3
## GitHub Link [Lesson 1_3 Activity](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson1_3)

![Lesson1_3_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_3_Activity/Lesson1_3_Activity1.png?raw=true)

![Lesson1_3_Screenshot2](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_3_Activity/Screenshot_1631767630.png?raw=true)

![Lesson1_3_Screenshot3](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_3_Activity/Screenshot_1631767637.png?raw=true)

### What I learned

- How to use a `ScrollView` and add layouts and views to it
- How to format text and multiple views together into a cohesive layout
- Using `android:autoLink="web"` to automatically crete links

### Homework

Question 1 
How many views can you use within a `ScrollView`?

Answer: One View or one view group

Question 2
Which XML attribute do you use in a `LinearLayout` to show views side by side?

Answer: `android:orientation="vertical"`

Question 3
Which XML attribute do you use to define the width of the LinearLayout inside the scrolling view?

Answer: `android:layout_width="match_parent"`

Homework 1.3 App
GitHub Link [Lesson 1_3 HW](https://github.com/tophbuddy/cs5520_cholzheu_projects/tree/main/CS5520/NEUSEA_ChrisHolzheu_Lesson1_3_HW)

![HW1_3_Screenshot1](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_3_HW/Screenshot_1631767234.png?raw=true)

![HW1_3_Screenshot2](https://github.com/tophbuddy/cs5520_cholzheu_projects/blob/main/CS5520/Project_Images/Lesson1_3_HW/Screenshot_1631767243.png?raw=true)
