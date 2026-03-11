import java.util.*;

public class AdvancedFinanceDSA {

    static Scanner sc = new Scanner(System.in);

    // ===============================================
    // LOGIN / SIGNUP SYSTEM
    // ===============================================

    static String username = "";
    static String password = "";
    static boolean loggedIn = false;

    static void signup() {

        System.out.println("\n--- SIGN UP ---");
        System.out.print("Create Username: ");
        username = sc.next();

        System.out.print("Create Password: ");
        password = sc.next();

        System.out.println("Account Created Successfully");
    }

    static void login() {

        System.out.println("\n--- LOGIN ---");

        System.out.print("Enter Username: ");
        String u = sc.next();

        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {
            loggedIn = true;
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Credentials");
        }
    }

    static void logout() {
        loggedIn = false;
        System.out.println("Logged Out");
    }

    // ===============================================
    // CIRCULAR LINKED LIST (CO2)
    // ===============================================

    static class Node {

        int id;
        double amount;
        String type;
        Node next;

        Node(int id, double amount, String type) {
            this.id = id;
            this.amount = amount;
            this.type = type;
        }
    }

    static Node head = null;

    static void addTransaction(int id, double amount, String type) {

        Node newNode = new Node(id, amount, type);

        if (head == null) {

            head = newNode;
            head.next = head;
        } else {

            Node temp = head;

            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Transaction Added");
    }

    static void displayTransactions() {

        if (head == null) {
            System.out.println("No Transactions");
            return;
        }

        Node temp = head;

        do {

            System.out.println("ID:" + temp.id +
                    " Amount:" + temp.amount +
                    " Type:" + temp.type);

            temp = temp.next;

        } while (temp != head);
    }

    // ===============================================
    // MERGE SORT (CO1 - Sorting)
    // ===============================================

    static void mergeSort(double arr[], int l, int r) {

        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(double arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        double L[] = new double[n1];
        double R[] = new double[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // ===============================================
    // BINARY SEARCH (CO1 - Searching)
    // ===============================================

    static int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;

            else if (arr[mid] < key)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    // ===============================================
    // DEQUE IMPLEMENTATION (CO3)
    // ===============================================

    static Deque<String> deque = new ArrayDeque<>();

    static void dequeDemo() {

        deque.addFirst("Income Entry");
        deque.addLast("Expense Entry");

        System.out.println("Deque Elements: " + deque);

        deque.removeFirst();
        deque.removeLast();
    }

    // ===============================================
    // POLYNOMIAL ADT (CO3 - ADT Concept)
    // ===============================================

    static class Term {

        int coeff;
        int power;

        Term(int c, int p) {
            coeff = c;
            power = p;
        }
    }

    static void polynomialDemo() {

        List<Term> poly = new ArrayList<>();

        poly.add(new Term(3, 2));
        poly.add(new Term(5, 1));
        poly.add(new Term(2, 0));

        System.out.print("Polynomial: ");

        for (Term t : poly) {

            System.out.print(t.coeff + "x^" + t.power + " ");
        }

        System.out.println();
    }

    // ===============================================
    // HEAP IMPLEMENTATION FROM SCRATCH (CO5)
    // ===============================================

    static class MaxHeap {

        int heap[] = new int[100];
        int size = 0;

        void insert(int val) {

            heap[++size] = val;
            int i = size;

            while (i > 1 && heap[i] > heap[i / 2]) {

                int temp = heap[i];
                heap[i] = heap[i / 2];
                heap[i / 2] = temp;

                i = i / 2;
            }
        }

        int deleteMax() {

            int max = heap[1];
            heap[1] = heap[size--];

            heapify(1);

            return max;
        }

        void heapify(int i) {

            int largest = i;

            int left = 2 * i;
            int right = 2 * i + 1;

            if (left <= size && heap[left] > heap[largest])
                largest = left;

            if (right <= size && heap[right] > heap[largest])
                largest = right;

            if (largest != i) {

                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                heapify(largest);
            }
        }
    }

    static MaxHeap heap = new MaxHeap();

    static void heapDemo() {

        heap.insert(2000);
        heap.insert(5000);
        heap.insert(1000);

        System.out.println("Highest Transaction: " + heap.deleteMax());
    }

    // ===============================================
    // MAIN MENU
    // ===============================================

    public static void main(String[] args) {

        int choice;

        while (true) {

            if (!loggedIn) {

                System.out.println("\n1 SignUp");
                System.out.println("2 Login");
                System.out.println("3 Exit");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        signup();
                        break;

                    case 2:
                        login();
                        break;

                    case 3:
                        System.exit(0);
                }

            } else {

                System.out.println("\n--- ADVANCED FINANCE SYSTEM ---");

                System.out.println("1 Add Transaction");
                System.out.println("2 Display Transactions");
                System.out.println("3 Merge Sort Demo");
                System.out.println("4 Binary Search Demo");
                System.out.println("5 Deque Demo");
                System.out.println("6 Polynomial ADT Demo");
                System.out.println("7 Heap Demo");
                System.out.println("8 Logout");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();

                        System.out.print("Type: ");
                        String type = sc.next();

                        addTransaction(id, amt, type);
                        break;

                    case 2:
                        displayTransactions();
                        break;

                    case 3:

                        double arr[] = {500, 200, 800, 100};
                        mergeSort(arr, 0, arr.length - 1);

                        System.out.println("Sorted Transactions:");

                        for (double v : arr)
                            System.out.print(v + " ");

                        System.out.println();
                        break;

                    case 4:

                        int nums[] = {10, 20, 30, 40, 50};

                        int pos = binarySearch(nums, 30);

                        System.out.println("Found at index: " + pos);
                        break;

                    case 5:
                        dequeDemo();
                        break;

                    case 6:
                        polynomialDemo();
                        break;

                    case 7:
                        heapDemo();
                        break;

                    case 8:
                        logout();
                        break;
                }
            }
        }
    }
}