/*
Напишите, пожалуйста, программу на любом языке программирования,
которая поместит + , -  или ничего
в промежутках между цифрами от 9 до 0 (в таком порядке) так,
чтобы в результате получилось 200.
Например: 98+76-5+43-2-10=200.
*/

import java.util.ArrayList;
import java.util.List;

public class TaskProgLab {

    public static char[][] allVariations(char[] array, int var) {
        int len = array.length;
        int perm = (int) Math.pow(len, var);
        char[][] res = new char[perm][var];

        for (int i = 0; i < var; i++) {
            int v = (int) Math.pow(len, i);
            for (int n = 0; n < perm; ) {
                for (int a = 0; a < len; a++) {
                    for (int m = 0; m < v; m++) {
                        res[n][i] = array[a];
                        n++;
                    }
                }
            }
        }

        return res;
    }

    public static String mergeChars(char[] str, char[] var) {
        char res[] = new char[str.length + var.length];
        int j = 0, k = 0;

        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = str[j];
                j++;
            } else {
                res[i] = var[k];
                k++;
            }
        }

        return new String(res).replace(" ", "");
    }

    public static long evaluate(String str) {
        String opsRegExp = "[\\+\\-]";
        String numRegExp = "[^[0-9]+$]";
        String[] strArr = str.split(opsRegExp);
        long res = Long.parseLong(strArr[0]);

        if (strArr.length > 1) {
            String[] opsArr = str.split(numRegExp);
            int j = 1;

            for (int i = 0; i < opsArr.length; i++) {
                if (opsArr[i].equals("-")) {
                    res -= Long.parseLong(strArr[j]);
                    j++;
                }
                if (opsArr[i].equals("+")) {
                    res += Long.parseLong(strArr[j]);
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 200;
        char[] str = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
        char[] ops = {' ', '+', '-'};

        // Всего вариантов: 3^9 = 19683

        char[][] variations = allVariations(ops, 9);
       // System.out.println(variations.length);

        List<String> result = new ArrayList<>();


        for (char[] var : variations) {
            String s = mergeChars(str, var);
            long eval = evaluate(s);
            if (eval == n) {
                result.add(s);
            }
        }

        // System.out.println(result.size());
        System.out.println(result);

    }
}
