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