import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task {
    public static void main(String[] args) {
        String roles = "Городничий\n" +
                "Аммос Федорович\n" +
                "Артемий Филиппович\n" +
                "Лука Лукич";
        String[] rolesMatrix = roles.split("\n");
        String textLines = "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
                "Аммос Федорович: Как ревизор?\n" +
                "Артемий Филиппович: Как ревизор?\n" +
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
                "Аммос Федорович: Вот те на!\n" +
                "Артемий Филиппович: Вот не было заботы, так подай!\n" +
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!";
        String[] textMatrix = textLines.split("\n");
        System.out.println(printTextPerRole(rolesMatrix, textMatrix));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        String[] result = new String[roles.length + textLines.length];
        int numberOfLine=0;
        for (int i = 0; i < roles.length; i++) {
            result[numberOfLine]=roles[i]+"\n";
            numberOfLine++;
            for(int j=0; j<textLines.length; j++){
                Pattern detectRole = Pattern.compile(roles[i]);
                Matcher detecter = detectRole.matcher(textLines[j]);
                if (detecter.find()){
                    result[numberOfLine]=textLines[j]+"\n";
                    numberOfLine++;
                }
            }
        }
        return Arrays.toString(result);
    }
}
