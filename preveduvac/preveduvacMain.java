package preveduvac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class preveduvacMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OBHT<String, String> dictionary = new OBHT<>(997);

        int n = Integer.parseInt(br.readLine());

        //br.readLine();

        for(int i=0; i<n; i++){
            String parts[] = br.readLine().split(" ");
            String macedonian = parts[0];
            String english = parts[1];
            dictionary.insert(english, macedonian);
        }

        while(true){
            String english = br.readLine();
            if(english.equals("KRAJ"))
                break;

            int index = dictionary.search(english);
            if(index == -1){
                System.out.println("/");
            }else {
                System.out.println(dictionary.atIndex(index).value);
            }
        }

    }

}
