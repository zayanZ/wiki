.. role:: raw-html-m2r(raw)
   :format: html


Introductions and Mission
=========================


* Table of Contents

  * `Welcome <#welcome>`_
  * `An Example... <#an-example>`_
  * `Goals <#goals>`_
  * `Installation <#installation>`_

Welcome!
--------

Hello everyone that is reading this!, I am Matthew Roman, one of the software directors for this year on the HHH FRC Robotics Team.

As you already know, this year is going to be very different when compared to previous years as there will be no in-person competitions due to COVID-19 (apparently it has to mess with *everything* it touches).

However, this is not all in vain as it allows us (Talha and I) the time to address one of software team's biggest problems-  *understanding* our code.

An Example...
-------------

Let's look at what I am trying to say using a little example.

In a programming textbook, you find a scenario that states:

..

   Dice are a vesatile tool that have been used in many different games from all over the world. These games range from more popular ones such as Dungeons & Dragons and Backgammon to lesser known ones like Chō-han and Ludo.

   **Task**\ :  Create a program in the *Java* that simulates a standard 6-sided die. Print out a different statement for each number of the die (numbers 1-6).

   *Note!*\ - Assume that random number generation for the die is already part of the program.


One of the ways you can do this is by using *if-else* statements like so:

.. code-block:: Java

       if(side == 1) {
           System.out.println("1");
       }
       else if(side == 2) {
           System.out.println("2");
       }
       else if(side == 3) {
           System.out.println("3");
       }
       //And so on for 4, 5, and 6

However, another way that you could go about this is by using *switch* statements: 

.. code-block:: Java

       switch(side) {
           case 1:
               System.out.println("1");
               break;
           case 2:
               System.out.println("2");
               break;
           case 3:
               System.out.println("3");
               break;
           //And so on for 4, 5, and 6
           default:
               System.out.println("This is an error");
               break;
       }

**Which would you chose in your program?**

If I were to ask you this question, many of you would say that it wouldn't matter and choose either one. However, what happens if the program was changed to a 10-sided die? a 100-sided die? *a 1000-sided one*\ ?

This is where *understanding* the code comes into play...

While *if-else* and *switch* statements might be similar on the surface, they are actually two separate functions in *Java*\ :

*If-else* statements are conditional statements that allow a programmer **flexibility** in checking logic in their program. This can include checking *multiple* variables at once and checking a *range* of a variable. However, this flexibility comes at a price.

During a program's runtime, a chain of *if-else* statements are run from top-down, meaning that the program starts from the top of the *if-else* chain and checks each individual statement before moving on to the next one. The time spent on processing these statements increases as *a lot* more of them are added.

*Switch* statements in contrast are a lot more limited- only allowing the programmer to check the data value of a variable (boolean, integer, double, etc). However, they are faster during runtime as since the program only checks for a specific value (it does not go through all of the statements one by one like with *if-else* statements).

Due to this, it can be concluded that the better option for the current program would be *if-else* statements and *switch* statements for the 100 and 1000 sided dice.

Goals/Procedures
----------------

As one of the heads of software this year, one of my goals is to help you guys have a better understanding of your code.

No, that does not mean that I'm requiring you to comprehend/comment on every little bit of your code.

All I'm asking is that you not just understand *what* you are doing, but also *why* you are doing it (that goes for **everyone** on the team, including Talha and I).
:raw-html-m2r:`<br/>`
:raw-html-m2r:`<br/>`

Some goals for this year include:


#. Understanding our code (as mentioned previously)
#. Learning to program the robot- both *old* and *new* topics
#. Using Git- yes, we are actually going to use GitBash *properly* this time around..
#. Improving communication with each other
#. Creating a timeline of our code (actual documention)
#. Creating readable comments that are **useful**

At the start of this year, we are planning to have meetings once every week- on [insert date here to update]. 

**Everyone** will attend the meeting, with the cohort in school going to the cafeteria and the ones online going to a zoom meeting.

*Note!*\ - There will normally be a typed up version of the lesson that we are going over, however this can change later in the year as we tackle topics that we are less familiar with (such as PID and Limelight).

Installation
------------

Since this is software, there of course has to be specific programs that we will use during the year.

Click here if you need to download any of the programs that we use: `Installation <Installation.md##programs-to-install>`_

You should still check it out even if you think you have everything (it's a good list : D).

Thanks for reading this and I hope that we can help software to the best of our abilities (or at least try to)...

--Matt
