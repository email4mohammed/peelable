package com.xyz.fruit;

public interface Peelable {
	
	public Colour getColour();

	public short getWeight();

	public byte getTaste();

	public State getState();

	public void setPeeler(Peeler peeler);

	public Peeler getPeeler();

	public boolean isHasWorm();
	
	PeelableResponse eat();
	
	PeelableResponse peel();
	
	
	

}
