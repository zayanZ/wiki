
Good Practices
==============

`Clean Code PDF <https://github.com/ontiyonke/book-1/blob/master/%5BPROGRAMMING%5D%5BClean%20Code%20by%20Robert%20C%20Martin%5D.pdf>`_

I know you don't feel nearly as passionate as I do about writing clean code. You may not even think it matters because we're only creating a robot that's a dozen files large, not hundreds like in an enterprise setting. But our small setting should only make you want to make our code clean even more because it's so easy to make it that way. You probably don't really understand what "clean code" really is, and I pity you for that. Go into any project you didn't make try to understand it. Part of the quest of Clean Code is to make code easily understandable from an outside perspective.

Read Clean Code.

Just read Clean Code.

It's a really good book.

Please...

Reading it will literally make your brain expand. It will change the way you view coding. If you don't quite understand something he mentions, look it up and your brain will expand even more.

If 400 pages is too much for you, I compiled Robert Martin's points which are most relevant to you (though you should try to read the whole book)


* `Good Practices <#good-practices>`_
* `Clean Code <#clean-code>`_

  * `Meaningful Names <#meaningful-names>`_

    * `Use Intention-Revealing Names <#use-intention-revealing-names>`_
    * `Avoid Disinformation <#avoid-disinformation>`_
    * `Make Meaningful Distinctions <#make-meaningful-distinctions>`_
    * `Member Prefixes <#member-prefixes>`_
    * `Avoid Mental Mapping <#avoid-mental-mapping>`_

  * `Methods <#methods>`_

    * `Use Descriptive Names <#use-descriptive-names>`_
    * `Have No Side Effects <#have-no-side-effects>`_

  * `Comments <#comments>`_

    * `Comments Do Not Make Up for Bad Code <#comments-do-not-make-up-for-bad-code>`_
    * `Explain Yourself in Code <#explain-yourself-in-code>`_
    * `Informative Comments <#informative-comments>`_
    * `Don't use a Comment When You Can Use a Function or Variable <#dont-use-a-comment-when-you-can-use-a-function-or-variable>`_

Clean Code
==========

..

   I could list all of the qualities that I notice in clean code, but there is one overarching quality that leads to all of them. Clean code always looks like it was written by someone who cares. There is nothing obvious that you can do to make it better. All of those things were thought about by the code’s author, and if you try to imagine improvements, you’re led back to where you are, sitting in appreciation of the code someone left for you—code left by someone who cares deeply about the craft.

   - Micheal Feathers


Writing clean code requires the disciplined use of a myriad little techniques applied through a painstakingly acquired sense of “cleanliness.” This “code-sense” is the key. Some of us are born with it. Some of us have to fight to acquire it. Not only does it let us see whether code is good or bad, but it also shows us the strategy for applying our discipline to transform bad code into clean code.

A programmer without “code-sense” can look at a messy module and recognize the mess but will have no idea what to do about it. A programmer with“code-sense” will look at a messy module and see options and variations. The “code-sense” will help that programmer choose the best variation and guide him or her to plot a sequence of behavior preserving transformations to get from here to there.

In short, a programmer who writes clean code is an artist who can take a blank screen through a series of transformations until it is an elegantly coded system.

Meaningful Names
----------------

PascalCase for classes, camelCase for methods and variable names.

Classes should have nouns or noun phrases like ``Customer``\ , ``WikiPage``\ , ``Account``\ , and ``AddressParser``.

Methods should have verbs or verb phrases ``postPayment``\ , ``deletePage``\ , or ``save``. Accessors, mutators, and predicates should be named for their value and prefixed with ``get``\ , ``set``\ , and ``is`` according to the `javabean standard <http://www.java2s.com/Tutorial/SCJP/0120__Object-Oriented/JavaBeansNamingConvention.htm>`_.

Use Intention-Revealing Names
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

