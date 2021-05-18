package tester;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ATMTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//public static void main(String[] args)  {

   	        try{
            Scanner  scanner = new Scanner(new File("C:\\Users\\SAMIN\\Desktop\\ATM\\ATMbalance.txt"));

            while(scanner.hasNext()){
                String temp = scanner.nextLine();
                System.out.println(temp);
}
            
   	        }
   	        catch(Exception e) {
   	        	
   	        	
   	        }
}
	}


