package main.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HexUtil {
    // lab 1
    private int[] addT(String number1, String number2) {
        int[] num1 = toArr(number1); // 123f -> 1, 2, 3, 15
        int[] num2 = toArr(number2); // 12 ->         1, 2
        // [1, 2 5, 1] -> 1251
        int maxLen = Math.max(num1.length, num2.length);
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        for (int i = 1; i <= maxLen; i++) {
            int a = num1.length - i >= 0 ? num1[num1.length - i] : 0;
            int b = num2.length - i >= 0 ? num2[num2.length - i] : 0;
            int temp = a + b + carry;
            result.add(temp & 15);
            carry = temp >> 4;
        }
        if (carry > 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public String add(String number1, String number2) {
        return toStr(addT(number1, number2));
    }

    private int[] subT(String number1, String number2) {
        int[] num1;
        int[] num2;
        if (compare(number1, number2) == 1) {
            num1 = toArr(number1);
            num2 = toArr(number2);
        } else if (compare(number1, number2) == -1) {
            num1 = toArr(number2);
            num2 = toArr(number1);
        } else {
            return new int[]{0};
        }
        int maxLen = Math.max(num1.length, num2.length);
        List<Integer> result = new ArrayList<>();
        int borrow = 0;

        for (int i = 1; i <= maxLen; i++) {
            int a = num1.length - i >= 0 ? num1[num1.length - i] : 0;
            int b = num2.length - i >= 0 ? num2[num2.length - i] : 0;
            int temp = a - b - borrow;

            if (temp >= 0) {
                borrow = 0;
                result.add(temp);
            } else {
                if (maxLen == 1 || (borrow == 1 && maxLen == i)) {
                    result.add(Math.abs(temp));
                } else {
                    result.add(16 + temp);
                }
                borrow = 1;
            }
        }
        Collections.reverse(result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public String sub(String number1, String number2) {
        String sign = compare(number1, number2) == -1 ? "-" : "";
        return sign + toStr(subT(number1, number2)).replaceFirst("^0+(?!$)", "");
    }

    private int[] subTBin(String number1, String number2) {
        int[] num1;
        int[] num2;
        if (compare(number1, number2) == 1) {
            num1 = toArr(number1);
            num2 = toArr(number2);
        } else if (compare(number1, number2) == -1) {
            num1 = toArr(number2);
            num2 = toArr(number1);
        } else {
            return new int[]{0};
        }

        int maxLen = Math.max(num1.length, num2.length);
        List<Integer> result = new ArrayList<>();
        int borrow = 0;

        for (int i = 1; i <= maxLen; i++) {
            int a = num1.length - i >= 0 ? num1[num1.length - i] : 0;
            int b = num2.length - i >= 0 ? num2[num2.length - i] : 0;
            int temp = a - b - borrow;

            if (temp >= 0) {
                borrow = 0;
                result.add(temp);
            } else {
                if (maxLen == 1 || (borrow == 1 && maxLen == i)) {
                    result.add(Math.abs(temp));
                } else {
                    result.add(2 + temp);
                }
                borrow = 1;
            }
        }
        Collections.reverse(result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public String subBin(String number1, String number2) {
        String sign = compare(number1, number2) == -1 ? "-" : "";
        return sign + toStr(subTBin(number1, number2)).replaceFirst("^0+(?!$)", "");
    }

    public String mulOne(String number, int b, int zero) {
        int[] num = toArr(new StringBuilder(number).reverse().toString());
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < zero; i++) {
            res.add(0);
        }
        for (int i = 0; i < num.length; i++) {
            int temp = num[i] * b + carry;
            carry = temp / 16;
            res.add(temp % 16);
        }
        if (carry != 0)
            res.add(carry);
        Collections.reverse(res);


        return toStr(res.stream().mapToInt(i -> i).toArray());
    }

    public String mul(String number1, String number2) {
        int[] num2 = toArr(new StringBuilder(number2).reverse().toString());
        String res = "0";

        for (int i = 0; i < num2.length; i++) {
            res = add(mulOne(number1, getInt(number2, i), i), res);
        }

        return res;
    }

    public String square(String number) {
        return mul(number, number);
    }

    public String pow(String number, String exp) {
        String res = "1";
        String binExp = new BigInteger(exp, 16).toString(2);
        int[] b = toArr(binExp);

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1)
                res = mul(res, number);
            if (i != b.length - 1)
                res = square(res);
        }

        return res;
    }

    public String[] LongDivMod(String up, String down) {
        if (compare(up, down) == 0)
            return new String[]{"1", "0"};
        if (compare(up, down) == -1)
            return new String[]{"0", up};
        if (up.equals("0") || down.equals("0"))
            return new String[]{"0", "0"};

        String r = up;
        String q = "0";

        String[] res = new String[2];

        int i = up.length() - down.length();

        while (i >= 0) {
            String c = shiftToHigh(down, i);

            while (compare(sub(r, c), "0") == 1) {
                r = sub(r, shiftToHigh(down, i));
                q = add(q, shiftToHigh("1", i));
            }

            i = i - 1;
        }
        if (compare(r, down) == 0) {
            q = add(q, "1");
            r = "0";
        }

        res[0] = q; // div
        res[1] = r; // mod

        return res;
    }

    public String divide(String number1, String number2) {
        return LongDivMod(number1, number2)[0];
    }

    public String mod(String number1, String number2) {
        return LongDivMod(number1, number2)[1];
    }

    public int compare(String number1, String number2) { // 1, 0, -1
        if (number1.charAt(0) == '-' && number2.charAt(0) != '-') return -1;
        if (number2.charAt(0) == '-' && number1.charAt(0) != '-') return 1;

        int[] num1 = toArr(number1);
        int[] num2 = toArr(number2);
        if (num1.length > num2.length) return 1;
        if (num2.length > num1.length) return -1;

        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num2[i]) return 1;
            if (num2[i] > num1[i]) return -1;
        }

        return 0;
    }

    // lab 2
    public String gcd(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0"))
            return "0";
        if (num1.equals("0"))
            return num2;
        if (num2.equals("0"))
            return num1;

        String d = "1";

        while (even(num1) && even(num2)) {
            num1 = divide(num1, "2");
            num2 = divide(num2, "2");
            d = mul(d, "2");
        }

        while (even(num1)) {
            num1 = divide(num1, "2");
        }

        while (compare(num2, "0") != 0) {
            while (even(num2)) {
                num2 = divide(num2, "2");
            }

            String tempA = num1;
            String tempB = num2;

            num1 = compare(tempA, tempB) == 1 ? tempB : tempA;
            num2 = compare(tempA, tempB) == 1 ? sub(tempA, tempB) : sub(tempB, tempA);
        }
        return mul(d, num1);
    }

    public String lcm(String num1, String num2) {
        return divide(mul(num1, num2), gcd(num1, num2));
    }

    public String barretReduction(String x, String p, String u) {
        int k = p.length();
        String q = "";

        q = killLastDigits(x, k - 1);
        q = mul(q, u);
        q = killLastDigits(q, k + 1);
        String r = sub(x, mul(q, p));

        while (compare(r, p) >= 0) {
            r = sub(r, p);
        }
        return r;
    }

    public String add(String number1, String number2, String n) {
        String u = divide(shiftToHigh("1", 2 * n.length()), n);
        System.out.println(shiftToHigh("1", 2 * n.length()));
        return barretReduction(add(number1, number2), n, u);
    }

    public String sub(String number1, String number2, String n) {
        String u = divide(shiftToHigh("1", 2 * n.length()), n);
        String temp = sub(number1, number2);

        System.out.println(temp);

        if (compare(temp, "0") == -1) {
            temp = temp.substring(1);
            String resTemp = barretReduction(temp, n, u);
            String sTemp = sub(n, resTemp);

            System.out.println("1 " + temp);
            System.out.println("2 " + resTemp);
            System.out.println("3 " + sTemp);

            return sTemp;
        }

        return barretReduction(temp, n, u);
    }

    public String mul(String number1, String number2, String n) {
        String u = divide(shiftToHigh("1", 2 * n.length()), n);

        return barretReduction(mul(number1, number2), n, u);
    }

    public String square(String number1, String n) {
        return mul(number1, number1, n);
    }

    public String pow(String number, String exp, String n) {
        String res = "1";
        String u = divide(shiftToHigh("1", 2 * n.length()), n);

        String binExp = new BigInteger(exp, 16).toString(2);
        int[] b = toArr(binExp);

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1)
                res = barretReduction(mul(res, number), n, u);
            if (i != b.length - 1)
                res = barretReduction(square(res), n, u);
        }

        return res;
    }

    public String shiftToHigh(String num, int zero) {
        return num + "0".repeat(Math.max(0, zero));
    }

    public String killLastDigits(String num, int k) {
        return Optional.ofNullable(num)
                .filter(str -> !str.isEmpty())
                .map(str -> str.substring(0, str.length() - k))
                .orElse(num);
    }

    public int getInt(String number, int i) {
        String num = new StringBuilder(number).reverse().toString();
        char temp = num.charAt(i);

        return switch (temp) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;

            case 'a', 'A' -> 10;
            case 'b', 'B' -> 11;
            case 'c', 'C' -> 12;
            case 'd', 'D' -> 13;
            case 'e', 'E' -> 14;
            case 'f', 'F' -> 15;

            default -> throw new IllegalArgumentException();
        };
    }

    public boolean even(String num) {
        char ch = num.charAt(num.length() - 1);

        return switch (ch) {
            case '0', '2', '4', '6', '8', 'a', 'A', 'c', 'C', 'e', 'E' -> true;
            default -> false;

        };
    }

    public String toStr(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int j : arr) {
            switch (j) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> sb.append(j);
                case 10 -> sb.append("A");
                case 11 -> sb.append("B");
                case 12 -> sb.append("C");
                case 13 -> sb.append("D");
                case 14 -> sb.append("E");
                case 15 -> sb.append("F");
                default -> throw new IllegalArgumentException();
            }
        }
        return sb.toString();
    }

    public int[] toArr(String num) {
        char[] temp = num.toCharArray();
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '0')
                res[i] = 0;
            else if (temp[i] == '1')
                res[i] = 1;
            else if (temp[i] == '2')
                res[i] = 2;
            else if (temp[i] == '3')
                res[i] = 3;
            else if (temp[i] == '4')
                res[i] = 4;
            else if (temp[i] == '5')
                res[i] = 5;
            else if (temp[i] == '6')
                res[i] = 6;
            else if (temp[i] == '7')
                res[i] = 7;
            else if (temp[i] == '8')
                res[i] = 8;
            else if (temp[i] == '9')
                res[i] = 9;
            else if (temp[i] == 'a' || temp[i] == 'A')
                res[i] = 10;
            else if (temp[i] == 'b' || temp[i] == 'B')
                res[i] = 11;
            else if (temp[i] == 'c' || temp[i] == 'C')
                res[i] = 12;
            else if (temp[i] == 'd' || temp[i] == 'D')
                res[i] = 13;
            else if (temp[i] == 'e' || temp[i] == 'E')
                res[i] = 14;
            else if (temp[i] == 'f' || temp[i] == 'F')
                res[i] = 15;
            else {
                throw new IllegalArgumentException();
            }
        }
        return res;
    }
}
