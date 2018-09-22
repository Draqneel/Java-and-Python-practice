package ru.ivmiit;

public class Main {

    public static void main(String[] args) {
        // NORTH - Север (0 ; +1), SOUTH - Юг(0 ; -1), EAST - Восток(1 ; 0), WEST - Запад(-1 ; 0);
        // Вверх - Вниз - Вниз - Вправо - Влево - Вверх - Влево
        // Вверх - Вниз - Вниз - Вправо - Влево - Верх - []
        for (String str : dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})) {
            System.out.println(str);
        }
    }

    public static String[] dirReduc(String[] arr) {
        // Your code here.
        int x = 0;
        int y = 0;
        int actualIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == "NORTH") {
                y++;
            }
            if (arr[i] == "SOUTH") {
                y--;
            }
            if (arr[i] == "EAST") {
                x++;
            }
            if (arr[i] == "WEST") {
                x--;
            }
            if (x == 0 && y == 0) {
                actualIndex = i;
            }
        }
        if (actualIndex + 1 >= arr.length) {
            return new String[]{};
        } else {
            actualIndex++;
        }
        int resultLength = arr.length - actualIndex;
        String[] result = new String[resultLength];
        for (int i = actualIndex; i < arr.length; i++) {
            result[i - actualIndex] = arr[i];
        }
        return result;
    }
}