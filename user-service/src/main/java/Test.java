public class Test {


    public static void main(String[] args) {


        char[] chars = "altmas".toCharArray();
        int endIndex = chars.length - 1;

        System.out.println(rev(endIndex,new StringBuilder(),chars).toString());

    }

    private static StringBuilder stringRev(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }

        return builder;
    }


    private static String rev(int index, StringBuilder builder, char[] arr) {
        //altmas
        if (index >= 0) {
            builder.append(arr[index]);
            index -= 1;
            rev(index, builder, arr);
        }
        return builder.toString();
    }

    private static void fun(int i) {
        if (i > 10)
            return;
        System.out.println(i);
        fun(i += 1);

    }
}
