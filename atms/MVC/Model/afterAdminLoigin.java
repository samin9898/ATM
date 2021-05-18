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