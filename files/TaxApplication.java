package com.example.tax;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		   //Tax incomeTax = (Tax)context.getBean("incomeTax");
		  // Tax propertyTax = (Tax)context.getBean("propertyTax");
		   Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the tax Payment Appliction");
            while(true) {
            System.out.println("Please Select which tax you want to pay: \n1. Income\n2. Property\n3. Exit");
                int userChoice = sc.nextInt();
                String taxChoice = "";
                switch(userChoice) {
                case 1 ->  taxChoice = "incomeTax";
                case 2 -> taxChoice = "propertyTax";
                case 3 ->  {
                	         taxChoice = "Existing...";
                	         
                	            sc.close();
                	            context.close();
                	            return;
                	            
                            }
                case 4 ->{
                	   System.out.println("Invalid Choice");
                	  continue;
                }
                   
                
                }
               
                Tax tax = (Tax)context.getBean(taxChoice); 
                System.out.println(tax.isTaxPayed());
                tax.setTaxableAmount(500000);
                
                tax.calculateTaxAmount();
                System.out.println(tax.getTaxAmount());
                System.out.println(tax.getTaxType());
                tax.payTax();
                
                
                //System.out.println(tax.isTaxPayed());
                
                
            }
            
            
	}

}
