/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          (p1)
// FILE:             (ScoreIteratorADT GradeEstimator ScoreList 
//					 GradeFileFormatException Score ScoreIterator ScoreListADT)
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
 * A container that stores references to instances of Score in a 
 * contiguous and ordered list of those instances.
 */
public interface ScoreListADT {

	/** 
	 * Returns the number of Scores in the list or zero
	 * @return the number of scores in this list
	 */
	int size();
	
	/** 
	 * Adds the score to the end of this list.
	 * 
	 * @param s a non-null Score to place as the last item in the list.
	 * @throws IllegalArgumentException
	 */
	void add(Score s) throws IllegalArgumentException;
	
	/**
	 * Removes and returns the item at index position i.
	 * If i is less than zero or greater than size()-1,
	 * will throw an IndexOutOfBoundsException.
	 * @param i must be greater than or equal to zero and less than size()
	 * @return the item at index i
	 * @throws IndexOutOfBoundsException
	 */
	Score remove(int i) throws IndexOutOfBoundsException;

	/**
	 * Returns (without removing) the item at index position i.
	 * If i is less than zero or greater than size()-1,
	 * will throw an IndexOutOfBoundsException.
	 * @param i must be greater than or equal to zero and less than size()
	 * @return the item at index i
	 * @throws IndexOutOfBoundsException
	 */
	Score get(int i) throws IndexOutOfBoundsException;
}
