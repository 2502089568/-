import java.util.ArrayList;
import java.util.Collections;

/*�����������
��1�����a1[i]=a2[j], a(x,y)=a(x �C 1,  y �C 1) + 1
��2.1�� ���a1[i] �� a2[j]��a(x �C 1, y) ��a(x, y �C 1)
	       ���Ӧa(x,y)= a(x �C 1, y)
��2.2�����a1[i] �� a2[j]��a(x �C 1, y) <a(x, y �C 1)
               ���Ӧa(x,y) = a(x, y �C 1)
   ��ӱ��1�������Ϸ���ͷ��2�ϣ�3�ң�����ͷ����     
               */

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1=getArray("13456778");
		int[] a2=getArray("357486782");
		Untils.sysArr(a1,"a1:");
		Untils.sysArr(a2,"a2:");
		int[][] a=new int[a1.length+1][a2.length+1];
		int[][] l=new int[a1.length+1][a2.length+1];
		Untils.initArr(a);	
		getLCSArray(a,l,a1,a2);
		Untils.sysArr(a,"a");
		Untils.sysArr(l,"����ͼ");
		getLCS(l,a1);
	}
	
	public static int[] getArray(String s) {
		int[] a=new int[s.length()];
		for(int i=0;i<s.length();i++) {
			a[i]=s.charAt(i)-48;
		}
		return a;
	}
	public static void getLCSArray(int[][] a,int[][] l,int[] a1,int[] a2) {
		for(int i=1;i<a.length;i++) {
			for(int j=1;j<a[i].length;j++) {
				if(a1[i-1]==a2[j-1]) {
					a[i][j]=a[i-1][j-1]+1;
					l[i][j]=1;//��ʾָ�����Ϸ��ļ�ͷ
				}else {
					if(a[i-1][j]>a[i][j-1]) {
						a[i][j]=a[i-1][j];
						l[i][j]=2;//��ͷָ���Ϸ�
					}else {
						a[i][j]=a[i][j-1];
						l[i][j]=3;//��ͷָ����
					}
				}
			}
		}
	}
	public static void getLCS(int[][] l,int[] a1) {
		ArrayList s=new ArrayList();
		System.out.println("�����������:");
		int i=l.length-1;
		while(i>0) {
			for(int j=l[i].length-1;j>0;) {
				if(l[i][j]==1) {
					//System.out.print(a1[i-1]);
					s.add(a1[i-1]);
					i--;
					j--;
				}else if(l[i][j]==2){
					i--;
				}else {
					j--;
				}
			}
			break;
		}
		Collections.reverse(s);  
		for(Object i1:s) {
			System.out.print(i1+" ");
		}
		System.out.println();
	}
}