It is easy to say that names should reveal intent. What we want to impress upon you is that we are serious about this. Choosing good names takes time but saves more than it takes. So take care with your names and change them when you find better ones. Everyone who reads your code (including you) will be happier if you do. The name of a variable, function, or class, should answer all the big questions. It should tell you why it exists, what it does, and how it is used. If a name requires a comment, then the name does not reveal its intent.

``int d; // elapsed time in days``

The name d reveals nothing. It does not evoke a sense of elapsed time, nor of days. We should choose a name that specifies what is being measured and the unit of that measurement:

.. code-block:: java

   int elapsedTimeInDays;
   int daysSinceCreation;
   int daysSinceModification;
   int fileAgeInDays;

Choosing names that reveal intent can make it much easier to understand and change code. What is the purpose of this code?

.. code-block:: java

   public List<int[]> getThem() {
     List<int[]> list1 = new ArrayList<int[]>();
     for (int[] x : theList)
       if (x[0] == 4)
         list1.add(x);
     return list1;
   }

Why is it hard to tell what this code is doing? There are no complex expressions. Spacing and indentation are reasonable. There are only three variables and two constants mentioned. There aren’t even any fancy classes or polymorphic methods, just a list of arrays (or so it seems). The problem isn’t the simplicity of the code but the implicity of the code (to coin a phrase): the degree to which the context is not explicit in the code itself. The code implicitly requires that we know the answers to questions such as:


#. What kinds of things are in theList?
#. What is the significance of the zeroth item in theList?
#. What is the significance of the value 4?
#. How would I use the list being returned?

The answers to these questions are not present in the code sample, but they could have been. Say that we’re working in a mine sweeper game. We find that the board is a list of cells called theList. Let’s rename that to gameBoard. Each cell on the board is represented by a simple array. We further find that the zeroth subscript is the location of a status value and that a status value of 4 means “flagged.” Just by giving these concepts names we can improve the code considerably:

.. code-block:: java

   public List<int[]> getFlaggedCells() {
     List<int[]> flaggedCells = new ArrayList<int[]>();
     for (int[] cell : gameBoard)
       if (cell[STATUS_VALUE] == FLAGGED)
         flaggedCells.add(cell);
     return flaggedCells;
   }

Notice that the simplicity of the code has not changed. It still has exactly the same number of operators and constants, with exactly the same number of nesting levels. But the code has become much more explicit. We can go further and write a simple class for cells instead of using an array of ints. It can include an intention-revealing function (call it isFlagged) to hide the magic numbers. It results in a new version of the function:

.. code-block:: java

   public List<Cell> getFlaggedCells() {
     List<Cell> flaggedCells = new ArrayList<Cell>();
     for (Cell cell : gameBoard)
       if (cell.isFlagged())
         flaggedCells.add(cell);
     return flaggedCells;
   }

With these simple name changes, it’s not difficult to understand what’s going on. This is the power of choosing good names.

Avoid Disinformation
^^^^^^^^^^^^^^^^^^^^

Programmers must avoid leaving false clues that obscure the meaning of code. We should avoid words whose entrenched meanings vary from our intended meaning. For example, ``hp``\ , ``aix``\ , and ``sco`` would be poor variable names because they are the names of Unix platforms or variants. Even if you are coding a hypotenuse and ``hp`` looks like a good abbreviation, it could be disinformative. Do not refer to a grouping of accounts as an ``accountList`` unless it’s actually a ``List``. The word list means something specific to programmers. If the container holding the accounts is not actually a ``List``\ , it may lead to false conclusions. So ``accountGroup`` or ``bunchOfAccounts`` or just plain ``accounts`` would be better.

Make Meaningful Distinctions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Programmers create problems for themselves when they write code solely to satisfy a compiler or interpreter. For example, because you can’t use the same name to refer to two different things in the same scope, you might be tempted to change one name in an arbitrary way. Sometimes this is done by misspelling one, leading to the surprising situation where correcting spelling errors leads to an inability to compile.

It is not sufficient to add number series or noise words, even though the compiler is satisfied. If names must be different, then they should also mean something different.

