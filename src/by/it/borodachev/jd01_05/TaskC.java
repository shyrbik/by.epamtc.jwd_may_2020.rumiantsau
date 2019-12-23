package by.it.borodachev.jd01_05;

import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
           step1(30);
            step2();
    }
    private static void step1(int masLength) {
         double [][]mas =new double [masLength][2];
         double delta = (9-5.35)/masLength;
         int i =0;
         int sgCount=0;
         double sg=1.0;

        for (double x = 5.35; x <=9 ; x+=delta) {
                if (i<masLength) {
                     mas[i][1]=Math.pow(x*x+4.5,1.0/3.0);
                     mas[i][0]=x;
                    if (mas[i][1] > 3.5) {sg=sg*mas[i][1]; sgCount++;}
                i++;
                }
                                }
        printArray(mas,"z",5);
if (sgCount >0) {
    System.out.printf("%s =%-50.30f%n", "Среднеее геометрическое ", Math.pow(sg, 1.0 / sgCount));
}
else
    System.out.printf("%s =%-50.30f%n", "Среднеее геометрическое ", 0);

    }

    private static void step2() {
      Random rn=new Random();
      int [] mas=new int[31];
      int bLength=0;
        for (int i = 0; i <mas.length; i++) {
          mas[i]=rn.nextInt(450-103)+103;
          if ((double) mas[i]/10 > (double)i) {bLength++;}
        }
        int [] masb=new int[bLength];
        int j=0;
        for (int i = 0; i <mas.length; i++) {
            if ((double) mas[i]/10 > (double)i) {masb[j]=mas[i]; j++;}
        }
        mergeSort(masb);
        printArrayTab(mas,"A",true);
        printArrayTab(masb,"B",false);
    }
     private static String leftPad(String originalString, int length,
                                 char padCharacter) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = padCharacter + paddedString;
        }
        return paddedString;
    }
    static void printArrayTab(int[] arr, String name, boolean onRow) {
        int rowCount;
        int columnCount=5;
        int newInd;
        String outFmtVal="|%s[%-2d]=%-5d|";
        String outFmtNull="|%-"+(name.length()+10)+"s|";
        String outFmtDelRow="%-"+(name.length()+10)+"s";
        String delRowStr =leftPad("-",name.length()+10+2,'-');
        String delRowStrEnd =leftPad("-",name.length()+10+2,'-');
       if (onRow) {
        System.out.printf("Massiv %s (index to rows)%n",name);
       }
else {
           System.out.printf("Massiv %s (index to cols)%n",name);
       }
        if (arr.length%columnCount >0) {
            rowCount=arr.length/columnCount+1;}
            else {rowCount=arr.length;}
            for (int i = 0; i < rowCount; i++) {
                System.out.printf("-");
                for (int j = 0; j < columnCount; j++) {
                System.out.printf(outFmtDelRow,delRowStr);
                    }
                System.out.printf("-");
                System.out.printf("%n");
                System.out.printf("|");
                 for (int j = 0; j < columnCount; j++) {
                    if (onRow)  {newInd=i*columnCount+j;}
                    else {newInd=i+j*rowCount;};
                 if (newInd >= arr.length) {
                     System.out.printf(outFmtNull," ");
                    }
                 else {
                    System.out.printf(outFmtVal,name,newInd,arr[newInd]);
                    }
                }
                System.out.printf("|");
                System.out.printf("%n");
                System.out.printf("-");
                for (int j = 0; j < columnCount; j++) {
                    System.out.printf(outFmtDelRow,delRowStr);
                }
                System.out.printf("-");
                System.out.printf("%n");
            }
          System.out.printf("%n");
    }
    static void printArray(double[ ][] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -6.4f]=%-50.30f",name,arr[i][0],arr[i][1]);
            if ((i+1)%columnCount==0) {System.out.printf("%n");}
        }
        System.out.printf("%n");
    }
    static void printArray(int[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -6.4f]=%-50.30f",name,i,arr[i]);
            if ((i+1)%columnCount==0) {System.out.printf("%n");}
        }
        System.out.printf("%n");
    }

    static void mergeSort(int[] mas) {
        mergeSort(mas, 0, mas.length - 1);
    }

    static void mergeSort(int[] mas, int left, int right) {
        if (mas.length == 0) return;
        if (left >= right) return;
        double median = mas[(left + (right - left) / 2)];
        int i = left, j = right;
        while (i <= j) {
            while (mas[i] < median) {
                i++;
            }
            while (mas[j] > median) {
                j--;
            }
            if (i <= j) {
                int tmp = mas[i];
                mas[i] = mas[j];
                mas[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) mergeSort(mas, left, j);
        if (right > i) mergeSort(mas, i, right);
    }

}