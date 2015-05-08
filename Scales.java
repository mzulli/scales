import java.util.Scanner;

public class Scales {
  public static void main (String[] args) {
    int rows = 2;
    int cols = 23;
    
    String[][] notes = new String[rows][cols];
    
    // populate array with initial values
    notes[0][0] = "C"; //sharps
    notes[0][1] = "C#";
    notes[0][2] = "D";
    notes[0][3] = "D#";
    notes[0][4] = "E";
    notes[0][5] = "F";
    notes[0][6] = "F#";
    notes[0][7] = "G";
    notes[0][8] = "G#";
    notes[0][9] = "A";
    notes[0][10] = "A#";
    notes[0][11] = "B";
    notes[1][0] = "C"; //flats
    notes[1][1] = "Db";
    notes[1][2] = "D";
    notes[1][3] = "Eb";
    notes[1][4] = "E";
    notes[1][5] = "F";
    notes[1][6] = "Gb";
    notes[1][7] = "G";
    notes[1][8] = "Ab";
    notes[1][9] = "A";
    notes[1][10] = "Bb";
    notes[1][11] = "B";
    
    // populate remaining notes
    int numNotes = 12;
    int i, j;
    for (i = 0; i < rows; i++){
      for (j = numNotes; j < cols; j++){
        notes[i][j] = notes[i][j % numNotes];
      }
    }
    
    //print full rows
    for (i = 0; i < rows; i++){
      for (j = 0; j < cols; j++){
        System.out.print(notes[i][j] + " ");
      }
      System.out.println();
    }    

    //ask user for starting note
    Scanner inputStart = new Scanner(System.in);
    String startNote;
    String endNote = "";
    try {
      System.out.print("Enter starting note: ");
      startNote = inputStart.next();
    }
    finally {
      inputStart.close();
    }
    
    //find user's note in array
    int startIndex = 0;
    int endIndex = startIndex + 11;
    j = 0; //reset counter
    do {
      if(notes[0][j].equals(startNote)){
        //set the start and end notes
        startNote = notes[0][startIndex];
        endNote = notes[0][endIndex];
      }
      else {
        j ++;
      }
    } while (!notes[0][j].equals(startNote));
    
    //print the start and end notes
    System.out.println("Your starting note, " + startNote + ", was found in column " + j + ".");
    System.out.println("Your ending note is " + endNote + ".");
        
    //print the chromatic scale
    System.out.print(startNote + " chromatic scale: ");
    for (int k = startIndex; k <= endIndex; k++) {
      System.out.print(notes[0][k] + " ");
    }
    System.out.print(notes[0][endIndex + 1] + " ");
    for (int l = endIndex; l >= startIndex; l--) {
      System.out.print(notes[1][l] + " ");
    }
    System.out.println();
    
//    //print chromatic scale
//    System.out.print(tonic + " chromatic scale: ");
//    for (j = 0; j < numNotes; j++) {
//      System.out.print(notes[0][j] + " ");
//    }
//    System.out.print(notes[0][numNotes] + " ");
//    for (j = numNotes - 1; j >= 0; j--) {
//      System.out.print(notes[1][j] + " ");
//    }
//    System.out.println();    
  }
}