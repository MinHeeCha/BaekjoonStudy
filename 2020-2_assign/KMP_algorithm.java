import java.util.Scanner;

class KMP {
    static Scanner scanner = new Scanner(System.in);
    int fail[];
    char pArr[];
    String pattern;

    public KMP(String p) {
        pattern = p;

        fail = new int[pattern.length()];
        pArr = new char[pattern.length()];
        for (int i = 0; i < pArr.length; i++)
            pArr[i] = (pattern.charAt(i));
    }
    public void calcFail() {
        int temp;

        fail[0] = 0;
        fail[1] = 1;
        for (int i = 2; i < fail.length; i++) {
           if (pArr[i - 1] == pArr[fail[i - 1] - 1]) {
                temp = fail[i - 1];
            }
            else {
                temp = fail[fail[i - 1] - 1];

                while(true) {
                    if (temp == 0 || pArr[i - 1] == pArr[temp])
                        break;
                    temp = fail[temp - 1];
                }
            }
            fail[i] = temp + 1;
        }
    }
    public boolean compare(char[] text) {
        int j = 0;
        boolean match = false;
        System.out.println("");

        for (int i = 0; i < text.length; i++) {
            if (text[i] == pArr[j]) {
                if (j == pArr.length - 1) {
                    match = true;
                    j = 0;
                    continue;
                }
                j++;
            }
            else {
                if (fail[j] == 0) {
                    j = 0;
                }
                else
                    j = fail[j] - 1;
            }
        }
        return match;
    }
}

public class KMP_algorithm {
    static Scanner scanner = new Scanner(System.in);
    static boolean flag = true;

    public static void main(String[] args) {
        String text = "AAAABBCBCBBABABABCBCABABASDNCCCCSSABABDSN";

        char arr[] = new char[text.length()];
        for (int i = 0; i < text.length(); i++)
            arr[i] = (text.charAt(i));

        KMP test = new KMP("ABABABCB");
        test.calcFail();

        for (int i = 0; i < test.pArr.length; i++)
            System.out.print(test.pArr[i] + " ");

        System.out.println(" ");
        
        for (int i = 0; i < test.pArr.length; i++)
            System.out.print(test.fail[i] + " ");

        boolean b = test.compare(arr);
        if (b)
            System.out.print("true!!!");

        scanner.close();
    }
}