Number-series naming ``(a1, a2, .. aN)`` is the opposite of intentional naming. Such names are not disinformative—they are noninformative; they provide no clue to the author’s intention. Consider:

.. code-block:: java

   public static void copyChars(char a1[], char a2[]) {
     for (int i = 0; i < a1.length; i++) {
       a2[i] = a1[i];
     }
   }

This function reads much better when source and destination are used for the argument names.

Noise words are another meaningless distinction. Imagine that you have a ``Product`` class. If you have another called ``ProductInfo`` or ``ProductData``\ , you have made the names different without making them mean anything different. Info and Data are indistinct noise words like ``a``\ , ``an``\ , and ``the``.

Noise words are redundant. The word variable should never appear in a variable name. The word table should never appear in a table name. How is ``NameString`` better than ``Name``\ ? Would a ``Name`` ever be a floating point number? If so, it breaks an earlier rule about disinformation.

Member Prefixes
^^^^^^^^^^^^^^^

You also don’t need to prefix member variables with ``m_`` anymore. Your classes and functions should be small enough that you don’t need them. And you should be using an editing environment that highlights or colorizes members to make them distinct.

.. code-block:: java

   public class Part {
     private String m_dsc; // The textual description
     void setName(String name) {
       m_dsc = name;
     }
   }
   _________________________________________________
   public class Part {
     String description;
     void setDescription(String description) {
       this.description = description;
     }
   }

Besides, people quickly learn to ignore the prefix (or suffix) to see the meaningful part of the name. The more we read the code, the less we see the prefixes. Eventually the prefixes become unseen clutter and a marker of older code.

Avoid Mental Mapping
^^^^^^^^^^^^^^^^^^^^

Readers shouldn’t have to mentally translate your names into other names they already know. This problem generally arises from a choice to use neither problem domain terms nor solution domain terms.

This is a problem with single-letter variable names. Certainly a loop counter may be named ``i`` or ``j`` or ``k`` (though never ``l``\ !) if its scope is very small and no other names can conflict with it. This is because those single-letter names for loop counters are traditional. However, in most other contexts a single-letter name is a poor choice; it’s just a place holder that the reader must mentally map to the actual concept. There can be no worse reason for using the name ``c`` than because ``a`` and ``b`` were already taken.

In general programmers are pretty smart people. Smart people sometimes like to show off their smarts by demonstrating their mental juggling abilities. After all, if you can reliably remember that ``r`` is the lower-cased version of the url with the host and scheme removed, then you must clearly be very smart.

One difference between a smart programmer and a professional programmer is that the professional understands that clarity is king. Professionals use their powers for good and write code that others can understand.

Methods
-------

Use Descriptive Names
^^^^^^^^^^^^^^^^^^^^^

Remember Ward’s principle: “You know you are working on clean code when each routine turns out to be pretty much what you expected.” Half the battle to achieving that principle is choosing good names for small functions that do one thing. The smaller and more focused a function is, the easier it is to choose a descriptive name.

Don’t be afraid to make a name long. A long descriptive name is better than a short enigmatic name. A long descriptive name is better than a long descriptive comment. Use a naming convention that allows multiple words to be easily read in the function names, and then make use of those multiple words to give the function a name that says what it does.

Don’t be afraid to spend time choosing a name. Indeed, you should try several different names and read the code with each in place. Modern IDEs like Eclipse or IntelliJ make it trivial to change names. Use one of those IDEs and experiment with different names until you find one that is as descriptive as you can make it.

Choosing descriptive names will clarify the design of the module in your mind and help you to improve it. It is not at all uncommon that hunting for a good name results in a favorable restructuring of the code.

Have No Side Effects
^^^^^^^^^^^^^^^^^^^^

Side effects are lies. Your function promises to do one thing, but it also does other hidden things. Sometimes it will make unexpected changes to the variables of its own class. Sometimes it will make them to the parameters passed into the function or to system globals. In either case they are devious and damaging mistruths that often result in strange temporal couplings and order dependencies. Consider, for example, the seemingly innocuous function this example. This function uses a standard algorithm to match a ``userName`` to a ``password``. It returns ``true`` if they match and ``false`` if anything goes wrong. But it also has a side effect. Can you spot it?

