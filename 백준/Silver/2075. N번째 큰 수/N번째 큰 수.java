import java.util.Scanner;

public class Main {

    private static int[] sorted;

    public static void merge_sort(int[] a){

        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }       
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if(l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        else {
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }

        }
        for(int i = left; i <= right; i++){
            a[i] = sorted[i];
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //System.out.println("Enter the n: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        int[] nums = new int[n * n];

        //System.out.println("Enter the nums: ");
        int index = 0;

        for (int i=0; i < n; i++){
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                try {
                    nums[index] = Integer.parseInt(token);
                    index++;
                } catch (NumberFormatException e){
                    System.out.println("Invalid number: " + token);
                }
            }
        }

        
        merge_sort(nums);
        System.out.println(nums[n*n - n]);
    }
}