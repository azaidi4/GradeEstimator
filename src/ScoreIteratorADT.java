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

public interface ScoreIteratorADT {

/** 
 * The class is to provide the methods for the iterator
 * 
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author (Ahmad Zaidi Devin Samaranayake Raaha Azfar Daisy Tao Ying Zhang 
 * David Foster)
 */
public boolean hasNext();

/**
 * The class is to provide the methods for the iterator
 * 
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author (Ahmad Zaidi Devin Samaranayake Raaha Azfar Daisy Tao Ying Zhang 
 * David Foster)
 */
public Score next();
}
