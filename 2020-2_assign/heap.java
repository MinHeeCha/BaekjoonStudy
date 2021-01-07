public class heap {
    void makeHeap(int list[], int n, int m) {
        int temp;
        int p = m;
        int l = m * 2 + 1;
        int r = m * 2 + 2;
        
        if (l < n && list[p] < list[l])
            p = l;
        if (r < n && list[p] < list[r])
            p = r;

        if (m != p) {
            temp = list[p];
            list[p] = list[m];
            list[m] = temp;
            makeHeap(list, n, p);
        }
    }
    void sort(int list[]) {
        int n = list.length;
        int temp;

        for (int i = n / 2 - 1; i >= 0; i--)
            makeHeap(list, n, i);

        for (int i = n - 1; i > 0; i--) {
            temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            makeHeap(list, i, 0);
        }
    }
    public static void main(String[] args) {
        int list[] = {69, 10, 30, 2, 16, 8, 31, 22};
        heap hp = new heap();
        
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println("");

        hp.sort(list);

        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}