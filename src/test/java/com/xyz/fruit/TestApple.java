package com.xyz.fruit;

import org.junit.Assert;
import org.junit.Test;

import com.xyz.fruit.PeelableResponse.MessageCode;

public class TestApple {
	
	@Test
	public void testTastyPeelableApple() {
		
		Peelable apple = new Apple(Colour.GREEN, (short)50, (byte)4, false);
		
		PeelableResponse response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.SUCCESS);
		Assert.assertEquals(apple.getState(), State.PEELED);
		
		response = apple.eat();
		Assert.assertEquals(response.getMessageCode(), MessageCode.SUCCESS);
		Assert.assertEquals(apple.getState(), State.EATEN);

	}

	@Test
	public void testPeelAPeeledApple() {
		
		Peelable apple = new Apple(Colour.GREEN, (short)50, (byte)4, false);
		
		PeelableResponse response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.SUCCESS);
		Assert.assertEquals(apple.getState(), State.PEELED);
		
		response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.FAILURE);
		Assert.assertEquals(apple.getState(), State.PEELED);

	}
	
	@Test
	public void testUnTastyApple() {
		
		Peelable apple = new Apple(Colour.GREEN, (short)50, (byte)3, false);
		
		PeelableResponse response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.FAILURE);
		Assert.assertEquals(apple.getState(), State.UNPEELED);
		
	}	
	
	@Test
	public void testTastyAppleWithWorm() {
		
		Peelable apple = new Apple(Colour.GREEN, (short)50, (byte)4, true);
		
		PeelableResponse response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.FAILURE);
		Assert.assertEquals(apple.getState(), State.UNPEELED);

	}
	
	@Test
	public void testEatPeeledApple() {
		
		Peelable apple = new Apple(Colour.GREEN, (short)50, (byte)4, false);
		
		PeelableResponse response = apple.peel();
		Assert.assertEquals(response.getMessageCode(), MessageCode.SUCCESS);
		Assert.assertEquals(apple.getState(), State.PEELED);
		
		response = apple.eat();
		Assert.assertEquals(response.getMessageCode(), MessageCode.SUCCESS);
		Assert.assertEquals(apple.getState(), State.EATEN);
		
	}	

	
	@Test
	public void testBlueApple() {
		
		Peelable apple = new Apple(Colour.BLUE, (short)50, (byte)4, false);
		
		apple.peel();
		
		Assert.assertEquals(apple.getPeeler().getClass(), ValyrianPeeler.class);
		
	}	
	
	@Test
	public void testDefaultApple() {
		
		Peelable apple = new Apple(Colour.RED, (short)50, (byte)4, false);
		
		Assert.assertEquals(apple.getPeeler().getClass(), DefaultPeeler.class);
		
	}	

}
