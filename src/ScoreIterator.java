
/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          (p0)
// FILE:             (ScoreIteratorADT GradeEstimator ScoreList 
//					GradeFileFormatException, Score ScoreIterator ScoreListADT)
//
// TEAM:    (16 00010000)
// Authors: 
// Author1: (YingZhang, yzhang865@wisc.edu, 001)
// Author2: (Raaha Azfar, azfar@wisc.edu,001)
// Author3: (David Foster, dfoster4@wisc.edu, 001)
// Author4: (DEVIN SAMARANAYAKE, dsamaranayak@wisc.edu,001) 
// Author5: (Daisy Tao, tao35@wisc.edu, 001)
// Author6: (AHMAD ZAIDI, azaidi4@wisce.edu,001) 
//////////////////////////// 80 columns wide //////////////////////////////////
/*
 * ScoreIterator is a class implementing ScoreIteratorADT as an indirect iterator.
 * It iterate through a given ScoreList considering the items in the ScoreList
 * that match a given category.
 * <p> Bugs: NoSuchElementException.
 */
 import java.util.*;
 public class ScoreIterator implements ScoreIteratorADT {
 private ScoreList myList; 	// A list of Score items.
 private int currPos;		// The current position of the iterator.
 private String category;	// The category to match with.
 
 //Constructor
 public ScoreIterator(ScoreList List,String category) {
	 this.myList = List;
	 this.currPos = 0;
	 this.category = category;
	 }
 
 /*
  * To check if there is more Scores in the scoreList matching the given category.
  * @returns true if there is more such scores; returns false is there is not.
  */
 public boolean hasNext() {
	 while (currPos < myList.size() && !(myList.get(currPos).getCategory().
			 equals(this.category))) {
		 currPos ++;
	 }
	 return (currPos < myList.size());
 }
	 
 /*
  * If there is more scores belong to the given category , pick up the next Score.
  * @return Score which matches the given category. 
  */
 public Score next() {
	 if(!hasNext()) throw new NoSuchElementException();
	 while (hasNext() && !myList.get(currPos).getCategory().equals(this.category)) {
	  currPos++;
	 }
	 return  myList.get(currPos++);	
 }
}