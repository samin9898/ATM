package ATM;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//import javafx.scene.control.PasswordField;
import java.io.File;

import java.util.*; 
import java.lang.*;

public class ATM {
    //private int pin;
    private boolean running;
    private Scanner input;
    private static Scanner x;
    private String balance;
    private double bal;
    private int choice;
    private String ATMB;
    private double atmBalance;
    private double cAtmB;
    private String username;
    private String gPin;
    private String preB;
    private double with=0;
    private int run=0;
    public ATM() {
        input=new Scanner(System.in);
        loadAtmb();
    }
    
    public static void main(String[] args)  {
        
        ATM bracuatm=new ATM();
        ATM bracuatmb=new ATM();
        try{
            System.out.println("Welcome to BracuBank ATM");
            System.out.println("Location - Mohakhali");
            //cAtmB=bracuatmb.loadATMB();
            bracuatm.runMachine();
            
        } catch(IOException e){
            System.out.println("\nAn error occurred!");
        }
    }
    
    public void runMachine() throws IOException{
        
        running=true;
        
        try{
            do{
                
                System.out.println("Go to:");
                System.out.println("__________________");
                System.out.println("|      1. User mode      |");
                System.out.println("__________________");
                System.out.println("__________________");
                System.out.println("|     2. Admin mode    |");
                System.out.println("__________________");
                System.out.println("Enter your mode: ");
                int mode=input.nextInt();
                
                if(mode==1){
                    userMode();
                }
                
                else if(mode==2){
                    adminMode();
                }
                else{
                    System.out.println("An error occurred!");
                }
                
            }while(running=true);
        }
        catch(Exception e){
            System.out.println("An error occurred!");
        }
    }
    
    private void userMode(){
        System.out.println("\n*****Welcome user******\nWhat can I do for you?");
        //int choice;
        do{
            try{
                System.out.println("__________________");
                System.out.println("|          1.Log in          |");
                System.out.println("__________________");
                System.out.println("__________________");
                System.out.println("|           2.Exit            |");
                System.out.println("__________________");
                System.out.println("Please enter your choice: ");
                choice=input.nextInt();
                
                if(choice==1){
                    login();
                }
                
                else if(choice==2){
                    System.out.println("Thanks for taking our service. Have a good day!");
                    System.out.println("******************************\n");
                    runMachine();
                }
                else{
                    System.out.println("Wrong input! Valid input are only 1 and 2. Please try again.");
                }
                if(choice!=2){
                    System.out.println("\nWhat to do next?");
                }
            }catch(IOException e){
                System.out.println("\nAn error occurred!");
            }
        }while(choice!=2);
    }
    
