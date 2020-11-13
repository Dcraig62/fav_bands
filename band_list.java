

import java.util.Scanner;
import java.util.ArrayList;

public class band_list {
    public static void main(String[] args){
        System.out.println("Band Ratings List: ");
        String choice= "A";
        Scanner myObj = new Scanner(System.in);
        ArrayList<String> alist = new ArrayList<String>();
        while(!choice.equals("Q")){
            displayOptions();
            choice = myObj.nextLine();
            if (!choice.equals("Q"))
                options(choice, alist);
        }
    }
    static void displayOptions(){
        System.out.println("Enter one of the following options: ");
        System.out.println("A - to add a band");
        System.out.println("L - to display the list");
        System.out.println("S - to search a band");
        System.out.println("R - to remove a band");
        System.out.println("Q - to quit");
    }
    static void options(String x, ArrayList<String> alist){
        int count = 0;
        String name;
        Scanner myObj = new Scanner(System.in);
        if(x.equals("A")){
            System.out.printf("Enter the band name: ");
            name = myObj.nextLine();
            alist.add(name);
        } else if(x.equals("L")){
            count = 1;
            for (String str:alist){
                System.out.println(count + " " + str);
                count++;
            }
        } else if(x.equals("S")){
            System.out.printf("Enter a band name: ");
            name = myObj.nextLine();
            count = search(alist, name);
            if (count > 0)
                System.out.println(count + " " + name);
        } else if(x.equals("R")){
            System.out.printf("Enter the band name: ");
            name = myObj.nextLine();
            count = search(alist, name);
            alist.remove(count - 1);
        } else{
            System.out.println("Not a valid option");
        }

    }
    static int search(ArrayList<String> alist, String name){
        int count = 1;
        boolean found = false;
            for (String str:alist){
                if (str.equals(name)){
                    found = true;
                    break;
                }
                count++;
            }
            if(!found){
                System.out.println("Band not found");
                return 0;
            }
            return count;
        
    }
}
