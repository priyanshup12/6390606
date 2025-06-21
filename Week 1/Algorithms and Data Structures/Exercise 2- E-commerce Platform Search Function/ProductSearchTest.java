public class ProductSearchTest {

    // Helper method to print search result
    public static void printResult(String label, Product result) {
        System.out.println(label + ":");
        if (result != null) {
            System.out.println("Found:" + result);
        } else {
            System.out.println("Not Found");
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1001, "MobilePhone", "Electronics"),
            new Product(1002, "Shirt", "Clothing"),
            new Product(1003, "Television", "Electronics"),
            new Product(1004, "Watch", "Accessories"),
            new Product(1005, "Airsoft", "Toy"),
            new Product(1006, "Notebook", "Stationary"),
            new Product(1007, "Pen", "Stationary")
        };

        System.out.println("====== LINEAR SEARCH TESTS ======\n");

        printResult("Search by ID (Exists)", ProductSearch.linearSearchById(products, 1004));
        printResult("Search by ID (Not Exists)", ProductSearch.linearSearchById(products, 9999));

        printResult("Search by Name (Exists)", ProductSearch.linearSearchByName(products, "Watch"));
        printResult("Search by Name (Not Exists)", ProductSearch.linearSearchByName(products, "Camera"));

        printResult("Search by Category (Exists)", ProductSearch.linearSearchByCategory(products, "Toy"));
        printResult("Search by Category (Not Exists)", ProductSearch.linearSearchByCategory(products, "Furniture"));

        System.out.println("====== BINARY SEARCH TESTS ======\n");

        printResult("Search by ID (Exists)", ProductSearch.binarySearchById(products, 1002));
        printResult("Search by ID (Not Exists)", ProductSearch.binarySearchById(products, 8888));

        printResult("Search by Name (Exists)", ProductSearch.binarySearchByName(products, "Notebook"));
        printResult("Search by Name (Not Exists)", ProductSearch.binarySearchByName(products, "Tablet"));

        printResult("Search by Category (Exists)", ProductSearch.binarySearchByCategory(products, "Stationary"));
        printResult("Search by Category (Not Exists)", ProductSearch.binarySearchByCategory(products, "Appliances"));
    }
}
