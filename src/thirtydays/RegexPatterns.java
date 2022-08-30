package thirtydays;
import java.io.*;
        import java.util.*;
        import java.util.regex.*;

public class RegexPatterns {

    public static String isNameInAccountMail(String emailID, String firstName){
        String myregexpr= firstName+"+@gmail.com$";
        Pattern pattern = Pattern.compile(myregexpr);
        Matcher m = pattern.matcher(emailID);

        return  (m.find()) ? firstName : "";

    }

    public static void validateAccounts(Map<String, String> accounts){
        List<String> namesToPrint = new ArrayList<>();
        for (Map.Entry<String, String> a : accounts.entrySet()) {
            if (isNameInAccountMail(a.getKey(), a.getValue()).equals(a.getValue())){
                namesToPrint.add(a.getValue());
            }
        }
        namesToPrint.stream().sorted().forEachOrdered(s -> System.out.println(s));

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> mapa =  new HashMap<>();
        mapa.put("julia@julia.com", "julia");
        mapa.put("julia@gmail.com", "julia");
        mapa.put("riya@gmail.com", "riya");
        mapa.put("sjulia@gmail.com", "julia");
        mapa.put("samantha@gmail.com", "samantha");
        mapa.put("tanya@gmail.com", "tanya");
        validateAccounts(mapa);





        bufferedReader.close();
    }
}
