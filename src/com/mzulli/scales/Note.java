package com.mzulli.scales;

public class Note {
  int noteRow = 0;
  int noteCol = 0;
  Note myNote;
  
  public Note() {    
  }

  public Note(int row, int col) {
     noteRow = row;
     noteCol = col;
  }
  
  public Note getNote() {
    return myNote;
  }  
  
  public int getRow() {
    return noteRow;
  }
  
  public int getCol() {
    return noteCol;
  }
}