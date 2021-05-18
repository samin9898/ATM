package ATM;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javafx.scene.control.PasswordField;
import java.io.File;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
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