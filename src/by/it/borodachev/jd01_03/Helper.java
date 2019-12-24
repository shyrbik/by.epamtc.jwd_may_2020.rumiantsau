package by.it.borodachev.jd01_03;

 class Helper {
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
  static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
   double [] retMatrix=new double[matrix.length];
   for (int i = 0; i < matrix.length; i++) {
    for (int i1 = 0; i1 < vector.length; i1++) {
     retMatrix[i]+=matrix[i][i1]*vector[i1];
    }
   }
   return retMatrix;
  }

  static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
   double[ ][ ] retMatrix=new double [matrixLeft.length][matrixRight[0].length];
   for (int i = 0; i < matrixLeft.length; i++) {
    for (int i1 = 0; i1 < matrixRight[0].length; i1++) {
     for (int i2 = 0; i2 < matrixRight.length; i2++) {
      retMatrix[i][i1]+=matrixLeft[i][i2]*matrixRight[i2][i1];
     }
    }
    }
   return retMatrix;
  }

 }
