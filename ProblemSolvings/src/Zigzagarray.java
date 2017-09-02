/**
 * a < b > c < d > e < f
 * 1,4,5,2,34,22,19,21
 */

/**
 * @author Ritam
 *
 */
public class Zigzagarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,7,8,34,56,22,45,90};
		zigzag(arr);
		ArrayUtil.traverse(arr);
	}	
	private static void zigzag(int a[]){
		boolean flag = true;
		for(int i=0;i<a.length;i++){
			if(i+1 >= a.length){
				break;
			}
			if(flag){
				if(a[i]>a[i+1]){
					ArrayUtil.swap(a,i,i+1);
				}
			}else{
				if(a[i]<a[i+1]){
					ArrayUtil.swap(a,i,i+1);
				}
			}
			//flip the falg
			flag = !flag;
		}
	}

}

