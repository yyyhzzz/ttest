package ttest;

public class CodeTest1 {
    /**
     * 测试题 1
     */
    public static void main(String[] args) {
        String str = "abbcccbba";
        System.out.println(compact(str));
    }

    public static String compact(String str) {
        // 将字符串装入容器
        StringBuilder sb = new StringBuilder(str);
        // 定义连续重复字母次数
        int count = 1;
        for (int i = 1; i < sb.length(); i++) {
            // 相邻字符相同，则count加一
            if (sb.charAt(i - 1) == sb.charAt(i)) {
                count++;
            } else {
                if (count > 2) {
                    sb.delete(i - count, i);
                    // 删除后，设置i为1，保证重新校验字符串
                    i = 0;
                }
                count = 1;
            }
            if (i == sb.length() - 1 && count > 2) {
                sb.delete(i + 1 - count, i + 1);
                i = 0;
            }
        }
        return sb.toString();
    }
}
