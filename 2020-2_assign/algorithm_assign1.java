import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

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

        for (int i = start; i < start + len; i++)
            temp += text[i];

        return temp;
    }
    public boolean compare(char[] text) {
        int cnt = 0;
        int m = pArr.length - 1;
        String reverseArr[] = new String[sArr.length];
        boolean match = false;

        for (int i = sArr.length - 1; i > 0; i--)
            reverseArr[i] = sArr[sArr.length - 1 - i];

        for (int i = m; i < text.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j == m)
                    cnt = 0;
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
            if (pArr[i - 1] == pArr[fail[i - 1] - 1])
                temp = fail[i - 1];
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
                if (fail[j] == 0)
                    j = 0;
                else
                    j = fail[j] - 1;
            }
        }
        return match;
    }
}

public class algorithm_assign1 {
    static Scanner scanner = new Scanner(System.in);
    static int fileCount;
    static String files[][];     // 0 : file name, 1 : file text
    static char textArr[][];
    static boolean isMatch[];
    
    public static void init() {
        int chCount = 0;

        System.out.println("프로그램 코드가 존재하는 폴더까지의 경로를 입력하시오.");
        System.out.println("ex) 프로그램 코드 0.txt의 경로가 다음과 같을 경우,");
        System.out.println("    C:\\Users\\guslo\\Desktop\\algorithm\\assign1\\programCode\\0.txt");
        System.out.println("    다음과 같이 입력하시오.");
        System.out.println("    C:\\Users\\guslo\\Desktop\\algorithm\\assign1\\programCode");
                            
        String path = scanner.next();
        File parent = new File(path);
        File subFiles[] = parent.listFiles();

        fileCount = subFiles.length;
        String subFilesName[] = new String[fileCount];
        files = new String[fileCount][2];
        textArr = new char[fileCount][];
        isMatch = new boolean[fileCount];

        if (fileCount < 15) {
            System.out.println("프로그램 코드는 15개 이상이어야 합니다.");
            System.exit(0);
        }

        for (int i = 0; i < fileCount; i++)
            subFilesName[i] = subFiles[i].getName();

        System.out.println("\n--- 프로그램 경로 ---");

        try {
            for (int i = 0; i < fileCount; i++) {
                String str = "";
                chCount = 0;

                String fileName = path + "\\" + subFilesName[i];
                File f = new File(fileName);
                System.out.println(fileName);

                files[i][0] = path + "\\" + subFilesName[i];

                FileReader reader = new FileReader(f);

                while ((reader.read()) != -1)
                    chCount++;
                System.out.println("count : " + chCount);

                if (chCount < 27) {
                    System.out.println("프로그램 코드는 27개 이상의 문자들로 구성되어야 합니다.");
                    System.exit(0);
                }

                BufferedReader in = new BufferedReader(new FileReader(f));

                while (true) {
                    str = in.readLine();
                    
                    if (str != null)
                        files[i][1] = str;
                    else
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error!");
            System.out.println("파일 경로를 확인해주세요.");
            System.exit(0);
        }

        for (int i = 0; i < fileCount; i++) {
            textArr[i] = new char[files[i][1].length()];

            for (int j = 0; j < files[i][1].length(); j++)
                textArr[i][j] = (files[i][1].charAt(j));
        }
    }
    public static void main(String[] args) {
        int matchCount = 0, pLength = 0, subCount = 0;
        String p = "";
        String sub[];

        long reqTime, resTime;
        String reqTimeStr, resTimeStr;
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        init();

        System.out.println("\n--- 프로그램 코드 ---");
        for (int i = 0; i < fileCount; i++)
            System.out.println(files[i][1]);
        System.out.println("");
        
        while (true) {
            System.out.print("악성코드 입력 : ");
            p = scanner.next();

            if (p.length() < 12) {
                System.out.println("12개 이상 문자들로 구성된 악성코드를 입력하시오.");
                continue;
            }
            else
                break;
        }
        while (true) {
            System.out.print("악성코드 패턴 길이 입력 : ");
            pLength = scanner.nextInt();

            if (pLength < 1) {
                System.out.println("1개 이상의 길이를 입력하시오.");
                continue;
            }
            else
                break;
        }
        
        System.out.println("\n--- 악성코드 패턴 ---");
        for (int i = 0; i + pLength <= p.length(); i++)
            subCount++;
        sub = new String[subCount];
        for (int i = 0; i + pLength <= p.length(); i++) {
            sub[i] = p.substring(i, i + pLength);
            System.out.println(sub[i]);
        }
        System.out.println("");

        // BM algorithm
        {
            reqTime = System.currentTimeMillis(); 
            reqTimeStr = dayTime.format(new Date(reqTime)); 
    
            for (int i = 0; i < subCount; i++) {
                BM test = new BM(sub[i]);
                test.calcMatchJump();
        
                for (int j = 0; j < fileCount; j++) {
                    if (test.compare(textArr[j]))
                        isMatch[j] = true;
                    else if(isMatch[j] != true && !test.compare(textArr[j]))
                        isMatch[j] = false;
                }
            }
            resTime = System.currentTimeMillis(); 
            resTimeStr = dayTime.format(resTime);
            System.out.println("BM 실행 시간 : " + (resTime - reqTime)/1000.000);
        }

        // KMP algorithm
        {
            reqTime = System.currentTimeMillis(); 
            reqTimeStr = dayTime.format(new Date(reqTime)); 
    
            for (int i = 0; i < subCount; i++) {
                KMP test = new KMP(sub[i]);
                test.calcFail();
        
                for (int j = 0; j < fileCount; j++) {
                    if (test.compare(textArr[j]))
                        isMatch[j] = true;
                    else if(isMatch[j] != true && !test.compare(textArr[j]))
                        isMatch[j] = false;
                }
            }
            resTime = System.currentTimeMillis(); 
            resTimeStr = dayTime.format(resTime);
            System.out.println("KMP 실행 시간 : " + (resTime - reqTime)/1000.000);
        }
        
        for (int i = 0; i < fileCount; i++)
            if (isMatch[i])
                matchCount++;
        System.out.println("\n바이러스 패턴을 가진 프로그램 :: 총 " + matchCount + "개");
        for (int i = 0; i < fileCount; i++)
            if (isMatch[i])
                System.out.println(files[i][0]);
        System.out.println("\n바이러스 패턴을 가지지 않은 프로그램 :: 총 " + (fileCount - matchCount) + "개");
        for (int i = 0; i < fileCount; i++)
            if (!isMatch[i])
                System.out.println(files[i][0]);

        scanner.close();
    }
}