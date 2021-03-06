
public class slltest{
    /*
      Author: Dustin Hu
      Date: 25-11-2014
      Purpose: To run the singly linked list simulation

      Methods: The m/ain 

     */
    public static void main(String[] args) throws CloneNotSupportedException{
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: To run the singly likned list demonstartion
	// Ipnut: None
	// Output: NOne

	SingleSortedLinkedList George = new SingleSortedLinkedList();
	SingleSortedLinkedList Frank = new SingleSortedLinkedList();
	System.out.println("Here's George's train:");
	System.out.println(George);

	System.out.println("As you can see, he lacks cars, and goes straight to a caboose.");
	System.out.println("And isEmpty will prove this for us.");
	System.out.print("isEmpty(), is George's train empty? ");
	System.out.println(George.isEmpty());

	System.out.println("Well then, let's give him a few cars in his train.");
	
	George.insert("ABC", "cde");
	George.insert("lew", "gpr");

	System.out.println("And here's his train");
	System.out.println(George);

	System.out.println("And say that Pacific Railways decided to add car Oil between ABC and lew, then his train would look like this.");
	George.insert("Oil", "lew");
	System.out.println(George);

	System.out.println("And if you ask George where the Oil is, he'll tell you that it's right here.");
	System.out.println(George.find("Oil"));

	System.out.println("But if you ask him where's the coal, he'll say");
	System.out.println(George.isNodeInList("coal"));

	System.out.println("And after the Lac-Megantic incident, George cant' carry oil anymore, so there goes his oil car.");
	George.delete("Oil");
	System.out.println("And now here is his train post Lac-Megantic");
	System.out.println(George);

	System.out.println("Well now, let's try printOdd with the current cars.");
	System.out.println(George);
	System.out.println("As you can see, we can't very well printOdd without enough cars, so let's give him back his oil car");
	George.insert("Oil", "lew");
	System.out.println(George);
	System.out.println("And now we can printOdd.");
	System.out.println(George.printOdd());

	    
	System.out.println("Well what if we needed to find the oil car?");
	System.out.println("Well let's tell George to find us the Oil car.");
	System.out.println(George.selfOrganizingSearch("Oil"));
	System.out.println("Oh, hey, look, he even moved it up to the front of the train for us... Though I'm not sure that's a good thing.");
	

	System.out.println("Oh, hey, there's Frank! He's got a job again!");
	System.out.println("Sort of, his train is... Empty.");
	System.out.println(Frank);
	System.out.println("Let's give Frank a few cars so he's not so lonely.");
	
	Frank.insert("Coal", "");
	Frank.insert("Gunpowder", "Coal");
	Frank.insert("Potatoes", "Coal");
	System.out.println("Frank's train is slightly odd though now, take a look.");
	System.out.println(Frank);
	System.out.println("Well that's okay, we'll just add George's train to his train.");
	System.out.println("And here's their new train.");
	System.out.println(Frank.concatenate(George));

	System.out.println("Oh, hey, look, Frank's going backwards.");
	Frank.reverse();
	System.out.println(Frank);
	System.out.println("I think he's a little bit drunk.");
	    
	System.out.println("Well then, what if we want to flip the Oil and ABC so that we're a little bit safer?");
	System.out.println("Let's ask George, Frank got fired for getting drunk.");
	George.exchange("Oil", "ABC");
	System.out.println("Oh, look, he's done already!");
	System.out.println(George);
	System.out.println("And George, could you reverse the train for me? I want to go the other way now.");
	George.reverse();
	System.out.println(George);
    }
}

class Node implements Cloneable{j
    /*
      Author: Dsutin Hu
      Date: 24-11-2014
      Purpose: To be a node
      Methods:

          Node: Constructor with no paramateres
	  Node: Constructor with info parameter
	  clone: Clones the Node
	  toString: Outputs the node as a string
     */

    public String data; 
    public Node next;

