import java.util.Scanner;

class BM {
    static Scanner scanner = new Scanner(System.in);
    int count = 0;
    int matchJump[];
    char pArr[];
    String sArr[];
    String pattern;

    public BM(String p) {
        pattern = p;

        matchJump = new int[pattern.length()];
        pArr = new char[pattern.length()];
        for (int i = 0; i < pArr.length; i++)
            pArr[i] = (pattern.charAt(i));
        sArr = new String[pattern.length()];
    }
    public void makeStringArr(int k, int m) {
        String temp = "";

        for (int j = k; j < m; j++) {
            temp += Character.toString(pArr[j + 1]);

            if (j == m - 1)
                sArr[count] = temp;
        }
    }
    public int calcR(int k, int m) {
        String temp = "";

        for (int i = k; i >= 0; i--) {
            temp = "";

            for (int j = 0; j < sArr[count].length(); j++)
                temp += pArr[i + j]; 

            if (temp.equals(sArr[count]) && i == 0)
                return i;
            else if (temp.equals(sArr[count]) && pArr[i - 1] != pArr[k])
                return i;
        }

        return -1;
    }
    public int calcQ(int k, int m) {
        int q = -1, temp = 0;
        String prefix = "", suffix = "";

        for (int i = 0; i < sArr[count].length(); i++) {
            prefix = "";
            suffix = "";

            for (int j = 0; j <= i; j++)
                prefix += pArr[j];
            for (int j = m - i; j <= m; j++)
                suffix += pArr[j];

            if (prefix.equals(suffix))
                temp = i;

            if (temp > q)
                q = temp;
        }
        count++;

        return q + 1;
    }
    public void calcMatchJump() {
        int m = matchJump.length - 1;

        matchJump[m] = 1;
        for (int i = m - 1; i >= 0; i--) {
            makeStringArr(i, m);
            int r = calcR(i, m);
            int q = calcQ(i, m);

            if (r == -1) {
                matchJump[i] = 2 * m - i + 1 - q;
                continue;
            }
            else if (r == 0) {
                matchJump[i] = m - r + 1;
                continue;
            }
            if (pArr[r - 1] == pArr[i])
                matchJump[i] = 2 * m - i + 1 - q;
            else if (pArr[r - 1] != pArr[i])
                matchJump[i] = m - r + 1;
        }
    }
    public String calcTemp(char[] text, int start, int len) {
        String temp = "";

        System.out.println("start : " + start + ", len : " + len);

        for (int i = start; i < start + len; i++)
            temp += text[i];

        System.out.println("temp : " + temp);
        System.out.println("");

        return temp;
    }
    public boolean compare(char[] text) {
        int cnt = 0;
        int m = pArr.length - 1;
        String reverseArr[] = new String[sArr.length];
        boolean match = false;

        System.out.println("");

        for (int i = sArr.length - 1; i > 0; i--)
            reverseArr[i] = sArr[sArr.length - 1 - i];

        for (int i = m; i < text.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j == m)
                    cnt = 0;
                System.out.println("cnt : " + cnt);
                String temp = calcTemp(text, i - cnt, m - j + 1);

                if (!temp.equals(reverseArr[j])) {
                    i += matchJump[j] - cnt;
                    j = m + 1;
                }
                if (cnt == m - 1) {
                    match = true;
                    i++;
                    j = m + 1;
                }
                if (i >= text.length)
                    break;

                cnt++;
            }
        }

        return match;
    }
}

public class BM_algorithm {
    static Scanner scanner = new Scanner(System.in);
    static boolean flag = true;

    public static void main(String[] args) {
        String text = "GCTTCTGCTACCTTTTGCGCGCGCGCGGAA";

        char arr[] = new char[text.length()];
        for (int i = 0; i < text.length(); i++)
            arr[i] = (text.charAt(i));

        BM test = new BM("CCTTTTGC");
        test.calcMatchJump();

        for (int i = 0; i < test.pArr.length; i++)
            System.out.print(test.pArr[i] + " ");

        System.out.println(" ");

        for (int i = 0; i < test.pArr.length; i++)
            System.out.print(test.matchJump[i] + " ");

        System.out.println(" ");

        boolean b = test.compare(arr);
        if (b)
            System.out.println("Match!!");

        scanner.close();
    }
}