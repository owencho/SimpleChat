Introduction
============
This is an incomplete program where it just provides the basic functionality of chat window to get you started on creating your own simple chat program. In the chat window you can create/join different channels so that only interested parties can chat among themselves. A participant can leave a channel if he/she chooses to do so.

Integrated Development Environment (IDE)
========================================
This project was created using NetBeans 11.3. To get started, `git clone` or download the project. Then open it under the NetBeans IDE.

Project Structure
=================
The source code is divided into 3 packages, namely, `client`, `gui`, and `mediator`. The `gui` package contains the code to create chat windows. The `mediator` package contains all the necessary classes and interfaces with code given except for `Publisher.java`, where you are expected to put your code in. The `client` package contains `Main.java`, which shows how to instantiate the chat window and initiate activities like _join-channel_, _leave-channel_, and _send-message_ in code. All those activities can be similarly done through GUI too. Also it contains a simple `SpyingPublisher` class to demonstrate how to a write a simple publisher/mediator. The `SpyingPublisher` only dumps onto the console activities triggered by chat windows. You can use the code as a starting point to help you kickstart. You can remove the class after that.

ChatFrame GUI
=============
To create and display a ChatFrame, invoke `ChatFrame.createFrame()` method as follow:
```java
SpyingPublisher publisher = new SpyingPublisher();
ChatFrame matt = ChatFrame.createFrame("Matthew", publisher);
```
`createFrame()` requires a _user name_ and a _publisher_. The name is needed to identify the user and should be unique. The publisher is a mediator object whose job is to coordinate the reception and dissemination of chat and system status messages.
[Note: Change the `SpyingPublisher` to `Publisher` once you have completed the `Publisher.java` code]

You can join/create channel by clicking on `Channel->Open Channel` in the GUI menu or hit `Ctrl-O`, then type in the channel name in the input dialog. Or you can do the same in the code as follow:
```java
matt.createChannel("My chat group");
```
If you created more than 1 ChatFrame, they would stack up on one another on the screen. You have to move the top ChatFrame away to see another ChatFrame immediately below it. ChatFrame objects can be created with the __same user name__, however they can conflict with one another and it is undesireable. So avoid re-using user name.  

To send a message, type the message in the text field box next to `Send` button, then press `Enter` key to send or click on the `Send` button. You can do the same in code as follow:
```java
matt.sendMessage("I know how to design using the Mediator design pattern!!!", "My chat group");
```
Watch the output console for the information dumped by the `SpyingPublisher` when _join-channel_, _leave-channel_, and _send-message_ are performed.

![Simple Chat Example](/doc/images/OutputFromSpyingPublisher.png)

Example of a Simple Chat Program
================================
The following is the output of a completed simple chat program [note that this code is not provided]:

![Simple Chat Example](/doc/images/SimpleChat.png)

It creates 3 chat windows, i.e., Matthew, Gina and Bambi, and 1 console. Matthew creates/joins **lounge** channel. Since he is the only participant in that channel, the mediator/publisher informs him that he is alone. Then when Gina joins the channel, she is informed that Matthew has been there and at the same time Matthew is informed that Gina has just joined. The same thing happens when Bambi and Console join the channel. Matthew sends greetings and it gets broadcasted to all other participants. The same thing happens when Console did the same.  

