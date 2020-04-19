Introduction
============
This is an incomplete program where it just provides the basic functionality of chat window to get you started on creating your own simple chat program. This project was created using NetBeans 11.3.

Structure
=========
The source code is divided into 3 packages, namely, `client`, `gui`, and `mediator`. The `gui` package contains the code to create chat windows. The `mediator` package contains all the necessary classes and interfaces with code given except for `Publisher.java`, where you are expected to put your code in. The `client` package contains `Main.java`, which shows how to instantiate the chat window and initiate activities like join-channel, leave-channel, and send-message in code. All those activities can be similarly done through GUI too. Also it contains a simple `SpyingPublisher` class to demonstrate how to a write a simple publisher/mediator. The `SpyingPublisher` only dumps onto the console activities triggered by chat windows. You can use the code as a starting point to help you kickstart. You can remove the class after that.    

Example of a Simple Chat Program
================================
The following is the output of a completed simple chat program:

![Simple Chat Example](/doc/images/SimpleChat.png)

It created 3 chat windows, i.e., Matthew, Gina and Bambi, and 1 console. Matthew create/join **lounge** channel. Since he was the only participant in that channel, the mediator/publisher informed him that he was alone. Then when Gina joined the channel, she was informed that Matthew was there and Matthew was also been informed that Gina has just joined. The same thing happened when Bambi and Console joined the channel. Matthew sent a greetings and it was broadcasted to all other participants. The same thing happened when Console did the same.  

