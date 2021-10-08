Verbose list-  name, personal number, member id and boats with boat information.

Change boat info, båttyp och längd
//I controller:
loopa alla båtar i lista,
Bygg upp sträng för val av båtar,
val = ui.askForInput(Lista med båtalternativ)
errorhantera, annar gå in i båtens ändringläge//

Simple error handling
Class diagram
Sekvensdiagram

Hobbes final advice
To find out if you have view responsibility in your controller/model you can imagine changing the language of the view. If you need to change things in controller or model you likely have view responsibility in them.
To find if you have model responsibility in your controller/view imagine writing a new UI (new controller/view) if you need to reimplement domain/business rules you likely have model responsibility in your controller/view. Another way is to check if a change in a business rule requires change in the controller/view.
Add all relations in the class diagram between the classes you have created. Make sure you know the difference between dependency and association, use the correct design level UML notation for the class diagram, esp important for associations as this is different from domain modeling.
Add all method calls (messages) between the objects in the sequence diagram, use proper object:Type notation, add parameters to your messages.
Check for hard-coded constants they are indicative of hidden dependencies. Classical examples are between view and controller to handle menu choices etc. (edited) 