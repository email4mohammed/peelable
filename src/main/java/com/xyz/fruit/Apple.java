package com.xyz.fruit;

public class Apple implements Peelable {


	private Colour colour;

	private short weight;

	private byte taste;

	private State state;

	private Peeler peeler;

	private boolean hasWorm;

	public Apple(Colour colour, short weight, byte taste, boolean hasWorm) {
		this.colour = colour;
		this.weight = weight;
		this.taste = taste;
		this.hasWorm = hasWorm;
		this.state = State.UNPEELED;

		switch (colour) {
		case BLUE:
			setPeeler(new ValyrianPeeler());
			break;
		default:
			setPeeler(new DefaultPeeler());
			break;
		}

	}

	public Colour getColour() {
		return colour;
	}

	public short getWeight() {
		return weight;
	}

	public byte getTaste() {
		return taste;
	}

	public State getState() {
		return state;
	}

	public void setPeeler(Peeler peeler) {
		this.peeler = peeler;
	}

	public Peeler getPeeler() {
		return peeler;
	}

	public boolean isHasWorm() {
		return hasWorm;
	}

	public PeelableResponse peel() {

		if ((this.state != State.UNPEELED) || hasWorm || (this.taste < 4)) {
			return new PeelableResponse(PeelableResponse.MessageCode.FAILURE,
					"The apple must be unpeeled and tasty and worm-free before it can be peeled");
		}

		this.peeler.peel();
		this.state = State.PEELED;

		return new PeelableResponse(PeelableResponse.MessageCode.SUCCESS, null);
	}

	public PeelableResponse eat() {

		if (this.state != State.PEELED) {
			return new PeelableResponse(PeelableResponse.MessageCode.FAILURE,
					"The apple must be peeled before it can be eaten");
		}

		this.state = State.EATEN;

		return new PeelableResponse(PeelableResponse.MessageCode.SUCCESS, null);

	}

}
