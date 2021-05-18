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