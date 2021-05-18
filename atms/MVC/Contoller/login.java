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