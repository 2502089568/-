/*��̬�滮
��N����Ʒ��һ������ΪW�ı�������i����Ʒ��������w[i]����ֵ��v[i]��
��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�������ܺͲ����������������Ҽ�ֵ�ܺ����*/

public class ex006 {
	public static void main(String[] args){
		int w=11;//�����Ʒ 
		int n=5;//����װ������������ܳ�����ֵ��ʹ���ܼ�ֵ���  
		int[] value={1,6,18,22,28};//��Ӧ��Ʒ�ļ�ֵ  
	    int[] weight={1,2,5,6,7};//��Ӧÿ��Ʒ������  
	    System.out.println("���ý����"+findMaxValue(w,n,weight,value));  	
	}
	
	/*//��ά,���ҵ����Ž�Ľ����
	 * public static int  findMaxValue(int w,int n,int[] weight, int[] value) {
		int[][]max=new int[n+1][w+1];//��Ϊװ����Ʒ����������Ϊ��Ʒ���
		String[][] l=new String[n+1][w+1];//������ô����Ʒ��
		for(int i=0;i<=w;i++) {//��װ��Ʒ����ֵ��Ϊ0
			max[0][i]=0;
			l[0][i]="0";
		}
		for(int e=0;e<=n;e++) {
			l[e][0]="0";
		}
		for(int j=1;j<=n;j++) {//��1���ǣ���weight�Ǵ�0��ʼ��Ҫ��ӦҪ��1
			for(int k=1;k<=w;k++) {
				if(weight[j-1]>k) {
					l[j][k]=l[j-1][k];
					max[j][k]=max[j-1][k];//�������һ����Ʒ��������k�������Ʒһ������ѡ
				}else {
					int a=max[j-1][k];//��ѡ��j����Ʒ  
					int b=value[j-1]+max[j-1][k-weight[j-1]];//����ѡ��j����Ʒ����ֵ���ڸü�ֵ����һ����żӻ���������������Ĳ�Ʒ�ļ�ֵ
					max[j][k]=a>b?a:b;
					if(a<b) {
						if(l[j-1][k-weight[j-1]].equals("0")) l[j][k]=""+j;//ȥ��0
						else l[j][k]=l[j-1][k-weight[j-1]]+j;
						}
					else l[j][k]=l[j-1][k];
				}
				
			}
		}
		
		//��ʾ
		System.out.println("ȡ���ʱ�±꣺"+n+" "+w); 
		for (int[] is : max) {  
            for (int i : is) {  
                System.out.print(i+"\t");  
            }  
            System.out.println();  
        }  
		
		System.out.println("���䣺"); 
		for (int i=0;i<=n;i++) {
			for(int j=0;j<=w;j++) {
				 System.out.printf("%-8s",l[i][j]);  
			}
			 System.out.println();
		} 
		
        return max[n][w];  
	}*/
	
	//1ά,��Ȼ�Ż��˶�̬�滮�Ŀռ�(��άÿ�δ����Ǵ����������У��ɺϲ���һά)
	public static int  findMaxValue(int w,int n,int[] weight, int[] value) {
		int[]max=new int[w+1];
		String[] l=new String[w+1];
		for(int i=0;i<l.length;i++) {
			l[i]="0";
		}
		max[0]=0;
		for(int i=1;i<=n;i++) {
			System.out.println("--------------------------");
			for(int j=w;j>0;j--) {
				if(j-weight[i-1]>=0&&max[j]<=max[j-weight[i-1]]+value[i-1]) {
					max[j]=max[j-weight[i-1]]+value[i-1];
					//���
					if(l[j-weight[i-1]]=="0") {
						l[j]=""+i;
					}else l[j]=l[j-weight[i-1]]+i;
					for(int k:max) {
						System.out.print(k+" ");
					}
					System.out.println();
				}
			}
		}
		for(int i:max) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("��ɣ�");
		for(String q:l) {
			System.out.print(q+" ");
		}
		System.out.println();
		return max[w];
	}
}
