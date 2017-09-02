/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindMissingExtraArrayElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int b[] = {2,4,6,10,14,16};
		int[] a = {2,4,5,6,10,14,16};
      
  	  int pos = findIndex(a,b);
  	  System.out.println(pos);

      
	}

	private static int findIndex(int[] a, int[] b) {
		if(a.length<b.length){
			System.out.println("invalid entry");
		}
		else if(a[0]!= b[0]){
			return 0;
		}else if(a[a.length-1] != b[b.length-1]){
			return a.length-1;
		}else if(a.length>2 && b.length>2){
			int mida = (1+a.length-2)/2;
			int midb = (1+b.length-2)/2;
			if(a[mida] == b[midb]){
				if(mida!= midb){
					for(int i=1;i<mida;i++){
						if(a[i]!= b[i]){
							return i;
						}
					}
				}
				for(int i=mida+1;i<a.length-1;i++){
					if(a[i]!= b[i]){
						return i;
					}
				}
				
			}else if(a[mida] != b[midb]){
				for(int i=mida+1;i<a.length-1;i++){
					if(i<b.length && a[i]!=b[i]){
						return i;
					}
				}
				return mida;
			}
		}else{
			System.out.println("arrays are equal");
		}
		return 0;
	}

}
