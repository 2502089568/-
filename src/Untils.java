
public class Untils {
	
	public static void sysArr(int[] a2, String s) {
		// TODO Auto-generated method stub
				System.out.print(s);
				for(int count:a2) {
					System.out.print(count+" ");
				}
				System.out.println();
	}
	
	public static void sysArr(int[][] a2, String s) {
		// TODO Auto-generated method stub
				System.out.println(s+":");
				for(int[] is:a2) {
					for(int count:is) {
						System.out.print(count+" ");
					}
					System.out.println();
				}
				System.out.println();
	}
	
	public static void initArr(int[][] a) {
		for(int i=0;i<a[0].length;i++) {
			a[0][i]=0;
		}
		for(int i=0;i<a.length;i++) {
			a[i][0]=0;
		}
	}
}