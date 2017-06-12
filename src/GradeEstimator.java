
/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          (p1)
// FILE:             (ScoreIteratorADT GradeEstimator ScoreList 
//                   GradeFileFormatException Score ScoreIterator ScoreListADT)
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * This class is the heart of the program. The program will print out the USAGE_
 * MESSAGE and use the default input from Config.java. if you are not given the 
 * exact one command-line argument.If you are given exactly one command-line
 * argument,the main method should attempt to create a new GradeEstimate instance
 * using the public method createGradeEstimatorFromFile(). The main method should
 * catch any FileNotFoundException or GradeFileFormatException thrown, print out
 * their message, and gracefully exit. If you are successful in creating a new 
 * GradeEstimator instance, the main method should then produce a grade estimate 
 * report using the getEstimateReport() method.
 * 
 */
public class GradeEstimator {
	ScoreList scores = new ScoreList(); // A list of scores
	String[] letterGrades; // An array stores grade letters
	double[] letterValues; // An array stores the scores according to the letter
							// grade
	String[] categories; // the first letter of the assignment categories
	double[] catValues; // the percentage of the different categories
	String[] catNames; // the full name of each assignment categories

	// Constructor
	public GradeEstimator(ScoreList scores, String[] letterGrades,
			double[] letterVal, String[] categories, String[] catNames,
			double[] catVal) {
		this.scores = scores;
		this.letterGrades = letterGrades;
		this.letterValues = letterVal;
		this.categories = categories;
		this.catValues = catVal;
		this.catNames = catNames;
		System.out.println(getEstimateReport());
	}

	/*
	 * This method create a new instance of the GradeEstimator class, using the
	 * given filename gradeInfo. It throws an exception of the given file does
	 * not exist, or is not properly formatted as described. If the file is
	 * properly formatted, this method stores the scores contained in the input
	 * file into a single ScoreList.
	 * 
	 * @return: a reference to the newly constructed instance.
	 */
	public static GradeEstimator createGradeEstimatorFromFile(String gradeInfo)
			throws FileNotFoundException, GradeFileFormatException {
		FileInputStream fileByteStream = null; // File input stream
		Scanner inFS = null;
		fileByteStream = new FileInputStream(gradeInfo);
		inFS = new Scanner(fileByteStream); // Scanner read the fileByteStream
		String[] str2 = new String[4];
		for (int x = 0; x < 4; x++) {
			str2[x] = inFS.nextLine().split("#")[0];
		}
		String[] letterGrades = new String[100];
		double[] letterValues = new double[100];
		String[] categories = new String[100];
		double[] catValues = new double[100];
		Scanner s = new Scanner(str2[0]);
		int lcount = 0; // The number of the existing letterGrades.
		while (s.hasNext()) {
			letterGrades[lcount] = s.next();
			lcount++;
		}
		s.close();
		int lvCount = 0; // The number of the existing letterValues.
		s = new Scanner(str2[1]);
		while (s.hasNextDouble()) {
			letterValues[lvCount] = s.nextDouble();
			lvCount++;
		}
		s.close();
		int cCount = 0;// The number of the existing categories.
		s = new Scanner(str2[2]);
		while (s.hasNext()) {
			categories[cCount] = (s.next());
			cCount++;
		}
		s.close();
		s = new Scanner(str2[3]);
		int cvCount = 0; // The number of the existing categoryValues.
		while (s.hasNext()) {
			catValues[cvCount] = (s.nextDouble());
			cvCount++;
		}
		s.close();
		// Shrink down the array.
		String[] letterGrades1 = new String[lcount];
		double[] letterValues1 = new double[lvCount];
		String[] categories1 = new String[cCount];
		String[] catNames = new String[cCount];
		double[] catValues1 = new double[cvCount];

		// Read and separate the first four lines of the grade_info.txt into
		// single array.
		for (int x = 0; x < lcount; x++) {
			letterGrades1[x] = letterGrades[x];
		}
		for (int x = 0; x < lvCount; x++) {
			letterValues1[x] = letterValues[x];
		}
		for (int x = 0; x < cCount; x++) {
			categories1[x] = categories[x].substring(0, 1);
			catNames[x] = categories[x];
		}
		for (int x = 0; x < cvCount; x++) {
			catValues1[x] = catValues[x];
		}
		// check the format of the file
		if (letterGrades1.length != letterValues1.length
				|| categories1.length != catValues1.length) {
			throw new GradeFileFormatException();
		}
		// Separate the remaining lines in the file and store the information
		// into the ScoreList. And check if the file format is correct.
		ScoreList scores = new ScoreList();
		while (inFS.hasNextLine()) {
			String[] str = inFS.nextLine().split("#");
			Scanner s1 = new Scanner(str[0]);
			String checker = s1.next();
			for (int x = 0; x < categories1.length; x++) {
				if (checker.equals(categories1[x]))
					break;
				if (x == categories1.length)
					throw new GradeFileFormatException();
			}
			// Call the constructor.
			Score temp = new Score(checker, s1.nextDouble(), s1.nextDouble());
			// Call the add method and store the new information into the
			// Scorelist.
			scores.add(temp);
			s1.close();
		}
		return new GradeEstimator(scores, letterGrades1, letterValues1,
				categories1, catNames, catValues1);
	}

