package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    Hashtable<String, SoccerPlayer> socPlayer = new Hashtable<String, SoccerPlayer>();
    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {

        SoccerPlayer player = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
        String key = (firstName + "##" + lastName);

        if (socPlayer.containsKey(key))
        {
            return false;
        }
        else
        {
            socPlayer.put(key, player);
            return true;
        }

    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName)
    {

        String key = (firstName + "##" + lastName);

        if (socPlayer.containsKey(key))
        {
            socPlayer.remove(key);
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName)
    {
        String key = (firstName + "##" + lastName);

        if (socPlayer.containsKey(key))
        {
            return socPlayer.get(key);
        }
        else
        {
            return null;
        }
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName)
    {
        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpGoals();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName)
    {
        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpAssists();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {

        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpShots();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {


        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpSaves();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName)
    {
        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpFouls();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {

        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpYellowCards();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName)
    {
        String key = (firstName + "##" + lastName);

        if(socPlayer.containsKey(key))
        {
            socPlayer.get(key).bumpRedCards();
            return true;

        }
        else {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName)
    {
        if(teamName == null)
        {
            return socPlayer.size();
        }
        else
        {
            int count = 0;
            for(SoccerPlayer player: socPlayer.values())
            {
                if(player.getTeamName().equals(teamName))
                {
                    count++;
                }
            }
            return count;

        }
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName)
    {
        if(teamName == null)
        {
            ArrayList<SoccerPlayer> soccPlayer = new ArrayList<SoccerPlayer>();
            for(SoccerPlayer player: socPlayer.values())
            {
                soccPlayer.add(player);
            }
            if((idx)+1 <= soccPlayer.size()) return soccPlayer.get(idx);
            else return null;
        }
        else
        {
            ArrayList<SoccerPlayer> soccPlayer = new ArrayList<SoccerPlayer>();
            for(SoccerPlayer player: socPlayer.values())
            {
                if(player.getTeamName().equals(teamName))
                {
                    soccPlayer.add(player);
                }
            }
            if((idx)+1 <= soccPlayer.size()) return soccPlayer.get(idx);
            else return null;

        }
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file)
    {
        try {
            Scanner scan = new Scanner(file);
            while(EOF != true)
            {
                while(scan.nextLine())
                {

                }
            }

        }
        catch (IOException e) {
        e.printStackTrace();
        }


        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {


        try {
            PrintWriter pw = new PrintWriter(file);
            for(SoccerPlayer player: socPlayer.values()) {
                pw.println(logString(player.getFirstName()));
                pw.println(logString(player.getLastName()));
                pw.println(logString(player.getTeamName()));
                pw.println(logString(""+player.getUniform()));
                pw.println(logString(""+player.getAssists()));
                pw.println(logString(""+player.getFouls()));
                pw.println(logString(""+player.getRedCards()));
                pw.println(logString(""+player.getSaves()));
                pw.println(logString(""+player.getShots()));
                pw.println(logString(""+player.getGoals()));
                pw.println(logString(""+player.getYellowCards()));
                pw.close();

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
