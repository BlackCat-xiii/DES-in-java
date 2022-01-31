package swe314des;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" ---------- I N P U T S -------------------");
        System.out.println("Please give the key: ");
        String key = sc.nextLine();
        System.out.println("Please give the message: ");
        String message = sc.nextLine();
        
        //..
        fun Tst = new fun();
        //..
        
        
        // ...
        
        String k1="",k2="",k3="",k4="",k5="",k6="",k7="",k8="",k9="",k10="",k11="",k12="",k13="",k14="",k15="",k16="";
        
        String Nkey = Tst.PC1(key);//56
        
        String Lpart="";
		 String Rpart="";
		 
		 for (int i =0 ; i<28 ; i++) {
			 
			 Lpart+=Nkey.charAt(i);
		 }
		 for (int i =28 ; i<56 ; i++) {
			 
			 Rpart+=Nkey.charAt(i);
		 }
		 
        
        
        for (int main=0; main<16 ; main++) {
		
		 /*if (main!=0) {
			 
		 for (int i =0 ; i<28 ; i++) {
			 
			 Lpart+=Lpart.charAt(i);
		 }
		 for (int i =28 ; i<56 ; i++) {
			 
			 Rpart+=Rpart.charAt(i);
		 }}*/
		 
		 
		 Lpart=Tst.Left_shift(Lpart, main);
		 Rpart=Tst.Left_shift(Rpart, main);
		 
		 IO.write("c.txt", Lpart + "\n");
		 IO.write("d.txt", Rpart + "\n");
		 switch (main){
		 case 0:
				k1=Tst.PC2(Lpart+Rpart);
				break;
			case 1:
				k2=Tst.PC2(Lpart+Rpart);
				break;
			case 2:
				k3=Tst.PC2(Lpart+Rpart);
				break;
			case 3:
				k4=Tst.PC2(Lpart+Rpart);
				break;
			case 4:
				k5=Tst.PC2(Lpart+Rpart);
				break;
			case 5:
				k6=Tst.PC2(Lpart+Rpart);
				break;
			case 6:
				k7=Tst.PC2(Lpart+Rpart);
				break;
			case 7:
				k8=Tst.PC2(Lpart+Rpart);
				break;
			case 8:
				k9=Tst.PC2(Lpart+Rpart);
					break;
			case 9:
				k10=Tst.PC2(Lpart+Rpart);
					break;
			case 10:
				k11=Tst.PC2(Lpart+Rpart);
					break;
			case 11:
				k12=Tst.PC2(Lpart+Rpart);
					break;
			case 12:
				k13=Tst.PC2(Lpart+Rpart);
					break;
			case 13:
				k14=Tst.PC2(Lpart+Rpart);
					break;
			case 14:
				k15=Tst.PC2(Lpart+Rpart);
					break;
			case 15:
				k16=Tst.PC2(Lpart+Rpart);
					break;
			
		 }
		 
        }
        
   	 String Nmas = Tst.IP(message);
   	IO.write("ip.txt", Nmas + "\n");
   	 String LpartM="";
   	 String RpartM="";
    for (int i =0 ; i<32; i++) {
		 
		 LpartM+=Nmas.charAt(i);
	 }
	 for (int i =32 ; i<64 ; i++) {
		 
		 RpartM+=Nmas.charAt(i);
	 }
	 for (int main=0 ; main<16 ; main++) {
		 
		 
		 
		 String timp = "";
		 switch (main){
		 case 0:
				timp =k1;
				break;
			case 1:
				timp =k2;
				break;
			case 2:
				timp =k3;
				break;
			case 3:
				timp =k4;
				break;
			case 4:
				timp =k5;
				break;
			case 5:
				timp =k6;
				break;
			case 6:
				timp =k7;
				break;
			case 7:
				timp = k8;
				break;
			case 8:
				timp =k9;
					break;
			case 9:
				timp =k10;
					break;
			case 10:
				timp =k11;
					break;
			case 11:
				timp =k12;
					break;
			case 12:
				timp =k13;
					break;
			case 13:
				timp =k14;
					break;
			case 14:
				timp =k15;
					break;
			case 15:
				timp =k16;
					break;
		 }
		 
		 IO.write("keys.txt", timp + "\n");
		 IO.write("l.txt", LpartM + "\n");
		 IO.write("r.txt", RpartM + "\n");
		 String TimpM = LpartM;
		 LpartM=RpartM;
		 
		 RpartM=Tst.xor(TimpM, Tst.F(RpartM, timp));
		 IO.write("fxored.txt", RpartM + "\n");
		
	 }
	 
        
        
        
        
        String ciphertext = Tst.finalP(RpartM+LpartM);
        IO.write("fp.txt", ciphertext + "\n");
        
        
        
        
        // ...

        //output
        System.out.println("\n\n\n---------- R E S U L T S -------------------");
        System.out.println("Key = " + key);
        System.out.println("message = " + message);
        System.out.println("ciphertext = " + ciphertext/*" --- put here the ciphertext"*/);


	IO.write("kp1.txt", Nkey + "\n");
	
    
        
        
        
        
        
        
        
        

    }
}

