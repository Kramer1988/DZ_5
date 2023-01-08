import java.util.ArrayList;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

 /*       Задание
        Все задания, описанные ниже должны быть выполнены с помощью Java 8 Stream API.
        1. Напишите метод, который на вход принимает диапазон лет,
                возвращает список високосных годов в этом диапазоне.
        Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
        2. Напишите метод, который на вход принимает целое число(количество зарплат)
        и возвращает список вещественных чисел,
                состоящих из случайных зарплат, распределенных по закону нормального распределения.
        Примечание:
        У нормального распределения есть два параметра: mean(среднее значение)  и std(среднее отклонение).
        У класса Random есть метод nextGaussian(),
                который генерирует нормально распределенное число с параметрами mean=0, std=1.
        Для генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои).
        Используйте такую формулу генерации: случайная зарплата = nextGaussian() * std + mean.
  */

        int year = 2000, years = 2050;
        int salary = 5;


        System.out.printf("\nСписок високосных годов в диапазоне от %d и до %d годов\n", year, years);
        System.out.println(rangeOfYears(year, years));

        System.out.println("Список случайных зарплат");
        System.out.println(realNumbers(salary));


    }


    //  1. Напишите метод, который на вход принимает диапазон лет,
    //        возвращает список високосных годов в этом диапазоне.
    //        Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
    private static ArrayList<Integer> rangeOfYears(int year, int years) {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(year, years)
                .filter(num -> num % 400 == 0 || num % 4 == 0 && num % 100 != 0)
                .forEachOrdered(list::add);
        return list;
    }

    /*2. Напишите метод, который на вход принимает целое число(количество зарплат)
      и возвращает список вещественных чисел,
      состоящих из случайных зарплат, распределенных по закону нормального распределения.
      Примечание:
      У нормального распределения есть два параметра: mean(среднее значение)  и std(среднее отклонение).
      У класса Random есть метод nextGaussian(),
      который генерирует нормально распределенное число с параметрами mean=0, std=1.
      Для генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои).
      Используйте такую формулу генерации: случайная зарплата = nextGaussian() * std + mean.
  */
    private static ArrayList<Double> realNumbers(int salary) {
        Random random = new Random();
        double mean = 1000 + (Math.random()) * 10000;
        double std = 1000 + (Math.random()) * 10000;
        ArrayList<Double> numb = new ArrayList<>();
        DoubleStream.generate(() -> random.nextGaussian(0, 1) * std + mean)
                .limit(salary)
                .forEachOrdered(numb::add);
        return numb;
    }


}