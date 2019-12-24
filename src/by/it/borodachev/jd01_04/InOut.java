package by.it.borodachev.jd01_04;

  class InOut {
      static double findMin(double[] arr) {
          double retValue = Double.MAX_VALUE;
          for (double v : arr) {
              if (v < retValue) {
                  retValue = v;
              }
          }
          return retValue;
      }

      static double findMax(double[] arr) {
          double retValue = Double.MIN_VALUE;
          for (double v : arr) {
              if (v > retValue) {
                  retValue = v;
              }
          }
          return retValue;
      }

      static void sort(double[] arr) {
          double changeValue;
          boolean toDO = false;
          do {
              toDO = false;
              for (int i = 0; i < arr.length - 1; i++) {
                  if (arr[i] > arr[i + 1]) {
                      changeValue = arr[i];
                      arr[i] = arr[i + 1];
                      arr[i + 1] = changeValue;
                      toDO = true;
                  }
              }
          } while (toDO);
      }
  static double[ ] getArray(String line) {
   String localLine=line.trim();
   String [] strArray = localLine.split(" ");
   double []retArray = new double[strArray.length];
   for (int i = 0; i <strArray.length ; i++) {
    retArray[i]=Double.valueOf(strArray[i]);
   }
   return retArray;
  }
  static void printArray(double[ ] arr) {
   for (double v : arr) {
    System.out.print (v+" ");
   }
   System.out.println();
  }


  static void printArray(double[ ] arr, String name, int columnCount) {
   for (int i = 0; i < arr.length; i++) {
      System.out.printf("%s[% -3d]=%-9.4f",name,i,arr[i]);
      if ((i+1)%columnCount==0) {System.out.printf("%n");}
   }
   System.out.printf("%n");
  }
     }

