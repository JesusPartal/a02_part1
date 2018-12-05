//JESUS PARTAL - R00092544

/**
 * The class contains the Divide and Conquer-based Algorithms we are using.
 */
public class DivideAndConquerAlgorithms {

    //----------------------------------------------
    // Class constructor
    //----------------------------------------------
    /**
     * Constructor of the class. Do not edit it.
     */
    public DivideAndConquerAlgorithms(){}

    //-------------------------------------------------------------------
    // 0. iterativeDisplayElements --> Displays all elements of a MyList
    //-------------------------------------------------------------------
    /**
     * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
     * @param m: The MyList we want to display its elements.
     */
    public void iterativeDisplayElements(MyList<Integer> m){
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;

        //Rule 1. MyList is empty
        if (m.length() == 0)
            scenario = 1;
            //Rule 2. MyList is non-empty
        else
            scenario = 2;

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch(scenario){

            //Rule 1. MyList is empty
            case 1:
                //1. We print the empty message
                System.out.println("Empty MyList");

                break;

            //Rule 2. MyList is non-empty
            case 2:
                //1. We print the initial message
                int size = m.length();
                System.out.println("MyList Contains the following " + size + " items: ");

                //2. We traverse the items
                for (int i = 0; i < size; i++)
                    System.out.println("Item " + i + ": " + m.getElement(i));

                break;

        }

    }

    //-------------------------------------------------------------------
    // 1. maxInt --> Computes the maximum item of MyList
    //-------------------------------------------------------------------
    /**
     * The function computes the maximum item of m (-1 if m is empty).
     * @param m: The MyList we want to compute its maximum item.
     * @return: The maximum item of MyList
     */
    public int maxInt(MyList<Integer> m){
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        int res = 0;

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------

        int scenario = 0;
        //Rule 1. MyList is empty
        if (m.length() == 0)
            scenario = 1;
        //Rule 2. MyList has one element
        if (m.length() == 1)
            scenario = 2;
        //Rule 3. MyList has more than one element
        if (m.length() >= 2)
            scenario = 3;

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            //Rule 1. MyList is empty
            case 1:
                res = -1;
                break;
            //Rule 2. MyList has one element
            case 2:
                res = m.getElement(0);
                break;
            //Rule 3. MyList has more than one element
            case 3:
                if (m.getElement(0) > res) {
                    int e0 = m.getElement(0);
                    m.removeElement(0);
                    res = e0;
                    maxInt(m);
                    m.addElement(0, e0);
                } else {
                    int e0 = m.getElement(0);
                    maxInt(m);
                    m.addElement(0, e0);
                }
                break;
        }

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 2. isReverse --> Computes if MyList is sorted in decreasing order
    //-------------------------------------------------------------------
    /**
     * The function computes whether m is sorted in decreasing order or not.
     * @param m: The MyList we want to check.
     * @return: Whether m is sorted in decreasing order or not.
     */
    public boolean isReverse(MyList<Integer> m){
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        boolean res = false;

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;
        //Rule 1. MyList length is equal or less than 1
        if (m.length() == 0 || m.length() == 1)
            scenario = 1;
        //Rule 2. MyList has more than 1 element
        if (m.length() >= 2)
            scenario = 2;

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            //Rule 1. MyList length is equal or less than 1
            case 1:
                res = false;
                break;
            //Rule 2. MyList has more than 1 element
            case 2:
                if(m.getElement(0) > m.getElement(1)){
                    int e0 = m.getElement(0);
                    res = true;
                    m.removeElement(0);
                    isReverse(m);
                    m.addElement(0,e0);
                } else {
                    res = false;
                }
        }

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 3. getNumAppearances --> Computes the amount of times that integer appears in MyList
    //-------------------------------------------------------------------
    /**
     * The function computes the amount of times that the integer n appears in m.
     * @param m: The MyList we want to use.
     * @param n: The number we want to compute its appearances for.
     * @return: The amount of appearances of n into m
     */
    public int getNumAppearances(MyList<Integer> m, int n) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        int res = 0;

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;
        //Rule 1. MyList is empty
        if (m.length() == 0)
            scenario = 1;
        //Rule 2. MyList has 1 element
        if (m.length() == 1)
            scenario = 2;
        //Rule 3. MyList has more than 1 element
        if (m.length() >= 2)
            scenario = 3;

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            //Rule 1. MyList is empty
            case 1:
                res = -1;
                break;
            //Rule 2. MyList has 1 element
            case 2:
                if (m.getElement(0) == n) {
                    res++;
                }
                break;
            //Rule 3. MyList has more than 1 element
            case 3:
                if (m.getElement(0) == n) {
                    int e0 = m.getElement(0);
                    m.removeElement(0);
                    res = 1 + getNumAppearances(m,n);
                    m.addElement(0, e0);
                } else {
                    int e0 = m.getElement(0);
                    m.removeElement(0);
                    res = getNumAppearances(m,n);
                    m.addElement(0, e0);
                }
                break;
        }

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 4. power --> Computes the m-est power of n
    //-------------------------------------------------------------------
    /**
     * The function computes n to the power of m.
     * @param n: The base number.
     * @param m: The power of n we want to compute
     * @return: n to the power of m.
     */

    public int power(int n, int m){
        //-----------------------------
        //SET OF OPS
        //-----------------------------
        if (m == 0)
            return 1;

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return (n * power(n, m-1));
    }

    //-------------------------------------------------------------------
    // 5. lucas --> Computes the n-est term of the Lucas series
    //-------------------------------------------------------------------
    /**
     * The function computes the n-est term of the Lucas series
     * @param n: The n-est term of the series we want to compute
     * @return: The term being computed
     */
    public int lucas(int n){
        //-----------------------------
        //SET OF OPS
        //-----------------------------
        if (n == 0) {
            return 2;
        } else if ( n == 1) {
            return 1;
        } else {
            return lucas (n-1) + lucas(n-2);
        }
    }

    //-------------------------------------------------------------------
    // 6. drawImage --> Prints a pattern of a given length
    //-------------------------------------------------------------------
    /**
     * The function prints prints a pattern of a given length.
     * *
     * **
     * ***
     * ...
     * @param n: The length of the desired pattern
     */
    public void drawImage(int n){
        //-----------------------------
        //SET OF OPS
        //-----------------------------
        if(n==0) return;

        drawImage(n-1);
        String p = "";
        for (int i=0; i<n; i++) {
            p = p + "*";
        }
        p += "\n";

        //-----------------------------
        //Print
        //-----------------------------
        System.out.println(p);
    }
}