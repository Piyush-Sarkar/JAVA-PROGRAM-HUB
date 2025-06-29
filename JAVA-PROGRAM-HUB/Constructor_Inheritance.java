import java.util.*;
class library//start of class
{
    String name,author; double p;//data members
    public library(String n,String a,double np)//start of method
    {
        name=n;
        author=a;
        p=np;
    }//end of method
    public void show()//display method
    {//inputs given
        System.out.println("Name of book: "+name);
        System.out.println("Name of author: "+author);
        System.out.println("Price of book: "+p);
    }//end of method
}//end of class

class compute extends library//start of class
{
    int d; double r;
    public compute(String na, String au, double pr,int da)
    {//inheriting method
        super(na,au,pr);
        d=da;
    }
    public void fine()//method for calculating fine
    {
        d=d-7;//excluding 7 days
        if(d>=1&&d<=5)
            r=d*2.00;
        else if(d>5 && d<=10)
        {
            r=5*2.00;
            r=r+(d-5)*3.00;
        }
        else if(d>10)
        {
            r=5*2.00;
            r=r+5*3.00;
            r=r+(d-10)*5.00;
        }
    }
    public void display()//display method
    {
        super.show();
        System.out.println("Fine is: "+r);
        System.out.println("Total amount to be paid: "+((0.02*p*(d+7))+r)); 
    }
}//end of class

class Constructor_Inheritance//start of main class
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of book: ");
        String book=sc.nextLine();
        System.out.print("Enter name of author: ");
        String author=sc.nextLine();
        System.out.print("Enter price of book: ");
        double prbook=sc.nextDouble();
        System.out.print("Enter number of days: ");
        int nod=sc.nextInt();
        System.out.println("********************");
        compute ob=new compute(book,author,prbook,nod);
        ob.fine();
        ob.display();
        sc.close();
    }//end of method
}//end of class
