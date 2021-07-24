package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Utilities {

	public static File getLatestFileFromSharedPath(String dirPath) {

		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;

	}

	public static Map<String, String> getFieldValueMappingFromLatestFile(String dirPath) {

		File source = getLatestFileFromSharedPath(dirPath);
		File dest = new File("./Data/dataFile.txt");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file = new File("./Data/dataFile.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> headers_list = Arrays.asList(sc.nextLine().trim().split("[|]+"));
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<String> values_list = null;
		while (sc.hasNextLine()) {
			values_list = Arrays.asList(sc.nextLine().trim().split("[|]+"));
		}
		for (int i = 0; i < headers_list.size(); i++) {
			map.put(headers_list.get(i), values_list.get(i));
		}
		return map;
	}

}
