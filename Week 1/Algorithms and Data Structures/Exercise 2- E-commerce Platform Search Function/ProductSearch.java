import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // ---------- LINEAR SEARCH METHODS ----------

    public static Product linearSearchById(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product linearSearchByName(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product linearSearchByCategory(Product[] products, String targetCategory) {
        for (Product product : products) {
            if (product.category.equalsIgnoreCase(targetCategory)) {
                return product;
            }
        }
        return null;
    }

    // ---------- BINARY SEARCH METHODS ----------

    public static Product binarySearchById(Product[] products, int targetId) {
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static Product binarySearchByName(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midName = products[mid].productName.toLowerCase();

            if (midName.equals(targetName.toLowerCase())) {
                return products[mid];
            } else if (midName.compareTo(targetName.toLowerCase()) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static Product binarySearchByCategory(Product[] products, String targetCategory) {
        Arrays.sort(products, Comparator.comparing(p -> p.category.toLowerCase()));
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midCategory = products[mid].category.toLowerCase();

            if (midCategory.equals(targetCategory.toLowerCase())) {
                return products[mid];
            } else if (midCategory.compareTo(targetCategory.toLowerCase()) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
