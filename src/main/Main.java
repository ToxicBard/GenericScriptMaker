package main;

import java.io.BufferedReader;
import java.io.IOException;

import commonTools.FileTools;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * TODO Start out by getting all of the
		 * necessary parameters line-by-line 
		 * from a text file.
		 * TODO Clean up the parameterization and do
		 * it in a better way down the road
		 * 
		 */
		BufferedReader loadFile = FileTools.loadReadFile("vars.cfg");
		
		String fileListExtension = loadFile.readLine();
		String fileListPath = loadFile.readLine();
		String replaceString = loadFile.readLine();
		/*
		 * Get the list of files
		 */
		/*
		 * Pass the list of files into the string replacement function
		 */
		/*
		 * Print the output to console at first, but then implement
		 * writing to file.
		 */
	}
	
	/*
	 *A function that takes the absolute path
	 *of the directory that the source files are
	 *located in, as well as the file extension to
	 *look for, and then returns a list of all of the
	 *files in that directory that match the provided 
	 *file extension
	 */
	
	/*
	 * A function that takes a list of file objects,
	 * a raw string for replacement, and a delimiter string.
	 * It then loops through each file and replaces the
	 * delimiter string in the raw replacement string with
	 * the filename (without extension) of the loop file.
	 * It then returns a string containing each replaced
	 * string, one on each line
	 */

}
