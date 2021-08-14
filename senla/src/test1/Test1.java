package test1;
public class Test1 {

    public int noOfTriples(String stng)
    {
        int l = stng.length();
        int ctr = 0;
        for (int i = 0; i < l-2; i++)
        {
            char tmp = stng.charAt(i);
            if (tmp == stng.charAt(i+1) && tmp == stng.charAt(i+2))
                ctr++;
        }
        return ctr;
    }

    public static void main(String[] args){
        Main m= new Main();
        String str1 =  "welllcommmmeee";
        System.out.println("The given string is: "+str1);
       System.out.println("The number of triples in the string is: "+m.noOfTriples(str1));
    }
}
