# Honours-Project

Abstract:

The problem this project is trying to solve is the ability to predict an outcome of a simplified poker game 

To solve this problem the following approach was taken – a neural network was trained to classify poker hands
and the hand odds of the opposing player were calculated by finding all the possible hand combinations. 
These values were then generated as datasets for multiple poker games and used to train a new neural network to predict a win or a loss. 

Experimentation was performed on data that was downloaded from the UCI Machine Learning Repository as well as data that was generated 
by the project source code. The Code implementation of this project can be found in the following public 
GitHub repository https://github.com/armankocharyan/Honours-Project/tree/master/Data%20Generator

Although the results were good, it stands that the neural network can be improved by training it with more valid data. The predictions 
can also be improved by implementing other AI methods and approaches such as decision trees and reinforcement learning. 


This Project Includes:
- Hand Classifying Neural Network: Honours Project\Neural Networks\HandIdentifierNN.py
- Decision Maker Neural Network: Honours Project\Neural Networks\Decision Maker\DecisionMakerrNN.py
- Poker game generator: \Honours Project\Data Generator

Requirements
-Any versions of Python 3.6 or 3.7
-tensorflow module
-Eclipse Desktop IDE

To Install Tensorflow
- Download Python 3.6 or 3.7 from https://www.python.org/downloads/
- Open Windows command prompt as an admin
- Enter "pip install tensorflow"

To Run the neural networks
- Open Windows command prompt
- Prompt to the project directory "cd ...\Honours Project\Neural Networks"
- Enter "Python HandIdentifierNN.py" to run the hand classifier
- Prompt to "...\Honours Project\Neural Networks\Decision Maker" and enter "Python DecisionMakerrNN.py" to run the NN

To open the data generator
- Install Eclipse IDE from https://www.eclipse.org/ide/
- Open Eclipse IDE and import the "\Honours Project\Data Generator" as a maven project
- running the main method in the Game class should generate game data into the Data Generator folder