package org.iii.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MovieDataConvert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("dataset/ratings.dat"));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("dataset/ratings_movies.csv"));
		String line;
		while((line=br.readLine())!=null){
			String[] values=line.split("::",-1);
			bw.write(values[0]+","+values[1]+","+values[2]+"\n");
		}
	}

}
