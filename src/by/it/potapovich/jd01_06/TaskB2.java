package by.it.potapovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        //text = text.trim();
        //    text = text.replaceAll("\\p{Punct}", " ");
        // text = text.replaceAll("\n|\r\n", " ");
        //text = text.replaceAll("[\\s]{2,}", " ");


        String[] lines = text.trim().split("[.|!]\\s*");
        //for (String s : line) {
        //  s = s.replaceAll("\\p{Punct}", " ");


        //  for (int i = 0; i < line.length; i++) {
        //line[i] = text.concat(line[i]);
        //   System.out.println(line [i]);
        //  }
        // String lines = s.trim();
        // }
        // System.out.println("------------------------------------");
        //System.out.println();
       // String[] linesWithoutPunct;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            line = line.replaceAll("\\p{Punct}", " ");
            line = line.replaceAll("\n|\r\n", " ");
            line = line.replaceAll("[\\s]{2,}", " ");
//            String[] lineWithoutPunct = line.split("\n");
               lines[i] = line;
            //    System.out.println(line);


//            for (String arg : secondLines) {
//                   if (!arg.isEmpty()) {
//                System.out.println(arg);
////                    }
////
////                }
//
//
//                   }


            // StringBuilder sb = new StringBuilder(Poem.text);
            // Pattern pattern = Pattern.compile("[а-яА-ЯёЁ][^\\p{Punct}][^\\s]");
            // Matcher matcher = pattern.matcher(Poem.text);
            //  while (matcher.find()) {
        }
        for (int k = 0; k < lines.length - 1; k++) {
            for (int j = k + 1; j < lines.length; j++) {
                if (lines[j].length() <= lines[k].length()) {
                    String temp = lines[k];
                    lines[k] = lines[j];
                    lines[j] = temp;
                }
            }
        }
        String result = "";

        for (int i = 5; i < lines.length-3; i++) {
            if (lines[i].length() == lines[i+1].length()){
                continue;
            }
            result = result.concat(lines[i] + "\n");
        }
        System.out.println(result);

//        for (String arg : lines) {
//            if (!arg.isEmpty()) {
//                System.out.println(arg);
////                    }
////
//                }
//
//                  }
           }
        }







