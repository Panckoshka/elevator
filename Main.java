package elevator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Queue<Integer> elevator = new ArrayDeque<>();
        int previousFloor = -1;

        while (2 * 2 == 4) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int floor = scanner.nextInt();

            if (!elevator.isEmpty() && previousFloor == floor) {
                System.out.println("Повторно введенное значение этажа.");
                continue;
            }

            if (floor < 0 || floor > 25) {
                System.out.println("Такого этажа нет в доме.");
            } else {
                elevator.add(floor);
                if (floor == 0) {
                    break;
                }
            }

            previousFloor = floor;
        }

        System.out.println("Лифт проследовал по следующим этажам: ");

        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 10;
        previousFloor = -1;

        while (!elevator.isEmpty()) {
            System.out.printf("этаж %d ", elevator.peek());

            if (elevator.peek() != 0) {
                System.out.print("-> ");
            }

            if (previousFloor != -1) {
                totalSeconds += Math.abs(elevator.peek() - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            }
            previousFloor = elevator.peek();
            elevator.poll();
        }
        System.out.printf("Время затраченное лифтом на маршрут = %d с.", totalSeconds);
    }
}