    public Node(){
	// AUthor: DUstin Hu
	// Date: 24-11-2014
	// Purpose: To create the node
	// Input: None
	// Output: None

	this.data = "";
	this.next = null;
    }
    public Node(String info){
	// AUthor: Dustin Hu
	// Date: 24-11-2014
	// Purpose: To create a new node
	// Input: THe data, a string
	// Output: None
	
	this.data = info;
	this.next = null;
    }
    public Object clone() throws CloneNotSupportedException {
	// AUthor: Dustin Hu
	// Date: 24-11-2014
	// Purpoes: To clone the node
	// Input: None
	// Output: A cloned node

	Node output = (Node) super.clone();
	if (this.next == null){
	    output.next = null;
	}
	else{
	    output.next = (Node) this.next.clone();
	}
	return output;
    }
    public String toString() {
	// AUthor: Dusitn Hu
	// Date: 11-25-2014
	// Purpose: To create the string 
	// Input: None
	// OUtput: THe node as a string
	String output = "";
	if (this.next == null){
	    output = output + this.data + " -> NULL";
	}
	else{
	    output = output + this.data + " -> " + this.next.toString();
	}
	return output;

    }
}

class SingleSortedLinkedList implements Cloneable{
    /* 
       Author: Dustin Hu
       Date: 25-11-2014
       Purpose: To be the singly linked list

       Fields: 
           list: The linked list

       Methods:
           SingleSortedLinkedList: Constructor with no parameters
           SingleSortedLinkedList: Constructor with one parameters
	   isEmpty: Checks if the linked list is empty
	   clone: Clones the list
	   getLastNode: Gets the last node
	   find: Finds the node before the target
	   insert: Inserts a string into the linked list
	   isNodeInList: Checks if a node is in the list
	   delete: Deletes the node
	   printOdd: Prints every other node
	   selfOrganizingSearch: Finds a node, null if not found given a string, and then and thne moves it to the front of the list
	   concatenate: Concatenates two lists together
	   exchange: Exchanges two nodes
	   areNeighbours: Checks if two nodes are neighbours
	   reverse: Reverses the linked list
     */

    protected Node list;

