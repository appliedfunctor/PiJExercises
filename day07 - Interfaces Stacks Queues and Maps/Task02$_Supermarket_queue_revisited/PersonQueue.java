package Task02$_Supermarket_queue_revisited;

public interface PersonQueue {
/**
* Adds another person to the queue.
*/
void insert(Person person);
/**
* Removes a person from the queue.
*/
Person retrieve();
}