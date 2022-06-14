/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludoogame;

/**
 *
 * @author emirarikan
 */
class Piece {
	private String renk;
	private int parcaRakam;
	private int yCoord;
	private int xCoord;
	private boolean ciktimi;
	private boolean tamammi;
	
	Piece(int pieceNumber, String color) {
		
		this.parcaRakam = pieceNumber+1;
		this.renk = color;
		
	}
	
	String getColor() {
		return renk;
	}
	void setparcaRakam(int pieceNumber){
            parcaRakam=pieceNumber;
        }
	int getPieceNumber() {
		return parcaRakam;
	}
	
	int getX() {
		return xCoord;
	}
	
	int getY() {
		return yCoord;
	}
	
	void setX(int x) {
		xCoord = x;
	}
	
	void setY(int y) {
		yCoord = y;
	}
	
	void setTakenOut(boolean mode) {
		ciktimi = mode;
	}
	
	boolean isTakenOut() {
		return ciktimi;
	}
	
	void setCompleted(boolean mode) {
		tamammi = mode;
	}
	
	boolean isCompleted() {
		return tamammi;
	}
	
}

