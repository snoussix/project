package com.sdzee.pricing;


public class compute {
		  public native void computePrices();

		  static {
		    System.loadLibrary("mabibjni");
		  }
		    
		  public static void main(String[] args) {
		    new compute().computePrices();
		  }


}
