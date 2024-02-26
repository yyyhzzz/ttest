package ttest;

public class CodeTest2 {
    /**
     * 测试题 2
     */
    public static void main(String[] args) {
        String str = "abcccbad";
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
                    // 得到删除字符，判断是否为a：不为a则添加字符-1对应字符；为a则直接删除
                    int c = sb.charAt(i - count) - 1;
                    sb.delete(i - count, i);
                    if (c >= 97) {
                        char beforeC = (char) c;
                        sb.insert(i - count, beforeC);
                    }
                    // 删除后，设置i为0，保证重新校验字符串
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
