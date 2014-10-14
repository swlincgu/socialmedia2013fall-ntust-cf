package org.iii.hadoop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

public class ReadSequenceFileArtist {

	public static void main(String[] args) throws IOException {
		String filename = "/";
		Path path = new Path(filename);
		
		String outputfilename = "";
		FileWriter writer = new FileWriter(outputfilename);
		PrintWriter pw = new PrintWriter(writer);
		String newline = System.getProperty("line.separator");
		pw.print("key,value"+newline);
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		SequenceFile.Reader reader = new SequenceFile.Reader(fs, path, conf);
		
		LongWritable key = new LongWritable();
		Text value = new Text();
		
		while(reader.next(key,value)){
			System.out.println("reading key:" + key.toString() + " with value " + value.toString());
		}
		reader.close();
		pw.close();
		writer.close();
	}

}
