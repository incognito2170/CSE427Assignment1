/**
 * 
 */

/**
 * @author Sakib
 *
 */

import java.util.Stack;

public class GenericStack<Item> extends Stack<Item> {
    private final static int STACK_SIZE = 15;
    private Item items[];
    private int topItem;

    public GenericStack() {
    	this(STACK_SIZE);
    }
    
    public GenericStack(int initSize) {
        items = (Item[]) new Object[initSize];
        topItem = -1;
    }	

    public Item push(Item newItem) {
    	items[++topItem] = newItem;
        return newItem;
    }
    
    public Item pop() {
    	if (topItem == -1) {
            return null;
        }
    	
        return items[topItem--];
    }
    
    public boolean isEmpty() {
    	if (topItem == -1) {
            return true;
        }
        
    	return false;
    }
}