    private void login(){
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\members.txt";
        boolean found = false;
        String tempUsername="";
        String tempPassword="";
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Please enter your credit card number :\n");
            username=sc.nextLine();
            System.out.println("Please enter your pin :\n");
            String password=sc.nextLine();
            password=password.trim();
            try{
                x=new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");
//            System.out.println("Please enter you userID : ");
//            tempUsername=input.nextLine();
//            System.out.println("Please enter you Pin : ");
//            tempPassword=input.nextLine();
                
                while(x.hasNext()&&!found){
                    tempUsername=x.next();
                    tempPassword=x.next();
                    tempPassword=tempPassword.trim();
                    gPin=tempPassword;
                    balance=x.next();
                    balance=balance.trim();
                    preB=balance;
                    bal=Double.parseDouble(balance);
                    //preB=String.valueOf(bal);
                    //System.out.println(bal);
                    
                    if(tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim()))
                    {
                        System.out.println("*****Login Successful!*****");
                        found=true;
                        
                    }
                }
                x.close();
                if(found==true){
                    afterLogin();
                }
                if(found==false){
                    System.out.println();
                    System.out.println("!!!!!!!!!!!!!!!!! Username or Pin Wrong !!!!!!!!!!!!!!!!!");
                    System.out.println();
                    System.out.println("Re-enter credit card number and pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }while(found==false);
    }
    
    private void afterLogin(){
        try{
            int dis;
            System.out.println("What would you like to do?");
            System.out.println("__________________");
            System.out.println("|    1.Check balance    |");
            System.out.println("__________________");
            System.out.println("__________________");
            System.out.println("|  2.Withdraw money  |");
            System.out.println("__________________");
            System.out.println("__________________");
            System.out.println("|      3.Change pin      |");
            System.out.println("__________________");
            System.out.println("__________________");
            System.out.println("|    4.Print Receipt      |");
            System.out.println("__________________");
            System.out.println("__________________");
            System.out.println("|       5.Logout            |");
            System.out.println("__________________");
            int choice;
            
            choice=input.nextInt();
            
            if(choice>5||choice<1){
                System.out.println("Wrong input! Valid inputs are only 1,2,3,4 and 5. Please try again.\n");
                afterLogin();
            }
            else{
                if(choice==1){
                    System.out.println("Your balance is "+bal+" taka\n");
                    System.out.println();
                    afterLogin();
                }
                else if(choice==2){
                    do{
                        do{
                            System.out.println("How much would you like to withdraw?\n");
                            with=input.nextDouble();
                            if(with<100||with>bal){
                                if(with>bal){
                                    System.out.println("Sorry!Insufficient balance!\n");
                                }
                                else{
                                    System.out.println("You need to withdraw more than 100 Taka");
                                }
                                System.out.println();
                                System.out.println("Enter correct amount");
                                System.out.println();
                            }
                            else if(with>atmBalance){
                                System.out.println("Sorry,the ATM does not have that amount of money left.");
                                afterLogin();
                            }
                        }while(with<100||with>bal);
                        do{
                            System.out.println("Are you sure you want to withdraw "+with+" taka?");
                            System.out.println("1.Yes");
                            System.out.println("2.No");
                            dis=input.nextInt();
                            if(dis>2||dis<0){
                                System.out.println("Wrong input! Valid input are only 1 and 2. Please try again.");
                            }
                        }while(dis>2||dis<1);
                        if(dis==1){
                            System.out.println();
                            System.out.println("Here is "+with+" taka");
                            System.out.println();
                            System.out.println("Your current bank balance is :"+(bal-with)+" taka");
                            System.out.println();
                            bal-=with;
                            updateBalance(bal);
                            atmBalance-=with;
                            updateAtmBalance(atmBalance);
//                        String ipip=String.valueOf(atmBalance);
//                        System.out.println(ipip);
                            afterLogin();
                            
                        }
//                    else if(dis==2){
//                        System.out.println("Hope you come back again! :)");
//                        afterLogin();
//                    }
                    }while(dis==2);
                }else if(choice==3){
                    changePin();
                }else if(choice==4){
                    printReceipt(with);
                    afterLogin();
                }
                else if(choice==5){
                    System.out.println("*****Logout Successful!*****");
                    with=0;
                    userMode();
                }
            }
        }catch(Exception e){
            System.out.println("\nWrong input!");
        }
    }
    
    private void adminMode(){
        
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\admin.txt";
        boolean found = false;
        String tempUsername="";
        String tempPassword="";
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Please enter your username :");
            String username=sc.nextLine();
            System.out.println("Please enter your password :");
            String password=sc.nextLine();
            try{
                x=new Scanner(new File(filepath));
                x.useDelimiter("[,\n]");
                
                while(x.hasNext()&&!found){
                    tempUsername=x.next();
                    tempPassword=x.next();
                    
                    if(tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim()))
                    {
                        System.out.println("Login Successful!\n");
                        found=true;
                        
                    }
                }
                x.close();
                if(found==true){
                    afterAdminLogin();
                }
                if(found==false){
                    System.out.println();
                    System.out.println("!!!!!!!!!!!!!!!!! Username and/or Pin Wrong !!!!!!!!!!!!!!!!!");
                    System.out.println();
                    System.out.println("Re-enter credit card number and pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }while(found==false);
    }
    
    private void afterAdminLogin(){
        
        //int choice;
        try{
            do{
                System.out.println();
                System.out.println("CURRENT ATM BALANCE IS :"+atmBalance+" TAKA.");
                System.out.println();
                
                System.out.println("what do you want to do?");
                System.out.println("__________________");
                System.out.println("|       1.Refill ATM       |");
                System.out.println("__________________");
                System.out.println("__________________");
                System.out.println("|            2.Exit           |");
                System.out.println("__________________");
                choice=input.nextInt();
                if(choice==1){
                    double refill=1000000;
                    updateAtmBalance(refill);
                    System.out.println("ATM has been refilled\n");
                    afterAdminLogin();
                }
                else if(choice==2){
                    System.out.println("Thank you for you service\n");
                    runMachine();
                }
                else{
                    System.out.println("Wrong input! Valid inputs are only 1 and 2. Please try again.\n");
                }
            }while(choice!=1||choice!=2);
        }catch(Exception e){
            System.out.println("Wrong input!");
        }
    }
    
    private void changePin(){
        
        //System.out.println(gPin);
        
        with=0;
        String oldPin=gPin;
        Scanner sc=new Scanner(System.in);
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\members.txt";
        System.out.println("Please enter your new pin :");
        System.out.println("New pin must contain '-' between numbers");
        System.out.println("Example : 1-2-3-4");
        String newPin=sc.nextLine();
        int pinLength=newPin.length();
        if(pinLength!=7){
            System.out.println("Wrong Input!\nTry again");
            changePin();
        }else{
            for(int s=0;s<pinLength;s++){
                int count=0;
                if(s%2!=0){
                    if(newPin.charAt(s)!='-'){
                        System.out.println("You must enter '-' between numbers.\nPlease re-enter pin");
                        changePin();
                    }else if(s%2==0){
                        for(int t=0;t<pinLength;t++){
                            if(newPin.charAt(s)!=(char)t){
                                count++;
                            }
                        }if(count!=0){
                            System.out.println("You must enter numbers between '-'.\nPlease re-enter pin");
                            changePin();
                        }
                    }
                }
            }
        }
        File newFile=new File(filepath);
        String oldC="";
        BufferedReader r=null;
        FileWriter w=null;
        try{
            r=new BufferedReader(new FileReader(newFile));
            String line=r.readLine();
            while(line!=null){
                oldC=oldC+line+System.lineSeparator();
                line=r.readLine();
            }
            String newC=oldC.replaceAll(oldPin,newPin);
            w=new FileWriter(newFile);
            w.write(newC);
            System.out.println("Pin has been changed!\nPlease log in again...");
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                r.close();
                w.close();
                login();
            }catch(IOException e){
                System.out.println(e);
            }
        }
        
    }
    
    private void updateBalance(double nbal){
        
        //System.out.println(gPin);
        String oldB=preB;
        //Scanner sc=new Scanner(System.in);
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\members.txt";
        String newB=String.valueOf(nbal);
//        System.out.println(oldB);
//        System.out.println(newB);
        
        File newFile=new File(filepath);
        String oldC="";
        BufferedReader r=null;
        FileWriter w=null;
        
        try{
//            System.out.println(oldB);
//            System.out.println(newB);
            r=new BufferedReader(new FileReader(newFile));
            String line=r.readLine();
            while(line!=null){
                oldC=oldC+line+System.lineSeparator();
                line=r.readLine();
            }
            String newC=oldC.replaceAll(oldB,newB);
            w=new FileWriter(newFile);
            w.write(newC);
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                r.close();
                w.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
    private void printReceipt(double withdraw){
        
        
        
        
        System.out.println("*************************************************************");
        System.out.println("                                        BRACU ATM RECEIPT                                           ");
        System.out.println("*************************************************************");
        
        System.out.println();
        
//        System.out.println("Date:         " + );
//        System.out.println("Time:         " + );
        
        
        System.out.println("                            Card Number:                  " +username);
        System.out.println();
        System.out.println("                            Previous Amount:             "+ preB);
        System.out.println();
        System.out.println("                            Withdrawal Amount:          "+withdraw );
        System.out.println();
        System.out.println("                            New Amount:                   "+(Double.valueOf(preB)-withdraw));
        System.out.println();
        
        System.out.println("*************************************************************");
    }
    
    private void loadAtmb(){
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\ATMbalance.txt";
        try{
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            
            while(x.hasNext()){
                atmBalance=Double.valueOf(x.next().trim());
                cAtmB=atmBalance;
//                System.out.println(atmBalance+" "+cAtmB);
            }
        }catch(IOException e){
            System.out.println(e);
        }            
    }
    
    private void updateAtmBalance(double newB){
        String filepath="C:\\Users\\SAMIN\\Desktop\\ATM\\ATMbalance.txt";
        if(newB==1000000){
            atmBalance=1000000;
        }
        String oldBalance=String.valueOf(cAtmB);
        BufferedReader read=null;
        FileWriter write=null;
        String notunBalance=String.valueOf(newB);
        
        try{
            read=new BufferedReader(new FileReader(filepath));
            String line=read.readLine();
            while(line!=null){
                oldBalance=oldBalance+line+System.lineSeparator();
                line=read.readLine();
            }
            String newBalance = oldBalance.replaceAll(oldBalance,notunBalance);
            write=new FileWriter(filepath);
            write.write(newBalance);
        }catch(IOException e){
            System.out.println(e);
        }
        finally{
            try{
                read.close();
                write.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }  
}