import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class QuickSort {
    public final static int LENGTH = 50;
    
    public int partition(Book list[], int left, int right) {
		Book temp;
		int pivot = (left + right) / 2;
		int low = left, high = right;

		while (low < high) {
			low = left;
			high = right;

			while (list[low].id < list[pivot].id && low < high)
				low++;
			while (list[high].id >= list[pivot].id && low < high)
				high--;

			if (low < high) {
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}

		temp = list[pivot];
		list[pivot] = list[high];
		list[high] = temp;

		return high;
	}
	public Book[] sort(Book list[], int left, int right)
	{
		int q;

		if (left < right) {
			q = partition(list, left, right);
			sort(list, left, q - 1);
			sort(list, q + 1, right);
        }
        
        return list;
	}
}

class HeapSort {
    public void makeHeap(Book list[], int n, int m) {
        Book temp;
        int p = m;
        int l = m * 2 + 1;
        int r = m * 2 + 2;
        
        if (l < n && list[p].term < list[l].term)
            p = l;
        if (r < n && list[p].term < list[r].term)
            p = r;

        if (m != p) {
            temp = list[p];
            list[p] = list[m];
            list[m] = temp;
            makeHeap(list, n, p);
        }
    }
    public Book[] sort(Book list[]) {
        int n = list.length;
        Book temp;

        for (int i = n / 2 - 1; i >= 0; i--)
            makeHeap(list, n, i);

        for (int i = n - 1; i > 0; i--) {
            temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            makeHeap(list, i, 0);
        }

        return list;
    }
}

class Book {
    static Scanner scanner = new Scanner(System.in);
    public final static int LENGTH = 50;

    protected int id, term;
    protected String name, bookName;

    public Book() {
        id = 0;
        name = "";
        bookName = "";
        term = 0;
    }
    public void input() {
        try {
            System.out.println("\n저자명과 도서명은 영문으로 입력해주세요.");
            System.out.print("ID > ");            id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("저자명 > ");          name = scanner.nextLine();
            System.out.print("도서명 > ");     bookName = scanner.nextLine();
            System.out.print("대여 기간 > ");     term = scanner.nextInt();
    
            System.out.println("[ ID : " + id + ", Name : " + name + ", Book Name : " + bookName + ", Lent Term : " + term + " ]");
            System.out.println("입력 완료");
        } catch (InputMismatchException e) {
            System.out.println("Error!");
            System.out.println("형식에 맞는 데이터를 입력하시오.");
            System.exit(0);
        }
    }
    public void remove() {
        id = 0;
        name = "";
        bookName = "";
        term = 0;

        System.out.println("삭제 완료");
    }
    public void print() {
        System.out.println("[ " + id + "    " + name + "    " + bookName + "    " + term + " ]");
    }
}

public class algorithm_assign2 {
    static Scanner scanner = new Scanner(System.in);
    final static int LENGTH = 50;
    static boolean flag = true;

    static int init(Book[] arr) {
        int i = 0;

        System.out.println("Book List의 경로를 입력하시오.");
        System.out.println("ex) C:\\Users\\guslo\\Desktop\\algorithm\\assign2\\BookList.txt");

        String path = scanner.next();
        
        try {
            File f = new File(path);
            BufferedReader in = new BufferedReader(new FileReader(f));
    
            while (true) {
                String str = in.readLine();
                
                if (str == null)
                    break;
                
                String split[] = str.split("\t");
                arr[i].id = Integer.valueOf(split[0]);
                arr[i].name = split[1];
                arr[i].bookName = split[2];
                arr[i].term = Integer.valueOf(split[3]);

                i++;
            }
        } catch (IOException e) {
            System.out.println("Error!");
            System.out.println("파일 경로를 확인해주세요.");
            System.exit(0);
        }

        return i;
    }

    public static void main(String[] args) {
        int count = 0;
        int menu, sortMenu, removeId;
        long reqTime, resTime;
        String reqTimeStr, resTimeStr;
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        Book bookArr[] = new Book[LENGTH];
        for (int i = 0; i < LENGTH; i++)
            bookArr[i] = new Book();

        System.out.println("***** 영문 도서 대여 프로그램 *****");
        while (true) {
            System.out.println("\n1. 입력	2. 정렬	3.삭제	4.출력	5.종료");
            System.out.print("메뉴 > ");        menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    if (flag) {
                        count = init(bookArr);
                        flag = false;
                    }
                    if (count >= LENGTH + 1) {
                        System.out.println("더 이상 입력할 수 없습니다.");
                        continue;
                    }
                    reqTime = System.currentTimeMillis(); 
                    reqTimeStr = dayTime.format(new Date(reqTime));
                    
                    bookArr[count].input();
                    count++;

                    resTime = System.currentTimeMillis(); 
		            resTimeStr = dayTime.format(resTime);
                    System.out.println("걸린시간 : " + (resTime - reqTime)/1000.000);
                    continue;

                case 2:
                    if (flag) {
                        System.out.println("데이터 입력 후 정렬해주세요.");
                        continue;
                    }
                    while (true) {
                        System.out.println("1. ID 정렬    2. 대여 기간 정렬");
                        System.out.print("메뉴 > ");       sortMenu = scanner.nextInt();
    
                        if (sortMenu == 1) {
                            reqTime = System.currentTimeMillis(); 
                            reqTimeStr = dayTime.format(new Date(reqTime));
                    
                            QuickSort q = new QuickSort();
                            bookArr = q.sort(bookArr, 0, LENGTH - 1);
                            break;
                        }
                        else if (sortMenu == 2) {
                            reqTime = System.currentTimeMillis(); 
                            reqTimeStr = dayTime.format(new Date(reqTime));
                    
                            HeapSort h = new HeapSort();
                            bookArr = h.sort(bookArr);
                            break;
                        }
                        else
                            System.out.println("잘못된 입력입니다.");
                    }
                    
                    resTime = System.currentTimeMillis(); 
		            resTimeStr = dayTime.format(resTime);
                    System.out.println("걸린시간 : " + (resTime - reqTime)/1000.000);
                    continue;

                case 3:
                    boolean removeFlag = true;
                    
                    if (flag) {
                        System.out.println("데이터 입력 후 삭제해주세요.");
                        continue;
                    }
                    System.out.print("삭제할 id > ");   removeId = scanner.nextInt();
                
                    reqTime = System.currentTimeMillis(); 
                    reqTimeStr = dayTime.format(new Date(reqTime));

                    for (int i = 0; i < LENGTH; i++) {
                        if (removeId == bookArr[i].id) {
                            bookArr[i].remove();
                            removeFlag = false;
                            continue;
                        }
                        if (removeId != bookArr[i].id && i + 1 == LENGTH)
                            removeId = 0;
                    }

                    if (removeId == 0 && removeFlag)
                        System.out.println("입력되지 않은 정보입니다.");

                    resTime = System.currentTimeMillis(); 
		            resTimeStr = dayTime.format(resTime);
                    System.out.println("걸린시간 : " + (resTime - reqTime)/1000.000);
                    continue;

                case 4:
                    if (flag) {
                        System.out.println("데이터 입력 후 출력해주세요.");
                        continue;
                    }
                    reqTime = System.currentTimeMillis(); 
                    reqTimeStr = dayTime.format(new Date(reqTime));

                    System.out.println("[ ID | Name      | Book Name    | Lent Term ]");

                    for (int i = 0; i < LENGTH; i++) {
                        if (bookArr[i].id == 0)
                            i++;
                        else
                            bookArr[i].print();
                    }

                    resTime = System.currentTimeMillis(); 
		            resTimeStr = dayTime.format(resTime);
                    System.out.println("걸린시간 : " + (resTime - reqTime)/1000.000);
                    continue;

                case 5:
                    System.out.println("Exit...");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}