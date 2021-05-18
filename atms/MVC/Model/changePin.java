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