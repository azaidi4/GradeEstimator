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
 * this class constructs the Score which contains the name, possible points 
 * and total points. And add the conditions and throw the exceptions if the 
 * name is null and the points are less than zero. Also some methods to do some
 * calculations with the points.
 *
 * <p>Bugs: (forget about the exceptions)
 *
 * @author (ying zhang)
 */

public class Score {
	private String assignName = ""; //create the variable for the name
	private double earnPoints = 0.0; //the possible earned points
	private double assignPoints = 0.0; //the total points 

	/**
	 *construct Score and give the concrete contents to the variables 
	 *and set the conditions for the variables. If the variables don't 
	 *satisfy the conditions, there will have exceptions.
	 */
	public Score(String assignName, double earnPoints, double assignPoints) {
		this.assignName = assignName; 
		this.earnPoints = earnPoints;
		this.assignPoints = assignPoints;
		if (assignName == null) //set the condition for the name
		{
			throw new IllegalArgumentException(); //throw the exception
		}
		if (assignPoints < 0) //the total points can't less than zero
		{
			throw new IllegalArgumentException(); //throw the exception
		}
		if (earnPoints < 0 || earnPoints > assignPoints)  //if the earned points
			//are negative or the earned points are more than the total one
		{
			throw new IllegalArgumentException(); //throw the exception
		}
	}

	/**
	 * get the name of Score
	 *
	 * PRECONDITIONS: (we must have the String assignName)
	 * 
	 * POSTCONDITIONS: (we can call the getName method to get the name 
	 * in other classes)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	public String getName() {
		return assignName; //get the name 
	}

	/**
	 * call the getPoints method to get the possible points can get
	 *
	 * PRECONDITIONS: (create the earnPoints variable)
	 * 
	 * POSTCONDITIONS: (call call the method in other classes to
	 *  get the earnPoints)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (the points we get)
	 */
	public double getPoints() {
		return earnPoints; //the points people earn
	}

	/**
	 * call the method to get the max possible value we can get
	 *
	 * PRECONDITIONS: (create the variable assignPoints)
	 * 
	 * POSTCONDITIONS: (we can call the method in other classes to get the 
	 * max possible value)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (max points)
	 */
	public double getMaxPossible() {
		return assignPoints; //get the maximum points
	}

	/**
	 * people can categorize the name by get the first character of the name
	 *
	 * PRECONDITIONS: (have to create the variable assignName first)
	 * 
	 * POSTCONDITIONS: (call the method to categorize names)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (names with the same first character)
	 */
	public String getCategory() {
		return assignName.substring(0, 1); 
		//get the first character of the name
	}

	/**
	 * calculate the percent of the points people get
	 *
	 * PRECONDITIONS: (create the variable assignPoints and earnPoints and the 
	 * assignPoints has to be non-zero because it's denominator)
	 * 
	 * POSTCONDITIONS: (get the percentage of the points)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (the percentage of the points and multiple 100)
	 */
	public double getPercent() {
		if (assignPoints == 0) //the denominator can't be zero
		{
			throw new NullPointerException(); //throw exception 
		}
		return (earnPoints / assignPoints) * 100; 
		//return the percentage of the point
	}

}
