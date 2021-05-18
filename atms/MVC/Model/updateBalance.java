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