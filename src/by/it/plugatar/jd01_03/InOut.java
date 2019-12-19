package by.it.Plugatar.jd01_03;

 public class InOut {
    public static double[] getArray(String line) {
        String [] parts=line.trim().split( " ");
        double[] result=new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            //result[i]=Integer.parseInt(parts[i]);
            result[i]=Double.parseDouble(parts[i]);
        }
        return result;
    }

     public static void printArray(double[] array) {
         for (double element : array) {
             System.out.print(element+" ");
         }
         System.out.println();
     }

     public static void printArray(double[] array, String name, int colCount) {
         for (int j = 0; j < array.length; j++) {
             System.out.printf("%s[% -3d]=%-10.4f ",name,j,array[j]);
             if ((j+1)%colCount==0 || j+1==array.length)
                 System.out.println();
         }
     }

 }
