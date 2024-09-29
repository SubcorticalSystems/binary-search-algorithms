import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
interface BinarySearch {
    public int binarySearch(int key);
    public void printElements();
    public void remove(int index);
    public void add(int value);
    public boolean contains(int value);
    public void initializeArray();
    public void sort();
}

//ArrayList
class BinarySearchArrayList implements BinarySearch {
    ArrayList <Integer> aL = new ArrayList<>();
    @Override
    public void initializeArray() {
        //initializing the first 10 digits of ArrayList with random numbers 1 - 50
        for (int i = 0; i < 10; i++) {
            int num = (int)((Math.random() * 50)+1);
            if (contains(num))
                i--;
            else
                aL.add(num);
        }
    }
    @Override
    public boolean contains(int value) {
        return aL.contains(Integer.valueOf(value));
    }
    @Override
    public void sort() {
        Collections.sort(aL);
    }
    @Override
    public int binarySearch(int key) {
        return Collections.binarySearch(aL, key);
    }
    @Override
    public void printElements() {
        System.out.println("ArrayList of numbers:");
        for (int x : aL)
            System.out.print(x + " ");
    }
    @Override
    public void remove(int index) {
        for (int i = index; i < aL.size() - 1; i ++) {
            aL.set(i, aL.get(i + 1));
        }
        aL.set(aL.size() - 1, 0);
        sort();
        printElements();
    }
    @Override
    public void add(int value) {
        if (!contains(value)) {
            aL.add(value);
            sort();
            printElements();
        } else {
            System.out.println("Item " + value + " already exists in list. Not added.");
        }
    }
}

//LinkedList
class BinarySearchLinkedList implements BinarySearch {
    LinkedList <Integer> aL = new LinkedList<>();
    @Override
    public void initializeArray() {
        //initializing the first 10 digits of ArrayList with random numbers 1 - 50
        for (int i = 0; i < 10; i++) {
            int num = (int)((Math.random() * 50)+1);
            if (contains(num))
                i--;
            else
                aL.add(num);
        }
    }
    @Override
    public boolean contains(int value) {
        return aL.contains(Integer.valueOf(value));
    }
    @Override
    public void sort() {
        Collections.sort(aL);
    }
    @Override
    public int binarySearch(int key) {
        return  Collections.binarySearch(aL, key);
    }
    @Override
    public void printElements() {
        System.out.println("LinkedList of numbers:");
        for (int x : aL)
            System.out.print(x + " ");
    }
    @Override
    public void remove(int index) {
        for (int i = index; i < aL.size() - 1; i ++) {
            aL.set(i, aL.get(i + 1));
        }
        aL.set(aL.size() - 1, 0);
        sort();
        printElements();
    }
    @Override
    public void add(int value) {
        if (!contains(value)) {
            aL.add(value);
            sort();
            printElements();
        } else {
            System.out.println("Item " + value + " already exists in list. Not added.");
        }
    }
}

//Array
class BinarySearchArray implements BinarySearch {
    int[] array = new int [15];
    @Override
    public void initializeArray() {
        //initializing the first 10 digits of array with random numbers 1 - 50
        for (int i = 0; i < 10; i++) {
            int num = (int)((Math.random() * 50)+1);
            if (contains(num)) {
                i--;
            } else
                array[i] = num;
        }
    }
    @Override
    public boolean contains(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }
    @Override
    public void sort() {
        Arrays.sort(array);
    }
    @Override
    public int binarySearch(int key) {
        return Arrays.binarySearch(array, key);
    }
    @Override
    public void printElements() {
        System.out.println("Array of numbers:");
        for (int x : array)
            System.out.print(x + " ");
    }
    @Override
    public void remove(int index) {
        for (int i = index; i < array.length - 1; i ++) {
            array [i] = array [i + 1];
        }
        array [array.length - 1] = 0;
        sort();
        printElements();
    }
    @Override
    public void add(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array [i] == 0) {
                array [i] = value;
                break;
            }
            else {
                System.out.println("There are no more spots left to fill.");
                break;}
        }
        sort();
        printElements();
    }

    //Test Methods
    public void printWelcomeMessage (String mode) {
        System.out.println("\nWelcome to the Binary Search Test (" + mode + "):\n");
    }
    public void testBinarySearch (BinarySearch searchObject) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (value != -1)
        {
            System.out.print("\n\nEnter an integer to search (or -1 to quit): ");
            String ss = scanner.nextLine();
            value = Integer.parseInt(ss);
            if (value == -1) {
                break;
            }
            int index;


            if ((index = searchObject.binarySearch(value)) >= 0) {
                System.out.println("Value " + value + " found." + " Do you want to remove it? y/n");
                        String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    searchObject.remove(index);
                }
            } else {
                System.out.println("Value " + value + " not found." + " Do you want to add it? y/n? ");
                        String answer = scanner.nextLine();
                if (answer.equals("y"))
                    searchObject.add(value);
            }
        }
        System.out.println("Goodbye...");
    }
    public void binarySearchTestDriver() {
        //Array
        BinarySearch bsArr = new BinarySearchArray();
        bsArr.initializeArray();
        bsArr.sort();
        String mode = bsArr.getClass().getSimpleName();
        printWelcomeMessage(mode);
        bsArr.printElements();
        testBinarySearch(bsArr);
        //Array List
        BinarySearch bsArrL = new BinarySearchArrayList();
        bsArrL.initializeArray();
        bsArrL.sort();
        mode = bsArrL.getClass().getSimpleName();
        printWelcomeMessage(mode);
        bsArrL.printElements();
        testBinarySearch(bsArrL);
        //Linked List
        BinarySearch bsLinkedL = new BinarySearchLinkedList();
        bsLinkedL.initializeArray();
        bsLinkedL.sort();
        mode = bsArrL.getClass().getSimpleName();
        printWelcomeMessage(mode);
        bsLinkedL.printElements();
        testBinarySearch(bsLinkedL);
    }
    public static void main(String[] args) {
        BinarySearchArray bs = new BinarySearchArray();
        bs.binarySearchTestDriver();
    }
}