.. code-block:: java

   public class UserValidator {

     private Cryptographer cryptographer;

     public boolean checkPassword(String userName, String password) {
       User user = UserGateway.findByName(userName);
       if (user != User.NULL) {
         String codedPhrase = user.getPhraseEncodedByPassword();
         String phrase = cryptographer.decrypt(codedPhrase, password);
         if ("Valid Password".equals(phrase)) {
           Session.initialize();
             return true;
         }
       }
       return false;
     }
   }

The side effect is the call to ``Session.initialize()``\ , of course. The ``checkPassword`` function, by its name, says that it checks the password. The name does not imply that it initializes the session. So a caller who believes what the name of the function says runs the risk of erasing the existing session data when he or she decides to check the validity of the user.

This side effect creates a temporal coupling. That is, ``checkPassword`` can only be called at certain times (in other words, when it is safe to initialize the session). If it is called out of order, session data may be inadvertently lost. Temporal couplings are confusing, especially when hidden as a side effect. If you must have a temporal coupling, you should make it clear in the name of the function. In this case we might rename the function ``checkPasswordAndInitializeSession``\ , though that certainly violates “Do one thing.”

Comments
--------

Comments Do Not Make Up for Bad Code
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

One of the more common motivations for writing comments is bad code. We write a module and we know it is confusing and disorganized. We know it’s a mess. So we say to ourselves, “Ooh, I’d better comment that!” No! You’d better clean it!

Clear and expressive code with few comments is far superior to cluttered and complex code with lots of comments. Rather than spend your time writing the comments that explain the mess you’ve made, spend it cleaning that mess.

Explain Yourself in Code
^^^^^^^^^^^^^^^^^^^^^^^^

There are certainly times when code makes a poor vehicle for explanation. Unfortunately, many programmers have taken this to mean that code is seldom, if ever, a good means for explanation. This is patently false. Which would you rather see? This:

.. code-block:: java

   // Check to see if the employee is eligible for full benefits
   if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))

Or this?

.. code-block:: java

   if (employee.isEligibleForFullBenefits())

It takes only a few seconds of thought to explain most of your intent in code. In many cases it’s simply a matter of creating a function that says the same thing as the comment you want to write.

Informative Comments
^^^^^^^^^^^^^^^^^^^^

It is sometimes useful to provide basic information with a comment. For example, consider this comment that explains the return value of an abstract method:

.. code-block:: java

   // Returns an instance of the Responder being tested.
   protected abstract Responder responderInstance();

A comment like this can sometimes be useful, but it is better to use the name of the function to convey the information where possible. For example, in this case the comment could be made redundant by renaming the function: ``responderBeingTested``. Here’s a case that’s a bit better:

.. code-block:: java

   // format matched kk:mm:ss EEE, MMM dd, yyyy
   Pattern timeMatcher = Pattern.compile("\\d*:\\d*:\\d* \\w*, \\w* \\d*, \\d*");

In this case the comment lets us know that the regular expression is intended to match a time and date that were formatted with the SimpleDateFormat.format function using the specified format string. Still, it might have been better, and clearer, if this code had been moved to a special class that converted the formats of dates and times. Then the comment would likely have been superfluous.

Don't use a Comment When You Can Use a Function or Variable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Consider the following stretch of code:

.. code-block:: java

   // does the module from the global list <mod> depend on the
   // subsystem we are part of?
   if (smodule.getDependSubsystems().contains(subSysMod.getSubSystem()))

This could be rephrased without the comment as

.. code-block:: java

   ArrayList moduleDependees = smodule.getDependSubsystems();
   String ourSubSystem = subSysMod.getSubSystem();
   if (moduleDependees.contains(ourSubSystem))

The author of the original code may have written the comment first (unlikely) and then written the code to fulfill the comment. However, the author should then have refactored the code, as I did, so that the comment could be removed.
