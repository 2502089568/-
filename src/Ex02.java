import java.util.*;
public class Ex02{
	public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String n=scan.next();
        int count=0;
        Set<Character> linkedHashSet = new LinkedHashSet<Character>();//set不允许有重复数据
        linkedHashSet.add(n.charAt(0));
        char a=n.charAt(0);
        for(int i=1;i<n.length();i++){
             if( a!=n.charAt(i)) {
            	 linkedHashSet.add(n.charAt(i));
             }
        }
        if(linkedHashSet.size()==1) {
        	System.out.println(1);
        }
        else if(linkedHashSet.size()==2) {
        	System.out.println(2);
        }
        else System.out.println(0);
    }
}