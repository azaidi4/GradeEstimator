/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          (p1)
// FILE:             (ScoreIteratorADT GradeEstimator ScoreList GradeFileFormatException 
//					 Score ScoreIterator ScoreListADT)
//
// TEAM:    (16 00010000)
// Authors: (Ahmad Zaidi Devin Samaranayake Raaha Azfar Daisy Tao Ying Zhang 
//	 		David Foster)
// Author1: (Ahmad Zaidi			azaidi4@wisce.edu)
// Author2: (Devin Samaranayake	dsamaranayak@wisc.edu)
// Author3: (Raaha Azfar			azfar@wisc.edu)
// Author4: (Daisy Tao     		tao35@wisc.edu)
// Author5: (Ying Zhang    		yzhang865@wisc.edu)
// Author6: (David Foster  		dfoster4@wisc.edu) 
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: Identify persons by name, relationship to you, and email. 
// Describe in detail the the ideas and help they provided. 
// 
// Online sources: avoid web searches to solve your problems, but if you do 
// search, be sure to include Web URLs and description of 
// of any information you find. 
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * list all the method in the ScoreList to do some implements
 *
 * <p>Bugs: (forget the exceptions)
 *
 * @author (ying zhang)
 */

import java.util.Iterator;
import java.util.NoSuchElementException; //need the exception

public class ScoreList implements ScoreListADT {
	public Score[] items; //create the Score type array 
	public int theSize; //the actual items stored in the array

	/**
	 * construct the ScoreList, and assign the value to the size and assign the 
	 * place for the array
	 */
	public ScoreList() {
		theSize = 0; //assign the value to the size
		items = new Score[10]; //assign the address and the capacity to the array
	}

	/**
	 * call the method to get the actual number of items in the array
	 */
	public int size() {
		return theSize; //get the number of the items in the array
	}

	/**
	 * the add method will add the score to the end of the list 
	 *
	 * PRECONDITIONS: (the score isn't null)
	 * 
	 * POSTCONDITIONS: (the size of the array is incremented)
	 *
	 * @param (Score s) (the Score type s)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	public void add(Score s) throws IllegalArgumentException {
		if (s == null)   //if the Score type s is null
		{
			throw new IllegalArgumentException(); 
			//throw the exception because the Score is non-null and 
			//continuous array
		}
		if (items.length == size()) //if the array is full
		{
			Score[] newItems = new Score[items.length * 2];
			//expand the array
			for (int i = 0; i < items.length; i++) 
			{
				newItems[i] = items[i]; 
				//put the value items in the old array to the new one
				items = newItems; 
				//the old array has twice capacity as it used to be
			}
		}
		items[theSize] = s; //put s at the end of the items
		theSize++; //add the item so the size of the items is increased by one
	}

	/**
	 * create the boolean type, to test whether the array is empty
	 *
	 * PRECONDITIONS: (i.e. the incoming list is assumed to be non-null)
	 * 
	 * POSTCONDITIONS: (i.e. the incoming list has been reordered)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	public boolean isEmpty() { 
		return size() == 0; //if the size of the array is zero, return false
	}

	/**
	 * remove the score item from the array
	 * If i is less than zero or greater than size()-1 throw the exception
	 *
	 * PRECONDITIONS: (i.e. the incoming list has been reordered)
	 * 
	 * POSTCONDITIONS: (there is a array to remove the item, the size of the 
	 * array is decreased by one)
	 *
	 * @param (int i) (the index of the array)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (the score at index i of the array)
	 */
	public Score remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1) //if the i not in the range of 0 to size -1
		{
			throw new IndexOutOfBoundsException(); //throw the exception
		}
		if (isEmpty()) //if the array is empty, people can't use remove method
		{
			throw new NoSuchElementException(); //throw exception
		}
		Score removeItem = items[i]; //assign the removed one item to the Score 
		//typed removeItem
		for (int j = i; j < size() - 1; j++) { //use the for loop to move every 
			//item one index ahead
			items[j] = items[j + 1]; //one index ahead 
		}
		theSize--; //remove one item from the array, the size decreased
		return removeItem; //return the removed item
	}

	/**
	 * Returns (without removing) the item at index position i.
	 * If i is less than zero or greater than size()-1,
	 * will throw an IndexOutOfBoundsException.
	 *
	 * PRECONDITIONS: (the index is between 0 and the size() - 1 and the list
	 * can't be empty)
	 * 
	 * POSTCONDITIONS: (i.e. the incoming list has been reordered)
	 *
	 * @param (int i) (the index of the array)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (the score in the index of the array)
	 */
	public Score get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1) //if the i is not between 0 to size -1
		{
			throw new IndexOutOfBoundsException(); //it will out of bound
		}
		if (theSize == 0) //if there is no item in the array 
		{
			throw new NullPointerException(); //throw the exception
		}
		return items[i]; //return the item people get
	}
	public ScoreIterator iterator(String category) {
		return new ScoreIterator(this, category);
	}
	
	//Do not use this method
	public ScoreIterator iterator() {
		return new ScoreIterator(this, "c");
	}

}