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