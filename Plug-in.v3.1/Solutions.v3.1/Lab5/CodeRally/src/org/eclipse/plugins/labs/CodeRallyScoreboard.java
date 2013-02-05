package org.eclipse.plugins.labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Espirity Inc.
 *
 */
public class CodeRallyScoreboard {
	
	private String fileName;
	private String elements[];

	public CodeRallyScoreboard(String fileName){
		this.fileName = fileName;
		try{
			load();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private void load() throws IOException
		{
			File file = new File(getFileName());
			if(!file.exists())
			{
				System.out.println("Scoreboard file not found at " + getFileName());
				return;
			}
			BufferedReader bufferReader = new BufferedReader(new FileReader(file));
			String string = bufferReader.readLine();
			String tournamentTitle = bufferReader.readLine();
			string = bufferReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(string, "\t");
			int round = Integer.parseInt(stringTokenizer.nextToken());
			int totalRounds = Integer.parseInt(stringTokenizer.nextToken());
			string = bufferReader.readLine();
			stringTokenizer = new StringTokenizer(string, "\t");
			int match = Integer.parseInt(stringTokenizer.nextToken());
			int totalMatches = Integer.parseInt(stringTokenizer.nextToken());
			string = bufferReader.readLine();
			int size = Integer.parseInt(string);
			elements = new String[size + 3];
			elements[0] = tournamentTitle;
			elements[1] = "Round: " + round + "/" + totalRounds;
			elements[2] = "Match: " + match + "/" + totalMatches;
			int points = 0;
			String playerName = null;
			String playerTeam = null;
			for(int i = 0; i < size; i++)
			{
				string = bufferReader.readLine();
				stringTokenizer = new StringTokenizer(string, "\t");
				points = Integer.parseInt(stringTokenizer.nextToken());
				playerName = stringTokenizer.nextToken();
				playerTeam = stringTokenizer.nextToken();
				elements[i+3] = "Player name: " + playerName + " ----- Player team: " + playerTeam + " ----- Player points: " + points;
			}

			bufferReader.close();
		}


	public String[] getElements() {
		return elements;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String string) {
		fileName = string;
	}

}
