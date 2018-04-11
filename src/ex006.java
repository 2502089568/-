/*动态规划
有N件物品和一个容量为W的背包。第i件物品的重量是w[i]，价值是v[i]。
求解将哪些物品装入背包可使这些物品的重量总和不超过背包容量，且价值总和最大。*/

public class ex006 {
	public static void main(String[] args){
		int w=11;//五个物品 
		int n=5;//背包装入的总重量不能超过该值，使得总价值最大  
		int[] value={1,6,18,22,28};//对应物品的价值  
	    int[] weight={1,2,5,6,7};//对应每个品的重量  
	    System.out.println("所得结果："+findMaxValue(w,n,weight,value));  	
	}
	
	/*//二维,能找到最优解的解组成
	 * public static int  findMaxValue(int w,int n,int[] weight, int[] value) {
		int[][]max=new int[n+1][w+1];//行为装入物品的质量，列为物品序号
		String[][] l=new String[n+1][w+1];//用来怎么放物品的
		for(int i=0;i<=w;i++) {//不装物品，价值都为0
			max[0][i]=0;
			l[0][i]="0";
		}
		for(int e=0;e<=n;e++) {
			l[e][0]="0";
		}
		for(int j=1;j<=n;j++) {//从1开是，而weight是从0开始，要对应要减1
			for(int k=1;k<=w;k++) {
				if(weight[j-1]>k) {
					l[j][k]=l[j-1][k];
					max[j][k]=max[j-1][k];//当加入的一个物品重量大于k，这个物品一定不能选
				}else {
					int a=max[j-1][k];//不选第j个物品  
					int b=value[j-1]+max[j-1][k-weight[j-1]];//可以选第j个物品，价值等于该价值加上一个序号加还可容纳这个重量的产品的价值
					max[j][k]=a>b?a:b;
					if(a<b) {
						if(l[j-1][k-weight[j-1]].equals("0")) l[j][k]=""+j;//去掉0
						else l[j][k]=l[j-1][k-weight[j-1]]+j;
						}
					else l[j][k]=l[j-1][k];
				}
				
			}
		}
		
		//显示
		System.out.println("取最大时下标："+n+" "+w); 
		for (int[] is : max) {  
            for (int i : is) {  
                System.out.print(i+"\t");  
            }  
            System.out.println();  
        }  
		
		System.out.println("分配："); 
		for (int i=0;i<=n;i++) {
			for(int j=0;j<=w;j++) {
				 System.out.printf("%-8s",l[i][j]);  
			}
			 System.out.println();
		} 
		
        return max[n][w];  
	}*/
	
	//1维,虽然优化了动态规划的空间(二维每次处理都是处理上面那行，可合并成一维)
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
					//组成
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
		System.out.println("组成：");
		for(String q:l) {
			System.out.print(q+" ");
		}
		System.out.println();
		return max[w];
	}
}
