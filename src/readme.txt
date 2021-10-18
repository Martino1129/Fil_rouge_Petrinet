This project permits to represent a Petrinet 

The package Petri contains all the classes necessary to create the model
The package Exception contains the exception needed in our implementation 
The package Test contains all the tests made during the implementation 

For the IDL evaluation, Titouan Sauterey has made the test on the Petrinet class (ie Test/PetrinetTest.java) while Martin Ducros has made the test on Place, Transition and Arc (ie PlaceTest.java, IArcTest.java and Transition.java in the package Test)

####### Precision about the model ##########

* When a transition was triggered, we made the choice to remove the tokens from the place before the transitions first and then to add the tokens to the place after the transition

* Two arcs can't be linked to the same place and transition if they have same the direction. 
