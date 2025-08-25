import java.util.ArrayList;
import java.util.Scanner;

// Class quản lý News với menu
public class NewsManager {
    private ArrayList<News> newsList;
    private Scanner scanner;
    private int nextId;

    public NewsManager() {
        newsList = new ArrayList<>();
        scanner = new Scanner(System.in);
        nextId = 1;
    }

    // Hiển thị menu
    public void showMenu() {
        System.out.println("\nNews management");
        System.out.println("1 - Insert news");
        System.out.println("2 - View list news");
        System.out.println("3 - Average rate");
        System.out.println("4 - Exit");
        System.out.print("Please enter (1-4): ");
    }

    // 4.a - Nhập news
    public void insertNews() {
        System.out.println("\nInsert new news: ");

        System.out.print("Enter title: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        System.out.print("Enter publish date (dd/MM/yyyy): ");
        String publishDate = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        // Tạo đối tượng News mới
        News news = new News(nextId++, title, publishDate, author, content);

        // Nhập 3 đánh giá
        System.out.println("\nEnter 3 rates");
        for (int i = 0; i < 3; i++) {
            int rate;
            do {
                System.out.print("Rate point " + (i + 1) + " (1-10): ");
                rate = scanner.nextInt();
                if (rate < 1 || rate > 10) {
                    System.out.println("Rate point must be between 1 and 10!");
                }
            } while (rate < 1 || rate > 10);

            news.setRate(i, rate);
        }

        // Thêm vào ArrayList
        newsList.add(news);
        System.out.println("\nAdd new news successfully!");
        System.out.println("ID: " + news.getId() + " | Average Rate: " +
                String.format("%.2f", news.getAverageRate()));
    }

    // 4.b & 4.c - View list news
    public void viewListNews() {
        if (newsList.isEmpty()) {
            System.out.println("\nNews list is empty!");
            return;
        }

        System.out.println("\nNews list:");
        System.out.println("Total list: " + newsList.size());

        for (int i = 0; i < newsList.size(); i++) {
            System.out.println("\nNews " + (i + 1) + " ---");
            newsList.get(i).display();
        }
    }

    // 4.d - Average rate (tương tự như mục 5)
    public void showAverageRate() {
        if (newsList.isEmpty()) {
            System.out.println("\nNews list is empty!");
            return;
        }

        System.out.println("\nAverage rate:");

        // Tính tổng điểm đánh giá của tất cả tin tức
        float totalRate = 0;
        for (News news : newsList) {
            // Gọi calculate() để đảm bảo averageRate được tính đúng
            news.calculate();
            totalRate += news.getAverageRate();

            System.out.println("ID " + news.getId() + " - " + news.getTitle() +
                    ": " + String.format("%.2f", news.getAverageRate()) + " points");
        }

        float overallAverage = totalRate / newsList.size();
        System.out.println("Average rate: " +
                String.format("%.2f", overallAverage) + " points");
    }

    // Method chạy chương trình chính
    public void run() {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    showAverageRate();
                    break;
                case 4:
                    System.out.println("Thanks for using NewsManager!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
