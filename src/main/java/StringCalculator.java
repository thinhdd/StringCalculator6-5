import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: RuaTre_IT
 * Date: 6/5/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public int add(String s) {
        int sum=0;
        if(s.isEmpty())
            return 0;
        if(s.contains("//") && s.contains("\n") )
        {
            if(s.contains("[") && s.contains("]"))
            {
                int D1=  s.indexOf("[");
                int D2= s.indexOf("]");
                String cur = s.substring(s.indexOf("\n")+1, s.length());
                String arc[] = cur.split(Pattern.quote(s.substring(D1+1,D2)));
                return Sum(arc);
            }
            else{
                String cur = s.substring(4,s.length());
                String scr[] = cur.split(String.valueOf(s.charAt(2)));
                return Sum(scr);
            }
        }
        if(s.contains("\n,") || s.contains(",\n"))
            return -1;
        if(s.contains(",") && s.contains("\n"))
        {
            String scr[] = s.split("[,\n]");
            return Sum(scr);
        }
        if(s.contains(","))
        {
            String scr[] = s.split(",");
            return Sum(scr);
        }
        return Integer.parseInt(s);  //To change body of created methods use File | Settings | File Templates.
    }
    public int Sum(String acr[])
    {
        int sum=0;
        String list="";
        for(int i=0; i<acr.length;i++)
        {
            if(!acr[i].isEmpty())
            {
                if(Integer.parseInt(acr[i])>0) {
                    if(Integer.parseInt(acr[i])<1000)
                        sum=sum+ Integer.parseInt(acr[i]);
                }
                else
                    list=list+ acr[i] + " ";
            }

        }
        if(list.length()>0)
            throw new IllegalArgumentException(list);
        return sum;
    }
}

class check{
    public static void main(String[] args) {
        String ss = "//[***]\n1***2";
        int D1=  ss.indexOf("[");
        int D2= ss.indexOf("]");
        String cur = ss.substring(ss.indexOf("\n")-1, ss.length());
        System.out.println(ss.substring(D1+1,D2));
        //String arc[] = cur.split(Pattern.quote(ss.substring(D1+1,D2-1)));
    }
}
