import java .util.Scanner;
class Folder {
Scanner input =new Scanner (System.in);
private double size ;
private String name ;
private String [] fils ;
public static int numFolder=0 ;
public Folder (String Fname , int numFils){
fils=new String[numFils]; 
name =Fname ;
numFolder++;
size=0;
}
public void readFils (){
for (int i =0 ;i<fils.length ;i++){
System.out.println("pleas enter the informaiton for fails ");
fils[i]=input.next();
System.out.println("pleas enter the size ");
size=size+input.nextInt();
}
}
public int countFiletype (String ex ){
int count =0;

for (int i =0 ;i<fils.length ;i++){
int loc=fils[i].indexOf('.');
if(loc!=-1&&fils[i].substring(loc+1).equals(ex))
count++;
}
return count ;
}
public String getName(){
return name ;
}
public void display (){
System.out.println("Name "+name );
System.out.println("size "+size+"MB" );
for (int i =0 ;i<fils.length ;i++)
System.out.println(fils[i]);
}
}

