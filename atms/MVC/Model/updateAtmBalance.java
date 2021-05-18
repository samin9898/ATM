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