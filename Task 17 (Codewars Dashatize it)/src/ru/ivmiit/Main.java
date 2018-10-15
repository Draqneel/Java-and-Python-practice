package ru.ivmiit;

/**
 * SPECIFICATION
 * Given a number, return a string with dash'-'marks before and after each odd integer,
 * but do not begin or end the string with a dash mark.
 * Ex:
 * dashatize(274) -> '2-7-4'
 * dashatize(6815) -> '68-1-5'
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(dashatize(5432));
    }

    public static String dashatize(int num) {
        String result = "";
        boolean lastOdd = false;
        int i = 0;
        int count = 0;
        while (num % 10 != 0){
            count++;
        }
        System.out.println(count);
        while (i <=  count){
            if (i == 0 && (num % 10) % 2 != 0) {
                result += num % 10 + "-";
                num = num / 10;
                i++;
                lastOdd = true;
            } else if (i == count && lastOdd == true) {
                result += num % 10;
                num = num / 10;
            } else if(i == count && lastOdd == false && (num % 10) % 2 != 0){
                result = result + "-" + num % 10;
                num = num / 10;
            } else if ((num % 10) % 2 != 0 && lastOdd == false){
                result = result + "-" + (num % 10) + "-";
                num = num / 10;
                i++;
                lastOdd = true;
            } else if ((num % 10) % 2 != 0 && lastOdd == true){
                result = result + (num % 10) + "-";
                num = num / 10;
                i++;
            } else {
                result += num % 10;
                num = num / 10;
                lastOdd = false;
                i++;
            }
        }
        return result;
    }
}
