public class ArrayShiftExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        System.out.println("Before shift:");
        printArray(arr);
        
        shift(arr);
        
        System.out.println("After shift:");
        printArray(arr);
    }
    
    public static void shift(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
          arr[i] = arr[i - 1];
        }
        arr[0] = 0;
      }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
