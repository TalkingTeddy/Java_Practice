public class Palindrome {
    public static String CheckString(String str) {
        
        // Intitialization
        int n = str.length();
        str = str.toLowerCase();
        // System.out.println(str);
        System.out.println("length of string " + n);
        int low  = 0;
        int high = n-1;
        boolean flag = true;

        // System.out.println(str.charAt(high));
        // Checking if string is Palindrome
        
        while (high > low) {
            
            if (str.charAt(low) != str.charAt(high)) {
                flag = false; 
                break;
            } else {
                flag = true;
            }
            high--;
            low++;
        }
        System.out.println(flag);

        // Palindrom Output
        if (flag == true) {
            return "Palindrome";
        } else {
            return "Not a Palindrome";
        }

    }

    public static void main(String[] args) {
        String a = CheckString("CivfgVic");
        System.out.println(a);
        
    }
}
