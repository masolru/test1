import java.util.Scanner;


 class Main {

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println(" Введите арифметическое выражение типа a + b ");
         String input = scanner.nextLine();

         try {
             String result = calc(input);
             System.out.println("Результат " + result);
         }catch (Exception e){
             System.out.println("Error "+ e.getMessage());
         }


     }

     public static String calc (String input){
        String[] parts = input.split(" ");
            if (parts.length != 3) {
              throw new IllegalArgumentException("Некорректный ввод. Формат ввода: 'число_оператор_число'.");
            }

            String one = parts[0];
            String oper = parts[1];
            String two = parts[2];

            boolean isRomanOne = isRoman(one);
            boolean isRomanTwo = isRoman(two);





            if (isRomanOne != isRomanTwo) {
              throw new IllegalArgumentException("Числа должны быть или только арабскими или только римскими");

            }
            int a, b;
            //сюда надо проверку на совпадение с римскими цифрами и перевод римских в арабские
            if (isRomanOne){
             a= romanToInt(one);
             b=romanToInt(two);
             if (a < 1 || a > 10 || b < 1 || b > 10){
                 throw new IllegalArgumentException(" Цифры от 1 до 10");
             }
            }


            a = Integer.parseInt(one);
            b = Integer.parseInt(two);
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");

            }
            int result;
            switch (oper) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new IllegalArgumentException("Делить на ноль нельзя");
                    }
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный оператор:" + oper);
            }

         return Integer.toString(result);
     }
        static boolean isRoman(String str) {
            return str.matches("[IVX]+");
        }
        static int romanToInt(String s){
            int total = 0;
            int prevValue = 0;

            for (char ch : s.toCharArray()) {
                int value = RomanValue(ch);
                if (value > prevValue) {
                    total += value - 2 * prevValue; // Вырезаем предыдущее значение, так как оно было добавлено
                } else {
                    total += value;
                }
                prevValue = value;
            }
            return total;

        }

        static int RomanValue(char ch){
          switch (ch) {
              case 'I':return  1;
              case 'V':return  5;
              case 'X':return  10;
              case 'L':return  50;
              case 'C':return  100;
              default: throw new IllegalArgumentException("Неккоретный ввод: " + ch);
          }
        }


 }