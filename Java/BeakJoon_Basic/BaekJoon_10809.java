package BeakJoon_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_10809 {
    public static void main(String[] args) throws IOException {
        Character[] words = {'a', 'b' , 'c', 'd' , 'e', 'f' , 'g', 'h' , 'i', 'j' , 'k', 'l' , 'm', 'n' , 'o', 'p' ,
            'q', 'r', 's', 't' , 'u', 'v', 'w', 'x' , 'y', 'z'};
        int[] wordNum = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            wordNum[i] = -1;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        Character[] temp = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (words[i].equals(temp[j]) && wordNum[i] == -1) wordNum[i] = j;
            }
        }

        for (int i = 0; i < wordNum.length; i++) {
            System.out.print(wordNum[i] + " ");
        }
    }
}
