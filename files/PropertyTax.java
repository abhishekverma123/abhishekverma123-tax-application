package com.example.tax;

public class PropertyTax implements Tax {
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
	public double taxableAmount;
	public double taxAmount;
	public boolean isTaxPayed;
	
	PropertyTax(){
		this.isTaxPayed = false;
	}
	
	// This method sets the taxable amount (i.e. the income for income tax or the property value for property tax)
    public void setTaxableAmount(int amount) {
    	this.taxableAmount = amount;
    	
    }
    
  public void calculateTaxAmount() {
	  
	         
        // taxAmount =0;
         if(!this.isTaxPayed) {
        	 
             this.taxAmount = this.taxableAmount * 0.05;
         }
     }
  
public double getTaxAmount() {
	  
	  return this.taxAmount;
	  
  }
//This method returns the taxType i.e. "income" or "property".
  public String getTaxType() {
	     return "property";
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
		  System.out.println("Hi, your property tax  is paid.");
		  isTaxPayed = true; 
	       }
	       else {
	    	   System.out.println("Thanks !, your property tax  is already  paid.");
	       }
	  }
	
	
}
