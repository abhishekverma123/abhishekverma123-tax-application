package com.example.tax;

public class IncomeTax implements Tax {
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
	          
	double taxableAmount;
	double taxAmount;
	boolean isTaxPayed;
	
	
	IncomeTax(){
		this.isTaxPayed = false;
	}
	// This method sets the taxable amount (i.e. the income for income tax or the property value for property tax)
    public void setTaxableAmount(int amount) {
    	this.taxableAmount = amount;
    	
    }
    /* This method calculates the tax amount according to the taxable amount and saves it in the taxAmount variable.
    1. For the income tax, the tax amount is calculated using tax slabs given in the problem statement.
    2. For the property tax, the tax amount is 5% of the current property value.
     */
  public void calculateTaxAmount() {
	  
	         
        // taxAmount =0;
         if(!this.isTaxPayed) {
      if(this.taxableAmount <= 300000) {
   	   taxAmount = 0 ;
      }
      else if(this.taxableAmount >300000 && this.taxableAmount <= 600000) {
   	   taxAmount = taxableAmount  * 0.05;   
      }
      else if(this.taxableAmount > 600000 && this.taxableAmount <= 900000) {
   	   taxAmount = taxableAmount * 0.1;
      }
      else if(this.taxableAmount > 900000 && this.taxableAmount <= 1200000) {
   	   taxAmount = taxableAmount * 0.15;
      }
      else if(this.taxableAmount >1200000 && this.taxableAmount <=1500000) {
   	   taxAmount = this.taxableAmount * 0.2;
      }
      else {
   	   taxAmount = this.taxableAmount * 0.3;
   	   
      }  
         }   

    }
  
  // This method returns the tax amount.
  public double getTaxAmount() {
	  
	  return this.taxAmount;
	  
  }
//This method returns the taxType i.e. "income" or "property".
  public String getTaxType() {
	     return "income";
  }
  // This method returns the isTaxPayed boolean. Helpful when you load the bean from the
  // context to check if the tax is already paid.
  public boolean isTaxPayed() {
	     return this.isTaxPayed;
  }
  // This method prints the tax payment confirmation statement and sets the isTaxPayed boolean TRUE.
  /*
      E.g. Hi, your property/income tax is paid.
   */
  public void payTax() {
	 
  if(!this.isTaxPayed) {
	  System.out.println("Hi, your " +this.getTaxType()+ " tax  is paid.");
	  isTaxPayed = true; 
       }
       else {
    	   System.out.println("Thanks !, your " +this.getTaxType()+ " tax  is already  paid.");
       }
	  
	  
  }
}
  
  

