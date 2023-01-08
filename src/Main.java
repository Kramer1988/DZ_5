import java.util.ArrayList;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

 /*       �������
        ��� �������, ��������� ���� ������ ���� ��������� � ������� Java 8 Stream API.
        1. �������� �����, ������� �� ���� ��������� �������� ���,
                ���������� ������ ���������� ����� � ���� ���������.
        ����������: ��� ���������� ���� �� ������� �� 400 ��� ������� �� 4 ��� ���� �� ������ �� 100.
        2. �������� �����, ������� �� ���� ��������� ����� �����(���������� �������)
        � ���������� ������ ������������ �����,
                ��������� �� ��������� �������, �������������� �� ������ ����������� �������������.
        ����������:
        � ����������� ������������� ���� ��� ���������: mean(������� ��������)  � std(������� ����������).
        � ������ Random ���� ����� nextGaussian(),
                ������� ���������� ��������� �������������� ����� � ����������� mean=0, std=1.
        ��� ��������� ������� ���������� ���������: std = 11190, mean = 29267(������ ����������� ����).
        ����������� ����� ������� ���������: ��������� �������� = nextGaussian() * std + mean.
  */

        int year = 2000, years = 2050;
        int salary = 5;


        System.out.printf("\n������ ���������� ����� � ��������� �� %d � �� %d �����\n", year, years);
        System.out.println(rangeOfYears(year, years));

        System.out.println("������ ��������� �������");
        System.out.println(realNumbers(salary));


    }


    //  1. �������� �����, ������� �� ���� ��������� �������� ���,
    //        ���������� ������ ���������� ����� � ���� ���������.
    //        ����������: ��� ���������� ���� �� ������� �� 400 ��� ������� �� 4 ��� ���� �� ������ �� 100.
    private static ArrayList<Integer> rangeOfYears(int year, int years) {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(year, years)
                .filter(num -> num % 400 == 0 || num % 4 == 0 && num % 100 != 0)
                .forEachOrdered(list::add);
        return list;
    }

    /*2. �������� �����, ������� �� ���� ��������� ����� �����(���������� �������)
      � ���������� ������ ������������ �����,
      ��������� �� ��������� �������, �������������� �� ������ ����������� �������������.
      ����������:
      � ����������� ������������� ���� ��� ���������: mean(������� ��������)  � std(������� ����������).
      � ������ Random ���� ����� nextGaussian(),
      ������� ���������� ��������� �������������� ����� � ����������� mean=0, std=1.
      ��� ��������� ������� ���������� ���������: std = 11190, mean = 29267(������ ����������� ����).
      ����������� ����� ������� ���������: ��������� �������� = nextGaussian() * std + mean.
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