	/*
	 * This method constructs a String to display the weighted percentage and
	 * letter grade estimates based on the input from the grade info file in a
	 * specific style.
	 * 
	 * @return A string representing the grade report.
	 */
	public String getEstimateReport() {
		String estimateReport = "Grade Estimate is based on " + scores.size()
				+ " scores.\n"; // The first sentence of the report indicating
		// the number of scores based on.
		double totalScore = 0.0; // The score you get.
		double iteratedCatVal = 0.0; // each percentage in the assignment
										// percentage
		double categoryScore = 0.0; // The score you get in each category.
		double weightedScore = 0.0; // the final score you get for each category
		// after multiple the percentage
		String letterGrade = ""; // The final letterGrade

		for (int i = 0; i < categories.length; i++) {
			ScoreIterator itr = scores.iterator(categories[i]);
			// Call the construct and create an iterator.
			if (!itr.hasNext()) { // if there is only one assignment in the
									// array
				categoryScore = 100.00;
				iteratedCatVal = catValues[i];
				weightedScore = categoryScore * iteratedCatVal / 100;
			}
			while (itr.hasNext()) { // if there are many, find the match one
				Score iterated = itr.next();
				// Get the next Score in the specific category.
				String iteratedCat = iterated.getCategory();
				// Get the category of the score which is currently iterating
				// on.
				for (int j = 0; j < categories.length; j++) {
					if (iteratedCat.equalsIgnoreCase(categories[j])) {
						iteratedCatVal = catValues[j];
					}
				}
				categoryScore = getAverageScore(iteratedCat);
				// call the get Average method to calculate the score of each
				// category
				weightedScore = categoryScore * iteratedCatVal / 100;
				// Calculate the score earned in total scale according to the
				// category weight.
			}

			totalScore += weightedScore;
			// create a line of output
			estimateReport += String.format(
					"%1$7.2f%% = %2$5.2f%% of %3$2.0f%% for ", weightedScore,
					categoryScore, iteratedCatVal) + this.catNames[i] + "\n";
			// Output the first part of the estimateReport in a specific format.
		}

		// Match the letterGrades.
		for (int k = 0; k < letterGrades.length; k++) {
			if (totalScore >= letterValues[k]) {
				letterGrade = letterGrades[k];
				break;
			}
		}

		if (letterGrade.equals("")) {
			letterGrade = "unable to estimate letter grade for " + totalScore;
		}
		// Output the wrong message if the totalScore can't be matched
		estimateReport += String.format(
				"--------------------------------\n%7.2f%% weighted percent "
				+ "\nLetter Grade Estimate: ",
				totalScore) + letterGrade;
		// Output the second part of the estimateReport in a specific format.
		return estimateReport;
	}

	/*
	 * This method read the information from a String indicating one category
	 * and calculate the average score one get in the category.
	 * 
	 * @return The averageScore one get for a specific category.
	 */
	private double getAverageScore(String s) {
		double total = 0.0; // the total score of each category
		double pointsPos = 0.0; // The position of the score in the iterator.
		Score score;// the Score instance
		ScoreIterator cat = scores.iterator(s);
		// Read all score belongs to the specific category and calculate the
		// percentage for this work.
		while (cat.hasNext()) {
			score = cat.next();
			total += (score.getPercent());
			pointsPos++;
		}
		return total / pointsPos; // return the average score
	}

	public static void main(String[] args) {
		// test if we are given the one command line
		try {
			if (args.length == 1) {
				createGradeEstimatorFromFile(args[0]);
			} else // if there is not one command line
				System.out.println(Config.USAGE_MESSAGE); // print the message
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (GradeFileFormatException e) {
			System.out.println(e);
		}
	}
}
