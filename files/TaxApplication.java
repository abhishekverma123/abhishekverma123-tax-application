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
                	         System.out.println("Exiting...");
                	         
                	            sc.close();
                	            context.close();
                	            return;
                	            
                            }
                default ->{
                	   System.out.println("Invalid Choice");
                	  continue;
                }
                   
                
                }
               
                Tax tax = (Tax)context.getBean(taxChoice); 
//                System.out.println(tax.isTaxPayed());
//                tax.setTaxableAmount(500000);
//                
//                tax.calculateTaxAmount();
//                System.out.println(tax.getTaxAmount());
//                System.out.println(tax.getTaxType());
//                tax.payTax();
//                
                
                //System.out.println(tax.isTaxPayed());
               // tax.payTax();
                   if(!tax.isTaxPayed()) {
                System.out.println("Please enter your "+tax.getTaxType()+" value:");
                 int amount = sc.nextInt();
                 tax.setTaxableAmount(amount);
                 tax.calculateTaxAmount();
                 System.out.println("You have slected "+tax.getTaxType()+" tax and your tax amount is: "+tax.getTaxAmount());
                 System.out.println("Do you want to pay the tax:\n1. Yes\n2. Exit");
                 int choice = sc.nextInt();
//                 switch(choice) {
//                 case 1 ->   tax.payTax();
//                 
//                 case 2 ->  { 
//                	          System.out.println("Pay the tax !");
//                               continue;
//                 }
                 
                 if(choice == 1) {
                	 tax.payTax();
                 
                 }
                 else {
                	 System.out.println("Payment Skipped");
                 }
                   }
                   else {
                	   tax.payTax(); 
                   }
               
                 
                 
                
                
            }
            
            
	}

}
