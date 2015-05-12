import java.util.Scanner;

public class Scale {
  
    private int rows = 2;
    private int cols = 23;
    private String[][] notes;
    private int tonicRow = 0;
    private int tonicCol = 0;
    private String startNote = "C";
  
    public Scale() {
        notes = new String[rows][cols];
        
        //fill the array
        notes[0] = new String[] {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#"}; //sharps
        notes[1] = new String[] {"","Db","","Eb","","","Gb","","Ab","","Bb","","","Db","","Eb","","","Gb","","Ab","","Bb"}; //flats
    }
 
    //print full array of notes
    public void printArray() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(notes[i][j] + " ");
            }
            System.out.println();
        }
    }

    //set start note
    public void setStartNote() {
        //prompt user for starting note
        Scanner inputStart = new Scanner(System.in);
        String prompt = "Enter the starting note (use \"#\" for sharp or \"b\" for flat): ";
        try {
            System.out.print(prompt);
            startNote = inputStart.next();
            while(!startNote.matches("^[A-Ga-g][#b]{0,2}")) {
                System.out.println(startNote + " is not a valid note. Please try again.");
                startNote = inputStart.next();
            }
        }
        finally {
            inputStart.close();
        } 
        
        //clean up startNote and pass to setTonic
        setTonic(startNote.substring(0,1).toUpperCase() + startNote.substring(1));
    }
    
    //set tonic
    public void setTonic(String target) {
        int i = 0;
        int j = 0;
        
        //if the startNote is C set tonic to notes[0][0]
        if(target.equals(notes[i][j])) {
            tonicRow = i;
            tonicCol = j;
        }
        
        //otherwise, find it in the array
        else {
            for(i = 0; i < rows; i++) {
                for(j = 0; j < cols; j++) {
                    if(target.equals(notes[i][j])) {
                        tonicRow = i;
                        tonicCol = j;
                        break;
                    }
                }
            }
        }
    }
    
    //print tonic
    public void printTonic() {
        System.out.println("Your starting note, " + startNote.substring(0,1).toUpperCase() + startNote.substring(1) 
                           + ", was found in row " + tonicRow + ", column " + tonicCol + ".");
    }
    
    //print chromatic scale
    public void printChromatic() {
        System.out.println(startNote.substring(0,1).toUpperCase() + startNote.substring(1) + " chromatic scale:");
        
        //if the tonic is natural or sharp use sharps ascending and flats descending
        if(tonicRow == 0) {
            int j = 0;
            int resume = 0;
            
            //print ascending
            for(j = tonicCol; j < tonicCol + 12; j++) {
                System.out.print(notes[0][j] + " ");
            }
            resume = j;
            System.out.print(startNote.substring(0,1).toUpperCase() + startNote.substring(1) + " ");
            
            //print descending
            for(j = resume - 1; j >= tonicCol; j--) {
                
                //if the note is natural it must be printed from row 0
                if(notes[1][j].isEmpty()) {
                    System.out.print(notes[0][j] + " ");
                }
                else {
                    System.out.print(notes[1][j] + " ");
                }
            }
            System.out.println();
        }
        
        //if the tonic is flat use flats
        else {
            int j = 0;
            int resume = 0;
            
            //print ascending
            for(j = tonicCol; j < tonicCol + 12; j++) {
                
                //if the note is natural print from row 0
                if(notes[1][j].isEmpty()) {
                    System.out.print(notes[0][j] + " ");
                }
                else {
                    System.out.print(notes[1][j] + " ");
                }
            }
            resume = j;
            System.out.print(startNote.substring(0,1).toUpperCase() + startNote.substring(1) + " ");
            
            //print descending
            for(j = resume - 1; j >= tonicCol; j--) {
                if(notes[1][j].isEmpty()) {
                    System.out.print(notes[0][j] + " ");
                }
                else {
                    System.out.print(notes[1][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    //print major scale
    public void printMajor() {
        int i = tonicRow;
        int j = tonicCol;
        int resume = 0;
        System.out.println(startNote.substring(0,1).toUpperCase() + startNote.substring(1) + " major scale:");
        
        //C# scale is unique because it contains all sharps
        if(notes[0][1].equals(startNote.substring(0,1).toUpperCase() + startNote.substring(1))) {
            System.out.println("C# D# E# F# G# A# B# C#");
        }
        
        else {
            //print tonic and next two whole steps up
            for(j = tonicCol; j <= tonicCol + 4; j = j + 2) {
                //print natural notes from row 0
                if(notes[i][j].isEmpty()) {
                    System.out.print(notes[0][j] + " ");
                }
                else {
                    System.out.print(notes[i][j] + " ");
                }
            }
            
            //print two and a half steps up from tonic
            j = tonicCol + 5;
            System.out.print(notes[i][j] + " ");
            
            //print next three whole steps
            resume = j + 2;
            for(j = resume; j <= resume + 4; j = j + 2) {
                if(notes[i][j].isEmpty()) {
                    System.out.print(notes[0][j] + " ");
                }
                else {
                    System.out.print(notes[i][j] + " ");
                }
            }
            
            //print last note
            j = j - 1;
            System.out.print(notes[i][j]);
            System.out.println();
        }
    }
}