    public SingleSortedLinkedList(){
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To create the single sorted linked list
	// Input: None
	// Output: None
	this.list = null;
    }
    public SingleSortedLinkedList(Node initial){
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To create the single sorted linked list
	// Input: The onde to start at
	// Output: None
	this.list = initial;
    }
    public boolean isEmpty(){
	// Author: Dustin Hu
	// Dae: 25-11-2014
	// Purpose: To check if the list is empty
	// Input: None
	// Output: True if the list is empty, false otherwise
	return list == null;
    }
    public Object clone() throws CloneNotSupportedException{
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To clone the list
	// Input: None
	// Output: THe cloned list
	SingleSortedLinkedList output = (SingleSortedLinkedList) super.clone();
	if (list != null){
	    output.list = (Node) this.list.clone();
	}
	else{
	    output.list = null;
	}
	return output;
    }
    public Node getLastNode(){
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To get the last node
	// Input: None
	// Output: The last node
	Node current = this.list;
	Node previous = this.list;
	boolean walk = true;

	while (walk == true){
	    if (current == null){
		walk = false;
	    }
	    else{
		previous = current;
		current = current.next;
	    }
	}

	return previous;
    }
    public Node find(String info){
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To find the next node
	// Input: The string to find
	// Output: The node before the node containing a given string
	Node previous = null;
	Node current = this.list;
	Node last = this.getLastNode();
	boolean walk = true;

	while (walk == true){
	    if (current == null){
		walk = false;
	    }
	    else if (current.data.equals(info)){
		walk = false;
	    }
	    else{
		previous = current;
		current = current.next;
	    }
	    
	}

	return previous;
    }
    public void insert(String info, String target){
	// Author: Dustin Hu
	// Date: 25-11-2014
	// Purpose: To insert a node
	// Input: The string to be inesrted and the place to inesrt it
	// Output: None
	Node toBeInserted = new Node(info);
	Node previous = this.find(target);
	Node after;


	if (this.isEmpty() == true){
	    this.list = toBeInserted;
	}
	else if (this.isNodeInList(target) == false){
	    this.getLastNode().next = toBeInserted;
	}
	else if (this.list.data.equals(target)){
	    after = this.list;
	    toBeInserted.next = after;
	    this.list = toBeInserted;
	    

	}
	else{
	    after = previous.next;
	    previous.next = toBeInserted;
	    toBeInserted.next = after;
	}


   } 
    public boolean isNodeInList(String info){
	// Author: Dustin Hu
	// Date: 26-11-2014
	// Purpose: To see if a node is in the list
	// Input: The node to found
	// output: True if the node is in the list, false if it's not

	boolean inList = false;
	Node current = this.list;

	if (this.isEmpty() == true){
	    inList = false;
	}
	else{
	    while (current != null && inList == false){
		if (current.data.equals(info)){
		    inList = true;
		}
		else{
		    current = current.next;
		}
	    }
	}
	return inList;
    }
    public boolean delete (String info){
	// Author: Dustin Hu
	// Date: 28-11-2014
	// Purpose To delete a node
	// Input: The string to delete
	// OUtput: Boolean true if deleted, otherwise false
	boolean output = true;
	Node previous;
	Node current;
	Node after;

	if (this.isNodeInList(info) == false){
	    output = false;
	}
	else{
	    if (this.list.data.equals(info)){
		this.list = this.list.next;
	    }
	    else if (this.getLastNode().data.equals(info)){
		this.find(info).next = null;
	    }

	    else{
		previous = this.find(info);
		current = previous.next;
		after = current.next;
		previous.next = after;
	    }
	}
	return output;
    }
    public String printOdd (){
	// Author: Dustin Hu
	// Date: 28-11-2014
	// Purpose: To print out eveyr other node
	// Input: None
	// Output: Evey other node's data
	String output = "";
	Node current = this.list;
	Node next;
	boolean walk = true;
	
	while (walk){
	    if (current == null){
		output = output + " NULL";
		walk = false;
	    }
	    else{
		output = output + current.data + " -> ";
		if (current.next == null){
		    current = null;
		}
		else{
		    current = current.next.next;
		}
	    }
	    
	}
	return output;
    }
    public Node selfOrganizingSearch(String info){
	// Author: Dustin Hu
	// Date: 28-11-2014
	// Purpose: To search for a node and move it to the front if it exsis
	// Input: The string to look for
	// Output: The node if found, null otherwise
	Node output;

	if (this.isEmpty() || this.isNodeInList(info) == false){
	    output = null;
	}
	else if (this.list.data.equals(info)){
	    output = this.list;
	}
	else{
	    output = this.find(info).next;
	    this.delete(output.data);
	    output.next = this.list;
	    this.list = output;
	}
	return output;

    }
    public SingleSortedLinkedList concatenate(SingleSortedLinkedList input) throws CloneNotSupportedException{
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: To concatenate two singly linked lists together
	// Input: The list to concatenate
	// Output: This list concatenated with the input list
	SingleSortedLinkedList output;
	Node end;

	if (this.isEmpty()){
	    output = (SingleSortedLinkedList) input.clone();
	}
	else if (input.isEmpty()){
	    output = (SingleSortedLinkedList)this.clone();
	}
	else{
	    output = (SingleSortedLinkedList) this.clone();
	    output.getLastNode().next = (Node) input.list.clone();
	}
	return output;
   
    }
    public void exchange (String NodeA, String NodeB){
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: To exchange two nodes
	// Input: The two string valueso f the nodes you wish to swap
	// Output: None


	if (this.isNodeInList(NodeA) == false || this.isNodeInList(NodeB) == false || this.isEmpty()){
	}
	else{

	    // Temporarily refer to the two nodes using new variables
	    Node NodeOne;
	    Node NodeTwo;
	    // Create a leftOfNodeOne, leftOfNodeTwo, rightOfNodeOne, rightOfNodeTwo
	    Node leftOfNodeOne;
	    Node leftOfNodeTwo;
	    
	    Node rightOfNodeOne;
	    Node rightOfNodeTwo;

	    if (this.find(NodeA) == null){
		NodeOne = this.list;
	    }
	    else{
		NodeOne = this.find(NodeA).next;
	    }

	    if (this.find(NodeB) == null){
		NodeTwo = this.list;
	    }
	    else{
		NodeTwo = this.find(NodeB).next;
	    }


	    if (this.list.data.equals(NodeA) && this.areNeighbours(NodeOne, NodeTwo) == false){
		// If NodeOne is first node, does not require a leftOfNodeOne
		leftOfNodeTwo = this.find(NodeB);
		rightOfNodeTwo = NodeTwo.next;
		
		rightOfNodeOne = NodeOne.next;

		leftOfNodeTwo.next = NodeOne;
		NodeOne.next = rightOfNodeTwo;

		NodeTwo.next = rightOfNodeOne;
		this.list = NodeTwo;
	    }
	    else if (this.list.data.equals(NodeB) && this.areNeighbours(NodeOne, NodeTwo) == false){
		leftOfNodeOne = this.find(NodeA);
		rightOfNodeOne = NodeOne.next;
		
		rightOfNodeTwo = NodeTwo.next;

		leftOfNodeOne.next = NodeTwo;
		NodeTwo.next = rightOfNodeOne;

		NodeOne.next = rightOfNodeTwo;
		this.list = NodeOne;
	    }
	    
	    else if (this.list.data.equals(NodeA) && this.areNeighbours(NodeOne, NodeTwo)){
		rightOfNodeTwo = NodeTwo.next;
		NodeOne.next = rightOfNodeTwo;
		NodeTwo.next = NodeOne;
		this.list = NodeTwo;
	    }
	    else if (this.list.data.equals(NodeB) && this.areNeighbours(NodeOne, NodeTwo)){
		rightOfNodeOne = NodeOne.next;
		NodeTwo.next = rightOfNodeOne;
		NodeOne.next = NodeTwo;
		this.list = NodeOne;
		
	    }

	    else if (NodeOne.next == NodeTwo){
		leftOfNodeOne = this.find(NodeA);
		rightOfNodeTwo = NodeTwo.next;

		leftOfNodeOne.next = NodeTwo;
		NodeOne.next = rightOfNodeTwo;
		
		NodeTwo.next = NodeOne;
	    }
	    else if (NodeTwo.next == NodeOne){
		leftOfNodeTwo = this.find(NodeB);
		rightOfNodeOne = NodeOne.next;

		leftOfNodeTwo.next = NodeOne;
		NodeTwo.next = rightOfNodeOne;
		
		NodeOne.next = NodeTwo;

	    }
	    
	    else{
		leftOfNodeOne = this.find(NodeA);
		rightOfNodeOne = NodeOne.next;
		
		leftOfNodeTwo = this.find(NodeB);
		rightOfNodeTwo = NodeTwo.next;

		NodeOne.next = rightOfNodeTwo;
		leftOfNodeTwo.next = NodeOne;
		
		NodeTwo.next = rightOfNodeOne;
		leftOfNodeOne.next = NodeTwo;
	    }
	}
    }
    public boolean areNeighbours(Node a, Node b){
	// AUthor: Dustin Hu
	// Date: 29-11-2014
	// Purpose: To check if two nodes are neighbours
	// Input: The two nodes to check
	// Output: Boolean true if they're neighbours, boolean false if not
	boolean output;
	if (a.next == b){
	    output = true;
	}
	else if (b.next == a){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public void reverse(){
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: To reverse a linked list
	// Input: None
	// Output: None

	// SingleSortedLinkedList temp = new SingleSortedLinkedList();
	// temp.list = this.getLastNode();
	// this.delete(this.getLastNode().data);

	// while (this.list != null){
	//     temp.getLastNode().next = this.getLastNode();
	//     this.delete(this.getLastNode().data);
	// }
	// this.list = temp.list;
	Node temp = this.getLastNode();
	Node current;
	current = temp;
	this.delete(this.getLastNode().data);
	
	while (this.list != null){
	    current.next = this.getLastNode();
	    this.delete(this.getLastNode().data);
	    current = current.next;
	}

	this.list = temp;
    }
    public String toString(){
	// Author: Dsutin Hu
	// Date: 25-11-2014
	// Purpose: To get the string of the linked list
	// Input: Noen
	// Output: The linked list as a string
	String output = "";
	if (this.isEmpty()){
	    output = "NULL";
	}
	else{
	    output = this.list.toString();
	}
	return output;
    }
    


}

