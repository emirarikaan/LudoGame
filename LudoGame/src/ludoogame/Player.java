/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludoogame;

/**
 *
 * @author emirarikan
 */
class Player {
	private int atilanZar;
	private String renk;
	private Piece[] parca;
       private boolean balti	;
	
        private String isim;
        	Player(String renk,String isim) {
		this.isim=isim;
		this.renk = renk;
		parca = new Piece[4];
		for(int i=0; i<4; i++)
			parca[i] = new Piece(i, renk);
		
	}

    public void setRenk(String color) {
        this.renk = color;
    }

    public void setAtilanZar(int numberRolled) {
        this.atilanZar = numberRolled;
    }

    public void setAltiyaSahip(boolean hasRolledSix) {
        this.balti = hasRolledSix;
    }

    public void setPiece(Piece[] piece) {
        this.parca = piece;
    }

    public void setIsım(String name) {
        this.isim = name;
    }

    public boolean isBalti() {
        return balti;
    }

    public Piece[] getParca() {
        return parca;
    }

    public String getIsım() {
        return isim;
    }
	
	Player(String color) {
		
		this.renk = color;
		
		parca = new Piece[4];
		
		for(int i=0; i<4; i++)
			parca[i] = new Piece(i, color);
		
	}
	
	void zarAtt() {
		atilanZar = new Zar().roll();
		
		if(atilanZar==6)
			balti = true;
		else balti = false;
		
	}
	
	Piece getPiece(int pieceNumber) {
		return parca[pieceNumber];
	}
	
	String getColor() {
		return renk;
	}
	
	int getNumberRolled() {
		return atilanZar;
	}
	
	boolean hasRolledSix() {
		return balti;
	}
	
	@Override
	public String toString() {
		return "Player " + renk;
	}
	
	boolean kazandi() {
		
		for(int i=0; i<4; i++)
			if(!parca[i].isCompleted())
				return false;
                
				return true;
		
	}
	
}
