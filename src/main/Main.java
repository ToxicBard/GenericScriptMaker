package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;

import commonTools.FileTools;


public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * TODO Come up with a better way to load the variables,
		 * or at least a way to comment/mark the input file
		 */
		
		BufferedReader loadFile = FileTools.loadReadFile("cfg/vars.cfg");
		BufferedWriter scriptWriter;
		ArrayList<File> matchingFiles;
		String scriptString;
		
		String fileListExtension = loadFile.readLine();
		String fileListPath = loadFile.readLine();
		String replaceStringRaw = loadFile.readLine();
		String replaceStringToken = loadFile.readLine();
		String outputScriptPath = loadFile.readLine();
		
		scriptWriter = FileTools.openWriteFile(outputScriptPath);
		
		//Get a list of files in the directory that match the file extension
		matchingFiles = getFileList(fileListPath, fileListExtension);
		
		//Generate the script
		scriptString = generateScriptString(matchingFiles, replaceStringRaw, replaceStringToken);
		
		//Display the result
		System.out.println(scriptString);
		
		//Write the result to file
		scriptWriter.write(scriptString);
		scriptWriter.close();
	}
	
	private static ArrayList<File> getFileList(String directoryPath, String extension){
		File listDirectory = new File(directoryPath);
		ArrayList<File> matchingFiles = new ArrayList<File>();
		File[] listDirectoryFiles = listDirectory.listFiles();
		
		//Sort the files alphabetically
		Arrays.sort(listDirectoryFiles);
		
		//Build list of files that match the provided extension
		for(File loopFile : listDirectoryFiles){
			if(loopFile.getName().endsWith(extension)){
				matchingFiles.add(loopFile);
			}
		}
		
		return matchingFiles;
	}
	
	private static String generateScriptString(ArrayList<File> fileList, String replaceString, String replaceToken)
	{
		String toReturn = "";
		String fileNameWithoutExtension;
		
		for(File loopFile : fileList){
			fileNameWithoutExtension = FilenameUtils.removeExtension(loopFile.getName());
			toReturn += replaceString.replace(replaceToken, fileNameWithoutExtension) + "\r\n";
		}
		
		return toReturn;
	}

}
