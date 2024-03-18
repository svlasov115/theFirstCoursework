import java.util.Random;

public class App {
    private final static Employee[] EMPLOYEES = new Employee[10];
    private final static Random RANDOM = new Random();
    private final static String[] MALE_SURNAMES = {"Акимов", "Белоусов", "Черепанов", "Попов", "Самойлов"};
    private final static String[] MALE_NAMES = {"Степан", "Фёдор", "Семён", "Василий", "Марк"};
    private final static String[] MALE_PATRONYMICS = {"Львович", "Маркович", "Николаевич", "Маратович", "Дмитриевич"};

    private static Employee generateEmployee() {
        return new Employee(
                MALE_SURNAMES[RANDOM.nextInt(MALE_NAMES.length)] + " " +
                        MALE_NAMES[RANDOM.nextInt(MALE_SURNAMES.length)] + " " +
                        MALE_PATRONYMICS[RANDOM.nextInt(MALE_PATRONYMICS.length)],
                RANDOM.nextInt(1, 6),
                RANDOM.nextInt(79_000, 270_000)
        );
    }

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }

        printEmployees();
        printFullNameOfEmployees();
        System.out.println("Сумма затрат на заработную плату в месяц: " + calculateSumOfSalaryExpensesOfEmployees());
        System.out.println("Средняя заработная плата сотрудника в месяц: " + calculateAverageSalaries());
        System.out.println("Сотрудник с максимальной заработной платой в месяц: " + findEmployeeWithMaxSalary());
        System.out.println("Сотрудник с минимальной заработной платой в месяц: " + findEmployeeWithMinSalary());
    }

    private static void printEmployees() {
        System.out.println("Информация о сотрудниках:");

        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaryExpensesOfEmployees() {
        int sum = 0;

        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }

        return sum;
    }

    /*
     * Метод поиска сотрудника с минимальной заработной платой
     * @return сотрудник с минимальной заработной платой, или null, если такого сотрудника не нашлось.
     */
    public static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        int minSalary = Integer.MAX_VALUE;

        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    /*
     * Метод поиска сотрудника с максимальной заработной платой
     * @return сотрудник с максимальной заработной платой, или null, если такого сотрудника не нашлось.
     */
    public static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        int maxSalary = Integer.MIN_VALUE;

        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }

        return employeeWithMaxSalary;
    }

    public static double calculateAverageSalaries() {
        return (double) calculateSumOfSalaryExpensesOfEmployees() / EMPLOYEES.length;
    }

    /*
     * Метод перевода строки
     */
    private static void translateString() {
        System.out.print("\n");
    }

    private static void printFullNameOfEmployees() {
        translateString();
        System.out.println("ФИО сотрудников:");


        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }

        translateString();
    }
}