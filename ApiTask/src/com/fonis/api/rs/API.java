package com.fonis.api.rs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class API {

	public static void main(String[] args) {

		try {

			URLConnection connection = new URL("https://randomapi.com/api/?key=E3NW-HHAC-LZAL-9RUO&id=m5lvubc&results=5").openConnection();
			InputStreamReader input = new InputStreamReader(connection.getInputStream());
			BufferedReader buff = new BufferedReader(input);
			String response = buff.readLine();

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("files/file.out")));

			JSONObject jsonObject = new JSONObject(response);
			System.out.println(jsonObject.toString(5));
			JSONArray files = jsonObject.getJSONArray("results");
			
			if(files != null) {

				String[] names = new String[files.length()];
				String[] authors = new String[files.length()];
				double[] durations = new double[files.length()];

				for (int i = 0; i < files.length(); i++) {

					JSONObject json = files.getJSONObject(i);

					JSONObject ob = json.getJSONObject("song");
					names[i] = ob.getString("name");
					authors[i] = ob.getString("author");
					durations[i] = ob.getDouble("duration");

					Song song = new Song(names[i], authors[i], durations[i]);

					pw.println(song);
				}
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
