
public class Queen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;//要放的皇后数量（有多少行就有多少个皇后）
		int[][] a=new int[n][n];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=0;
			}
		}
		//Queue(0,a);
		Queue(n);//传入参数表示为皇后个数
		
	}
///////////////////////////////////////////////////
	 //方法1，横向寻找位置
	  private static void Queue(int j, int[][] a) {
		if(j==a.length) {//递归结束条件
			for(int i=0; i<a.length; i++) {
				 //得到一个解，在屏幕上显示
				for(int k=0;k<a.length;k++) {
					System.out.print(a[i][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return ;
		}
		for(int i=0;i<a.length;i++) {//竖向寻找
			if(isCorrect(i, j, a)==1) {//都不行的话就往回走到上一层
				a[i][j]=1;//放置皇后
	            Queue(j+1,a);//递归深度优先搜索解空间树（横向加皇后）
	            a[i][j]=0;//这句代码就是实现回溯到上一层（某行不行的话把添加的皇后去掉）
			}
		}
		
	}

	private static int isCorrect(int i, int j, int[][] a) {
	    int s, t;
	    for(s=i,t=0; t<a.length; t++)
	        if(a[s][t]==1 && t!=j)
	            return 0;//判断行
	    for(t=j,s=0; s<a.length; s++)
	        if(a[s][t]==1 && s!=i)
	            return 0;//判断列
	    for(s=i-1,t=j-1; s>=0&&t>=0; s--,t--)
	        if(a[s][t]==1)
	            return 0;//判断左上方
	    for(s=i+1,t=j+1; s<a.length&&t<a.length;s++,t++)
	        if(a[s][t]==1)
	            return 0;//判断右下方
	    for(s=i-1,t=j+1; s>=0&&t<a.length; s--,t++)
	        if(a[s][t]==1)
	            return 0;//判断右上方
	    for(s=i+1,t=j-1; s<a.length&&t>=0; s++,t--)
	        if(a[s][t]==1)
	            return 0;//判断左下方

	    return 1;//否则返回
	}
////////////////////////////////	
	//法2，向下寻找位置
	private static void Queue(int n) {
		int[] a=new int[n+1];//a[k]代表第k行的皇后放的列数
		Untils.initArr(a);
		int k=1;
		while(k>=1) {
			a[k]=a[k]+1;//从第1列开始
			while(a[k]<=n&&!isCorrect(a,k)) {
				a[k]=a[k]+1;//依次向后寻找可放的列数
			}
			if(a[k]<=n&&k==n) {//到最后一行了，得出结果
				System.out.println("得到结果:");
				for(int i=1;i<=n;i++) {
					System.out.print("("+i+","+a[i]+")"+" ");
				}return ;
			}else if(a[k]<=n&&k<n){
				k=k+1;//放下一行的皇后
			}else {
				a[k]=0;
				k=k-1;//返回去的时候由于数组（a[k]）存了上次的一个位置而71行有加1，位置从上一层后面再找
			}
		}
	}

	private static boolean isCorrect(int[] a,int k) {
		for(int i=1;i<k;i++) {//i为行数
			// 不在同一列或不在同一斜列  Math.abs求绝对值
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
