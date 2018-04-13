
public class Queen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;//Ҫ�ŵĻʺ��������ж����о��ж��ٸ��ʺ�
		int[][] a=new int[n][n];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=0;
			}
		}
		//Queue(0,a);
		Queue(n);//���������ʾΪ�ʺ����
		
	}
///////////////////////////////////////////////////
	 //����1������Ѱ��λ��
	  private static void Queue(int j, int[][] a) {
		if(j==a.length) {//�ݹ��������
			for(int i=0; i<a.length; i++) {
				 //�õ�һ���⣬����Ļ����ʾ
				for(int k=0;k<a.length;k++) {
					System.out.print(a[i][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return ;
		}
		for(int i=0;i<a.length;i++) {//����Ѱ��
			if(isCorrect(i, j, a)==1) {//�����еĻ��������ߵ���һ��
				a[i][j]=1;//���ûʺ�
	            Queue(j+1,a);//�ݹ��������������ռ���������ӻʺ�
	            a[i][j]=0;//���������ʵ�ֻ��ݵ���һ�㣨ĳ�в��еĻ�����ӵĻʺ�ȥ����
			}
		}
		
	}

	private static int isCorrect(int i, int j, int[][] a) {
	    int s, t;
	    for(s=i,t=0; t<a.length; t++)
	        if(a[s][t]==1 && t!=j)
	            return 0;//�ж���
	    for(t=j,s=0; s<a.length; s++)
	        if(a[s][t]==1 && s!=i)
	            return 0;//�ж���
	    for(s=i-1,t=j-1; s>=0&&t>=0; s--,t--)
	        if(a[s][t]==1)
	            return 0;//�ж����Ϸ�
	    for(s=i+1,t=j+1; s<a.length&&t<a.length;s++,t++)
	        if(a[s][t]==1)
	            return 0;//�ж����·�
	    for(s=i-1,t=j+1; s>=0&&t<a.length; s--,t++)
	        if(a[s][t]==1)
	            return 0;//�ж����Ϸ�
	    for(s=i+1,t=j-1; s<a.length&&t>=0; s++,t--)
	        if(a[s][t]==1)
	            return 0;//�ж����·�

	    return 1;//���򷵻�
	}
////////////////////////////////	
	//��2������Ѱ��λ��
	private static void Queue(int n) {
		int[] a=new int[n+1];//a[k]�����k�еĻʺ�ŵ�����
		Untils.initArr(a);
		int k=1;
		while(k>=1) {
			a[k]=a[k]+1;//�ӵ�1�п�ʼ
			while(a[k]<=n&&!isCorrect(a,k)) {
				a[k]=a[k]+1;//�������Ѱ�ҿɷŵ�����
			}
			if(a[k]<=n&&k==n) {//�����һ���ˣ��ó����
				System.out.println("�õ����:");
				for(int i=1;i<=n;i++) {
					System.out.print("("+i+","+a[i]+")"+" ");
				}return ;
			}else if(a[k]<=n&&k<n){
				k=k+1;//����һ�еĻʺ�
			}else {
				a[k]=0;
				k=k-1;//����ȥ��ʱ���������飨a[k]�������ϴε�һ��λ�ö�71���м�1��λ�ô���һ���������
			}
		}
	}

	private static boolean isCorrect(int[] a,int k) {
		for(int i=1;i<k;i++) {//iΪ����
			// ����ͬһ�л���ͬһб��  Math.abs�����ֵ
			if(i!=k&&a[i]==a[k]) {
				return false;
			}
			if(Math.abs(i-k)==Math.abs(a[i]-a[k])) {
				return false;
			}
		}
		return true;
	}

}
