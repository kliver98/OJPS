import java.util.Scanner;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class BubblesAndBuckets {

	static int mergeSort(int arr[], int array_size) { 
        int temp[] = new int[array_size]; 
        return _mergeSort(arr, temp, 0, array_size - 1); 
    } 
    static int _mergeSort(int arr[], int temp[], int left, int right) { 
      int mid, inv_count = 0; 
      if (right > left) { 
        mid = (right + left)/2; 
        inv_count  = _mergeSort(arr, temp, left, mid); 
        inv_count += _mergeSort(arr, temp, mid+1, right); 
        inv_count += merge(arr, temp, left, mid+1, right); 
      } 
      return inv_count; 
    } 
    static int merge(int arr[], int temp[], int left, int mid, int right) { 
      int i, j, k; 
      int inv_count = 0; 
      i = left;
      j = mid;
      k = left;
      while ((i <= mid - 1) && (j <= right)) { 
        if (arr[i] <= arr[j]) { 
          temp[k++] = arr[i++]; 
        } 
        else{ 
          temp[k++] = arr[j++]; 
          inv_count = inv_count + (mid - i); 
        } 
      } 
      while (i <= mid - 1) 
        temp[k++] = arr[i++]; 
      while (j <= right) 
        temp[k++] = arr[j++]; 
      for (i=left; i <= right; i++) 
        arr[i] = temp[i]; 
       
      return inv_count; 
    } 
	
	static String calculate(int[] arr, int n) {	
		int cont = mergeSort(arr,n);
		return (cont%2 == 0) ? "Carlos":"Marcelo";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ( !(line = sc.nextLine()).equals("0") ) {
			String[] l = line.split(" ");
			int n = Integer.parseInt(l[0]);
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(l[i+1]);
			}
			sb.append(calculate(arr,n)+"\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
