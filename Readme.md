Introduction
============
This is an incomplete program where it just provides the basic functionality of chat window to get you started on creating your own simple chat program. 

Structure
=========
The source code is divided into 3 packages, namely, `client`, `gui`, and `mediator`. The `gui` package contains the code to create chat windows. The `mediator` package contains all the necessary classes and interfaces with code given except for `Publisher.java`, where you are expected to put your code in. The `client` package contains `Main.java`, which shows how to instantiate the chat window and initiate activities like join-channel, leave-channel, and send-message in code. All those activities can be similarly done through GUI too. Also it contains a simple `SpyingPublisher` class to demonstrate how to a write a simple publisher/mediator. The `SpyingPublisher` only dumps onto the console activities triggered by chat windows. You can use the code as a starting point to help you kickstart. You can remove the class after that.    

