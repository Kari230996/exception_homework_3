import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия, Имя, Отчество, номер телефона):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 4) {
            System.err.println("Ошибка: неверное количество данных");
            return;
        }

        String surname = data[0];
        String firstName = data[1];
        String middleName = data[2];
        long phoneNumber;

        try {
            phoneNumber = Long.parseLong(data[3]);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат номера телефона");
            return;
        }

        String filename = surname + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(surname + firstName + middleName + phoneNumber);
            writer.newLine();
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении-записи файла:");
            e.printStackTrace();
        }
    }
}
