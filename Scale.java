import java.util.Scanner;

public class Scale {
  
  private int rows = 2;
  private int cols = 23;
  private String[][] notes = new String[rows][cols];
  private int tonicRow;
  private int tonicCol;
  private String startNote;
  
  public static void main(String[] args) {
    fillArray();
  }

    // populate array with notes
    public void fillArray() {
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
      int numNotes = 12;
      int i, j;
      for (i = 0; i < rows; i++){
        for (j = numNotes; j < cols; j++){
          notes[i][j] = notes[i][j % numNotes];
        }
      }
    }
    
    //print full array of notes
    public void printArray() {
      int i, j;
      for (i = 0; i < rows; i++){
        for (j = 0; j < cols; j++){
          System.out.print(notes[i][j] + " ");
        }
        System.out.println();
      }
    }

    //set tonic note
    public void setTonic() {
      Scanner inputStart = new Scanner(System.in);
      int i;
      try {
        System.out.print("Enter the starting note: ");
        startNote = inputStart.next();
      }
      finally {
        inputStart.close();
      }
      //find and set tonic
      tonicRow = findTonicRow(startNote);
      tonicCol = findTonicCol(startNote);
    }
    
    //tonic row search
    public int findTonicRow(String target) {
      int i = 0;
      int j = 0;
      for(i = 0; i < rows; i++) {
        if(notes[i][j] == target) {
            return i;
        }
        else {
          return -1;
        }
      }
      return -1;
    }

    //tonic col search
    public int findTonicCol(String target) {
      int i = 0;
      int j = 0;
      for(i = 0; i < notes.length; i++) {
        if(notes[i][j] == target) {
            return j;
        }
        else {
          return -1;
        }        
      }
      return -1;
    }
    
    //print tonic
    public void printTonic() {
      System.out.println("Your starting note, " + startNote 
                           + ", was found in row " + tonicRow + ", column " + tonicCol + ".");
    }
}