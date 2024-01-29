import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;

    public LinkShortener() {
        this.shortToLongMap = new HashMap<>();
        this.longToShortMap = new HashMap<>();
    }

    // Basic hash function for generating short URLs
    private String generateShortUrl(String longUrl) {
        int hashCode = longUrl.hashCode();
        String shortUrl = Integer.toHexString(hashCode);
        return shortUrl.substring(0, 6); // Use the first 6 characters as the short URL
    }

    // Shorten a long URL and handle collisions
    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);
        while (shortToLongMap.containsKey(shortUrl)) {
            // Collision occurred, regenerate short URL
            shortUrl = generateShortUrl(longUrl);
        }

        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Expand a short URL to its original form
    public String expandUrl(String shortUrl) {
        return shortToLongMap.getOrDefault(shortUrl, "Short URL not found");
    }

    // Simple command-line interface for user interaction
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option(1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = linkShortener.shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                case 2:
                    System.out.print("Enter the short URL: ");
                    String inputShortUrl = scanner.nextLine();
                    String expandedUrl = linkShortener.expandUrl(inputShortUrl);
                    System.out.println("Expanded URL: " + expandedUrl);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
