import java.util.*;
import java.io.*;

public class FinanceDSAProject {

    static Scanner sc = new Scanner(System.in);

    // =========================================================
    // USER AUTHENTICATION SYSTEM
    // Login / Signup / Logout
    // =========================================================

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

        if(u.equals(username) && p.equals(password))
        {
            loggedIn = true;
            System.out.println("Login Successful");
        }
        else
        {
            System.out.println("Invalid Credentials");
        }
    }

    static void logout()
    {
        loggedIn = false;
        System.out.println("Logged Out Successfully");
    }

    // =========================================================
    // CO2: CIRCULAR LINKED LIST
    // Used to store financial transactions dynamically
    // =========================================================

    static class Transaction
    {
        int id;
        double amount;
        String type;
        Transaction next;

        Transaction(int id,double amount,String type)
        {
            this.id=id;
            this.amount=amount;
            this.type=type;
        }
    }

    static Transaction head=null;

    static void addTransaction(int id,double amount,String type)
    {
        Transaction newNode=new Transaction(id,amount,type);

        if(head==null)
        {
            head=newNode;
            head.next=head;
        }
        else
        {
            Transaction temp=head;

            while(temp.next!=head)
                temp=temp.next;

            temp.next=newNode;
            newNode.next=head;
        }

        saveToFile(id,amount,type);

        System.out.println("Transaction Added");
    }

    static void displayTransactions()
    {
        if(head==null)
        {
            System.out.println("No Transactions");
            return;
        }

        Transaction temp=head;

        do
        {
            System.out.println("ID:"+temp.id+
                               " Amount:"+temp.amount+
                               " Type:"+temp.type);

            temp=temp.next;

        }while(temp!=head);
    }

    // =========================================================
    // FILE STORAGE
    // Save transactions into file
    // =========================================================

    static void saveToFile(int id,double amount,String type)
    {
        try
        {
            FileWriter fw=new FileWriter("transactions.txt",true);

            fw.write(id+" "+amount+" "+type+"\n");

            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("File Error");
        }
    }

    // =========================================================
    // CO1: MERGE SORT (Sorting Algorithm)
    // Time Complexity O(n log n)
    // =========================================================

    static void mergeSort(double arr[],int l,int r)
    {
        if(l<r)
        {
            int m=(l+r)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    static void merge(double arr[],int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;

        double L[]=new double[n1];
        double R[]=new double[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];

        for(int j=0;j<n2;j++)
            R[j]=arr[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
                arr[k++]=L[i++];
            else
                arr[k++]=R[j++];
        }

        while(i<n1)
            arr[k++]=L[i++];

        while(j<n2)
            arr[k++]=R[j++];
    }

    // =========================================================
    // CO1: BINARY SEARCH
    // Searching Algorithm
    // =========================================================

    static int binarySearch(int arr[],int key)
    {
        int low=0;
        int high=arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]==key)
                return mid;

            else if(arr[mid]<key)
                low=mid+1;

            else
                high=mid-1;
        }

        return -1;
    }

    // =========================================================
    // CO4: HASHING
    // HashMap used as Hash Table
    // =========================================================

    static void hashingDemo()
    {
        HashMap<Integer,Double> map=new HashMap<>();

        Transaction temp=head;

        if(temp==null)
        {
            System.out.println("No Data");
            return;
        }

        do
        {
            map.put(temp.id,temp.amount);

            temp=temp.next;

        }while(temp!=head);

        System.out.println("Hash Table Data:");
        System.out.println(map);
    }

    // =========================================================
    // CO3: DEQUE IMPLEMENTATION
    // Double Ended Queue
    // =========================================================

    static void dequeDemo()
    {
        Deque<Integer> dq=new ArrayDeque<>();

        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter value: ");
            dq.addLast(sc.nextInt());
        }

        System.out.println("Deque Elements:"+dq);

        System.out.println("Remove Front:"+dq.removeFirst());

        System.out.println("Remove Rear:"+dq.removeLast());
    }

    // =========================================================
    // CO3: POLYNOMIAL ADT
    // =========================================================

    static class Term
    {
        int coeff;
        int power;

        Term(int c,int p)
        {
            coeff=c;
            power=p;
        }
    }

    static void polynomialDemo()
    {
        System.out.print("Enter number of terms: ");
        int n=sc.nextInt();

        List<Term> poly=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            System.out.print("Coefficient:");
            int c=sc.nextInt();

            System.out.print("Power:");
            int p=sc.nextInt();

            poly.add(new Term(c,p));
        }

        System.out.print("Polynomial:");

        for(Term t:poly)
            System.out.print(t.coeff+"x^"+t.power+" + ");

        System.out.println();
    }

    // =========================================================
    // CO5: HEAP IMPLEMENTATION FROM SCRATCH
    // Max Heap
    // =========================================================

    static class MaxHeap
    {
        int heap[]=new int[100];
        int size=0;

        void insert(int val)
        {
            heap[++size]=val;

            int i=size;

            while(i>1 && heap[i]>heap[i/2])
            {
                int temp=heap[i];
                heap[i]=heap[i/2];
                heap[i/2]=temp;

                i=i/2;
            }
        }

        int deleteMax()
        {
            int max=heap[1];

            heap[1]=heap[size--];

            heapify(1);

            return max;
        }

        void heapify(int i)
        {
            int largest=i;

            int left=2*i;
            int right=2*i+1;

            if(left<=size && heap[left]>heap[largest])
                largest=left;

            if(right<=size && heap[right]>heap[largest])
                largest=right;

            if(largest!=i)
            {
                int temp=heap[i];
                heap[i]=heap[largest];
                heap[largest]=temp;

                heapify(largest);
            }
        }
    }

    static MaxHeap heap=new MaxHeap();

    static void heapDemo()
    {
        System.out.print("Enter number of elements:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter value:");
            heap.insert(sc.nextInt());
        }

        System.out.println("Highest Transaction:"+heap.deleteMax());
    }

    // =========================================================
    // GRAPH BASED EXPENSE ANALYSIS
    // Adjacency Matrix representation
    // =========================================================

    static void graphDemo()
    {
        System.out.print("Enter number of categories:");
        int n=sc.nextInt();

        int graph[][]=new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j]=sc.nextInt();
            }
        }

        System.out.println("Graph Representation:");

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(graph[i][j]+" ");
            }

            System.out.println();
        }
    }

    // =========================================================
    // MAIN MENU SYSTEM
    // =========================================================

    public static void main(String[] args)
    {
        int choice;

        while(true)
        {
            if(!loggedIn)
            {
                System.out.println("\n1 SignUp");
                System.out.println("2 Login");
                System.out.println("3 Exit");

                choice=sc.nextInt();

                switch(choice)
                {
                    case 1: signup(); break;
                    case 2: login(); break;
                    case 3: System.exit(0);
                }
            }
            else
            {
                System.out.println("\n--- PERSONAL FINANCE SYSTEM ---");

                System.out.println("1 Add Transaction");
                System.out.println("2 Display Transactions");
                System.out.println("3 Merge Sort Demo");
                System.out.println("4 Binary Search Demo");
                System.out.println("5 Hashing Demo");
                System.out.println("6 Deque Demo");
                System.out.println("7 Polynomial ADT Demo");
                System.out.println("8 Heap Demo");
                System.out.println("9 Graph Expense Analysis");
                System.out.println("10 Logout");

                choice=sc.nextInt();

                switch(choice)
                {
                    case 1:

                        System.out.print("ID:");
                        int id=sc.nextInt();

                        System.out.print("Amount:");
                        double amt=sc.nextDouble();

                        System.out.print("Type:");
                        String type=sc.next();

                        addTransaction(id,amt,type);
                        break;

                    case 2: displayTransactions(); break;

                    case 3:

                        System.out.print("Enter number of elements:");
                        int n=sc.nextInt();

                        double arr[]=new double[n];

                        for(int i=0;i<n;i++)
                            arr[i]=sc.nextDouble();

                        mergeSort(arr,0,n-1);

                        for(double v:arr)
                            System.out.print(v+" ");

                        System.out.println();
                        break;

                    case 4:

                        System.out.print("Enter size:");
                        int size=sc.nextInt();

                        int nums[]=new int[size];

                        for(int i=0;i<size;i++)
                            nums[i]=sc.nextInt();

                        System.out.print("Key:");
                        int key=sc.nextInt();

                        int pos=binarySearch(nums,key);

                        if(pos==-1)
                            System.out.println("Not Found");
                        else
                            System.out.println("Found at index:"+pos);

                        break;

                    case 5: hashingDemo(); break;

                    case 6: dequeDemo(); break;

                    case 7: polynomialDemo(); break;

                    case 8: heapDemo(); break;

                    case 9: graphDemo(); break;

                    case 10: logout(); break;
                }
            }
        }
    }
}