package services;

import java.util.Scanner;


public class CredentialService extends Employee{
	
	public CredentialService(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	private String password;
	private String department;
	private int defaultPasswordLength=8;
	private String companySuffix="abc.com";
	private String email;
			
		private String setDepartment() {
			System.out.print( "\nChoose a department:\n1 for Technical\n2 for Admin\n3 for HumanResources\n4 for Legal\n0 for none\nEnter the department code: ");
			Scanner in=new Scanner(System.in);
			int depchoice=in.nextInt();
			if(depchoice==1) {
				return "Technical";
			}
			else if(depchoice==2) {
				return "Admin";
			}
			else if(depchoice==3) {
				return "Human Resources";
			}
			else if(depchoice==4) {
				return "Legal";
			}
			else {
				return "";
			}
		}
		//generate a random password
		public String randomPassword(int length) {
				String passwordSet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrwxyz0123456789!@#$%";
				char[] password=new char[length];
				for(int i=0;i<length;i++) {
					int rand=(int) (Math.random()*passwordSet.length());
					password[i]=passwordSet.charAt(rand);
				}
				return new String(password);
			}
			
		
		
		void generateEmailAddress(String firstName, String lastName)
		{
			
			email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@" +department+"."+companySuffix;
			
		}
		
		void  showCredentials()
		{
			this.department=setDepartment();
			generateEmailAddress(getFirstName(),getLastName());
			System.out.println("Dear"+getFirstName()+" your generated credentials are as follows :");
			System.out.println("Your Email is: "+ email);
			this.password=randomPassword(defaultPasswordLength);
			System.out.println("Your password is: "+this.password+"\n\n");
		}
	}



