package test1;

public class Main {
    public int noOfTriples(String stng)
        {
            int l = stng.length();
            int ctr = 0;
            for (int i = 0; i < l - 2; i++)
            {
                char tmp = stng.charAt(i);
                if (tmp == stng.charAt(i + 1) && tmp == stng.charAt(i + 2))
                    ctr++;
            }
            return ctr;
        }

        public static void main (String[] args)
            {
                Main m = new Main();
                String str1 = "wwwrr   riuyiuhjjj";
                System.out.println("строка" + str1);
                System.out.println("количество троек " + m.noOfTriples(str1));
            }
    }

