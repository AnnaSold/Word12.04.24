import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] massiv1;
        String[] massiv2;
        massiv1 = readFile("INPUT.TXT");
        String s = findOftenWord(massiv1);
        //massiv2 = readFile("Dict.txt");
        List dict = readFile2("Dict.txt");
        //System.out.println(s);
        for (Object m:dict){
            System.out.println(m);

        }
    }

    public static String[] readFile(String fname) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fname));
        //scan.nextLine();
        // String[] massiv= new String[n];

        String str = scan.nextLine();
        String[] massiv = str.split(" ");

        scan.close();
        return massiv;
    }


    public static String findOftenWord(String[] massiv) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < massiv.length; i++) {
            if (h.containsKey(massiv[i])) {
                h.replace(massiv[i], h.get(massiv[i]) + 1);
            } else {
                h.put(massiv[i], 1);
            }
        }
        String s = null;
        int p = 0;
        for (String w : h.keySet()) {
            if (p < h.get(w)) {
                p = h.get(w);
                s = w;
            }
        }
        String word = s;
        return word;
    }
    public static List replacaWords(List spisokDict){
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < spisokDict.size(); i++) {
            if (h.containsKey(spisokDict.get(i))) {
                h.replace(spisokDict.get(i), h.get(spisokDict.get(i)) + 1);
            } else {
                h.put(spisokDict.get(i), 1);
            }
        }
        String s = null;
        int p = 0;
        for (String w : h.keySet()) {
            if (p < h.get(w)) {
                p = h.get(w);
                s = w;
            }
        }

        return spisokDict;

    }


    public static List readFile2(String fname) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fname));
        //scan.nextLine();
        // String[] massiv= new String[n];
        List dict = new ArrayList<>();
        while (scan.hasNext()){
            String str = scan.nextLine();
            dict.add(str);
        }

        scan.close();
        return dict;
    }
}