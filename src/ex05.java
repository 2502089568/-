import java.util.Scanner;

public class ex05 {

	static int count=0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int w = scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			 a[i]=scan.nextInt();
		}
		int count=0;
		count = dfs(a,-1,0,w);
		System.out.println(count);
/*		for(int j=0;j<a.length;j++) {
	    	System.out.println(a[j]);
		}*/
	}
	
	public static int  dfs(int[] a,int t,int sum,int w) {
		count++;
		if(t==a.length-1) {
			return count;
		}
		for(int i=t+1;i<a.length;i++) {
			if(sum+a[i]<=w) {
				//System.out.println(sum);
				dfs(a,i,sum+a[i],w);
			}
		}
		return count;
	}
	
}
