import java.util.Scanner;

public class ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wayLength;
		String way;
		Scanner scan = new Scanner(System.in);
		int all=scan.nextInt();
		int[] a = new int[all];
		for(int i=0;i<all;i++) {
			wayLength=scan.nextInt();
			way = scan.next();
			a[i]=getMinLight(way,wayLength);
		}
		
//		for(int j:a) {
//			System.out.println(a[j]);
//		}
		
		for(int j=0;j<a.length;j++) {
	    	System.out.println(a[j]);
		}
	}

	public static int getMinLight(String way,int wayLength) {
		int count=0;
		for(int i=0;i<wayLength;i++) {
			if(way.charAt(i)=='.') {
				count++;
				i=i+2;
			}
		}
		return count;
	}
}
