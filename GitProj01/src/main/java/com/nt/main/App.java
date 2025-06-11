package com.nt.main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        calculateSum(10, 20);
        
    }
    
    public static void calculateSum(int a, int b) {
    	
    	int sum = a+b;
    	System.out.println("Calculating a:"+a+", b:"+b+" = "+sum);
    }
}
