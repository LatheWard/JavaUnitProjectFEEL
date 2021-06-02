package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static Playlist getRandomElement(ArrayList<Playlist> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String[] genres = {"Rock", "Alternative", "Jazz", "Country", "Blues", "Pop", "Rap", "Metal"};
        String[] emotions ={"happy", "sad", "angry", "anxious"};
        ArrayList<String> genresList = new ArrayList<>(Arrays.asList(genres));
        ArrayList<String> emotionsList = new ArrayList<>(Arrays.asList(emotions));
        ArrayList<Playlist> happyList = new ArrayList<>();
        Playlist happySongs = new Playlist("HappySongs", "pop", 221, 734, false);
        happyList.add(happySongs);

        ArrayList<Playlist> sadList = new ArrayList<>();
        Playlist sadSongs = new Playlist("SadSongs", "pop", 207, 720, false);
        sadList.add(sadSongs);

        ArrayList<Playlist> angryList = new ArrayList<>();
        Playlist angrySongs = new Playlist("Angry Tunes", "Metal", 36, 139, false);
        angryList.add(angrySongs);

        ArrayList<Playlist> anxiousList = new ArrayList<>();
        Playlist anxiousSongs = new Playlist("Anxiety Relief", "Alternative", 336, 252, false);
        anxiousList.add(anxiousSongs);

        System.out.println(" - - F E E L - - ");
        String mainChoice = ""; // use for main functioning later
        while(!mainChoice.equalsIgnoreCase("exit")){
            System.out.println("[help], Enter my [emotions], [add] my Playlists, [exit]");
            mainChoice = userInput.nextLine();
            if(mainChoice.equalsIgnoreCase("help")){
                System.out.println("ENTER MY EMOTIONS:");
                System.out.print(" This is the main function of the app." +
                        "\n Select this for a recommendation in genre and Spotify playlists" +
                        "\n- - - -");
                System.out.println("\nADD MY PLAYLISTS:");
                System.out.print(" Along with our own playlists to listen to, you can add in the names and information\n" +
                        " of your playlist as well to work with our algorithm" +
                        "\n- - - -");
                System.out.println("\nEXIT:");
                System.out.print("Exits the app\n");
            }

            else if(mainChoice.equalsIgnoreCase("emotions")){
                System.out.println("Which of these do you feel the strongest right now");
                System.out.println("Happy, sad, angry, or anxious?");
                String firstEmotion = userInput.nextLine();
                System.out.println("Here's a playlist we think would be great for you: ");
                if(firstEmotion.equalsIgnoreCase("happy")){
                    System.out.print(getRandomElement(happyList).toString());
                }
                if(firstEmotion.equalsIgnoreCase("sad")){
                    System.out.print(getRandomElement(sadList).toString());

                }
                if(firstEmotion.equalsIgnoreCase("angry")){
                    System.out.print(getRandomElement(angryList).toString());

                }
                if(firstEmotion.equalsIgnoreCase("anxious")){
                    System.out.print(getRandomElement(anxiousList).toString());
                }
            }

            else if(mainChoice.equalsIgnoreCase("add")){
                // Playlist making decision
                System.out.println("How many playlists do you want to enter? Please enter a valid number");
                int entryNumberOfPlaylists = userInput.nextInt();
                userInput.nextLine();
                String playlistInfo = "";
                for(int i = entryNumberOfPlaylists; i > 0; i--){
                    System.out.println("What is your playlist name? >");
                    String playName = userInput.nextLine();
                    System.out.println("What genre does it fall under?");
                    System.out.println("Rock, Alternative, Jazz, Country, Blues, Pop, Rap, Metal \n>");

                    String playGenre = userInput.nextLine();
                    if(!genresList.contains(playGenre)){
                        System.out.println("Please enter one of our genres");
                        System.out.println("Rock, Alternative, Jazz, Country, Blues, Pop, Rap, Metal \n>");
                        playGenre = userInput.nextLine();
                    }
                    System.out.println("How many songs are on the playlist? Please enter a number");
                    int playNumOfSongs = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Is this a favorite? [Y/N] >");
                    boolean playFavoriteUse = false;
                    String playFavorite = userInput.nextLine();
                    if(playFavorite.equalsIgnoreCase("y")){
                        playFavoriteUse = true;
                    }
                    else if(playFavorite.equalsIgnoreCase("n")){
                        continue;
                    }
                    else{
                        System.out.println("Please enter Y or N\n > ");
                        playFavorite = userInput.nextLine();
                    }
                    double playLength = Playlist.getLength(playNumOfSongs);
                    Playlist newPlaylist = new Playlist(playName, playGenre, playNumOfSongs, playLength, playFavoriteUse);
                    if(newPlaylist.genre.equalsIgnoreCase("Rock")){
                        happyList.add(newPlaylist);
                        angryList.add(newPlaylist);
                    }
                    else if(newPlaylist.genre.equalsIgnoreCase("Jazz")){
                        anxiousList.add(newPlaylist);
                    }
                    else if(newPlaylist.genre.equalsIgnoreCase("Country")){
                        sadList.add(newPlaylist);
                    }
                    else if(newPlaylist.genre.equalsIgnoreCase("Blues")){
                        sadList.add(newPlaylist);
                    }
                    else if(newPlaylist.genre.equalsIgnoreCase("Pop")){
                        happyList.add(newPlaylist);
                        anxiousList.add(newPlaylist);
                    }
                    else if(newPlaylist.genre.equalsIgnoreCase("Rap")){
                        happyList.add(newPlaylist);
                        angryList.add(newPlaylist);
                    }
                    System.out.println("Still want to add more playlists? [Y/N] >");
                    String wantMorePlaylists = userInput.nextLine();
                    if(wantMorePlaylists.equalsIgnoreCase("y")){
                        continue;
                    }
                    else if(wantMorePlaylists.equalsIgnoreCase("n")){
                        break;
                    }
            }
            }
        }
    }
}
