package com.mpatric.mp3agic;

import java.io.File;
import java.io.IOException;

public class mainCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mp3File mp3[];
		File curDir = new File(".");
		String[] list;
		int i=0;
		/*try {
			//mp3[] = new Mp3File("un.mp3");
			//System.out.println(mp3.getLengthInSeconds());
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {*/
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = fileLoader(curDir);
		for (String s : list) {
			if (s.charAt(s.length()-1)=='3') {
				System.out.println(s);
			}

		}
		
		
		
	}

	private static String[] fileLoader(File _curDir) {//Returns a string of all files in the main repesitory
		File[] files = _curDir.listFiles();
		String[] listeNomFichiers = new String[files.length];
		int i = 0;

		for (File f : files) {
			if (f.isDirectory()) {
				/* System.out.println(f.getName()); */} 
			else if (f.isFile()) {
				// System.out.println(f.getName());
					
					listeNomFichiers[i]= f.getName();
					
				i++;
			}
			
		}
		return listeNomFichiers;

	}
	private static int nbrefichier(File _curDir) {//Returns a string of all files in the main repesitory
		File[] files = _curDir.listFiles();
		return files.length;

	}
}