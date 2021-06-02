package com.company;

public class Playlist
{
    String name;
    String genre;
    int numberOfSongs;
    double estLength;
    boolean favorite;

    public Playlist(String name, String genre, int numberOfSongs, double length, boolean favorite) {
        this.name = name;
        this.genre = genre;
        this.numberOfSongs = numberOfSongs;
        this.estLength = length;
        this.favorite = favorite;
    }
    @Override
    public String toString() {
        return this.name + " - " + "Bulk Genre: " + this.genre + " - " + "\n " +
                "Number of songs: " + this.numberOfSongs + " - " + "Est. Length (Minutes): " + this.estLength + " - " + "\n Favorite? " + this.favorite + "\n";
    }

    public static double getLength(int songs){
        return songs * 3.35;
    }
}
