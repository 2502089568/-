
import java.util.*;
public class Ex01{
	
	public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        String b=String.valueOf(n);
        StringBuilder a=new StringBuilder(b).reverse();
        String c=a.toString();
          int i = Integer.valueOf(c).intValue();
          int j = Integer.valueOf(b).intValue();
        System.out.println(i+j);
    }
	
}
