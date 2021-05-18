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