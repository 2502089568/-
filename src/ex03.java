/*ţţ����˯��ͷ�����������˺ܶ����ӣ�ֻ�����������ʱ�����Ż��ѹ������Ҿ������𴲡���������������ҪX���ӵ�����ң��Ͽ�ʱ��Ϊ�����AʱB�֣��������������ʲôʱ���� 
��������:
ÿ���������һ������������
ÿ�����������ĵ�һ�а���һ������������ʾ���ӵ�����N(N<=100)��
��������N��ÿ�а���������������ʾ������������ʱ��ΪHi(0<=A<24)ʱMi(0<=B<60)�֡�
��������һ�а���һ����������ʾ������������ҪX(0<=X<=100)���ӵ�����ҡ�
��������һ�а���������������ʾ�Ͽ�ʱ��ΪA(0<=A<24)ʱB(0<=B<60)�֡�
���ݱ�֤������һ�����ӿ�����ţţ��ʱ������ҡ�

�������:
�������������ʾţţ������ʱ�䡣

��������1:
3 
5 0 
6 0 
7 0 
59 
6 59

�������1:
6 0
 * 
 * */

import java.util.*;
public class ex03{
    public static void main(String[] args){
    	int daoM;
    	int daoH;
    	int zwH;
    	int zwM;
    	int zdH=0;
    	int zdM=0;
        Scanner scan=new Scanner(System.in);
        int count = scan.nextInt();
        int h[]=new int[count+1];
        int m[]=new int[count+1];
        for(int i=0;i<count;i++) {
        	h[i]=Integer.valueOf(scan.next()).intValue();
        	m[i]=Integer.valueOf(scan.next()).intValue();
        }
        int daoT = scan.nextInt();
        h[count]=Integer.valueOf(scan.next()).intValue();
        m[count]=Integer.valueOf(scan.next()).intValue();
        if(daoT>=60) {
        	daoH=daoT/60;
        	daoM=daoT%60;
        }
        else { daoM=daoT;daoH=0;}
        if(m[count]<daoM) {
        	zwM=60-(daoM-m[count]);
        	zwH=h[count]-1-daoH;
        }else {
        	zwM=m[count]-daoM;
        	zwH=h[count]-daoH;
        }    
        for(int j=0;j<count;j++) {
        	if(h[j]<zwH||(zwH==h[j]&&zwM>=m[j])) {
        			if(zdH<h[j]||(zdH==h[j]&&zdM<=m[j])) {
        				zdH=h[j];
        				zdM=m[j];
        			}
        		}
        	}
        System.out.println(zdH+" "+zdM);
    }
}
